package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void successfulResultTest() {
        var two = new Task1.Expr.Constant(2);
        var four = new Task1.Expr.Constant(4);
        var negOne = new Task1.Expr.Negate(new Task1.Expr.Constant(1));
        var sumTwoFour = new Task1.Expr.Addition(two, four);
        var multi = new Task1.Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Task1.Expr.Exponent(multi, 2);
        var res = new Task1.Expr.Addition(exp, new Task1.Expr.Constant(1));

        assertThat(res.evaluate()).isEqualTo(37.0);
        LOGGER.info(res);
        LOGGER.info(" = " + res.evaluate());
    }
}
