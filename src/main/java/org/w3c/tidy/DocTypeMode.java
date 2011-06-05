package org.w3c.tidy;

/**
 * Treatment of doctype.
 * 
 * @author trajano
 * 
 */
public enum DocTypeMode {
	/**
	 * treatment of doctype: auto.
	 */
	DOCTYPE_AUTO("auto", "auto"),

	/**
	 * treatment of doctype: loose.
	 */
	DOCTYPE_LOOSE("loose", "loose"),

	/**
	 * treatment of doctype: omit.
	 */
	DOCTYPE_OMIT("omit", "omit"),

	/**
	 * treatment of doctype: strict.
	 */
	DOCTYPE_STRICT("strict", "strict"),

	/**
	 * treatment of doctype: user.
	 */
	DOCTYPE_USER("user", null);

	/**
	 * Friendly name.
	 */
	private final String friendlyName;

	/**
	 * DocType. This can be null if {@link #DOCTYPE_USER}.
	 */
	private final String docType;

	/**
	 * Constructs the {@link Enum}.
	 * 
	 * @param friendlyName
	 *            A friendly name for the mode.
	 */
	private DocTypeMode(final String friendlyName, final String docType) {
		this.friendlyName = friendlyName;
		this.docType = docType;
	}

	/**
	 * This returns the friendly name that was given.
	 * 
	 * @return the friendly name.
	 */
	public final String getDocType() {
		return docType;
	}

	/**
	 * This returns the friendly name that was given.
	 * 
	 * @return the friendly name.
	 */
	public final String getFriendlyName() {
		return friendlyName;
	}
}
