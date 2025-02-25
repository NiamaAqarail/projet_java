package https.github.com.NiamaAqarail.backend.service.impl;

import https.github.com.NiamaAqarail.backend.dto.UserDTO;
import https.github.com.NiamaAqarail.backend.model.User;
import https.github.com.NiamaAqarail.backend.repository.UserRepository;
import https.github.com.NiamaAqarail.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        userRepository.delete(user);
    }

    @Override
    public void updateUsername(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        user.setUsername(userDTO.getUsername());
        userRepository.save(user);
    }

    @Override
    public void updateEmail(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
    }

    @Override
    public void updatePasswd(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }
}
