/**
 * 
 */
package autokennzeichen.generator;

/**
 * All license tag generators implement this interface.
 * 
 * @author hmueller
 *
 */
public interface LicenseTagGenerator {
	
	/**
	 * Generates a fictional number plate/license tag for a car.
	 * The implementation should honor the rules of a specific country.
	 * 
	 * @return a String containing the license tag
	 */
	String generate();

}
