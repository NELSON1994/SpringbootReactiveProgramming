package com.ewebflux.reactive.repository;

import com.ewebflux.reactive.dao.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveMongoRepository<User,Integer> {
    @Query("{ 'name': ?0 }")
    Flux<User> findByName(final String name);

    @Query("{ 'status': ?0 }")
    Flux<User> findByStatus(final boolean status);
}
