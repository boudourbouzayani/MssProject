package tn.mss.mssIntern.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.mss.mssIntern.modele.ResponseMessage;
import tn.mss.mssIntern.modele.User;
import tn.mss.mssIntern.service.UserService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/users")
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


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (userService.authenticate(username, password)) {
            return new ResponseEntity<>(new ResponseMessage("it s ok"),HttpStatus.OK);
        }

        return   ResponseEntity.badRequest().body(new ResponseMessage("it s not ok"));
    }

    @PostMapping("/cc")
    public ResponseEntity<?> cc(@RequestParam("cc") boolean cc) {


        if (cc==true) {
            return new ResponseEntity<>(cc,HttpStatus.CREATED);
        }

        return ResponseEntity.ok().body(new ResponseMessage("Login Unsuccessful!"));
    }
}