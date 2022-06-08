import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.testng.annotations.Test;

/**
 * Test klasy MeasureTime
 */
class MeasureTimeTest {
    MeasureTime t1;

    @Test
    void testMeasureTime(){
        t1 = new MeasureTime();
        try {
            t1 = new MeasureTime();
            Thread.sleep(5000);
            Assertions.assertTrue(t1.endMeasure()>=5000, "Nie Działa");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}