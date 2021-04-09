package app.controller;

import app.model.ComicBook;
import app.service.ComicBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ComicBookControler {
    @Autowired
    ComicBookService comicservice;

    @RequestMapping(path="comicbooks",method= RequestMethod.GET)
    public ResponseEntity<List<ComicBook>> listComics()
    {
        List<ComicBook> result=comicservice.getAllComic();
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(path="comicbooks" ,method=RequestMethod.POST)
    public  ResponseEntity<ComicBook>  addBook(@RequestBody ComicBook book)
    {
        ComicBook bookadd=comicservice.add(book,book.getId(), book.getSeries(), book.getNumber());
        return new ResponseEntity<>(bookadd, new HttpHeaders(), HttpStatus.CREATED);

    }

    @RequestMapping(path="comicbooks/{id}", method=RequestMethod.PUT)
    public ResponseEntity<ComicBook> update(@PathVariable String id, @RequestBody ComicBook book)
    {
        ComicBook updatebook=comicservice.update(Integer.parseInt(id), book.getSeries(), book.getNumber() );
        return new ResponseEntity<>(updatebook, new HttpHeaders(), HttpStatus.OK);

    }
    @RequestMapping(path="comicbooks/id/{id}", method=RequestMethod.GET)
    public ResponseEntity<List<ComicBook>> searchBookbyId(@PathVariable String id)
    {
        List<ComicBook> bookbyid=comicservice.getBookById(id);
        return new ResponseEntity<>(bookbyid, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path="comicbooks/series/{series}", method=RequestMethod.GET)
    public ResponseEntity<List<ComicBook>> searchBookbySeries(@PathVariable String series)
    {
        List<ComicBook> bookbyseries=comicservice.getComicBookBySeries(series);
        return new ResponseEntity<>(bookbyseries, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path="comicbooks/number/{number}", method=RequestMethod.GET)
    public ResponseEntity<List<ComicBook>> searchBookbyAuthor(@PathVariable String number)
    {
        List<ComicBook> bookbynumber=comicservice.getComicBookByNumber(number);
        return new ResponseEntity<>(bookbynumber, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path="comicbooks{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id)
    {
        comicservice.deletebyId(Integer.parseInt(id));

    }

    @RequestMapping(path = "comicbooksdelete", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteall()
    {
        comicservice.deleteall();
    }

    @RequestMapping(path="comicsort", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void sort()
    {
        comicservice.sort();
    }
}
