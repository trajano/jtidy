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

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.w3c.tidy.Node.NodeType;
import org.w3c.tidy.TidyMessage.Level;

import static org.w3c.tidy.ErrorCode.*;

/**
 * Error/informational message reporter. You should only need to edit the file TidyMessages.properties to localize HTML
 * tidy.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public final class Report
{

    /**
     * used to point to Web Accessibility Guidelines.
     */
    public static final String ACCESS_URL = "http://www.w3.org/WAI/GL";

    /**
     * Release date String.
     */
    public static final String RELEASE_DATE_STRING = readReleaseDate();
    
    private static String readReleaseDate() {
    	final Properties p = new Properties();
    	try {
    		final InputStream s = Report.class.getResourceAsStream("/jtidy.properties");
			p.load(s);
			s.close();
    	} catch (Exception e) {
			throw new RuntimeException("Failed to load jtidy.properties", e);
		}
		return p.getProperty("date");
    }


    /**
     * accessibility flaw: missing image map.
     */
    public static final short MISSING_IMAGE_ALT = 1;

    /**
     * accessibility flaw: missing link alt.
     */
    public static final short MISSING_LINK_ALT = 2;

    /**
     * accessibility flaw: missing summary.
     */
    public static final short MISSING_SUMMARY = 4;

    /**
     * accessibility flaw: missing image map.
     */
    public static final short MISSING_IMAGE_MAP = 8;

    /**
     * accessibility flaw: using frames.
     */
    public static final short USING_FRAMES = 16;

    /**
     * accessibility flaw: using noframes.
     */
    public static final short USING_NOFRAMES = 32;

    /**
     * presentation flaw: using spacer.
     */
    public static final short USING_SPACER = 1;

    /**
     * presentation flaw: using layer.
     */
    public static final short USING_LAYER = 2;

    /**
     * presentation flaw: using nobr.
     */
    public static final short USING_NOBR = 4;

    /**
     * presentation flaw: using font.
     */
    public static final short USING_FONT = 8;

    /**
     * presentation flaw: using body.
     */
    public static final short USING_BODY = 16;

    /**
     * character encoding error: windows chars.
     */
    public static final short WINDOWS_CHARS = 1;

    /**
     * character encoding error: non ascii.
     */
    public static final short NON_ASCII = 2;

    /**
     * character encoding error: found utf16.
     */
    public static final short FOUND_UTF16 = 4;

    /**
     * char has been replaced.
     */
    public static final short REPLACED_CHAR = 0;

    /**
     * char has been discarded.
     */
    public static final short DISCARDED_CHAR = 1;
    
    /* badchar bit field */

    public static final int BC_VENDOR_SPECIFIC_CHARS  = 1;
    public static final int BC_INVALID_SGML_CHARS     = 2;
    public static final int BC_INVALID_UTF8           = 4;
    public static final int BC_INVALID_UTF16          = 8;
    public static final int BC_ENCODING_MISMATCH      = 16; /* fatal error */
    public static final int BC_INVALID_URI            = 32;
    public static final int BC_INVALID_NCR            = 64;

    /**
     * Resource bundle with messages.
     */
    private static ResourceBundle res;

    /**
     * Printed in GNU Emacs messages.
     */
    private String currentFile;

    /**
     * message listener for error reporting.
     */
    private TidyMessageListener listener;

    static
    {
        try
        {
            res = ResourceBundle.getBundle("org/w3c/tidy/TidyMessages");
        }
        catch (MissingResourceException e)
        {
            throw new Error(e.toString());
        }
    }

    /**
     * Instantiated only in Tidy() constructor.
     */
    protected Report()
    {
        super();
    }

    /**
     * Generates a complete message for the warning/error. The message is composed by:
     * <ul>
     * <li>position in file</li>
     * <li>prefix for the error level (warning: | error:)</li>
     * <li>message read from ResourceBundle</li>
     * <li>optional parameters added to message using MessageFormat</li>
     * </ul>
     * @param errorCode tidy error code
     * @param lexer Lexer
     * @param message key for the ResourceBundle
     * @param level message level. One of <code>TidyMessage.LEVEL_ERROR</code>,
     * <code>TidyMessage.LEVEL_WARNING</code>,<code>TidyMessage.LEVEL_INFO</code>
     * @param params optional parameters added with MessageFormat
     * @return formatted message
     * @throws MissingResourceException if <code>message</code> key is not available in jtidy resource bundle.
     * @see TidyMessage
     */
    protected String getMessage(int errorCode, Lexer lexer, String message, Level level, Object... params)
        	throws MissingResourceException {
    	String resource = res.getString(message);
    	String position = lexer == null || level == null ? "" : getPosition(lexer);
        String prefix = level == null ? "" : (level + ": ");
        String messageString = MessageFormat.format(resource, params);
        if (listener != null) {
            TidyMessage msg = new TidyMessage(errorCode, (lexer != null) ? lexer.lines : 0, (lexer != null)
                ? lexer.columns : 0, level, messageString);
            listener.messageReceived(msg);
        }
        return position + prefix + messageString;
    }

    /**
     * Prints a message to lexer.errout after calling getMessage().
     * @param errorCode tidy error code
     * @param lexer Lexer
     * @param message key for the ResourceBundle
     * @param level message level. One of <code>TidyMessage.LEVEL_ERROR</code>,
     * <code>TidyMessage.LEVEL_WARNING</code>,<code>TidyMessage.LEVEL_INFO</code>
     * @param params optional parameters added with MessageFormat
     * @see TidyMessage
     */
    private void printMessage(final ErrorCode errorCode, final Lexer lexer, final String message, final Level level, final Object... params) {
    	printMessage(errorCode.code(), lexer, message, level, params);
    }
    
    private void printMessage(int errorCode, Lexer lexer, String message, Level level, Object... params)
    {
        String resource;
        try
        {
            resource = getMessage(errorCode, lexer, message, level, params);
        }
        catch (MissingResourceException e)
        {
            lexer.errout.println(e.toString());
            return;
        }

        lexer.errout.println(resource);
    }
    
    private void simpleMessage(int errorCode, Lexer lexer, String message, Level level, Object... params) {
        String resource;
        try {
            resource = getMessage(errorCode, null, message, level, params);
        } catch (MissingResourceException e) {
            lexer.errout.println(e.toString());
            return;
        }
        lexer.errout.println(resource);
    }

    /**
     * Prints a message to errout after calling getMessage(). Used when lexer is not yet defined.
     * @param errout PrintWriter
     * @param message key for the ResourceBundle
     * @param level message level. One of <code>TidyMessage.LEVEL_ERROR</code>,
     * <code>TidyMessage.LEVEL_WARNING</code>,<code>TidyMessage.LEVEL_INFO</code>
     * @param params optional parameters added with MessageFormat
     * @see TidyMessage
     */
    private void printMessage(PrintWriter errout, String message, Level level, Object... params)
    {
        String resource;
        try
        {
            resource = getMessage(-1, null, message, level, params);
        }
        catch (MissingResourceException e)
        {
            errout.println(e.toString());
            return;
        }
        errout.println(resource);
    }

    /**
     * print version information.
     * @param p printWriter
     */
    public void showVersion(final PrintWriter p) {
        printMessage(p, "version_summary", null, RELEASE_DATE_STRING);
    }

    /**
     * Returns a formatted tag name handling start and ent tags, nulls, doctypes, and text.
     * @param tag Node
     * @return formatted tag name
     */
    private String getTagName(Node tag)
    {
        if (tag != null)
        {
            if (tag.type == NodeType.StartTag)
            {
                return "<" + tag.element + ">";
            }
            else if (tag.type == NodeType.EndTag)
            {
                return "</" + tag.element + ">";
            }
            else if (tag.type == NodeType.DocTypeTag)
            {
                return "<!DOCTYPE>";
            }
            else if (tag.type == NodeType.TextNode)
            {
                return "plain text";
            }
            else
            {
                return tag.element;
            }
        }
        return "";
    }

    /**
     * Prints an "unknown option" error message. Lexer is not defined when this is called.
     * @param option unknown option name
     */
    public void unknownOption(String option)
    {
        try
        {
            System.err.println(MessageFormat.format(res.getString("unknown_option"), option));
        }
        catch (MissingResourceException e)
        {
            System.err.println(e.toString());
        }
    }

    /**
     * Prints a "bad argument" error message. Lexer is not defined when this is called.
     * @param value bad argument value
     * @param option option object
     */
    public void badArgument(final String value, final Option option) {
        try {
            System.err.println(MessageFormat.format(res.getString("bad_argument"), option.getName(), value));
        } catch (MissingResourceException e) {
            System.err.println(e.toString());
        }
    }

    /**
     * Returns a formatted String describing the current position in file.
     * @param lexer Lexer
     * @return String position ("line:column")
     */
    private String getPosition(Lexer lexer)
    {
        try
        {
            // Change formatting to be parsable by GNU Emacs
            if (lexer.configuration.isEmacs())
            {
                return MessageFormat.format(res.getString("emacs_format"), 
                    this.currentFile,
                    new Integer(lexer.lines),
                    new Integer(lexer.columns))
                    + " ";
            }
            // traditional format
            return MessageFormat.format(res.getString("line_column"), 
                new Integer(lexer.lines),
                new Integer(lexer.columns));

        }
        catch (MissingResourceException e)
        {
            lexer.errout.println(e.toString());
        }
        return "";
    }

    /**
     * Prints encoding error messages.
     * @param lexer Lexer
     * @param code error code
     * @param c invalid char
     */
    public void encodingError(Lexer lexer, ErrorCode code, int c, int replaceMode)
    {
        lexer.warnings++;

        if (lexer.errors > lexer.configuration.getShowErrors()) // keep quiet after <showErrors> errors
        {
            return;
        }

        if (lexer.configuration.isShowWarnings())
        {
            String buf = Integer.toHexString(c);

            // An encoding mismatch is currently treated as a non-fatal error
            switch(code) {
            case ENCODING_MISMATCH:
                // actual encoding passed in "c"
                lexer.badChars |= BC_ENCODING_MISMATCH;
                printMessage(
                    code,
                    lexer,
                    "encoding_mismatch",
                    Level.WARNING,
                    
                        lexer.configuration.getInCharEncodingName(),
                        ParsePropertyImpl.CHAR_ENCODING.getFriendlyName(null, new Integer(c), lexer.configuration));
                break;
            case VENDOR_SPECIFIC_CHARS:
                lexer.badChars |= BC_VENDOR_SPECIFIC_CHARS;
                printMessage(
                    code,
                    lexer,
                    "invalid_char",
                    Level.WARNING,
                    replaceMode, buf);
                break;
            case INVALID_SGML_CHARS:
                lexer.badChars |= BC_INVALID_SGML_CHARS;
                printMessage(
                    code,
                    lexer,
                    "invalid_char",
                    Level.WARNING,
                    replaceMode, buf);
                break;
            case INVALID_UTF8:
                lexer.badChars |= BC_INVALID_UTF8;
                printMessage(
                    code,
                    lexer,
                    "invalid_utf8",
                    Level.WARNING,
                    replaceMode, buf);
                break;
            case INVALID_UTF16:
                lexer.badChars |= BC_INVALID_UTF16;
                printMessage(
                    code,
                    lexer,
                    "invalid_utf16",
                    Level.WARNING,
                    replaceMode, buf);
                break;
            case INVALID_NCR:
                lexer.badChars |= BC_INVALID_NCR;
                printMessage(
                    code,
                    lexer,
                    "invalid_ncr",
                    Level.WARNING,
                    replaceMode, buf);
                break;
            }
        }
    }

    /**
     * Prints entity error messages.
     * @param lexer Lexer
     * @param code error code
     * @param entity invalid entity String
     * @param c invalid char
     */
    public void entityError(Lexer lexer, ErrorCode code, String entity, int c)
    {
        lexer.warnings++;

        if (lexer.errors > lexer.configuration.getShowErrors()) // keep quiet after <showErrors> errors
        {
            return;
        }

        if (lexer.configuration.isShowWarnings())
        {
            switch (code)
            {
                case MISSING_SEMICOLON :
                    printMessage(code, lexer, "missing_semicolon", Level.WARNING, entity);
                    break;
                case MISSING_SEMICOLON_NCR :
                    printMessage(code, lexer, "missing_semicolon_ncr", Level.WARNING, entity);
                    break;
                case UNKNOWN_ENTITY :
                    printMessage(code, lexer, "unknown_entity", Level.WARNING, entity);
                    break;
                case UNESCAPED_AMPERSAND :
                    printMessage(code, lexer, "unescaped_ampersand", Level.WARNING);
                    break;
                case APOS_UNDEFINED :
                    printMessage(code, lexer, "apos_undefined", Level.WARNING);
                    break;
                default :
                    // should not reach here
                    break;
            }
        }
    }

    /**
     * Prints error messages for attributes.
     * @param lexer Lexer
     * @param node current tag
     * @param attribute attribute
     * @param code error code
     */
    public void attrError(Lexer lexer, Node node, AttVal attribute, ErrorCode code)
    {
        if (code == UNEXPECTED_GT)
        {
            lexer.errors++;
        }
        else
        {
            lexer.warnings++;
        }

        if (lexer.errors > lexer.configuration.getShowErrors()) // keep quiet after <showErrors> errors
        {
            return;
        }

        if (code == UNEXPECTED_GT) // error
        {
            printMessage(code, lexer, "unexpected_gt", Level.ERROR, getTagName(node));
        }

        if (!lexer.configuration.isShowWarnings()) // warnings
        {
            return;
        }

        switch (code)
        {
            case UNKNOWN_ATTRIBUTE :
                printMessage(code, lexer, "unknown_attribute", Level.WARNING, attribute.attribute);
                break;

            case MISSING_ATTRIBUTE :
                printMessage(
                    code,
                    lexer,
                    "missing_attribute",
                    Level.WARNING,
                    getTagName(node), attribute.attribute);
                break;

            case MISSING_ATTR_VALUE :
                printMessage(
                    code,
                    lexer,
                    "missing_attr_value",
                    Level.WARNING,
                    getTagName(node), attribute.attribute);
                break;

            case MISSING_IMAGEMAP :
                printMessage(code, lexer, "missing_imagemap", Level.WARNING, getTagName(node));
                lexer.badAccess |= MISSING_IMAGE_MAP;
                break;

            case BAD_ATTRIBUTE_VALUE :
                printMessage(code, lexer, "bad_attribute_value", Level.WARNING, 
					    getTagName(node),
					    attribute.attribute,
					    attribute.value);
                break;

            case XML_ID_SYNTAX :
                printMessage(
                    code,
                    lexer,
                    "xml_id_sintax",
                    Level.WARNING,
                    getTagName(node), attribute.attribute);
                break;

            case XML_ATTRIBUTE_VALUE :
                printMessage(
                    code,
                    lexer,
                    "xml_attribute_value",
                    Level.WARNING,
                    getTagName(node), attribute.attribute);
                break;

            case UNEXPECTED_QUOTEMARK :
                printMessage(code, lexer, "unexpected_quotemark", Level.WARNING, getTagName(node));
                break;

            case MISSING_QUOTEMARK :
                printMessage(code, lexer, "missing_quotemark", Level.WARNING, getTagName(node));
                break;

            case REPEATED_ATTRIBUTE :
                printMessage(code, lexer, "repeated_attribute", Level.WARNING, 
					    getTagName(node),
					    attribute.value,
					    attribute.attribute);
                break;

            case PROPRIETARY_ATTR_VALUE :
                printMessage(
                    code,
                    lexer,
                    "proprietary_attr_value",
                    Level.WARNING,
                    getTagName(node), attribute.value);
                break;

            case PROPRIETARY_ATTRIBUTE :
                printMessage(
                    code,
                    lexer,
                    "proprietary_attribute",
                    Level.WARNING,
                    getTagName(node), attribute.attribute);
                break;

            case UNEXPECTED_END_OF_FILE :
                // on end of file adjust reported position to end of input
                lexer.lines = lexer.in.getCurline();
                lexer.columns = lexer.in.getCurcol();
                printMessage(code, lexer, "unexpected_end_of_file", Level.WARNING, getTagName(node));
                break;

            case ID_NAME_MISMATCH :
                printMessage(code, lexer, "id_name_mismatch", Level.WARNING, getTagName(node));
                break;

            case BACKSLASH_IN_URI :
                printMessage(code, lexer, "backslash_in_uri", Level.WARNING, getTagName(node));
                break;

            case FIXED_BACKSLASH :
                printMessage(code, lexer, "fixed_backslash", Level.WARNING, getTagName(node));
                break;

            case ILLEGAL_URI_REFERENCE :
                printMessage(code, lexer, "illegal_uri_reference", Level.WARNING, getTagName(node));
                break;

            case ESCAPED_ILLEGAL_URI :
                printMessage(code, lexer, "escaped_illegal_uri", Level.WARNING, getTagName(node));
                break;

            case NEWLINE_IN_URI :
                printMessage(code, lexer, "newline_in_uri", Level.WARNING, getTagName(node));
                break;

            case ANCHOR_NOT_UNIQUE :
                printMessage(
                    code,
                    lexer,
                    "anchor_not_unique",
                    Level.WARNING,
                    getTagName(node), attribute.value);
                break;

            case ENTITY_IN_ID :
                printMessage(code, lexer, "entity_in_id", Level.WARNING);
                break;

            case JOINING_ATTRIBUTE :
                printMessage(
                    code,
                    lexer,
                    "joining_attribute",
                    Level.WARNING,
                    getTagName(node), attribute.attribute);
                break;

            case UNEXPECTED_EQUALSIGN :
                printMessage(code, lexer, "expected_equalsign", Level.WARNING, getTagName(node));
                break;

            case ATTR_VALUE_NOT_LCASE :
                printMessage(code, lexer, "attr_value_not_lcase", Level.WARNING, 
					    getTagName(node),
					    attribute.value,
					    attribute.attribute);
                break;

            default :
                break;
        }
    }

    /**
     * Prints warnings.
     * @param lexer Lexer
     * @param element parent/missing tag
     * @param node current tag
     * @param code error code
     */
    public void warning(Lexer lexer, Node element, Node node, ErrorCode code)
    {
        if (!((code == DISCARDING_UNEXPECTED) && lexer.badForm != 0)) // lexer->errors++; already done in BadForm()
        {
            lexer.warnings++;
        }

        // keep quiet after <showErrors> errors
        if (lexer.errors > lexer.configuration.getShowErrors())
        {
            return;
        }

        if (lexer.configuration.isShowWarnings())
        {
            switch (code)
            {
                case MISSING_ENDTAG_FOR :
                    printMessage(code, lexer, "missing_endtag_for", Level.WARNING, element.element);
                    break;

                case MISSING_ENDTAG_BEFORE :
                    printMessage(
                        code,
                        lexer,
                        "missing_endtag_before",
                        Level.WARNING,
                        element.element, getTagName(node));
                    break;

                case DISCARDING_UNEXPECTED :
                    if (lexer.badForm == 0)
                    {
                        // the case for when this is an error not a warning, is handled later
                        printMessage(
                            code,
                            lexer,
                            "discarding_unexpected",
                            Level.WARNING,
                            getTagName(node));
                    }
                    break;

                case NESTED_EMPHASIS :
                    printMessage(code, lexer, "nested_emphasis", Level.INFO, getTagName(node));
                    break;

                case COERCE_TO_ENDTAG :
                    printMessage(code, lexer, "coerce_to_endtag", Level.INFO, element.element);
                    break;

                case NON_MATCHING_ENDTAG :
                    printMessage(
                        code,
                        lexer,
                        "non_matching_endtag",
                        Level.WARNING,
                        getTagName(node), element.element);
                    break;

                case TAG_NOT_ALLOWED_IN :
                    printMessage(
                        code,
                        lexer,
                        "tag_not_allowed_in",
                        Level.WARNING,
                        getTagName(node), element.element);
                    break;

                case DOCTYPE_AFTER_TAGS :
                    printMessage(code, lexer, "doctype_after_tags", Level.WARNING);
                    break;

                case MISSING_STARTTAG :
                    printMessage(code, lexer, "missing_starttag", Level.WARNING, node.element);
                    break;

                case UNEXPECTED_ENDTAG :
                    if (element != null)
                    {
                        printMessage(
                            code,
                            lexer,
                            "unexpected_endtag_in",
                            Level.WARNING,
                            node.element, element.element);
                    }
                    else
                    {
                        printMessage(code, lexer, "unexpected_endtag", Level.WARNING, node.element);
                    }
                    break;

                case TOO_MANY_ELEMENTS :
                    if (element != null)
                    {
                        printMessage(
                            code,
                            lexer,
                            "too_many_elements_in",
                            Level.WARNING,
                            node.element, element.element);
                    }
                    else
                    {
                        printMessage(code, lexer, "too_many_elements", Level.WARNING, node.element);
                    }
                    break;

                case USING_BR_INPLACE_OF :
                    printMessage(code, lexer, "using_br_inplace_of", Level.WARNING, getTagName(node));
                    break;

                case INSERTING_TAG :
                    printMessage(code, lexer, "inserting_tag", Level.WARNING, node.element);
                    break;

                case CANT_BE_NESTED :
                    printMessage(code, lexer, "cant_be_nested", Level.WARNING, getTagName(node));
                    break;

                case PROPRIETARY_ELEMENT :
                    printMessage(code, lexer, "proprietary_element", Level.WARNING, getTagName(node));

                    if (node.is(TagId.LAYER))
                    {
                        lexer.badLayout |= USING_LAYER;
                    }
                    else if (node.is(TagId.SPACER))
                    {
                        lexer.badLayout |= USING_SPACER;
                    }
                    else if (node.is(TagId.NOBR))
                    {
                        lexer.badLayout |= USING_NOBR;
                    }
                    break;

                case OBSOLETE_ELEMENT :
                    if (element.tag != null && (element.tag.model & Dict.CM_OBSOLETE) != 0)
                    {
                        printMessage(code, lexer, "obsolete_element", Level.WARNING, 
							    getTagName(element),
							    getTagName(node));
                    }
                    else
                    {
                        printMessage(code, lexer, "replacing_element", Level.WARNING, 
							    getTagName(element),
							    getTagName(node));
                    }
                    break;

                case UNESCAPED_ELEMENT :
                    printMessage(code, lexer, "unescaped_element", Level.WARNING, getTagName(element));
                    break;

                case TRIM_EMPTY_ELEMENT :
                    printMessage(code, lexer, "trim_empty_element", Level.WARNING, getTagName(element));
                    break;

                case MISSING_TITLE_ELEMENT :
                    printMessage(code, lexer, "missing_title_element", Level.WARNING);
                    break;

                case ILLEGAL_NESTING :
                    printMessage(code, lexer, "illegal_nesting", Level.WARNING, getTagName(element));
                    break;

                case NOFRAMES_CONTENT :
                    printMessage(code, lexer, "noframes_content", Level.WARNING, getTagName(node));
                    break;

                case INCONSISTENT_VERSION :
                    printMessage(code, lexer, "inconsistent_version", Level.WARNING);
                    break;

                case MALFORMED_DOCTYPE :
                    printMessage(code, lexer, "malformed_doctype", Level.WARNING);
                    break;

                case CONTENT_AFTER_BODY :
                    printMessage(code, lexer, "content_after_body", Level.WARNING);
                    break;

                case MALFORMED_COMMENT :
                    printMessage(code, lexer, "malformed_comment", Level.WARNING);
                    break;

                case BAD_COMMENT_CHARS :
                    printMessage(code, lexer, "bad_comment_chars", Level.WARNING);
                    break;

                case BAD_XML_COMMENT :
                    printMessage(code, lexer, "bad_xml_comment", Level.WARNING);
                    break;

                case BAD_CDATA_CONTENT :
                    printMessage(code, lexer, "bad_cdata_content", Level.WARNING);
                    break;

                case INCONSISTENT_NAMESPACE :
                    printMessage(code, lexer, "inconsistent_namespace", Level.WARNING);
                    break;

                case DTYPE_NOT_UPPER_CASE :
                    printMessage(code, lexer, "dtype_not_upper_case", Level.WARNING);
                    break;

                case UNEXPECTED_END_OF_FILE :
                    // on end of file adjust reported position to end of input
                    lexer.lines = lexer.in.getCurline();
                    lexer.columns = lexer.in.getCurcol();
                    printMessage(
                        code,
                        lexer,
                        "unexpected_end_of_file",
                        Level.WARNING,
                        getTagName(element));
                    break;

                case NESTED_QUOTATION :
                    printMessage(code, lexer, "nested_quotation", Level.WARNING);
                    break;

                case ELEMENT_NOT_EMPTY :
                    printMessage(code, lexer, "element_not_empty", Level.WARNING, getTagName(element));
                    break;

                case MISSING_DOCTYPE :
                    printMessage(code, lexer, "missing_doctype", Level.WARNING);
                    break;

                default :
                    break;
            }
        }

        if ((code == DISCARDING_UNEXPECTED) && lexer.badForm != 0)
        {
            // the case for when this is a warning not an error, is handled earlier
            printMessage(code, lexer, "discarding_unexpected", Level.ERROR, getTagName(node));
        }

    }

    /**
     * Prints errors.
     * @param lexer Lexer
     * @param element parent/missing tag
     * @param node current tag
     * @param code error code
     */
    public void error(Lexer lexer, Node element, Node node, ErrorCode code)
    {
        lexer.errors++;

        // keep quiet after <showErrors> errors
        if (lexer.errors > lexer.configuration.getShowErrors())
        {
            return;
        }

        switch (code) {
        case SUSPECTED_MISSING_QUOTE:
            printMessage(code, lexer, "suspected_missing_quote", Level.ERROR);
            break;
        case DUPLICATE_FRAMESET:
            printMessage(code, lexer, "duplicate_frameset", Level.ERROR);
            break;
        case UNKNOWN_ELEMENT:
            printMessage(code, lexer, "unknown_element", Level.ERROR, getTagName(node));
            break;
        case UNEXPECTED_ENDTAG:
            if (element != null)
            {
                printMessage(
                    code,
                    lexer,
                    "unexpected_endtag_in",
                    Level.ERROR,
                    node.element, element.element);
            }
            else
            {
                printMessage(code, lexer, "unexpected_endtag", Level.ERROR, node.element);
            }
            break;
        }
    }

    /**
     * Prints error summary.
     * @param lexer Lexer
     */
    public void errorSummary(Lexer lexer)
    {
        // adjust badAccess to that its null if frames are ok
        if ((lexer.badAccess & (USING_FRAMES | USING_NOFRAMES)) != 0)
        {
            if (!(((lexer.badAccess & USING_FRAMES) != 0) && ((lexer.badAccess & USING_NOFRAMES) == 0)))
            {
                lexer.badAccess &= ~(USING_FRAMES | USING_NOFRAMES);
            }
        }
        if (lexer.badChars != 0)
        {
            if ((lexer.badChars & BC_VENDOR_SPECIFIC_CHARS) != 0)
            {
                int encodingChoiche = 0;

                if ("Cp1252".equals(lexer.configuration.getInCharEncodingName()))
                {
                    encodingChoiche = 1;
                }
                else if ("MacRoman".equals(lexer.configuration.getInCharEncodingName()))
                {
                    encodingChoiche = 2;
                }

                printMessage(VENDOR_SPECIFIC_CHARS, lexer, "vendor_specific_chars_summary", null, new Integer(
					    encodingChoiche));
            }

            if ((lexer.badChars & BC_INVALID_SGML_CHARS) != 0 || (lexer.badChars & BC_INVALID_NCR) != 0)
            {
                int encodingChoiche = 0;

                if ("Cp1252".equals(lexer.configuration.getInCharEncodingName()))
                {
                    encodingChoiche = 1;
                }
                else if ("MacRoman".equals(lexer.configuration.getInCharEncodingName()))
                {
                    encodingChoiche = 2;
                }

                printMessage(INVALID_SGML_CHARS, lexer, "invalid_sgml_chars_summary", null, new Integer(
					    encodingChoiche));
            }

            if ((lexer.badChars & BC_INVALID_UTF8) != 0)
            {
                printMessage(INVALID_UTF8, lexer, "invalid_utf8_summary", null);
            }

            if ((lexer.badChars & BC_INVALID_UTF16) != 0)
            {
                printMessage(INVALID_UTF16, lexer, "invalid_utf16_summary", null);
            }

            if ((lexer.badChars & BC_INVALID_URI) != 0)
            {
                printMessage(INVALID_URI, lexer, "invaliduri_summary", null);
            }
        }

        if (lexer.badForm != 0)
        {
            printMessage(BADFORM_SUMMARY, lexer, "badform_summary", null);
        }

        if (lexer.badAccess != 0)
        {
            if ((lexer.badAccess & MISSING_SUMMARY) != 0)
            {
                printMessage(MISSING_SUMMARY, lexer, "badaccess_missing_summary", null);
            }

            if ((lexer.badAccess & MISSING_IMAGE_ALT) != 0)
            {
                printMessage(MISSING_IMAGE_ALT, lexer, "badaccess_missing_image_alt", null);
            }

            if ((lexer.badAccess & MISSING_IMAGE_MAP) != 0)
            {
                printMessage(MISSING_IMAGE_MAP, lexer, "badaccess_missing_image_map", null);
            }

            if ((lexer.badAccess & MISSING_LINK_ALT) != 0)
            {
                printMessage(MISSING_LINK_ALT, lexer, "badaccess_missing_link_alt", null);
            }

            if (((lexer.badAccess & USING_FRAMES) != 0) && ((lexer.badAccess & USING_NOFRAMES) == 0))
            {
                printMessage(USING_FRAMES, lexer, "badaccess_frames", null);
            }

            printMessage(BADACCESS_SUMMARY, lexer, "badaccess_summary", null, ACCESS_URL);
        }

        if (lexer.badLayout != 0)
        {
            if ((lexer.badLayout & USING_LAYER) != 0)
            {
                printMessage(USING_LAYER, lexer, "badlayout_using_layer", null);
            }

            if ((lexer.badLayout & USING_SPACER) != 0)
            {
                printMessage(USING_SPACER, lexer, "badlayout_using_spacer", null);
            }

            if ((lexer.badLayout & USING_FONT) != 0)
            {
                printMessage(USING_FONT, lexer, "badlayout_using_font", null);
            }

            if ((lexer.badLayout & USING_NOBR) != 0)
            {
                printMessage(USING_NOBR, lexer, "badlayout_using_nobr", null);
            }

            if ((lexer.badLayout & USING_BODY) != 0)
            {
                printMessage(USING_BODY, lexer, "badlayout_using_body", null);
            }
        }
    }

    /**
     * Prints the "unknown option" message.
     * @param errout PrintWriter
     * @param c invalid option char
     */
    public void unknownOption(PrintWriter errout, char c)
    {
        printMessage(errout, "unrecognized_option", Level.ERROR, new String(new char[]{c}));
    }

    /**
     * Prints the "unknown file" message.
     * @param errout PrintWriter
     * @param file invalid file name
     */
    public void unknownFile(PrintWriter errout, String file)
    {
        printMessage(errout, "unknown_file", Level.ERROR, "Tidy", file);
    }

    /**
     * Prints the "needs author intervention" message.
     * @param errout PrintWriter
     */
    public void needsAuthorIntervention(PrintWriter errout)
    {
        printMessage(errout, "needs_author_intervention", null);
    }

    /**
     * Prints the "missing body" message.
     * @param errout PrintWriter
     */
    public void missingBody(PrintWriter errout)
    {
        printMessage(errout, "missing_body", Level.ERROR);
    }

    /**
     * Prints the number of generated slides.
     * @param errout PrintWriter
     * @param count slides count
     */
    public void reportNumberOfSlides(PrintWriter errout, int count)
    {
        printMessage(errout, "slides_found", null, new Integer(count));
    }

    /**
     * Prints tidy general info.
     * @param errout PrintWriter
     */
    public void generalInfo(PrintWriter errout)
    {
        printMessage(errout, "general_info", null);
    }

    /**
     * Sets the current file name.
     * @param filename current file.
     */
    public void setFilename(String filename)
    {
        this.currentFile = filename; // for use with Gnu Emacs
    }

    /**
     * Prints information for html version in input file.
     * @param errout PrintWriter
     * @param lexer Lexer
     * @param filename file name
     * @param doctype doctype Node
     */
    public void reportVersion(PrintWriter errout, Lexer lexer, String filename, Node doctype)
    {
        int i, c;
        int state = 0;
        int apparentVers = lexer.apparentVersion();
        String vers = Lexer.getNameFromVers(apparentVers);
        int[] cc = new int[1];

        // adjust reported position to first line
        lexer.lines = 1;
        lexer.columns = 1;

        if (doctype != null)
        {

            StringBuffer doctypeBuffer = new StringBuffer();
            for (i = doctype.start; i < doctype.end; ++i)
            {
                c = doctype.textarray[i];

                // look for UTF-8 multibyte character
                if (c < 0)
                {
                    i += PPrint.getUTF8(doctype.textarray, i, cc);
                    c = cc[0];
                }

                if (c == '"')
                {
                    ++state;
                }
                else if (state == 1)
                {
                    doctypeBuffer.append((char) c);
                }
            }

            simpleMessage(
                DOCTYPE_GIVEN_SUMMARY.code(),
                lexer,
                "doctype_given",
                Level.INFO,
                doctypeBuffer);
        }

        simpleMessage(REPORT_VERSION_SUMMARY.code(), lexer, "report_version", Level.INFO, 
			    (vers != null ? vers : "HTML Proprietary"));
        if (lexer.warnMissingSIInEmittedDocType()) {
        	simpleMessage(-1, lexer, "no_si", Level.INFO);
        }
    }

    /**
     * Prints the number of error/warnings found.
     * @param errout PrintWriter
     * @param lexer Lexer
     */
    public void reportNumWarnings(PrintWriter errout, Lexer lexer)
    {
        if (lexer.warnings > 0 || lexer.errors > 0)
        {
            printMessage(
                errout,
                "num_warnings",
                null,
                new Integer(lexer.warnings), new Integer(lexer.errors));
        }
        else
        {
            printMessage(errout, "no_warnings", null);
        }
    }

    /**
     * Prints tidy help.
     * @param out PrintWriter
     */
    public void helpText(PrintWriter out)
    {
        printMessage(out, "help_text", null, "Tidy", RELEASE_DATE_STRING);
    }

    /**
     * Prints the "bad tree" message.
     * @param errout PrintWriter
     */
    public void badTree(PrintWriter errout)
    {
        printMessage(errout, "bad_tree", Level.ERROR);
    }

    /**
     * Adds a message listener.
     * @param listener TidyMessageListener
     */
    public void addMessageListener(TidyMessageListener listener)
    {
        this.listener = listener;
    }
}