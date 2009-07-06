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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static org.w3c.tidy.Versions.*;

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
    public static final Dict XML_TAGS = new Dict(null, VERS_ALL, Dict.CM_BLOCK, null, null);

    /**
     * all the known tags.
     */
    private static final Dict[] TAGS = {
        new Dict(
            "html",
            VERS_ALL,
            (Dict.CM_HTML | Dict.CM_OPT | Dict.CM_OMITST),
            ParserImpl.HTML,
            TagCheckImpl.HTML),
        new Dict("head", VERS_ALL, (Dict.CM_HTML | Dict.CM_OPT | Dict.CM_OMITST), ParserImpl.HEAD, null),
        new Dict("title", VERS_ALL, Dict.CM_HEAD, ParserImpl.TITLE, null),
        new Dict("base", VERS_ALL, (Dict.CM_HEAD | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("link", VERS_ALL, (Dict.CM_HEAD | Dict.CM_EMPTY), ParserImpl.EMPTY, TagCheckImpl.LINK),
        new Dict("meta", VERS_ALL, (Dict.CM_HEAD | Dict.CM_EMPTY), ParserImpl.EMPTY, TagCheckImpl.META),
        new Dict(
            "style",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            Dict.CM_HEAD,
            ParserImpl.SCRIPT,
            TagCheckImpl.STYLE),
        new Dict(
            "script",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_HEAD | Dict.CM_MIXED | Dict.CM_BLOCK | Dict.CM_INLINE),
            ParserImpl.SCRIPT,
            TagCheckImpl.SCRIPT),
        new Dict(
            "server",
            VERS_NETSCAPE,
            (Dict.CM_HEAD | Dict.CM_MIXED | Dict.CM_BLOCK | Dict.CM_INLINE),
            ParserImpl.SCRIPT,
            null),
        new Dict("body", VERS_ALL, (Dict.CM_HTML | Dict.CM_OPT | Dict.CM_OMITST), ParserImpl.BODY, null),
        new Dict("frameset", VERS_FRAMESET, (Dict.CM_HTML | Dict.CM_FRAMES), ParserImpl.FRAMESET, null),
        new Dict("p", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_OPT), ParserImpl.INLINE, null),
        new Dict("h1", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_HEADING), ParserImpl.INLINE, null),
        new Dict("h2", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_HEADING), ParserImpl.INLINE, null),
        new Dict("h3", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_HEADING), ParserImpl.INLINE, null),
        new Dict("h4", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_HEADING), ParserImpl.INLINE, null),
        new Dict("h5", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_HEADING), ParserImpl.INLINE, null),
        new Dict("h6", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_HEADING), ParserImpl.INLINE, null),
        new Dict("ul", VERS_ALL, Dict.CM_BLOCK, ParserImpl.LIST, null),
        new Dict("ol", VERS_ALL, Dict.CM_BLOCK, ParserImpl.LIST, null),
        new Dict("dl", VERS_ALL, Dict.CM_BLOCK, ParserImpl.DEFLIST, null),
        new Dict("dir", VERS_LOOSE, (Dict.CM_BLOCK | Dict.CM_OBSOLETE), ParserImpl.LIST, null),
        new Dict("menu", VERS_LOOSE, (Dict.CM_BLOCK | Dict.CM_OBSOLETE), ParserImpl.LIST, null),
        new Dict("pre", VERS_ALL, Dict.CM_BLOCK, ParserImpl.PRE, null),
        new Dict("listing", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_OBSOLETE), ParserImpl.PRE, null),
        new Dict("xmp", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_OBSOLETE), ParserImpl.PRE, null),
        new Dict("plaintext", VERS_ALL, (Dict.CM_BLOCK | Dict.CM_OBSOLETE), ParserImpl.PRE, null),
        new Dict("address", VERS_ALL, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("blockquote", VERS_ALL, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("form", VERS_ALL, Dict.CM_BLOCK, ParserImpl.BLOCK, TagCheckImpl.FORM),
        new Dict("isindex", VERS_LOOSE, (Dict.CM_BLOCK | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("fieldset", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("table", VERS_FROM32, Dict.CM_BLOCK, ParserImpl.TABLETAG, TagCheckImpl.TABLE),
        new Dict(
            "hr",
            (short) (VERS_ALL & ~VERS_BASIC),
            (Dict.CM_BLOCK | Dict.CM_EMPTY),
            ParserImpl.EMPTY,
            TagCheckImpl.HR),
        new Dict("div", VERS_FROM32, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("multicol", VERS_NETSCAPE, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("nosave", VERS_NETSCAPE, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("layer", VERS_NETSCAPE, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("ilayer", VERS_NETSCAPE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict(
            "nolayer",
            VERS_NETSCAPE,
            (Dict.CM_BLOCK | Dict.CM_INLINE | Dict.CM_MIXED),
            ParserImpl.BLOCK,
            null),
        new Dict("align", VERS_NETSCAPE, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict("center", VERS_LOOSE, Dict.CM_BLOCK, ParserImpl.BLOCK, null),
        new Dict(
            "ins",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_INLINE | Dict.CM_BLOCK | Dict.CM_MIXED),
            ParserImpl.INLINE,
            null),
        new Dict(
            "del",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_INLINE | Dict.CM_BLOCK | Dict.CM_MIXED),
            ParserImpl.INLINE,
            null),
        new Dict("li", VERS_ALL, (Dict.CM_LIST | Dict.CM_OPT | Dict.CM_NO_INDENT), ParserImpl.BLOCK, null),
        new Dict("dt", VERS_ALL, (Dict.CM_DEFLIST | Dict.CM_OPT | Dict.CM_NO_INDENT), ParserImpl.INLINE, null),
        new Dict("dd", VERS_ALL, (Dict.CM_DEFLIST | Dict.CM_OPT | Dict.CM_NO_INDENT), ParserImpl.BLOCK, null),
        new Dict("caption", VERS_FROM32, Dict.CM_TABLE, ParserImpl.INLINE, TagCheckImpl.CAPTION),
        new Dict("colgroup", VERS_HTML40, (Dict.CM_TABLE | Dict.CM_OPT), ParserImpl.COLGROUP, null),
        new Dict("col", VERS_HTML40, (Dict.CM_TABLE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict(
            "thead",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_TABLE | Dict.CM_ROWGRP | Dict.CM_OPT),
            ParserImpl.ROWGROUP,
            null),
        new Dict(
            "tfoot",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_TABLE | Dict.CM_ROWGRP | Dict.CM_OPT),
            ParserImpl.ROWGROUP,
            null),
        new Dict(
            "tbody",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_TABLE | Dict.CM_ROWGRP | Dict.CM_OPT),
            ParserImpl.ROWGROUP,
            null),
        new Dict("tr", VERS_FROM32, (Dict.CM_TABLE | Dict.CM_OPT), ParserImpl.ROW, null),
        new Dict(
            "td",
            VERS_FROM32,
            (Dict.CM_ROW | Dict.CM_OPT | Dict.CM_NO_INDENT),
            ParserImpl.BLOCK,
            TagCheckImpl.TABLECELL),
        new Dict(
            "th",
            VERS_FROM32,
            (Dict.CM_ROW | Dict.CM_OPT | Dict.CM_NO_INDENT),
            ParserImpl.BLOCK,
            TagCheckImpl.TABLECELL),
        new Dict("q", VERS_HTML40, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("a", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, TagCheckImpl.ANCHOR),
        new Dict("br", VERS_ALL, (Dict.CM_INLINE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict(
            "img",
            VERS_ALL,
            (Dict.CM_INLINE | Dict.CM_IMG | Dict.CM_EMPTY),
            ParserImpl.EMPTY,
            TagCheckImpl.IMG),
        new Dict(
            "object",
            VERS_HTML40,
            (Dict.CM_OBJECT | Dict.CM_HEAD | Dict.CM_IMG | Dict.CM_INLINE | Dict.CM_PARAM),
            ParserImpl.BLOCK,
            null),
        new Dict(
            "applet",
            VERS_LOOSE,
            (Dict.CM_OBJECT | Dict.CM_IMG | Dict.CM_INLINE | Dict.CM_PARAM),
            ParserImpl.BLOCK,
            null),
        new Dict(
            "servlet",
            VERS_SUN,
            (Dict.CM_OBJECT | Dict.CM_IMG | Dict.CM_INLINE | Dict.CM_PARAM),
            ParserImpl.BLOCK,
            null),
        new Dict("param", VERS_FROM32, (Dict.CM_INLINE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("embed", VERS_NETSCAPE, (Dict.CM_INLINE | Dict.CM_IMG | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("noembed", VERS_NETSCAPE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("iframe", VERS_HTML40_LOOSE, Dict.CM_INLINE, ParserImpl.BLOCK, null),
        new Dict("frame", VERS_FRAMESET, (Dict.CM_FRAMES | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("noframes", VERS_IFRAME, (Dict.CM_BLOCK | Dict.CM_FRAMES), ParserImpl.NOFRAMES, null),
        new Dict(
            "noscript",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_BLOCK | Dict.CM_INLINE | Dict.CM_MIXED),
            ParserImpl.BLOCK,
            null),
        new Dict("b", (short) (VERS_ALL & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("i", (short) (VERS_ALL & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("u", VERS_LOOSE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("tt", (short) (VERS_ALL & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("s", VERS_LOOSE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("strike", VERS_LOOSE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("big", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("small", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("sub", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("sup", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("em", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("strong", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("dfn", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("code", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("samp", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("kbd", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("var", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("cite", VERS_ALL, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("abbr", VERS_HTML40, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("acronym", VERS_HTML40, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("span", VERS_FROM32, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("blink", VERS_PROPRIETARY, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("nobr", VERS_PROPRIETARY, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("wbr", VERS_PROPRIETARY, (Dict.CM_INLINE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("marquee", VERS_MICROSOFT, (Dict.CM_INLINE | Dict.CM_OPT), ParserImpl.INLINE, null),
        new Dict("bgsound", VERS_MICROSOFT, (Dict.CM_HEAD | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("comment", VERS_MICROSOFT, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("spacer", VERS_NETSCAPE, (Dict.CM_INLINE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("keygen", VERS_NETSCAPE, (Dict.CM_INLINE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict(
            "nolayer",
            VERS_NETSCAPE,
            (Dict.CM_BLOCK | Dict.CM_INLINE | Dict.CM_MIXED),
            ParserImpl.BLOCK,
            null),
        new Dict("ilayer", VERS_NETSCAPE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict(
            "map",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            Dict.CM_INLINE,
            ParserImpl.BLOCK,
            TagCheckImpl.MAP),
        new Dict(
            "area",
            (short) (VERS_ALL & ~VERS_BASIC),
            (Dict.CM_BLOCK | Dict.CM_EMPTY),
            ParserImpl.EMPTY,
            TagCheckImpl.AREA),
        new Dict("input", VERS_ALL, (Dict.CM_INLINE | Dict.CM_IMG | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("select", VERS_ALL, (Dict.CM_INLINE | Dict.CM_FIELD), ParserImpl.SELECT, null),
        new Dict("option", VERS_ALL, (Dict.CM_FIELD | Dict.CM_OPT), ParserImpl.TEXT, null),
        new Dict(
            "optgroup",
            (short) (VERS_HTML40 & ~VERS_BASIC),
            (Dict.CM_FIELD | Dict.CM_OPT),
            ParserImpl.OPTGROUP,
            null),
        new Dict("textarea", VERS_ALL, (Dict.CM_INLINE | Dict.CM_FIELD), ParserImpl.TEXT, null),
        new Dict("label", VERS_HTML40, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("legend", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("button", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("basefont", VERS_LOOSE, (Dict.CM_INLINE | Dict.CM_EMPTY), ParserImpl.EMPTY, null),
        new Dict("font", VERS_LOOSE, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("bdo", (short) (VERS_HTML40 & ~VERS_BASIC), Dict.CM_INLINE, ParserImpl.INLINE, null),
        // elements for XHTML 1.1
        new Dict("ruby", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("rbc", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("rtc", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("rb", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("rt", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
        new Dict("rp", VERS_XHTML11, Dict.CM_INLINE, ParserImpl.INLINE, null),
    //
    };

    /**
     * anchor/node hash.
     */
    protected Anchor anchorList;

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
        short model;

        switch (tagType)
        {
            case Dict.TAGTYPE_BLOCK :
                model = (short) (Dict.CM_BLOCK | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.BLOCK;
                break;

            case Dict.TAGTYPE_EMPTY :
                model = (short) (Dict.CM_EMPTY | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.BLOCK;
                break;

            case Dict.TAGTYPE_PRE :
                model = (short) (Dict.CM_BLOCK | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.PRE;
                break;

            case Dict.TAGTYPE_INLINE :
            default :
                // default to inline tag
                model = (short) (Dict.CM_INLINE | Dict.CM_NO_INDENT | Dict.CM_NEW);
                tagParser = ParserImpl.INLINE;
                break;
        }

        install(new Dict(name, VERS_PROPRIETARY, model, tagParser, null));
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
    void removeAnchorByNode(Node node)
    {
        Anchor delme = null;
        Anchor found = null;
        Anchor prev = null;
        Anchor next = null;

        for (found = anchorList; found != null; found = found.next)
        {
            next = found.next;

            if (found.node == node)
            {
                if (prev != null)
                {
                    prev.next = next;
                }
                else
                {
                    anchorList = next;
                }

                delme = found;
            }
            else
            {
                prev = found;
            }
        }
        if (delme != null)
        {
            delme = null; // freeAnchor
        }
    }

    /**
     * Initialize a new anchor.
     * @return a new anchor element
     */
    Anchor newAnchor()
    {
        Anchor a = new Anchor();
        return a;
    }

    /**
     * Adds a new anchor to namespace.
     * @param name anchor name
     * @param node destination for this anchor
     * @return Anchor
     */
    Anchor addAnchor(String name, Node node)
    {
        Anchor a = newAnchor();

        a.name = name;
        a.node = node;

        if (anchorList == null)
        {
            anchorList = a;
        }
        else
        {
            Anchor here = anchorList;

            while (here.next != null)
            {
                here = here.next;
            }
            here.next = a;
        }

        return anchorList;
    }

    /**
     * Return node associated with anchor.
     * @param name anchor name
     * @return node associated with anchor
     */
    Node getNodeByAnchor(String name)
    {
        Anchor found;

        for (found = anchorList; found != null; found = found.next)
        {
            if (name.equalsIgnoreCase(found.name))
            {
                break;
            }
        }

        if (found != null)
        {
            return found.node;
        }

        return null;
    }

    /**
     * free all anchors.
     */
    void freeAnchors()
    {
        anchorList = null;
    }

}