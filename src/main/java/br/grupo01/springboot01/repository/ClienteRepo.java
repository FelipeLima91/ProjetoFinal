package br.grupo01.springboot01.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.grupo01.springboot01.model.Cliente;

@Repository
public interface ClienteRepo extends CrudRepository<Cliente,Integer>{

    
}
