package br.backend.spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ativos_diretos")
public class Ativos_diretos implements Serializable {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_diretos_ativos;
    private String nome;
    private String usuario;
    private String telefone;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Construtor default
    public Ativos_diretos() {
    }

    // Contrutor geral
    public Ativos_diretos(String nome, String usuario, String telefone, String email) {
        this.nome = nome;
        this.usuario = usuario;
        this.telefone = telefone;
        this.email = email;
        //.cod_cliente = cod_cliente;
    }

    // Getters e Setters
    public int getId_diretos_ativos() {return id_diretos_ativos;}
    public void setId_diretos_ativos(int id_diretos_ativos) {this.id_diretos_ativos = id_diretos_ativos;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    //public Long getCod_cliente() {return cod_cliente;}
    //public void setCod_cliente(Long cod_cliente) {this.cod_cliente = cod_cliente;}


    @Override
    public int hashCode() {
        return Objects.hash(getId_diretos_ativos());
    }

    @Override
    public String toString() {
        return "Ativos_diretos{" +
                "id_diretos_ativos=" + id_diretos_ativos +
                ", nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                //", cod_cliente=" + cod_cliente +
                '}';
    }
}
