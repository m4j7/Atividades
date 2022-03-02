package br.com.agenda.Model;

import java.time.LocalDateTime;

abstract class Pessoa extends AbstractEntity {

    private String nmPessoa;
    private Sexo sexo;
    private String nrRg;
    private String nrCpf;
    private String rua;
    private String login;
    private String senha;
    private String nrTelefone;
    private String email;
    private Boolean stPessoa;

    public Pessoa(String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa) {
        this.nmPessoa = nmPessoa;
        this.sexo = sexo;
        this.nrRg = nrRg;
        this.nrCpf = nrCpf;
        this.rua = rua;
        this.login = login;
        this.senha = senha;
        this.nrTelefone = nrTelefone;
        this.email = email;
        this.stPessoa = stPessoa;
    }

    public Pessoa(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmPessoa, Sexo sexo, String nrRg, String nrCpf, String rua, String login, String senha, String nrTelefone, String email, Boolean stPessoa) {
        super(id, cadastro, atualizado, excluido);
        this.nmPessoa = nmPessoa;
        this.sexo = sexo;
        this.nrRg = nrRg;
        this.nrCpf = nrCpf;
        this.rua = rua;
        this.login = login;
        this.senha = senha;
        this.nrTelefone = nrTelefone;
        this.email = email;
        this.stPessoa = stPessoa;
    }

    protected Pessoa() {
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStPessoa() {
        return stPessoa;
    }

    public void setStPessoa(Boolean stPessoa) {
        this.stPessoa = stPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nmPessoa='" + nmPessoa + '\'' +
                ", sexo=" + sexo +
                ", nrRg='" + nrRg + '\'' +
                ", nrCpf='" + nrCpf + '\'' +
                ", rua='" + rua + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nrTelefone='" + nrTelefone + '\'' +
                ", email='" + email + '\'' +
                ", stPessoa=" + stPessoa +
                '}';
    }
}
