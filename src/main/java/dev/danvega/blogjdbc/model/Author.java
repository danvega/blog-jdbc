package dev.danvega.blogjdbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public record Author(
        @Id @JsonIgnore Integer post,
        String firstName,
        String lastName,
        String email
) {
}
