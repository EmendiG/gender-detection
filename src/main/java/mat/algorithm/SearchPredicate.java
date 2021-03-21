package mat.algorithm;

import java.util.List;

public interface SearchPredicate {

    boolean isSearchedName(String tokenName, List<String> searchedNames);
    void removeName(List<String> names, String token);

}
