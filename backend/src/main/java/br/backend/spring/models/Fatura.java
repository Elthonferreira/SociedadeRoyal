package br.backend.spring.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "fatura")
public class Fatura implements Serializable {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Column(name = "id_fatura")
    private Long id_fatura;
    private Long idbusca;
    private String descricao1;
    private String descricao2;
    private String descricao3;
    private String descricao4;
    private String valor;
    private String registro;
    private int status_fatura;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cliente", nullable = false)
    private Cliente cliente;


    // Construtor default
    public Fatura (){}

    // Construtor geral
    public Fatura(String descricao1, String descricao2, String descricao3, String descricao4, String valor, String registro, int status_fatura) {
        this.descricao1 = descricao1;
        this.descricao2 = descricao2;
        this.descricao3 = descricao3;
        this.descricao4 = descricao4;
        this.valor = valor;
        this.registro = registro;
        this.status_fatura = status_fatura;
    }

    // Getters e Setters
    public Long getId_fatura() {return id_fatura;}
    public void setId_fatura(Long id_fatura) {this.id_fatura = id_fatura;}
    public String getDescricao1() {return descricao1;}
    public void setDescricao1(String descricao1) {this.descricao1 = descricao1;}
    public String getDescricao2() {return descricao2;}
    public void setDescricao2(String descricao2) {this.descricao2 = descricao2;}
    public String getDescricao3() {return descricao3;}
    public void setDescricao3(String descricao3) {this.descricao3 = descricao3;}
    public String getDescricao4() {return descricao4;}
    public void setDescricao4(String descricao4) {this.descricao4 = descricao4;}
    public String getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}
    public String getRegistro() {return registro;}
    public void setRegistro(String registro) {this.registro = registro;}
    public int getStatus_fatura() {return status_fatura;}
    public void setStatus_fatura(int status_fatura) {this.status_fatura = status_fatura;}
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
}
