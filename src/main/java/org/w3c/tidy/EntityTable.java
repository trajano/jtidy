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

import static org.w3c.tidy.Versions.VERS_ALL;
import static org.w3c.tidy.Versions.VERS_FROM40;
import static org.w3c.tidy.Versions.VERS_XML;

import java.util.HashMap;
import java.util.Map;

/**
 * Entity hash table.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public final class EntityTable
{

    /**
     * the default entity table.
     */
    private static EntityTable defaultEntityTable;

    /**
     * Known entities.
     */
    private static Entity[] entities = {
    	// Markup pre-defined character entities
    	new Entity("quot", VERS_ALL | VERS_XML, 34),
        new Entity("amp", VERS_ALL | VERS_XML, 38),
        new Entity("apos", VERS_FROM40 | VERS_XML, 39),
        new Entity("lt", VERS_ALL | VERS_XML, 60),
        new Entity("gt", VERS_ALL | VERS_XML, 62),
        
    	// Latin-1 character entities
        new Entity("nbsp", VERS_ALL, 160),
        new Entity("iexcl", VERS_ALL, 161),
        new Entity("cent", VERS_ALL, 162),
        new Entity("pound", VERS_ALL, 163),
        new Entity("curren", VERS_ALL, 164),
        new Entity("yen", VERS_ALL, 165),
        new Entity("brvbar", VERS_ALL, 166),
        new Entity("sect", VERS_ALL, 167),
        new Entity("uml", VERS_ALL, 168),
        new Entity("copy", VERS_ALL, 169),
        new Entity("ordf", VERS_ALL, 170),
        new Entity("laquo", VERS_ALL, 171),
        new Entity("not", VERS_ALL, 172),
        new Entity("shy", VERS_ALL, 173),
        new Entity("reg", VERS_ALL, 174),
        new Entity("macr", VERS_ALL, 175),
        new Entity("deg", VERS_ALL, 176),
        new Entity("plusmn", VERS_ALL, 177),
        new Entity("sup2", VERS_ALL, 178),
        new Entity("sup3", VERS_ALL, 179),
        new Entity("acute", VERS_ALL, 180),
        new Entity("micro", VERS_ALL, 181),
        new Entity("para", VERS_ALL, 182),
        new Entity("middot", VERS_ALL, 183),
        new Entity("cedil", VERS_ALL, 184),
        new Entity("sup1", VERS_ALL, 185),
        new Entity("ordm", VERS_ALL, 186),
        new Entity("raquo", VERS_ALL, 187),
        new Entity("frac14", VERS_ALL, 188),
        new Entity("frac12", VERS_ALL, 189),
        new Entity("frac34", VERS_ALL, 190),
        new Entity("iquest", VERS_ALL, 191),
        new Entity("Agrave", VERS_ALL, 192),
        new Entity("Aacute", VERS_ALL, 193),
        new Entity("Acirc", VERS_ALL, 194),
        new Entity("Atilde", VERS_ALL, 195),
        new Entity("Auml", VERS_ALL, 196),
        new Entity("Aring", VERS_ALL, 197),
        new Entity("AElig", VERS_ALL, 198),
        new Entity("Ccedil", VERS_ALL, 199),
        new Entity("Egrave", VERS_ALL, 200),
        new Entity("Eacute", VERS_ALL, 201),
        new Entity("Ecirc", VERS_ALL, 202),
        new Entity("Euml", VERS_ALL, 203),
        new Entity("Igrave", VERS_ALL, 204),
        new Entity("Iacute", VERS_ALL, 205),
        new Entity("Icirc", VERS_ALL, 206),
        new Entity("Iuml", VERS_ALL, 207),
        new Entity("ETH", VERS_ALL, 208),
        new Entity("Ntilde", VERS_ALL, 209),
        new Entity("Ograve", VERS_ALL, 210),
        new Entity("Oacute", VERS_ALL, 211),
        new Entity("Ocirc", VERS_ALL, 212),
        new Entity("Otilde", VERS_ALL, 213),
        new Entity("Ouml", VERS_ALL, 214),
        new Entity("times", VERS_ALL, 215),
        new Entity("Oslash", VERS_ALL, 216),
        new Entity("Ugrave", VERS_ALL, 217),
        new Entity("Uacute", VERS_ALL, 218),
        new Entity("Ucirc", VERS_ALL, 219),
        new Entity("Uuml", VERS_ALL, 220),
        new Entity("Yacute", VERS_ALL, 221),
        new Entity("THORN", VERS_ALL, 222),
        new Entity("szlig", VERS_ALL, 223),
        new Entity("agrave", VERS_ALL, 224),
        new Entity("aacute", VERS_ALL, 225),
        new Entity("acirc", VERS_ALL, 226),
        new Entity("atilde", VERS_ALL, 227),
        new Entity("auml", VERS_ALL, 228),
        new Entity("aring", VERS_ALL, 229),
        new Entity("aelig", VERS_ALL, 230),
        new Entity("ccedil", VERS_ALL, 231),
        new Entity("egrave", VERS_ALL, 232),
        new Entity("eacute", VERS_ALL, 233),
        new Entity("ecirc", VERS_ALL, 234),
        new Entity("euml", VERS_ALL, 235),
        new Entity("igrave", VERS_ALL, 236),
        new Entity("iacute", VERS_ALL, 237),
        new Entity("icirc", VERS_ALL, 238),
        new Entity("iuml", VERS_ALL, 239),
        new Entity("eth", VERS_ALL, 240),
        new Entity("ntilde", VERS_ALL, 241),
        new Entity("ograve", VERS_ALL, 242),
        new Entity("oacute", VERS_ALL, 243),
        new Entity("ocirc", VERS_ALL, 244),
        new Entity("otilde", VERS_ALL, 245),
        new Entity("ouml", VERS_ALL, 246),
        new Entity("divide", VERS_ALL, 247),
        new Entity("oslash", VERS_ALL, 248),
        new Entity("ugrave", VERS_ALL, 249),
        new Entity("uacute", VERS_ALL, 250),
        new Entity("ucirc", VERS_ALL, 251),
        new Entity("uuml", VERS_ALL, 252),
        new Entity("yacute", VERS_ALL, 253),
        new Entity("thorn", VERS_ALL, 254),
        new Entity("yuml", VERS_ALL, 255),
        
        // Extended Entities defined in HTML 4: Symbols 
        new Entity("fnof", VERS_FROM40, 402),
        new Entity("Alpha", VERS_FROM40, 913),
        new Entity("Beta", VERS_FROM40, 914),
        new Entity("Gamma", VERS_FROM40, 915),
        new Entity("Delta", VERS_FROM40, 916),
        new Entity("Epsilon", VERS_FROM40, 917),
        new Entity("Zeta", VERS_FROM40, 918),
        new Entity("Eta", VERS_FROM40, 919),
        new Entity("Theta", VERS_FROM40, 920),
        new Entity("Iota", VERS_FROM40, 921),
        new Entity("Kappa", VERS_FROM40, 922),
        new Entity("Lambda", VERS_FROM40, 923),
        new Entity("Mu", VERS_FROM40, 924),
        new Entity("Nu", VERS_FROM40, 925),
        new Entity("Xi", VERS_FROM40, 926),
        new Entity("Omicron", VERS_FROM40, 927),
        new Entity("Pi", VERS_FROM40, 928),
        new Entity("Rho", VERS_FROM40, 929),
        new Entity("Sigma", VERS_FROM40, 931),
        new Entity("Tau", VERS_FROM40, 932),
        new Entity("Upsilon", VERS_FROM40, 933),
        new Entity("Phi", VERS_FROM40, 934),
        new Entity("Chi", VERS_FROM40, 935),
        new Entity("Psi", VERS_FROM40, 936),
        new Entity("Omega", VERS_FROM40, 937),
        new Entity("alpha", VERS_FROM40, 945),
        new Entity("beta", VERS_FROM40, 946),
        new Entity("gamma", VERS_FROM40, 947),
        new Entity("delta", VERS_FROM40, 948),
        new Entity("epsilon", VERS_FROM40, 949),
        new Entity("zeta", VERS_FROM40, 950),
        new Entity("eta", VERS_FROM40, 951),
        new Entity("theta", VERS_FROM40, 952),
        new Entity("iota", VERS_FROM40, 953),
        new Entity("kappa", VERS_FROM40, 954),
        new Entity("lambda", VERS_FROM40, 955),
        new Entity("mu", VERS_FROM40, 956),
        new Entity("nu", VERS_FROM40, 957),
        new Entity("xi", VERS_FROM40, 958),
        new Entity("omicron", VERS_FROM40, 959),
        new Entity("pi", VERS_FROM40, 960),
        new Entity("rho", VERS_FROM40, 961),
        new Entity("sigmaf", VERS_FROM40, 962),
        new Entity("sigma", VERS_FROM40, 963),
        new Entity("tau", VERS_FROM40, 964),
        new Entity("upsilon", VERS_FROM40, 965),
        new Entity("phi", VERS_FROM40, 966),
        new Entity("chi", VERS_FROM40, 967),
        new Entity("psi", VERS_FROM40, 968),
        new Entity("omega", VERS_FROM40, 969),
        new Entity("thetasym", VERS_FROM40, 977),
        new Entity("upsih", VERS_FROM40, 978),
        new Entity("piv", VERS_FROM40, 982),
        new Entity("bull", VERS_FROM40, 8226),
        new Entity("hellip", VERS_FROM40, 8230),
        new Entity("prime", VERS_FROM40, 8242),
        new Entity("Prime", VERS_FROM40, 8243),
        new Entity("oline", VERS_FROM40, 8254),
        new Entity("frasl", VERS_FROM40, 8260),
        new Entity("weierp", VERS_FROM40, 8472),
        new Entity("image", VERS_FROM40, 8465),
        new Entity("real", VERS_FROM40, 8476),
        new Entity("trade", VERS_FROM40, 8482),
        new Entity("alefsym", VERS_FROM40, 8501),
        new Entity("larr", VERS_FROM40, 8592),
        new Entity("uarr", VERS_FROM40, 8593),
        new Entity("rarr", VERS_FROM40, 8594),
        new Entity("darr", VERS_FROM40, 8595),
        new Entity("harr", VERS_FROM40, 8596),
        new Entity("crarr", VERS_FROM40, 8629),
        new Entity("lArr", VERS_FROM40, 8656),
        new Entity("uArr", VERS_FROM40, 8657),
        new Entity("rArr", VERS_FROM40, 8658),
        new Entity("dArr", VERS_FROM40, 8659),
        new Entity("hArr", VERS_FROM40, 8660),
        new Entity("forall", VERS_FROM40, 8704),
        new Entity("part", VERS_FROM40, 8706),
        new Entity("exist", VERS_FROM40, 8707),
        new Entity("empty", VERS_FROM40, 8709),
        new Entity("nabla", VERS_FROM40, 8711),
        new Entity("isin", VERS_FROM40, 8712),
        new Entity("notin", VERS_FROM40, 8713),
        new Entity("ni", VERS_FROM40, 8715),
        new Entity("prod", VERS_FROM40, 8719),
        new Entity("sum", VERS_FROM40, 8721),
        new Entity("minus", VERS_FROM40, 8722),
        new Entity("lowast", VERS_FROM40, 8727),
        new Entity("radic", VERS_FROM40, 8730),
        new Entity("prop", VERS_FROM40, 8733),
        new Entity("infin", VERS_FROM40, 8734),
        new Entity("ang", VERS_FROM40, 8736),
        new Entity("and", VERS_FROM40, 8743),
        new Entity("or", VERS_FROM40, 8744),
        new Entity("cap", VERS_FROM40, 8745),
        new Entity("cup", VERS_FROM40, 8746),
        new Entity("int", VERS_FROM40, 8747),
        new Entity("there4", VERS_FROM40, 8756),
        new Entity("sim", VERS_FROM40, 8764),
        new Entity("cong", VERS_FROM40, 8773),
        new Entity("asymp", VERS_FROM40, 8776),
        new Entity("ne", VERS_FROM40, 8800),
        new Entity("equiv", VERS_FROM40, 8801),
        new Entity("le", VERS_FROM40, 8804),
        new Entity("ge", VERS_FROM40, 8805),
        new Entity("sub", VERS_FROM40, 8834),
        new Entity("sup", VERS_FROM40, 8835),
        new Entity("nsub", VERS_FROM40, 8836),
        new Entity("sube", VERS_FROM40, 8838),
        new Entity("supe", VERS_FROM40, 8839),
        new Entity("oplus", VERS_FROM40, 8853),
        new Entity("otimes", VERS_FROM40, 8855),
        new Entity("perp", VERS_FROM40, 8869),
        new Entity("sdot", VERS_FROM40, 8901),
        new Entity("lceil", VERS_FROM40, 8968),
        new Entity("rceil", VERS_FROM40, 8969),
        new Entity("lfloor", VERS_FROM40, 8970),
        new Entity("rfloor", VERS_FROM40, 8971),
        new Entity("lang", VERS_FROM40, 9001),
        new Entity("rang", VERS_FROM40, 9002),
        new Entity("loz", VERS_FROM40, 9674),
        new Entity("spades", VERS_FROM40, 9824),
        new Entity("clubs", VERS_FROM40, 9827),
        new Entity("hearts", VERS_FROM40, 9829),
        new Entity("diams", VERS_FROM40, 9830),
        
        // Extended Entities defined in HTML 4: Special (less Markup at top)
        new Entity("OElig", VERS_FROM40, 338),
        new Entity("oelig", VERS_FROM40, 339),
        new Entity("Scaron", VERS_FROM40, 352),
        new Entity("scaron", VERS_FROM40, 353),
        new Entity("Yuml", VERS_FROM40, 376),
        new Entity("circ", VERS_FROM40, 710),
        new Entity("tilde", VERS_FROM40, 732),
        new Entity("ensp", VERS_FROM40, 8194),
        new Entity("emsp", VERS_FROM40, 8195),
        new Entity("thinsp", VERS_FROM40, 8201),
        new Entity("zwnj", VERS_FROM40, 8204),
        new Entity("zwj", VERS_FROM40, 8205),
        new Entity("lrm", VERS_FROM40, 8206),
        new Entity("rlm", VERS_FROM40, 8207),
        new Entity("ndash", VERS_FROM40, 8211),
        new Entity("mdash", VERS_FROM40, 8212),
        new Entity("lsquo", VERS_FROM40, 8216),
        new Entity("rsquo", VERS_FROM40, 8217),
        new Entity("sbquo", VERS_FROM40, 8218),
        new Entity("ldquo", VERS_FROM40, 8220),
        new Entity("rdquo", VERS_FROM40, 8221),
        new Entity("bdquo", VERS_FROM40, 8222),
        new Entity("dagger", VERS_FROM40, 8224),
        new Entity("Dagger", VERS_FROM40, 8225),
        new Entity("permil", VERS_FROM40, 8240),
        new Entity("lsaquo", VERS_FROM40, 8249),
        new Entity("rsaquo", VERS_FROM40, 8250),
        new Entity("euro", VERS_FROM40, 8364)};

    /**
     * Entity map.
     */
    private Map<String, Entity> entityMap = new HashMap<String, Entity>();

    /**
     * use getDefaultEntityTable to get an entity table instance.
     */
    private EntityTable()
    {
        super();
    }

    /**
     * installs an entity.
     * @param ent entity
     * @return installed Entity
     */
    private Entity install(Entity ent)
    {
        return this.entityMap.put(ent.getName(), ent);
    }

    /**
     * Lookup an entity by its name.
     * @param name entity name
     * @return entity
     */
    public Entity lookup(String name)
    {
        return this.entityMap.get(name);
    }

    /**
     * Returns the entity code for the given entity name.
     * @param name entity name
     * @return entity code or 0 for unknown entity names
     */
    public Entity entityInfo(final String name, final boolean isXml) {
    	assert(name != null && name.charAt(0) == '&');

        // numeric entitity: name = "&#" followed by number
        if (name.length() > 1 && name.charAt(1) == '#') {
            int c = 0; // zero on missing/bad number

            // 'x' prefix denotes hexadecimal number format
            try {
                if (name.length() >= 4 && (name.charAt(2) == 'x' || (!isXml && name.charAt(2) == 'X'))) {
                    c = Integer.parseInt(name.substring(3), 16);
                }
                else if (name.length() >= 3) {
                    c = Integer.parseInt(name.substring(2));
                }
            } catch (NumberFormatException e) {
                // ignore
            }
            return new Entity(name, VERS_ALL, c);
        }

        // Named entity: name ="&" followed by a name
        return lookup(name.substring(1));
    }

    /**
     * Returns the entity name for the given entity code.
     * @param code entity code
     * @return entity name or null for unknown entity codes
     */
    public String entityName(short code)
    {
        String name = null;
        for (Entity ent : entityMap.values())
        {
            if (ent.getCode() == code)
            {
                name = ent.getName();
                break;
            }
        }
        return name;
    }

    /**
     * Returns the default entity table instance.
     * @return entity table instance
     */
    public static EntityTable getDefaultEntityTable()
    {
        if (defaultEntityTable == null)
        {
            defaultEntityTable = new EntityTable();
            for (int i = 0; i < entities.length; i++)
            {
                defaultEntityTable.install(entities[i]);
            }
        }
        return defaultEntityTable;
    }

}