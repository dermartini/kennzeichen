/**
 * 
 */
package autokennzeichen.generator;

import java.util.Random;

/**
 * "Supergenerator", creates license tags from different countries using their
 * respective generators.
 * 
 * @author hmueller
 *
 */
public class InternationalGenerator implements LicenseTagGenerator {

	private LicenseTagGenerator[] generators = null;
	private Random rnd = null;

	public InternationalGenerator() {
		this.rnd = new Random();
		this.generators = new LicenseTagGenerator[5];
		this.generators[0] = new DEGenerator();
		this.generators[1] = new CHGenerator();
		this.generators[2] = new BEGenerator();
		this.generators[3] = new ATGenerator();
		this.generators[4] = new ITGenerator();
		//this.generators[5] = new NLGenerator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		return this.generators[this.rnd.nextInt(this.generators.length)]
				.generate();
	}

}
