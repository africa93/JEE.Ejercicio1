package persistence.daos.library;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistence.entities.UnRelatedEntity;
import persistence.entities.library.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	
}
