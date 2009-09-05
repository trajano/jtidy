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

import org.w3c.tidy.Node.NodeType;
import org.w3c.tidy.Options.TriState;

/**
 * Pretty print parse tree. Block-level and unknown elements are printed on new lines and their contents indented 2
 * spaces Inline elements are printed inline. Inline content is wrapped on spaces (except in attribute values or
 * preformatted text, after start tags and before end tags.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public class PPrint
{

    /**
     * position: normal.
     */
    private static final short NORMAL = 0;

    /**
     * position: preformatted text.
     */
    private static final short PREFORMATTED = 1;

    /**
     * position: comment.
     */
    private static final short COMMENT = 2;

    /**
     * position: attribute value.
     */
    private static final short ATTRIBVALUE = 4;

    /**
     * position: nowrap.
     */
    private static final short NOWRAP = 8;

    /**
     * position: cdata.
     */
    private static final short CDATA = 16;

    /**
     * Start cdata token.
     */
    private static final String CDATA_START = "<![CDATA[";

    /**
     * End cdata token.
     */
    private static final String CDATA_END = "]]>";

    /**
     * Javascript comment start.
     */
    private static final String JS_COMMENT_START = "//";

    /**
     * Javascript comment end.
     */
    private static final String JS_COMMENT_END = "";

    /**
     * VB comment start.
     */
    private static final String VB_COMMENT_START = "\'";

    /**
     * VB comment end.
     */
    private static final String VB_COMMENT_END = "";

    /**
     * CSS comment start.
     */
    private static final String CSS_COMMENT_START = "/*";

    /**
     * CSS comment end.
     */
    private static final String CSS_COMMENT_END = "*/";

    /**
     * Default comment start.
     */
    private static final String DEFAULT_COMMENT_START = "";

    /**
     * Default comment end.
     */
    private static final String DEFAULT_COMMENT_END = "";

    private int[] linebuf;

    private int lbufsize;

    private int linelen;

    private int wraphere;

    private boolean inAttVal;

    private boolean inString;

    /**
     * current configuration.
     */
    private Configuration configuration;

    /**
     * Instantiates a new PPrint.
     * @param configuration configuration
     */
    public PPrint(Configuration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * @param ind
     * @return
     */
    int cWrapLen(int ind)
    {
        /* #431953 - start RJ Wraplen adjusted for smooth international ride */
        if ("zh".equals(this.configuration.getLanguage()))
        {
            // Chinese characters take two positions on a fixed-width screen
            // It would be more accurate to keep a parallel linelen and wraphere incremented by 2 for Chinese characters
            // and 1 otherwise, but this is way simpler.
            return (ind + ((this.configuration.getWraplen() - ind) / 2));
        }
        if ("ja".equals(this.configuration.getLanguage()))
        {
            /* average Japanese text is 30% kanji */
            return (ind + (((this.configuration.getWraplen() - ind) * 7) / 10));
        }
        return (this.configuration.getWraplen());
        /* #431953 - end RJ */
    }

    /**
     * return one less than the number of bytes used by the UTF-8 byte sequence. The Unicode char is returned in ch.
     * @param str points to the UTF-8 byte sequence
     * @param start starting offset in str
     * @param ch initialized to 1st byte, passed as an array to allow modification
     * @return one less that the number of bytes used by UTF-8 char
     */
    public static int getUTF8(byte[] str, int start, int[] ch)
    {

        int[] n = new int[1];

        int[] bytes = new int[]{0};

        // first byte "str[0]" is passed in separately from the
        // rest of the UTF-8 byte sequence starting at "str[1]"
        byte[] successorBytes = str;

        boolean err = EncodingUtils.decodeUTF8BytesToChar(
            n,
            TidyUtils.toUnsigned(str[start]),
            successorBytes,
            null,
            bytes,
            start + 1);

        if (err)
        {
            n[0] = 0xFFFD; // replacement char
        }
        ch[0] = n[0];
        return bytes[0] - 1;

    }

    /**
     * store char c as UTF-8 encoded byte stream.
     * @param buf
     * @param start
     * @param c
     * @return
     */
    public static int putUTF8(byte[] buf, int start, int c)
    {
        int[] count = new int[]{0};

        boolean err = EncodingUtils.encodeCharToUTF8Bytes(c, buf, null, count);
        if (err)
        {
            // replacement char 0xFFFD encoded as UTF-8
            buf[0] = (byte) 0xEF;
            buf[1] = (byte) 0xBF;
            buf[2] = (byte) 0xBD;
            count[0] = 3;
        }

        start += count[0];

        return start;
    }

    private void addC(int c, int index)
    {
        if (index + 1 >= lbufsize)
        {
            while (index + 1 >= lbufsize)
            {
                if (lbufsize == 0)
                {
                    lbufsize = 256;
                }
                else
                {
                    lbufsize = lbufsize * 2;
                }
            }

            int[] temp = new int[lbufsize];
            if (linebuf != null)
            {
                System.arraycopy(linebuf, 0, temp, 0, index);
            }
            linebuf = temp;
        }

        linebuf[index] = c;
    }

    /**
     * Adds an ascii String.
     * @param str String to be added
     * @param index actual line lenght
     * @return final line length
     */
    private int addAsciiString(String str, int index)
    {

        int len = str.length();
        if (index + len >= lbufsize)
        {
            while (index + len >= lbufsize)
            {
                if (lbufsize == 0)
                {
                    lbufsize = 256;
                }
                else
                {
                    lbufsize = lbufsize * 2;
                }
            }

            int[] temp = new int[lbufsize];
            if (linebuf != null)
            {
                System.arraycopy(linebuf, 0, temp, 0, index);
            }
            linebuf = temp;
        }

        for (int ix = 0; ix < len; ++ix)
        {
            linebuf[index + ix] = str.charAt(ix);
        }
        return index + len;
    }

    /**
     * @param fout
     * @param indent
     */
    private void wrapLine(Out fout, int indent)
    {
        int i, p, q;

        if (wraphere == 0)
        {
            return;
        }

        for (i = 0; i < indent; ++i)
        {
            fout.outc(' ');
        }

        for (i = 0; i < wraphere; ++i)
        {
            fout.outc(linebuf[i]);
        }

        if (inString)
        {
            fout.outc(' ');
            fout.outc('\\');
        }

        fout.newline();

        if (linelen > wraphere)
        {
            p = 0;

            if (linebuf[wraphere] == ' ')
            {
                ++wraphere;
            }

            q = wraphere;
            addC('\0', linelen);

            while (true)
            {
                linebuf[p] = linebuf[q];
                if (linebuf[q] == 0)
                {
                    break;
                }
                p++;
                q++;
            }
            linelen -= wraphere;
        }
        else
        {
            linelen = 0;
        }

        wraphere = 0;
    }

    /**
     * @param fout
     * @param indent
     * @param inString
     */
    private void wrapAttrVal(Out fout, int indent, boolean inString)
    {
        int i, p, q;

        for (i = 0; i < indent; ++i)
        {
            fout.outc(' ');
        }

        for (i = 0; i < wraphere; ++i)
        {
            fout.outc(linebuf[i]);
        }

        fout.outc(' ');

        if (inString)
        {
            fout.outc('\\');
        }

        fout.newline();

        if (linelen > wraphere)
        {
            p = 0;

            if (linebuf[wraphere] == ' ')
            {
                ++wraphere;
            }

            q = wraphere;
            addC('\0', linelen);

            while (true)
            {
                linebuf[p] = linebuf[q];
                if (linebuf[q] == 0)
                {
                    break;
                }
                p++;
                q++;
            }
            linelen -= wraphere;
        }
        else
        {
            linelen = 0;
        }

        wraphere = 0;
    }

    /**
     * @param fout
     * @param indent
     */
    public void flushLine(Out fout, int indent)
    {
        int i;

        if (linelen > 0)
        {
            if (indent + linelen >= this.configuration.getWraplen())
            {
                wrapLine(fout, indent);
            }

            if (!inAttVal || this.configuration.isIndentAttributes())
            {
                for (i = 0; i < indent; ++i)
                {
                    fout.outc(' ');
                }
            }

            for (i = 0; i < linelen; ++i)
            {
                fout.outc(linebuf[i]);
            }
        }

        fout.newline();
        linelen = 0;
        wraphere = 0;
        inAttVal = false;
    }

    /**
     * @param fout
     * @param indent
     */
    public void condFlushLine(Out fout, int indent)
    {
        int i;

        if (linelen > 0)
        {
            if (indent + linelen >= this.configuration.getWraplen())
            {
                wrapLine(fout, indent);
            }

            if (!inAttVal || this.configuration.isIndentAttributes())
            {
                for (i = 0; i < indent; ++i)
                {
                    fout.outc(' ');
                }
            }

            for (i = 0; i < linelen; ++i)
            {
                fout.outc(linebuf[i]);
            }

            fout.newline();
            linelen = 0;
            wraphere = 0;
            inAttVal = false;
        }
    }

    /**
     * @param c
     * @param mode
     */
    private void printChar(int c, short mode)
    {
        String entity;
        boolean breakable = false; // #431953 - RJ

        if (c == ' ' && !TidyUtils.toBoolean(mode & (PREFORMATTED | COMMENT | ATTRIBVALUE | CDATA)))
        {
            // coerce a space character to a non-breaking space
            if (TidyUtils.toBoolean(mode & NOWRAP))
            {
                // by default XML doesn't define &nbsp;
                if (this.configuration.isNumEntities() || this.configuration.isXmlTags())
                {
                    addC('&', linelen++);
                    addC('#', linelen++);
                    addC('1', linelen++);
                    addC('6', linelen++);
                    addC('0', linelen++);
                    addC(';', linelen++);
                }
                else
                {
                    // otherwise use named entity
                    addC('&', linelen++);
                    addC('n', linelen++);
                    addC('b', linelen++);
                    addC('s', linelen++);
                    addC('p', linelen++);
                    addC(';', linelen++);
                }
                return;
            }
            wraphere = linelen;
        }

        // comment characters are passed raw
        if (TidyUtils.toBoolean(mode & (COMMENT | CDATA)))
        {
            addC(c, linelen++);
            return;
        }

        // except in CDATA map < to &lt; etc.
        if (!TidyUtils.toBoolean(mode & CDATA))
        {
            if (c == '<')
            {
                addC('&', linelen++);
                addC('l', linelen++);
                addC('t', linelen++);
                addC(';', linelen++);
                return;
            }

            if (c == '>')
            {
                addC('&', linelen++);
                addC('g', linelen++);
                addC('t', linelen++);
                addC(';', linelen++);
                return;
            }

            // naked '&' chars can be left alone or quoted as &amp;
            // The latter is required for XML where naked '&' are illegal.
            if (c == '&' && this.configuration.isQuoteAmpersand())
            {
                addC('&', linelen++);
                addC('a', linelen++);
                addC('m', linelen++);
                addC('p', linelen++);
                addC(';', linelen++);
                return;
            }

            if (c == '"' && this.configuration.isQuoteMarks())
            {
                addC('&', linelen++);
                addC('q', linelen++);
                addC('u', linelen++);
                addC('o', linelen++);
                addC('t', linelen++);
                addC(';', linelen++);
                return;
            }

            if (c == '\'' && this.configuration.isQuoteMarks())
            {
                addC('&', linelen++);
                addC('#', linelen++);
                addC('3', linelen++);
                addC('9', linelen++);
                addC(';', linelen++);
                return;
            }

            if (c == 160 && !this.configuration.isRawOut())
            {
                if (this.configuration.isMakeBare())
                {
                    addC(' ', linelen++);
                }
                else if (this.configuration.isQuoteNbsp())
                {
                    addC('&', linelen++);

                    if (this.configuration.isNumEntities() || this.configuration.isXmlTags())
                    {
                        addC('#', linelen++);
                        addC('1', linelen++);
                        addC('6', linelen++);
                        addC('0', linelen++);
                    }
                    else
                    {
                        addC('n', linelen++);
                        addC('b', linelen++);
                        addC('s', linelen++);
                        addC('p', linelen++);
                    }

                    addC(';', linelen++);
                }
                else
                {
                    addC(c, linelen++);
                }

                return;
            }
        }

        // #431953 - start RJ
        // Handle encoding-specific issues

        if ("UTF8".equals(this.configuration.getOutCharEncodingName()))
        {
            // Chinese doesn't have spaces, so it needs other kinds of breaks
            // This will also help documents using nice Unicode punctuation
            // But we leave the ASCII range punctuation untouched

            // Break after any punctuation or spaces characters
            if ((c >= 0x2000) && !TidyUtils.toBoolean(mode & PREFORMATTED))
            {
                if (((c >= 0x2000) && (c <= 0x2006))
                    || ((c >= 0x2008) && (c <= 0x2010))
                    || ((c >= 0x2011) && (c <= 0x2046))
                    || ((c >= 0x207D) && (c <= 0x207E))
                    || ((c >= 0x208D) && (c <= 0x208E))
                    || ((c >= 0x2329) && (c <= 0x232A))
                    || ((c >= 0x3001) && (c <= 0x3003))
                    || ((c >= 0x3008) && (c <= 0x3011))
                    || ((c >= 0x3014) && (c <= 0x301F))
                    || ((c >= 0xFD3E) && (c <= 0xFD3F))
                    || ((c >= 0xFE30) && (c <= 0xFE44))
                    || ((c >= 0xFE49) && (c <= 0xFE52))
                    || ((c >= 0xFE54) && (c <= 0xFE61))
                    || ((c >= 0xFE6A) && (c <= 0xFE6B))
                    || ((c >= 0xFF01) && (c <= 0xFF03))
                    || ((c >= 0xFF05) && (c <= 0xFF0A))
                    || ((c >= 0xFF0C) && (c <= 0xFF0F))
                    || ((c >= 0xFF1A) && (c <= 0xFF1B))
                    || ((c >= 0xFF1F) && (c <= 0xFF20))
                    || ((c >= 0xFF3B) && (c <= 0xFF3D))
                    || ((c >= 0xFF61) && (c <= 0xFF65)))
                {
                    wraphere = linelen + 2; // 2, because AddChar is not till later
                    breakable = true;
                }
                else
                {
                    switch (c)
                    {
                        case 0xFE63 :
                        case 0xFE68 :
                        case 0x3030 :
                        case 0x30FB :
                        case 0xFF3F :
                        case 0xFF5B :
                        case 0xFF5D :
                            wraphere = linelen + 2;
                            breakable = true;
                    }
                }
                // but break before a left punctuation
                if (breakable)
                {
                    if (((c >= 0x201A) && (c <= 0x201C)) || ((c >= 0x201E) && (c <= 0x201F)))
                    {
                        wraphere--;
                    }
                    else
                    {
                        switch (c)
                        {
                            case 0x2018 :
                            case 0x2039 :
                            case 0x2045 :
                            case 0x207D :
                            case 0x208D :
                            case 0x2329 :
                            case 0x3008 :
                            case 0x300A :
                            case 0x300C :
                            case 0x300E :
                            case 0x3010 :
                            case 0x3014 :
                            case 0x3016 :
                            case 0x3018 :
                            case 0x301A :
                            case 0x301D :
                            case 0xFD3E :
                            case 0xFE35 :
                            case 0xFE37 :
                            case 0xFE39 :
                            case 0xFE3B :
                            case 0xFE3D :
                            case 0xFE3F :
                            case 0xFE41 :
                            case 0xFE43 :
                            case 0xFE59 :
                            case 0xFE5B :
                            case 0xFE5D :
                            case 0xFF08 :
                            case 0xFF3B :
                            case 0xFF5B :
                            case 0xFF62 :
                                wraphere--;
                        }
                    }
                }
            }
            else if ("BIG5".equals(this.configuration.getOutCharEncodingName()))
            {
                // Allow linebreak at Chinese punctuation characters
                // There are not many spaces in Chinese
                addC(c, linelen++);
                if (((c & 0xFF00) == 0xA100) && !TidyUtils.toBoolean(mode & PREFORMATTED))
                {
                    wraphere = linelen;
                    // opening brackets have odd codes: break before them
                    if ((c > 0x5C) && (c < 0xAD) && ((c & 1) == 1))
                    {
                        wraphere--;
                    }
                }
                return;
            }
            else if ("SHIFTJIS".equals(this.configuration.getOutCharEncodingName())
                || "ISO2022".equals(this.configuration.getOutCharEncodingName()))
            {
                // ISO 2022 characters are passed raw
                addC(c, linelen++);
                return;
            }
            else
            {
                if (this.configuration.isRawOut())
                {
                    addC(c, linelen++);
                    return;
                }
            }
            // #431953 - end RJ
        }

        // if preformatted text, map &nbsp; to space
        if (c == 160 && TidyUtils.toBoolean(mode & PREFORMATTED))
        {
            addC(' ', linelen++);
            return;
        }

        // Filters from Word and PowerPoint often use smart quotes resulting in character codes between 128 and 159.
        // Unfortunately, the corresponding HTML 4.0 entities for these are not widely supported.
        // The following converts dashes and quotation marks to the nearest ASCII equivalent.
        // My thanks to Andrzej Novosiolov for his help with this code.

        if (this.configuration.isMakeClean() && this.configuration.isAsciiChars() || this.configuration.isMakeBare())
        {
            if (c >= 0x2013 && c <= 0x201E)
            {
                switch (c)
                {
                    case 0x2013 : // en dash
                    case 0x2014 : // em dash
                        c = '-';
                        break;
                    case 0x2018 : // left single quotation mark
                    case 0x2019 : // right single quotation mark
                    case 0x201A : // single low-9 quotation mark
                        c = '\'';
                        break;
                    case 0x201C : // left double quotation mark
                    case 0x201D : // right double quotation mark
                    case 0x201E : // double low-9 quotation mark
                        c = '"';
                        break;
                }
            }
        }

        // don't map latin-1 chars to entities
        if ("ISO8859_1".equals(this.configuration.getOutCharEncodingName()))
        {
            if (c > 255) /* multi byte chars */
            {
                if (!this.configuration.isNumEntities())
                {
                    entity = EntityTable.getDefaultEntityTable().entityName((short) c);
                    if (entity != null)
                    {
                        entity = "&" + entity + ";";
                    }
                    else
                    {
                        entity = "&#" + c + ";";
                    }
                }
                else
                {
                    entity = "&#" + c + ";";
                }

                for (int i = 0; i < entity.length(); i++)
                {
                    addC(entity.charAt(i), linelen++);
                }

                return;
            }

            if (c > 126 && c < 160)
            {
                entity = "&#" + c + ";";

                for (int i = 0; i < entity.length(); i++)
                {
                    addC(entity.charAt(i), linelen++);
                }

                return;
            }

            addC(c, linelen++);
            return;
        }

        // don't map utf8 or utf16 chars to entities
        if (this.configuration.getOutCharEncodingName().startsWith("UTF"))
        {
            addC(c, linelen++);
            return;
        }

        // use numeric entities only for XML
        if (this.configuration.isXmlTags())
        {
            // if ASCII use numeric entities for chars > 127
            if (c > 127 && "ASCII".equals(this.configuration.getOutCharEncodingName()))
            {
                entity = "&#" + c + ";";

                for (int i = 0; i < entity.length(); i++)
                {
                    addC(entity.charAt(i), linelen++);
                }

                return;
            }

            // otherwise output char raw
            addC(c, linelen++);
            return;
        }

        // default treatment for ASCII
        if ("ASCII".equals(this.configuration.getOutCharEncodingName()) && (c > 126 || (c < ' ' && c != '\t')))
        {
            if (!this.configuration.isNumEntities())
            {
                entity = EntityTable.getDefaultEntityTable().entityName((short) c);
                if (entity != null)
                {
                    entity = "&" + entity + ";";
                }
                else
                {
                    entity = "&#" + c + ";";
                }
            }
            else
            {
                entity = "&#" + c + ";";
            }

            for (int i = 0; i < entity.length(); i++)
            {
                addC(entity.charAt(i), linelen++);
            }

            return;
        }

        addC(c, linelen++);
    }

    /**
     * The line buffer is uint not char so we can hold Unicode values unencoded. The translation to UTF-8 is deferred to
     * the outc routine called to flush the line buffer.
     * @param fout
     * @param mode
     * @param indent
     * @param textarray
     * @param start
     * @param end
     */
    private void printText(Out fout, short mode, int indent, byte[] textarray, int start, int end)
    {
        int i, c;
        int[] ci = new int[1];

        for (i = start; i < end; ++i)
        {
            if (indent + linelen >= this.configuration.getWraplen())
            {
                wrapLine(fout, indent);
            }

            c = (textarray[i]) & 0xFF; // Convert to unsigned.

            // look for UTF-8 multibyte character
            if (c > 0x7F)
            {
                i += getUTF8(textarray, i, ci);
                c = ci[0];
            }

            if (c == '\n')
            {
                flushLine(fout, indent);
                continue;
            }

            printChar(c, mode);
        }
    }

    /**
     * @param fout
     * @param indent
     * @param value
     * @param delim
     * @param wrappable
     */
    private void printAttrValue(Out fout, int indent, String value, int delim, boolean wrappable)
    {
        int c;
        int[] ci = new int[1];
        boolean wasinstring = false;
        byte[] valueChars = null;
        int i;
        short mode = (wrappable ? (short) (NORMAL | ATTRIBVALUE) : (short) (PREFORMATTED | ATTRIBVALUE));

        if (value != null)
        {
            valueChars = TidyUtils.getBytes(value);
        }

        // look for ASP, Tango or PHP instructions for computed attribute value
        if (valueChars != null && valueChars.length >= 5 && valueChars[0] == '<')
        {
            if (valueChars[1] == '%' || valueChars[1] == '@' || (new String(valueChars, 0, 5)).equals("<?php"))
            {
                mode |= CDATA;
            }
        }

        if (delim == 0)
        {
            delim = '"';
        }

        addC('=', linelen++);

        // don't wrap after "=" for xml documents
        if (!this.configuration.isXmlOut())
        {

            if (indent + linelen < this.configuration.getWraplen())
            {
                wraphere = linelen;
            }

            if (indent + linelen >= this.configuration.getWraplen())
            {
                wrapLine(fout, indent);
            }

            if (indent + linelen < this.configuration.getWraplen())
            {
                wraphere = linelen;
            }
            else
            {
                condFlushLine(fout, indent);
            }
        }

        addC(delim, linelen++);

        if (value != null)
        {
            inString = false;

            i = 0;
            while (i < valueChars.length)
            {
                c = (valueChars[i]) & 0xFF; // Convert to unsigned.

                if (wrappable && c == ' ' && indent + linelen < this.configuration.getWraplen())
                {
                    wraphere = linelen;
                    wasinstring = inString;
                }

                if (wrappable && wraphere > 0 && indent + linelen >= this.configuration.getWraplen())
                {
                    wrapAttrVal(fout, indent, wasinstring);
                }

                if (c == delim)
                {
                    String entity;

                    entity = (c == '"' ? "&quot;" : "&#39;");

                    for (int j = 0; j < entity.length(); j++)
                    {
                        addC(entity.charAt(j), linelen++);
                    }

                    ++i;
                    continue;
                }
                else if (c == '"')
                {
                    if (this.configuration.isQuoteMarks())
                    {
                        addC('&', linelen++);
                        addC('q', linelen++);
                        addC('u', linelen++);
                        addC('o', linelen++);
                        addC('t', linelen++);
                        addC(';', linelen++);
                    }
                    else
                    {
                        addC('"', linelen++);
                    }

                    if (delim == '\'')
                    {
                        inString = !inString;
                    }

                    ++i;
                    continue;
                }
                else if (c == '\'')
                {
                    if (this.configuration.isQuoteMarks())
                    {
                        addC('&', linelen++);
                        addC('#', linelen++);
                        addC('3', linelen++);
                        addC('9', linelen++);
                        addC(';', linelen++);
                    }
                    else
                    {
                        addC('\'', linelen++);
                    }

                    if (delim == '"')
                    {
                        inString = !inString;
                    }

                    ++i;
                    continue;
                }

                // look for UTF-8 multibyte character
                if (c > 0x7F)
                {
                    i += getUTF8(valueChars, i, ci);
                    c = ci[0];
                }

                ++i;

                if (c == '\n')
                {
                    flushLine(fout, indent);
                    continue;
                }

                printChar(c, mode);
            }
        }

        inString = false;
        addC(delim, linelen++);
    }

    /**
     * @param fout
     * @param indent
     * @param node
     * @param attr
     */
    private void printAttribute(Out fout, int indent, Node node, AttVal attr)
    {
        String name;
        boolean wrappable = false;

        if (this.configuration.isIndentAttributes())
        {
            flushLine(fout, indent);
            indent += this.configuration.getSpaces();
        }

        name = attr.attribute;

        if (indent + linelen >= this.configuration.getWraplen())
        {
            wrapLine(fout, indent);
        }

        if (!this.configuration.isXmlTags() && !this.configuration.isXmlOut() && attr.dict != null)
        {
            if (AttributeTable.getDefaultAttributeTable().isScript(name))
            {
                wrappable = this.configuration.isWrapScriptlets();
            }
            else if (!attr.dict.isNowrap() && this.configuration.isWrapAttVals())
            {
                wrappable = true;
            }
        }

        if (indent + linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
            addC(' ', linelen++);
        }
        else
        {
            condFlushLine(fout, indent);
            addC(' ', linelen++);
        }

        for (int i = 0; i < name.length(); i++)
        {
            addC(
                TidyUtils.foldCase(name.charAt(i), this.configuration.isUpperCaseAttrs(), this.configuration.isXmlTags()),
                linelen++);
        }

        if (indent + linelen >= this.configuration.getWraplen())
        {
            wrapLine(fout, indent);
        }

        if (attr.value == null)
        {
            if (this.configuration.isXmlTags() || this.configuration.isXmlOut())
            {
                printAttrValue(fout, indent, (attr.isBoolAttribute() ? attr.attribute : ""), attr.delim, true);
            }
            else if (!attr.isBoolAttribute() && node != null && !node.isNewNode())
            {
                printAttrValue(fout, indent, "", attr.delim, true);
            }
            else if (indent + linelen < this.configuration.getWraplen())
            {
                wraphere = linelen;
            }

        }
        else
        {
            printAttrValue(fout, indent, attr.value, attr.delim, wrappable);
        }
    }

    /**
     * @param fout
     * @param indent
     * @param node
     * @param attr
     */
    private void printAttrs(Out fout, int indent, Node node, AttVal attr)
    {
        // add xml:space attribute to pre and other elements
        if (configuration.isXmlOut()
            && configuration.isXmlSpace()
            && ParserImpl.XMLPreserveWhiteSpace(node, configuration.tt)
            && node.getAttrByName("xml:space") == null)
        {
            node.addAttribute("xml:space", "preserve");
            if (attr != null)
            {
                attr = node.attributes;
            }
        }

        if (attr != null)
        {
            if (attr.next != null)
            {
                printAttrs(fout, indent, node, attr.next);
            }

            if (attr.attribute != null)
            {
                Attribute attribute = attr.dict;

                if (!this.configuration.isDropProprietaryAttributes()
                    || !(attribute == null || TidyUtils.toBoolean(attribute.getVersions() & Versions.VERS_PROPRIETARY)))
                {
                    printAttribute(fout, indent, node, attr);
                }
            }
            else if (attr.asp != null)
            {
                addC(' ', linelen++);
                printAsp(fout, indent, attr.asp);
            }
            else if (attr.php != null)
            {
                addC(' ', linelen++);
                printPhp(fout, indent, attr.php);
            }
        }

    }

    /**
     * Line can be wrapped immediately after inline start tag provided if follows a text node ending in a space, or it
     * parent is an inline element that that rule applies to. This behaviour was reverse engineered from Netscape 3.0
     * @param node current Node
     * @return <code>true</code> if the current char follows a space
     */
    private static boolean afterSpace(Node node)
    {
        Node prev;
        int c;

        if (node == null || node.tag == null || !TidyUtils.toBoolean(node.tag.model & Dict.CM_INLINE))
        {
            return true;
        }

        prev = node.prev;

        if (prev != null)
        {
            if (prev.type == NodeType.TextNode && prev.end > prev.start)
            {
                c = (prev.textarray[prev.end - 1]) & 0xFF; // Convert to unsigned.

                if (c == 160 || c == ' ' || c == '\n')
                {
                    return true;
                }
            }

            return false;
        }

        return afterSpace(node.parent);
    }

    /**
     * @param fout
     * @param mode
     * @param indent
     * @param node
     */
    private void printTag(Out fout, short mode, int indent, Node node)
    {
        String p;

        addC('<', linelen++);

        if (node.type == NodeType.EndTag)
        {
            addC('/', linelen++);
        }

        p = node.element;
        for (int i = 0; i < p.length(); i++)
        {
            addC(
                TidyUtils.foldCase(p.charAt(i), this.configuration.isUpperCaseTags(), this.configuration.isXmlTags()),
                linelen++);
        }

        printAttrs(fout, indent, node, node.attributes);

        if ((this.configuration.isXmlOut() || this.configuration.isXHTML())
            && (node.type == NodeType.StartEndTag || TidyUtils.toBoolean(node.tag.model & Dict.CM_EMPTY)))
        {
            addC(' ', linelen++); // Space is NS compatibility hack <br />
            addC('/', linelen++); // Required end tag marker
        }

        addC('>', linelen++);

        if ((node.type != NodeType.StartEndTag || configuration.isXHTML()) && !TidyUtils.toBoolean(mode & PREFORMATTED))
        {
            if (indent + linelen >= this.configuration.getWraplen())
            {
                wrapLine(fout, indent);
            }

            if (indent + linelen < this.configuration.getWraplen())
            {

                // wrap after start tag if is <br/> or if it's not inline
                // fix for [514348]
                if (!TidyUtils.toBoolean(mode & NOWRAP)
                    && (!TidyUtils.toBoolean(node.tag.model & Dict.CM_INLINE) || (node.is(TagId.BR)))
                    && afterSpace(node))
                {
                    wraphere = linelen;
                }

            }
        }
        else
        {
            condFlushLine(fout, indent);
        }

    }

    /**
     * @param mode
     * @param indent
     * @param node
     */
    private void printEndTag(short mode, int indent, Node node)
    {
        String p;

        // Netscape ignores SGML standard by not ignoring a line break before </A> or </U> etc.
        // To avoid rendering this as an underlined space, I disable line wrapping before inline end tags

        // if (indent + linelen < this.configuration.wraplen && !TidyUtils.toBoolean(mode & NOWRAP))
        // {
        // wraphere = linelen;
        // }

        addC('<', linelen++);
        addC('/', linelen++);

        p = node.element;
        for (int i = 0; i < p.length(); i++)
        {
            addC(
                TidyUtils.foldCase(p.charAt(i), this.configuration.isUpperCaseTags(), this.configuration.isXmlTags()),
                linelen++);
        }

        addC('>', linelen++);
    }

    /**
     * @param fout
     * @param indent
     * @param node
     */
    private void printComment(Out fout, int indent, Node node)
    {
        if (this.configuration.isHideComments())
        {
            return;
        }

        if (indent + linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
        }

        addC('<', linelen++);
        addC('!', linelen++);
        addC('-', linelen++);
        addC('-', linelen++);

        printText(fout, COMMENT, indent, node.textarray, node.start, node.end);

        // See Lexer.java: AQ 8Jul2000
        addC('-', linelen++);
        addC('-', linelen++);
        addC('>', linelen++);

        if (node.linebreak)
        {
            flushLine(fout, indent);
        }
    }

    /**
     * @param fout
     * @param indent
     * @param node
     */
    private void printDocType(Out fout, int indent, Node node)
    {
        int i, c = 0;
        short mode = 0;
        boolean q = this.configuration.isQuoteMarks();

        this.configuration.setQuoteMarks(false);

        if (indent + linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
        }

        condFlushLine(fout, indent);

        addC('<', linelen++);
        addC('!', linelen++);
        addC('D', linelen++);
        addC('O', linelen++);
        addC('C', linelen++);
        addC('T', linelen++);
        addC('Y', linelen++);
        addC('P', linelen++);
        addC('E', linelen++);
        addC(' ', linelen++);

        if (indent + linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
        }

        for (i = node.start; i < node.end; ++i)
        {
            if (indent + linelen >= this.configuration.getWraplen())
            {
                wrapLine(fout, indent);
            }

            c = node.textarray[i] & 0xFF; // Convert to unsigned.

            // inDTDSubset?
            if (TidyUtils.toBoolean(mode & CDATA))
            {
                if (c == ']')
                {
                    mode &= ~CDATA;
                }
            }
            else if (c == '[')
            {
                mode |= CDATA;
            }
            int[] ci = new int[1];

            // look for UTF-8 multibyte character
            if (c > 0x7F)
            {
                i += getUTF8(node.textarray, i, ci);
                c = ci[0];
            }

            if (c == '\n')
            {
                flushLine(fout, indent);
                continue;
            }

            printChar(c, mode);
        }

        if (linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
        }

        addC('>', linelen++);
        this.configuration.setQuoteMarks(q);
        condFlushLine(fout, indent);
    }

    /**
     * @param fout
     * @param indent
     * @param node
     */
    private void printPI(Out fout, int indent, Node node)
    {
        if (indent + linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
        }

        addC('<', linelen++);
        addC('?', linelen++);

        // set CDATA to pass < and > unescaped
        printText(fout, CDATA, indent, node.textarray, node.start, node.end);

        if (node.end <= 0 || node.textarray[node.end - 1] != '?') // #542029 - fix by Terry Teague 10 Apr 02
        {
            addC('?', linelen++);
        }

        addC('>', linelen++);
        condFlushLine(fout, indent);
    }

    /**
     * Pretty print the xml declaration.
     * @param fout
     * @param indent
     * @param node
     */
    private void printXmlDecl(Out fout, int indent, Node node)
    {
        if (indent + linelen < this.configuration.getWraplen())
        {
            wraphere = linelen;
        }

        addC('<', linelen++);
        addC('?', linelen++);
        addC('x', linelen++);
        addC('m', linelen++);
        addC('l', linelen++);

        printAttrs(fout, indent, node, node.attributes);

        if (node.end <= 0 || node.textarray[node.end - 1] != '?') // #542029 - fix by Terry Teague 10 Apr 02
        {
            addC('?', linelen++);
        }

        addC('>', linelen++);

        condFlushLine(fout, indent);
    }

    /**
     * note ASP and JSTE share <% ... %> syntax.
     * @param fout
     * @param indent
     * @param node
     */
    private void printAsp(Out fout, int indent, Node node)
    {
        int savewraplen = this.configuration.getWraplen();

        // disable wrapping if so requested

        if (!this.configuration.isWrapAsp() || !this.configuration.isWrapJste())
        {
            this.configuration.setWraplen(0xFFFFFF); // a very large number
        }

        addC('<', linelen++);
        addC('%', linelen++);

        printText(fout, (this.configuration.isWrapAsp() ? CDATA : COMMENT), indent, node.textarray, node.start, node.end);

        addC('%', linelen++);
        addC('>', linelen++);
        /* condFlushLine(fout, indent); */
        this.configuration.setWraplen(savewraplen);
    }

    /**
     * JSTE also supports <# ... #> syntax
     * @param fout
     * @param indent
     * @param node
     */
    private void printJste(Out fout, int indent, Node node)
    {
        int savewraplen = this.configuration.getWraplen();

        // disable wrapping if so requested

        if (!this.configuration.isWrapJste())
        {
            this.configuration.setWraplen(0xFFFFFF); // a very large number
        }

        addC('<', linelen++);
        addC('#', linelen++);

        printText(fout, (this.configuration.isWrapJste() ? CDATA : COMMENT), indent, node.textarray, node.start, node.end);

        addC('#', linelen++);
        addC('>', linelen++);
        // condFlushLine(fout, indent);
        this.configuration.setWraplen(savewraplen);
    }

    /**
     * PHP is based on XML processing instructions.
     * @param fout
     * @param indent
     * @param node
     */
    private void printPhp(Out fout, int indent, Node node)
    {
        int savewraplen = this.configuration.getWraplen();

        // disable wrapping if so requested

        if (!this.configuration.isWrapPhp())
        {
            this.configuration.setWraplen(0xFFFFFF); // a very large number
        }

        addC('<', linelen++);
        addC('?', linelen++);

        printText(fout, (this.configuration.isWrapPhp() ? CDATA : COMMENT), indent, node.textarray, node.start, node.end);

        addC('?', linelen++);
        addC('>', linelen++);
        // PCondFlushLine(fout, indent);
        this.configuration.setWraplen(savewraplen);
    }

    /**
     * @param fout
     * @param indent
     * @param node
     */
    private void printCDATA(Out fout, int indent, Node node)
    {
        int savewraplen = this.configuration.getWraplen();

        if (!this.configuration.isIndentCdata())
        {
            indent = 0;
        }

        condFlushLine(fout, indent);

        // disable wrapping
        this.configuration.setWraplen(0xFFFFFF); // a very large number

        addC('<', linelen++);
        addC('!', linelen++);
        addC('[', linelen++);
        addC('C', linelen++);
        addC('D', linelen++);
        addC('A', linelen++);
        addC('T', linelen++);
        addC('A', linelen++);
        addC('[', linelen++);

        printText(fout, COMMENT, indent, node.textarray, node.start, node.end);

        addC(']', linelen++);
        addC(']', linelen++);
        addC('>', linelen++);
        condFlushLine(fout, indent);
        this.configuration.setWraplen(savewraplen);
    }

    /**
     * @param fout
     * @param indent
     * @param node
     */
    private void printSection(Out fout, int indent, Node node)
    {
        int savewraplen = this.configuration.getWraplen();

        // disable wrapping if so requested

        if (!this.configuration.isWrapSection())
        {
            this.configuration.setWraplen(0xFFFFFF); // a very large number
        }

        addC('<', linelen++);
        addC('!', linelen++);
        addC('[', linelen++);

        printText(
            fout,
            (this.configuration.isWrapSection() ? CDATA : COMMENT),
            indent,
            node.textarray,
            node.start,
            node.end);

        addC(']', linelen++);
        addC('>', linelen++);
        // PCondFlushLine(fout, indent);
        this.configuration.setWraplen(savewraplen);
    }

    /**
     * Is the current node inside HEAD?
     * @param node Node
     * @return <code>true</code> if node is inside an HEAD tag
     */
    private boolean insideHead(Node node)
    {
        if (node.is(TagId.HEAD))
        {
            return true;
        }

        if (node.parent != null)
        {
            return insideHead(node.parent);
        }
        return false;
    }

    /**
     * Is text node and already ends w/ a newline? Used to pretty print CDATA/PRE text content. If it already ends on a
     * newline, it is not necessary to print another before printing end tag.
     * @param node text node
     * @return text indent
     */
    private int textEndsWithNewline(Node node)
    {
        if (node.type == NodeType.TextNode && node.end > node.start)
        {
            int ch, ix = node.end - 1;
            // Skip non-newline whitespace
            while (ix >= node.start
                && TidyUtils.toBoolean(ch = (node.textarray[ix] & 0xff))
                && (ch == ' ' || ch == '\t' || ch == '\r'))
            {
                --ix;
            }

            if (ix >= 0 && node.textarray[ix] == '\n')
            {
                return node.end - ix - 1; // #543262 tidy eats all memory
            }
        }
        return -1;
    }

    /**
     * Does the current node contain a CDATA section?
     * @param node Node
     * @return <code>true</code> if node contains a CDATA section
     */
    static boolean hasCDATA(Node node)
    {
        // Scan forward through the textarray. Since the characters we're
        // looking for are < 0x7f, we don't have to do any UTF-8 decoding.

        if (node.type != NodeType.TextNode)
        {
            return false;
        }

        int len = node.end - node.start + 1;
        String start = TidyUtils.getString(node.textarray, node.start, len);

        int indexOfCData = start.indexOf(CDATA_START);
        return indexOfCData > -1 && indexOfCData <= len;
    }

    /**
     * Print script and style elements. For XHTML, wrap the content as follows:
     * 
     * <pre>
     *     JavaScript:
     *         //&lt;![CDATA[
     *             content
     *         //]]>
     *     VBScript:
     *         '&lt;![CDATA[
     *             content
     *         ']]>
     *     CSS:
     *         /*&lt;![CDATA[* /
     *             content
     *         /*]]>* /
     *     other:
     *        &lt;![CDATA[
     *             content
     *         ]]>
     * </pre>
     * 
     * @param fout
     * @param mode
     * @param indent
     * @param lexer
     * @param node
     */
    private void printScriptStyle(Out fout, short mode, int indent, Lexer lexer, Node node)
    {
        Node content;
        String commentStart = DEFAULT_COMMENT_START;
        String commentEnd = DEFAULT_COMMENT_END;
        boolean hasCData = false;
        int contentIndent = -1;

        if (insideHead(node))
        {
            // flushLine(fout, indent);
        }

        indent = 0;

        // start script
        printTag(fout, mode, indent, node);
        // flushLine(fout, indent); // extra newline

        if (lexer.configuration.isXHTML() && node.content != null)
        {
            AttVal type = node.getAttrByName("type");
            if (type != null)
            {
                if ("text/javascript".equalsIgnoreCase(type.value))
                {
                    commentStart = JS_COMMENT_START;
                    commentEnd = JS_COMMENT_END;
                }
                else if ("text/css".equalsIgnoreCase(type.value))
                {
                    commentStart = CSS_COMMENT_START;
                    commentEnd = CSS_COMMENT_END;
                }
                else if ("text/vbscript".equalsIgnoreCase(type.value))
                {
                    commentStart = VB_COMMENT_START;
                    commentEnd = VB_COMMENT_END;
                }
            }

            hasCData = hasCDATA(node.content);
            if (!hasCData)
            {
                // disable wrapping
                int savewraplen = lexer.configuration.getWraplen();
                lexer.configuration.setWraplen(0xFFFFFF); // a very large number

                linelen = addAsciiString(commentStart, linelen);
                linelen = addAsciiString(CDATA_START, linelen);
                linelen = addAsciiString(commentEnd, linelen);
                condFlushLine(fout, indent);

                // restore wrapping
                lexer.configuration.setWraplen(savewraplen);
            }
        }

        for (content = node.content; content != null; content = content.next)
        {
            printTree(fout, (short) (mode | PREFORMATTED | NOWRAP | CDATA), 0, lexer, content);

            if (content.next == null)
            {
                contentIndent = textEndsWithNewline(content);
            }

        }

        if (contentIndent < 0)
        {
            condFlushLine(fout, indent);
            contentIndent = 0;
        }

        if (lexer.configuration.isXHTML() && node.content != null)
        {
            if (!hasCData)
            {
                // disable wrapping
                int ix, savewraplen = lexer.configuration.getWraplen();
                lexer.configuration.setWraplen(0xFFFFFF); // a very large number

                // Add spaces to last text node to align w/ indent
                if (contentIndent > 0 && linelen < contentIndent)
                {
                    linelen = contentIndent;
                }
                for (ix = 0; contentIndent < indent && ix < indent - contentIndent; ++ix)
                {
                    addC(' ', linelen++);
                }

                linelen = addAsciiString(commentStart, linelen);
                linelen = addAsciiString(CDATA_END, linelen);
                linelen = addAsciiString(commentEnd, linelen);

                // restore wrapping
                lexer.configuration.setWraplen(savewraplen);
                condFlushLine(fout, 0);
            }
        }

        printEndTag(mode, indent, node);

        if (lexer.configuration.getIndentContent() == TriState.No
        		&& node.next != null
        		&& !(node.hasCM(Dict.CM_INLINE) || node.isText())) {
            flushLine(fout, indent);
        }
    }

    /**
     * Should tidy indent the give tag?
     * @param node actual node
     * @return <code>true</code> if line should be indented
     */
    private boolean shouldIndent(Node node) {
    	final TriState indentContent = configuration.getIndentContent();
        if (indentContent == TriState.No) {
            return false;
        }
        if (node.is(TagId.TEXTAREA)) {
        	return false;
        }
        if (indentContent == TriState.Auto) {
            if (node.content != null && node.hasCM(Dict.CM_NO_INDENT)) {
                for (node = node.content; node != null; node = node.next)
                {
                    if (node.tag != null && TidyUtils.toBoolean(node.tag.model & Dict.CM_BLOCK))
                    {
                        return true;
                    }
                }

                return false;
            }

            if (TidyUtils.toBoolean(node.tag.model & Dict.CM_HEADING))
            {
                return false;
            }

            if (node.is(TagId.P))
            {
                return false;
            }

            if (node.is(TagId.TITLE))
            {
                return false;
            }
        }

        if (TidyUtils.toBoolean(node.tag.model & (Dict.CM_FIELD | Dict.CM_OBJECT)))
        {
            return true;
        }

        if (node.is(TagId.MAP))
        {
            return true;
        }

        return !TidyUtils.toBoolean(node.tag.model & Dict.CM_INLINE);
    }

    /**
     * Print just the content of the body element. Useful when you want to reuse material from other documents.
     * @param fout
     * @param lexer
     * @param root
     * @param xml
     */
    void printBody(Out fout, Lexer lexer, Node root, boolean xml)
    {
        if (root == null)
        {
            return;
        }

        // Feature request #434940 - fix by Dave Raggett/Ignacio Vazquez-Abrams 21 Jun 01
        // Sebastiano Vigna <vigna@dsi.unimi.it>
        Node body = root.findBody();

        if (body != null)
        {
            Node content;
            for (content = body.content; content != null; content = content.next)
            {
                if (xml)
                {
                    printXMLTree(fout, (short) 0, 0, lexer, content);
                }
                else
                {
                    printTree(fout, (short) 0, 0, lexer, content);
                }
            }
        }
    }

    /**
     * @param fout
     * @param mode
     * @param indent
     * @param lexer
     * @param node
     */
    public void printTree(Out fout, short mode, int indent, Lexer lexer, Node node)
    {
        Node content, last;
        int spaces = configuration.getSpaces();
        boolean xhtml = configuration.isXHTML();

        if (node == null) {
            return;
        }

        if (node.type == NodeType.TextNode) {
            printText(fout, mode, indent, node.textarray, node.start, node.end);
        }
        else if (node.type == NodeType.CommentTag) {
            printComment(fout, indent, node);
        }
        else if (node.type == NodeType.RootNode) {
            for (content = node.content; content != null; content = content.next) {
                printTree(fout, mode, indent, lexer, content);
            }
        }
        else if (node.type == NodeType.DocTypeTag) {
            printDocType(fout, indent, node);
        }
        else if (node.type == NodeType.ProcInsTag) {
            printPI(fout, indent, node);
        }
        else if (node.type == NodeType.XmlDecl) {
            printXmlDecl(fout, indent, node);
        }
        else if (node.type == NodeType.CDATATag) {
            printCDATA(fout, indent, node);
        }
        else if (node.type == NodeType.SectionTag) {
            printSection(fout, indent, node);
        }
        else if (node.type == NodeType.AspTag) {
            printAsp(fout, indent, node);
        }
        else if (node.type == NodeType.JsteTag) {
            printJste(fout, indent, node);
        }
        else if (node.type == NodeType.PhpTag) {
            printPhp(fout, indent, node);
        }
        else if (node.hasCM(Dict.CM_EMPTY)
        		|| (node.type == NodeType.StartEndTag && !xhtml)) {
            if (!node.hasCM(Dict.CM_INLINE)) {
                condFlushLine(fout, indent);
            }

            if (node.is(TagId.BR) && node.prev != null
            		&& !(node.prev.is(TagId.BR) || (mode & PREFORMATTED) != 0)
            		&& this.configuration.isBreakBeforeBR()) {
                flushLine(fout, indent);
            }
            
            if (node.is(TagId.HR)) {
            	// insert extra newline for classic formatting
                final boolean classic = configuration.isVertSpace();
                if (classic && node.parent != null && node.parent.content != node) {
                	flushLine(fout, indent);
                }
            }

            printTag(fout, mode, indent, node);
            
            if (node.next != null) {
	            if (node.is(TagId.PARAM) || node.is(TagId.AREA)) {
	                condFlushLine(fout, indent);
	            }
	            else if ((node.is(TagId.BR) && (mode & PREFORMATTED) == 0) || node.is(TagId.HR)) {
	                flushLine(fout, indent);
	            }
            }
        }
        else // some kind of container element
        {
            if (node.type == NodeType.StartEndTag) {
                node.type = NodeType.StartTag;
            }

            if (node.tag != null
            		&& (node.tag.getParser() == ParserImpl.PRE || node.is(TagId.TEXTAREA))) {
            	final boolean classic = configuration.isVertSpace();
            	final int indprev = indent;
                condFlushLine(fout, indent);
                condFlushLine(fout, indent);
                
                // insert extra newline for classic formatting
                if (classic && node.parent != null && node.parent.content != node) {
                    flushLine(fout, indent);
                }
                printTag(fout, mode, indent, node);

                indent = 0;
                flushLine(fout, indent);

                for (content = node.content; content != null; content = content.next) {
                    printTree(fout, (short) (mode | PREFORMATTED | NOWRAP), indent, lexer, content);
                }

                condFlushLine(fout, indent);
                indent = indprev;
                printEndTag(mode, indent, node);
                
                if (configuration.getIndentContent() == TriState.No && node.next != null) {
                    flushLine(fout, indent);
                }
            }
            else if (node.is(TagId.STYLE) || node.is(TagId.SCRIPT)) {
                printScriptStyle(fout, (short) (mode | PREFORMATTED | NOWRAP | CDATA), indent, lexer, node);
            }
            else if (node.hasCM(Dict.CM_INLINE)) {
                if (configuration.isMakeClean()) {
                    // replace <nobr> ... </nobr> by &nbsp; or &#160; etc.
                    if (node.is(TagId.NOBR)) {
                        for (content = node.content; content != null; content = content.next) {
                            printTree(fout, (short) (mode | NOWRAP), indent, lexer, content);
                        }
                        return;
                    }
                }

                // otherwise a normal inline element
                printTag(fout, mode, indent, node);

                // indent content for SELECT, TEXTAREA, MAP, OBJECT and APPLET
                if (shouldIndent(node)) {
                	indent += spaces;
                    condFlushLine(fout, indent);

                    for (content = node.content; content != null; content = content.next) {
                        printTree(fout, mode, indent, lexer, content);
                    }

                    indent -= spaces;
                    condFlushLine(fout, indent);
                }
                else {
                    for (content = node.content; content != null; content = content.next) {
                        printTree(fout, mode, indent, lexer, content);
                    }
                }
                printEndTag(mode, indent, node);
            }
            else { // other tags
            	final boolean indcont = configuration.getIndentContent() != TriState.No;
            	final boolean indsmart = configuration.getIndentContent() == TriState.Auto;
            	final boolean hideend = configuration.isHideEndTags();
            	final boolean classic = configuration.isVertSpace();
            	int contentIndent = indent;
            	
            	// insert extra newline for classic formatting
                if (classic && node.parent != null && node.parent.content != node && !node.is(TagId.HTML)) {
                	flushLine(fout, indent);
                }
                
                if (shouldIndent(node)) {
                	contentIndent += spaces;
                }

                condFlushLine(fout, indent);
                if (indsmart && node.prev != null) {
                    flushLine(fout, indent);
                }

                // do not omit elements with attributes
                if (!hideend || !node.hasCM(Dict.CM_OMITST)
                    	|| node.attributes != null) {
                    printTag(fout, mode, indent, node);

                    if (shouldIndent(node)) {
                    	if (!(node.is(TagId.LI) && node.content.isText())) {
                    		condFlushLine(fout, contentIndent);
                    	}
                    }
                    else if (node.hasCM(Dict.CM_HTML) || node.is(TagId.NOFRAMES)
                    		|| (node.hasCM(Dict.CM_HEAD) && !node.is(TagId.TITLE))) {
                        flushLine(fout, contentIndent);
                    }
                }
                
                last = null;
                for (content = node.content; content != null; content = content.next) {
                    // kludge for naked text before block level tag
                    if (last != null && !indcont && last.isText()
                    		&& content.tag != null && !content.hasCM(Dict.CM_INLINE)) {
                        flushLine(fout, contentIndent);
                    }

                    printTree(fout, mode, contentIndent, lexer, content);
                    last = content;
                }

                // don't flush line for td and th
                if (shouldIndent(node) || (!hideend && (node.hasCM(Dict.CM_HTML) || node.is(TagId.NOFRAMES)
                		|| (node.hasCM(Dict.CM_HEAD) && !node.is(TagId.TITLE))))) {
                    condFlushLine(fout, indent);
                    if (!hideend || !node.hasCM(Dict.CM_OPT)) {
                        printEndTag(mode, indent, node);
                    }
                }
                else {
                    if (!hideend || !node.hasCM(Dict.CM_OPT)) {
                    	// newline before endtag for classic formatting
                        if (classic && !node.hasMixedContent()) {
                            flushLine(fout, indent);
                        }
                        printEndTag(mode, indent, node);
                    }
                }
                
                if (!indcont && !hideend && !node.is(TagId.HTML) && !classic) {
                	flushLine(fout, indent);
                }
                else if (classic && node.next != null
                		&& node.hasCM(Dict.CM_LIST | Dict.CM_DEFLIST | Dict.CM_TABLE | Dict.CM_BLOCK)) {
                	flushLine(fout, indent);
                }
            }
        }
    }

    /**
     * @param fout
     * @param mode
     * @param indent
     * @param lexer
     * @param node
     */
    public void printXMLTree(Out fout, short mode, int indent, Lexer lexer, Node node)
    {
        TagTable tt = this.configuration.tt;

        if (node == null)
        {
            return;
        }

        if (node.type == NodeType.TextNode || (node.type == NodeType.CDATATag && lexer.configuration.isEscapeCdata()))
        {
            printText(fout, mode, indent, node.textarray, node.start, node.end);
        }
        else if (node.type == NodeType.CommentTag)
        {
            condFlushLine(fout, indent);
            printComment(fout, 0, node);
            condFlushLine(fout, 0);
        }
        else if (node.type == NodeType.RootNode)
        {
            Node content;

            for (content = node.content; content != null; content = content.next)
            {
                printXMLTree(fout, mode, indent, lexer, content);
            }
        }
        else if (node.type == NodeType.DocTypeTag)
        {
            printDocType(fout, indent, node);
        }
        else if (node.type == NodeType.ProcInsTag)
        {
            printPI(fout, indent, node);
        }
        else if (node.type == NodeType.XmlDecl)
        {
            printXmlDecl(fout, indent, node);
        }
        else if (node.type == NodeType.CDATATag)
        {
            printCDATA(fout, indent, node);
        }
        else if (node.type == NodeType.SectionTag)
        {
            printSection(fout, indent, node);
        }
        else if (node.type == NodeType.AspTag)
        {
            printAsp(fout, indent, node);
        }
        else if (node.type == NodeType.JsteTag)
        {
            printJste(fout, indent, node);
        }
        else if (node.type == NodeType.PhpTag)
        {
            printPhp(fout, indent, node);
        }
        else if (TidyUtils.toBoolean(node.tag.model & Dict.CM_EMPTY)
            || node.type == NodeType.StartEndTag
            && !configuration.isXHTML())
        {
            condFlushLine(fout, indent);
            printTag(fout, mode, indent, node);
            // fgiust: Remove empty lines between tags in XML.
            // flushLine(fout, indent);

            // CPR: folks don't want so much vertical spacing in XML
            // if (node.next != null) { flushLine(fout, indent); }

        }
        else
        {
            // some kind of container element
            Node content;
            boolean mixed = false;
            int cindent;

            for (content = node.content; content != null; content = content.next)
            {
                if (content.type == NodeType.TextNode)
                {
                    mixed = true;
                    break;
                }
            }

            condFlushLine(fout, indent);

            if (ParserImpl.XMLPreserveWhiteSpace(node, tt))
            {
                indent = 0;
                cindent = 0;
                mixed = false;
            }
            else if (mixed)
            {
                cindent = indent;
            }
            else
            {
                cindent = indent + this.configuration.getSpaces();
            }

            printTag(fout, mode, indent, node);

            if (!mixed && node.content != null)
            {
                flushLine(fout, indent);
            }

            for (content = node.content; content != null; content = content.next)
            {
                printXMLTree(fout, mode, cindent, lexer, content);
            }

            if (!mixed && node.content != null)
            {
                condFlushLine(fout, cindent);
            }
            printEndTag(mode, indent, node);
            // condFlushLine(fout, indent);

            // CPR: folks don't want so much vertical spacing in XML
            // if (node.next != null) { flushLine(fout, indent); }

        }
    }

    /**
     * Split parse tree by h2 elements and output to separate files. Counts number of h2 children (if any) belonging to
     * node.
     * @param node root node
     * @return number of slides (number of h2 elements)
     */
    public int countSlides(Node node)
    {
        // assume minimum of 1 slide
        int n = 1;

        // fix for [431716] avoid empty slides
        if (node != null && node.content != null && node.content.is(TagId.H2))
        {
            // "first" slide is empty, so ignore it
            n--;
        }

        if (node != null)
        {
            for (node = node.content; node != null; node = node.next)
            {
                if (node.is(TagId.H2))
                {
                    ++n;
                }
            }
        }

        return n;
    }

    /**
     * Add meta element for page transition effect, this works on IE but not NS.
     * @param lexer
     * @param root
     * @param duration
     */
    public void addTransitionEffect(Lexer lexer, Node root, double duration)
    {
        Node head = root.findHEAD();
        String transition;

        transition = "blendTrans(Duration=" + (new Double(duration)).toString() + ")";

        if (head != null)
        {
            Node meta = lexer.inferredTag(TagId.META);
            meta.addAttribute("http-equiv", "Page-Enter");
            meta.addAttribute("content", transition);
            head.insertNodeAtStart(meta);
        }
    }
}