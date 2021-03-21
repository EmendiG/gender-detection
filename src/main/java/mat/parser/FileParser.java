package mat.parser;

import java.util.stream.Stream;

public interface FileParser {

    long getNumberOfCharacters();
    Stream<String> getFileStream();

}
