package br.com.agenda.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Agenda extends AbstractEntity{

    private Paciente paciente;
    private Medico medico;
    private StAgendamento statusAgendamento;
    private LocalDate dataAbertura;
    private Boolean StEncaixe;

    public Agenda(Paciente paciente, Medico medico, StAgendamento statusAgendamento, LocalDate dataAbertura, Boolean stEncaixe) {
        this.paciente = paciente;
        this.medico = medico;
        this.statusAgendamento = statusAgendamento;
        this.dataAbertura = dataAbertura;
        StEncaixe = stEncaixe;
    }

    public Agenda(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, Paciente paciente, Medico medico, StAgendamento statusAgendamento, LocalDate dataAbertura, Boolean stEncaixe) {
        super(id, cadastro, atualizado, excluido);
        this.paciente = paciente;
        this.medico = medico;
        this.statusAgendamento = statusAgendamento;
        this.dataAbertura = dataAbertura;
        StEncaixe = stEncaixe;
    }

    public Agenda() {
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public StAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public LocalDate getDataAbertura(LocalDateTime dataAbertura) {
        return this.dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Boolean getStEncaixe() {
        return StEncaixe;
    }

    public void setStEncaixe(Boolean stEncaixe) {
        StEncaixe = stEncaixe;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", statusAgendamento=" + statusAgendamento +
                ", dataAbertura=" + dataAbertura +
                ", StEncaixe=" + StEncaixe +
                '}';
    }


}

