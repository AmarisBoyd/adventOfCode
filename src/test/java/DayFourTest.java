import com.advent.year2025.Day_Four.DayFour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DayFourTest {
    @Test
    public void DayFourTestA() throws IOException {
        int dayFourTestAnswerA=13;
        int dayFourAnswerA =1411;
        int dayFourTestRes= DayFour.part_a(true);
        int dayFourRes= DayFour.part_a(false);
        Assertions.assertEquals(dayFourAnswerA,dayFourRes);
        Assertions.assertEquals(dayFourTestAnswerA,dayFourTestRes);



    }
    @Test
    public  void DayFourTestB() throws IOException {
        int dayFourTestAnswerB=43;
        int dayFourAnswerB =8557;
        Assertions.assertEquals(dayFourTestAnswerB,DayFour.part_b(true));
        Assertions.assertEquals(dayFourAnswerB,DayFour.part_b(false));
    }


}

