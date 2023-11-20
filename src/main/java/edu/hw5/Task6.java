package edu.hw5;

public class Task6 {

    public boolean containsSubsequence(String superString, String subString) {
        return superString.contains(subString);
    }

    public boolean contains(String superString, String subSequence) {
        String regex = ".*" + String.join(".*", subSequence.split("")) + ".*";
        return superString.matches(regex);
    }
}
