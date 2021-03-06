/*
 *  Java HTML Tidy - JTidy
 *  HTML parser and pretty printer
 *
 *  Copyright (c) 1998-2000 World Wide Web Consortium (Massachusetts
 *  Institute of Technology, Institut National de Recherche en
 *  Informatique et en Automatique, Keio University). All Rights
 *  Reserved.
 *
 *  Contributing Author(s):
 *
 *     Dave Raggett <dsr@w3.org>
 *     Andy Quick <ac.quick@sympatico.ca> (translation to Java)
 *     Gary L Peskin <garyp@firstech.com> (Java development)
 *     Sami Lempinen <sami@lempinen.net> (release management)
 *     Fabrizio Giustina <fgiust at users.sourceforge.net>
 *
 *  The contributing author(s) would like to thank all those who
 *  helped with testing, bug fixes, and patience.  This wouldn't
 *  have been possible without all of you.
 *
 *  COPYRIGHT NOTICE:
 *
 *  This software and documentation is provided "as is," and
 *  the copyright holders and contributing author(s) make no
 *  representations or warranties, express or implied, including
 *  but not limited to, warranties of merchantability or fitness
 *  for any particular purpose or that the use of the software or
 *  documentation will not infringe any third party patents,
 *  copyrights, trademarks or other rights.
 *
 *  The copyright holders and contributing author(s) will not be
 *  liable for any direct, indirect, special or consequential damages
 *  arising out of any use of the software or documentation, even if
 *  advised of the possibility of such damage.
 *
 *  Permission is hereby granted to use, copy, modify, and distribute
 *  this source code, or portions hereof, documentation and executables,
 *  for any purpose, without fee, subject to the following restrictions:
 *
 *  1. The origin of this source code must not be misrepresented.
 *  2. Altered versions must be plainly marked as such and must
 *     not be misrepresented as being the original source.
 *  3. This Copyright notice may not be removed or altered from any
 *     source or altered source distribution.
 *
 *  The copyright holders and contributing author(s) specifically
 *  permit, without fee, and encourage the use of this source code
 *  as a component for supporting the Hypertext Markup Language in
 *  commercial products. If you use this source code in a product,
 *  acknowledgment is not required but would be appreciated.
 *
 */
package org.w3c.tidy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.w3c.tidy.Node.NodeType;
import org.w3c.tidy.Options.AttrSortStrategy;
import org.w3c.tidy.Options.DoctypeModes;
import org.w3c.tidy.Options.DupAttrModes;
import org.w3c.tidy.Options.TriState;

