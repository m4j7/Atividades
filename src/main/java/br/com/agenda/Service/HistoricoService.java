package br.com.agenda.Service;

import br.com.agenda.Dao.HistoricoDao;
import br.com.agenda.Model.Historico;

public class HistoricoService {

     HistoricoDao historicoDao = new HistoricoDao();

    public void updateHistorico(Historico historico){
        historicoDao.updateHistorico(historico);
    }

    public void updateStatusHistorico (Historico historico){
        historicoDao.updateStatusHistorico((historico));
    }

    public void findAllHistorico(Historico historico){
        historicoDao.findByIdHistorico(historico);
    }

    public void findByIdHistorico(Historico historico){
        historicoDao.findByIdHistorico(historico);
    }
}
