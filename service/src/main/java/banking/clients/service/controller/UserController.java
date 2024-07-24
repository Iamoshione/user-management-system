package banking.clients.service.controller;


import banking.clients.service.model.User;
import banking.clients.service.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping()
    public List<User> getUser() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/create")
    public HttpEntity<String> create(@RequestBody User user){
        userService.createUser(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>("User Created",httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}/delete")
    public HttpEntity<String> deleteAccount(@PathVariable Integer id){
        userService.deleteUser(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>("Successfully deleted",httpHeaders,HttpStatus.OK);
    }

    @PutMapping(value="{id}/update")
    public HttpEntity<String> updateUser(@RequestBody User user , @PathVariable Integer id){
        userService.updateUser(user,id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>("Successfully Updated",httpHeaders,HttpStatus.OK);
    }



}