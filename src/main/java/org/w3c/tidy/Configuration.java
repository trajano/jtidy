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
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import org.w3c.tidy.Options.DoctypeModes;
import org.w3c.tidy.Options.DupAttrModes;
import org.w3c.tidy.Options.OptionEnum;

/**
 * Read configuration file and manage configuration properties. Configuration files associate a property name with a
 * value. The format is that of a Java .properties file.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public class Configuration implements Serializable
{

    /**
     * character encoding = RAW.
     * @deprecated use <code>Tidy.setRawOut(true)</code> for raw output
     */
    public static final int RAW = 0;

    /**
     * character encoding = ASCII.
     * @deprecated
     */
    public static final int ASCII = 1;

    /**
     * character encoding = LATIN1.
     * @deprecated
     */
    public static final int LATIN1 = 2;

    /**
     * character encoding = UTF8.
     * @deprecated
     */
    public static final int UTF8 = 3;

    /**
     * character encoding = ISO2022.
     * @deprecated
     */
    public static final int ISO2022 = 4;

    /**
     * character encoding = MACROMAN.
     * @deprecated
     */
    public static final int MACROMAN = 5;

    /**
     * character encoding = UTF16LE.
     * @deprecated
     */
    public static final int UTF16LE = 6;

    /**
     * character encoding = UTF16BE.
     * @deprecated
     */
    public static final int UTF16BE = 7;

    /**
     * character encoding = UTF16.
     * @deprecated
     */
    public static final int UTF16 = 8;

    /**
     * character encoding = WIN1252.
     * @deprecated
     */
    public static final int WIN1252 = 9;

    /**
     * character encoding = BIG5.
     * @deprecated
     */
    public static final int BIG5 = 10;

    /**
     * character encoding = SHIFTJIS.
     * @deprecated
     */
    public static final int SHIFTJIS = 11;

    /**
     * Convert from deprecated tidy encoding constant to standard java encoding name.
     */
    private final String[] ENCODING_NAMES = new String[]{"raw", // rawOut, it will not be mapped to a java encoding
        "ASCII",
        "ISO8859_1",
        "UTF8",
        "JIS",
        "MacRoman",
        "UnicodeLittle",
        "UnicodeBig",
        "Unicode",
        "Cp1252",
        "Big5",
        "SJIS"};

    private final Map<Option, Object> options = new EnumMap<Option, Object>(Option.class);

    /**
     * serial version UID for this class.
     */
    private static final long serialVersionUID = -4955155037138560842L;

