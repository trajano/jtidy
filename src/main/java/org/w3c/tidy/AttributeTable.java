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

import java.util.Hashtable;
import java.util.Map;

import static org.w3c.tidy.Versions.*;

/**
 * HTML attribute hash table.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public class AttributeTable
{
    /**
     * attribute table instance.
     */
    private static AttributeTable defaultAttributeTable;

    /**
     * all the known attributes.
     */
    private static final Attribute[] ATTRS = {
    	new Attribute(AttrId.UNKNOWN,           "unknown!",          VERS_PROPRIETARY,  null         ), 
    	new Attribute(AttrId.ABBR,              "abbr",              VERS_HTML40,       AttrCheckImpl.PCDATA    ), 
    	new Attribute(AttrId.ACCEPT,            "accept",            VERS_ALL,          AttrCheckImpl.XTYPE     ), 
    	new Attribute(AttrId.ACCEPT_CHARSET,    "accept-charset",    VERS_HTML40,       AttrCheckImpl.CHARSET   ), 
    	new Attribute(AttrId.ACCESSKEY,         "accesskey",         VERS_HTML40,       AttrCheckImpl.CHARACTER ), 
    	new Attribute(AttrId.ACTION,            "action",            VERS_ALL,          AttrCheckImpl.ACTION    ), 
    	new Attribute(AttrId.ADD_DATE,          "add_date",          VERS_NETSCAPE,     AttrCheckImpl.PCDATA    ), /* A */
    	new Attribute(AttrId.ALIGN,             "align",             VERS_ALL,          AttrCheckImpl.ALIGN     ), /* varies by element */
    	new Attribute(AttrId.ALINK,             "alink",             VERS_LOOSE,        AttrCheckImpl.COLOR     ), 
    	new Attribute(AttrId.ALT,               "alt",               VERS_ALL,          AttrCheckImpl.PCDATA    ), /* nowrap */
    	new Attribute(AttrId.ARCHIVE,           "archive",           VERS_HTML40,       AttrCheckImpl.URLS      ), /* space or comma separated list */
    	new Attribute(AttrId.AXIS,              "axis",              VERS_HTML40,       AttrCheckImpl.PCDATA    ), 
    	new Attribute(AttrId.BACKGROUND,        "background",        VERS_LOOSE,        AttrCheckImpl.URL       ), 
    	new Attribute(AttrId.BGCOLOR,           "bgcolor",           VERS_LOOSE,        AttrCheckImpl.COLOR     ), 
    	new Attribute(AttrId.BGPROPERTIES,      "bgproperties",      VERS_PROPRIETARY,  AttrCheckImpl.PCDATA    ), /* BODY "fixed" fixes background */
    	new Attribute(AttrId.BORDER,            "border",            VERS_ALL,          AttrCheckImpl.BORDER    ), /* like LENGTH + "border" */
    	new Attribute(AttrId.BORDERCOLOR,       "bordercolor",       VERS_MICROSOFT,    AttrCheckImpl.COLOR     ), /* used on TABLE */
    	new Attribute(AttrId.BOTTOMMARGIN,      "bottommargin",      VERS_MICROSOFT,    AttrCheckImpl.NUMBER    ), /* used on BODY */
    	new Attribute(AttrId.CELLPADDING,       "cellpadding",       VERS_FROM32,       AttrCheckImpl.LENGTH    ), /* % or pixel values */
    	new Attribute(AttrId.CELLSPACING,       "cellspacing",       VERS_FROM32,       AttrCheckImpl.LENGTH    ), 
    	new Attribute(AttrId.CHAR,              "char",              VERS_HTML40,       AttrCheckImpl.CHARACTER ), 
    	new Attribute(AttrId.CHAROFF,           "charoff",           VERS_HTML40,       AttrCheckImpl.LENGTH    ), 
    	new Attribute(AttrId.CHARSET,           "charset",           VERS_HTML40,       AttrCheckImpl.CHARSET   ), 
    	new Attribute(AttrId.CHECKED,           "checked",           VERS_ALL,          AttrCheckImpl.BOOL      ), /* i.e. "checked" or absent */
    	new Attribute(AttrId.CITE,              "cite",              VERS_HTML40,       AttrCheckImpl.URL       ), 
    	new Attribute(AttrId.CLASS,             "class",             VERS_HTML40,       AttrCheckImpl.PCDATA    ), 
    	new Attribute(AttrId.CLASSID,           "classid",           VERS_HTML40,       AttrCheckImpl.URL       ), 
    	new Attribute(AttrId.CLEAR,             "clear",             VERS_LOOSE,        AttrCheckImpl.CLEAR     ), /* BR: left, right, all */
    	new Attribute(AttrId.CODE,              "code",              VERS_LOOSE,        AttrCheckImpl.PCDATA    ), /* APPLET */
    	new Attribute(AttrId.CODEBASE,          "codebase",          VERS_HTML40,       AttrCheckImpl.URL       ), /* OBJECT */
    	new Attribute(AttrId.CODETYPE,          "codetype",          VERS_HTML40,       AttrCheckImpl.XTYPE     ), /* OBJECT */
    	new Attribute(AttrId.COLOR,             "color",             VERS_LOOSE,        AttrCheckImpl.COLOR     ), /* BASEFONT, FONT */
    	new Attribute(AttrId.COLS,              "cols",              VERS_IFRAME,       AttrCheckImpl.COLS      ), /* TABLE & FRAMESET */
    	new Attribute(AttrId.COLSPAN,           "colspan",           VERS_FROM32,       AttrCheckImpl.NUMBER    ), 
    	new Attribute(AttrId.COMPACT,           "compact",           VERS_ALL,          AttrCheckImpl.BOOL      ), /* lists */
    	new Attribute(AttrId.CONTENT,           "content",           VERS_ALL,          AttrCheckImpl.PCDATA    ), 
    	new Attribute(AttrId.COORDS,            "coords",            VERS_FROM32,       AttrCheckImpl.COORDS    ), /* AREA, A */
    	new Attribute(AttrId.DATA,              "data",              VERS_HTML40,       AttrCheckImpl.URL       ), /* OBJECT */
    	new Attribute(AttrId.DATAFLD,           "datafld",           VERS_MICROSOFT,    AttrCheckImpl.PCDATA    ), /* used on DIV, IMG */
    	new Attribute(AttrId.DATAFORMATAS,      "dataformatas",      VERS_MICROSOFT,    AttrCheckImpl.PCDATA    ), /* used on DIV, IMG */
    	new Attribute(AttrId.DATAPAGESIZE,      "datapagesize",      VERS_MICROSOFT,    AttrCheckImpl.NUMBER    ), /* used on DIV, IMG */
    	new Attribute(AttrId.DATASRC,           "datasrc",           VERS_MICROSOFT,    AttrCheckImpl.URL       ), /* used on TABLE */
    	new Attribute(AttrId.DATETIME,          "datetime",          VERS_HTML40,       AttrCheckImpl.DATE      ), /* INS, DEL */
    	new Attribute(AttrId.DECLARE,           "declare",           VERS_HTML40,       AttrCheckImpl.BOOL      ), /* OBJECT */
    	new Attribute(AttrId.DEFER,             "defer",             VERS_HTML40,       AttrCheckImpl.BOOL      ), /* SCRIPT */
    	new Attribute(AttrId.DIR,               "dir",               VERS_HTML40,       AttrCheckImpl.TEXTDIR   ), /* ltr or rtl */
    	new Attribute(AttrId.DISABLED,          "disabled",          VERS_HTML40,       AttrCheckImpl.BOOL      ), /* form fields */
    	new Attribute(AttrId.ENCODING,          "encoding",          VERS_XML,          AttrCheckImpl.PCDATA    ), /* <?xml?> */
    	new Attribute(AttrId.ENCTYPE,           "enctype",           VERS_ALL,          AttrCheckImpl.XTYPE     ), /* FORM */
    	new Attribute(AttrId.FACE,              "face",              VERS_LOOSE,        AttrCheckImpl.PCDATA    ), /* BASEFONT, FONT */
    	new Attribute(AttrId.FOR,               "for",               VERS_HTML40,       AttrCheckImpl.IDREF     ), /* LABEL */
    	new Attribute(AttrId.FRAME,             "frame",             VERS_HTML40,       AttrCheckImpl.TFRAME    ), /* TABLE */
    	new Attribute(AttrId.FRAMEBORDER,       "frameborder",       VERS_FRAMESET,     AttrCheckImpl.FBORDER   ), /* 0 or 1 */
    	new Attribute(AttrId.FRAMESPACING,      "framespacing",      VERS_PROPRIETARY,  AttrCheckImpl.NUMBER    ), 
    	new Attribute(AttrId.GRIDX,             "gridx",             VERS_PROPRIETARY,  AttrCheckImpl.NUMBER    ), /* TABLE Adobe golive*/
    	new Attribute(AttrId.GRIDY,             "gridy",             VERS_PROPRIETARY,  AttrCheckImpl.NUMBER    ), /* TABLE Adobe golive */
    	new Attribute(AttrId.HEADERS,           "headers",           VERS_HTML40,       AttrCheckImpl.IDREFS    ), /* table cells */
    	new Attribute(AttrId.HEIGHT,            "height",            VERS_ALL,          AttrCheckImpl.LENGTH    ), /* pixels only for TH/TD */
    	new Attribute(AttrId.HREF,              "href",              VERS_ALL,          AttrCheckImpl.URL       ), /* A, AREA, LINK and BASE */
    	new Attribute(AttrId.HREFLANG,          "hreflang",          VERS_HTML40,       AttrCheckImpl.LANG      ), /* A, LINK */
    	new Attribute(AttrId.HSPACE,            "hspace",            VERS_ALL,          AttrCheckImpl.NUMBER    ), /* APPLET, IMG, OBJECT */
    	new Attribute(AttrId.HTTP_EQUIV,        "http-equiv",        VERS_ALL,          AttrCheckImpl.PCDATA    ), /* META */
    	new Attribute(AttrId.ID,                "id",                VERS_HTML40,       AttrCheckImpl.IDDEF     ), 
    	new Attribute(AttrId.ISMAP,             "ismap",             VERS_ALL,          AttrCheckImpl.BOOL      ), /* IMG */
    	new Attribute(AttrId.LABEL,             "label",             VERS_HTML40,       AttrCheckImpl.PCDATA    ), /* OPT, OPTGROUP */
    	new Attribute(AttrId.LANG,              "lang",              VERS_HTML40,       AttrCheckImpl.LANG      ), 
    	new Attribute(AttrId.LANGUAGE,          "language",          VERS_LOOSE,        AttrCheckImpl.PCDATA    ), /* SCRIPT */
    	new Attribute(AttrId.LAST_MODIFIED,     "last_modified",     VERS_NETSCAPE,     AttrCheckImpl.PCDATA    ), /* A */
    	new Attribute(AttrId.LAST_VISIT,        "last_visit",        VERS_NETSCAPE,     AttrCheckImpl.PCDATA    ), /* A */
    	new Attribute(AttrId.LEFTMARGIN,        "leftmargin",        VERS_MICROSOFT,    AttrCheckImpl.NUMBER    ), /* used on BODY */
    	new Attribute(AttrId.LINK,              "link",              VERS_LOOSE,        AttrCheckImpl.COLOR     ), /* BODY */
    	new Attribute(AttrId.LONGDESC,          "longdesc",          VERS_HTML40,       AttrCheckImpl.URL       ), /* IMG */
    	new Attribute(AttrId.LOWSRC,            "lowsrc",            VERS_PROPRIETARY,  AttrCheckImpl.URL       ), /* IMG */
    	new Attribute(AttrId.MARGINHEIGHT,      "marginheight",      VERS_IFRAME,       AttrCheckImpl.NUMBER    ), /* FRAME, IFRAME, BODY */
    	new Attribute(AttrId.MARGINWIDTH,       "marginwidth",       VERS_IFRAME,       AttrCheckImpl.NUMBER    ), /* ditto */
    	new Attribute(AttrId.MAXLENGTH,         "maxlength",         VERS_ALL,          AttrCheckImpl.NUMBER    ), /* INPUT */
    	new Attribute(AttrId.MEDIA,             "media",             VERS_HTML40,       AttrCheckImpl.MEDIA     ), /* STYLE, LINK */
    	new Attribute(AttrId.METHOD,            "method",            VERS_ALL,          AttrCheckImpl.FSUBMIT   ), /* FORM: get or post */
    	new Attribute(AttrId.MULTIPLE,          "multiple",          VERS_ALL,          AttrCheckImpl.BOOL      ), /* SELECT */
    	new Attribute(AttrId.NAME,              "name",              VERS_ALL,          AttrCheckImpl.NAME      ), 
    	new Attribute(AttrId.NOHREF,            "nohref",            VERS_FROM32,       AttrCheckImpl.BOOL      ), /* AREA */
    	new Attribute(AttrId.NORESIZE,          "noresize",          VERS_FRAMESET,     AttrCheckImpl.BOOL      ), /* FRAME */
    	new Attribute(AttrId.NOSHADE,           "noshade",           VERS_LOOSE,        AttrCheckImpl.BOOL      ), /* HR */
    	new Attribute(AttrId.NOWRAP,            "nowrap",            VERS_LOOSE,        AttrCheckImpl.BOOL      ), /* table cells */
    	new Attribute(AttrId.OBJECT,            "object",            VERS_HTML40_LOOSE, AttrCheckImpl.PCDATA    ), /* APPLET */
    	new Attribute(AttrId.OnAFTERUPDATE,     "onafterupdate",     VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), 
    	new Attribute(AttrId.OnBEFOREUNLOAD,    "onbeforeunload",    VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), 
    	new Attribute(AttrId.OnBEFOREUPDATE,    "onbeforeupdate",    VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), 
    	new Attribute(AttrId.OnBLUR,            "onblur",            VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnCHANGE,          "onchange",          VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnCLICK,           "onclick",           VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnDATAAVAILABLE,   "ondataavailable",   VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), /* object, applet */
    	new Attribute(AttrId.OnDATASETCHANGED,  "ondatasetchanged",  VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), /* object, applet */
    	new Attribute(AttrId.OnDATASETCOMPLETE, "ondatasetcomplete", VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), 
    	new Attribute(AttrId.OnDBLCLICK,        "ondblclick",        VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnERRORUPDATE,     "onerrorupdate",     VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), /* form fields */
    	new Attribute(AttrId.OnFOCUS,           "onfocus",           VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnKEYDOWN,         "onkeydown",         VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnKEYPRESS,        "onkeypress",        VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnKEYUP,           "onkeyup",           VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnLOAD,            "onload",            VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnMOUSEDOWN,       "onmousedown",       VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnMOUSEMOVE,       "onmousemove",       VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnMOUSEOUT,        "onmouseout",        VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnMOUSEOVER,       "onmouseover",       VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnMOUSEUP,         "onmouseup",         VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnRESET,           "onreset",           VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnROWENTER,        "onrowenter",        VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), /* form fields */
    	new Attribute(AttrId.OnROWEXIT,         "onrowexit",         VERS_MICROSOFT,    AttrCheckImpl.SCRIPT    ), /* form fields */
    	new Attribute(AttrId.OnSELECT,          "onselect",          VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnSUBMIT,          "onsubmit",          VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.OnUNLOAD,          "onunload",          VERS_EVENTS,       AttrCheckImpl.SCRIPT    ), /* event */
    	new Attribute(AttrId.PROFILE,           "profile",           VERS_HTML40,       AttrCheckImpl.URL       ), /* HEAD */
    	new Attribute(AttrId.PROMPT,            "prompt",            VERS_LOOSE,        AttrCheckImpl.PCDATA    ), /* ISINDEX */
    	new Attribute(AttrId.RBSPAN,            "rbspan",            VERS_XHTML11,      AttrCheckImpl.NUMBER    ), /* ruby markup */
    	new Attribute(AttrId.READONLY,          "readonly",          VERS_HTML40,       AttrCheckImpl.BOOL      ), /* form fields */
    	new Attribute(AttrId.REL,               "rel",               VERS_ALL,          AttrCheckImpl.LINKTYPES ), 
    	new Attribute(AttrId.REV,               "rev",               VERS_ALL,          AttrCheckImpl.LINKTYPES ), 
    	new Attribute(AttrId.RIGHTMARGIN,       "rightmargin",       VERS_MICROSOFT,    AttrCheckImpl.NUMBER    ), /* used on BODY */
    	new Attribute(AttrId.ROWS,              "rows",              VERS_ALL,          AttrCheckImpl.NUMBER    ), /* TEXTAREA */
    	new Attribute(AttrId.ROWSPAN,           "rowspan",           VERS_ALL,          AttrCheckImpl.NUMBER    ), /* table cells */
    	new Attribute(AttrId.RULES,             "rules",             VERS_HTML40,       AttrCheckImpl.TRULES    ), /* TABLE */
    	new Attribute(AttrId.SCHEME,            "scheme",            VERS_HTML40,       AttrCheckImpl.PCDATA    ), /* META */
    	new Attribute(AttrId.SCOPE,             "scope",             VERS_HTML40,       AttrCheckImpl.SCOPE     ), /* table cells */
    	new Attribute(AttrId.SCROLLING,         "scrolling",         VERS_IFRAME,       AttrCheckImpl.SCROLL    ), /* yes, no or auto */
    	new Attribute(AttrId.SELECTED,          "selected",          VERS_ALL,          AttrCheckImpl.BOOL      ), /* OPTION */
    	new Attribute(AttrId.SHAPE,             "shape",             VERS_FROM32,       AttrCheckImpl.SHAPE     ), /* AREA, A */
    	new Attribute(AttrId.SHOWGRID,          "showgrid",          VERS_PROPRIETARY,  AttrCheckImpl.BOOL      ), /* TABLE Adobe golive */
    	new Attribute(AttrId.SHOWGRIDX,         "showgridx",         VERS_PROPRIETARY,  AttrCheckImpl.BOOL      ), /* TABLE Adobe golive*/
    	new Attribute(AttrId.SHOWGRIDY,         "showgridy",         VERS_PROPRIETARY,  AttrCheckImpl.BOOL      ), /* TABLE Adobe golive*/
    	new Attribute(AttrId.SIZE,              "size",              VERS_LOOSE,        AttrCheckImpl.NUMBER    ), /* HR, FONT, BASEFONT, SELECT */
    	new Attribute(AttrId.SPAN,              "span",              VERS_HTML40,       AttrCheckImpl.NUMBER    ), /* COL, COLGROUP */
    	new Attribute(AttrId.SRC,               "src",               VERS_ALL,          AttrCheckImpl.URL       ), /* IMG, FRAME, IFRAME */
    	new Attribute(AttrId.STANDBY,           "standby",           VERS_HTML40,       AttrCheckImpl.PCDATA    ), /* OBJECT */
    	new Attribute(AttrId.START,             "start",             VERS_ALL,          AttrCheckImpl.NUMBER    ), /* OL */
    	new Attribute(AttrId.STYLE,             "style",             VERS_HTML40,       AttrCheckImpl.PCDATA    ), 
    	new Attribute(AttrId.SUMMARY,           "summary",           VERS_HTML40,       AttrCheckImpl.PCDATA    ), /* TABLE */
    	new Attribute(AttrId.TABINDEX,          "tabindex",          VERS_HTML40,       AttrCheckImpl.NUMBER    ), /* fields, OBJECT  and A */
    	new Attribute(AttrId.TARGET,            "target",            VERS_HTML40,       AttrCheckImpl.TARGET    ), /* names a frame/window */
    	new Attribute(AttrId.TEXT,              "text",              VERS_LOOSE,        AttrCheckImpl.COLOR     ), /* BODY */
    	new Attribute(AttrId.TITLE,             "title",             VERS_HTML40,       AttrCheckImpl.PCDATA    ), /* text tool tip */
    	new Attribute(AttrId.TOPMARGIN,         "topmargin",         VERS_MICROSOFT,    AttrCheckImpl.NUMBER    ), /* used on BODY */
    	new Attribute(AttrId.TYPE,              "type",              VERS_FROM32,       AttrCheckImpl.TYPE      ), /* also used by SPACER */
    	new Attribute(AttrId.USEMAP,            "usemap",            VERS_ALL,          AttrCheckImpl.URL       ), /* things with images */
    	new Attribute(AttrId.VALIGN,            "valign",            VERS_FROM32,       AttrCheckImpl.VALIGN    ), 
    	new Attribute(AttrId.VALUE,             "value",             VERS_ALL,          AttrCheckImpl.PCDATA    ), 
    	new Attribute(AttrId.VALUETYPE,         "valuetype",         VERS_HTML40,       AttrCheckImpl.VTYPE     ), /* PARAM: data, ref, object */
    	new Attribute(AttrId.VERSION,           "version",           VERS_ALL|VERS_XML, AttrCheckImpl.PCDATA    ), /* HTML <?xml?> */
    	new Attribute(AttrId.VLINK,             "vlink",             VERS_LOOSE,        AttrCheckImpl.COLOR     ), /* BODY */
    	new Attribute(AttrId.VSPACE,            "vspace",            VERS_LOOSE,        AttrCheckImpl.NUMBER    ), /* IMG, OBJECT, APPLET */
    	new Attribute(AttrId.WIDTH,             "width",             VERS_ALL,          AttrCheckImpl.LENGTH    ), /* pixels only for TD/TH */
    	new Attribute(AttrId.WRAP,              "wrap",              VERS_NETSCAPE,     AttrCheckImpl.PCDATA    ), /* textarea */
    	new Attribute(AttrId.XML_LANG,          "xml:lang",          VERS_XML,          AttrCheckImpl.LANG      ), /* XML language */
    	new Attribute(AttrId.XML_SPACE,         "xml:space",         VERS_XML,          AttrCheckImpl.PCDATA    ), /* XML white space */

    	/* todo: VERS_ALL is wrong! */
    	new Attribute(AttrId.XMLNS,             "xmlns",             VERS_ALL,          AttrCheckImpl.PCDATA    ), /* name space */
    	new Attribute(AttrId.EVENT,             "event",             VERS_HTML40,       AttrCheckImpl.PCDATA    ), /* reserved for <script> */
    	new Attribute(AttrId.METHODS,           "methods",           VERS_HTML20,       AttrCheckImpl.PCDATA    ), /* for <a>, never implemented */
    	new Attribute(AttrId.N,                 "n",                 VERS_HTML20,       AttrCheckImpl.PCDATA    ), /* for <nextid> */
    	new Attribute(AttrId.SDAFORM,           "sdaform",           VERS_HTML20,       AttrCheckImpl.PCDATA    ), /* SDATA attribute in HTML 2.0 */
    	new Attribute(AttrId.SDAPREF,           "sdapref",           VERS_HTML20,       AttrCheckImpl.PCDATA    ), /* SDATA attribute in HTML 2.0 */
    	new Attribute(AttrId.SDASUFF,           "sdasuff",           VERS_HTML20,       AttrCheckImpl.PCDATA    ), /* SDATA attribute in HTML 2.0 */
    	new Attribute(AttrId.URN,               "urn",               VERS_HTML20,       AttrCheckImpl.PCDATA    ), /* for <a>, never implemented */
    };

    /**
     * Map containing all the installed attributes.
     */
    private Map attributeHashtable = new Hashtable();

    /**
     * lookup an installed Attribute.
     * @param name attribute name
     * @return Attribute or null if the attribute is not found
     */
    public Attribute lookup(String name)
    {
        return (Attribute) this.attributeHashtable.get(name);
    }

    /**
     * installs a new Attribute.
     * @param attr Atribute
     * @return installed Attribute
     */
    public Attribute install(Attribute attr)
    {
        return (Attribute) this.attributeHashtable.put(attr.getName(), attr);
    }

    /**
     * public method for finding attribute definition by name.
     * @param attval AttVal instance
     * @return Attribute with name = attval.name
     */
    public Attribute findAttribute(AttVal attval)
    {
        Attribute np;

        if (attval.attribute != null)
        {
            np = lookup(attval.attribute);
            return np;
        }

        return null;
    }

    /**
     * Does the given attibute contains an url?
     * @param attrname attribute name
     * @return <code>true</code> if the given attribute is expected to contain an URL
     */
    public boolean isUrl(String attrname)
    {
        Attribute np;

        np = lookup(attrname);
        return (np != null && np.getAttrchk() == AttrCheckImpl.URL);
    }

    /**
     * Does the given attibute contains a script?
     * @param attrname attribute name
     * @return <code>true</code> if the given attribute is expected to contain a script
     */
    public boolean isScript(String attrname)
    {
        Attribute np;

        np = lookup(attrname);
        return (np != null && np.getAttrchk() == AttrCheckImpl.SCRIPT);
    }

    /**
     * Returns the default attribute table instance.
     * @return AttributeTable instance
     */
    public static AttributeTable getDefaultAttributeTable()
    {
        if (defaultAttributeTable == null)
        {
            defaultAttributeTable = new AttributeTable();
            for (int i = 0; i < ATTRS.length; i++)
            {
                defaultAttributeTable.install(ATTRS[i]);
            }
        }
        return defaultAttributeTable;
    }

}