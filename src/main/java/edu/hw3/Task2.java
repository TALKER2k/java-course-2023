package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {}

    private  static  final Logger LOGGER = LogManager.getLogger();

    public static List<String> clusterize(String brackets) {
        int openBracket = 0, closeBracket = 0, i = 0;
        StringBuilder bracketsCopy = new StringBuilder(brackets);
        List<String> listCluster = new ArrayList<>();
        while (i < bracketsCopy.length()) {
            if (bracketsCopy.charAt(i) == '(') {
                openBracket++;
            } else {
                closeBracket++;
            }

            if (openBracket == closeBracket) {
                listCluster.add(bracketsCopy.substring(0, i + 1));
                bracketsCopy.delete(0, i);
                i = -1;
            }

            i++;
        }

        return listCluster;
    }
}
