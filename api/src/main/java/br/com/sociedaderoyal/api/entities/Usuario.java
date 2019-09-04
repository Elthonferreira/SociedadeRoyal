package br.com.sociedaderoyal.api.entities;

import br.com.sociedaderoyal.api.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -6491459261523089753L;

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private PerfilEnum perfil;
    private Date dataCriacao;
    private Usuario pai;
    private List<Usuario> filhos;
    private List<Fatura> faturas;

    public Usuario() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="nome", nullable=false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="email", nullable=false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="perfil", nullable=false)
    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    @Column(name="data_criacao", nullable=false)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Column(name="senha", nullable=false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name="cpf", nullable=false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name="telefone", nullable=false)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @ManyToOne
    public Usuario getPai() {
        return pai;
    }

    public void setPai(Usuario pai) {
        this.pai = pai;
    }

    @OneToMany(mappedBy="pai")
    @JsonIgnore
    public List<Usuario> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Usuario> filhos) {
        this.filhos = filhos;
    }

    @OneToMany(mappedBy="cliente")
    @JsonIgnore
    public List<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }

    //Quando acontece um cadastro
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha +
                ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", pai=" + pai + "" +
                ", filhos= "+ filhos +"]";
    }


}