package fi.haaga.helia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haaga.helia.domain.Book;
import fi.haaga.helia.domain.User;
import fi.haaga.helia.repository.BookRepository;
import fi.haaga.helia.repository.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, UserRepository userRepository) {
		return (args) -> {
			Book book = new Book();
			repository.save(new Book("Franz Kafka","0553213695","The Metamorphosis",1912));
			// Create users with BCrypt encoded password (user/user, admin/admin)
			userRepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			userRepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
		};
	}
}
