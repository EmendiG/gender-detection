package mat.parser;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryParser {

    public static Map<String, String> parseQueryToParams(String query) {
        return Arrays.stream(query.split("(\\?)|(&)"))
                .map(param -> param.split("="))
                .filter(entry -> entry.length > 1)
                .peek(entry -> System.out.println(Arrays.toString(entry)))
                .collect(Collectors.toMap(entry -> entry[0].toLowerCase(), entry -> entry[1].toLowerCase()));
    }

}
