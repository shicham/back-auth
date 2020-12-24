package com.crm.repository;

import com.crm.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) = LOWER(:username)")
    UserEntity findByUsernameCaseInsensitive(@Param("username") String username);

    @Query
    UserEntity findByEmail(String email);

}
