package br.com.agenda.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente extends Pessoa {

    private Convenio convenio;
    private TpAtendimento tpAtendimento;
    private LocalDateTime dtVencimentoConv;
    private String nrCartaoConv;

    public Paciente(String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa) {
        super(nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
    }

    public Paciente(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa) {
        super(id, cadastro, atualizado, excluido, nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
    }

    public Paciente() {
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public TpAtendimento getTpAtendimento() {
        return tpAtendimento;
    }

    public void setTpAtendimento(TpAtendimento tpAtendimento) {
        this.tpAtendimento = tpAtendimento;
    }

    public LocalDateTime getDtVencimentoConv() {
        return dtVencimentoConv;
    }

    public void setDtVencimentoConv(LocalDateTime dtVencimentoConv) {
        this.dtVencimentoConv = dtVencimentoConv;
    }

    public String getNrCartaoConv() {
        return nrCartaoConv;
    }

    public void setNrCartaoConv(String nrCartaoConv) {
        this.nrCartaoConv = nrCartaoConv;
    }



    @Override
    public String toString() {
        return "Paciente{" +
                "convenio=" + convenio +
                ", tpAtendimento=" + tpAtendimento +
                ", dtVencimentoConv=" + dtVencimentoConv +
                ", nrCartaoConv='" + nrCartaoConv + '\'' +
                '}';
    }
}

