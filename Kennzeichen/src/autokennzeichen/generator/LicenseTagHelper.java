/**
 * 
 */
package autokennzeichen.generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Helper that contains functionality for handling license tag prefixes,
 * Choosing random elements from String pools, generating Stings containing an
 * amount of digits etc.
 * 
 * @author hmueller
 *
 */
public class LicenseTagHelper {

	public final Random rnd;

	private String[] prefixes = null;

	/**
	 * Constructs a Helper without prefix-functionality
	 */
	public LicenseTagHelper() {
		this.rnd = new Random();

	}

	/**
	 * Constructs a Helper with prefix functionality
	 * 
	 * @param fileName
	 */
	public LicenseTagHelper(String fileName) {
		this();
		this.prefixes = this.loadPrefixFile(fileName);
	}

	/**
	 * Loads a prefix file that contains one prefix per line.
	 * 
	 * @param fileName
	 *            the name of the file to load
	 * @return an array containing the prefix-Strings
	 */
	private String[] loadPrefixFile(String fileName) {
		List<String> prefixes = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String read = "";
			while ((read = br.readLine()) != null) {
				prefixes.add(read.trim());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Prefix File not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Failed to load prefix file: " + e.getMessage());
		}

		return prefixes.toArray(new String[prefixes.size()]);
	}

	/**
	 * Chooses a random prefix from the prefixes handled by this Helper. If this
	 * helper does not handle prefixes, a Runtimeexception is thrown.
	 * 
	 * @return a random prefix from this Helper's prefix pool
	 * @throws UnsupportedOperationException
	 *             if this Helper does not have a prefix pool
	 */
	public String randomPrefix() throws UnsupportedOperationException {
		if (this.prefixes == null) {
			throw new UnsupportedOperationException(
					"This Helper does not handle prefixes");
		}
		return this.randomString(this.prefixes);
	}

	/**
	 * Generates a String containing n random digits 0-9;
	 * 
	 * @return the String containing the digit
	 */
	public String randomDigits(int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(Integer.toString(this.rnd.nextInt(10)));
		}

		return sb.toString();
	}

	/**
	 * Chooses one random String from a pool of Strings.
	 * 
	 * @param pool
	 *            the pool of Strings to chose from
	 * @return the Chosen One
	 */
	public String randomString(String[] pool) {
		return pool[this.rnd.nextInt(pool.length)];
	}

}
