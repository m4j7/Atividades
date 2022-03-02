package br.com.agenda.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Secretaria extends Pessoa{

    private String nrPis;
    private LocalDateTime dtContratacao;
    private BigDecimal salario;

    public Secretaria(String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa, String nrPis, LocalDateTime dtContratacao, BigDecimal salario) {
        super(nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
        this.nrPis = nrPis;
        this.dtContratacao = dtContratacao;
        this.salario = salario;
    }

    public Secretaria(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa, String nrPis, LocalDateTime dtContratacao, BigDecimal salario) {
        super(id, cadastro, atualizado, excluido, nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
        this.nrPis = nrPis;
        this.dtContratacao = dtContratacao;
        this.salario = salario;
    }

    public Secretaria(String nrPis, LocalDateTime dtContratacao, BigDecimal salario) {
        this.nrPis = nrPis;
        this.dtContratacao = dtContratacao;
        this.salario = salario;
    }

    public Secretaria(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa) {
        super(id, cadastro, atualizado, excluido, nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
    }

    public Secretaria() {
    }

    public String getNrPis() {
        return nrPis;
    }

    public void setNrPis(String nrPis) {
        this.nrPis = nrPis;
    }

    public LocalDateTime getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(LocalDateTime dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "nrPis='" + nrPis + '\'' +
                ", dtContratacao=" + dtContratacao +
                ", salario=" + salario +
                '}';
    }
}
