package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.dto.AuthenticateRequestDto;
import fr.eql.teama.catalogue.dto.DeleteResponse;
import fr.eql.teama.catalogue.dto.FullUserDto;
import fr.eql.teama.catalogue.entities.Credentials;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.exception.AlreadyExistException;
import fr.eql.teama.catalogue.exception.RestException;
import fr.eql.teama.catalogue.service.CredentialsService;
import fr.eql.teama.catalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CredentialsService credentialsService;

    // Ajouter un user
    @PostMapping(value = "/users")
    public FullUserDto addUser(@RequestBody FullUserDto newUser){
        User existing = userService.findUserByLogin(newUser.getLogin());

        if (existing != null) {
            throw new AlreadyExistException("Un utilisateur existe déjà avec l'identifiant " + newUser.getLogin() + ".");
        }

        return FullUserDto.from(userService.addUser(newUser.toUser()));
    }


    @PostMapping("/authenticate")
    FullUserDto authenticate(@RequestBody AuthenticateRequestDto requestDto) {
        User userWithLogin = userService.findUserByLogin(requestDto.getLogin());

        if (userWithLogin == null) {
            throw new RestException("Il n'y a pas d'utilisateur avec l'identifiant " + requestDto.getLogin() + ".");
        }

        if (! credentialsService.hash(requestDto.getPassword()).equals(userWithLogin.getCredentials().getHashedPassword())) {
            throw new RestException("Erreur de mot de passe.");
        }

        return FullUserDto.from(userWithLogin);
    }

/*    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }*/


    // Modifier un user
    @PutMapping(value = "/users")
    FullUserDto updateUser (@RequestBody FullUserDto dto) throws Exception {
        User existingUser = userService.findUserById(dto.getId());

        if (existingUser == null) {
            throw new Exception("Cet utilisateur n'existe pas.");
        }

        // Keep the credentials because we don't want to overwrite them
        Credentials previousCredentials = existingUser.getCredentials();
        User updatedUser = dto.toUser();
        updatedUser.setCredentials(previousCredentials);

        // Do update the user
        updatedUser = userService.updateUser(updatedUser);

        // Return it as a DTO
        return FullUserDto.from(updatedUser);
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
