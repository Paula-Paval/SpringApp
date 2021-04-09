package app.service;

import app.model.Client;
import app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientrepository;

    public List<Client> getAll()
    {
        List<Client> result=clientrepository.findAll();
        if(result.size()>0)
        {
            return result;
        }
        else
        {
            return new ArrayList<>();
        }
    }

    public List<Client> getById(String id)
    {
        List<Client> clients=clientrepository.findAll();
        List<Client>  clientsid=new LinkedList<>();
        for( Client client: clients)
        {
            if(client.getId().toString().toLowerCase().contains(id.toLowerCase()))
                     clientsid.add(client);
        }
        return clientsid;
    }

    public List<Client> getByName(String name)
    {
        List<Client> clients=clientrepository.findAll();
        List<Client>  clientsname=new LinkedList<>();
        for( Client client: clients)
        {
            if(client.getName().toLowerCase().contains(name))
                clientsname.add(client);
        }
        return clientsname;

    }
    public Client update(Integer id, String name)
    {
        Client client=clientrepository.getOne(id);
        client.setName(name);
        client=clientrepository.save(client);
        return client;
    }

    public Client add(Client client, Integer id, String name)
    {
        client.setId(id);
        client.setName(name);
        client=clientrepository.save(client);
        return client;
    }

    public void deletebyId(Integer id)
    {
        clientrepository.deleteById(id);
    }

    public void delete()
    {
        clientrepository.deleteAll();
    }

    public void sortclients()
    {
      List<Client> result=clientrepository.findAll();
      result.sort(Client::compareTo);
      System.out.println(result);
    }

}