/**
 * HTML parser and pretty printer.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public class Tidy implements Serializable
{

    /**
     * Serial Version UID to avoid problems during serialization.
     */
    static final long serialVersionUID = -2794371560623987718L;

    /**
     * Alias for configuration options accepted in command line.
     */
    private static final Map<String, String> CMDLINE_ALIAS = new HashMap<String, String>();

    static
    {
        CMDLINE_ALIAS.put("xml", "input-xml");
        CMDLINE_ALIAS.put("asxml", "output-xhtml");
        CMDLINE_ALIAS.put("asxhtml", "output-xhtml");
        CMDLINE_ALIAS.put("ashtml", "output-html");
        CMDLINE_ALIAS.put("omit", "hide-endtags");
        CMDLINE_ALIAS.put("upper", "uppercase-tags");
        CMDLINE_ALIAS.put("raw", "output-raw");
        CMDLINE_ALIAS.put("numeric", "numeric-entities");
        CMDLINE_ALIAS.put("change", "write-back");
        CMDLINE_ALIAS.put("update", "write-back");
        CMDLINE_ALIAS.put("modify", "write-back");
        CMDLINE_ALIAS.put("errors", "only-errors");
        CMDLINE_ALIAS.put("slides", "split");
        CMDLINE_ALIAS.put("lang", "language");
        CMDLINE_ALIAS.put("w", "wrap");
        CMDLINE_ALIAS.put("file", "error-file");
        CMDLINE_ALIAS.put("f", "error-file");
    }

    /**
     * Error output stream.
     */
    private PrintWriter errout;

    private final PrintWriter stderr;

    private final Configuration configuration;

    private String inputStreamName = "InputStream";

    private int parseErrors;

    private int parseWarnings;

    private final Report report;
    
    private Lexer lexer;

    /**
     * Instantiates a new Tidy instance. It's reccomended that a new instance is used at each parsing.
     */
    public Tidy()
    {
        this.report = new Report();
        configuration = new Configuration(this.report);

        final TagTable tt = new TagTable();
        tt.setConfiguration(configuration);
        configuration.tt = tt;

        configuration.setErrfile(null);
        stderr = new PrintWriter(System.err, true);
        errout = stderr;
    }

    /**
     * Returns the actual configuration
     * @return tidy configuration
     */
    public Configuration getConfiguration()
    {
        return configuration;
    }

    public PrintWriter getStderr()
    {
        return stderr;
    }

    /**
     * ParseErrors - the number of errors that occurred in the most recent parse operation.
     * @return number of errors that occurred in the most recent parse operation.
     */
    public int getParseErrors()
    {
        return parseErrors;
    }

    /**
     * ParseWarnings - the number of warnings that occurred in the most recent parse operation.
     * @return number of warnings that occurred in the most recent parse operation.
     */
    public int getParseWarnings()
    {
        return parseWarnings;
    }

    /**
     * InputStreamName - the name of the input stream (printed in the header information).
     * @param name input stream name
     */
    public void setInputStreamName(final String name)
    {
        if (name != null)
        {
            inputStreamName = name;
        }
    }

    public String getInputStreamName()
    {
        return inputStreamName;
    }

    /**
     * Errout - the error output stream.
     * @return error output stream.
     */
    public PrintWriter getErrout()
    {
        return errout;
    }

    public void setErrout(final PrintWriter out)
    {
        this.errout = out;
    }

    /**
     * Sets the configuration from a configuration file.
     * @param filename configuration file name/path.
     */
    public void setConfigurationFromFile(final String filename)
    {
        configuration.parseFile(filename);
    }

    /**
     * Sets the configuration from a properties object.
     * @param props Properties object
     */
    public void setConfigurationFromProps(final Properties props)
    {
        configuration.addProps(props);
    }

    /**
     * Creates an empty DOM Document.
     * @return a new org.w3c.dom.Document
     */
    public static org.w3c.dom.Document createEmptyDocument()
    {
        final Node document = new Node(NodeType.RootNode, new byte[0], 0, 0);
        final Node node = new Node(NodeType.StartTag, new byte[0], 0, 0, "html", new TagTable());
        if (document != null && node != null)
        {
            document.insertNodeAtStart(node);
            return (org.w3c.dom.Document) document.getAdapter();
        }

        return null;
    }

    /**
     * Reads from the given input and returns the root Node. If out is non-null, pretty prints to out. Warning: caller
     * is responsible for calling close() on input and output after calling this method.
     * @param in input
     * @param out optional destination for pretty-printed document
     * @return parsed org.w3c.tidy.Node
     */
    public Node parse(final InputStream in, final OutputStream out)
    {

        final StreamIn streamIn = StreamInFactory.getStreamIn(configuration, in);

        Out o = null;
        if (out != null)
        {
            o = OutFactory.getOut(this.configuration, out); // normal output stream
        }

        return parse(streamIn, o);
    }

    /**
     * Reads from the given input and returns the root Node. If out is non-null, pretty prints to out. Warning: caller
     * is responsible for calling close() on input and output after calling this method.
     * @param in input
     * @param out optional destination for pretty-printed document
     * @return parsed org.w3c.tidy.Node
     */
    public Node parse(final Reader in, final OutputStream out)
    {

        final StreamIn streamIn = StreamInFactory.getStreamIn(configuration, in);

        Out o = null;
        if (out != null)
        {
            o = OutFactory.getOut(this.configuration, out); // normal output stream
        }

        return parse(streamIn, o);
    }

    /**
     * Reads from the given input and returns the root Node. If out is non-null, pretty prints to out. Warning: caller
     * is responsible for calling close() on input and output after calling this method.
     * @param in input
     * @param out optional destination for pretty-printed document
     * @return parsed org.w3c.tidy.Node
     */
    public Node parse(final Reader in, final Writer out)
    {
        final StreamIn streamIn = StreamInFactory.getStreamIn(configuration, in);

        Out o = null;
        if (out != null)
        {
            o = OutFactory.getOut(this.configuration, out); // normal output stream
        }

        return parse(streamIn, o);
    }

    /**
     * Reads from the given input and returns the root Node. If out is non-null, pretty prints to out. Warning: caller
     * is responsible for calling close() on input and output after calling this method.
     * @param in input
     * @param out optional destination for pretty-printed document
     * @return parsed org.w3c.tidy.Node
     */
    public Node parse(final InputStream in, final Writer out)
    {
        final StreamIn streamIn = StreamInFactory.getStreamIn(configuration, in);

        Out o = null;
        if (out != null)
        {
            o = OutFactory.getOut(this.configuration, out); // normal output stream
        }

        return parse(streamIn, o);
    }

    /**
     * Parses InputStream in and returns a DOM Document node. If out is non-null, pretty prints to OutputStream out.
     * @param in input stream
     * @param out optional output stream
     * @return parsed org.w3c.dom.Document
     */
    public org.w3c.dom.Document parseDOM(final InputStream in, final OutputStream out)
    {
        final Node document = parse(in, out);
        if (document != null)
        {
            return (org.w3c.dom.Document) document.getAdapter();
        }
        return null;
    }

    public org.w3c.dom.Document parseDOM(final Reader in, final Writer out) {
        final Node document = parse(in, out);
        if (document != null) {
            return (org.w3c.dom.Document) document.getAdapter();
        }
        return null;
    }

    /**
     * Pretty-prints a DOM Document. Must be an instance of org.w3c.tidy.DOMDocumentImpl. Caller is responsible for
     * closing the outputStream after calling this method.
     * @param doc org.w3c.dom.Document
     * @param out output stream
     */
    public void pprint(final org.w3c.dom.Document doc, final OutputStream out)
    {
        if (!(doc instanceof DOMDocumentImpl))
        {
            // @todo should we inform users that tidy can't print a generic Document or change the method signature?
            return;
        }

        pprint(((DOMDocumentImpl) doc).adaptee, out);
    }

    /**
     * Pretty-prints a DOM Node. Caller is responsible for closing the outputStream after calling this method.
     * @param node org.w3c.dom.Node. Must be an instance of org.w3c.tidy.DOMNodeImpl.
     * @param out output stream
     */
    public void pprint(final org.w3c.dom.Node node, final OutputStream out)
    {
        if (!(node instanceof DOMNodeImpl))
        {
            // @todo should we inform users than tidy can't print a generic Node or change the method signature?
            return;
        }

        pprint(((DOMNodeImpl) node).adaptee, out);
    }
    
    private static boolean showBodyOnly(final Lexer lexer) {
        switch (lexer.configuration.getBodyOnly()) {
        case No:
            return false;
        case Yes:
            return true;
        default:
            final Node node = lexer.root.findBody();
            if (node != null && node.implicit) {
                return true;
            }
        }
        return false;
    }

    /**
     * Internal routine that actually does the parsing.
     * @param streamIn tidy StreamIn
     * @param o tidy Out
     * @return parsed org.w3c.tidy.Node
     */
    private Node parse(final StreamIn streamIn, final Out o)
    {
        Node document = null;
        Node doctype;
        PPrint pprint;

        if (errout == null)
        {
            return null;
        }

        // ensure config is self-consistent
        configuration.adjust();

        parseErrors = 0;
        parseWarnings = 0;

        lexer = new Lexer(streamIn, configuration, this.report);
        lexer.errout = errout;

        // store pointer to lexer in input stream to allow character encoding errors to be reported
        streamIn.setLexer(lexer);

        this.report.setFilename(inputStreamName); // #431895 - fix by Dave Bryan 04 Jan 01

        // Tidy doesn't alter the doctype for generic XML docs
        if (configuration.isXmlTags())
        {
            document = ParserImpl.parseXMLDocument(lexer);
            if (!document.checkNodeIntegrity())
            {
                if (!configuration.isQuiet()) {
                    report.badTree(errout);
                    errout.flush();
                }
                return null;
            }
        }
        else
        {
            lexer.warnings = 0;

            document = ParserImpl.parseDocument(lexer);

            if (!document.checkNodeIntegrity())
            {
                if (!configuration.isQuiet()) {
                    report.badTree(errout);
                    errout.flush();
                }
                return null;
            }
            
            // tidyCleanAndRepair

            final Clean cleaner = new Clean(configuration.tt);

            // simplifies <b><b> ... </b> ... </b> etc.
            cleaner.nestedEmphasis(document);

            // cleans up <dir> indented text </dir> etc.
            cleaner.list2BQ(document);
            cleaner.bQ2Div(document);

            // replaces i by em and b by strong
            if (configuration.isLogicalEmphasis())
            {
                cleaner.emFromI(document);
            }

            if (configuration.isWord2000() && cleaner.isWord2000(document))
            {
                // prune Word2000's <![if ...]> ... <![endif]>
                cleaner.dropSections(lexer, document);

                // drop style & class attributes and empty p, span elements
                cleaner.cleanWord2000(lexer, document);
            }

            // replaces presentational markup by style rules
            if (configuration.isMakeClean() || configuration.isDropFontTags())
            {
                cleaner.cleanDocument(lexer, document);
            }
            
            /*  Reconcile http-equiv meta element with output encoding  */
            if (!"raw".equals(configuration.getOutCharEncodingName())) {
            	Clean.verifyHTTPEquiv(lexer, document.findHEAD());
            }

            if (!document.checkNodeIntegrity())
            {
                this.report.badTree(errout);
                errout.flush();
                return null;
            }

            doctype = document.findDocType();

            // remember given doctype
            if (doctype != null) {
            	final AttVal fpi = doctype.getAttrByName("PUBLIC");
            	if (fpi.hasValue()) {
            		lexer.givenDoctype = fpi.value;
            	}
            }
            
            final boolean wantNameAttr = configuration.isAnchorAsName();

            if (document.content != null)
            {
                if (configuration.isXHTML() && !configuration.isHtmlOut()) {
                    lexer.setXHTMLDocType(document);
                    cleaner.fixAnchors(lexer, lexer.root, wantNameAttr, true);
                    Clean.fixXhtmlNamespace(lexer.root, true);
                    Clean.fixLanguageInformation(lexer, lexer.root, true, true);
                } else {
                    lexer.fixDocType(document);
                    cleaner.fixAnchors(lexer, lexer.root, wantNameAttr, true);
                    Clean.fixXhtmlNamespace(lexer.root, false);
                    Clean.fixLanguageInformation(lexer, lexer.root, false, true);
                }

                if (configuration.isTidyMark())
                {
                    lexer.addGenerator(document);
                }
            }

            // ensure presence of initial <?XML version="1.0"?>
            if (configuration.isXmlOut() && configuration.isXmlDecl())
            {
                lexer.fixXmlDecl(document);
            }
            
            // tidyRunDiagnostics

            if (!configuration.isQuiet() && document.content != null)
            {
                this.report.reportVersion(lexer);
            }
        }

        parseWarnings = lexer.warnings;
        parseErrors = lexer.errors;
        if (!configuration.isQuiet()) {
            this.report.reportNumWarnings(errout, lexer);
        }

        if (!configuration.isQuiet() && lexer.errors > 0 && !configuration.isForceOutput())
        {
            this.report.needsAuthorIntervention(errout);
        }

        if (configuration.isShowMarkup() && (lexer.errors == 0 || configuration.isForceOutput()) && o != null) {
        	
        	// tidySaveStream
        	
        	if (configuration.isMakeClean()) {
        		Clean.wbrToSpace(lexer, lexer.root);
        	}
        	
        	final AttrSortStrategy sortAttrStrat = configuration.getSortAttributes();
			if (sortAttrStrat != AttrSortStrategy.None) {
                sortAttributes(lexer.root, sortAttrStrat);
        	}
			
            pprint = new PPrint(configuration);

            if (showBodyOnly(lexer)) {
                // Feature request #434940 - fix by Dave Raggett/Ignacio Vazquez-Abrams 21 Jun 01
                pprint.printBody(o, lexer, document, configuration.isXmlOut());
            }
            else if (configuration.isXmlOut() && !configuration.isXHTML())
            {
                pprint.printXMLTree(o, (short) 0, 0, lexer, document);
            }
            else
            {
                pprint.printTree(o, (short) 0, 0, lexer, document);
            }

            pprint.flushLine(o, 0);
            o.flush();
        }

        // Tidy only shows the error summary when there are errors and/or warnings,
        // but that can miss e.g. badlayout messages
        if ((!configuration.isTidyCompat() || parseErrors + parseWarnings > 0) && !configuration.isQuiet()) {
            this.report.errorSummary(lexer);
        }
        
        if (errout != null) {
        	errout.flush();
        }

        return document;
    }
    
    private AttVal sortAttVal(final AttVal list, final AttrSortStrategy strat) {
    	// quick hack for now
    	final List<AttVal> l = new ArrayList<AttVal>();
    	AttVal x = list;
    	while (x != null) {
    		l.add(x);
    		x = x.next;
    	}
    	if (strat != AttrSortStrategy.Alpha) {
    		throw new IllegalArgumentException("Unexpected sort strategy: " + strat);
    	}
    	if (l.size() < 2) {
    		return list;
    	}
    	Collections.sort(l, new Comparator<AttVal>() {
			public int compare(final AttVal a1, final AttVal a2) {
				return a1.attribute.compareTo(a2.attribute);
			}
		});
    	final int n = l.size();
    	l.add(null);
    	for (int i = 0; i < n; ++i) {
			l.get(i).next = l.get(i + 1);
		}
		return l.get(0);
	}
    
    private void sortAttributes(final Node node, final AttrSortStrategy strat) {
    	Node x = node;
    	while (x != null) {
	        x.attributes = sortAttVal(x.attributes, strat);
	        if (x.content != null) {
	            sortAttributes(x.content, strat);
	        }
	        x = x.next;
    	}
    }

	/**
     * Internal routine that actually does the parsing. The caller can pass either an InputStream or file name. If both
     * are passed, the file name is preferred.
     * @param in input stream (used only if <code>file</code> is null)
     * @param file file name
     * @param out output stream
     * @return parsed org.w3c.tidy.Node
     * @throws FileNotFoundException if <code>file</code> is not null but it can't be found
     * @throws IOException for errors in reading input stream or file
     */
    private Node parse(InputStream in, final String file, OutputStream out) throws FileNotFoundException, IOException
    {

        StreamIn streamIn;
        Out o = null;
        boolean inputStreamOpen = false;
        boolean outputStreamOpen = false;

        if (file != null)
        {
            in = new FileInputStream(file);
            inputStreamOpen = true;
            inputStreamName = file;
        }
        else if (in == null)
        {
            in = System.in;
            inputStreamName = "stdin";
        }

        streamIn = StreamInFactory.getStreamIn(configuration, in);

        if (configuration.isWriteback() && file != null)
        {
            out = new FileOutputStream(file);
            outputStreamOpen = true;
        }

        if (out != null)
        {
            o = OutFactory.getOut(this.configuration, out); // normal output stream
        }

        final Node node = parse(streamIn, o);

        // Try to close the InputStream but only if if we created it.
        if (inputStreamOpen)
        {
            try
            {
                in.close();
            }
            catch (final IOException e)
            {
                // ignore
            }
        }

        // Try to close the OutputStream but only if if we created it.
        if (outputStreamOpen)
        {
            try
            {
                out.close();
            }
            catch (final IOException e)
            {
                // ignore
            }
        }

        return node;

    }

    /**
     * Pretty-prints a tidy Node.
     * @param node org.w3c.tidy.Node
     * @param out output stream
     */
    private void pprint(final Node node, final OutputStream out)
    {
        PPrint pprint;

        if (out != null)
        {

            final Out o = OutFactory.getOut(this.configuration, out);

            pprint = new PPrint(configuration);

            if (configuration.isXmlTags())
            {
                pprint.printXMLTree(o, (short) 0, 0, lexer, node);
            }
            else
            {
                pprint.printTree(o, (short) 0, 0, lexer, node);
            }

            pprint.flushLine(o, 0);

            o.flush();
        }
    }

    /**
     * Command line interface to parser and pretty printer.
     * @param argv command line parameters
     */
    public static void main(final String[] argv)
    {
        final Tidy tidy = new Tidy();
        final int returnCode = tidy.mainExec(argv);
        System.exit(returnCode);
    }

    /**
     * Main method, but returns the return code as an int instead of calling System.exit(code). Needed for testing main
     * method without shutting down tests.
     * @param argv command line parameters
     * @return return code
     */
    protected int mainExec(final String[] argv)
    {
        String file;
        int argCount = argv.length;
        int argIndex = 0;

        // read command line
        final Properties properties = new Properties();

        while (argCount > 0)
        {
            if (argv[argIndex].startsWith("-"))
            {
                // support -foo and --foo
                String argName = argv[argIndex].toLowerCase();
                while (argName.length() > 0 && argName.charAt(0) == '-')
                {
                    argName = argName.substring(1);
                }

                // "exclusive" options
                if (argName.equals("help") || argName.equals("h") || argName.equals("?"))
                {
                    this.report.helpText(new PrintWriter(System.out, true));
                    return 0;
                }
                else if (argName.equals("help-config"))
                {
                    configuration.printConfigOptions(new PrintWriter(System.out, true), false);
                    return 0;
                }
                else if (argName.equals("show-config"))
                {
                    configuration.adjust(); // ensure config is self-consistent
                    configuration.printConfigOptions(errout, true);
                    return 0;
                }
                else if (argName.equals("version") || argName.equals("v"))
                {
                    this.report.showVersion(errout);
                    return 0;
                }

                // optional value for non boolean options
                String argValue = null;
                if (argCount > 2 && !argv[argIndex + 1].startsWith("-"))
                {
                    argValue = argv[argIndex + 1];
                    --argCount;
                    ++argIndex;
                }

                // handle "special" aliases
                final String alias = CMDLINE_ALIAS.get(argName);
                if (alias != null)
                {
                    argName = alias;
                }

                if (Configuration.isKnownOption(argName)) // handle any standard config option
                {
                    properties.setProperty(argName, (argValue == null ? "" : argValue));
                }
                else if (argName.equals("config")) // parse a property file
                {
                    if (argValue != null)
                    {
                        configuration.parseFile(argValue);
                    }
                }
                else if (TidyUtils.isCharEncodingSupported(argName)) // handle any encoding name
                {
                    properties.setProperty("char-encoding", argName);
                }
                else
                {

                    for (int i = 0; i < argName.length(); i++)
                    {
                        switch (argName.charAt(i))
                        {
                            case 'i' :
                                configuration.setIndentContent(TriState.Auto);
                                if (configuration.getSpaces() == 0) {
                                	configuration.reset(Option.IndentSpaces);
                                }
                                break;

                            case 'o' :
                                configuration.setHideEndTags(true);
                                break;

                            case 'u' :
                                configuration.setUpperCaseTags(true);
                                break;

                            case 'c' :
                                configuration.setMakeClean(true);
                                break;

                            case 'b' :
                                configuration.setMakeBare(true);
                                break;

                            case 'n' :
                                configuration.setNumEntities(true);
                                break;

                            case 'm' :
                                configuration.setWriteback(true);
                                break;

                            case 'e' :
                                configuration.setShowMarkup(false);
                                break;

                            case 'q' :
                                configuration.setQuiet(true);
                                break;

                            default :
                                this.report.unknownOption(this.errout, argName.charAt(i));
                                break;
                        }
                    }
                }

                --argCount;
                ++argIndex;
                continue;
            }

            configuration.addProps(properties);

            // ensure config is self-consistent
            configuration.adjust();

            // user specified error file
            if (configuration.getErrfile() != null)
            {

                String errorfile = "stderr";

                // is it same as the currently opened file?
                if (!configuration.getErrfile().equals(errorfile))
                {
                    // no so close previous error file

                    if (this.errout != this.stderr)
                    {
                        this.errout.close();
                    }

                    // and try to open the new error file
                    try
                    {
                        this.setErrout(new PrintWriter(new FileWriter(configuration.getErrfile()), true));
                        errorfile = configuration.getErrfile();
                    }
                    catch (final IOException e)
                    {
                        // can't be opened so fall back to stderr
                        errorfile = "stderr";
                        this.setErrout(stderr);
                    }
                }
            }

            if (argCount > 0)
            {
                file = argv[argIndex];
            }
            else
            {
                file = "stdin";
            }

            try
            {
                parse(null, file, System.out);
            }
            catch (final FileNotFoundException fnfe)
            {
                this.report.unknownFile(this.errout, file);
            }
            catch (final IOException ioe)
            {
                this.report.unknownFile(this.errout, file);
            }

            --argCount;
            ++argIndex;

            if (argCount <= 0)
            {
                break;
            }
        }

        if (this.parseErrors + this.parseWarnings > 0 && !configuration.isQuiet())
        {
            this.report.generalInfo(this.errout);
        }

        if (this.errout != this.stderr)
        {
            this.errout.close();
        }

        // return status can be used by scripts
        if (this.parseErrors > 0)
        {
            return 2;
        }

        if (this.parseWarnings > 0)
        {
            return 1;
        }

        // 0 means all is ok
        return 0;
    }

    /**
     * Attach a TidyMessageListener which will be notified for messages and errors.
     * @param listener TidyMessageListener implementation
     */
    public void setMessageListener(final TidyMessageListener listener)
    {
        this.report.addMessageListener(listener);
    }

    /**
     * <code>indent-spaces</code>- default indentation.
     * @param spaces number of spaces used for indentation
     * @see Configuration#spaces
     */
    public void setSpaces(final int spaces)
    {
        configuration.setSpaces(spaces);
    }

    /**
     * <code>indent-spaces</code>- default indentation.
     * @return number of spaces used for indentation
     * @see Configuration#spaces
     */
    public int getSpaces()
    {
        return configuration.getSpaces();
    }

    /**
     * <code>wrap</code>- default wrap margin.
     * @param wraplen default wrap margin
     * @see Configuration#wraplen
     */
    public void setWraplen(final int wraplen)
    {
        configuration.setWraplen(wraplen);
    }

    /**
     * <code>wrap</code>- default wrap margin.
     * @return default wrap margin
     * @see Configuration#wraplen
     */
    public int getWraplen()
    {
        return configuration.getWraplen();
    }

    /**
     * <code>tab-size</code>- tab size in chars.
     * @param tabsize tab size in chars
     * @see Configuration#tabsize
     */
    public void setTabsize(final int tabsize)
    {
        configuration.setTabsize(tabsize);
    }

    /**
     * <code>tab-size</code>- tab size in chars.
     * @return tab size in chars
     * @see Configuration#tabsize
     */
    public int getTabsize()
    {
        return configuration.getTabsize();
    }

    /**
     * Errfile - file name to write errors to.
     * @param errfile file name to write errors to
     * @see Configuration#errfile
     */
    public void setErrfile(final String errfile)
    {
        configuration.setErrfile(errfile);
    }

    /**
     * Errfile - file name to write errors to.
     * @return error file name
     * @see Configuration#errfile
     */
    public String getErrfile()
    {
        return configuration.getErrfile();
    }

    /**
     * writeback - if true then output tidied markup. NOTE: this property is ignored when parsing from an InputStream.
     * @param writeback <code>true</code>= output tidied markup
     * @see Configuration#writeback
     */
    public void setWriteback(final boolean writeback)
    {
        configuration.setWriteback(writeback);
    }

    /**
     * writeback - if true then output tidied markup. NOTE: this property is ignored when parsing from an InputStream.
     * @return <code>true</code> if tidy will output tidied markup in input file
     * @see Configuration#writeback
     */
    public boolean getWriteback()
    {
        return configuration.isWriteback();
    }

    public void setShowMarkup(final boolean showMarkup)
    {
        configuration.setShowMarkup(showMarkup);
    }

    public boolean isShowMarkup()
    {
        return configuration.isShowMarkup();
    }

    /**
     * show-warnings - show warnings? (errors are always shown).
     * @param showWarnings if <code>false</code> warnings are not shown
     * @see Configuration#showWarnings
     */
    public void setShowWarnings(final boolean showWarnings)
    {
        configuration.setShowWarnings(showWarnings);
    }

    /**
     * show-warnings - show warnings? (errors are always shown).
     * @return <code>false</code> if warnings are not shown
     * @see Configuration#showWarnings
     */
    public boolean getShowWarnings()
    {
        return configuration.isShowWarnings();
    }

    /**
     * quiet - no 'Parsing X', guessed DTD or summary.
     * @param quiet <code>true</code>= don't output summary, warnings or errors
     * @see Configuration#quiet
     */
    public void setQuiet(final boolean quiet)
    {
        configuration.setQuiet(quiet);
    }

    /**
     * quiet - no 'Parsing X', guessed DTD or summary.
     * @return <code>true</code> if tidy will not output summary, warnings or errors
     * @see Configuration#quiet
     */
    public boolean getQuiet()
    {
        return configuration.isQuiet();
    }
    
    /**
     * @deprecated Use the TriState version.
     */
    @Deprecated
    public void setIndentContent(final boolean indentContent) {
    	setIndentContent(TriState.fromBoolean(indentContent));
    }

    /**
     * indent - indent content of appropriate tags.
     * @param indentContent indent content of appropriate tags
     * @see Configuration#indentContent
     */
    public void setIndentContent(final TriState indentContent) {
        configuration.setIndentContent(indentContent);
    }

    /**
     * indent - indent content of appropriate tags.
     * @return <code>true</code> if tidy will indent content of appropriate tags
     * @see Configuration#indentContent
     */
    public TriState getIndentContent() {
        return configuration.getIndentContent();
    }

    /**
     * hide-endtags - suppress optional end tags.
     * @param hideEndTags <code>true</code>= suppress optional end tags
     * @see Configuration#hideEndTags
     */
    public void setHideEndTags(final boolean hideEndTags)
    {
        configuration.setHideEndTags(hideEndTags);
    }

    /**
     * hide-endtags - suppress optional end tags.
     * @return <code>true</code> if tidy will suppress optional end tags
     * @see Configuration#hideEndTags
     */
    public boolean getHideEndTags()
    {
        return configuration.isHideEndTags();
    }

    /**
     * input-xml - treat input as XML.
     * @param xmlTags <code>true</code> if tidy should treat input as XML
     * @see Configuration#xmlTags
     */
    public void setXmlTags(final boolean xmlTags)
    {
        configuration.setXmlTags(xmlTags);
    }

    /**
     * input-xml - treat input as XML.
     * @return <code>true</code> if tidy will treat input as XML
     * @see Configuration#xmlTags
     */
    public boolean getXmlTags()
    {
        return configuration.isXmlTags();
    }

    /**
     * output-xml - create output as XML.
     * @param xmlOut <code>true</code> if tidy should create output as xml
     * @see Configuration#xmlOut
     */
    public void setXmlOut(final boolean xmlOut)
    {
        configuration.setXmlOut(xmlOut);
    }

    /**
     * output-xml - create output as XML.
     * @return <code>true</code> if tidy will create output as xml
     * @see Configuration#xmlOut
     */
    public boolean getXmlOut()
    {
        return configuration.isXmlOut();
    }

    /**
     * output-xhtml - output extensible HTML.
     * @param xhtml <code>true</code> if tidy should output XHTML
     * @see Configuration#xHTML
     */
    public void setXHTML(final boolean xhtml)
    {
        configuration.setXHTML(xhtml);
    }

    /**
     * output-xhtml - output extensible HTML.
     * @return <code>true</code> if tidy will output XHTML
     * @see Configuration#xHTML
     */
    public boolean getXHTML()
    {
        return configuration.isXHTML();
    }

    /**
     * uppercase-tags - output tags in upper case.
     * @param upperCaseTags <code>true</code> if tidy should output tags in upper case (default is lowercase)
     * @see Configuration#upperCaseTags
     */
    public void setUpperCaseTags(final boolean upperCaseTags)
    {
        configuration.setUpperCaseTags(upperCaseTags);
    }

    /**
     * uppercase-tags - output tags in upper case.
     * @return <code>true</code> if tidy should will tags in upper case
     * @see Configuration#upperCaseTags
     */
    public boolean getUpperCaseTags()
    {
        return configuration.isUpperCaseTags();
    }

    /**
     * uppercase-attributes - output attributes in upper case.
     * @param upperCaseAttrs <code>true</code> if tidy should output attributes in upper case (default is lowercase)
     * @see Configuration#upperCaseAttrs
     */
    public void setUpperCaseAttrs(final boolean upperCaseAttrs)
    {
        configuration.setUpperCaseAttrs(upperCaseAttrs);
    }

    /**
     * uppercase-attributes - output attributes in upper case.
     * @return <code>true</code> if tidy should will attributes in upper case
     * @see Configuration#upperCaseAttrs
     */
    public boolean getUpperCaseAttrs()
    {
        return configuration.isUpperCaseAttrs();
    }

    /**
     * make-clean - remove presentational clutter.
     * @param makeClean true to remove presentational clutter
     * @see Configuration#makeClean
     */
    public void setMakeClean(final boolean makeClean)
    {
        configuration.setMakeClean(makeClean);
    }

    /**
     * make-clean - remove presentational clutter.
     * @return true if tidy will remove presentational clutter
     * @see Configuration#makeClean
     */
    public boolean getMakeClean()
    {
        return configuration.isMakeClean();
    }

    /**
     * make-bare - remove Microsoft cruft.
     * @param makeBare true to remove Microsoft cruft
     * @see Configuration#makeBare
     */
    public void setMakeBare(final boolean makeBare)
    {
        configuration.setMakeBare(makeBare);
    }

    /**
     * make-clean - remove Microsoft cruft.
     * @return true if tidy will remove Microsoft cruft
     * @see Configuration#makeBare
     */
    public boolean getMakeBare()
    {
        return configuration.isMakeBare();
    }

    /**
     * break-before-br - output newline before &lt;br&gt;.
     * @param breakBeforeBR <code>true</code> if tidy should output a newline before &lt;br&gt;
     * @see Configuration#breakBeforeBR
     */
    public void setBreakBeforeBR(final boolean breakBeforeBR)
    {
        configuration.setBreakBeforeBR(breakBeforeBR);
    }

    /**
     * break-before-br - output newline before &lt;br&gt;.
     * @return <code>true</code> if tidy will output a newline before &lt;br&gt;
     * @see Configuration#breakBeforeBR
     */
    public boolean getBreakBeforeBR()
    {
        return configuration.isBreakBeforeBR();
    }

    /**
     * <code>numeric-entities</code>- output entities other than the built-in HTML entities in the numeric rather
     * than the named entity form.
     * @param numEntities <code>true</code> if tidy should output entities in the numeric form.
     * @see Configuration#numEntities
     */
    public void setNumEntities(final boolean numEntities)
    {
        configuration.setNumEntities(numEntities);
    }

    /**
     * <code>numeric-entities</code>- output entities other than the built-in HTML entities in the numeric rather
     * than the named entity form.
     * @return <code>true</code> if tidy will output entities in the numeric form.
     * @see Configuration#numEntities
     */
    public boolean getNumEntities()
    {
        return configuration.isNumEntities();
    }

    /**
     * <code>quote-marks</code>- output " marks as &amp;quot;.
     * @param quoteMarks <code>true</code> if tidy should output " marks as &amp;quot;
     * @see Configuration#quoteMarks
     */
    public void setQuoteMarks(final boolean quoteMarks)
    {
        configuration.setQuoteMarks(quoteMarks);
    }

    /**
     * <code>quote-marks</code>- output " marks as &amp;quot;.
     * @return <code>true</code> if tidy will output " marks as &amp;quot;
     * @see Configuration#quoteMarks
     */
    public boolean getQuoteMarks()
    {
        return configuration.isQuoteMarks();
    }

    /**
     * <code>quote-nbsp</code>- output non-breaking space as entity.
     * @param quoteNbsp <code>true</code> if tidy should output non-breaking space as entity
     * @see Configuration#quoteNbsp
     */
    public void setQuoteNbsp(final boolean quoteNbsp)
    {
        configuration.setQuoteNbsp(quoteNbsp);
    }

    /**
     * <code>quote-nbsp</code>- output non-breaking space as entity.
     * @return <code>true</code> if tidy will output non-breaking space as entity
     * @see Configuration#quoteNbsp
     */
    public boolean getQuoteNbsp()
    {
        return configuration.isQuoteNbsp();
    }

    /**
     * <code>quote-ampersand</code>- output naked ampersand as &amp;.
     * @param quoteAmpersand <code>true</code> if tidy should output naked ampersand as &amp;
     * @see Configuration#quoteAmpersand
     */
    public void setQuoteAmpersand(final boolean quoteAmpersand)
    {
        configuration.setQuoteAmpersand(quoteAmpersand);
    }

    /**
     * <code>quote-ampersand</code>- output naked ampersand as &amp;.
     * @return <code>true</code> if tidy will output naked ampersand as &amp;
     * @see Configuration#quoteAmpersand
     */
    public boolean getQuoteAmpersand()
    {
        return configuration.isQuoteAmpersand();
    }

    /**
     * <code>wrap-attributes</code>- wrap within attribute values.
     * @param wrapAttVals <code>true</code> if tidy should wrap within attribute values
     * @see Configuration#wrapAttVals
     */
    public void setWrapAttVals(final boolean wrapAttVals)
    {
        configuration.setWrapAttVals(wrapAttVals);
    }

    /**
     * <code>wrap-attributes</code>- wrap within attribute values.
     * @return <code>true</code> if tidy will wrap within attribute values
     * @see Configuration#wrapAttVals
     */
    public boolean getWrapAttVals()
    {
        return configuration.isWrapAttVals();
    }

    /**
     * <code>wrap-script-literals</code>- wrap within JavaScript string literals.
     * @param wrapScriptlets <code>true</code> if tidy should wrap within JavaScript string literals
     * @see Configuration#wrapScriptlets
     */
    public void setWrapScriptlets(final boolean wrapScriptlets)
    {
        configuration.setWrapScriptlets(wrapScriptlets);
    }

    /**
     * <code>wrap-script-literals</code>- wrap within JavaScript string literals.
     * @return <code>true</code> if tidy will wrap within JavaScript string literals
     * @see Configuration#wrapScriptlets
     */
    public boolean getWrapScriptlets()
    {
        return configuration.isWrapScriptlets();
    }

    /**
     * <code>wrap-sections</code>- wrap within &lt;![ ... ]&gt; section tags
     * @param wrapSection <code>true</code> if tidy should wrap within &lt;![ ... ]&gt; section tags
     * @see Configuration#wrapSection
     */
    public void setWrapSection(final boolean wrapSection)
    {
        configuration.setWrapSection(wrapSection);
    }

    /**
     * <code>wrap-sections</code>- wrap within &lt;![ ... ]&gt; section tags
     * @return <code>true</code> if tidy will wrap within &lt;![ ... ]&gt; section tags
     * @see Configuration#wrapSection
     */
    public boolean getWrapSection()
    {
        return configuration.isWrapSection();
    }

    /**
     * <code>alt-text</code>- default text for alt attribute.
     * @param altText default text for alt attribute
     * @see Configuration#altText
     */
    public void setAltText(final String altText)
    {
        configuration.setAltText(altText);
    }

    /**
     * <code>alt-text</code>- default text for alt attribute.
     * @return default text for alt attribute
     * @see Configuration#altText
     */
    public String getAltText()
    {
        return configuration.getAltText();
    }

    /**
     * <code>add-xml-pi</code>- add &lt;?xml?&gt; for XML docs.
     * @param xmlDecl <code>true</code> if tidy should add &lt;?xml?&gt; for XML docs
     * @see Configuration#xmlPi
     */
    public void setXmlDecl(final boolean xmlDecl)
    {
        configuration.setXmlDecl(xmlDecl);
    }

    /**
     * <code>add-xml-pi</code>- add &lt;?xml?&gt; for XML docs.
     * @return <code>true</code> if tidy will add &lt;?xml?&gt; for XML docs
     * @see Configuration#xmlPi
     */
    public boolean getXmlDecl()
    {
        return configuration.isXmlDecl();
    }

    /**
     * <code>drop-font-tags</code>- discard presentation tags.
     * @param dropFontTags <code>true</code> if tidy should discard presentation tags
     * @see Configuration#dropFontTags
     */
    public void setDropFontTags(final boolean dropFontTags)
    {
        configuration.setDropFontTags(dropFontTags);
    }

    /**
     * <code>drop-font-tags</code>- discard presentation tags.
     * @return <code>true</code> if tidy will discard presentation tags
     * @see Configuration#dropFontTags
     */
    public boolean getDropFontTags()
    {
        return configuration.isDropFontTags();
    }

    /**
     * <code>drop-proprietary-attributes</code>- discard proprietary attributes.
     * @param dropProprietaryAttributes <code>true</code> if tidy should discard proprietary attributes
     * @see Configuration#dropProprietaryAttributes
     */
    public void setDropProprietaryAttributes(final boolean dropProprietaryAttributes)
    {
        configuration.setDropProprietaryAttributes(dropProprietaryAttributes);
    }

    /**
     * <code>drop-proprietary-attributes</code>- discard proprietary attributes.
     * @return <code>true</code> if tidy will discard proprietary attributes
     * @see Configuration#dropProprietaryAttributes
     */
    public boolean getDropProprietaryAttributes()
    {
        return configuration.isDropProprietaryAttributes();
    }

    /**
     * <code>drop-empty-paras</code>- discard empty p elements.
     * @param dropEmptyParas <code>true</code> if tidy should discard empty p elements
     * @see Configuration#dropEmptyParas
     */
    public void setDropEmptyParas(final boolean dropEmptyParas)
    {
        configuration.setDropEmptyParas(dropEmptyParas);
    }

    /**
     * <code>drop-empty-paras</code>- discard empty p elements.
     * @return <code>true</code> if tidy will discard empty p elements
     * @see Configuration#dropEmptyParas
     */
    public boolean getDropEmptyParas()
    {
        return configuration.isDropEmptyParas();
    }

    /**
     * <code>fix-bad-comments</code>- fix comments with adjacent hyphens.
     * @param fixComments <code>true</code> if tidy should fix comments with adjacent hyphens
     * @see Configuration#fixComments
     */
    public void setFixComments(final boolean fixComments)
    {
        configuration.setFixComments(fixComments);
    }

    /**
     * <code>fix-bad-comments</code>- fix comments with adjacent hyphens.
     * @return <code>true</code> if tidy will fix comments with adjacent hyphens
     * @see Configuration#fixComments
     */
    public boolean getFixComments()
    {
        return configuration.isFixComments();
    }

    /**
     * <code>wrap-asp</code>- wrap within ASP pseudo elements.
     * @param wrapAsp <code>true</code> if tidy should wrap within ASP pseudo elements
     * @see Configuration#wrapAsp
     */
    public void setWrapAsp(final boolean wrapAsp)
    {
        configuration.setWrapAsp(wrapAsp);
    }

    /**
     * <code>wrap-asp</code>- wrap within ASP pseudo elements.
     * @return <code>true</code> if tidy will wrap within ASP pseudo elements
     * @see Configuration#wrapAsp
     */
    public boolean getWrapAsp()
    {
        return configuration.isWrapAsp();
    }

    /**
     * <code>wrap-jste</code>- wrap within JSTE pseudo elements.
     * @param wrapJste <code>true</code> if tidy should wrap within JSTE pseudo elements
     * @see Configuration#wrapJste
     */
    public void setWrapJste(final boolean wrapJste)
    {
        configuration.setWrapJste(wrapJste);
    }

    /**
     * <code>wrap-jste</code>- wrap within JSTE pseudo elements.
     * @return <code>true</code> if tidy will wrap within JSTE pseudo elements
     * @see Configuration#wrapJste
     */
    public boolean getWrapJste()
    {
        return configuration.isWrapJste();
    }

    /**
     * <code>wrap-php</code>- wrap within PHP pseudo elements.
     * @param wrapPhp <code>true</code> if tidy should wrap within PHP pseudo elements
     * @see Configuration#wrapPhp
     */
    public void setWrapPhp(final boolean wrapPhp)
    {
        configuration.setWrapPhp(wrapPhp);
    }

    /**
     * <code>wrap-php</code>- wrap within PHP pseudo elements.
     * @return <code>true</code> if tidy will wrap within PHP pseudo elements
     * @see Configuration#wrapPhp
     */
    public boolean getWrapPhp()
    {
        return configuration.isWrapPhp();
    }

    /**
     * <code>fix-backslash</code>- fix URLs by replacing \ with /.
     * @param fixBackslash <code>true</code> if tidy should fix URLs by replacing \ with /
     * @see Configuration#fixBackslash
     */
    public void setFixBackslash(final boolean fixBackslash)
    {
        configuration.setFixBackslash(fixBackslash);
    }

    /**
     * <code>fix-backslash</code>- fix URLs by replacing \ with /.
     * @return <code>true</code> if tidy will fix URLs by replacing \ with /
     * @see Configuration#fixBackslash
     */
    public boolean getFixBackslash()
    {
        return configuration.isFixBackslash();
    }

    /**
     * <code>indent-attributes</code>- newline+indent before each attribute.
     * @param indentAttributes <code>true</code> if tidy should output a newline+indent before each attribute
     * @see Configuration#indentAttributes
     */
    public void setIndentAttributes(final boolean indentAttributes)
    {
        configuration.setIndentAttributes(indentAttributes);
    }

    /**
     * <code>indent-attributes</code>- newline+indent before each attribute.
     * @return <code>true</code> if tidy will output a newline+indent before each attribute
     * @see Configuration#indentAttributes
     */
    public boolean getIndentAttributes()
    {
        return configuration.isIndentAttributes();
    }

    /**
     * <code>doctype</code>- user specified doctype.
     * @param doctype <code>omit | auto | strict | loose | <em>fpi</em></code> where the <em>fpi </em> is a string
     * similar to &quot;-//ACME//DTD HTML 3.14159//EN&quot; Note: for <em>fpi </em> include the double-quotes in the
     * string.
     * @see Configuration#docTypeStr
     * @see Configuration#docTypeMode
     */
    public void setDocType(final String doctype)
    {
        if (doctype != null)
        {
            configuration.setDocTypeStr((String) ParsePropertyImpl.DOCTYPE.parse(doctype, Option.Doctype, configuration));
        }
    }

    /**
     * <code>doctype</code>- user specified doctype.
     * @return <code>omit | auto | strict | loose | <em>fpi</em></code> where the <em>fpi </em> is a string similar
     * to &quot;-//ACME//DTD HTML 3.14159//EN&quot; Note: for <em>fpi </em> include the double-quotes in the string.
     * @see Configuration#docTypeStr
     * @see Configuration#docTypeMode
     */
    public String getDocType() {
        String result = null;
        switch (configuration.getDocTypeMode()) {
            case Omit:
                result = "omit";
                break;
            case Auto:
                result = "auto";
                break;
            case Strict:
                result = "strict";
                break;
            case Loose:
                result = "loose";
                break;
            case User:
                result = configuration.getDocTypeStr();
                break;
        }
        return result;
    }
    
    public void setDocTypeMode(final DoctypeModes docTypeMode) {
    	configuration.setDocTypeMode(docTypeMode);
    }
    
    public DoctypeModes getDocTypeMode() {
    	return configuration.getDocTypeMode();
    }

    /**
     * <code>logical-emphasis</code>- replace i by em and b by strong.
     * @param logicalEmphasis <code>true</code> if tidy should replace i by em and b by strong
     * @see Configuration#logicalEmphasis
     */
    public void setLogicalEmphasis(final boolean logicalEmphasis)
    {
        configuration.setLogicalEmphasis(logicalEmphasis);
    }

    /**
     * <code>logical-emphasis</code>- replace i by em and b by strong.
     * @return <code>true</code> if tidy will replace i by em and b by strong
     * @see Configuration#logicalEmphasis
     */
    public boolean getLogicalEmphasis()
    {
        return configuration.isLogicalEmphasis();
    }

    /**
     * <code>assume-xml-procins</code> This option specifies if Tidy should change the parsing of processing
     * instructions to require ?> as the terminator rather than >. This option is automatically set if the input is in
     * XML.
     * @param xmlPIs <code>true</code> if tidy should expect a ?> at the end of processing instructions
     * @see Configuration#xmlPIs
     */
    public void setXmlPIs(final boolean xmlPIs)
    {
        configuration.setXmlPIs(xmlPIs);
    }

    /**
     * <code>assume-xml-procins</code> This option specifies if Tidy should change the parsing of processing
     * instructions to require ?> as the terminator rather than >. This option is automatically set if the input is in
     * XML.
     * @return <code>true</code> if tidy will expect a ?> at the end of processing instructions
     * @see Configuration#xmlPIs
     */
    public boolean getXmlPIs()
    {
        return configuration.isXmlPIs();
    }

    /**
     * <code>enclose-text</code>- if true text at body is wrapped in &lt;p&gt;'s.
     * @param encloseText <code>true</code> if tidy should wrap text at body in &lt;p&gt;'s.
     * @see Configuration#encloseBodyText
     */
    public void setEncloseText(final boolean encloseText)
    {
        configuration.setEncloseBodyText(encloseText);
    }

    /**
     * <code>enclose-text</code>- if true text at body is wrapped in &lt;p&gt;'s.
     * @return <code>true</code> if tidy will wrap text at body in &lt;p&gt;'s.
     * @see Configuration#encloseBodyText
     */
    public boolean getEncloseText()
    {
        return configuration.isEncloseBodyText();
    }

    /**
     * <code>enclose-block-text</code>- if true text in blocks is wrapped in &lt;p&gt;'s.
     * @param encloseBlockText <code>true</code> if tidy should wrap text text in blocks in &lt;p&gt;'s.
     * @see Configuration#encloseBlockText
     */
    public void setEncloseBlockText(final boolean encloseBlockText)
    {
        configuration.setEncloseBlockText(encloseBlockText);
    }

    /**
     * <code>enclose-block-text</code>- if true text in blocks is wrapped in &lt;p&gt;'s. return <code>true</code>
     * if tidy should will text text in blocks in &lt;p&gt;'s.
     * @see Configuration#encloseBlockText
     */
    public boolean getEncloseBlockText()
    {
        return configuration.isEncloseBlockText();
    }

    /**
     * <code>word-2000</code>- draconian cleaning for Word2000.
     * @param word2000 <code>true</code> if tidy should clean word2000 documents
     * @see Configuration#word2000
     */
    public void setWord2000(final boolean word2000)
    {
        configuration.setWord2000(word2000);
    }

    /**
     * <code>word-2000</code>- draconian cleaning for Word2000.
     * @return <code>true</code> if tidy will clean word2000 documents
     * @see Configuration#word2000
     */
    public boolean getWord2000()
    {
        return configuration.isWord2000();
    }

    /**
     * <code>tidy-mark</code>- add meta element indicating tidied doc.
     * @param tidyMark <code>true</code> if tidy should add meta element indicating tidied doc
     * @see Configuration#tidyMark
     */
    public void setTidyMark(final boolean tidyMark)
    {
        configuration.setTidyMark(tidyMark);
    }

    /**
     * <code>tidy-mark</code>- add meta element indicating tidied doc.
     * @return <code>true</code> if tidy will add meta element indicating tidied doc
     * @see Configuration#tidyMark
     */
    public boolean getTidyMark()
    {
        return configuration.isTidyMark();
    }

    /**
     * <code>add-xml-space</code>- if set to yes adds xml:space attr as needed.
     * @param xmlSpace <code>true</code> if tidy should add xml:space attr as needed
     * @see Configuration#xmlSpace
     */
    public void setXmlSpace(final boolean xmlSpace)
    {
        configuration.setXmlSpace(xmlSpace);
    }

    /**
     * <code>add-xml-space</code>- if set to yes adds xml:space attr as needed.
     * @return <code>true</code> if tidy will add xml:space attr as needed
     * @see Configuration#xmlSpace
     */
    public boolean getXmlSpace()
    {
        return configuration.isXmlSpace();
    }

    /**
     * <code>gnu-emacs</code>- if true format error output for GNU Emacs.
     * @param emacs <code>true</code> if tidy should format error output for GNU Emacs
     * @see Configuration#emacs
     */
    public void setEmacs(final boolean emacs)
    {
        configuration.setEmacs(emacs);
    }

    /**
     * <code>gnu-emacs</code>- if true format error output for GNU Emacs.
     * @return <code>true</code> if tidy will format error output for GNU Emacs
     * @see Configuration#emacs
     */
    public boolean getEmacs()
    {
        return configuration.isEmacs();
    }

    /**
     * <code>literal-attributes</code>- if true attributes may use newlines.
     * @param literalAttribs <code>true</code> if attributes may use newlines
     * @see Configuration#literalAttribs
     */
    public void setLiteralAttribs(final boolean literalAttribs)
    {
        configuration.setLiteralAttribs(literalAttribs);
    }

    /**
     * <code>literal-attributes</code>- if true attributes may use newlines.
     * @return <code>true</code> if attributes may use newlines
     * @see Configuration#literalAttribs
     */
    public boolean getLiteralAttribs()
    {
        return configuration.isLiteralAttribs();
    }
    
    /**
     * @deprecated Use the TriState version.
     */
    @Deprecated
    public void setPrintBodyOnly(final boolean bodyOnly) {
    	setPrintBodyOnly(TriState.fromBoolean(bodyOnly));
    }

    /**
     * <code>print-body-only</code>- output BODY content only.
     * @param bodyOnly true = print only the document body
     * @see Configuration#bodyOnly
     */
    public void setPrintBodyOnly(final TriState bodyOnly)
    {
        configuration.setBodyOnly(bodyOnly);
    }

    /**
     * <code>print-body-only</code>- output BODY content only.
     * @return true if tidy will print only the document body
     */
    public TriState getPrintBodyOnly()
    {
        return configuration.getBodyOnly();
    }

    /**
     * <code>fix-uri</code>- fix uri references applying URI encoding if necessary.
     * @param fixUri true = fix uri references
     * @see Configuration#fixUri
     */
    public void setFixUri(final boolean fixUri)
    {
        configuration.setFixUri(fixUri);
    }

    /**
     * <code>fix-uri</code>- output BODY content only.
     * @return true if tidy will fix uri references
     */
    public boolean getFixUri()
    {
        return configuration.isFixUri();
    }

    /**
     * <code>lower-literals</code>- folds known attribute values to lower case.
     * @param lowerLiterals true = folds known attribute values to lower case
     * @see Configuration#lowerLiterals
     */
    public void setLowerLiterals(final boolean lowerLiterals)
    {
        configuration.setLowerLiterals(lowerLiterals);
    }

    /**
     * <code>lower-literals</code>- folds known attribute values to lower case.
     * @return true if tidy will folds known attribute values to lower case
     */
    public boolean getLowerLiterals()
    {
        return configuration.isLowerLiterals();
    }

    /**
     * <code>hide-comments</code>- hides all (real) comments in output.
     * @param hideComments true = hides all comments in output
     * @see Configuration#hideComments
     */
    public void setHideComments(final boolean hideComments)
    {
        configuration.setHideComments(hideComments);
    }

    /**
     * <code>hide-comments</code>- hides all (real) comments in output.
     * @return true if tidy will hide all comments in output
     */
    public boolean getHideComments()
    {
        return configuration.isHideComments();
    }

    /**
     * <code>indent-cdata</code>- indent CDATA sections.
     * @param indentCdata true = indent CDATA sections
     * @see Configuration#indentCdata
     */
    public void setIndentCdata(final boolean indentCdata)
    {
        configuration.setIndentCdata(indentCdata);
    }

    /**
     * <code>indent-cdata</code>- indent CDATA sections.
     * @return true if tidy will indent CDATA sections
     */
    public boolean getIndentCdata()
    {
        return configuration.isIndentCdata();
    }

    /**
     * <code>force-output</code>- output document even if errors were found.
     * @param forceOutput true = output document even if errors were found
     * @see Configuration#forceOutput
     */
    public void setForceOutput(final boolean forceOutput)
    {
        configuration.setForceOutput(forceOutput);
    }

    /**
     * <code>force-output</code>- output document even if errors were found.
     * @return true if tidy will output document even if errors were found
     */
    public boolean getForceOutput()
    {
        return configuration.isForceOutput();
    }

    /**
     * <code>show-errors</code>- set the number of errors to put out.
     * @param showErrors number of errors to put out
     * @see Configuration#showErrors
     */
    public void setShowErrors(final int showErrors)
    {
        configuration.setShowErrors(showErrors);
    }

    /**
     * <code>show-errors</code>- number of errors to put out.
     * @return the number of errors tidy will put out
     */
    public int getShowErrors()
    {
        return configuration.getShowErrors();
    }

    /**
     * <code>ascii-chars</code>- convert quotes and dashes to nearest ASCII char.
     * @param asciiChars true = convert quotes and dashes to nearest ASCII char
     * @see Configuration#asciiChars
     */
    public void setAsciiChars(final boolean asciiChars)
    {
        configuration.setAsciiChars(asciiChars);
    }

    /**
     * <code>ascii-chars</code>- convert quotes and dashes to nearest ASCII char.
     * @return true if tidy will convert quotes and dashes to nearest ASCII char
     */
    public boolean getAsciiChars()
    {
        return configuration.isAsciiChars();
    }

    /**
     * <code>join-classes</code>- join multiple class attributes.
     * @param joinClasses true = join multiple class attributes
     * @see Configuration#joinClasses
     */
    public void setJoinClasses(final boolean joinClasses)
    {
        configuration.setJoinClasses(joinClasses);
    }

    /**
     * <code>join-classes</code>- join multiple class attributes.
     * @return true if tidy will join multiple class attributes
     */
    public boolean getJoinClasses()
    {
        return configuration.isJoinClasses();
    }

    /**
     * <code>join-styles</code>- join multiple style attributes.
     * @param joinStyles true = join multiple style attributes
     * @see Configuration#joinStyles
     */
    public void setJoinStyles(final boolean joinStyles)
    {
        configuration.setJoinStyles(joinStyles);
    }

    /**
     * <code>join-styles</code>- join multiple style attributes.
     * @return true if tidy will join multiple style attributes
     */
    public boolean getJoinStyles()
    {
        return configuration.isJoinStyles();
    }

    /**
     * <code>trim-empty-elements</code>- trim empty elements.
     * @param trim-empty-elements true = trim empty elements
     * @see Configuration#trimEmpty
     */
    public void setTrimEmptyElements(final boolean trimEmpty)
    {
        configuration.setTrimEmpty(trimEmpty);
    }

    /**
     * <code>trim-empty-elements</code>- trim empty elements.
     * @return true if tidy will trim empty elements
     */
    public boolean getTrimEmptyElements()
    {
        return configuration.isTrimEmpty();
    }

    /**
     * <code>replace-color</code>- replace hex color attribute values with names.
     * @param replaceColor true = replace hex color attribute values with names
     * @see Configuration#replaceColor
     */
    public void setReplaceColor(final boolean replaceColor)
    {
        configuration.setReplaceColor(replaceColor);
    }

    /**
     * <code>replace-color</code>- replace hex color attribute values with names.
     * @return true if tidy will replace hex color attribute values with names
     */
    public boolean getReplaceColor()
    {
        return configuration.isReplaceColor();
    }

    /**
     * <code>escape-cdata</code>- replace CDATA sections with escaped text.
     * @param escapeCdata true = replace CDATA sections with escaped text
     * @see Configuration#escapeCdata
     */
    public void setEscapeCdata(final boolean escapeCdata)
    {
        configuration.setEscapeCdata(escapeCdata);
    }

    /**
     * <code>escape-cdata</code> -replace CDATA sections with escaped text.
     * @return true if tidy will replace CDATA sections with escaped text
     */
    public boolean getEscapeCdata()
    {
        return configuration.isEscapeCdata();
    }

    /**
     * <code>repeated-attributes</code>- keep first or last duplicate attribute.
     * @param repeatedAttributes <code>Configuration.KEEP_FIRST | Configuration.KEEP_LAST</code>
     * @see Configuration#duplicateAttrs
     */
    public void setRepeatedAttributes(final DupAttrModes repeatedAttributes)
    {
        configuration.setDuplicateAttrs(repeatedAttributes);
    }

    /**
     * <code>repeated-attributes</code>- keep first or last duplicate attribute.
     * @return <code>Configuration.KEEP_FIRST | Configuration.KEEP_LAST</code>
     */
    public DupAttrModes getRepeatedAttributes()
    {
        return configuration.getDuplicateAttrs();
    }

    /**
     * <code>keep-time</code>- if true last modified time is preserved.
     * @param keepFileTimes <code>true</code> if tidy should preserved last modified time in input file.
     * @todo <strong>this is NOT supported at this time. </strong>
     * @see Configuration#keepFileTimes
     */
    public void setKeepFileTimes(final boolean keepFileTimes)
    {
        configuration.setKeepFileTimes(keepFileTimes);
    }

    /**
     * <code>keep-time</code>- if true last modified time is preserved.
     * @return <code>true</code> if tidy will preserved last modified time in input file.
     * @todo <strong>this is NOT supported at this time. </strong>
     * @see Configuration#keepFileTimes
     */
    public boolean getKeepFileTimes()
    {
        return configuration.isKeepFileTimes();
    }

    /**
     * <code>output-raw</code>- avoid mapping values > 127 to entities. This has the same effect of specifying a
     * "raw" encoding in the original version of tidy.
     * @param rawOut avoid mapping values > 127 to entities
     * @see Configuration#rawOut
     */
    public void setRawOut(final boolean rawOut)
    {
        configuration.setRawOut(rawOut);
    }

    /**
     * <code>output-raw</code>- avoid mapping values > 127 to entities.
     * @return <code>true</code> if tidy will not map values > 127 to entities
     * @see Configuration#rawOut
     */
    public boolean getRawOut()
    {
        return configuration.isRawOut();
    }

    /**
     * <code>input-encoding</code> the character encoding used for input.
     * @param encoding a valid java encoding name
     */
    public void setInputEncoding(final String encoding)
    {
        configuration.setInCharEncodingName(encoding);
    }

    /**
     * <code>input-encoding</code> the character encoding used for input.
     * @return the java name of the encoding currently used for input
     */
    public String getInputEncoding()
    {
        return configuration.getInCharEncodingName();
    }

    /**
     * <code>output-encoding</code> the character encoding used for output.
     * @param encoding a valid java encoding name
     */
    public void setOutputEncoding(final String encoding)
    {
        configuration.setOutCharEncodingName(encoding);
    }

    /**
     * <code>output-encoding</code> the character encoding used for output.
     * @return the java name of the encoding currently used for output
     */
    public String getOutputEncoding()
    {
        return configuration.getOutCharEncodingName();
    }
    
    /**
     * @deprecated Use the TriState version.
     */
    @Deprecated
    public void setMergeDivs(final boolean mergeDivs) {
    	setMergeDivs(TriState.fromBoolean(mergeDivs));
    }
    
    public void setMergeDivs(final TriState mergeDivs) {
        configuration.setMergeDivs(mergeDivs);
    }

    public TriState getMergeDivs() {
        return configuration.getMergeDivs();
    }
    
    /**
     * @see Option#TidyCompat
     */
    public void setTidyCompat(final boolean tidyCompat) {
        configuration.setTidyCompat(tidyCompat);
    }

    /**
     * @see Option#TidyCompat
     */
    public boolean isTidyCompat() {
        return configuration.isTidyCompat();
    }
}