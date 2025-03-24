package com.example.semiprojectv1.repository;

import com.example.semiprojectv1.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserid(String userid);

    boolean existsByEmail(String email);

    Optional<User>  findByUserid(String userid);
}
