package com.propertysearchsystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertysearchsystem.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUserName(String userName);
  Optional<User> findByUserId(String userId);

}
