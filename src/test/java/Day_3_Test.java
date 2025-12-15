import com.advent.year2025.Day_Three.Day_Three;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;

public class Day_3_Test {
@Test
public void dayThreePartATest() throws IOException {
    //result of what day 3 part a should b
    int DayThreePartA=357;

    int DayThreePartARes= Day_Three.part_a(true);
    Assertions.assertEquals(DayThreePartA,DayThreePartARes);

}
    @Test
    public void dayThreePartBTest() throws IOException {
        BigInteger DayThreePartB= new BigInteger("3121910778619");
        BigInteger DayThreePartBRes= Day_Three.part_b(true);
        Assertions.assertEquals(DayThreePartB,DayThreePartBRes);
    }
}
