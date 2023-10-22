package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task2 {
    private Task2() {}

    private static final Logger LOGGER = LogManager.getLogger();

    public static List<String> clusterize(String brackets) {
        if (brackets == null) {
            LOGGER.info("Brackets string is NULL");
            return new ArrayList<>();
        }
        int openBracket = 0;
        int closeBracket = 0;
        List<String> listCluster = new ArrayList<>();
        for (int i = 0, j = 0; i < brackets.length(); i++) {

            if (brackets.charAt(i) == '(') {
                openBracket++;
            } else {
                closeBracket++;
            }

            if (openBracket == closeBracket) {
                listCluster.add(brackets.substring(j, i + 1));
                j = i + 1;
            }
        }

        return listCluster;
    }
}
