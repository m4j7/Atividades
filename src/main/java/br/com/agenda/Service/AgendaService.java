package br.com.agenda.Service;

import br.com.agenda.Dao.AgendaDao;
import br.com.agenda.Model.Agenda;

import java.util.List;

public class AgendaService {

    AgendaDao agendaDao = new AgendaDao();

    public void insertAgendamento(Agenda agenda){

        agendaDao.insertAgendamento(agenda);
    }

    public List<Agenda> findAllAgendamento(Agenda agenda){

        return agendaDao.findAllAgendamento();
    }

    public Agenda findByIdAgendamento(Agenda agenda){
        return agendaDao.findByIdAgendamento(1l);
    }

    public void updateAgendamento(Agenda agenda){
        agendaDao.updateAgendamento(agenda);
    }

    public void disableAgendamento(Agenda agenda)
    {
        agendaDao.disableAgendamento(agenda);
    }


}
