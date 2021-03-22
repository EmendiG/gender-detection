package mat.parser;

import mat.Gender;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class FileParserImpl implements FileParser {

    private Gender pickedGender;
    private static final String fileExtension = ".txt";
    private static final Charset fileEncoding = StandardCharsets.UTF_8;

    public FileParserImpl(Gender pickedGender) {
        this.pickedGender = pickedGender;
    }

    /**
     *  Get length of all tokens + number of lines in the given Flat File
     */
    public long getNumberOfCharacters(String lineBreaker) {
        long countedLines = 0;
        long allNamesLength = 0;
        Iterator<String> iterator = getFileStream().iterator();
        while (iterator.hasNext()) {
            // get bytes of every token
            allNamesLength += iterator.next().getBytes(StandardCharsets.UTF_8).length;
            // every lines ends with lineBreaker == "<br>" tag
            countedLines += lineBreaker.length();
        }
        return countedLines + allNamesLength;
    }

    /**
     *  Get stream of Flat File lines for parsing purpose
     */
    public Stream<String> getFileStream() {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(pickedGender.toString().toLowerCase() + fileExtension);
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream), fileEncoding)).lines();
    }

}
