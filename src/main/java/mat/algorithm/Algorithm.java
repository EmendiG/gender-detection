package mat.algorithm;

import mat.Gender;

import java.util.List;

public interface Algorithm {

    long howManyNamesFoundByGender(
            Gender pickedGender,
            List<String> searchedNames,
            SearchPredicate searchPredicate);
    Gender findGender(String paramName, String paramAlgorithm);

}
