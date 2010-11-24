package org.w3c.tidy;

/*********************************************************************
* AccessibilityChecks
*
* Carries out processes for all accessibility checks.  Traverses
* through all the content within the tree and evaluates the tags for
* accessibility.
*
* To perform the following checks, 'AccessibilityChecks' must be
* called AFTER the tree structure has been formed.
*
* If, in the command prompt, there is no specification of which
* accessibility priorities to check, no accessibility checks will be
* performed.  (ie. '1' for priority 1, '2' for priorities 1 and 2,
*                  and '3') for priorities 1, 2 and 3.)
*
* Copyright University of Toronto
* Programmed by: Mike Lam and Chris Ridpath
* Modifications by : Terry Teague (TRT)
*
* Reference document: http://www.w3.org/TR/WAI-WEBCONTENT/
*********************************************************************/


public class Accessibility {

//	private static final int TEXTBUF_SIZE = 128;

	/* List of possible image types */
	private static final String imageExtensions[] = {".jpg", ".gif", ".tif", ".pct", ".pic", ".iff", ".dib",
		".tga", ".pcx", ".png", ".jpeg", ".tiff", ".bmp"};

	/* List of possible sound file types */
	private static final String soundExtensions[] = {".wav", ".au", ".aiff", ".snd", ".ra", ".rm"};

	private static final AccessErrorCode soundExtErrCodes[] = {
		AccessErrorCode.AUDIO_MISSING_TEXT_WAV,
		AccessErrorCode.AUDIO_MISSING_TEXT_AU,
		AccessErrorCode.AUDIO_MISSING_TEXT_AIFF,
		AccessErrorCode.AUDIO_MISSING_TEXT_SND,
		AccessErrorCode.AUDIO_MISSING_TEXT_RA,
		AccessErrorCode.AUDIO_MISSING_TEXT_RM
	};

	/* List of possible media extensions */
	private static final String mediaExtensions[] = {".mpg", ".mov", ".asx", ".avi", ".ivf", ".m1v", ".mmm", ".mp2v",
		".mpa", ".mpe", ".mpeg", ".ram", ".smi", ".smil", ".swf", ".wm", ".wma", ".wmv"};

	/* List of possible frame sources */
	private static final String frameExtensions[] = {".htm", ".html", ".shtm", ".shtml", ".cfm", ".cfml",
		".asp", ".cgi", ".pl", ".smil"};

	/* List of possible colour values */
	private static final int colorValues[][] = {
		{  0,   0,   0},
		{128, 128, 128},
		{192, 192, 192},
		{255, 255, 255},
		{192,   0,   0},
		{255,   0,   0},
		{128,   0, 128},
		{255,   0, 255},
		{  0, 128,   0},
		{  0, 255,   0},
		{128, 128,   0},
		{255, 255,   0},
		{  0,   0, 128},
		{  0,   0, 255},
		{  0, 128, 128},
		{  0, 255, 255}
	};

	/* These arrays are used to convert color names to their RGB values */
	private static final String colorNames[] = { "black", "silver", "grey", "white", "maroon", "red", "purple",
			"fuchsia", "green", "lime", "olive", "yellow", "navy", "blue", "teal", "aqua"};

	/* gets set from Tidy variable AccessibilityCheckLevel */
	private int level;

	/* list of characters in the text nodes found within a container element */
	private final StringBuilder textNode = new StringBuilder();

	/* Number of frame elements found within a frameset */
	private int numFrames;

	/* Number of 'longdesc' attributes found within a frameset */
	private int hasCheckedLongDesc;

	private int checkedHeaders;
	private int listElements;
	private int otherListElements;

	/* For 'USEMAP' identifier */
	private boolean hasUseMap;
	private boolean hasName;
	private boolean hasMap;

	/* For tracking nodes that are deleted from the original parse tree - TRT */
	/* Node *access_tree; */

	private boolean hasTH;
	private boolean hasValidFor;
	private boolean hasValidId;
	private boolean hasValidRowHeaders;
	private boolean hasValidColumnHeaders;
	private boolean hasInvalidRowHeader;
	private boolean hasInvalidColumnHeader;
	private int forID;

	/*
		GetFileExtension takes a path and returns the extension
		portion of the path (if any).
	*/

	private static String getFileExtension(final String path) {
		int i = path.length() - 1;

		do {
			if (path.charAt(i) == '/' || path.charAt(i) == '\\') {
				return "";
			}
			else if (path.charAt(i) == '.') {
				return path.substring(i);
			}
		} while (--i > 0);
		return "";
	}

	/************************************************************************
	* IsImage
	*
	* Checks if the given filename is an image file.
	************************************************************************/

