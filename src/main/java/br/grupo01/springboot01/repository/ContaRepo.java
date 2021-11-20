package br.grupo01.springboot01.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.grupo01.springboot01.model.Conta;

@Repository
public interface ContaRepo extends CrudRepository<Conta,Integer>{ 
 

}
