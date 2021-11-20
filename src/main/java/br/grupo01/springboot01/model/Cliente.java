package br.grupo01.springboot01.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity // Inidica que esta classe será armezenada no Banco de Dados
@Table(name = "tb_cliente")
public class Cliente {


    @Id // idica que este campo é chave primario
    @GeneratedValue (strategy =  GenerationType.IDENTITY) // 1,2.3.....
    private int codigo;

    @Column (name = "nome", length = 120, nullable = false)
    private String nome;

    @Column (length = 20)
    private String cpf;

    @Column (length = 20)
    private String telefone;

    @Column (length = 40, nullable = false, unique = true) // unique: não pode ter 2 emails iguais
    private String email;

    @OneToMany (mappedBy = "titular") 
    @JsonIgnoreProperties("titular")
    private List<Conta> contas;
    
    public int getCodigo()
     {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
