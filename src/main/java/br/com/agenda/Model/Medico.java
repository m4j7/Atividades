package br.com.agenda.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Medico extends Pessoa{

    private String nrCrm;
    private BigDecimal porcenParticipacao;
    private String consultorio;
    private Especialidade nmEspecialidade;

    public Medico() {
    }

    public Medico(String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa, String nrCrm, BigDecimal porcenParticipacao, String consultorio, Especialidade nmEspecialidade) {
        super(nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
        this.nrCrm = nrCrm;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
        this.nmEspecialidade = nmEspecialidade;
    }



    public Especialidade getNmEspecialidade() {
        return nmEspecialidade;
    }

    public void setNmEspecialidade(Especialidade nmEspecialidade) {
        this.nmEspecialidade = nmEspecialidade;
    }

    public Medico(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa, String nrCrm, BigDecimal porcenParticipacao, String consultorio, Especialidade nmEspecialidade) {
        super(id, cadastro, atualizado, excluido, nmPessoa, sexo, nrRg, nrCpf, rua, login, senha, nrTelefone, email, stPessoa);
        this.nrCrm = nrCrm;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
        this.nmEspecialidade = nmEspecialidade;
    }

    public Medico(String nrCrm, BigDecimal porcenParticipacao, String consultorio, Especialidade nmEspecialidade) {
        this.nrCrm = nrCrm;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
        this.nmEspecialidade = nmEspecialidade;
    }

    public String getNrCrm() {
        return nrCrm;
    }

    public void setNrCrm(String nrCrm) {
        this.nrCrm = nrCrm;
    }

    public BigDecimal getPorcenParticipacao() {
        return porcenParticipacao;
    }

    public void setPorcenParticipacao(BigDecimal porcenParticipacao) {
        this.porcenParticipacao = porcenParticipacao;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }





}
