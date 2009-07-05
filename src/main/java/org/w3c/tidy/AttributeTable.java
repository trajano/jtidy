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
        new Attribute("abbr", VERS_HTML40, AttrCheckImpl.TEXT),
        new Attribute("accept-charset", VERS_HTML40, AttrCheckImpl.CHARSET),
        new Attribute("accept", VERS_ALL, AttrCheckImpl.TYPE),
        new Attribute("accesskey", VERS_HTML40, AttrCheckImpl.CHARACTER),
        new Attribute("action", VERS_ALL, AttrCheckImpl.URL),
        new Attribute("add_date", VERS_NETSCAPE, AttrCheckImpl.TEXT), // A
        new Attribute("align", VERS_ALL, AttrCheckImpl.ALIGN), // set varies with element
        new Attribute("alink", VERS_LOOSE, AttrCheckImpl.COLOR),
        new Attribute("alt", VERS_ALL, AttrCheckImpl.TEXT),
        new Attribute("archive", VERS_HTML40, AttrCheckImpl.URLS), // space or comma separated list
        new Attribute("axis", VERS_HTML40, AttrCheckImpl.TEXT),
        new Attribute("background", VERS_LOOSE, AttrCheckImpl.URL),
        new Attribute("bgcolor", VERS_LOOSE, AttrCheckImpl.COLOR),
        new Attribute("bgproperties", VERS_PROPRIETARY, AttrCheckImpl.TEXT), // BODY "fixed" fixes background
        new Attribute("border", VERS_ALL, AttrCheckImpl.BOOL), // like LENGTH + "border"
        new Attribute("bordercolor", VERS_MICROSOFT, AttrCheckImpl.COLOR), // used on TABLE
        new Attribute("bottommargin", VERS_MICROSOFT, AttrCheckImpl.NUMBER), // used on BODY
        new Attribute("cellpadding", VERS_FROM32, AttrCheckImpl.LENGTH), // % or pixel values
        new Attribute("cellspacing", VERS_FROM32, AttrCheckImpl.LENGTH),
        new Attribute("char", VERS_HTML40, AttrCheckImpl.CHARACTER),
        new Attribute("charoff", VERS_HTML40, AttrCheckImpl.LENGTH),
        new Attribute("charset", VERS_HTML40, AttrCheckImpl.CHARSET),
        new Attribute("checked", VERS_ALL, AttrCheckImpl.BOOL), // i.e. "checked" or absent
        new Attribute("cite", VERS_HTML40, AttrCheckImpl.URL),
        new Attribute("class", VERS_HTML40, AttrCheckImpl.TEXT),
        new Attribute("classid", VERS_HTML40, AttrCheckImpl.URL),
        new Attribute("clear", VERS_LOOSE, AttrCheckImpl.CLEAR), // BR: left, right, all
        new Attribute("code", VERS_LOOSE, AttrCheckImpl.TEXT), // APPLET
        new Attribute("codebase", VERS_HTML40, AttrCheckImpl.URL), // OBJECT
        new Attribute("codetype", VERS_HTML40, AttrCheckImpl.TYPE), // OBJECT
        new Attribute("color", VERS_LOOSE, AttrCheckImpl.COLOR), // BASEFONT, FONT
        new Attribute("cols", VERS_IFRAME, AttrCheckImpl.COLS), // TABLE & FRAMESET
        new Attribute("colspan", VERS_FROM32, AttrCheckImpl.NUMBER),
        new Attribute("compact", VERS_ALL, AttrCheckImpl.BOOL), // lists
        new Attribute("content", VERS_ALL, AttrCheckImpl.TEXT), // META
        new Attribute("coords", VERS_FROM32, AttrCheckImpl.COORDS), // AREA, A
        new Attribute("data", VERS_HTML40, AttrCheckImpl.URL), // OBJECT
        new Attribute("datafld", VERS_MICROSOFT, AttrCheckImpl.TEXT), // used on DIV, IMG
        new Attribute("dataformatas", VERS_MICROSOFT, AttrCheckImpl.TEXT), // used on DIV, IMG
        new Attribute("datapagesize", VERS_MICROSOFT, AttrCheckImpl.NUMBER), // used on DIV, IMG
        new Attribute("datasrc", VERS_MICROSOFT, AttrCheckImpl.URL), // used on TABLE
        new Attribute("datetime", VERS_HTML40, AttrCheckImpl.DATE), // INS, DEL
        new Attribute("declare", VERS_HTML40, AttrCheckImpl.BOOL), // OBJECT
        new Attribute("defer", VERS_HTML40, AttrCheckImpl.BOOL), // SCRIPT
        new Attribute("dir", VERS_HTML40, AttrCheckImpl.TEXTDIR), // ltr or rtl
        new Attribute("disabled", VERS_HTML40, AttrCheckImpl.BOOL), // form fields
        new Attribute("enctype", VERS_ALL, AttrCheckImpl.TYPE), // FORM
        new Attribute("face", VERS_LOOSE, AttrCheckImpl.TEXT), // BASEFONT, FONT
        new Attribute("for", VERS_HTML40, AttrCheckImpl.IDREF), // LABEL
        new Attribute("frame", VERS_HTML40, AttrCheckImpl.TFRAME), // TABLE
        new Attribute("frameborder", (VERS_FRAMESET | VERS_IFRAME), AttrCheckImpl.FBORDER), // 0 or 1
        new Attribute("framespacing", VERS_PROPRIETARY, AttrCheckImpl.NUMBER), // pixel value
        new Attribute("gridx", VERS_PROPRIETARY, AttrCheckImpl.NUMBER), // TABLE Adobe golive
        new Attribute("gridy", VERS_PROPRIETARY, AttrCheckImpl.NUMBER), // TABLE Adobe golive
        new Attribute("headers", VERS_HTML40, AttrCheckImpl.IDREF), // table cells
        new Attribute("height", VERS_ALL, AttrCheckImpl.LENGTH), // pixels only for TH/TD
        new Attribute("href", VERS_ALL, AttrCheckImpl.URL), // A, AREA, LINK and BASE
        new Attribute("hreflang", VERS_HTML40, AttrCheckImpl.LANG), // A, LINK
        new Attribute("hspace", VERS_ALL, AttrCheckImpl.NUMBER), // APPLET, IMG, OBJECT
        new Attribute("http-equiv", VERS_ALL, AttrCheckImpl.TEXT), // META
        new Attribute("id", VERS_HTML40, AttrCheckImpl.ID),
        new Attribute("ismap", VERS_ALL, AttrCheckImpl.BOOL), // IMG
        new Attribute("label", VERS_HTML40, AttrCheckImpl.TEXT), // OPT, OPTGROUP
        new Attribute("lang", VERS_HTML40, AttrCheckImpl.LANG),
        new Attribute("language", VERS_LOOSE, AttrCheckImpl.TEXT), // SCRIPT
        new Attribute("last_modified", VERS_NETSCAPE, AttrCheckImpl.TEXT), // A
        new Attribute("last_visit", VERS_NETSCAPE, AttrCheckImpl.TEXT), // A
        new Attribute("leftmargin", VERS_MICROSOFT, AttrCheckImpl.NUMBER), // used on BODY
        new Attribute("link", VERS_LOOSE, AttrCheckImpl.COLOR), // BODY
        new Attribute("longdesc", VERS_HTML40, AttrCheckImpl.URL), // IMG
        new Attribute("lowsrc", VERS_PROPRIETARY, AttrCheckImpl.URL), // IMG
        new Attribute("marginheight", VERS_IFRAME, AttrCheckImpl.NUMBER), // FRAME, IFRAME, BODY
        new Attribute("marginwidth", VERS_IFRAME, AttrCheckImpl.NUMBER), // ditto
        new Attribute("maxlength", VERS_ALL, AttrCheckImpl.NUMBER), // INPUT
        new Attribute("media", VERS_HTML40, AttrCheckImpl.MEDIA), // STYLE, LINK
        new Attribute("method", VERS_ALL, AttrCheckImpl.FSUBMIT), // FORM: get or post
        new Attribute("multiple", VERS_ALL, AttrCheckImpl.BOOL), // SELECT
        new Attribute("name", VERS_ALL, AttrCheckImpl.NAME),
        new Attribute("nohref", VERS_FROM32, AttrCheckImpl.BOOL), // AREA
        new Attribute("noresize", VERS_FRAMESET, AttrCheckImpl.BOOL), // FRAME
        new Attribute("noshade", VERS_LOOSE, AttrCheckImpl.BOOL), // HR
        new Attribute("nowrap", VERS_LOOSE, AttrCheckImpl.BOOL), // table cells
        new Attribute("object", VERS_HTML40_LOOSE, AttrCheckImpl.TEXT), // APPLET
        new Attribute("onblur", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onchange", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onclick", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("ondblclick", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onkeydown", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onkeypress", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onkeyup", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onload", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onmousedown", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onmousemove", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onmouseout", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onmouseover", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onmouseup", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onsubmit", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onreset", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onselect", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onunload", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onfocus", VERS_EVENTS, AttrCheckImpl.SCRIPT), // event
        new Attribute("onafterupdate", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // form fields
        new Attribute("onbeforeupdate", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // form fields
        new Attribute("onerrorupdate", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // form fields
        new Attribute("onrowenter", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // form fields
        new Attribute("onrowexit", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // form fields
        new Attribute("onbeforeunload", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // form fields
        new Attribute("ondatasetchanged", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // object, applet
        new Attribute("ondataavailable", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // object, applet
        new Attribute("ondatasetcomplete", VERS_MICROSOFT, AttrCheckImpl.SCRIPT), // object, applet
        new Attribute("profile", VERS_HTML40, AttrCheckImpl.URL), // HEAD
        new Attribute("prompt", VERS_LOOSE, AttrCheckImpl.TEXT), // ISINDEX
        new Attribute("readonly", VERS_HTML40, AttrCheckImpl.BOOL), // form fields
        new Attribute("rel", VERS_ALL, AttrCheckImpl.LINKTYPES), // A, LINK
        new Attribute("rev", VERS_ALL, AttrCheckImpl.LINKTYPES), // A, LINK
        new Attribute("rightmargin", VERS_MICROSOFT, AttrCheckImpl.NUMBER), // used on BODY
        new Attribute("rows", VERS_ALL, AttrCheckImpl.NUMBER), // TEXTAREA
        new Attribute("rowspan", VERS_ALL, AttrCheckImpl.NUMBER), // table cells
        new Attribute("rules", VERS_HTML40, AttrCheckImpl.TRULES), // TABLE
        new Attribute("scheme", VERS_HTML40, AttrCheckImpl.TEXT), // META
        new Attribute("scope", VERS_HTML40, AttrCheckImpl.SCOPE), // table cells
        new Attribute("scrolling", VERS_IFRAME, AttrCheckImpl.SCROLL), // yes, no or auto
        new Attribute("selected", VERS_ALL, AttrCheckImpl.BOOL), // OPTION
        new Attribute("shape", VERS_FROM32, AttrCheckImpl.SHAPE), // AREA, A
        new Attribute("showgrid", VERS_PROPRIETARY, AttrCheckImpl.BOOL), // TABLE Adobe golive
        new Attribute("showgridx", VERS_PROPRIETARY, AttrCheckImpl.BOOL), // TABLE Adobe golive
        new Attribute("showgridy", VERS_PROPRIETARY, AttrCheckImpl.BOOL), // TABLE Adobe golive
        new Attribute("size", VERS_LOOSE, AttrCheckImpl.NUMBER), // HR, FONT, BASEFONT, SELECT
        new Attribute("span", VERS_HTML40, AttrCheckImpl.NUMBER), // COL, COLGROUP
        new Attribute("src", VERS_ALL, AttrCheckImpl.URL), // IMG, FRAME, IFRAME
        new Attribute("standby", VERS_HTML40, AttrCheckImpl.TEXT), // OBJECT
        new Attribute("start", VERS_ALL, AttrCheckImpl.NUMBER), // OL
        new Attribute("style", VERS_HTML40, AttrCheckImpl.TEXT),
        new Attribute("summary", VERS_HTML40, AttrCheckImpl.TEXT), // TABLE
        new Attribute("tabindex", VERS_HTML40, AttrCheckImpl.NUMBER), // fields, OBJECT and A
        new Attribute("target", VERS_HTML40, AttrCheckImpl.TARGET), // names a frame/window
        new Attribute("text", VERS_LOOSE, AttrCheckImpl.COLOR), // BODY
        new Attribute("title", VERS_HTML40, AttrCheckImpl.TEXT), // text tool tip
        new Attribute("topmargin", VERS_MICROSOFT, AttrCheckImpl.NUMBER), // used on BODY
        new Attribute("type", VERS_FROM32, AttrCheckImpl.TYPE), // also used by SPACER
        new Attribute("usemap", VERS_ALL, AttrCheckImpl.BOOL), // things with images
        new Attribute("valign", VERS_FROM32, AttrCheckImpl.VALIGN),
        new Attribute("value", VERS_ALL, AttrCheckImpl.TEXT), // OPTION, PARAM
        new Attribute("valuetype", VERS_HTML40, AttrCheckImpl.VTYPE), // PARAM: data, ref, object
        new Attribute("version", VERS_ALL, AttrCheckImpl.TEXT), // HTML
        new Attribute("vlink", VERS_LOOSE, AttrCheckImpl.COLOR), // BODY
        new Attribute("vspace", VERS_LOOSE, AttrCheckImpl.NUMBER), // IMG, OBJECT, APPLET
        new Attribute("width", VERS_ALL, AttrCheckImpl.LENGTH), // pixels only for TD/TH
        new Attribute("wrap", VERS_NETSCAPE, AttrCheckImpl.TEXT), // textarea
        new Attribute("xml:lang", VERS_XML, AttrCheckImpl.TEXT), // XML language
        new Attribute("xml:space", VERS_XML, AttrCheckImpl.TEXT), // XML language
        new Attribute("xmlns", VERS_ALL, AttrCheckImpl.TEXT), // name space
        new Attribute("rbspan", VERS_XHTML11, AttrCheckImpl.NUMBER), // ruby markup
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