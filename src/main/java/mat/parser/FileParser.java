package mat.parser;

import mat.Gender;

import java.util.List;

public interface FileParser {

    long howManyNamesFoundByGender(Gender pickedGender, List<String> searchedNames);
}
