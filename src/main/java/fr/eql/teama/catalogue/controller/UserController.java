package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.dto.DeleteResponse;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.service.UserService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Ajouter un user
    @PostMapping(value = "/users")
    public User addUser(@RequestBody User newUser){
        return (User) userService.addUser(newUser);
    }

/*    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }*/


    // Modifier un user
    @PutMapping(value = "/users")
    User updateUser (@RequestBody User user) throws Exception {
        User existingUser = userService.findUserById(user.getId());
        if (existingUser == null){
            throw new Exception("Cet utilisateur n'existe pas.");
        }
         userService.addUser(user);
        return user;
    }


    // Supprimer un user
    @DeleteMapping(value = "users/{id}")
    ResponseEntity<DeleteResponse> deleteUserById(@PathVariable(name="id") Integer id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<DeleteResponse>(
                    DeleteResponse.withSuccess("L'utilisateur a été supprimé avec succès."),
                    HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<DeleteResponse>(
                    DeleteResponse.withError("Erreur."),
                    HttpStatus.NOT_FOUND);
        }
    }

    // Rechercher tous les users
    @GetMapping(value = "/users")
    List<User> getListUsers(){
        List<User> allUsers = new ArrayList<>();
        allUsers = userService.getAllUsers();
        return allUsers;
    }

    //Rechercher un user by id
    @GetMapping(value = "/users/{id}")
    User getUserById (@PathVariable(name = "id") Integer id) throws Exception {
        User userToFind = userService.findUserById(id);
        if (userToFind == null){
            throw new Exception("Cet utilisateur n'existe plus/pas.");
        }
        return userToFind;
    }

/*
    //Rechercher users by city
    @GetMapping(value = "/users/{city}")
    List<User> getUsersByCity(@PathVariable(name= "city") String city){
        List<User> users = new ArrayList<>();
        users = userService.findByCity(city);
        return users;
    }

    //Rechercher users by zip code
    @GetMapping(value = "/users/{postCode}")
    List<User> getUsersByZipCode(@PathVariable(name= "postCode") String postCode){
        List<User> users = new ArrayList<>();
        users = userService.findByPostCode(postCode);
        return users;
    }*/
}
