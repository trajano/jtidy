package org.w3c.tidy;

import java.util.HashMap;
import java.util.Map;

import org.w3c.tidy.Options.OptionEnum;

/**
 * Wrapper for handling the set of acceptable values for an enumerated option
 * 
 * @author aditsu
 */
public class OptionValues {
	private final OptionEnum[] values;
	private final Map<String, OptionEnum> valueMap = new HashMap<String, OptionEnum>();
	private final Class<? extends OptionEnum> cl;
	
	public OptionValues(final Class<? extends OptionEnum> cl) {
		values = cl.getEnumConstants();
		this.cl = cl;
		for (int i = 0; i < values.length; ++i) {
			final OptionEnum v = values[i];
			valueMap.put(v.getName(), v);
			for (String s : v.getSynonyms()) {
				valueMap.put(s, v);
			}
		}
	}
	
	public OptionEnum get(final int x) {
		return values[x];
	}
	
	/**
	 * Returns the option value matching the given string, or null if not found
	 */
	public OptionEnum get(final String value) {
		return valueMap.get(value);
	}
	
	public void checkValue(final OptionEnum value) {
		if (value.getClass() != cl) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Returns a String describing the possible option values (including names and synonyms)
	 */
	public String getDescription() {
		final StringBuilder sb = new StringBuilder();
		for (OptionEnum o : values) {
			sb.append(o.getName());
			for (String s : o.getSynonyms()) {
				sb.append('/').append(s);
			}
			sb.append(", ");
		}
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}
}
