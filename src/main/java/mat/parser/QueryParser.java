package mat.parser;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryParser {

    /**
     *  Parse given URI parameters string to get all mapped parameters ?[param1]=[value1]&[param2]=[value2]
     */
    public static Map<String, String> parseQueryToParams(String query) {
        return Arrays.stream(query.split("(\\?)|(&)"))
                .map(param -> param.split("="))
                .filter(entry -> entry.length > 1)
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1] ));
    }

}
