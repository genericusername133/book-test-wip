package fi.haaga.helia.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fi.haaga.helia.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByAuthor(String author);

}