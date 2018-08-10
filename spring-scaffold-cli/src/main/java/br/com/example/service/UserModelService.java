package br.com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import br.com.example.model.UserModel;
import br.com.example.repository.UserModelRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserModelService {

	@Autowired
	private UserModelRepository usermodelRepository;

	public List<UserModel> findAll() {
		return usermodelRepository.findAll();
	}

	public Optional<UserModel> findById(Integer id) {
		return usermodelRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public UserModel save(UserModel entity) {
		return usermodelRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(UserModel entity) {
		usermodelRepository.delete(entity);
	}

}
	
