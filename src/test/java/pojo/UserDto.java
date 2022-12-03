package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @JsonProperty
    String id;

    @JsonProperty
    String name;

    @JsonProperty
    String username;

    @JsonProperty
    String email;

    @JsonProperty
    AddressDto address;

    @JsonProperty
    String phone;

    @JsonProperty
    String website;

    @JsonProperty
    CompanyDto company;
}
