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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static org.w3c.tidy.Versions.*;
import static org.w3c.tidy.Dict.*;

/**
 * Tag dictionary node hash table.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public final class TagTable
{

    /**
     * dummy entry for all xml tags.
     */
    public static final Dict XML_TAGS = new Dict(TagId.UNKNOWN, null, VERS_XML, null, Dict.CM_BLOCK, null, null);

    /**
     * all the known tags.
     */
    private static final Dict[] TAGS = {
    	new Dict(TagId.UNKNOWN,    "unknown!",   VERS_UNKNOWN,           null,                (0),                                           null,                null                 ),

    	/* W3C defined elements */
    	new Dict(TagId.A,          "a",          TagVersions.A,          AttrDict.A,          (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.ABBR,       "abbr",       TagVersions.ABBR,       AttrDict.ABBR,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.ACRONYM,    "acronym",    TagVersions.ACRONYM,    AttrDict.ACRONYM,    (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.ADDRESS,    "address",    TagVersions.ADDRESS,    AttrDict.ADDRESS,    (CM_BLOCK),                                    ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.APPLET,     "applet",     TagVersions.APPLET,     AttrDict.APPLET,     (CM_OBJECT|CM_IMG|CM_INLINE|CM_PARAM),         ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.AREA,       "area",       TagVersions.AREA,       AttrDict.AREA,       (CM_BLOCK|CM_EMPTY),                           ParserImpl.EMPTY,    TagCheckImpl.AREA    ),
    	new Dict(TagId.B,          "b",          TagVersions.B,          AttrDict.B,          (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.BASE,       "base",       TagVersions.BASE,       AttrDict.BASE,       (CM_HEAD|CM_EMPTY),                            ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.BASEFONT,   "basefont",   TagVersions.BASEFONT,   AttrDict.BASEFONT,   (CM_INLINE|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.BDO,        "bdo",        TagVersions.BDO,        AttrDict.BDO,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.BIG,        "big",        TagVersions.BIG,        AttrDict.BIG,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.BLOCKQUOTE, "blockquote", TagVersions.BLOCKQUOTE, AttrDict.BLOCKQUOTE, (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.BODY,       "body",       TagVersions.BODY,       AttrDict.BODY,       (CM_HTML|CM_OPT|CM_OMITST),                    ParserImpl.BODY,     null                 ),
    	new Dict(TagId.BR,         "br",         TagVersions.BR,         AttrDict.BR,         (CM_INLINE|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.BUTTON,     "button",     TagVersions.BUTTON,     AttrDict.BUTTON,     (CM_INLINE),                                   ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.CAPTION,    "caption",    TagVersions.CAPTION,    AttrDict.CAPTION,    (CM_TABLE),                                    ParserImpl.INLINE,   TagCheckImpl.CAPTION ),
    	new Dict(TagId.CENTER,     "center",     TagVersions.CENTER,     AttrDict.CENTER,     (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.CITE,       "cite",       TagVersions.CITE,       AttrDict.CITE,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.CODE,       "code",       TagVersions.CODE,       AttrDict.CODE,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.COL,        "col",        TagVersions.COL,        AttrDict.COL,        (CM_TABLE|CM_EMPTY),                           ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.COLGROUP,   "colgroup",   TagVersions.COLGROUP,   AttrDict.COLGROUP,   (CM_TABLE|CM_OPT),                             ParserImpl.COLGROUP, null                 ),
    	new Dict(TagId.DD,         "dd",         TagVersions.DD,         AttrDict.DD,         (CM_DEFLIST|CM_OPT|CM_NO_INDENT),              ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.DEL,        "del",        TagVersions.DEL,        AttrDict.DEL,        (CM_INLINE|CM_BLOCK|CM_MIXED),                 ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.DFN,        "dfn",        TagVersions.DFN,        AttrDict.DFN,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.DIR,        "dir",        TagVersions.DIR,        AttrDict.DIR,        (CM_BLOCK|CM_OBSOLETE),                        ParserImpl.LIST,     null                 ),
    	new Dict(TagId.DIV,        "div",        TagVersions.DIV,        AttrDict.DIV,        (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.DL,         "dl",         TagVersions.DL,         AttrDict.DL,         (CM_BLOCK),                                    ParserImpl.DEFLIST,  null                 ),
    	new Dict(TagId.DT,         "dt",         TagVersions.DT,         AttrDict.DT,         (CM_DEFLIST|CM_OPT|CM_NO_INDENT),              ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.EM,         "em",         TagVersions.EM,         AttrDict.EM,         (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.FIELDSET,   "fieldset",   TagVersions.FIELDSET,   AttrDict.FIELDSET,   (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.FONT,       "font",       TagVersions.FONT,       AttrDict.FONT,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.FORM,       "form",       TagVersions.FORM,       AttrDict.FORM,       (CM_BLOCK),                                    ParserImpl.BLOCK,    TagCheckImpl.FORM    ),
    	new Dict(TagId.FRAME,      "frame",      TagVersions.FRAME,      AttrDict.FRAME,      (CM_FRAMES|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.FRAMESET,   "frameset",   TagVersions.FRAMESET,   AttrDict.FRAMESET,   (CM_HTML|CM_FRAMES),                           ParserImpl.FRAMESET, null                 ),
    	new Dict(TagId.H1,         "h1",         TagVersions.H1,         AttrDict.H1,         (CM_BLOCK|CM_HEADING),                         ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.H2,         "h2",         TagVersions.H2,         AttrDict.H2,         (CM_BLOCK|CM_HEADING),                         ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.H3,         "h3",         TagVersions.H3,         AttrDict.H3,         (CM_BLOCK|CM_HEADING),                         ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.H4,         "h4",         TagVersions.H4,         AttrDict.H4,         (CM_BLOCK|CM_HEADING),                         ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.H5,         "h5",         TagVersions.H5,         AttrDict.H5,         (CM_BLOCK|CM_HEADING),                         ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.H6,         "h6",         TagVersions.H6,         AttrDict.H6,         (CM_BLOCK|CM_HEADING),                         ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.HEAD,       "head",       TagVersions.HEAD,       AttrDict.HEAD,       (CM_HTML|CM_OPT|CM_OMITST),                    ParserImpl.HEAD,     null                 ),
    	new Dict(TagId.HR,         "hr",         TagVersions.HR,         AttrDict.HR,         (CM_BLOCK|CM_EMPTY),                           ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.HTML,       "html",       TagVersions.HTML,       AttrDict.HTML,       (CM_HTML|CM_OPT|CM_OMITST),                    ParserImpl.HTML,     TagCheckImpl.HTML    ),
    	new Dict(TagId.I,          "i",          TagVersions.I,          AttrDict.I,          (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.IFRAME,     "iframe",     TagVersions.IFRAME,     AttrDict.IFRAME,     (CM_INLINE),                                   ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.IMG,        "img",        TagVersions.IMG,        AttrDict.IMG,        (CM_INLINE|CM_IMG|CM_EMPTY),                   ParserImpl.EMPTY,    TagCheckImpl.IMG     ),
    	new Dict(TagId.INPUT,      "input",      TagVersions.INPUT,      AttrDict.INPUT,      (CM_INLINE|CM_IMG|CM_EMPTY),                   ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.INS,        "ins",        TagVersions.INS,        AttrDict.INS,        (CM_INLINE|CM_BLOCK|CM_MIXED),                 ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.ISINDEX,    "isindex",    TagVersions.ISINDEX,    AttrDict.ISINDEX,    (CM_BLOCK|CM_EMPTY),                           ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.KBD,        "kbd",        TagVersions.KBD,        AttrDict.KBD,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.LABEL,      "label",      TagVersions.LABEL,      AttrDict.LABEL,      (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.LEGEND,     "legend",     TagVersions.LEGEND,     AttrDict.LEGEND,     (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.LI,         "li",         TagVersions.LI,         AttrDict.LI,         (CM_LIST|CM_OPT|CM_NO_INDENT),                 ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.LINK,       "link",       TagVersions.LINK,       AttrDict.LINK,       (CM_HEAD|CM_EMPTY),                            ParserImpl.EMPTY,    TagCheckImpl.LINK    ),
    	new Dict(TagId.LISTING,    "listing",    TagVersions.LISTING,    AttrDict.LISTING,    (CM_BLOCK|CM_OBSOLETE),                        ParserImpl.PRE,      null                 ),
    	new Dict(TagId.MAP,        "map",        TagVersions.MAP,        AttrDict.MAP,        (CM_INLINE),                                   ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.MENU,       "menu",       TagVersions.MENU,       AttrDict.MENU,       (CM_BLOCK|CM_OBSOLETE),                        ParserImpl.LIST,     null                 ),
    	new Dict(TagId.META,       "meta",       TagVersions.META,       AttrDict.META,       (CM_HEAD|CM_EMPTY),                            ParserImpl.EMPTY,    TagCheckImpl.META    ),
    	new Dict(TagId.NOFRAMES,   "noframes",   TagVersions.NOFRAMES,   AttrDict.NOFRAMES,   (CM_BLOCK|CM_FRAMES),                          ParserImpl.NOFRAMES, null                 ),
    	new Dict(TagId.NOSCRIPT,   "noscript",   TagVersions.NOSCRIPT,   AttrDict.NOSCRIPT,   (CM_BLOCK|CM_INLINE|CM_MIXED),                 ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.OBJECT,     "object",     TagVersions.OBJECT,     AttrDict.OBJECT,     (CM_OBJECT|CM_HEAD|CM_IMG|CM_INLINE|CM_PARAM), ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.OL,         "ol",         TagVersions.OL,         AttrDict.OL,         (CM_BLOCK),                                    ParserImpl.LIST,     null                 ),
    	new Dict(TagId.OPTGROUP,   "optgroup",   TagVersions.OPTGROUP,   AttrDict.OPTGROUP,   (CM_FIELD|CM_OPT),                             ParserImpl.OPTGROUP, null                 ),
    	new Dict(TagId.OPTION,     "option",     TagVersions.OPTION,     AttrDict.OPTION,     (CM_FIELD|CM_OPT),                             ParserImpl.TEXT,     null                 ),
    	new Dict(TagId.P,          "p",          TagVersions.P,          AttrDict.P,          (CM_BLOCK|CM_OPT),                             ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.PARAM,      "param",      TagVersions.PARAM,      AttrDict.PARAM,      (CM_INLINE|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.PLAINTEXT,  "plaintext",  TagVersions.PLAINTEXT,  AttrDict.PLAINTEXT,  (CM_BLOCK|CM_OBSOLETE),                        ParserImpl.PRE,      null                 ),
    	new Dict(TagId.PRE,        "pre",        TagVersions.PRE,        AttrDict.PRE,        (CM_BLOCK),                                    ParserImpl.PRE,      null                 ),
    	new Dict(TagId.Q,          "q",          TagVersions.Q,          AttrDict.Q,          (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.RB,         "rb",         TagVersions.RB,         AttrDict.RB,         (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.RBC,        "rbc",        TagVersions.RBC,        AttrDict.RBC,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.RP,         "rp",         TagVersions.RP,         AttrDict.RP,         (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.RT,         "rt",         TagVersions.RT,         AttrDict.RT,         (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.RTC,        "rtc",        TagVersions.RTC,        AttrDict.RTC,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.RUBY,       "ruby",       TagVersions.RUBY,       AttrDict.RUBY,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.S,          "s",          TagVersions.S,          AttrDict.S,          (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.SAMP,       "samp",       TagVersions.SAMP,       AttrDict.SAMP,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.SCRIPT,     "script",     TagVersions.SCRIPT,     AttrDict.SCRIPT,     (CM_HEAD|CM_MIXED|CM_BLOCK|CM_INLINE),         ParserImpl.SCRIPT,   TagCheckImpl.SCRIPT  ),
    	new Dict(TagId.SELECT,     "select",     TagVersions.SELECT,     AttrDict.SELECT,     (CM_INLINE|CM_FIELD),                          ParserImpl.SELECT,   null                 ),
    	new Dict(TagId.SMALL,      "small",      TagVersions.SMALL,      AttrDict.SMALL,      (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.SPAN,       "span",       TagVersions.SPAN,       AttrDict.SPAN,       (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.STRIKE,     "strike",     TagVersions.STRIKE,     AttrDict.STRIKE,     (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.STRONG,     "strong",     TagVersions.STRONG,     AttrDict.STRONG,     (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.STYLE,      "style",      TagVersions.STYLE,      AttrDict.STYLE,      (CM_HEAD),                                     ParserImpl.SCRIPT,   TagCheckImpl.STYLE   ),
    	new Dict(TagId.SUB,        "sub",        TagVersions.SUB,        AttrDict.SUB,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.SUP,        "sup",        TagVersions.SUP,        AttrDict.SUP,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.TABLE,      "table",      TagVersions.TABLE,      AttrDict.TABLE,      (CM_BLOCK),                                    ParserImpl.TABLETAG, TagCheckImpl.TABLE   ),
    	new Dict(TagId.TBODY,      "tbody",      TagVersions.TBODY,      AttrDict.TBODY,      (CM_TABLE|CM_ROWGRP|CM_OPT),                   ParserImpl.ROWGROUP, null                 ),
    	new Dict(TagId.TD,         "td",         TagVersions.TD,         AttrDict.TD,         (CM_ROW|CM_OPT|CM_NO_INDENT),                  ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.TEXTAREA,   "textarea",   TagVersions.TEXTAREA,   AttrDict.TEXTAREA,   (CM_INLINE|CM_FIELD),                          ParserImpl.TEXT,     null                 ),
    	new Dict(TagId.TFOOT,      "tfoot",      TagVersions.TFOOT,      AttrDict.TFOOT,      (CM_TABLE|CM_ROWGRP|CM_OPT),                   ParserImpl.ROWGROUP, null                 ),
    	new Dict(TagId.TH,         "th",         TagVersions.TH,         AttrDict.TH,         (CM_ROW|CM_OPT|CM_NO_INDENT),                  ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.THEAD,      "thead",      TagVersions.THEAD,      AttrDict.THEAD,      (CM_TABLE|CM_ROWGRP|CM_OPT),                   ParserImpl.ROWGROUP, null                 ),
    	new Dict(TagId.TITLE,      "title",      TagVersions.TITLE,      AttrDict.TITLE,      (CM_HEAD),                                     ParserImpl.TITLE,    null                 ),
    	new Dict(TagId.TR,         "tr",         TagVersions.TR,         AttrDict.TR,         (CM_TABLE|CM_OPT),                             ParserImpl.ROW,      null                 ),
    	new Dict(TagId.TT,         "tt",         TagVersions.TT,         AttrDict.TT,         (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.U,          "u",          TagVersions.U,          AttrDict.U,          (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.UL,         "ul",         TagVersions.UL,         AttrDict.UL,         (CM_BLOCK),                                    ParserImpl.LIST,     null                 ),
    	new Dict(TagId.VAR,        "var",        TagVersions.VAR,        AttrDict.VAR,        (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.XMP,        "xmp",        TagVersions.XMP,        AttrDict.XMP,        (CM_BLOCK|CM_OBSOLETE),                        ParserImpl.PRE,      null                 ),
    	new Dict(TagId.NEXTID,     "nextid",     TagVersions.NEXTID,     AttrDict.NEXTID,     (CM_HEAD|CM_EMPTY),                            ParserImpl.EMPTY,    null                 ),

    	/* proprietary elements */
    	new Dict(TagId.ALIGN,      "align",      VERS_NETSCAPE,          null,                (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.BGSOUND,    "bgsound",    VERS_MICROSOFT,         null,                (CM_HEAD|CM_EMPTY),                            ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.BLINK,      "blink",      VERS_PROPRIETARY,       null,                (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.COMMENT,    "comment",    VERS_MICROSOFT,         null,                (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.EMBED,      "embed",      VERS_NETSCAPE,          null,                (CM_INLINE|CM_IMG|CM_EMPTY),                   ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.ILAYER,     "ilayer",     VERS_NETSCAPE,          null,                (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.KEYGEN,     "keygen",     VERS_NETSCAPE,          null,                (CM_INLINE|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.LAYER,      "layer",      VERS_NETSCAPE,          null,                (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.MARQUEE,    "marquee",    VERS_MICROSOFT,         null,                (CM_INLINE|CM_OPT),                            ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.MULTICOL,   "multicol",   VERS_NETSCAPE,          null,                (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.NOBR,       "nobr",       VERS_PROPRIETARY,       null,                (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.NOEMBED,    "noembed",    VERS_NETSCAPE,          null,                (CM_INLINE),                                   ParserImpl.INLINE,   null                 ),
    	new Dict(TagId.NOLAYER,    "nolayer",    VERS_NETSCAPE,          null,                (CM_BLOCK|CM_INLINE|CM_MIXED),                 ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.NOSAVE,     "nosave",     VERS_NETSCAPE,          null,                (CM_BLOCK),                                    ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.SERVER,     "server",     VERS_NETSCAPE,          null,                (CM_HEAD|CM_MIXED|CM_BLOCK|CM_INLINE),         ParserImpl.SCRIPT,   null                 ),
    	new Dict(TagId.SERVLET,    "servlet",    VERS_SUN,               null,                (CM_OBJECT|CM_IMG|CM_INLINE|CM_PARAM),         ParserImpl.BLOCK,    null                 ),
    	new Dict(TagId.SPACER,     "spacer",     VERS_NETSCAPE,          null,                (CM_INLINE|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    	new Dict(TagId.WBR,        "wbr",        VERS_PROPRIETARY,       null,                (CM_INLINE|CM_EMPTY),                          ParserImpl.EMPTY,    null                 ),
    };

    /**
     * anchor/node map
     */
    protected Map<String, Node> anchorMap = new HashMap<String, Node>();
    protected Map<Node, String> anchorByNode = new HashMap<Node, String>();

    /**
     * configuration.
     */
    private Configuration configuration;

    /**
     * hashTable containing tags.
     */
    private Map<String, Dict> tagHashtable = new Hashtable<String, Dict>();

    /**
     * Instantiates a new tag table with known tags.
     */
    protected TagTable()
    {
        for (int i = 0; i < TAGS.length; i++)
        {
            install(TAGS[i]);
        }
    }

    /**
     * Setter for the current configuration instance.
     * @param configuration configuration instance
     */
    public void setConfiguration(Configuration configuration)
    {
        this.configuration = configuration;
    }

    /**
     * Lookup a tag definition by its name.
     * @param name tag name
     * @return tag definition (Dict)
     */
    public Dict lookup(String name)
    {
        return tagHashtable.get(name);
    }
    
    public Dict lookup(final TagId tid) {
    	if (tid == TagId.UNKNOWN) {
    		return null;
    	}
        for (Dict np : tagHashtable.values()) {
            if (np.id == tid) {
                return np;
            }
        }
        return null;
    }

    /**
     * Installs a new tag in the tag table, or modify an existing one.
     * @param dict tag definition
     * @return installed Dict instance
     */
    public Dict install(Dict dict)
    {
        Dict d = tagHashtable.get(dict.name);
        if (d != null)
        {
            d.versions = dict.versions;
            d.model |= dict.model;
            d.setParser(dict.getParser());
            d.setChkattrs(dict.getChkattrs());
            return d;
        }

        tagHashtable.put(dict.name, dict);
        return dict;

    }

    /**
     * Finds a tag by name.
     * @param node Node to find. If the element is found the tag property of node will be set.
     * @return true if the tag is found, false otherwise
     */
    public boolean findTag(Node node)
    {
        Dict np;

        if (configuration != null && configuration.xmlTags)
        {
            node.tag = XML_TAGS;
            return true;
        }

        if (node.element != null)
        {
            np = lookup(node.element);
            if (np != null)
            {
                node.tag = np;
                return true;
            }
        }

        return false;
    }

    /**
     * Finds a parser fo the given node.
     * @param node Node
     * @return parser for the node
     */
    public Parser findParser(Node node)
    {
        Dict np;

        if (node.element != null)
        {
            np = lookup(node.element);
            if (np != null)
            {
                return np.getParser();
            }
        }

        return null;
    }

    /**
     * Defines a new tag.
     * @param tagType tag type. Can be TAGTYPE_BLOCK | TAGTYPE_EMPTY | TAGTYPE_PRE | TAGTYPE_INLINE
     * @param name tag name
     */
    public void defineTag(short tagType, String name)
    {
        Parser tagParser;
        int model;

        switch (tagType)
        {
            case Dict.TAGTYPE_BLOCK :
                model = (Dict.CM_BLOCK | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.BLOCK;
                break;

            case Dict.TAGTYPE_EMPTY :
                model = (Dict.CM_EMPTY | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.BLOCK;
                break;

            case Dict.TAGTYPE_PRE :
                model = (Dict.CM_BLOCK | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.PRE;
                break;

            case Dict.TAGTYPE_INLINE :
            default :
                // default to inline tag
                model = (Dict.CM_INLINE | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.INLINE;
                break;
        }

        install(new Dict(TagId.UNKNOWN, name, VERS_PROPRIETARY, null, model, tagParser, null));
    }

    /**
     * return a List containing all the user-defined tag names.
     * @param tagType one of Dict.TAGTYPE_EMPTY | Dict.TAGTYPE_INLINE | Dict.TAGTYPE_BLOCK | Dict.TAGTYPE_PRE
     * @return List containing all the user-defined tag names
     */
    List<String> findAllDefinedTag(short tagType)
    {
        List<String> tagNames = new ArrayList<String>();

        for (Dict curDictEntry : tagHashtable.values())
        {
            if (curDictEntry != null)
            {
                switch (tagType)
                {
                    // defined tags can be empty + inline
                    case Dict.TAGTYPE_EMPTY :
                        if ((curDictEntry.versions == VERS_PROPRIETARY)
                            && ((curDictEntry.model & Dict.CM_EMPTY) == Dict.CM_EMPTY)
                            && // (curDictEntry.parser == ParseBlock) &&
                            (curDictEntry.id != TagId.WBR))
                        {
                            tagNames.add(curDictEntry.name);
                        }
                        break;

                    // defined tags can be empty + inline
                    case Dict.TAGTYPE_INLINE :
                        if ((curDictEntry.versions == VERS_PROPRIETARY)
                            && ((curDictEntry.model & Dict.CM_INLINE) == Dict.CM_INLINE)
                            && // (curDictEntry.parser == ParseInline) &&
                            (curDictEntry.id != TagId.BLINK)
                            && (curDictEntry.id != TagId.NOBR)
                            && (curDictEntry.id != TagId.WBR))
                        {
                            tagNames.add(curDictEntry.name);
                        }
                        break;

                    // defined tags can be empty + block
                    case Dict.TAGTYPE_BLOCK :
                        if ((curDictEntry.versions == VERS_PROPRIETARY)
                            && ((curDictEntry.model & Dict.CM_BLOCK) == Dict.CM_BLOCK)
                            && (curDictEntry.getParser() == ParserImpl.BLOCK))
                        {
                            tagNames.add(curDictEntry.name);
                        }
                        break;

                    case Dict.TAGTYPE_PRE :
                        if ((curDictEntry.versions == VERS_PROPRIETARY)
                            && ((curDictEntry.model & Dict.CM_BLOCK) == Dict.CM_BLOCK)
                            && (curDictEntry.getParser() == ParserImpl.PRE))
                        {
                            tagNames.add(curDictEntry.name);
                        }
                        break;
                }
            }
        }

        return tagNames;
    }

    /**
     * Free node's attributes.
     * @param node Node
     */
    public void freeAttrs(Node node)
    {
        while (node.attributes != null)
        {
            AttVal av = node.attributes;
            if ("id".equalsIgnoreCase(av.attribute) || "name".equalsIgnoreCase(av.attribute) && node.isAnchorElement())
            {
                removeAnchorByNode(node);
            }

            node.attributes = av.next;
        }
    }

    /**
     * Removes anchor for specific node.
     * @param node Node
     */
    void removeAnchorByNode(final Node node) {
    	final String s = anchorByNode.get(node);
    	if (s == null) {
    		return;
    	}
    	anchorByNode.remove(node);
    	anchorMap.remove(s);
    }

    /**
     * Adds a new anchor to namespace.
     * @param name anchor name
     * @param node destination for this anchor
     * @return Anchor
     */
    void addAnchor(final String name, final Node node) {
    	final String s = name.toLowerCase();
    	anchorMap.put(s, node);
    	anchorByNode.put(node, s);
    }

    /**
     * Return node associated with anchor.
     * @param name anchor name
     * @return node associated with anchor
     */
    Node getNodeByAnchor(final String name) {
    	return anchorMap.get(name.toLowerCase());
    }

    /**
     * free all anchors.
     */
    void freeAnchors()
    {
        anchorMap.clear();
        anchorByNode.clear();
    }

}