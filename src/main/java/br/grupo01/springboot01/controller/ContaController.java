package br.grupo01.springboot01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.springboot01.model.Conta;
import br.grupo01.springboot01.repository.ContaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepo repo;

    @GetMapping
    public List<Conta> listarTodos() {
        List<Conta> lista = (List<Conta>) repo.findAll(); // casting

        return lista;
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Conta> buscarCliente(@PathVariable int codigo) {
        // busca um cliente com este codigo, e se não encontrar, preenche com null
        Conta conta = repo.findById(codigo).orElse(null);

        if(conta != null) { // achou o cliente
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.notFound().build(); // notFound = status 404, sem conteudo
    }
}
