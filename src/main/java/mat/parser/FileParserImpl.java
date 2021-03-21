package mat.parser;

import mat.Gender;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}
