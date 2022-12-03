package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialDto {
    @JsonProperty
    String username;

    @JsonProperty
    String password;
}
