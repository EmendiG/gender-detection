package mat.algorithm;

import mat.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test.FileCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AlgorithmTest {

    @ParameterizedTest
    @MethodSource("injectAlgorithmURIString")
    void testFindGender(String algorithmURIString) {
        List<String> searchedNames = new ArrayList<>(Arrays.asList("kamil", "marcin", "piotr"));
        FileCreator fileCreator = new FileCreator();
        String filePath = fileCreator.createFileWithGivenTokens(searchedNames, Gender.MALE);

        // set up file Parser
        String paramName = "kamil-kasia marcin*piotr";
        Algorithm algorithm = new AlgorithmImpl();
        Gender foundGender = algorithm.findGender(paramName, algorithmURIString);

        Assertions.assertEquals(Gender.MALE, foundGender);

        // cleaning after testing
        fileCreator.deleteFileWithGivenPathString(filePath);
    }


    private static Stream<SearchPredicate> injectSearchPredicate() {
        return  Stream.of(
                new FirstSearchPredicate(),
                new ListSearchPredicate()
        );
    }

    private static Stream<String> injectAlgorithmURIString() {
        return  Stream.of(
                "list",
                "first"
        );
    }

}
