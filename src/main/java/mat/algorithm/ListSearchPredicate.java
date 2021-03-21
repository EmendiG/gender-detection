package mat.algorithm;

import java.util.List;

public class ListSearchPredicate implements SearchPredicate {

    /**
     *  Check if passed token might be found within passed list of names from URI
     */
    @Override
    public boolean isSearchedName(String tokenName, List<String> searchedNames) {
        // searched names are already lower cased by parser
        // check if read token from the file might be found within list of passed names
        for (String name : searchedNames) {
            if (name.toLowerCase().equals(tokenName) ) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Remove name from URI names list when one is found
     */
    @Override
    public void removeName(List<String> names, String name) {
        names.remove(name);
    }

}
