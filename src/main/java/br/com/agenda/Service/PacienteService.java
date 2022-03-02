package br.com.agenda.Service;

import br.com.agenda.Dao.AgendaDao;
import br.com.agenda.Dao.PacienteDao;
import br.com.agenda.Model.Paciente;

public class PacienteService {

    PacienteDao pacienteDao= new PacienteDao();

    public PacienteService(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void insertPaciente(Paciente paciente){
        pacienteDao.insertPaciente(paciente);
    }

    public Paciente findAllPaciente(Paciente paciente){

        return (Paciente) pacienteDao.findAllPaciente(paciente);
    }

    public Paciente findByIdPaciente(Paciente paciente){
       return pacienteDao.findByIdPaciente(paciente);
    }


    public void updatePaciente(Paciente paciente){
        pacienteDao.updatePaciente(paciente);
    }



}
