package group.demo.model;

import group.demo.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userCrisalis")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "rol")
    private UserRol rol;

    public User(UserDTO userDTO){
        this.name = userDTO.getName();
        this.username =  userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.rol = userDTO.getUserRol();
    }

    public UserDTO toDTO(){
        return
                UserDTO
                        .builder()
                        .name(this.name)
                        .username(this.username)
                        .password(this.password)
                        .build();
    }
}
