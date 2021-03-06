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

/**
 * Message sent to listeners for validation errors/warnings and info.
 * @see Tidy#setMessageListener(TidyMessageListener)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public final class TidyMessage
{

    /**
     * Line in the source file (can be 0 if the message is not related to a particular line, such as a summary message).
     */
    private final int line;

    /**
     * Column in the source file (can be 0 if the message is not related to a particular column, such as a summary
     * message).
     */
    private final int column;

    /**
     * Level for this message. Can be TidyMessage.Level.SUMMARY | TidyMessage.Level.INFO | TidyMessage.Level.WARNING |
     * TidyMessage.Level.ERROR.
     */
    private final Level level;

    /**
     * Formatted text for this message.
     */
    private final String message;

    /**
     * Tidy internal error code.
     */
    private final int errorCode;

    /**
     * Instantiates a new message.
     * @param errorCode Tidy internal error code.
     * @param line Line number in the source file
     * @param column Column number in the source file
     * @param level severity
     * @param message message text
     */
    public TidyMessage(final int errorCode, final int line, final int column, final Level level, final String message)
    {
        this.errorCode = errorCode;
        this.line = line;
        this.column = column;
        this.level = level;
        this.message = message;
    }

    /**
     * Getter for <code>errorCode</code>.
     * @return Returns the errorCode.
     */
    public int getErrorCode()
    {
        return this.errorCode;
    }

    /**
     * Getter for <code>column</code>.
     * @return Returns the column.
     */
    public int getColumn()
    {
        return this.column;
    }

    /**
     * Getter for <code>level</code>.
     * @return Returns the level.
     */
    public Level getLevel()
    {
        return this.level;
    }

    /**
     * Getter for <code>line</code>.
     * @return Returns the line.
     */
    public int getLine()
    {
        return this.line;
    }

    /**
     * Getter for <code>message</code>.
     * @return Returns the message.
     */
    public String getMessage()
    {
        return this.message;
    }

    /**
     * Message severity enumeration.
     * @author fgiust
     * @version $Revision$ ($Author$)
     */
    public enum Level {
        /** Summary (number of warnings, errors) */
        SUMMARY("Summary"),

        /** Information about markup usage */
        INFO("Info"),
        
        /** Warning message */
        WARNING("Warning"),
        
        /** Error message - output suppressed */
        ERROR("Error"),

        /** Configuration error */
        CONFIG("Config"),
        
        /** Accessibility message */
        ACCESS("Access"),
        
        /** I/O or file system error */
        BAD_DOCUMENT("Document"),
        
        /** Crash! */
        FATAL("panic");
        
        private final String text;
        
        private Level(final String text) {
            this.text = text;
        }

        public int getCode() {
            return ordinal();
        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
		public String toString() {
        	return text;
        }
    }
}
