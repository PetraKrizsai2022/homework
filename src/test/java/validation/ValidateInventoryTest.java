package validation;

import org.assertj.core.api.Assertions;

public class ValidateInventoryTest {
    public void validateCartBadge(String cartBadge) {
        Assertions.assertThat(cartBadge).isEqualTo("2");
    }

    public void validateCompleteHeader(String header) {
        Assertions.assertThat(header).isEqualTo("THANK YOU FOR YOUR ORDER");
    }

    public void validateErrorMessage(String errorText) {
        Assertions.assertThat(errorText).isEqualTo("Epic sadface: Username is required");
    }

    public void validateFooter(String footerText) {
        Assertions.assertThat(footerText).contains("2022");
        Assertions.assertThat(footerText).contains("Terms of Service");
    }
}
