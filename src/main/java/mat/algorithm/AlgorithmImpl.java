package mat.algorithm;

import mat.Gender;
import mat.parser.FileParser;
import mat.parser.FileParserImpl;
import mat.parser.StringParser;

import java.util.List;

public class AlgorithmImpl implements Algorithm {

    /**
     *  Find gender based on picked algorithm and string full name
     */
    @Override
    public Gender findGender(String paramName, String paramAlgorithm) {

        // parse names from URI string
        List<String> searchedNames = StringParser.parseName(paramName);
        int initialSize = searchedNames.size();
        // initialize chosen algorithm based on passed URI parameter
        SearchPredicate searchPredicate = initChosenAlgorithm(paramAlgorithm);
        long femaleCount = howManyNamesFoundByGender(Gender.FEMALE, searchedNames, searchPredicate);
        long maleCount = 0L;

        // check if there is a need to check men names or female names are more than 50% of all passed names already
        if ( ( (double) initialSize - femaleCount) / initialSize >= 1.0 / 2.0 ) {
            maleCount = howManyNamesFoundByGender(Gender.MALE, searchedNames, searchPredicate);
        }

        if (femaleCount > maleCount) {
            return Gender.FEMALE;
        } else if (femaleCount < maleCount) {
            return Gender.MALE;
        } else {
            return Gender.INCONCLUSIVE;
        }
    }

    /**
     *  Find how many tokens from specific Flat File may be
     *  found within passed list of names
     */
    private long howManyNamesFoundByGender(
            Gender pickedGender,
            List<String> searchedNames,
            SearchPredicate searchPredicate) {

        FileParser fileParser = new FileParserImpl(pickedGender);
        long sum = 0;
        sum = fileParser.getFileStream()
            .map(String::toLowerCase)
            .takeWhile(s ->  (searchedNames.size() > 0) )
            .filter(token -> {
                boolean nameFound = searchPredicate.isSearchedName(token, searchedNames);
                if (nameFound) {
                    searchPredicate.removeName(searchedNames, token);
                }
                return nameFound;
            })
            .count();
        return sum;
    }

    /**
     *  Check which predicate should be instantiated based on algorithm string that was passed in URI
     */
    private SearchPredicate initChosenAlgorithm(String pickedAlgorithm) {
        switch (pickedAlgorithm) {
            case "list":
                return new ListSearchPredicate();
            case "first":
                return new FirstSearchPredicate();
            default:
                return new ListSearchPredicate();
        }
    }

}
