package com.example.ecole.controllers;

import com.example.ecole.models.Client;
import com.example.ecole.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @GetMapping("/affichage")
            public String Affichage(){
                return "Hello!";
            }
            @PostMapping("/client/create")
    public String ajouter(@RequestBody Client client ){
        Client c=new Client();
        c.setNom(client.getNom());
        c.setPostnom(client.getPostnom());
        c.setSexe(client.getSexe());
        c.setAdresse(client.getAdresse());
        clientRepository.save(client);
        return "client create successfull";
            }
            @GetMapping("afficher/client")
    public List<Client> afficheclient(){
                List<Client> cls=clientRepository.findAll();
                return cls;
            }
//@GetMapping("/afficherone/{id}")
//    public List<Client> magic(@RequestParam(name = "id") Long id){
//        System.out.println(id);
//    List<Client> cl = clientRepository.findById(id).get();
//
//
//}
    @PutMapping("/update/client/{id}")
    public String update(@PathVariable long id,@RequestBody Client client){
        Client c=clientRepository.findById(id).get();

        c.setNom(client.getNom());
        c.setPostnom(client.getPostnom());
        c.setSexe(client.getSexe());
        c.setAdresse(client.getAdresse());
        clientRepository.save(c);
        return "update successfully";
    }
    @DeleteMapping("/delete/client/{id}")
    public  String DeleteClient(@PathVariable long id){
        Client client=clientRepository.findById(id).get();
        clientRepository.delete(client);
        return "butamu,toka";
    }


}
