package app.service;


import app.model.Book;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookrepository;

    public List<Book> getAllBook()
    {
        List<Book> result=bookrepository.findAll();
        if(result.size()>0)
        {
            return result;
        }
        else
        {
            return  new ArrayList<>();
        }
    }
    public List<Book> getBookById(String  id)
    {
        List<Book> books=bookrepository.findAll();
        List<Book> booksbyid=new LinkedList<>();
        for(Book book:books)
        {
            if(book.getId().toString().toLowerCase().contains(id.toLowerCase()))
            {
                booksbyid.add(book);
            }
        }
       return booksbyid;

    }
    public List<Book> getBookbyAuthor(String author)
    {
        List<Book> booksbyauthor=bookrepository.findAll();
        booksbyauthor=booksbyauthor.stream()
                .filter(item->(item.getAuthor().toLowerCase().contains(author)))
                .collect(Collectors.toList());
        if(booksbyauthor.size()>0)
        {
            return booksbyauthor;
        }
        else
        {
            return new ArrayList<>();
        }
    }
    public List<Book> getBookbyTitle(String title)
    {
        List<Book> books=bookrepository.findAll();
        List<Book> booksbyname=new LinkedList<>();
        for(Book book: books)
        {
            if(book.getTitle().toLowerCase().contains(title))
            {
                booksbyname.add(book);
            }
        }
       return booksbyname;
    }
    public Book update(Integer id, String title, String author)
    {
        Book updatebook=bookrepository.getOne(id);
        updatebook.setAuthor(author);
        updatebook.setTitle(title);
        updatebook=bookrepository.save(updatebook);
        return updatebook;
    }
    public Book add(Book book, Integer id,  String title, String author)
    {
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book=bookrepository.save(book);
        return book;
    }
    public void deletebyid(Integer id)
    {
        bookrepository.deleteById(id);
    }

    public void deleteall()
    {
        bookrepository.deleteAll();
    }
    public void  sortbookbytitle()
    {
        List<Book> result=bookrepository.findAll();
        Comparator<Book> compareByTitle = Comparator
                .comparing(Book::getTitle);
        List<Book> booksorted = result.stream()
                .sorted(compareByTitle)
                .collect(Collectors.toList());
        System.out.println(booksorted);

    }
    public void  sortbookbyauthor()
    {
        List<Book> result=bookrepository.findAll();
        Comparator<Book> compareByAuthor = Comparator
                .comparing(Book::getAuthor);
        List<Book> booksorted = result.stream()
                .sorted(compareByAuthor)
                .collect(Collectors.toList());
        System.out.println(booksorted);

    }

}

