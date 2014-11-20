/**
 * 
 */
package autokennzeichen.generator;


/**
 * Generates fake CH license tags using the real regional prefixes.
 * 
 * @author hmueller
 *
 */
public class CHGenerator implements LicenseTagGenerator {
	
	private LicenseTagHelper helper = null;
	
	public CHGenerator() {
		this.helper = new LicenseTagHelper("./src/autokennzeichen/generator/ch_prefixes.txt");
	}

	/* (non-Javadoc)
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		sb.append( this.helper.randomPrefix() );
		sb.append("-");
		sb.append(this.helper.randomDigits(this.helper.rnd.nextInt(2)+2) );
		sb.append(" ");
		sb.append(this.helper.randomDigits( 3 ) );
		
		return sb.toString();
	}

}
