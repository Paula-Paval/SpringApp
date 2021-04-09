package app.controller;

import app.model.Client;
import app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class ClientControler {
    @Autowired
    ClientService clientservice;

    @RequestMapping(path="clients", method = RequestMethod.GET)
    public ResponseEntity<List<Client>>listClients()
    {
        List<Client> clients=clientservice.getAll();
        return new ResponseEntity<>(clients, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path="clients/id{id}", method=RequestMethod.GET)
    public ResponseEntity<List<Client>> searchClientsById(@PathVariable String id)
    {
        List<Client> clients=clientservice.getById(id);
        return new ResponseEntity<>(clients, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path="clients/name{name}", method=RequestMethod.GET)
    public ResponseEntity<List<Client>> searchClientsByName(@PathVariable String name)
    {
        List<Client> clients=clientservice.getByName(name);
        return new ResponseEntity<>(clients, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path="clients", method=RequestMethod.POST)
    public ResponseEntity<Client> add(@RequestBody Client client)
    {
        Client clientadd=clientservice.add(client, client.getId(), client.getName());
        return new ResponseEntity<>(clientadd, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path="clients/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> update(@PathVariable String id, @RequestBody Client client)
    {
        Client clientupdate=clientservice.update(Integer.parseInt(id), client.getName());
        return new ResponseEntity<>(clientupdate, new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(path="clients/{id}", method=RequestMethod.DELETE)
    public void deletebyId(@PathVariable String id)
    {
        clientservice.deletebyId(Integer.parseInt(id));
    }

    @RequestMapping(path="clients", method = RequestMethod.DELETE)
    public void delete()
    {
        clientservice.delete();
    }

    @RequestMapping(path="clientsort", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void sort()
    {
        clientservice.sortclients();

    }

}
