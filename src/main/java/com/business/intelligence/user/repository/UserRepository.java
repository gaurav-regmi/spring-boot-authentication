package com.business.intelligence.user.repository;

import com.business.intelligence.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select t from UserEntity t where t.username = :username and t.active = 'Y'")
    Optional<UserEntity> findByUsername(String username);
}
