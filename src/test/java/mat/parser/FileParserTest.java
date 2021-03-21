package mat.parser;

import mat.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.FileCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileParserTest {

    @Test
    void testGetNumberOfCharacters() {
        FileCreator fileCreator = new FileCreator();
        List<String> searchedNames = new ArrayList<>(Arrays.asList("kamil", "marcin", "piotr"));
        String filePath = fileCreator.createFileWithGivenTokens(searchedNames, Gender.MALE);

        FileParser fileParser = new FileParserImpl(Gender.MALE);

        // 16 char + 3 lines
        Assertions.assertEquals(16L + 3L, fileParser.getNumberOfCharacters());

        // cleaning after testing
        fileCreator.deleteFileWithGivenPathString(filePath);
    }

    @Test
    void testGetFileStream() {
        FileCreator fileCreator = new FileCreator();
        List<String> searchedNames = new ArrayList<>(Arrays.asList("kamil", "marcin", "piotr"));
        String filePath = fileCreator.createFileWithGivenTokens(searchedNames, Gender.MALE);


        FileParser fileParser = new FileParserImpl(Gender.MALE);
        Stream<String> fileStream = fileParser.getFileStream();
        Assertions.assertEquals(3L, fileStream.count());

        // cleaning after testing
        fileCreator.deleteFileWithGivenPathString(filePath);

    }




}
