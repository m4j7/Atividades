package br.com.agenda.Service;

import br.com.agenda.Dao.EspecialidadeDao;
import br.com.agenda.Model.Convenio;
import br.com.agenda.Model.Especialidade;

import java.util.List;

public class EspecialidadeService {

    EspecialidadeDao especialidadeDao = new EspecialidadeDao();

    public void insertEspecialidade(Especialidade especialidade){

        especialidadeDao.insertEspecialidade(especialidade);
    }

    public List<Especialidade> findAllConvenio(Especialidade especialidade){
        return especialidadeDao.findAllEspecialidade(especialidade);
    }

    public Especialidade findByIdEspecialidade(Especialidade especialidade){
        return especialidadeDao.findByIdEspecialidade(especialidade);
    }


    public void updateEspecialidade(Especialidade especialidade){
        especialidadeDao.updateEspecialidade(especialidade);
    }

    public void disableEspecialidade(Especialidade especialidade){
        especialidadeDao.disableEspecialidade(especialidade);
    }


}


