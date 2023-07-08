package tn.mss.mssIntern.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.mss.mssIntern.modele.User;
import tn.mss.mssIntern.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
        @Autowired
    UserService userService;
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers (){
        List<User> tutorials = userService.findAllUsers();
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getAllUsers (@PathVariable("id")Long id ){
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        User user = userService.findUsernameByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
    @PostMapping("/add")
    public <user> ResponseEntity<User> addUser(@RequestBody User user){
        System.out.println("user is"+user);
        User newuser = userService.addUser(user);
        return new ResponseEntity<>(newuser,HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserRepo(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}