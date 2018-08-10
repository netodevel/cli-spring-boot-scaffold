package com.example.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}