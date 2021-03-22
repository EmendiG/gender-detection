package mat.parser;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    /**
     *  Parse given full name string by any non-alphabetic char
     */
    public static List<String> parseName(String names) {
        // uri might contain encoded alphanumeric values
        // that should be decoded but other delimiters should be replaced
        names = names
                .replaceAll("[[^a-zA-Z0-9|%]+]", "-")
                .replaceAll("%20", "-");
        return Arrays.stream(names.split("-"))
                .map(s -> URLDecoder.decode(s, StandardCharsets.UTF_8))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

}
