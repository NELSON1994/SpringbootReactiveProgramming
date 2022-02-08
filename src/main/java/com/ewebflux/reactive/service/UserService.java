package com.ewebflux.reactive.service;

import com.ewebflux.reactive.dao.User;
import com.ewebflux.reactive.implementations.UserImplentationService;
import com.ewebflux.reactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserImplentationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user){
        userRepository.save(user).subscribe();
    }

    @Override
     public Mono<User> findById(int id){
        Mono<User> user=userRepository.findById(id);
        return user;
     }

     @Override
     public Flux<User> findUsersByName(String name){
        Flux<User> users=userRepository.findByName(name);
       // users.subscribe();
        return users;
     }

    @Override
    public Flux<User> findUsersByStatus(boolean status){
        Flux<User> users=userRepository.findByStatus(status);
        // users.subscribe();
        return users;
    }

    @Override
    public Flux<User> findAllUsers(){
        Flux<User> users=userRepository.findAll();
        return users;
    }

    @Override
    public Mono<User> updateUser(User user){
        Mono<User> user1=userRepository.save(user);
        return user1;
    }

    @Override
    public Mono<Void> deleteById(int id){
        Mono<Void> user=userRepository.deleteById(id);
        return user;
    }

}
