package br.backend.spring.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Long id_cliente;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String usuario;
    private String senha;
    private Plano plano;
    private FormPagamento formpagamento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @OneToMany(mappedBy = "cliente", orphanRemoval = true)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Ativos_diretos> ativos_diretos;


    // ComboBox plano
    public enum Plano {
        FINANCEIRO  (1), BEMESTAR   (2), MINDSET  (3);
        private final int escolha;
        Plano(int escolha) {this.escolha = escolha;}

        public int getEscolha() {return escolha;}
    }

    // ComboBox formpagamento
    public enum FormPagamento {
        BANCARIA  (1), URPAY   (2);
        private final int escolha;
        FormPagamento(int escolha) {this.escolha = escolha;}

        public int getEscolha() {return escolha;}
    }

    // Construtor default
    public Cliente() {
    }
    // Construtor geral
    public Cliente(String nome, String cpf, String email, String telefone, String usuario, String senha, Plano plano, FormPagamento formpagamento, String endereco, String bairro, String cidade, String estado, String cep, List<Ativos_diretos> ativos_diretos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
        this.plano = plano;
        this.formpagamento = formpagamento;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.ativos_diretos = ativos_diretos;
    }

    // Getters e Setters
    public Long getId_cliente() {return id_cliente;}
    public void setId_cliente(Long id) {this.id_cliente = id;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public Plano getPlano() {return plano;}
    public void setPlano(Plano plano) {this.plano = plano;}
    public FormPagamento getFormpagamento() {return formpagamento;}
    public void setFormpagamento(FormPagamento formpagamento) {this.formpagamento = formpagamento;}
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public String getBairro() {return bairro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}
    public List<Ativos_diretos> getAtivos_diretos() {return ativos_diretos;}
    public void setAtivos_diretos(List<Ativos_diretos> ativos_diretos) {this.ativos_diretos = ativos_diretos;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", plano=" + plano +
                ", formpagamento=" + formpagamento +
                ", endereço='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
