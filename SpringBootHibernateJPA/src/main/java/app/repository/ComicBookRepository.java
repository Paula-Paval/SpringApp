package app.repository;


import app.model.ComicBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicBookRepository  extends JpaRepository<ComicBook, Integer> {
}
