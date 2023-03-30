

import org.example.GA;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GATest {


    @ParameterizedTest(name = "PopulationSize: {0}, NumberOfIterations: {1}")
    @CsvSource({
            "100, 5",
            "42, 5000",
            "40, 10000"
    })
    public void testGenericAlgorithm(int popSize, int numberOfIterations) {
        GA.LaunchAlgorithm(popSize, numberOfIterations);
    }
}
