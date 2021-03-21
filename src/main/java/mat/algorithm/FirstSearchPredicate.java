package mat.algorithm;

import java.util.List;

public class FirstSearchPredicate implements SearchPredicate {

    /**
     *  Check if passed token is the same as the first name in URI string
     */
    @Override
    public boolean isSearchedName(String tokenName, List<String> searchedNames) {
        // all elements from searched names are already lower cased by parser
        return searchedNames.get(0).equals(tokenName.toLowerCase());
    }

    /**
     *  Clear whole URI names list if first name was found
     */
    @Override
    public void removeName(List<String> names, String token) {
        names.clear();
    }

}
