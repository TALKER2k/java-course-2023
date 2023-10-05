package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void timeOfFilmTest() {
        // given
        String time1 = "01:00";
        String time2 = "13:56";
        String time3 = "999:59";

        // when
        int resultTime1 = Task1.minutesToSeconds(time1);
        int resultTime2 = Task1.minutesToSeconds(time2);
        int resultTime3 = Task1.minutesToSeconds(time3);

        // then
        assertThat(resultTime1).isEqualTo(60);
        assertThat(resultTime2).isEqualTo(13 * 60 + 56);
        assertThat(resultTime3).isEqualTo(999 * 60 + 59);
    }

    @Test
    void notCorrectTimeOfFilmTest() {
        // given
        String time1 = "-01:00";
        String time2 = "01:60";
        String time3 = "-11:60";

        // when
        int resultTime1 = Task1.minutesToSeconds(time1);
        int resultTime2 = Task1.minutesToSeconds(time2);
        int resultTime3 = Task1.minutesToSeconds(time3);

        // then
        assertThat(resultTime1).isEqualTo(-1);
        assertThat(resultTime2).isEqualTo(-1);
        assertThat(resultTime3).isEqualTo(-1);
    }
}
