package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoDto {
    @JsonProperty
    String lat;

    @JsonProperty
    String lng;
}
