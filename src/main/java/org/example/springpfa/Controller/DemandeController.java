package org.example.springpfa.Controller;
import org.example.springpfa.Repository.DemandeRepository;
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

    @GetMapping("/demandes")
    public List<Demande> GetUsers(){
        List<Demande> arrayList = new ArrayList<>();
        arrayList =  demandeRepository.findAll();
        return  arrayList;
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
