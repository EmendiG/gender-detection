package mat.parser;

import java.util.stream.Stream;

public interface FileParser {

    long getLengthOfLinesBytes(String lineBreaker);
    Stream<String> getFileStream();

}
