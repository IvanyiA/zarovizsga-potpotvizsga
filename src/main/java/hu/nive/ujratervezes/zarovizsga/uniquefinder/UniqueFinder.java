package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UniqueFinder {

    public List<Character> uniqueChars(String input) {
        parameterCheck(input);
        List<Character> result = new ArrayList<>();
        for (Character c : input.toCharArray()) {
            if (!result.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Character> uniqueChars2 (String input) {
        parameterCheck(input);
        Set<Character> result = new LinkedHashSet<>();

        for (Character c : input.toCharArray()) {
            {
                result.add(c);
            }
        }
        return new ArrayList<>(result);
    }

    private void parameterCheck(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
    }

}
