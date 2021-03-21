package mat.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParserTest {

    @Test
    void testParseName() {

        String names = "kamil-kasia marcin*piotr";
        List<String> searchedNames = new ArrayList<>(Arrays.asList("kamil", "kasia", "marcin", "piotr"));

        Assertions.assertEquals(searchedNames, StringParser.parseName(names));
    }
}
