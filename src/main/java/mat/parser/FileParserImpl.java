package mat.parser;

import mat.Gender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class FileParserImpl implements FileParser {

    @Override
    public long howManyNamesFoundByGender(Gender pickedGender, List<String> searchedNames) {
        long sum = 0;

        try (Stream<String> stream = Files.lines(Paths.get("female.txt"))) {
            sum = stream
                    .map(String::toLowerCase)
                    .filter(token -> {
                        for (String name : searchedNames) {
                            if (name.toLowerCase().equals(token.toLowerCase())) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .count();
            return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public long getNumberOfCharacters(Gender pickedGender) {
        long countedLines = 0;
        long allNamesLength = 0;
        try (Stream<String> stream = Files.lines(Paths.get("female.txt"))) {
            Iterator<String> iterator = stream.iterator();
            while (iterator.hasNext()) {
                countedLines++;
                allNamesLength += iterator.next().length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countedLines + allNamesLength;
    }
}
