package com.ewebflux.reactive.implementations;

import com.ewebflux.reactive.dao.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserImplentationService {

    void createUser(User user);

    Mono<User> findById(int id);

    Flux<User> findUsersByName(String name);

    Flux<User> findUsersByStatus(boolean status);

    Flux<User> findAllUsers();

    Mono<User> updateUser(User user);

    Mono<Void> deleteById(int id);
}
