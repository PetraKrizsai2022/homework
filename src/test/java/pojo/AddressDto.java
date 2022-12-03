package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    @JsonProperty
    String street;

    @JsonProperty
    String suite;

    @JsonProperty
    String city;

    @JsonProperty
    String zipcode;

    @JsonProperty
    GeoDto geo;
}