//    static
//    {
//    	// missing: unknown
//        addConfigOption(new Flag("indent-spaces", "spaces", ParsePropertyImpl.INT));
//        addConfigOption(new Flag("wrap", "wraplen", ParsePropertyImpl.INT));
//        addConfigOption(new Flag("tab-size", "tabsize", ParsePropertyImpl.INT));
//        addConfigOption(new Flag("char-encoding", null, ParsePropertyImpl.CHAR_ENCODING));
//        addConfigOption(new Flag("input-encoding", null, ParsePropertyImpl.CHAR_ENCODING));
//        addConfigOption(new Flag("output-encoding", null, ParsePropertyImpl.CHAR_ENCODING));
//        addConfigOption(new Flag("newline", null, ParsePropertyImpl.NEWLINE));
//        // missing: doctype-mode
//        addConfigOption(new Flag("doctype", "docTypeStr", ParsePropertyImpl.DOCTYPE));
//        addConfigOption(new Flag("repeated-attributes", "duplicateAttrs", ParsePropertyImpl.REPEATED_ATTRIBUTES));
//        addConfigOption(new Flag("alt-text", "altText", ParsePropertyImpl.STRING));
//        
//        // obsolete
//        addConfigOption(new Flag("slide-style", "slidestyle", ParsePropertyImpl.NAME));
//        
//        addConfigOption(new Flag("error-file", "errfile", ParsePropertyImpl.NAME));
//        // missing: output-file
//        addConfigOption(new Flag("write-back", "writeback", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("markup", "onlyErrors", ParsePropertyImpl.INVBOOL));
//        addConfigOption(new Flag("show-warnings", "showWarnings", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("quiet", "quiet", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("indent", "indentContent", ParsePropertyImpl.INDENT));
//        addConfigOption(new Flag("hide-endtags", "hideEndTags", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("input-xml", "xmlTags", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("output-xml", "xmlOut", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("output-xhtml", "xHTML", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("output-html", "htmlOut", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("add-xml-decl", "xmlPi", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("uppercase-tags", "upperCaseTags", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("uppercase-attributes", "upperCaseAttrs", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("bare", "makeBare", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("clean", "makeClean", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("logical-emphasis", "logicalEmphasis", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("drop-proprietary-attributes", "dropProprietaryAttributes", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("drop-font-tags", "dropFontTags", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("drop-empty-paras", "dropEmptyParas", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("fix-bad-comments", "fixComments", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("break-before-br", "breakBeforeBR", ParsePropertyImpl.BOOL));
//        
//        // obsolete
//        addConfigOption(new Flag("split", "burstSlides", ParsePropertyImpl.BOOL));
//        
//        addConfigOption(new Flag("numeric-entities", "numEntities", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("quote-marks", "quoteMarks", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("quote-nbsp", "quoteNbsp", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("quote-ampersand", "quoteAmpersand", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("wrap-attributes", "wrapAttVals", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("wrap-script-literals", "wrapScriptlets", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("wrap-sections", "wrapSection", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("wrap-asp", "wrapAsp", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("wrap-jste", "wrapJste", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("wrap-php", "wrapPhp", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("fix-backslash", "fixBackslash", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("indent-attributes", "indentAttributes", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("assume-xml-procins", "xmlPIs", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("add-xml-space", "xmlSpace", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("enclose-text", "encloseBodyText", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("enclose-block-text", "encloseBlockText", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("keep-time", "keepFileTimes", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("word-2000", "word2000", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("tidy-mark", "tidyMark", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("gnu-emacs", "emacs", ParsePropertyImpl.BOOL));
//        // missing: gnu-emacs-file
//        addConfigOption(new Flag("literal-attributes", "literalAttribs", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("show-body-only", "bodyOnly", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("fix-uri", "fixUri", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("lower-literals", "lowerLiterals", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("hide-comments", "hideComments", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("indent-cdata", "indentCdata", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("force-output", "forceOutput", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("show-errors", "showErrors", ParsePropertyImpl.INT));
//        addConfigOption(new Flag("ascii-chars", "asciiChars", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("join-classes", "joinClasses", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("join-styles", "joinStyles", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("escape-cdata", "escapeCdata", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("language", "language", ParsePropertyImpl.NAME));
//        addConfigOption(new Flag("ncr", "ncr", ParsePropertyImpl.BOOL));
//        // missing: output-bom
//        addConfigOption(new Flag("replace-color", "replaceColor", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("css-prefix", "cssPrefix", ParsePropertyImpl.CSS1SELECTOR));
//        addConfigOption(new Flag("new-inline-tags", null, ParsePropertyImpl.TAGNAMES));
//        addConfigOption(new Flag("new-blocklevel-tags", null, ParsePropertyImpl.TAGNAMES));
//        addConfigOption(new Flag("new-empty-tags", null, ParsePropertyImpl.TAGNAMES));
//        addConfigOption(new Flag("new-pre-tags", null, ParsePropertyImpl.TAGNAMES));
//        // missing: accessibility-check
//        // missing: vertical-space
//        // missing: punctuation-wrap
//        // missing: merge-divs
//        // missing: decorate-inferred-ul
//        // missing: preserve-entities
//        // missing: sort-attributes
//        // missing: merge-spans
//        // missing: anchor-as-name
//        
//        // options not found in Tidy
//        addConfigOption(new Flag("add-xml-pi", "xmlPi", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("only-errors", "onlyErrors", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("output-raw", "rawOut", ParsePropertyImpl.BOOL));
//        addConfigOption(new Flag("trim-empty-elements", "trimEmpty", ParsePropertyImpl.BOOL));
//    }

    /**
     * style sheet for slides.
     * @deprecated does nothing
     */
    protected String slidestyle;

    /**
     * if true then output tidied markup.
     */
    private boolean writeback;

    /**
     * if true normal output is suppressed.
     */
    private boolean onlyErrors;

    /**
     * however errors are always shown.
     */
    private boolean showWarnings = true;

    /**
     * no 'Parsing X', guessed DTD or summary.
     */
    private boolean quiet;

    /**
     * indent content of appropriate tags.
     */
    private boolean indentContent;

    /**
     * does text/block level content effect indentation.
     */
    private boolean smartIndent;

    /**
     * suppress optional end tags.
     */
    private boolean hideEndTags;

    /**
     * treat input as XML.
     */
    private boolean xmlTags;

    /**
     * create output as XML.
     */
    private boolean xmlOut;

    /**
     * output extensible HTML.
     */
    private boolean xHTML;

    /**
     * output plain-old HTML, even for XHTML input. Yes means set explicitly.
     */
    private boolean htmlOut;

    /**
     * add <code>&lt;?xml?&gt;</code> for XML docs.
     */
    private boolean xmlPi;

    /**
     * output tags in upper not lower case.
     */
    private boolean upperCaseTags;

    /**
     * output attributes in upper not lower case.
     */
    private boolean upperCaseAttrs;

    /**
     * remove presentational clutter.
     */
    private boolean makeClean;

    /**
     * Make bare HTML: remove Microsoft cruft.
     */
    private boolean makeBare;

    /**
     * replace i by em and b by strong.
     */
    private boolean logicalEmphasis;

    /**
     * discard presentation tags.
     */
    private boolean dropFontTags;

    /**
     * discard proprietary attributes.
     */
    private boolean dropProprietaryAttributes;

    /**
     * discard empty p elements.
     */
    private boolean dropEmptyParas = true;

    /**
     * fix comments with adjacent hyphens.
     */
    private boolean fixComments = true;

    /**
     * trim empty elements.
     */
    private boolean trimEmpty = true;

    /**
     * o/p newline before br or not?
     */
    private boolean breakBeforeBR;

    /**
     * create slides on each h2 element.
     */
    private boolean burstSlides;

    /**
     * use numeric entities.
     */
    private boolean numEntities;

    /**
     * output " marks as &quot;.
     */
    private boolean quoteMarks;

    /**
     * output non-breaking space as entity.
     */
    private boolean quoteNbsp = true;

    /**
     * output naked ampersand as &amp;.
     */
    private boolean quoteAmpersand = true;

    /**
     * wrap within attribute values.
     */
    private boolean wrapAttVals;

    /**
     * wrap within JavaScript string literals.
     */
    private boolean wrapScriptlets;

    /**
     * wrap within CDATA section tags.
     */
    private boolean wrapSection = true;

    /**
     * wrap within ASP pseudo elements.
     */
    private boolean wrapAsp = true;

    /**
     * wrap within JSTE pseudo elements.
     */
    private boolean wrapJste = true;

    /**
     * wrap within PHP pseudo elements.
     */
    private boolean wrapPhp = true;

    /**
     * fix URLs by replacing \ with /.
     */
    private boolean fixBackslash = true;

    /**
     * newline+indent before each attribute.
     */
    private boolean indentAttributes;

    /**
     * If set to yes PIs must end with <code>?&gt;</code>.
     */
    private boolean xmlPIs;

    /**
     * if set to yes adds xml:space attr as needed.
     */
    private boolean xmlSpace;

    /**
     * if yes text at body is wrapped in p's.
     */
    private boolean encloseBodyText;

    /**
     * if yes text in blocks is wrapped in p's.
     */
    private boolean encloseBlockText;

    /**
     * if yes last modied time is preserved.
     */
    private boolean keepFileTimes = true;

    /**
     * draconian cleaning for Word2000.
     */
    private boolean word2000;

    /**
     * add meta element indicating tidied doc.
     */
    private boolean tidyMark = true;

    /**
     * if true format error output for GNU Emacs.
     */
    private boolean emacs;

    /**
     * if true attributes may use newlines.
     */
    private boolean literalAttribs;

    /**
     * output BODY content only.
     */
    private boolean bodyOnly;

    /**
     * properly escape URLs.
     */
    private boolean fixUri = true;

    /**
     * folds known attribute values to lower case.
     */
    private boolean lowerLiterals = true;

    /**
     * replace hex color attribute values with names.
     */
    private boolean replaceColor;

    /**
     * hides all (real) comments in output.
     */
    private boolean hideComments;

    /**
     * indent CDATA sections.
     */
    private boolean indentCdata;

    /**
     * output document even if errors were found.
     */
    private boolean forceOutput;

    /**
     * number of errors to put out.
     */
    private int showErrors = 6;

    /**
     * convert quotes and dashes to nearest ASCII char.
     */
    private boolean asciiChars = true;

    /**
     * join multiple class attributes.
     */
    private boolean joinClasses;

    /**
     * join multiple style attributes.
     */
    private boolean joinStyles = true;

    /**
     * replace CDATA sections with escaped text.
     */
    private boolean escapeCdata = true;

    /**
     * allow numeric character references.
     */
    private boolean ncr = true; // #431953

    /**
     * CSS class naming for -clean option.
     */
    private String cssPrefix;

    /**
     * char encoding used when replacing illegal SGML chars, regardless of specified encoding.
     */
    private String replacementCharEncoding = "WIN1252"; // by default

    /**
     * TagTable associated with this Configuration.
     */
    protected TagTable tt;

    /**
     * Report instance. Used for messages.
     */
    protected Report report;

    /**
     * track what types of tags user has defined to eliminate unnecessary searches.
     */
    private int definedTags;

    /**
     * bytes for the newline marker.
     */
    private char[] newline = (System.getProperty("line.separator")).toCharArray();

    /**
     * Input character encoding (defaults to "ISO8859_1").
     */
    private String inCharEncoding = "ISO8859_1";

    /**
     * Output character encoding (defaults to "ASCII").
     */
    private String outCharEncoding = "ASCII";

    /**
     * Avoid mapping values > 127 to entities.
     */
    private boolean rawOut;
    
    private int accessibilityCheckLevel = 0;

    /**
     * configuration properties.
     */
    private transient Properties properties = new Properties();

    /**
     * Instantiates a new Configuration. This method should be called by Tidy only.
     * @param report Report instance
     */
    protected Configuration(Report report)
    {
        this.report = report;
    }

    /**
     * adds configuration Properties.
     * @param p Properties
     */
    public void addProps(Properties p)
    {
        Enumeration<?> propEnum = p.propertyNames();
        while (propEnum.hasMoreElements())
        {
            String key = (String) propEnum.nextElement();
            String value = p.getProperty(key);
            properties.put(key, value);
        }
        parseProps();
    }

    /**
     * Parses a property file.
     * @param filename file name
     */
    public void parseFile(String filename)
    {
        try
        {
            properties.load(new FileInputStream(filename));
        }
        catch (IOException e)
        {
            System.err.println(filename + " " + e.toString());
            return;
        }
        parseProps();
    }

    /**
     * Is the given String a valid configuration flag?
     * @param name configuration parameter name
     * @return <code>true</code> if the given String is a valid config option
     */
    public static boolean isKnownOption(String name)
    {
        return name != null && Options.getOption(name) != null;
    }

    /**
     * Parses the configuration properties file.
     */
    private void parseProps()
    {
        for (Object o : properties.keySet())
        {
        	String key = (String) o;
        	Option flag = Options.getOption(key);
            if (flag == null)
            {
                report.unknownOption(key);
                continue;
            }

            String stringValue = properties.getProperty(key);
            Object value = flag.getParser().parse(stringValue, flag, this);
            options.put(flag, value);
        }
    }

    /**
     * Ensure that config is self consistent.
     */
    public void adjust()
    {
        if (encloseBlockText)
        {
            encloseBodyText = true;
        }

        // avoid the need to set IndentContent when SmartIndent is set
        if (smartIndent)
        {
            indentContent = true;
        }

        // disable wrapping
        if (getWraplen() == 0) {
            setWraplen(0x7FFFFFFF);
        }

        // Word 2000 needs o:p to be declared as inline
        if (word2000)
        {
            definedTags |= Dict.TAGTYPE_INLINE;
            tt.defineTag(Dict.TAGTYPE_INLINE, "o:p");
        }

        // #480701 disable XHTML output flag if both output-xhtml and xml are set
        if (xmlTags)
        {
            xHTML = false;
        }

        // XHTML is written in lower case
        if (xHTML)
        {
            xmlOut = true;
            upperCaseTags = false;
            upperCaseAttrs = false;
        }

        // if XML in, then XML out
        if (xmlTags)
        {
            xmlOut = true;
            xmlPIs = true;
        }

        // #427837 - fix by Dave Raggett 02 Jun 01
        // generate <?xml version="1.0" encoding="iso-8859-1"?> if the output character encoding is Latin-1 etc.
        if (!"UTF8".equals(getOutCharEncodingName()) && !"ASCII".equals(getOutCharEncodingName()) && xmlOut)
        {
            xmlPi = true;
        }

        // XML requires end tags
        if (xmlOut)
        {
            quoteAmpersand = true;
            hideEndTags = false;
        }
    }

    /**
     * prints available configuration options.
     * @param errout where to write
     * @param showActualConfiguration print actual configuration values
     */
    public void printConfigOptions(Writer errout, boolean showActualConfiguration)
    {
        String pad = "                                                                               ";
        try
        {
            errout.write("\nConfiguration File Settings:\n\n");

            if (showActualConfiguration)
            {
                errout.write("Name                        Type       Current Value\n");
            }
            else
            {
                errout.write("Name                        Type       Allowable values\n");
            }

            errout.write("=========================== =========  ========================================\n");

            for (Option configItem : Options.getOptions())
            {
                errout.write(configItem.getName());
                errout.write(pad, 0, 28 - configItem.getName().length());

                errout.write(configItem.getParser().getType());
                errout.write(pad, 0, 11 - configItem.getParser().getType().length());

                if (showActualConfiguration)
                {
                    Object actualValue = options.get(configItem);
                    errout.write(configItem.getParser().getFriendlyName(configItem.getName(), actualValue, this));
                }
                else
                {
                    errout.write(configItem.getParser().getOptionValues());
                }

                errout.write("\n");

            }
            errout.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * Getter for <code>inCharEncodingName</code>.
     * @return Returns the inCharEncodingName.
     */
    protected String getInCharEncodingName()
    {
        return this.inCharEncoding;
    }

    /**
     * Setter for <code>inCharEncodingName</code>.
     * @param encoding The inCharEncodingName to set.
     */
    protected void setInCharEncodingName(String encoding)
    {
        String javaEncoding = EncodingNameMapper.toJava(encoding);
        if (javaEncoding != null)
        {
            this.inCharEncoding = javaEncoding;
        }
    }

    /**
     * Getter for <code>outCharEncodingName</code>.
     * @return Returns the outCharEncodingName.
     */
    protected String getOutCharEncodingName()
    {
        return this.outCharEncoding;
    }

    /**
     * Setter for <code>outCharEncodingName</code>.
     * @param encoding The outCharEncodingName to set.
     */
    protected void setOutCharEncodingName(String encoding)
    {
        String javaEncoding = EncodingNameMapper.toJava(encoding);
        if (javaEncoding != null)
        {
            this.outCharEncoding = javaEncoding;
        }
    }

    /**
     * Setter for <code>inOutCharEncodingName</code>.
     * @param encoding The CharEncodingName to set.
     */
    protected void setInOutEncodingName(String encoding)
    {
        setInCharEncodingName(encoding);
        setOutCharEncodingName(encoding);
    }

    /**
     * Setter for <code>outCharEncoding</code>.
     * @param encoding The outCharEncoding to set.
     * @deprecated use setOutCharEncodingName(String)
     */
    protected void setOutCharEncoding(int encoding)
    {
        setOutCharEncodingName(convertCharEncoding(encoding));
    }

    /**
     * Setter for <code>inCharEncoding</code>.
     * @param encoding The inCharEncoding to set.
     * @deprecated use setInCharEncodingName(String)
     */
    protected void setInCharEncoding(int encoding)
    {
        setInCharEncodingName(convertCharEncoding(encoding));
    }

    /**
     * Convert a char encoding from the deprecated tidy constant to a standard java encoding name.
     * @param code encoding code
     * @return encoding name
     */
    protected String convertCharEncoding(int code)
    {
        if (code != 0 && code < ENCODING_NAMES.length)
        {
            return ENCODING_NAMES[code];
        }
        return null;
    }
    
    private static RuntimeException badType(final Object x) {
    	if (x == null) {
    		return new RuntimeException("Null option value");
    	}
    	return new RuntimeException("Unexpected value type: " + x.getClass().getName());
    }
    
    private Object get(final Option option) {
    	final Object x = options.get(option);
    	return x == null ? option.getDflt() : x;
    }
    
    private int getInt(final Option option) {
    	final Object x = get(option);
    	if (x instanceof Integer) {
    		return (Integer) x;
    	}
    	throw badType(x);
    }
    
    private OptionEnum getOptionEnum(final Option option) {
    	final Object x = get(option);
    	if (x instanceof OptionEnum) {
    		return (OptionEnum) x;
    	}
    	throw badType(x);
    }
    
    private String getString(final Option option) {
    	final Object x = get(option);
    	if (x instanceof String) {
    		return (String) x;
    	}
    	throw badType(x);
    }
    
    private void set(final Option option, final Object value) {
    	options.put(option, value);
    }

	protected void setSpaces(final int spaces) {
		set(Option.IndentSpaces, spaces);
	}

	protected int getSpaces() {
		return getInt(Option.IndentSpaces);
	}

	protected void setWraplen(final int wraplen) {
		set(Option.WrapLen, wraplen);
	}

	protected int getWraplen() {
		return getInt(Option.WrapLen);
	}

	protected void setTabsize(final int tabsize) {
		set(Option.TabSize, tabsize);
	}

	protected int getTabsize() {
		return getInt(Option.TabSize);
	}

	protected void setDocTypeMode(final DoctypeModes docTypeMode) {
		set(Option.DoctypeMode, docTypeMode);
	}

	protected DoctypeModes getDocTypeMode() {
		return (DoctypeModes) getOptionEnum(Option.DoctypeMode);
	}

	protected void setDuplicateAttrs(final DupAttrModes duplicateAttrs) {
		set(Option.DuplicateAttrs, duplicateAttrs);
	}

	protected DupAttrModes getDuplicateAttrs() {
		return (DupAttrModes) getOptionEnum(Option.DuplicateAttrs);
	}

	protected void setAltText(final String altText) {
		set(Option.AltText, altText);
	}

	protected String getAltText() {
		return getString(Option.AltText);
	}

	protected void setLanguage(final String language) {
		set(Option.Language, language);
	}

	protected String getLanguage() {
		return getString(Option.Language);
	}

	protected void setDocTypeStr(final String docTypeStr) {
		set(Option.Doctype, docTypeStr);
	}

	protected String getDocTypeStr() {
		return getString(Option.Doctype);
	}

	protected void setErrfile(final String errfile) {
		set(Option.ErrFile, errfile);
	}

	protected String getErrfile() {
		return getString(Option.ErrFile);
	}

	protected void setWriteback(boolean writeback) {
		this.writeback = writeback;
	}

	protected boolean isWriteback() {
		return writeback;
	}

	protected void setOnlyErrors(boolean onlyErrors) {
		this.onlyErrors = onlyErrors;
	}

	protected boolean isOnlyErrors() {
		return onlyErrors;
	}

	protected void setShowWarnings(boolean showWarnings) {
		this.showWarnings = showWarnings;
	}

	protected boolean isShowWarnings() {
		return showWarnings;
	}

	protected void setQuiet(boolean quiet) {
		this.quiet = quiet;
	}

	protected boolean isQuiet() {
		return quiet;
	}

	protected void setIndentContent(boolean indentContent) {
		this.indentContent = indentContent;
	}

	protected boolean isIndentContent() {
		return indentContent;
	}

	protected void setSmartIndent(boolean smartIndent) {
		this.smartIndent = smartIndent;
	}

	protected boolean isSmartIndent() {
		return smartIndent;
	}

	protected void setHideEndTags(boolean hideEndTags) {
		this.hideEndTags = hideEndTags;
	}

	protected boolean isHideEndTags() {
		return hideEndTags;
	}

	protected void setXmlTags(boolean xmlTags) {
		this.xmlTags = xmlTags;
	}

	protected boolean isXmlTags() {
		return xmlTags;
	}

	protected void setXmlOut(boolean xmlOut) {
		this.xmlOut = xmlOut;
	}

	protected boolean isXmlOut() {
		return xmlOut;
	}

	protected void setXHTML(boolean xHTML) {
		this.xHTML = xHTML;
	}

	protected boolean isXHTML() {
		return xHTML;
	}

	protected void setHtmlOut(boolean htmlOut) {
		this.htmlOut = htmlOut;
	}

	protected boolean isHtmlOut() {
		return htmlOut;
	}

	protected void setXmlPi(boolean xmlPi) {
		this.xmlPi = xmlPi;
	}

	protected boolean isXmlPi() {
		return xmlPi;
	}

	protected void setUpperCaseTags(boolean upperCaseTags) {
		this.upperCaseTags = upperCaseTags;
	}

	protected boolean isUpperCaseTags() {
		return upperCaseTags;
	}

	protected void setUpperCaseAttrs(boolean upperCaseAttrs) {
		this.upperCaseAttrs = upperCaseAttrs;
	}

	protected boolean isUpperCaseAttrs() {
		return upperCaseAttrs;
	}

	protected void setMakeClean(boolean makeClean) {
		this.makeClean = makeClean;
	}

	protected boolean isMakeClean() {
		return makeClean;
	}

	protected void setMakeBare(boolean makeBare) {
		this.makeBare = makeBare;
	}

	protected boolean isMakeBare() {
		return makeBare;
	}

	protected void setLogicalEmphasis(boolean logicalEmphasis) {
		this.logicalEmphasis = logicalEmphasis;
	}

	protected boolean isLogicalEmphasis() {
		return logicalEmphasis;
	}

	protected void setDropFontTags(boolean dropFontTags) {
		this.dropFontTags = dropFontTags;
	}

	protected boolean isDropFontTags() {
		return dropFontTags;
	}

	protected void setDropProprietaryAttributes(boolean dropProprietaryAttributes) {
		this.dropProprietaryAttributes = dropProprietaryAttributes;
	}

	protected boolean isDropProprietaryAttributes() {
		return dropProprietaryAttributes;
	}

	protected void setDropEmptyParas(boolean dropEmptyParas) {
		this.dropEmptyParas = dropEmptyParas;
	}

	protected boolean isDropEmptyParas() {
		return dropEmptyParas;
	}

	protected void setFixComments(boolean fixComments) {
		this.fixComments = fixComments;
	}

	protected boolean isFixComments() {
		return fixComments;
	}

	protected void setTrimEmpty(boolean trimEmpty) {
		this.trimEmpty = trimEmpty;
	}

	protected boolean isTrimEmpty() {
		return trimEmpty;
	}

	protected void setBreakBeforeBR(boolean breakBeforeBR) {
		this.breakBeforeBR = breakBeforeBR;
	}

	protected boolean isBreakBeforeBR() {
		return breakBeforeBR;
	}

	protected void setBurstSlides(boolean burstSlides) {
		this.burstSlides = burstSlides;
	}

	protected boolean isBurstSlides() {
		return burstSlides;
	}

	protected void setNumEntities(boolean numEntities) {
		this.numEntities = numEntities;
	}

	protected boolean isNumEntities() {
		return numEntities;
	}

	protected void setQuoteMarks(boolean quoteMarks) {
		this.quoteMarks = quoteMarks;
	}

	protected boolean isQuoteMarks() {
		return quoteMarks;
	}

	protected void setQuoteNbsp(boolean quoteNbsp) {
		this.quoteNbsp = quoteNbsp;
	}

	protected boolean isQuoteNbsp() {
		return quoteNbsp;
	}

	protected void setQuoteAmpersand(boolean quoteAmpersand) {
		this.quoteAmpersand = quoteAmpersand;
	}

	protected boolean isQuoteAmpersand() {
		return quoteAmpersand;
	}

	protected void setWrapAttVals(boolean wrapAttVals) {
		this.wrapAttVals = wrapAttVals;
	}

	protected boolean isWrapAttVals() {
		return wrapAttVals;
	}

	protected void setWrapScriptlets(boolean wrapScriptlets) {
		this.wrapScriptlets = wrapScriptlets;
	}

	protected boolean isWrapScriptlets() {
		return wrapScriptlets;
	}

	protected void setWrapSection(boolean wrapSection) {
		this.wrapSection = wrapSection;
	}

	protected boolean isWrapSection() {
		return wrapSection;
	}

	protected void setWrapAsp(boolean wrapAsp) {
		this.wrapAsp = wrapAsp;
	}

	protected boolean isWrapAsp() {
		return wrapAsp;
	}

	protected void setWrapJste(boolean wrapJste) {
		this.wrapJste = wrapJste;
	}

	protected boolean isWrapJste() {
		return wrapJste;
	}

	protected void setWrapPhp(boolean wrapPhp) {
		this.wrapPhp = wrapPhp;
	}

	protected boolean isWrapPhp() {
		return wrapPhp;
	}

	protected void setFixBackslash(boolean fixBackslash) {
		this.fixBackslash = fixBackslash;
	}

	protected boolean isFixBackslash() {
		return fixBackslash;
	}

	protected void setIndentAttributes(boolean indentAttributes) {
		this.indentAttributes = indentAttributes;
	}

	protected boolean isIndentAttributes() {
		return indentAttributes;
	}

	protected void setXmlPIs(boolean xmlPIs) {
		this.xmlPIs = xmlPIs;
	}

	protected boolean isXmlPIs() {
		return xmlPIs;
	}

	protected void setXmlSpace(boolean xmlSpace) {
		this.xmlSpace = xmlSpace;
	}

	protected boolean isXmlSpace() {
		return xmlSpace;
	}

	protected void setEncloseBodyText(boolean encloseBodyText) {
		this.encloseBodyText = encloseBodyText;
	}

	protected boolean isEncloseBodyText() {
		return encloseBodyText;
	}

	protected void setEncloseBlockText(boolean encloseBlockText) {
		this.encloseBlockText = encloseBlockText;
	}

	protected boolean isEncloseBlockText() {
		return encloseBlockText;
	}

	protected void setKeepFileTimes(boolean keepFileTimes) {
		this.keepFileTimes = keepFileTimes;
	}

	protected boolean isKeepFileTimes() {
		return keepFileTimes;
	}

	protected void setWord2000(boolean word2000) {
		this.word2000 = word2000;
	}

	protected boolean isWord2000() {
		return word2000;
	}

	protected void setTidyMark(boolean tidyMark) {
		this.tidyMark = tidyMark;
	}

	protected boolean isTidyMark() {
		return tidyMark;
	}

	protected void setEmacs(boolean emacs) {
		this.emacs = emacs;
	}

	protected boolean isEmacs() {
		return emacs;
	}

	protected void setLiteralAttribs(boolean literalAttribs) {
		this.literalAttribs = literalAttribs;
	}

	protected boolean isLiteralAttribs() {
		return literalAttribs;
	}

	protected void setBodyOnly(boolean bodyOnly) {
		this.bodyOnly = bodyOnly;
	}

	protected boolean isBodyOnly() {
		return bodyOnly;
	}

	protected void setFixUri(boolean fixUri) {
		this.fixUri = fixUri;
	}

	protected boolean isFixUri() {
		return fixUri;
	}

	protected void setLowerLiterals(boolean lowerLiterals) {
		this.lowerLiterals = lowerLiterals;
	}

	protected boolean isLowerLiterals() {
		return lowerLiterals;
	}

	protected void setReplaceColor(boolean replaceColor) {
		this.replaceColor = replaceColor;
	}

	protected boolean isReplaceColor() {
		return replaceColor;
	}

	protected void setHideComments(boolean hideComments) {
		this.hideComments = hideComments;
	}

	protected boolean isHideComments() {
		return hideComments;
	}

	protected void setIndentCdata(boolean indentCdata) {
		this.indentCdata = indentCdata;
	}

	protected boolean isIndentCdata() {
		return indentCdata;
	}

	protected void setForceOutput(boolean forceOutput) {
		this.forceOutput = forceOutput;
	}

	protected boolean isForceOutput() {
		return forceOutput;
	}

	protected void setShowErrors(int showErrors) {
		this.showErrors = showErrors;
	}

	protected int getShowErrors() {
		return showErrors;
	}

	protected void setAsciiChars(boolean asciiChars) {
		this.asciiChars = asciiChars;
	}

	protected boolean isAsciiChars() {
		return asciiChars;
	}

	protected void setJoinClasses(boolean joinClasses) {
		this.joinClasses = joinClasses;
	}

	protected boolean isJoinClasses() {
		return joinClasses;
	}

	protected void setJoinStyles(boolean joinStyles) {
		this.joinStyles = joinStyles;
	}

	protected boolean isJoinStyles() {
		return joinStyles;
	}

	protected void setEscapeCdata(boolean escapeCdata) {
		this.escapeCdata = escapeCdata;
	}

	protected boolean isEscapeCdata() {
		return escapeCdata;
	}

	protected void setNcr(boolean ncr) {
		this.ncr = ncr;
	}

	protected boolean isNcr() {
		return ncr;
	}

	protected void setCssPrefix(String cssPrefix) {
		this.cssPrefix = cssPrefix;
	}

	protected String getCssPrefix() {
		return cssPrefix;
	}

	protected void setReplacementCharEncoding(String replacementCharEncoding) {
		this.replacementCharEncoding = replacementCharEncoding;
	}

	protected String getReplacementCharEncoding() {
		return replacementCharEncoding;
	}

	protected void setDefinedTags(int definedTags) {
		this.definedTags = definedTags;
	}

	protected int getDefinedTags() {
		return definedTags;
	}

	protected void setNewline(char[] newline) {
		this.newline = newline;
	}

	protected char[] getNewline() {
		return newline;
	}

	protected void setRawOut(boolean rawOut) {
		this.rawOut = rawOut;
	}

	protected boolean isRawOut() {
		return rawOut;
	}

	protected void setAccessibilityCheckLevel(int accessibilityCheckLevel) {
		this.accessibilityCheckLevel = accessibilityCheckLevel;
	}

	protected int getAccessibilityCheckLevel() {
		return accessibilityCheckLevel;
	}
}