package validation;

import org.assertj.core.api.SoftAssertions;
import org.asynchttpclient.util.Assertions;

import java.util.Map;

public class ValidateRichText {

    public void validateFormContent(Map<String, String> formContent) {
        Assertions.assertNotNull(formContent, "Content of the form must not be null");

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(formContent.get("text")).isEqualTo("Automation Test Example");
        softAssertions.assertThat(formContent.get("boldText")).isEqualTo("Automation ");
        softAssertions.assertThat(formContent.get("underLineText")).isEqualTo("Test");
        softAssertions.assertAll();;
    }
 }
