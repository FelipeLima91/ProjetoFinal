package br.grupo01.springboot01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.springboot01.model.Cliente;
import br.grupo01.springboot01.repository.ClienteRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepo repo;

    @GetMapping
    public List<Cliente> listarTodos() {
        List<Cliente> lista = (List<Cliente>) repo.findAll(); // casting

        return lista;
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable int codigo) {
        // busca um cliente com este codigo, e se não encontrar, preenche com null
        Cliente cliente = repo.findById(codigo).orElse(null);

        if(cliente != null) { // achou o cliente
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build(); // notFound = status 404, sem conteudo
    }
}
