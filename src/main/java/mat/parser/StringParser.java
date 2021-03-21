package mat.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    /**
     *  Parse given full name string by any non-alphabetic char
     */
    public static List<String> parseName(String names) {
        return Arrays.stream(names.split("[^a-zA-Z]+"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

}
