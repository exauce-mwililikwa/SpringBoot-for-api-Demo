package com.example.ecole.repository;


import com.example.ecole.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
public List<Client> findByid(long id);
}
