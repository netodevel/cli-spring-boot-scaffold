package br.com.example.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.example.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Integer> {
	
}