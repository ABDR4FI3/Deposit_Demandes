package org.example.springpfa.Controller;
import org.example.springpfa.Repository.DemandeRepository;
import org.example.springpfa.Repository.UserRepository;
import org.example.springpfa.Services.JWTUtils;
import org.example.springpfa.Services.UserService;
import org.example.springpfa.entities.Demande;
import org.example.springpfa.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemandeController {

    @Autowired
    DemandeRepository demandeRepository;
    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/demandes")
    public List<Demande> GetDemandes(@RequestBody String token ) {
        System.out.println(token);
        User user = userRepository.findByUsername(jwtUtils.extractUserName(token));
        // Check if token is valid for the given user
        if (!jwtUtils.isTokenValid(token, user)) {
            throw new RuntimeException("Invalid or expired token");
        }
        // Fetch and return demandes from repository
        List<Demande> demandes = demandeRepository.findAll();
        System.out.println(token + "\n" + user.getUsername());
        return demandes;
    }
    //Get a specific user
    @GetMapping("/demandes/{id}")
    public Demande GetUser(@PathVariable long id){
        return demandeRepository.findByIdDemande(id);
    }
    //add new User
    @PostMapping("/demandes/add")
    public void PostUser(@RequestBody Demande demande){
        demandeRepository.save(demande);
    }
    //Edit an existing user :
    /*@PutMapping("/user/edit/{id}")
    public void PutUser(@RequestBody User user , @PathVariable long id ){
        userService.editUser(user,id);
    }
    @DeleteMapping("/users/delete/{id}")
    public void DeleteUser(@PathVariable long id){
        userService.dropUser(id);
    }

     */

}
