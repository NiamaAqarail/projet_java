package https.github.com.NiamaAqarail.backend.service;

import https.github.com.NiamaAqarail.backend.dto.UserDTO;
import https.github.com.NiamaAqarail.backend.model.User;

import java.util.List;

public interface UserService{
    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateUsername(Integer id, UserDTO userDTO);

    void updateEmail(Integer id, UserDTO userDTO);

    void updatePasswd(Integer id, UserDTO userDTO);


}
