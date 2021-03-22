package mat.parser;

import java.util.stream.Stream;

public interface FileParser {

    long getNumberOfCharacters(String lineBreaker);
    Stream<String> getFileStream();

}
