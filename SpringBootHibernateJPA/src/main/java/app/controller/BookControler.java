package app.controller;

import app.model.Book;
import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookControler {
    @Autowired
    private BookService bookservice;

    @RequestMapping(path="books", method= RequestMethod.GET)
    public ResponseEntity<List<Book>> listBooks()
    {
        List<Book> result=bookservice.getAllBook();
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(path="books" ,method=RequestMethod.POST)
    public  ResponseEntity<Book>  addBook(@RequestBody Book book)
    {
        Book bookadd=bookservice.add(book,book.getId(), book.getTitle(), book.getAuthor());
        return new ResponseEntity<>(bookadd, new HttpHeaders(), HttpStatus.CREATED);

    }

    @RequestMapping(path="books/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable String id, @RequestBody Book book)
    {
        Book updatebook=bookservice.update(Integer.parseInt(id), book.getTitle(), book.getAuthor() );
        return new ResponseEntity<>(updatebook, new HttpHeaders(), HttpStatus.OK);

    }
    @RequestMapping(path="books/id/{id}", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> searchBookbyId(@PathVariable String id)
    {
        List<Book> bookbyid=bookservice.getBookById(id);
        return new ResponseEntity<>(bookbyid, new HttpHeaders(), HttpStatus.OK);
    }
   @RequestMapping(path="books/title/{title}", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> searchBookbyTitle(@PathVariable String title)
    {
        List<Book> bookbytitle=bookservice.getBookbyTitle(title);
        return new ResponseEntity<>(bookbytitle, new HttpHeaders(), HttpStatus.OK);
    }
   @RequestMapping(path="books/author/{author}", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> searchBookbyAuthor(@PathVariable String author)
    {
        List<Book> bookbyauthor=bookservice.getBookbyAuthor(author);
        return new ResponseEntity<>(bookbyauthor, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path="books{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id)
    {
        bookservice.deletebyid(Integer.parseInt(id));

    }

    @RequestMapping(path = "booksdelete", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteall()
    {
        bookservice.deleteall();
    }

    @RequestMapping(path="booksortbytitle", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void sorttitle()
    {
        bookservice.sortbookbytitle();
    }

    @RequestMapping(path="booksortbyauthor", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void sortuthor()
    {
        bookservice.sortbookbyauthor();
    }
}
