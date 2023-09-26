package group.demo.service;

import group.demo.exception.custom.EmptyElementException;
import group.demo.exception.custom.NotCreatedException;
import group.demo.exception.custom.UnauthorizedException;
import group.demo.model.User;
import group.demo.model.dto.UserDTO;
import group.demo.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDTO){
        if(checkUserDTO(userDTO, Boolean.FALSE)){
            return this.userRepository.save(new User(userDTO));
        }
        throw new NotCreatedException("Error in save new User");

    }

    public UserDTO loginUserWithCredentials(String username, String password){
        if (
                this.checkUserDTO(UserDTO
                                .builder()
                                .username(username)
                                .password(password)
                                .build()
                        , Boolean.TRUE)
        ){
            return this.userRepository.findByUsernameAndPassword(username, password)
                    .orElseThrow(
                            () -> new UnauthorizedException("Invalid credentials")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }

    public List<UserDTO> getListAllUsersInDB(){
        return this.userRepository.findAll().stream().map(User::toDTO).collect(Collectors.toList());
    }

    private Boolean checkUserDTO(UserDTO userDTO, Boolean isForLogin){
        if(!isForLogin){
            if(StringUtils.isEmpty(userDTO.getName())){
                throw new EmptyElementException("Name is empty");
            }
            if (userDTO.getUserRol() == null) {
                throw new EmptyElementException("Rol is empty");
            }
        }
        if(StringUtils.isEmpty(userDTO.getUsername())){
            throw new EmptyElementException("Username is empty");
        }
        if(StringUtils.isEmpty(userDTO.getPassword())){
            throw new EmptyElementException("Password is empty");
        }
        return Boolean.TRUE;
    }
}
