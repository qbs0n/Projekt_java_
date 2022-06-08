import java.time.Duration;
import java.time.Instant;

/**
 * Prosta klasa używana do mierzenie czasu rozgrywki
 */
public class MeasureTime {

	/**
	 * Obiekt klasy Instant
	 */
	Instant time;

	/**
	 * Metoda rozpoczynająca odliczanie czasu
	 */
	public MeasureTime(){
		time = Instant.now();
	}

	/**
	 * Metoda kończąca odliczanie czasu
	 * @return odmierzony czas
	 */
	public long endMeasure() {
		return Duration.between(time, Instant.now()).toMillis();
	}
}
