package mat.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SearchPredicateTest {

    @ParameterizedTest
    @MethodSource("injectSearchPredicate")
    void testIsSearchedName(SearchPredicate searchPredicate) {
        List<String> _testNames = new ArrayList<>(Arrays.asList("anna", "konrad"));

        Assertions.assertTrue(searchPredicate.isSearchedName(new String("anna"), _testNames));
    }

    @ParameterizedTest
    @MethodSource("injectSearchPredicate")
    void testRemoveName(SearchPredicate searchPredicate) {
        List<String> names = new ArrayList<>(Arrays.asList("anna", "konrad", "filip"));
        String name = "filip";

        searchPredicate.removeName(names, name);
        Assertions.assertNotEquals( 3 , names.size());
    }

    private static Stream<SearchPredicate> injectSearchPredicate() {
        return  Stream.of(
                new FirstSearchPredicate(),
                new ListSearchPredicate()
        );
    }


}
