package br.grupo01.springboot01.dto;

import br.grupo01.springboot01.model.Cliente;

public class ClienteDTO {
    private String nome;
    

    public ClienteDTO(Cliente cliente) {
        nome = cliente.getNome();
        }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
        
}