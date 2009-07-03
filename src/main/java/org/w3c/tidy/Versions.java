package org.w3c.tidy;

// from lexer.h
public class Versions {
	/* unknown */
	public static final int xxxx                  = 0;

	/* W3C defined HTML/XHTML family document types */
	public static final int HT20                  = 1;
	public static final int HT32                  = 2;
	public static final int H40S                  = 4;
	public static final int H40T                  = 8;
	public static final int H40F                 = 16;
	public static final int H41S                 = 32;
	public static final int H41T                 = 64;
	public static final int H41F                = 128;
	public static final int X10S                = 256;
	public static final int X10T                = 512;
	public static final int X10F               = 1024;
	public static final int XH11               = 2048;
	public static final int XB10               = 4096;

	/* proprietary stuff */
	public static final int VERS_SUN           = 8192;
	public static final int VERS_NETSCAPE     = 16384;
	public static final int VERS_MICROSOFT    = 32768;

	/* special flag */
	public static final int VERS_XML          = 65536;

	/* compatibility symbols */
	public static final int VERS_UNKNOWN      = (xxxx);
	public static final int VERS_HTML20       = (HT20);
	public static final int VERS_HTML32       = (HT32);
	public static final int VERS_HTML40_STRICT = (H40S|H41S|X10S);
	public static final int VERS_HTML40_LOOSE  = (H40T|H41T|X10T);
	public static final int VERS_FRAMESET     = (H40F|H41F|X10F);
	public static final int VERS_XHTML11      = (XH11);
	public static final int VERS_BASIC        = (XB10);

	/* meta symbols */
	public static final int VERS_HTML40       = (VERS_HTML40_STRICT|VERS_HTML40_LOOSE|VERS_FRAMESET);
	public static final int VERS_IFRAME       = (VERS_HTML40_LOOSE|VERS_FRAMESET);
	public static final int VERS_LOOSE        = (VERS_HTML20|VERS_HTML32|VERS_IFRAME);
	public static final int VERS_EVENTS       = (VERS_HTML40|VERS_XHTML11);
	public static final int VERS_FROM32       = (VERS_HTML32|VERS_HTML40);
	public static final int VERS_FROM40       = (VERS_HTML40|VERS_XHTML11|VERS_BASIC);
	public static final int VERS_XHTML        = (X10S|X10T|X10F|XH11|XB10);

	/* all W3C defined document types */
	public static final int VERS_ALL          = (VERS_HTML20|VERS_HTML32|VERS_FROM40);

	/* all proprietary types */
	public static final int VERS_PROPRIETARY  = (VERS_NETSCAPE|VERS_MICROSOFT|VERS_SUN);
}
