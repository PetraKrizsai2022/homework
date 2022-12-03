package validation;

import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class ValidateApiTest {
    private final SoftAssertions softAssertions = new SoftAssertions();

    public void validateEmailList(List<String> emailList) {
        for (String email : emailList) {
            softAssertions.assertThat(email).contains("@");
        }
        softAssertions.assertAll();
    }
}
