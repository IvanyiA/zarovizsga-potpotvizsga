package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

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

    private void parameterCheck(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
    }

}
