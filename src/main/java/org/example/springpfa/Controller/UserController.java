package org.example.springpfa.Controller;

import org.example.springpfa.Repository.UserRepository;
import org.example.springpfa.Services.PasswordEncoderService;
import org.example.springpfa.Services.UserService;
import org.example.springpfa.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService ;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    PasswordEncoderService passwordEncoder;



    @GetMapping("/users")
    public List<User> GetUsers(){
        List<User> arrayList = new ArrayList<>();
        arrayList =  userService.FindUsers();
        return  arrayList;
    }
    //Get a specific user
    @GetMapping("/users/{id}")
    public User GetUser(@PathVariable long id){
        return userService.findUser(id);
    }
    //add new User
    @PostMapping("/user/add")
    public void PostUser(@RequestBody User user){
        userService.addUser(user);
    }
    //Edit an existing user :
    @PutMapping("/user/edit/{id}")
    public void PutUser(@RequestBody User user , @PathVariable long id ){
        userService.editUser(user,id);
    }
    @DeleteMapping("/users/delete/{id}")
    public void DeleteUser(@PathVariable long id){
        userService.dropUser(id);
    }

    //authentication
    @PostMapping("/users/authenticate")
    public Map<String, String> authenticateUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        System.out.println(email);
        // Retrieve user from database
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            // Generate JWT token
            String token = passwordEncoder.generateToken(user);
            // Return the token to the client
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            System.out.println("Connected Successfully \n"+ token);
            return response;
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

}