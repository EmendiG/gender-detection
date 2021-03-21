package mat.parser;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryParser {

    public Map<String, String> parseQueryToParams(String query) {
        return Arrays.stream(query.split("(\\?)|(&)"))
                .map(param -> param.split("="))
                .filter(entry -> entry.length > 1)
                .collect(Collectors.toMap(entry -> entry[0].toLowerCase(), entry -> entry[1].toLowerCase()));
    }

}
