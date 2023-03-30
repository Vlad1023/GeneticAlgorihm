

import org.example.GA;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GATest {

    @ParameterizedTest
    @CsvSource({
            "100, 3",
            "40, 5000",
            "40, 10000"
    })
    public void testOutputForParameters(int popSize, int numberOfIterations) {
        GA.LaunchAlgorithm(popSize, numberOfIterations);
    }
}
