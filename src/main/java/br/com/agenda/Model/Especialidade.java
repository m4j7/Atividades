package br.com.agenda.Model;

import java.time.LocalDateTime;

public class Especialidade extends AbstractEntity {

    private String nmEspecialidade;

    public Especialidade(String nmEspecialidade) {
        this.nmEspecialidade = nmEspecialidade;
    }

    public Especialidade() {
    }

    public Especialidade(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido) {
        super(id, cadastro, atualizado, excluido);
    }

    public Especialidade(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nmEspecialidade) {
        super(id, cadastro, atualizado, excluido);
        this.nmEspecialidade = nmEspecialidade;
    }



    public String getNmEspecialidade() {
        return nmEspecialidade;
    }

    public void setNmEspecialidade(String nmEspecialidade) {
        this.nmEspecialidade = nmEspecialidade;
    }


    @Override
    public String toString() {
        return "Especialidade{" +
                "nmEspecialidade='" + nmEspecialidade + '\'' +
                '}';
    }
}
