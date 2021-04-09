package app.service;


import app.model.ComicBook;
import app.repository.ComicBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComicBookService {
    @Autowired
    private ComicBookRepository comicrepository;

    public List<ComicBook> getAllComic()
    {
        List<ComicBook> result=comicrepository.findAll();
        if(result.size()>0)
        {
            return result;
        }
        else
        {
            return  new ArrayList<>();
        }
    }

    public List<ComicBook> getBookById(String  id)
    {
        List<ComicBook> books=comicrepository.findAll();
        List<ComicBook> booksbyid=new LinkedList<>();
        for(ComicBook book:books)
        {
            if(book.getId().toString().toLowerCase().contains(id.toLowerCase()))
            {
                booksbyid.add(book);
            }
        }
        return booksbyid;

    }
   public List<ComicBook> getComicBookBySeries(String series)
   {
       List<ComicBook> comicbooks=comicrepository.findAll();
       comicbooks=comicbooks.stream()
               .filter(item->(item.getSeries().toLowerCase().contains(series)))
               .collect(Collectors.toList());
       return comicbooks;
   }
   public List<ComicBook> getComicBookByNumber(String number)
   {
       List<ComicBook> books=comicrepository.findAll();
       List<ComicBook> booksbynumber=new LinkedList<>();
       for(ComicBook book:books)
       {
           if(book.getNumber().toString().toLowerCase().contains(number.toLowerCase()))
           {
               booksbynumber.add(book);
           }
       }
       return booksbynumber;
   }
   public ComicBook update(Integer id, String series, Integer number)
   {
       ComicBook updatecomic=comicrepository.getOne(id);
       updatecomic.setNumber(number);
       updatecomic.setSeries(series);
       updatecomic=comicrepository.save(updatecomic);
       return updatecomic;
   }
   public ComicBook add(ComicBook comic, Integer id, String series, Integer number)
   {
       comic.setId(id);
       comic.setNumber(number);
       comic.setSeries(series);
       comic=comicrepository.save(comic);
       return comic;
   }

   public void deleteall()
   {
       comicrepository.deleteAll();
   }

   public void deletebyId(Integer id)
   {
       comicrepository.deleteById(id);
   }

    public void sort()
    {
        List<ComicBook> result=comicrepository.findAll();
        Comparator<ComicBook> compareBySeries = Comparator
                .comparing(ComicBook::getSeries)
                .thenComparing(ComicBook::getNumber);
        List<ComicBook> comicbooksorted = result.stream()
                .sorted(compareBySeries)
                .collect(Collectors.toList());
        System.out.println(comicbooksorted);

    }
}
