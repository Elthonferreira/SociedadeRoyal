package br.com.sociedaderoyal.api.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fatura")
public class Fatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao1;
    private String descricao2;
    private String descricao3;
    private String descricao4;
    private String valor;
    private String registro;
    private int status_fatura;
    private Usuario cliente;

    public Fatura (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao1() {
        return descricao1;
    }

    public void setDescricao1(String descricao1) {
        this.descricao1 = descricao1;
    }

    public String getDescricao2() {
        return descricao2;
    }

    public void setDescricao2(String descricao2) {
        this.descricao2 = descricao2;
    }

    public String getDescricao3() {
        return descricao3;
    }

    public void setDescricao3(String descricao3) {
        this.descricao3 = descricao3;
    }

    public String getDescricao4() {
        return descricao4;
    }

    public void setDescricao4(String descricao4) {
        this.descricao4 = descricao4;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getStatus_fatura() {
        return status_fatura;
    }

    public void setStatus_fatura(int status_fatura) {
        this.status_fatura = status_fatura;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}
