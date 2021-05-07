package ar.edu.unnoba.pdyc2021.mymusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unnoba.pdyc2021.mymusic.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{
}

