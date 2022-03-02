package br.com.agenda.Service;

import br.com.agenda.Dao.MedicoDao;
import br.com.agenda.Model.Medico;

import java.util.List;

public class MedicoService {

    MedicoDao medicoDao = new MedicoDao();

    public void insertMedico(Medico medico){
        medicoDao.insertMedico(medico);
    }

    public List<Medico> findAllMedico(Medico medico){

        return medicoDao.findAllMedico();
    }

    public Medico findByIdMedico(Medico medico){
        return medicoDao.findByIdMedico(12l);
    }

    public void updateMedico(Medico medico){
        medicoDao.updateMedico(medico);
    }

    public void disableMedico(Medico medico){
        medicoDao.disableMedico(medico);
    }
}
