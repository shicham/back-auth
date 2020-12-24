package com.crm.repository;

import com.crm.domain.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Long> {

    @Query("SELECT u FROM UserTokenEntity u WHERE LOWER(u.username) = LOWER(:username)")
    UserTokenEntity findByUsername(@Param("username") String username);

    UserTokenEntity findByToken(String token);

}
