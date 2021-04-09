package app.service;

import app.model.Rent;
import app.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {
    @Autowired
    RentRepository rentrepository;

    @Autowired
    BookService bookservice;



    public List<Rent> getAll()
    {
        List<Rent> result=rentrepository.findAll();
        if(result.size()>0)
        {
            return result;
        }
        else
        {
            return  new ArrayList<>();
        }
    }
    public void rent(Rent rent)
    {
        int flag=1;
        //check if book id is between rented books
        for(Rent rented:rentrepository.findAll())
        {
            if (rented.equals(rent))
            {
                //it is
                flag=0;
                break;
            }
        }
        if(flag==1)
        {
            //check if book id is in  library
            if(bookservice.getBookById(rent.getItemId().toString()).size()>0)
            {
                rentrepository.save(rent);

            }
            else
            {
                System.out.println("Book not found!");
            }
        }
        else
        {
            System.out.println("Book was rented!");
        }

    }
    public void retur(Rent rent)
    {
        for(Rent rented:rentrepository.findAll())
        {
            if (rented.equals(rent))
            {
                rentrepository.delete(rent);
            }
        }
    }



}
