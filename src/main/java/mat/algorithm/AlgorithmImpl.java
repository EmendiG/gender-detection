package mat.algorithm;

import mat.Gender;
import mat.parser.FileParser;
import mat.parser.FileParserImpl;
import mat.parser.StringParser;

import java.util.List;

public class AlgorithmImpl implements Algorithm {

    @Override
    public Gender findGender(String paramName) {
        List<String> searchedNames = StringParser.parseName(paramName,"%20");

        FileParser fileParser = new FileParserImpl();
        long femaleCount = fileParser.howManyNamesFoundByGender(Gender.FEMALE, searchedNames);

        if (femaleCount > 0 ) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

}
