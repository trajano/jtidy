package org.w3c.tidy;

import static org.w3c.tidy.Versions.*;
import java.util.EnumMap;
import java.util.Map;

// extended attribute information, from attrdict.c
public class AttrDict {
	public static final Map<AttrId, Integer> A = new EnumMap<AttrId, Integer>(AttrId.class);
	
	static {
		final Map<AttrId, Integer> m = A;
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CHARSET,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COORDS,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HREF,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.HREFLANG,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.METHODS,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.NAME,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.REL,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.REV,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SHAPE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TARGET,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.URN,            HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> ABBR = new EnumMap<AttrId, Integer>(AttrId.class);
	
	static {
		final Map<AttrId, Integer> m = ABBR;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> ACRONYM = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = ACRONYM;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> ADDRESS = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = ADDRESS;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> APPLET = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = APPLET;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ALT,            xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ARCHIVE,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CODE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CODEBASE,       xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.HEIGHT,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.HSPACE,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.NAME,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OBJECT,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.VSPACE,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.WIDTH,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> AREA = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = AREA;
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ALT,            xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.COORDS,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HREF,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NOHREF,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SHAPE,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TARGET,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> B = new EnumMap<AttrId, Integer>(AttrId.class);
	
	static {
		final Map<AttrId, Integer> m = B;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BASE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BASE;
		m.put(AttrId.HREF,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.TARGET,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BASEFONT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BASEFONT;
		m.put(AttrId.COLOR,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.FACE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SIZE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BDO = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BDO;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BIG = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BIG;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BLOCKQUOTE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BLOCKQUOTE;
		m.put(AttrId.CITE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BODY = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BODY;
		m.put(AttrId.ALINK,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.BACKGROUND,     xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.BGCOLOR,        xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.LINK,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnLOAD,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnUNLOAD,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TEXT,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VLINK,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BR = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BR;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLEAR,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> BUTTON = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = BUTTON;
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DISABLED,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NAME,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALUE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> CAPTION = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = CAPTION;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> CENTER = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = CENTER;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> CITE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = CITE;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> CODE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = CODE;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> COL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = COL;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SPAN,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALIGN,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.WIDTH,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> COLGROUP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = COLGROUP;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SPAN,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALIGN,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.WIDTH,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DD = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DD;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DEL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DEL;
		m.put(AttrId.CITE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DATETIME,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DFN = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DFN;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DIR = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DIR;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.COMPACT,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DIV = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DIV;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DL;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COMPACT,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> DT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = DT;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> EM = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = EM;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> FIELDSET = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = FIELDSET;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> FONT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = FONT;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.COLOR,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.FACE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SIZE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> FORM = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = FORM;
		m.put(AttrId.ACCEPT,         xxxx|xxxx|xxxx|H41T|X10T|xxxx|H41F|X10F|xxxx|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ACCEPT_CHARSET, xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ACTION,         HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ENCTYPE,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.METHOD,         HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.NAME,           xxxx|xxxx|xxxx|H41T|X10T|xxxx|H41F|X10F|xxxx|H41S|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnRESET,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnSUBMIT,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDASUFF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TARGET,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> FRAME = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = FRAME;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.FRAMEBORDER,    xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LONGDESC,       xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.MARGINHEIGHT,   xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.MARGINWIDTH,    xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.NAME,           xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.NORESIZE,       xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SCROLLING,      xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SRC,            xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> FRAMESET = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = FRAMESET;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.COLS,           xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnLOAD,         xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnUNLOAD,       xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ROWS,           xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> H1 = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = H1;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> H2 = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = H2;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> H3 = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = H3;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> H4 = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = H4;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> H5 = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = H5;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> H6 = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = H6;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> HEAD = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = HEAD;
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.PROFILE,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> HR = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = HR;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|H41T|X10T|xxxx|H41F|X10F|xxxx|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|xxxx|H41T|X10T|xxxx|H41F|X10F|xxxx|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NOSHADE,        xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SIZE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.WIDTH,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> HTML = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = HTML;
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.VERSION,        HT20|HT32|H40T|H41T|xxxx|H40F|H41F|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> I = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = I;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> IFRAME = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = IFRAME;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.FRAMEBORDER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.HEIGHT,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LONGDESC,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.MARGINHEIGHT,   xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.MARGINWIDTH,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.NAME,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SCROLLING,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SRC,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.WIDTH,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> IMG = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = IMG;
		m.put(AttrId.ALIGN,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ALT,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.BORDER,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.HEIGHT,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.HSPACE,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ISMAP,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.LONGDESC,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.NAME,           xxxx|xxxx|xxxx|H41T|X10T|xxxx|H41F|X10F|xxxx|H41S|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SRC,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.USEMAP,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VSPACE,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.WIDTH,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> INPUT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = INPUT;
		m.put(AttrId.ACCEPT,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ALIGN,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ALT,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHECKED,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DISABLED,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ISMAP,          xxxx|xxxx|xxxx|H41T|xxxx|xxxx|H41F|xxxx|xxxx|H41S|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.MAXLENGTH,      HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.NAME,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCHANGE,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnSELECT,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.READONLY,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SIZE,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SRC,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.USEMAP,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALUE,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> INS = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = INS;
		m.put(AttrId.CITE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DATETIME,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> ISINDEX = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = ISINDEX;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.PROMPT,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> KBD = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = KBD;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> LABEL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = LABEL;
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.FOR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> LEGEND = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = LEGEND;
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> LI = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = LI;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.VALUE,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> LINK = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = LINK;
		m.put(AttrId.CHARSET,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HREF,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.HREFLANG,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.MEDIA,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.METHODS,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.REL,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.REV,            HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TARGET,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.URN,            HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> LISTING = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = LISTING;
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> MAP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = MAP;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NAME,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> MENU = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = MENU;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.COMPACT,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> META = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = META;
		m.put(AttrId.CONTENT,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HTTP_EQUIV,     HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NAME,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SCHEME,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> NEXTID = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = NEXTID;
		m.put(AttrId.N,              HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> NOFRAMES = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = NOFRAMES;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> NOSCRIPT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = NOSCRIPT;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> OBJECT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = OBJECT;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ARCHIVE,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.BORDER,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASSID,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CODEBASE,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CODETYPE,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DATA,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DECLARE,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HEIGHT,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.HSPACE,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NAME,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STANDBY,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.USEMAP,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VSPACE,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.WIDTH,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> OL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = OL;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COMPACT,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.START,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> OPTGROUP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = OPTGROUP;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DISABLED,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LABEL,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> OPTION = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = OPTION;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DISABLED,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LABEL,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SELECTED,       HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VALUE,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> P = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = P;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> PARAM = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = PARAM;
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.NAME,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VALUE,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VALUETYPE,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> PLAINTEXT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = PLAINTEXT;
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> PRE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = PRE;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.WIDTH,          HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XML_SPACE,      xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> Q = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = Q;
		m.put(AttrId.CITE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> RB = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = RB;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> RBC = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = RBC;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> RP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = RP;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> RT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = RT;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.RBSPAN,         xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> RTC = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = RTC;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> RUBY = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = RUBY;
		m.put(AttrId.CLASS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> S = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = S;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SAMP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SAMP;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SCRIPT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SCRIPT;
		m.put(AttrId.CHARSET,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DEFER,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.EVENT,          xxxx|xxxx|H40T|H41T|xxxx|H40F|H41F|xxxx|H40S|H41S|xxxx|xxxx|xxxx);
		m.put(AttrId.FOR,            xxxx|xxxx|H40T|H41T|xxxx|H40F|H41F|xxxx|H40S|H41S|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.LANGUAGE,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SRC,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_SPACE,      xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SELECT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SELECT;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DISABLED,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.MULTIPLE,       HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.NAME,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCHANGE,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SIZE,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SMALL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SMALL;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SPAN = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SPAN;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> STRIKE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = STRIKE;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> STRONG = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = STRONG;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> STYLE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = STYLE;
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.MEDIA,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TYPE,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XML_SPACE,      xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SUB = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SUB;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> SUP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = SUP;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TABLE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TABLE;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.BGCOLOR,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.BORDER,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CELLPADDING,    xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CELLSPACING,    xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DATAPAGESIZE,   xxxx|xxxx|H40T|H41T|xxxx|H40F|H41F|xxxx|H40S|H41S|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.FRAME,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.RULES,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SUMMARY,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.WIDTH,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TBODY = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TBODY;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALIGN,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TD = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TD;
		m.put(AttrId.ABBR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.AXIS,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.BGCOLOR,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COLSPAN,        xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HEADERS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.HEIGHT,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NOWRAP,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ROWSPAN,        xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SCOPE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VALIGN,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.WIDTH,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TEXTAREA = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TEXTAREA;
		m.put(AttrId.ACCESSKEY,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COLS,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DISABLED,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NAME,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.OnBLUR,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCHANGE,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnFOCUS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnSELECT,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.READONLY,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ROWS,           HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TABINDEX,       xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TFOOT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TFOOT;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALIGN,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TH = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TH;
		m.put(AttrId.ABBR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.AXIS,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.BGCOLOR,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COLSPAN,        xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.HEADERS,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.HEIGHT,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.NOWRAP,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ROWSPAN,        xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.SCOPE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VALIGN,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.WIDTH,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> THEAD = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = THEAD;
		m.put(AttrId.ALIGN,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.VALIGN,         xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TITLE = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TITLE;
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TR = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TR;
		m.put(AttrId.ALIGN,          xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.BGCOLOR,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.CHAR,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CHAROFF,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.VALIGN,         xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> TT = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = TT;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|xxxx);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> U = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = U;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> UL = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = UL;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.COMPACT,        HT20|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.TYPE,           xxxx|HT32|H40T|H41T|X10T|H40F|H41F|X10F|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> VAR = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = VAR;
		m.put(AttrId.CLASS,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.DIR,            xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.ID,             xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.LANG,           xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|xxxx|xxxx);
		m.put(AttrId.OnCLICK,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnDBLCLICK,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYDOWN,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYPRESS,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnKEYUP,        xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEDOWN,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEMOVE,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOUT,     xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEOVER,    xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.OnMOUSEUP,      xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.STYLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|xxxx);
		m.put(AttrId.TITLE,          xxxx|xxxx|H40T|H41T|X10T|H40F|H41F|X10F|H40S|H41S|X10S|XH11|XB10);
		m.put(AttrId.XML_LANG,       xxxx|xxxx|xxxx|xxxx|X10T|xxxx|xxxx|X10F|xxxx|xxxx|X10S|XH11|XB10);
		m.put(AttrId.XMLNS,          xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|XH11|XB10);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
	
	public static final Map<AttrId, Integer> XMP = new EnumMap<AttrId, Integer>(AttrId.class); 
	
	static {
		final Map<AttrId, Integer> m = XMP;
		m.put(AttrId.SDAFORM,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.SDAPREF,        HT20|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx|xxxx);
		m.put(AttrId.UNKNOWN,        0                                                               );
	}
}
