package group.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import group.demo.model.UserRol;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rol")
    private UserRol userRol;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
