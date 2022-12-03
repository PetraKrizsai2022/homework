package validation;

import org.assertj.core.api.Assertions;

public class ValidateIFrameTest {
    public void validateTitle(String title) {
        Assertions.assertThat(title).isEqualTo("Selenium Live Project: FREE Real Time Project for Practice");
    }
}
