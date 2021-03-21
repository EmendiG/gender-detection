package mat.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private String names;

    public StringParser(String names) {
        this.names = names;
    }

    public List<String> parseName(String separator) {
        return Arrays.stream( names.split(separator) )
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

}
