package com.ewebflux.reactive.endpoints;

import com.ewebflux.reactive.dao.User;
import com.ewebflux.reactive.implementations.UserImplentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    private UserImplentationService userImplentationService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user){
        userImplentationService.createUser(user);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<User>> getById(@PathVariable int id){
        Mono<User> user=userImplentationService.findById(id);
        HttpStatus status= user != null ? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(user,status);
    }

    @GetMapping("/status")
    public ResponseEntity<Flux<User>> getByStatus(@RequestParam boolean status){
        Flux<User> users=userImplentationService.findUsersByStatus(status);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Flux<User>> getByName(@PathVariable String name){
        Flux<User> users=userImplentationService.findUsersByName(name);
        HttpStatus status= users!= null ? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(users,status);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Flux<User>> getAll(){
        Flux<User> users=userImplentationService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> update(@RequestBody User user) {
        return userImplentationService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") int id) {
        userImplentationService.deleteById(id).subscribe();
    }

}
