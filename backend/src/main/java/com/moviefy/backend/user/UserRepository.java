package com.moviefy.backend.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.passwors = :passwords AND u.email = :email")
    Optional<User> findUserByEmailAndPassword(@Param("passwords") String passwords, @Param("email") String email);
}
