package ar.edu.unnoba.pdyc2021.mymusic.service;

import java.util.List;

import ar.edu.unnoba.pdyc2021.mymusic.model.User;

public interface UserService {
	public List<User> getUsers();
	public User addUser(User user);
	public User findUser(Long id);
	public void deleteUser(Long id);
	public User updateUser(User user, Long id);  

}
