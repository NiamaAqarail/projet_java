package https.github.com.NiamaAqarail.backend.controller;


import https.github.com.NiamaAqarail.backend.dto.UserDTO;
import https.github.com.NiamaAqarail.backend.model.User;
import https.github.com.NiamaAqarail.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        try {
            userservice.addUser(user);
            return "User added successfully";
        } catch (Exception e) {
            return "Exception detected: " + e.getMessage();
        }

    }
    @GetMapping("/all")
    public List<User> getUsers(){
        return userservice.getUsers();
    }
    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userservice.getUser(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateuser(@PathVariable Integer id, @RequestBody User user){
        userservice.updateUser(id,user);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userservice.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-username/{id}")
    public ResponseEntity<Void> updateUsername(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userservice.updateUsername(id, userDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-email/{id}")
    public ResponseEntity<Void> updateEmail(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userservice.updateEmail(id, userDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-pwd/{id}")
    public ResponseEntity<Void> updatePasswd(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userservice.updatePasswd(id, userDTO);
        return ResponseEntity.noContent().build();
    }
}
