package rest.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

public class UserEntityConfig extends Configuration
{
    @Getter
    @Setter
    @JsonProperty
    private String version;
}
