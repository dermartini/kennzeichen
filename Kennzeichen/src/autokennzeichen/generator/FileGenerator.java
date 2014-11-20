/**
 * 
 */
package autokennzeichen.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates fake CollCollect logfiles using the license tag generators and the
 * TimeStampFactory.
 * 
 * @author hmueller
 *
 */
public class FileGenerator {

	/**
	 * Private construktor, prevents "new FileGenerator()"
	 */
	private FileGenerator() {
	}

	/**
	 * Generates a fake TollCollect logfile with the name <code>fileName</code>
	 * and the length <code>lines</code>.
	 * 
	 * @param fileName
	 *            name of the generated file
	 * @param lines
	 *            length of the generated file
	 */
	public static void generateLogFile(String fileName, int lines) {

		StringBuilder sb = new StringBuilder();
		LicenseTagGenerator gen = new InternationalGenerator();
		TimeStampFactory tf = new TimeStampFactory();

		for (int i = 0; i < lines; i++) {
			sb.append(tf.next());
			sb.append(" -- ");
			sb.append(gen.generate());
			sb.append(System.lineSeparator());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			bw.write(sb.toString());
		} catch (IOException e) {
			System.err.println("Couldn't write logfile: " + e);
		}

	}
}
