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
    public long getNumberOfCharacters() {
        long countedLines = 0;
        long allNamesLength = 0;
        Iterator<String> iterator = getFileStream().iterator();
        while (iterator.hasNext()) {
            countedLines ++;
            allNamesLength += iterator.next().length();
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
