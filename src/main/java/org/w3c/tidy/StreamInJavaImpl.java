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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;


/**
 * StreamIn Implementation using java writers.
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public class StreamInJavaImpl implements StreamIn
{

    /**
     * number of characters kept in buffer.
     */
    private static final int CHARBUF_SIZE = 16;
    private static final int LASTPOS_SIZE = 64;

    /**
     * character buffer.
     */
    private final int[] charbuf = new int[CHARBUF_SIZE];

    /**
     * actual position in buffer.
     */
    private int bufpos;

    /**
     * Java input stream reader.
     */
    private final Reader reader;

    /**
     * has end of stream been reached?
     */
    private boolean endOfStream;

    /**
     * Is char pushed?
     */
    private boolean pushed;

    /**
     * current column number.
     */
    private int curcol;
    
    private final int lastcols[] = new int[LASTPOS_SIZE];
    private int curlastpos; /* current last position in lastcols */ 
    private int firstlastpos; /* first valid last position in lastcols */ 

    /**
     * current line number.
     */
    private int curline;

    /**
     * tab size in chars.
     */
    private final int tabsize;

    private int tabs;
    
    private Lexer lexer;

    /**
     * Instantiates a new StreamInJavaImpl.
     * @param stream
     * @param encoding
     * @param tabsize
     * @throws UnsupportedEncodingException
     */
    protected StreamInJavaImpl(final InputStream stream, final String encoding, final int tabsize) throws UnsupportedEncodingException
    {
        reader = new InputStreamReader(stream, encoding);
        this.pushed = false;
        this.tabsize = tabsize;
        this.curline = 1;
        this.curcol = 1;
    }

    /**
     * Instantiates a new StreamInJavaImpl.
     * @param stream
     * @param encoding
     * @param tabsize
     */
    protected StreamInJavaImpl(final Reader reader, final int tabsize)
    {
        this.reader = reader;
        this.pushed = false;
        this.tabsize = tabsize;
        this.curline = 1;
        this.curcol = 1;
    }

    /**
     * @see org.w3c.tidy.StreamIn#readCharFromStream()
     */
    public int readCharFromStream()
    {
        int c;
        try
        {
            c = reader.read();
            if (c < 0) {
                endOfStream = true;
                return END_OF_STREAM;
            }

        }
        catch (final IOException e)
        {
            // @todo how to handle?
            endOfStream = true;
            return END_OF_STREAM;
        }

        return c;
    }
    
    private void popLastPos() {
        curlastpos = (curlastpos + 1) % LASTPOS_SIZE;
        if (curlastpos == firstlastpos) {
            firstlastpos = (firstlastpos + 1) % LASTPOS_SIZE;
        }
    }

    private void saveLastPos() {
        popLastPos();
        lastcols[curlastpos] = curcol;
    }
    
    private int popChar() {
        int c = END_OF_STREAM;
        if (pushed) {
            assert bufpos > 0;
            c = charbuf[--bufpos];
            if (bufpos == 0) {
                pushed = false;
            }
            if (c == '\n') {
                curcol = 1;
                curline++;
                popLastPos();
                return c;
            }
            this.curcol++;
            popLastPos();
        }
        return c;
    }

    /**
     * @see org.w3c.tidy.StreamIn#readChar()
     */
    public int readChar() {
        int c = END_OF_STREAM;

        if (this.pushed) {
            return popChar();
        }

        saveLastPos();

        if (this.tabs > 0) {
            this.curcol++;
            this.tabs--;
            return ' ';
        }

        c = readCharFromStream();

        if (END_OF_STREAM == c) {
            endOfStream = true;
            return END_OF_STREAM;
        }

        if (c == '\n') {
            this.curcol = 1;
            this.curline++;
            return c;
        }
        if (c == '\t') {
            this.tabs = tabsize > 0 ?
            		this.tabsize - (this.curcol - 1) % this.tabsize - 1
            		: 0;
            this.curcol++;
            c = ' ';
            return c;
        }
        if (c == '\r') {
            c = readCharFromStream();
            if (c != '\n') {
                if (c != END_OF_STREAM) {
                    ungetChar(c);
                }
                c = '\n';
            } else {
            	this.curcol = 1;
            	this.curline++;
            	return c;
            }
        }
        
        /* produced e.g. as a side-effect of smart quotes in Word */
        /* but can't happen if using MACROMAN encoding */
        if (127 < c && c < 160) {
        	int c1 = 0;
        	int replMode = Report.DISCARDED_CHAR;
        	final String enc = lexer.configuration.getInCharEncodingName();
        	final String repl = lexer.configuration.getReplacementCharEncoding();
        	final boolean isVendorChar = "WIN1252".equals(enc) || "MACROMAN".equals(enc);
        	final boolean isWinChar = "WIN1252".equals(enc) || "WIN1252".equals(repl);
        	final boolean isMacChar = "MACROMAN".equals(enc) || "MACROMAN".equals(repl);
        	
        	/* set error position just before offending character */
        	lexer.lines = curline;
        	lexer.columns = curcol;
        	
        	if (isWinChar) {
        		c1 = EncodingUtils.decodeWin1252(c);
        	}
        	else if (isMacChar) {
        		c1 = EncodingUtils.decodeMacRoman(c);
        	}
        	if (c1 != 0) {
        		replMode = Report.REPLACED_CHAR;
        	}
        	
        	if (c1 == 0 && isVendorChar) {
        		lexer.report.encodingError(lexer, ErrorCode.VENDOR_SPECIFIC_CHARS, c, replMode);
        	}
        	else if (!isVendorChar) {
        		lexer.report.encodingError(lexer, ErrorCode.INVALID_SGML_CHARS, c, replMode);
        	}
        	c = c1;
        }

        this.curcol++;
        return c;
    }

    private void restoreLastPos() {
        if (firstlastpos == curlastpos) {
            curcol = 0;
        } else {
            curcol = lastcols[curlastpos];
            if (curlastpos == 0) {
                curlastpos = LASTPOS_SIZE;
            }
            curlastpos--;
        }
    }

    /**
     * @see org.w3c.tidy.StreamIn#ungetChar(int)
     */
    public void ungetChar(final int c)
    {
    	if (c == END_OF_STREAM) {
    		return;
    	}
        this.pushed = true;
        if (this.bufpos >= CHARBUF_SIZE)
        {
            // pop last element
            System.arraycopy(this.charbuf, 0, this.charbuf, 1, CHARBUF_SIZE - 1);
            this.bufpos--;
        }
        this.charbuf[this.bufpos++] = c;

        if (c == '\n')
        {
            --this.curline;
        }
        restoreLastPos();
    }

    /**
     * @see org.w3c.tidy.StreamIn#isEndOfStream()
     */
    public boolean isEndOfStream()
    {
        return endOfStream;
    }

    /**
     * Getter for <code>curcol</code>.
     * @return Returns the curcol.
     */
    public int getCurcol()
    {
        return this.curcol;
    }

    public void moveCurcol(final int x) {
        curcol += x;
    }

    /**
     * Getter for <code>curline</code>.
     * @return Returns the curline.
     */
    public int getCurline()
    {
        return this.curline;
    }

    /**
     * @see org.w3c.tidy.StreamIn#setLexer(org.w3c.tidy.Lexer)
     */
    public void setLexer(final Lexer lexer) {
    	this.lexer = lexer;
    }

}