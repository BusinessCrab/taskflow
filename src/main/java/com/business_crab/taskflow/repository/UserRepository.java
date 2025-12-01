package com.business_crab.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business_crab.taskflow.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{   }