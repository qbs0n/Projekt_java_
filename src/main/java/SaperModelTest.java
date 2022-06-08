
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * Test klasy SaperModel
 */
class SaperModelTest {

    SaperModel s1;
    SaperModel s2;
    SaperModel s3;
    SaperModel s4;
    int[][] t1= {{9,9,9},
            {9,0,9},
            {9,9,9}};

    int[][] t2= {{9,9,9,9},
            {9,0,0,9},
            {9,0,0,9},
            {9,9,9,9}};

    int[][] t3= {{0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}};

    int[][] t4= {{9,9,9,9},
            {9,9,9,9},
            {9,9,9,9},
            {9,9,9,9}};

    @BeforeEach
    void setUp() {
        s1 = new SaperModel(t1,3,1);
        s2 = new SaperModel(t2,4,4);
        s3 = new SaperModel(t3,4,16);
        s4 = new SaperModel(t4,4,0);
    }

    @Test
    @DisplayName("Sprawdzanie czy funkcja checkNeighbours zwraca dobrą wartość dla kilku losowych punktów")
    void testCheckNeighbours(){

        assertEquals(9,s1.checkNeighbours(0,0,s1.table),"Nie działa");
        assertEquals(8,s1.checkNeighbours(1,1,s1.table),"Nie działa");
        assertEquals(9,s1.checkNeighbours(2,2,s1.table),"Nie działa");

        assertEquals(5,s2.checkNeighbours(1,1,s2.table),"Nie działa");
        assertEquals(5,s2.checkNeighbours(2,2,s2.table),"Nie działa");
        assertEquals(9,s2.checkNeighbours(3,3,s2.table),"Nie działa");

        assertEquals(0,s3.checkNeighbours(0,3,s3.table),"Nie działa");
        assertEquals(0,s3.checkNeighbours(2,3,s3.table),"Nie działa");
        assertEquals(0,s3.checkNeighbours(1,2,s3.table),"Nie działa");

        assertEquals(9,s4.checkNeighbours(0,3,s4.table),"Nie działa");
        assertEquals(9,s4.checkNeighbours(3,1,s4.table),"Nie działa");
        assertEquals(9,s4.checkNeighbours(2,1,s4.table),"Nie działa");

    }




}