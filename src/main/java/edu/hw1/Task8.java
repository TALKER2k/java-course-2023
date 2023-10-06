package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task8 {
    private Task8() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("checkstyle:MagicNumber")
    public static boolean knightBoardCapture(int[][] board) {
        try {
            if (board == null) {
                throw new NullPointerException("Board is NULL!");
            }
        } catch (NullPointerException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
        int[] firstStep = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] secondStep = {1, -1, 1, -1, 2, -2, 2, -2};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        if (i + firstStep[k] < board.length && j + secondStep[k] < board.length
                                && i + firstStep[k] >= 0 && j + secondStep[k] >= 0
                                && board[i + firstStep[k]][j + secondStep[k]] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
