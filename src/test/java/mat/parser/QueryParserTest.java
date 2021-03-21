package mat.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class QueryParserTest {

    @Test
    void testparseQueryToParams() {
        String query = "/gender?name=kasia-basia*kamil&algorithm=first";
        Map<String, String> stringStringMap = QueryParser.parseQueryToParams(query);
        String name = stringStringMap.get("name");
        Assertions.assertEquals("kasia-basia*kamil", name);
    }
}
