package ar.edu.unnoba.pdyc2021.mymusic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unnoba.pdyc2021.mymusic.PlaylistApplication;

@SpringBootApplication
public class PlaylistApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlaylistApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder();
}
}
