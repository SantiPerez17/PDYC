package ar.edu.unnoba.pdyc2021.mymusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unnoba.pdyc2021.mymusic.model.User;
import ar.edu.unnoba.pdyc2021.mymusic.repository.UserRepository;
@Service
public class UserServiceImp implements UserService {

	 @Autowired
	 private UserRepository userRepository;

	 @Override
	 public List<User> getUsers() {
		 return userRepository.findAll();
	    }

	@Override
	public User addUser(User user) {
		//encriptar user.getPassword();
		return userRepository.save(user);
	}

	@Override
	public User findUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		//tiene que ser el id del userlogueado, hay que mandar una validacion con un token que se fije si es el usuario o bien generar roles, y si es admin que lo borre.
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user, Long id) {
		//aca tiene que pasar lo mismo que arriba, pero para la primer entrega va bien
		User u = userRepository.findById(id).get();
        if (user.getEmail()!=null) {u.setEmail(user.getEmail());}
        //llamar funcion que encripta pass (en caso de que se modifique la pass)
        if (user.getPassword()!=null) {u.setPassword(user.getPassword());}
        return userRepository.save(u);
	}

}