	private static boolean isImage(final String iType) {
		/* Get the file extension */
		final String ext = getFileExtension(iType);

		/* Compare it to the array of known image file extensions */
		for (String s : imageExtensions) {
			if (ext.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}


	/***********************************************************************
	* IsSoundFile
	*
	* Checks if the given filename is a sound file.
	***********************************************************************/

	private static AccessErrorCode isSoundFile(final String sType) {
		final String ext = getFileExtension(sType);

		for (int i = 0; i < soundExtensions.length; i++) {
			if (ext.equalsIgnoreCase(soundExtensions[i])) {
				return soundExtErrCodes[i];
			}
		}
		return null;
	}


	/***********************************************************************
	* IsValidSrcExtension
	*
	* Checks if the 'SRC' value within the FRAME element is valid
	* The 'SRC' extension must end in ".htm", ".html", ".shtm", ".shtml",
	* ".cfm", ".cfml", ".asp", ".cgi", ".pl", or ".smil"
	***********************************************************************/

	private static boolean isValidSrcExtension(final String sType) {
		final String ext = getFileExtension(sType);

		for (String s : frameExtensions) {
			if (ext.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}


	/*********************************************************************
	* IsValidMediaExtension
	*
	* Checks to warn the user that synchronized text equivalents are
	* required if multimedia is used.
	*********************************************************************/

	private static boolean isValidMediaExtension(final String sType) {
		final String ext = getFileExtension(sType);

		for (String s : mediaExtensions) {
			if (ext.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}


	/************************************************************************
	* IsWhitespace
	*
	* Checks if the given string is all whitespace.
	************************************************************************/

	private static boolean isWhitespace(final String pString) {
		if (pString == null) {
			return true;
		}
		for (int i = 0; i < pString.length(); ++i) {
			final char c = pString.charAt(i);
			if (!TidyUtils.isWhite(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean hasValue(final AttVal av) {
		return av != null && !isWhitespace(av.value);
	}

	/***********************************************************************
	* IsPlaceholderAlt
	*
	* Checks to see if there is an image and photo place holder contained
	* in the ALT text.
	***********************************************************************/

	private static boolean isPlaceholderAlt(final String txt) {
		return txt.contains("image") || txt.contains("photo");
	}


	/***********************************************************************
	* IsPlaceHolderObject
	*
	* Checks to see if there is an OBJECT place holder contained
	* in the 'ALT' text.
	***********************************************************************/

	private static boolean isPlaceHolderObject(final String txt) {
		return txt.contains("object");
	}


	/**********************************************************
	* EndsWithBytes
	*
	* Checks to see if the ALT text ends with 'bytes'
	**********************************************************/

	private static boolean endsWithBytes(final String txt) {
		return txt.endsWith("bytes");
	}


	/*******************************************************
	* textFromOneNode
	*
	* Returns a list of characters contained within one
	* text node.
	*******************************************************/

	private String textFromOneNode(final Lexer lexer, final Node node) {
		if (node != null) {
			/* Copy contents of a text node */
			return TidyUtils.getString(lexer.lexbuf, node.start, node.end - node.start);
		}
		return "";
	}


	/*********************************************************
	* getTextNode
	*
	* Locates text nodes within a container element.
	* Retrieves text that are found contained within
	* text nodes, and concatenates the text.
	*********************************************************/

	private void getTextNode(final Lexer lexer, final Node node) {
		if (node.isText()) {
			/* Retrieves each character found within the text node */
			textNode.append(TidyUtils.getString(lexer.lexbuf, node.start, node.end - node.start));
		}
	}


	/**********************************************************
	* getTextNodeClear
	*
	* Clears the current 'textNode' and reloads it with new
	* text.  The textNode must be cleared before use.
	**********************************************************/

	private String getTextNodeClear(final Lexer lexer, final Node node) {
		/* Clears list */
		textNode.setLength(0);

		getTextNode(lexer, node.content);
		return textNode.toString();
	}

	/**********************************************************
	* LevelX_Enabled
	*
	* Tell whether access "X" is enabled.
	**********************************************************/

	private boolean level1Enabled() {
		return level == 1 || level == 2 || level == 3;
	}

	private boolean level2Enabled() {
		return level == 2 || level == 3;
	}

	private boolean level3Enabled() {
		return level == 3;
	}

	/********************************************************
	* CheckColorAvailable
	*
	* Verify that information conveyed with color is
	* available without color.
	********************************************************/

	private void checkColorAvailable(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			switch (node.getId()) {
			case IMG:
				lexer.report.accessWarning(lexer, node, AccessErrorCode.INFORMATION_NOT_CONVEYED_IMAGE);
				break;
			case APPLET:
				lexer.report.accessWarning(lexer, node, AccessErrorCode.INFORMATION_NOT_CONVEYED_APPLET);
				break;
			case OBJECT:
				lexer.report.accessWarning(lexer, node, AccessErrorCode.INFORMATION_NOT_CONVEYED_OBJECT);
				break;
			case SCRIPT:
				lexer.report.accessWarning(lexer, node, AccessErrorCode.INFORMATION_NOT_CONVEYED_SCRIPT);
				break;
			case INPUT:
				lexer.report.accessWarning(lexer, node, AccessErrorCode.INFORMATION_NOT_CONVEYED_INPUT);
				break;
			}
		}
	}

	/*********************************************************************
	* CheckColorContrast
	*
	* Checks elements for color contrast.  Must have valid contrast for
	* valid visibility.
	*
	* This logic is extremely fragile as it does not recognize
	* the fact that color is inherited by many components and
	* that BG and FG colors are often set separately.  E.g. the
	* background color may be set by for the body or a table
	* or a cell.  The foreground color may be set by any text
	* element (p, h1, h2, input, textarea), either explicitly
	* or by style.  Ergo, this test will not handle most real
	* world cases.  It's a start, however.
	*********************************************************************/

	private void checkColorContrast(final Lexer lexer, final Node node) {
		int rgbBG[] = {255,255,255};   /* Black text on white BG */

		if (level3Enabled()) {
			boolean gotBG = true;
			AttVal av;

			/* Check for 'BGCOLOR' first to compare with other color attributes */
			for (av = node.attributes; av != null; av = av.next) {
				if (av.is(AttrId.BGCOLOR)) {
					if (hasValue(av)) {
						gotBG = getRgb(av.value, rgbBG);
					}
				}
			}
			/*
			   Search for COLOR attributes to compare with background color
			   Must have valid colour contrast
			*/
			for (av = node.attributes; gotBG && av != null; av = av.next) {
				AccessErrorCode errcode = null;
				switch (av.getId()) {
				case TEXT:
					errcode = AccessErrorCode.COLOR_CONTRAST_TEXT;
					break;
				case LINK:
					errcode = AccessErrorCode.COLOR_CONTRAST_LINK;
					break;
				case ALINK:
					errcode = AccessErrorCode.COLOR_CONTRAST_ACTIVE_LINK;
					break;
				case VLINK:
					errcode = AccessErrorCode.COLOR_CONTRAST_VISITED_LINK;
					break;
				}
				if (errcode != null && hasValue(av)) {
					int rgbFG[] = {0, 0, 0};  /* Black text */

					if (getRgb(av.value, rgbFG) && !compareColors(rgbBG, rgbFG)) {
						lexer.report.accessWarning(lexer, node, errcode);
					}
				}
			}
		}
	}


	/**************************************************************
	* CompareColors
	*
	* Compares two RGB colors for good contrast.
	**************************************************************/
	private static int minmax(final int i1, final int i2) {
		return Math.max(i1, i2) - Math.min(i1, i2);
	}

	private static int brightness(final int rgb[]) {
		return ((rgb[0] * 299) + (rgb[1] * 587) + (rgb[2] * 114)) / 1000;
	}

	private static boolean compareColors(final int rgbBG[], final int rgbFG[]) {
		int brightBG = brightness(rgbBG);
		int brightFG = brightness(rgbFG);

		int diffBright = minmax(brightBG, brightFG);
		int diffColor = minmax(rgbBG[0], rgbFG[0]) + minmax(rgbBG[1], rgbFG[1]) + minmax(rgbBG[2], rgbFG[2]);

		return diffBright > 180 && diffColor > 500;
	}


	/*********************************************************************
	* GetRgb
	*
	* Gets the red, green and blue values for this attribute for the
	* background.
	*
	* Example: If attribute is BGCOLOR="#121005" then red = 18, green = 16,
	* blue = 5.
	*********************************************************************/

	private static boolean getRgb(final String color, final int rgb[]) {
		/* Check if we have a color name */
		for (int x = 0; x < colorNames.length; x++) {
			if (colorNames[x].contains(color)) {
				rgb[0] = colorValues[x][0];
				rgb[1] = colorValues[x][1];
				rgb[2] = colorValues[x][2];
				return true;
			}
		}
		/*
		   No color name so must be hex values
		   Is this a number in hexadecimal format?
		*/
		/* Must be 7 characters in the RGB value (including '#') */
		if (color.length() == 7 && color.charAt(0) == '#') {
			rgb[0] = (ctox(color.charAt(1)) * 16) + ctox(color.charAt(2));
			rgb[1] = (ctox(color.charAt(3)) * 16) + ctox(color.charAt(4));
			rgb[2] = (ctox(color.charAt(5)) * 16) + ctox(color.charAt(6));
			return true;
		}
		return false;
	}


	/*******************************************************************
	* ctox
	*
	* Converts a character to a number.
	* Example: if given character is 'A' then returns 10.
	*
	* Returns the number that the character represents. Returns -1 if not a
	* valid number.
	*******************************************************************/

	private static int ctox(final char ch) {
		if (ch >= '0' && ch <= '9') {
			 return ch - '0';
		}
		else if (ch >= 'a' && ch <= 'f') {
			return ch - 'a' + 10;
		}
		else if (ch >= 'A' && ch <= 'F') {
			return ch - 'A' + 10;
		}
		return -1;
	}


	/***********************************************************
	* CheckImage
	*
	* Checks all image attributes for specific elements to
	* check for validity of the values contained within
	* the attributes.  An appropriate warning message is displayed
	* to indicate the error.
	***********************************************************/

	private void checkImage(final Lexer lexer, Node node) {
		if (level1Enabled()) {
			boolean hasAlt = false;
			boolean hasIsMap = false;
			boolean hasLongDesc = false;
			boolean hasDLINK = false;
			boolean hasValidHeight = false;
			boolean hasValidWidthBullet = false;
			boolean hasValidWidthHR = false;
			boolean hasTriggeredMissingLongDesc = false;

			/* Checks all image attributes for invalid values within attributes */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				/*
				   Checks for valid ALT attribute.
				   The length of the alt text must be less than 150 characters
				   long.
				*/
				if (av.is(AttrId.ALT)) {
					if (av.value != null) {
						if (av.value.length() < 150 && !isPlaceholderAlt(av.value) && !isPlaceHolderObject(av.value)
								&& !endsWithBytes(av.value) && !isImage(av.value)) {
							hasAlt = true;
						}
						else if (av.value.length() > 150) {
							hasAlt = true;
							lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_ALT_SUSPICIOUS_TOO_LONG);
						}
						else if (isImage(av.value)) {
							hasAlt = true;
							lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_ALT_SUSPICIOUS_FILENAME);
						}
						else if (isPlaceholderAlt(av.value)) {
							hasAlt = true;
							lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_ALT_SUSPICIOUS_PLACEHOLDER);
						}
						else if (endsWithBytes(av.value)) {
							hasAlt = true;
							lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_ALT_SUSPICIOUS_FILE_SIZE);
						}
					}
				}
				/*
				   Checks for width values of 'bullets' and 'horizontal
				   rules' for validity.

				   Valid pixel width for 'bullets' must be < 30, and > 150 for
				   horizontal rules.
				*/
				else if (av.is(AttrId.WIDTH)) {
					/* Longdesc attribute needed if width attribute is not present. */
					if (hasValue(av)) {
						int width = Integer.parseInt(av.value);
						if (width < 30) {
							hasValidWidthBullet = true;
						}
						if (width > 150) {
							hasValidWidthHR = true;
						}
					}
				}
				/*
				   Checks for height values of 'bullets' and horizontal
				   rules for validity.

				   Valid pixel height for 'bullets' and horizontal rules
				   must be < 30.
				*/
				else if (av.is(AttrId.HEIGHT)) {
					/* Longdesc attribute needed if height attribute not present. */
					if (hasValue(av) && Integer.parseInt(av.value) < 30) {
						hasValidHeight = true;
					}
				}
				/*
				   Checks for longdesc and determines validity.
				   The length of the 'longdesc' must be > 1
				*/
				else if (av.is(AttrId.LONGDESC)) {
					if (hasValue(av) && av.value.length() > 1) {
						hasLongDesc = true;
					}
				}
				/*
				   Checks for 'USEMAP' attribute.  Ensures that
				   text links are provided for client-side image maps
				*/
				else if (av.is(AttrId.USEMAP)) {
					if (hasValue(av)) {
						hasUseMap = true;
					}
				}
				else if (av.is(AttrId.ISMAP)) {
					hasIsMap = true;
				}
			}

			/*
				Check to see if a dLINK is present.  The ANCHOR element must
				be present following the IMG element.  The text found between
				the ANCHOR tags must be < 6 characters long, and must contain
				the letter 'd'.
			*/
			if (node.next.is(TagId.A)) {
				node = node.next;
				/*
					Node following the anchor must be a text node
					for dLINK to exist
				*/
				if (node.content != null && node.content.tag == null) {
					/* Number of characters found within the text node */
					String word = textFromOneNode(lexer, node.content);
					if (word.equals("d") || word.equals("D")) {
						hasDLINK = true;
					}
				}
			}
			/*
				Special case check for dLINK.  This will occur if there is
				whitespace between the <img> and <a> elements.  Ignores
				whitespace and continues check for dLINK.
			*/
			if (node.next != null && node.next.tag == null) {
				node = node.next;

				if (node.next.is(TagId.A)) {
					node = node.next;
					/*
						Node following the ANCHOR must be a text node
						for dLINK to exist
					*/
					if (node.content != null && node.content.tag == null) {
						/* Number of characters found within the text node */
						String word = textFromOneNode(lexer, node.content);

						if (word.equals("d") || word.equals("D")) {
							hasDLINK = true;
						}
					}
				}
			}

			if (!hasAlt) {
				lexer.report.accessError(lexer, node, AccessErrorCode.IMG_MISSING_ALT);
			}
			if (!hasLongDesc && hasValidHeight && (hasValidWidthHR || hasValidWidthBullet)) {
				hasTriggeredMissingLongDesc = true;
			}
			if (!hasTriggeredMissingLongDesc) {
				if (hasDLINK && !hasLongDesc) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_MISSING_LONGDESC);
				}
				if (hasLongDesc && !hasDLINK) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_MISSING_DLINK);
				}
				if (!hasLongDesc && !hasDLINK) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_MISSING_LONGDESC_DLINK);
				}
			}
			if (hasIsMap) {
				lexer.report.accessError(lexer, node, AccessErrorCode.IMAGE_MAP_SERVER_SIDE_REQUIRES_CONVERSION);
				lexer.report.accessWarning(lexer, node, AccessErrorCode.IMG_MAP_SERVER_REQUIRES_TEXT_LINKS);
			}
		}
	}


	/***********************************************************
	* CheckApplet
	*
	* Checks APPLET element to check for validity pertaining
	* the 'ALT' attribute.  An appropriate warning message is
	* displayed  to indicate the error. An appropriate warning
	* message is displayed to indicate the error.  If no 'ALT'
	* text is present, then there must be alternate content
	* within the APPLET element.
	***********************************************************/

	private void checkApplet(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			boolean hasAlt = false;
			boolean hasDescription = false;

			/* Checks for attributes within the APPLET element */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				/*
				   Checks for valid ALT attribute.
				   The length of the alt text must be > 4 characters in length
				   but must be < 150 characters long.
				*/
				if (av.is(AttrId.ALT)) {
					if (av.value != null) {
						hasAlt = true;
					}
				}
			}
			if (!hasAlt) {
				/* Must have alternate text representation for that element */
				if (node.content != null) {
					String word = null;

					if (node.content.tag == null) {
						word = textFromOneNode(lexer, node.content);
					}
					if (node.content.content != null && node.content.content.tag == null) {
						word = textFromOneNode(lexer, node.content.content);
					}
					if (word != null && !isWhitespace(word)) {
						hasDescription = true;
					}
				}
			}
			if (!hasDescription && !hasAlt) {
				lexer.report.accessError(lexer, node, AccessErrorCode.APPLET_MISSING_ALT);
			}
		}
	}


	/*******************************************************************
	* CheckObject
	*
	* Checks to verify whether the OBJECT element contains
	* 'ALT' text, and to see that the sound file selected is
	* of a valid sound file type.  OBJECT must have an alternate text
	* representation.
	*******************************************************************/

	private void checkObject(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			boolean hasAlt = false;
			boolean hasDescription = false;

			if (node.content != null) {
				if (!node.content.isText()) {
					Node tnode = node.content;

					for (AttVal av = tnode.attributes; av != null; av = av.next) {
						if (av.is(AttrId.ALT)) {
							hasAlt = true;
							break;
						}
					}
				}

				/* Must have alternate text representation for that element */
				if (!hasAlt) {
					String word = null;
					if (node.content.isText()) {
						word = textFromOneNode(lexer, node.content);
					}
					if (word == null && node.content.content.isText()) {
						word = textFromOneNode(lexer, node.content.content);
					}
					if (word != null && !isWhitespace(word)) {
						hasDescription = true;
					}
				}
			}

			if (!hasAlt && !hasDescription) {
				lexer.report.accessError(lexer, node, AccessErrorCode.OBJECT_MISSING_ALT);
			}
		}
	}


	/***************************************************************
	* CheckMissingStyleSheets
	*
	* Ensures that stylesheets are used to control the presentation.
	***************************************************************/

	private static boolean checkMissingStyleSheets(final Node node) {
		boolean sspresent = false;

		for (Node content = node.content; !sspresent && content != null; content = content.next) {
			sspresent = content.is(TagId.LINK) || content.is(TagId.STYLE) || content.is(TagId.FONT)
					|| content.is(TagId.BASEFONT);

			for (AttVal av = content.attributes; !sspresent && av != null; av = av.next) {
				sspresent = av.is(AttrId.STYLE) || av.is(AttrId.TEXT) || av.is(AttrId.VLINK) || av.is(AttrId.ALINK)
						|| av.is(AttrId.LINK);

				if (!sspresent && av.is(AttrId.REL)) {
					sspresent = av.valueIs("stylesheet");
				}
			}

			if (!sspresent) {
				sspresent = checkMissingStyleSheets(content);
			}
		}
		return sspresent;
	}


	/*******************************************************************
	* CheckFrame
	*
	* Checks if the URL is valid and to check if a 'LONGDESC' is needed
	* within the FRAME element.  If a 'LONGDESC' is needed, the value must
	* be valid. The URL must end with the file extension, htm, or html.
	* Also, checks to ensure that the 'SRC' and 'TITLE' values are valid.
	*******************************************************************/

	private void checkFrame(final Lexer lexer, final Node node) {
		boolean hasTitle = false;
		numFrames++;

		if (level1Enabled()) {
			/* Checks for attributes within the FRAME element */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				/* Checks if 'LONGDESC' value is valid only if present */
				if (av.is(AttrId.LONGDESC)) {
					if (hasValue(av) && av.value.length() > 1) {
						hasCheckedLongDesc++;
					}
				}

				/* Checks for valid 'SRC' value within the frame element */
				else if (av.is(AttrId.SRC)) {
					if (hasValue(av) && !isValidSrcExtension(av.value)) {
						lexer.report.accessError(lexer, node, AccessErrorCode.FRAME_SRC_INVALID);
					}
				}

				/* Checks for valid 'TITLE' value within frame element */
				else if (av.is(AttrId.TITLE)) {
					if (hasValue(av)) {
						hasTitle = true;
					}
					if (!hasTitle) {
						if (av.value == null || av.value.length() == 0) {
							hasTitle = true;
							lexer.report.accessError(lexer, node, AccessErrorCode.FRAME_TITLE_INVALID_NULL);
						}
						else {
							if (isWhitespace(av.value) && av.value.length() > 0) {
								hasTitle = true;
								lexer.report.accessError(lexer, node, AccessErrorCode.FRAME_TITLE_INVALID_SPACES);
							}
						}
					}
				}
			}
			if (!hasTitle) {
				lexer.report.accessError(lexer, node, AccessErrorCode.FRAME_MISSING_TITLE);
			}
			if (numFrames == 3 && hasCheckedLongDesc < 3) {
				numFrames = 0;
				lexer.report.accessWarning(lexer, node, AccessErrorCode.FRAME_MISSING_LONGDESC);
			}
		}
	}


	/****************************************************************
	* CheckIFrame
	*
	* Checks if 'SRC' value is valid.  Must end in appropriate
	* file extension.
	****************************************************************/

	private void checkIFrame(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			/* Checks for valid 'SRC' value within the IFRAME element */
			final AttVal av = node.getAttrById(AttrId.SRC);
			if (hasValue(av)) {
				if (!isValidSrcExtension(av.value)) {
					lexer.report.accessError(lexer, node, AccessErrorCode.FRAME_SRC_INVALID);
				}
			}
		}
	}


	/**********************************************************************
	* CheckAnchorAccess
	*
	* Checks that the sound file is valid, and to ensure that
	* text transcript is present describing the 'HREF' within the
	* ANCHOR element.  Also checks to see ensure that the 'TARGET' attribute
	* (if it exists) is not null and does not contain '_new' or '_blank'.
	**********************************************************************/

	private void checkAnchorAccess(final Lexer lexer, final Node node) {
		boolean hasDescription = false;
		boolean hasTriggeredLink = false;

		/* Checks for attributes within the ANCHOR element */
		for (AttVal av = node.attributes; av != null; av = av.next) {
			if (level1Enabled()) {
				/* Must be of valid sound file type */
				if (av.is(AttrId.HREF)) {
					if (hasValue(av)) {
						String ext = getFileExtension (av.value);

						/* Checks to see if multimedia is used */
						if (isValidMediaExtension(av.value)) {
							lexer.report.accessError(lexer, node, AccessErrorCode.MULTIMEDIA_REQUIRES_TEXT);
						}
						/*
							Checks for validity of sound file, and checks to see if
							the file is described within the document, or by a link
							that is present which gives the description.
						*/
						if (ext.length() < 6 && ext.length() > 0) {
							AccessErrorCode errcode = isSoundFile(av.value);
							if (errcode != null) {
								if (node.next != null) {
									if (node.next.tag == null) {
										String word = textFromOneNode(lexer, node.next);

										/* Must contain at least one letter in the text */
										if (!isWhitespace(word)) {
											hasDescription = true;
										}
									}
								}

								/* Must contain text description of sound file */
								if (!hasDescription) {
									lexer.report.accessError(lexer, node, errcode);
								}
							}
						}
					}
				}
			}

			if (level2Enabled()) {
				/* Checks 'TARGET' attribute for validity if it exists */
				if (av.is(AttrId.TARGET)) {
					if (av.valueIs("_new")) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.NEW_WINDOWS_REQUIRE_WARNING_NEW);
					}
					else if (av.valueIs("_blank")) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.NEW_WINDOWS_REQUIRE_WARNING_BLANK);
					}
				}
			}
		}

		if (level2Enabled()) {
			if (node.content != null && node.content.tag == null) {
				String word = textFromOneNode(lexer, node.content);
				if (word != null && !isWhitespace(word)) {
					if (word.equals("more")) {
						hasTriggeredLink = true;
					}
					if (word.equals("click here")) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.LINK_TEXT_NOT_MEANINGFUL_CLICK_HERE);
					}
					if (hasTriggeredLink == false) {
						if (word.length() < 6) {
							lexer.report.accessWarning(lexer, node, AccessErrorCode.LINK_TEXT_NOT_MEANINGFUL);
						}
					}
					if (word.length() > 60) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.LINK_TEXT_TOO_LONG);
					}
				}
			}
			if (node.content == null) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.LINK_TEXT_MISSING);
			}
		}
	}


	/************************************************************
	* CheckArea
	*
	* Checks attributes within the AREA element to
	* determine if the 'ALT' text and 'HREF' values are valid.
	* Also checks to see ensure that the 'TARGET' attribute
	* (if it exists) is not null and does not contain '_new'
	* or '_blank'.
	************************************************************/

	private void checkArea(final Lexer lexer, final Node node) {
		boolean hasAlt = false;

		/* Checks all attributes within the AREA element */
		for (AttVal av = node.attributes; av != null; av = av.next) {
			if (level1Enabled()) {
				/*
				  Checks for valid ALT attribute.
				  The length of the alt text must be > 4 characters long
				  but must be less than 150 characters long.
				*/
				if (av.is(AttrId.ALT)) {
					/* The check for validity */
					if (av.value != null) {
						hasAlt = true;
					}
				}
			}

			if (level2Enabled()) {
				if (av.is(AttrId.TARGET)) {
					if (av.valueIs("_new")) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.NEW_WINDOWS_REQUIRE_WARNING_NEW);
					}
					else if (av.valueIs("_blank")) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.NEW_WINDOWS_REQUIRE_WARNING_BLANK);
					}
				}
			}
		}

		if (level1Enabled()) {
			/* AREA must contain alt text */
			if (!hasAlt) {
				lexer.report.accessError(lexer, node, AccessErrorCode.AREA_MISSING_ALT);
			}
		}
	}


	/***************************************************
	* CheckScript
	*
	* Checks the SCRIPT element to ensure that a
	* NOSCRIPT section follows the SCRIPT.
	***************************************************/

	private void checkScriptAcc(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			/* NOSCRIPT element must appear immediately following SCRIPT element */
			if (node.next == null || !node.next.is(TagId.NOSCRIPT)) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_MISSING_NOSCRIPT);
			}
		}
	}


	/**********************************************************
	* CheckRows
	*
	* Check to see that each table has a row of headers if
	* a column of columns doesn't exist.
	**********************************************************/

	private void checkRows(final Lexer lexer, Node node) {
		int numTR = 0;
		int numValidTH = 0;
		checkedHeaders++;

		for (; node != null; node = node.next) {
			numTR++;
			if (node.content.is(TagId.TH)) {
				hasTH = true;
				if (node.content.content.isText()) {
					String word = textFromOneNode(lexer, node.content.content);
					if (!isWhitespace(word)) {
						numValidTH++;
					}
				}
			}
		}
		if (numTR == numValidTH) {
			hasValidRowHeaders = true;
		}
		if (numTR >= 2 && numTR > numValidTH && numValidTH >= 2 && hasTH) {
			hasInvalidRowHeader = true;
		}
	}


	/**********************************************************
	* CheckColumns
	*
	* Check to see that each table has a column of headers if
	* a row of columns doesn't exist.
	**********************************************************/

	private void checkColumns(final Lexer lexer, final Node node) {
		int numTH = 0;
		boolean isMissingHeader = false;

		checkedHeaders++;

		/* Table must have row of headers if headers for columns don't exist */
		if (node.content.is(TagId.TH)) {
			hasTH = true;

			for (Node tnode = node.content; tnode != null; tnode = tnode.next) {
				if (tnode.is(TagId.TH)) {
					if (tnode.content.isText()) {
						String word = textFromOneNode(lexer, tnode.content);
						if (!isWhitespace(word)) {
							numTH++;
						}
					}
				}
				else {
					isMissingHeader = true;
				}
			}
		}

		if (!isMissingHeader && numTH > 0) {
			hasValidColumnHeaders = true;
		}
		if (isMissingHeader && numTH >= 2) {
			hasInvalidColumnHeader = true;
		}
	}


	/*****************************************************
	* CheckTH
	*
	* Checks to see if the header provided for a table
	* requires an abbreviation. (only required if the
	* length of the header is greater than 15 characters)
	*****************************************************/

	private void checkTH(final Lexer lexer, final Node node) {
		if (level3Enabled()) {
			boolean hasAbbr = false;

			/* Checks TH element for 'ABBR' attribute */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				if (av.is(AttrId.ABBR)) {
					/* Value must not be null and must be less than 15 characters */
					if (av.value != null && !isWhitespace(av.value)) {
						hasAbbr = true;
					}
					if (av.value == null || av.value.length() == 0) {
						hasAbbr = true;
						lexer.report.accessWarning(lexer, node, AccessErrorCode.TABLE_MAY_REQUIRE_HEADER_ABBR_NULL);
					}
					if (isWhitespace(av.value) && av.value.length() > 0) {
						hasAbbr = true;
						lexer.report.accessWarning(lexer, node, AccessErrorCode.TABLE_MAY_REQUIRE_HEADER_ABBR_SPACES);
					}
				}
			}

			/* If the header is greater than 15 characters, an abbreviation is needed */
			final String word = textFromOneNode(lexer, node.content);

			if (word != null && !isWhitespace(word)) {
				/* Must have 'ABBR' attribute if header is > 15 characters */
				if (word.length() > 15 && !hasAbbr) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.TABLE_MAY_REQUIRE_HEADER_ABBR);
				}
			}
		}
	}


	/*****************************************************************
	* CheckMultiHeaders
	*
	* Layout tables should make sense when linearized.
	* TABLE must contain at least one TH element.
	* This technique applies only to tables used for layout purposes,
	* not to data tables. Checks for column of multiple headers.
	*****************************************************************/

	private void checkMultiHeaders(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			boolean validColSpanRows = true;
			boolean validColSpanColumns = true;

			int flag = 0;

			if (node.content != null) {
				Node tnode = node.content;
				/*
				   Checks for column of multiple headers found
				   within a data table.
				*/
				while (tnode != null) {
					if (tnode.is(TagId.TR)) {
						if (tnode.content != null) {
							Node temp = tnode.content;

							/* The number of TH elements found within TR element */
							if (flag == 0) {
								while (temp != null) {
									/*
									   Must contain at least one TH element
									   within in the TR element
									*/
									if (temp.is(TagId.TH)) {
										for (AttVal av = temp.attributes; av != null; av = av.next) {
											if (av.is(AttrId.COLSPAN) && (Integer.parseInt(av.value) > 1)) {
												validColSpanColumns = false;
											}
											if (av.is(AttrId.ROWSPAN) && (Integer.parseInt(av.value) > 1)) {
												validColSpanRows = false;
											}
										}
									}
									temp = temp.next;
								}
								flag = 1;
							}
						}
					}
					tnode = tnode.next;
				}
				/* Displays HTML 4 Table Algorithm when multiple column of headers used */
				if (!validColSpanRows) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.DATA_TABLE_REQUIRE_MARKUP_ROW_HEADERS);
					lexer.report.displayHTMLTableAlgorithm(lexer);
				}
				if (!validColSpanColumns) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.DATA_TABLE_REQUIRE_MARKUP_COLUMN_HEADERS);
					lexer.report.displayHTMLTableAlgorithm(lexer);
				}
			}
		}
	}


	/****************************************************
	* CheckTable
	*
	* Checks the TABLE element to ensure that the
	* table is not missing any headers.  Must have either
	* a row or column of headers.
	****************************************************/

	private void checkTable(final Lexer lexer, final Node node) {
		int numTR = 0;
		boolean hasSummary = false;
		boolean hasCaption = false;

		if (level3Enabled()) {
			/* Table must have a 'SUMMARY' describing the purpose of the table */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				if (av.is(AttrId.SUMMARY)) {
					if (hasValue(av)) {
						hasSummary = true;
						if (av.contains("summary") && av.contains("table")) {
							lexer.report.accessError(lexer, node, AccessErrorCode.TABLE_SUMMARY_INVALID_PLACEHOLDER);
						}
					}
					if (av.value == null || av.value.length() == 0) {
						hasSummary = true;
						lexer.report.accessError(lexer, node, AccessErrorCode.TABLE_SUMMARY_INVALID_NULL);
					}
					else if (isWhitespace(av.value) && av.value.length() > 0) {
						hasSummary = true;
						lexer.report.accessError(lexer, node, AccessErrorCode.TABLE_SUMMARY_INVALID_SPACES);
					}
				}
			}

			/* TABLE must have content. */
			if (node.content == null) {
				lexer.report.accessError(lexer, node, AccessErrorCode.DATA_TABLE_MISSING_HEADERS);
				return;
			}
		}

		if (level1Enabled()) {
			/* Checks for multiple headers */
			checkMultiHeaders(lexer, node);
		}

		if (level2Enabled()) {
			/* Table must have a CAPTION describing the purpose of the table */
			if (node.content.is(TagId.CAPTION)) {
				Node tnode = node.content;
				String word = null;

				if (tnode.content != null && tnode.content.tag == null) {
					word = getTextNodeClear(lexer, tnode);
				}
				if (!isWhitespace(word)) {
					hasCaption = true;
				}
			}
			if (!hasCaption) {
				lexer.report.accessError(lexer, node, AccessErrorCode.TABLE_MISSING_CAPTION);
			}
		}

		if (node.content != null) {
			if (node.content.is(TagId.CAPTION) && node.content.next != null && node.content.next.is(TagId.TR)) {
				checkColumns(lexer, node.content.next);
			}
			else if (node.content.is(TagId.TR)) {
				checkColumns(lexer, node.content);
			}
		}
		if (!hasValidColumnHeaders) {
			if (node.content != null) {
				if (node.content.is(TagId.CAPTION) && node.content.next != null && node.content.next.is(TagId.TR)) {
					checkRows(lexer, node.content.next);
				}
				else if (node.content.is(TagId.TR)) {
					checkRows(lexer, node.content);
				}
			}
		}

		if (level3Enabled()) {
			/* Suppress warning for missing 'SUMMARY for HTML 2.0 and HTML 3.2 */
			if (!hasSummary) {
				lexer.report.accessError(lexer, node, AccessErrorCode.TABLE_MISSING_SUMMARY);
			}
		}

		if (level2Enabled()) {
			if (node.content != null) {
				Node temp = node.content;

				while (temp != null) {
					if (temp.is(TagId.TR)) {
						numTR++;
					}
					temp = temp.next;
				}

				if (numTR == 1) {
					lexer.report.accessWarning(lexer, node, AccessErrorCode.LAYOUT_TABLES_LINEARIZE_PROPERLY);
				}
			}
			if (hasTH) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.LAYOUT_TABLE_INVALID_MARKUP);
			}
		}

		if (level1Enabled()) {
			if (checkedHeaders == 2) {
				if (!hasValidRowHeaders && !hasValidColumnHeaders && !hasInvalidRowHeader && !hasInvalidColumnHeader) {
					lexer.report.accessError(lexer, node, AccessErrorCode.DATA_TABLE_MISSING_HEADERS);
				}
				if (!hasValidRowHeaders && hasInvalidRowHeader) {
					lexer.report.accessError(lexer, node, AccessErrorCode.DATA_TABLE_MISSING_HEADERS_ROW);
				}

				if (!hasValidColumnHeaders && hasInvalidColumnHeader) {
					lexer.report.accessError(lexer, node, AccessErrorCode.DATA_TABLE_MISSING_HEADERS_COLUMN);
				}
			}
		}
	}


	/***************************************************
	* CheckASCII
	*
	* Checks for valid text equivalents for XMP and PRE
	* elements for ASCII art.  Ensures that there is
	* a skip over link to skip multi-lined ASCII art.
	***************************************************/

	private void checkASCII(final Lexer lexer, final Node node) {
		String skipOver = null;
		boolean IsAscii = false;
		int hasSkipOverLink = 0;

		int newLines = -1;
		char compareLetter;
		int matchingCount = 0;

		if (level1Enabled() && node.content != null) {
			/*
			   Checks the text within the PRE and XMP tags to see if ascii
			   art is present
			*/
			for (int i = node.content.start + 1; i < node.content.end; i++) {
				matchingCount = 0;

				/* Counts the number of lines of text */
				if (lexer.lexbuf[i] == '\n') {
					newLines++;
				}
				compareLetter = (char) lexer.lexbuf[i];

				/* Counts consecutive character matches */
				for (int x = i; x < i + 5; x++) {
					if (lexer.lexbuf[x] == compareLetter) {
						matchingCount++;
					}
					else {
						break;
					}
				}

				/* Must have at least 5 consecutive character matches */
				if (matchingCount >= 5) {
					break;
				}
			}
			/*
			   Must have more than 6 lines of text OR 5 or more consecutive
			   letters that are the same for there to be ascii art
			*/
			if (newLines >= 6 || matchingCount >= 5) {
				IsAscii = true;
			}

			/* Checks for skip over link if ASCII art is present */
			if (IsAscii) {
				if (node.prev != null && node.prev.prev != null) {
					final Node temp1 = node.prev.prev;

					/* Checks for 'HREF' attribute */
					for (AttVal av = temp1.attributes; av != null; av = av.next) {
						if (av.is(AttrId.HREF) && hasValue(av)) {
							skipOver = av.value;
							hasSkipOverLink++;
						}
					}
				}
			}
		}

		if (level2Enabled()) {
			/*
			   Checks for A element following PRE to ensure proper skipover link
			   only if there is an A element preceding PRE.
			*/
			if (hasSkipOverLink == 1) {
				if (node.next.is(TagId.A)) {
					final Node temp2 = node.next;

					/* Checks for 'NAME' attribute */
					for (AttVal av = temp2.attributes; av != null; av = av.next) {
						if (av.is(AttrId.NAME) && hasValue(av)) {
							/*
							   Value within the 'HREF' attribute must be the same
							   as the value within the 'NAME' attribute for valid
							   skipover.
							*/
							if (skipOver.contains(av.value)) {
								hasSkipOverLink++;
							}
						}
					}
				}
			}

			if (IsAscii) {
				lexer.report.accessError(lexer, node, AccessErrorCode.ASCII_REQUIRES_DESCRIPTION);
				if (level3Enabled() && hasSkipOverLink < 2) {
					lexer.report.accessError(lexer, node, AccessErrorCode.SKIPOVER_ASCII_ART);
				}
			}
		}
	}


	/***********************************************************
	* CheckFormControls
	*
	* <form> must have valid 'FOR' attribute, and <label> must
	* have valid 'ID' attribute for valid form control.
	***********************************************************/

	private void checkFormControls(final Lexer lexer, final Node node) {
		if (!hasValidFor && hasValidId) {
			lexer.report.accessError(lexer, node, AccessErrorCode.ASSOCIATE_LABELS_EXPLICITLY_FOR);
		}
		if (!hasValidId && hasValidFor) {
			lexer.report.accessError(lexer, node, AccessErrorCode.ASSOCIATE_LABELS_EXPLICITLY_ID);
		}
		if (!hasValidId && !hasValidFor) {
			lexer.report.accessError(lexer, node, AccessErrorCode.ASSOCIATE_LABELS_EXPLICITLY);
		}
	}


	/************************************************************
	* CheckLabel
	*
	* Check for valid 'FOR' attribute within the LABEL element
	************************************************************/

	private void checkLabel(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			/* Checks for valid 'FOR' attribute */
			final AttVal av = node.getAttrById(AttrId.FOR);
			if (hasValue(av)) {
				hasValidFor = true;
			}
			if (++forID == 2) {
				forID = 0;
				checkFormControls(lexer, node);
			}
		}
	}


	/************************************************************
	* CheckInputLabel
	*
	* Checks for valid 'ID' attribute within the INPUT element.
	* Checks to see if there is a LABEL directly before
	* or after the INPUT element determined by the 'TYPE'.
	* Each INPUT element must have a LABEL describing the form.
	************************************************************/

	private void checkInputLabel(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			/* Checks attributes within the INPUT element */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				/* Must have valid 'ID' value */
				if (av.is(AttrId.ID) && hasValue(av)) {
					hasValidId = true;
				}
			}
			if (++forID == 2) {
				forID = 0;
				checkFormControls(lexer, node);
			}
		}
	}


	/***************************************************************
	* CheckInputAttributes
	*
	* INPUT element must have a valid 'ALT' attribute if the
	* 'VALUE' attribute is present.
	***************************************************************/

	private void checkInputAttributes(final Lexer lexer, final Node node) {
		boolean hasAlt = false;
		boolean mustHaveAlt = false;

		/* Checks attributes within the INPUT element */
		for (AttVal av = node.attributes; av != null; av = av.next) {
			/* 'VALUE' must be found if the 'TYPE' is 'text' or 'checkbox' */
			if (av.is(AttrId.TYPE) && hasValue(av)) {
				if (level1Enabled()) {
					if (av.valueIs("image")) {
						mustHaveAlt = true;
					}
				}
			}
			if (av.is(AttrId.ALT) && hasValue(av)) {
				hasAlt = true;
			}
		}
		if (mustHaveAlt && !hasAlt) {
			lexer.report.accessError(lexer, node, AccessErrorCode.IMG_BUTTON_MISSING_ALT);
		}
	}


	/***************************************************************
	* CheckFrameSet
	*
	* Frameset must have valid NOFRAME section.  Must contain some
	* text but must not contain information telling user to update
	* browsers,
	***************************************************************/

	private void checkFrameSet(final Lexer lexer, final Node node) {
		boolean hasNoFrames = false;

		if (level1Enabled()) {
			if ((lexer.badAccess & Report.INVALID_LINK_NOFRAMES) != 0) {
			   lexer.report.accessError(lexer, node, AccessErrorCode.NOFRAMES_INVALID_LINK);
			   lexer.badAccess &= ~Report.INVALID_LINK_NOFRAMES; /* emit only once */
			}
			for (Node temp = node.content; temp != null ; temp = temp.next) {
				if (temp.is(TagId.NOFRAMES)) {
					hasNoFrames = true;

					if (temp.content != null && temp.content.content.is(TagId.P)) {
						final Node para = temp.content.content;
						if (para.content.isText()) {
							final String word = textFromOneNode(lexer, para.content);
							if (word != null && word.contains("browser")) {
								lexer.report.accessError(lexer, para, AccessErrorCode.NOFRAMES_INVALID_CONTENT);
							}
						}
					}
					else if (temp.content == null) {
						lexer.report.accessError(lexer, temp, AccessErrorCode.NOFRAMES_INVALID_NO_VALUE);
					}
					else if (temp.content != null && isWhitespace(textFromOneNode(lexer, temp.content))) {
						lexer.report.accessError(lexer, temp, AccessErrorCode.NOFRAMES_INVALID_NO_VALUE);
					}
				}
			}
			if (!hasNoFrames) {
				lexer.report.accessError(lexer, node, AccessErrorCode.FRAME_MISSING_NOFRAMES);
			}
		}
	}


	/***********************************************************
	* CheckHeaderNesting
	*
	* Checks for heading increases and decreases.  Headings must
	* not increase by more than one header level, but may
	* decrease at from any level to any level.  Text within
	* headers must not be more than 20 words in length.
	***********************************************************/

	private void checkHeaderNesting(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			int numWords = 1;
			boolean isValidIncrease = false;
			boolean needsDescription = false;
			/*
			   Text within header element cannot contain more than 20 words without
			   a separate description
			*/
			if (node.content != null && node.content.tag == null) {
				final String word = textFromOneNode(lexer, node.content);

				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == ' ') {
						numWords++;
					}
				}
				if (numWords > 20) {
					needsDescription = true;
				}
			}

			/* Header following must be same level or same plus 1 for
			** valid heading increase size.  E.g. H1 . H1, H2.  H3 . H3, H4
			*/
			if (node.isHeader()) {
				int level = node.getHeaderLevel();
				isValidIncrease = true;

				for (Node temp = node.next; temp != null; temp = temp.next) {
					final int nested = temp.getHeaderLevel();
					if (nested >= level) {
						isValidIncrease = nested <= level + 1;
						break;
					}
				}
			}
			if (!isValidIncrease) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.HEADERS_IMPROPERLY_NESTED);
			}
			if (needsDescription) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.HEADER_USED_FORMAT_TEXT);
			}
		}
	}


	/*************************************************************
	* CheckParagraphHeader
	*
	* Checks to ensure that P elements are not headings.  Must be
	* greater than 10 words in length, and they must not be in bold,
	* or italics, or underlined, etc.
	*************************************************************/

	private void checkParagraphHeader(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			/* Cannot contain text formatting elements */
			if (node.content != null) {
				boolean isNotHeader = false;
				if (node.content.tag != null) {
					Node temp = node.content;

					while (temp != null) {
						if (temp.tag == null) {
							isNotHeader = true;
							break;
						}
						temp = temp.next;
					}
				}
				if (!isNotHeader) {
					if (node.content.is(TagId.STRONG)) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.POTENTIAL_HEADER_BOLD);
					}
					if (node.content.is(TagId.U)) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.POTENTIAL_HEADER_UNDERLINE);
					}
					if (node.content.is(TagId.EM)) {
						lexer.report.accessWarning(lexer, node, AccessErrorCode.POTENTIAL_HEADER_ITALICS);
					}
				}
			}
		}
	}


	/****************************************************************
	* CheckEmbed
	*
	* Checks to see if 'SRC' is a multimedia type.  Must have
	* syncronized captions if used.
	****************************************************************/

	private void checkEmbed(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			final AttVal av = node.getAttrById(AttrId.SRC);
			if (hasValue(av) && isValidMediaExtension(av.value)) {
				 lexer.report.accessError(lexer, node, AccessErrorCode.MULTIMEDIA_REQUIRES_TEXT);
			}
		}
	}


	/*********************************************************************
	* CheckHTMLAccess
	*
	* Checks HTML element for valid 'LANG' attribute.  Must be a valid
	* language.  ie. 'fr' or 'en'
	********************************************************************/

	private void checkHTMLAccess(final Lexer lexer, final Node node) {
		if (level3Enabled()) {
			boolean validLang = false;
			final AttVal av = node.getAttrById(AttrId.LANG);
			if (av != null) {
				validLang = true;
				if (!hasValue(av)) {
					lexer.report.accessError(lexer, node, AccessErrorCode.LANGUAGE_INVALID);
				}
			}
			if (!validLang) {
				lexer.report.accessError(lexer, node, AccessErrorCode.LANGUAGE_NOT_IDENTIFIED);
			}
		}
	}


	/********************************************************
	* CheckBlink
	*
	* Document must not contain the BLINK element.
	* It is invalid HTML/XHTML.
	*********************************************************/

	private void checkBlink(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			/* Checks to see if text is found within the BLINK element. */
			if (node.content.isText()) {
				final String word = textFromOneNode(lexer, node.content);
				if (!isWhitespace(word)) {
					lexer.report.accessError(lexer, node, AccessErrorCode.REMOVE_BLINK_MARQUEE);
				}
			}
		}
	}


	/********************************************************
	* CheckMarquee
	*
	* Document must not contain the MARQUEE element.
	* It is invalid HTML/XHTML.
	********************************************************/

	private void checkMarquee(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			/* Checks to see if there is text in between the MARQUEE element */
			if (node.isText()) {
				final String word = textFromOneNode(lexer, node.content);
				if (!isWhitespace(word)) {
					lexer.report.accessError(lexer, node, AccessErrorCode.REMOVE_BLINK_MARQUEE);
				}
			}
		}
	}


	/**********************************************************
	* CheckLink
	*
	* 'REL' attribute within the LINK element must not contain
	* 'stylesheet'.  HTML/XHTML document is unreadable when
	* style sheets are applied.  -- CPR huh?
	**********************************************************/

	private void checkLink(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			boolean hasRel = false;
			boolean hasType = false;
			/* Check for valid 'REL' and 'TYPE' attribute */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				if (av.is(AttrId.REL) && hasValue(av)) {
					if (av.contains("stylesheet")) {
						hasRel = true;
					}
				}
				if (av.is(AttrId.TYPE) && hasValue(av)) {
					hasType = true;
				}
			}
			if (hasRel && hasType) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.STYLESHEETS_REQUIRE_TESTING_LINK);
			}
		}
	}


	/*******************************************************
	* CheckStyle
	*
	* Document must not contain STYLE element.  HTML/XHTML
	* document is unreadable when style sheets are applied.
	*******************************************************/

	private void checkStyle(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			lexer.report.accessWarning(lexer, node, AccessErrorCode.STYLESHEETS_REQUIRE_TESTING_STYLE_ELEMENT);
		}
	}


	/*************************************************************
	* DynamicContent
	*
	* Verify that equivalents of dynamic content are updated and
	* available as often as the dynamic content.
	*************************************************************/

	private void dynamicContent(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			AccessErrorCode msgcode = null;
			if (node.is(TagId.APPLET)) {
				msgcode = AccessErrorCode.TEXT_EQUIVALENTS_REQUIRE_UPDATING_APPLET;
			}
			else if (node.is(TagId.SCRIPT)) {
				msgcode = AccessErrorCode.TEXT_EQUIVALENTS_REQUIRE_UPDATING_SCRIPT;
			}
			else if (node.is(TagId.OBJECT)) {
				msgcode = AccessErrorCode.TEXT_EQUIVALENTS_REQUIRE_UPDATING_OBJECT;
			}
			if (msgcode != null) {
				lexer.report.accessWarning(lexer, node, msgcode);
			}
		}
	}


	/*************************************************************
	* ProgrammaticObjects
	*
	* Verify that the page is usable when programmatic objects
	* are disabled.
	*************************************************************/

	private void programmaticObjects(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			AccessErrorCode msgcode = null;
			switch (node.getId()) {
			case SCRIPT:
				msgcode = AccessErrorCode.PROGRAMMATIC_OBJECTS_REQUIRE_TESTING_SCRIPT;
				break;
			case OBJECT:
				msgcode = AccessErrorCode.PROGRAMMATIC_OBJECTS_REQUIRE_TESTING_OBJECT;
				break;
			case EMBED:
				msgcode = AccessErrorCode.PROGRAMMATIC_OBJECTS_REQUIRE_TESTING_EMBED;
				break;
			case APPLET:
				msgcode = AccessErrorCode.PROGRAMMATIC_OBJECTS_REQUIRE_TESTING_APPLET;
				break;
			}
			if (msgcode != null) {
				lexer.report.accessWarning(lexer, node, msgcode);
			}
		}
	}


	/*************************************************************
	* AccessibleCompatible
	*
	* Verify that programmatic objects are directly accessible.
	*************************************************************/

	private void accessibleCompatible(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			AccessErrorCode msgcode = null;
			switch (node.getId()) {
			case SCRIPT:
				msgcode = AccessErrorCode.ENSURE_PROGRAMMATIC_OBJECTS_ACCESSIBLE_SCRIPT;
				break;
			case OBJECT:
				msgcode = AccessErrorCode.ENSURE_PROGRAMMATIC_OBJECTS_ACCESSIBLE_OBJECT;
				break;
			case EMBED:
				msgcode = AccessErrorCode.ENSURE_PROGRAMMATIC_OBJECTS_ACCESSIBLE_EMBED;
				break;
			case APPLET:
				msgcode = AccessErrorCode.ENSURE_PROGRAMMATIC_OBJECTS_ACCESSIBLE_APPLET;
				break;
			}
			if (msgcode != null) {
				lexer.report.accessWarning(lexer, node, msgcode);
			}
		}
	}


	/**************************************************
	* CheckFlicker
	*
	* Verify that the page does not cause flicker.
	**************************************************/

	private void checkFlicker(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			AccessErrorCode msgcode = null;
			switch (node.getId()) {
			case SCRIPT:
				msgcode = AccessErrorCode.REMOVE_FLICKER_SCRIPT;
				break;
			case OBJECT:
				msgcode = AccessErrorCode.REMOVE_FLICKER_OBJECT;
				break;
			case EMBED:
				msgcode = AccessErrorCode.REMOVE_FLICKER_EMBED;
				break;
			case APPLET:
				msgcode = AccessErrorCode.REMOVE_FLICKER_APPLET;
				break;
			case IMG:
				/* Checks for animated gif within the <img> tag. */
				final AttVal av = node.getAttrById(AttrId.SRC);
				if (hasValue(av)) {
					final String ext = getFileExtension(av.value);
					if (ext.equalsIgnoreCase(".gif")) {
						msgcode = AccessErrorCode.REMOVE_FLICKER_ANIMATED_GIF;
					}
				}
				break;
			}
			if (msgcode != null) {
				lexer.report.accessWarning(lexer, node, msgcode);
			}
		}
	}


	/**********************************************************
	* CheckDeprecated
	*
	* APPLET, BASEFONT, CENTER, FONT, ISINDEX,
	* S, STRIKE, and U should not be used.  Becomes deprecated
	* HTML if any of the above are used.
	**********************************************************/

	private void checkDeprecated(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			AccessErrorCode msgcode = null;
			switch (node.getId()) {
			case APPLET:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_APPLET;
				break;
			case BASEFONT:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_BASEFONT;
				break;
			case CENTER:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_CENTER;
				break;
			case DIR:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_DIR;
				break;
			case FONT:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_FONT;
				break;
			case ISINDEX:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_ISINDEX;
				break;
			case MENU:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_MENU;
				break;
			case S:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_S;
				break;
			case STRIKE:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_STRIKE;
				break;
			case U:
				msgcode = AccessErrorCode.REPLACE_DEPRECATED_HTML_U;
				break;
			}
			if (msgcode != null) {
				lexer.report.accessError(lexer, node, msgcode);
			}
		}
	}


	/************************************************************
	* CheckScriptKeyboardAccessible
	*
	* Elements must have a device independent event handler if
	* they have any of the following device dependent event
	* handlers.
	************************************************************/

	private void checkScriptKeyboardAccessible(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			int hasOnMouseDown = 0;
			int hasOnMouseUp = 0;
			int hasOnClick = 0;
			int hasOnMouseOut = 0;
			int hasOnMouseOver = 0;
			int hasOnMouseMove = 0;

			/* Checks all elements for their attributes */
			for (AttVal av = node.attributes; av != null; av = av.next) {
				switch (av.getId()) {
				/* Must also have 'ONKEYDOWN' attribute with 'ONMOUSEDOWN' */
				case OnMOUSEDOWN:
					hasOnMouseDown++;
					break;
				/* Must also have 'ONKEYUP' attribute with 'ONMOUSEUP' */
				case OnMOUSEUP:
					hasOnMouseUp++;
					break;
				/* Must also have 'ONKEYPRESS' attribute with 'ONCLICK' */
				case OnCLICK:
					hasOnClick++;
					break;
				/* Must also have 'ONBLUR' attribute with 'ONMOUSEOUT' */
				case OnMOUSEOUT:
					hasOnMouseOut++;
					break;
				case OnMOUSEOVER:
					hasOnMouseOver++;
					break;
				case OnMOUSEMOVE:
					hasOnMouseMove++;
					break;
				case OnKEYDOWN:
					hasOnMouseDown++;
					break;
				case OnKEYUP:
					hasOnMouseUp++;
					break;
				case OnKEYPRESS:
					hasOnClick++;
					break;
				case OnBLUR:
					hasOnMouseOut++;
					break;
				}
			}
			if (hasOnMouseDown == 1) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_NOT_KEYBOARD_ACCESSIBLE_ON_MOUSE_DOWN);
			}
			if (hasOnMouseUp == 1) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_NOT_KEYBOARD_ACCESSIBLE_ON_MOUSE_UP);
			}
			if (hasOnClick == 1) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_NOT_KEYBOARD_ACCESSIBLE_ON_CLICK);
			}
			if (hasOnMouseOut == 1) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_NOT_KEYBOARD_ACCESSIBLE_ON_MOUSE_OUT);
			}
			if (hasOnMouseOver == 1) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_NOT_KEYBOARD_ACCESSIBLE_ON_MOUSE_OVER);
			}
			if (hasOnMouseMove == 1) {
				lexer.report.accessError(lexer, node, AccessErrorCode.SCRIPT_NOT_KEYBOARD_ACCESSIBLE_ON_MOUSE_MOVE);
			}
			/* Recursively check all child nodes.
			 */
			for (Node content = node.content; content != null; content = content.next) {
				checkScriptKeyboardAccessible(lexer, content);
			}
		}
	}


	/**********************************************************
	* CheckMetaData
	*
	* Must have at least one of these elements in the document.
	* META, LINK, TITLE or ADDRESS.  <meta> must contain
	* a "content" attribute that doesn't contain a URL, and
	* an "http-Equiv" attribute that doesn't contain 'refresh'.
	**********************************************************/

	private boolean checkMetaData(final Lexer lexer, final Node node, boolean hasMetaData) {
		if (level2Enabled()) {
			boolean hasHttpEquiv = false;
			boolean hasContent = false;
			boolean containsAttr = false;

			if (node.is(TagId.META)) {
				for (AttVal av = node.attributes; av != null; av = av.next) {
					if (av.is(AttrId.HTTP_EQUIV) && hasValue(av)) {
						containsAttr = true;

						/* Must not have an auto-refresh */
						if (av.valueIs("refresh")) {
							hasHttpEquiv = true;
							lexer.report.accessError(lexer, node, AccessErrorCode.REMOVE_AUTO_REFRESH);
						}
					}

					if (av.is(AttrId.CONTENT) && hasValue(av)) {
						containsAttr = true;

						/* If the value is not an integer, then it must not be a URL */
						if (av.value.startsWith("http:")) {
							hasContent = true;
							lexer.report.accessError(lexer, node, AccessErrorCode.REMOVE_AUTO_REDIRECT);
						}
					}
				}

				if (hasContent || hasHttpEquiv) {
					hasMetaData = true;
					lexer.report.accessError(lexer, node, AccessErrorCode.METADATA_MISSING_REDIRECT_AUTOREFRESH);
				}
				else {
					if (containsAttr && !hasContent && !hasHttpEquiv) {
						hasMetaData = true;
					}
				}
			}

			if (!hasMetaData && node.is(TagId.ADDRESS) && node.content.is(TagId.A)) {
				hasMetaData = true;
			}

			if (!hasMetaData && node != null && !node.is(TagId.TITLE) && node.content != null
					&& node.content.isText()) {
				final String word = textFromOneNode(lexer, node.content);
				if (!isWhitespace(word)) {
					hasMetaData = true;
				}
			}

			if (!hasMetaData && node.is(TagId.LINK)) {
				final AttVal av = node.getAttrById(AttrId.REL);
				if (!av.contains("stylesheet")) {
					hasMetaData = true;
				}
			}

			/* Check for MetaData */
			for (Node node2 = node.content; node2 != null; node2 = node2.next) {
				hasMetaData = checkMetaData(lexer, node2, hasMetaData);
			}
		}
		return hasMetaData;
	}


	/*******************************************************
	* MetaDataPresent
	*
	* Determines if MetaData is present in document
	*******************************************************/

	private void metaDataPresent(final Lexer lexer, final Node node) {
		if (level2Enabled()) {
			lexer.report.accessError(lexer, node, AccessErrorCode.METADATA_MISSING);
		}
	}


	/*****************************************************
	* CheckDocType
	*
	* Checks that every HTML/XHTML document contains a
	* '!DOCTYPE' before the root node. ie.  <HTML>
	*****************************************************/

	private void checkDocType(final Lexer lexer) {
		if (level2Enabled()) {
			Node dtNode = lexer.root.findDocType();

			/* If the doctype has been added by tidy, DTnode.end will be 0. */
			if (dtNode != null && dtNode.end != 0) {
				final String word = textFromOneNode(lexer, dtNode);
				if (!word.contains("HTML PUBLIC") && !word.contains("html PUBLIC")) {
					dtNode = null;
				}
			}
			if (dtNode == null) {
				lexer.report.accessError(lexer, lexer.root, AccessErrorCode.DOCTYPE_MISSING);
			}
		}
	}


	/********************************************************
	* CheckMapLinks
	*
	* Checks to see if an HREF for A element matches HREF
	* for AREA element.  There must be an HREF attribute
	* of an A element for every HREF of an AREA element.
	********************************************************/

	private static boolean urlMatch(final String url1, final String url2) {
		// TODO: Make host part case-insensitive and remainder case-sensitive.
		return url1.equals(url2);
	}

	private static boolean findLinkA(Node node, final String url) {
		boolean found = false;
		for (node = node.content; !found && node != null; node = node.next) {
			if (node.is(TagId.A)) {
				final AttVal href = node.getAttrById(AttrId.HREF);
				found = hasValue(href) && urlMatch(url, href.value);
			}
			else {
				found = findLinkA(node, url);
			}
		}
		return found;
	}

	private void checkMapLinks(final Lexer lexer, final Node node) {
		if (!level3Enabled()) {
			return;
		}
		/* Stores the 'HREF' link of an AREA element within a MAP element */
		for (Node child = node.content; child != null; child = child.next) {
			if (child.is(TagId.AREA)) {
				/* Checks for 'HREF' attribute */
				final AttVal href = child.getAttrById(AttrId.HREF);
				if (hasValue(href) && !findLinkA(lexer.root, href.value)) {
					lexer.report.accessError(lexer, node, AccessErrorCode.IMG_MAP_CLIENT_MISSING_TEXT_LINKS);
				}
			}
		}
	}


	/****************************************************
	* CheckForStyleAttribute
	*
	* Checks all elements within the document to check
	* for the use of 'STYLE' attribute.
	****************************************************/

	private void checkForStyleAttribute(final Lexer lexer, final Node node) {
		if (level1Enabled()) {
			/* Must not contain 'STYLE' attribute */
			final AttVal style = node.getAttrById(AttrId.STYLE);
			if (hasValue(style)) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.STYLESHEETS_REQUIRE_TESTING_STYLE_ATTR);
			}
		}

		/* Recursively check all child nodes.
		*/
		for (Node content = node.content; content != null; content = content.next) {
			checkForStyleAttribute(lexer, content);
		}
	}


	/*****************************************************
	* CheckForListElements
	*
	* Checks document for list elements (<ol>, <ul>, <li>)
	*****************************************************/

	private void checkForListElements(final Lexer lexer, Node node) {
		if (node.is(TagId.LI)) {
			listElements++;
		}
		else if (node.is(TagId.OL) || node.is(TagId.UL)) {
			otherListElements++;
		}

		for (node = node.content; node != null; node = node.next) {
			checkForListElements(lexer, node);
		}
	}


	/******************************************************
	* CheckListUsage
	*
	* Ensures that lists are properly used.  <ol> and <ul>
	* must contain <li> within itself, and <li> must not be
	* by itself.
	******************************************************/

	private void checkListUsage(final Lexer lexer, final Node node) {
		if (!level2Enabled()) {
			return;
		}
		AccessErrorCode msgcode = null;

		if (node.is(TagId.OL)) {
			msgcode = AccessErrorCode.LIST_USAGE_INVALID_OL;
		}
		else if (node.is(TagId.UL)) {
			msgcode = AccessErrorCode.LIST_USAGE_INVALID_UL;
		}
		if (msgcode != null) {
			/*
			** Check that OL/UL
			** a) has LI child,
			** b) was not added by Tidy parser
			** IFF OL/UL node is implicit
			*/
			if (!node.content.is(TagId.LI)) {
				lexer.report.accessWarning(lexer, node, msgcode);
			}
			else if (node.implicit) {  /* if a tidy added node */
				lexer.report.accessWarning(lexer, node, AccessErrorCode.LIST_USAGE_INVALID_LI);
			}
		}
		else if (node.is(TagId.LI)) {
			/* Check that LI parent
			** a) exists,
			** b) is either OL or UL
			** IFF the LI parent was added by Tidy
			** ie, if it is marked 'implicit', then
			** emit warnings LIST_USAGE_INVALID_UL or
			** warning LIST_USAGE_INVALID_OL tests
			*/
			if (node.parent == null || (!node.parent.is(TagId.OL) && !node.parent.is(TagId.UL))) {
				lexer.report.accessWarning(lexer, node, AccessErrorCode.LIST_USAGE_INVALID_LI);
			}
			else if (node.implicit && node.parent != null && (node.parent.is(TagId.OL) || node.parent.is(TagId.UL))) {
				/* if tidy added LI node, then */
				msgcode = node.parent.is(TagId.UL) ?
						AccessErrorCode.LIST_USAGE_INVALID_UL : AccessErrorCode.LIST_USAGE_INVALID_OL;
				lexer.report.accessWarning(lexer, node, msgcode);
			}
		}
	}

	/************************************************************
	* AccessibilityChecks
	*
	* Traverses through the individual nodes of the tree
	* and checks attributes and elements for accessibility.
	* after the tree structure has been formed.
	************************************************************/

	private void accessibilityCheckNode(final Lexer lexer, final Node node) {
		/* Check BODY for color contrast */
		if (node.is(TagId.BODY)) {
			checkColorContrast(lexer, node);
		}
		/* Checks document for MetaData */
		else if (node.is(TagId.HEAD)) {
			if (!checkMetaData(lexer, node, false)) {
				metaDataPresent(lexer, node);
			}
		}
		/* Check the ANCHOR tag */
		else if (node.is(TagId.A)) {
			checkAnchorAccess(lexer, node);
		}
		/* Check the IMAGE tag */
		else if (node.is(TagId.IMG)) {
			checkFlicker(lexer, node);
			checkColorAvailable(lexer, node);
			checkImage(lexer, node);
		}
		/* Checks MAP for client-side text links */
		else if (node.is(TagId.MAP)) {
			checkMapLinks(lexer, node);
		}
		/* Check the AREA tag */
		else if (node.is(TagId.AREA)) {
			checkArea(lexer, node);
		}
		/* Check the APPLET tag */
		else if (node.is(TagId.APPLET)) {
			checkDeprecated(lexer, node);
			programmaticObjects(lexer, node);
			dynamicContent(lexer, node);
			accessibleCompatible(lexer, node);
			checkFlicker(lexer, node);
			checkColorAvailable(lexer, node);
			checkApplet(lexer, node);
		}
		/* Check the OBJECT tag */
		else if (node.is(TagId.OBJECT)) {
			programmaticObjects(lexer, node);
			dynamicContent(lexer, node);
			accessibleCompatible(lexer, node);
			checkFlicker(lexer, node);
			checkColorAvailable(lexer, node);
			checkObject(lexer, node);
		}
		/* Check the FRAME tag */
		else if (node.is(TagId.FRAME)) {
			checkFrame(lexer, node);
		}
		/* Check the IFRAME tag */
		else if (node.is(TagId.IFRAME)) {
			checkIFrame(lexer, node);
		}
		/* Check the SCRIPT tag */
		else if (node.is(TagId.SCRIPT)) {
			dynamicContent(lexer, node);
			programmaticObjects(lexer, node);
			accessibleCompatible(lexer, node);
			checkFlicker(lexer, node);
			checkColorAvailable(lexer, node);
			checkScriptAcc(lexer, node);
		}
		/* Check the TABLE tag */
		else if (node.is(TagId.TABLE)) {
			checkColorContrast(lexer, node);
			checkTable(lexer, node);
		}
		/* Check the PRE for ASCII art */
		else if (node.is(TagId.PRE) || node.is(TagId.XMP)) {
			checkASCII(lexer, node);
		}
		/* Check the LABEL tag */
		else if (node.is(TagId.LABEL)) {
			checkLabel(lexer, node);
		}
		/* Check INPUT tag for validity */
		else if (node.is(TagId.INPUT)) {
			checkColorAvailable(lexer, node);
			checkInputLabel(lexer, node);
			checkInputAttributes(lexer, node);
		}
		/* Checks FRAMESET element for NOFRAME section */
		else if (node.is(TagId.FRAMESET)) {
			checkFrameSet(lexer, node);
		}
		/* Checks for header elements for valid header increase */
		else if (node.isHeader()) {
			checkHeaderNesting(lexer, node);
		}
		/* Checks P element to ensure that it is not a header */
		else if (node.is(TagId.P)) {
			checkParagraphHeader(lexer, node);
		}
		/* Checks HTML element for valid 'LANG' */
		else if (node.is(TagId.HTML)) {
			checkHTMLAccess(lexer, node);
		}
		/* Checks BLINK for any blinking text */
		else if (node.is(TagId.BLINK)) {
			checkBlink(lexer, node);
		}
		/* Checks MARQUEE for any MARQUEE text */
		else if (node.is(TagId.MARQUEE)) {
			checkMarquee(lexer, node);
		}
		/* Checks LINK for 'REL' attribute */
		else if (node.is(TagId.LINK)) {
			checkLink(lexer, node);
		}
		/* Checks to see if STYLE is used */
		else if (node.is(TagId.STYLE)) {
			checkColorContrast(lexer, node);
			checkStyle(lexer, node);
		}
		/* Checks to see if EMBED is used */
		else if (node.is(TagId.EMBED)) {
			checkEmbed(lexer, node);
			programmaticObjects(lexer, node);
			accessibleCompatible(lexer, node);
			checkFlicker(lexer, node);
		}
		/* Deprecated HTML if the following tags are found in the document */
		else if (node.is(TagId.BASEFONT) || node.is(TagId.CENTER) || node.is(TagId.ISINDEX) || node.is(TagId.U)
				|| node.is(TagId.FONT) || node.is(TagId.DIR) || node.is(TagId.S) || node.is(TagId.STRIKE)
				|| node.is(TagId.MENU)) {
			checkDeprecated(lexer, node);
		}
		/* Checks for 'ABBR' attribute if needed */
		else if (node.is(TagId.TH)) {
			checkTH(lexer, node);
		}
		/* Ensures that lists are properly used */
		else if (node.is(TagId.LI) || node.is(TagId.OL) || node.is(TagId.UL)) {
			checkListUsage(lexer, node);
		}
		/* Recursively check all child nodes.
		*/
		for (Node content = node.content; content != null; content = content.next) {
			accessibilityCheckNode(lexer, content);
		}
	}

	protected static void check(final Lexer lexer) {
		new Accessibility().runChecks(lexer);
	}

	private void runChecks(final Lexer lexer) {
		/* Initialize */
		level = lexer.configuration.getAccessibilityCheckLevel();

		/* Hello there, ladies and gentlemen... */
		lexer.report.accessibilityHelloMessage(lexer);

		/* Checks all elements for script accessibility */
		checkScriptKeyboardAccessible(lexer, lexer.root);

		/* Checks entire document for the use of 'STYLE' attribute */
		checkForStyleAttribute(lexer, lexer.root);

		/* Checks for '!DOCTYPE' */
		checkDocType(lexer);

		/* Checks to see if stylesheets are used to control the layout */
		if (level2Enabled() && ! checkMissingStyleSheets(lexer.root)) {
			lexer.report.accessWarning(lexer, lexer.root, AccessErrorCode.STYLE_SHEET_CONTROL_PRESENTATION);
		}

		/* Check to see if any list elements are found within the document */
		checkForListElements(lexer, lexer.root);

		/* Recursively apply all remaining checks to
		** each node in document.
		*/
		accessibilityCheckNode(lexer, lexer.root);
	}
}
