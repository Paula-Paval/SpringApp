package app.controller;


import app.model.Rent;
import app.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RentControler {
    @Autowired
    RentService rentservice;

    @RequestMapping(path="rented", method= RequestMethod.GET )
    public ResponseEntity<List<Rent>>  getAll()
    {
        List<Rent> result=rentservice.getAll();
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path="rented", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void rent(@RequestBody Rent rent)
    {
        rentservice.rent(rent);
    }
    @RequestMapping(path="rented", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void retur(@RequestBody Rent rent)
    {
        rentservice.retur(rent);
    }



}
