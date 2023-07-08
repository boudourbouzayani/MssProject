package tn.mss.mssIntern.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import tn.mss.mssIntern.modele.User;
import tn.mss.mssIntern.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Component
@ComponentScan
public  class UserService {
    @Autowired(required = true)
    public UserRepository userRepository;
    public User addUser(User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            list.add(user);
        }
        return list;
    }

    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur introuvable"));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepository.save(existingUser);
    }


    public User findUsernameByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public User findUserById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }



}



