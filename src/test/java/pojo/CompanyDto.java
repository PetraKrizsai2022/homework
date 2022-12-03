package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {
    @JsonProperty
    String name;

    @JsonProperty
    String catchPhrase;

    @JsonProperty
    String bs;
}
