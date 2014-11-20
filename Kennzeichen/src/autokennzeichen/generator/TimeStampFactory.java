/**
 * 
 */
package autokennzeichen.generator;

import java.sql.Timestamp;
import java.util.Random;

/**
 * Generates timestamps, starting at the hardcoded starting time.
 * 
 * @author hmueller
 *
 */
public class TimeStampFactory {

	private Random rnd = null;
	private final String start = "2014-01-01 08:00:00";

	private long time = 0L;

	public TimeStampFactory() {
		this.rnd = new Random();
		this.time = Timestamp.valueOf(start).getTime();
	}

	/**
	 * Each call to next() will return a new Timestamp that references a point
	 * in time after the the last call to next(). The timestamps should differ
	 * randomly by 10 to 60 seconds.
	 * 
	 * @return a random Timestamp
	 */
	public Timestamp next() {
		this.time += (this.rnd.nextInt(50) + 10) * 1000;
		return new Timestamp(time);
	}

}
