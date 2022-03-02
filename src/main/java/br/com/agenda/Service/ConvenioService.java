package br.com.agenda.Service;

import br.com.agenda.Dao.ConvenioDao;
import br.com.agenda.Model.Convenio;

import java.util.List;

public class ConvenioService {

    ConvenioDao convenioDao = new ConvenioDao();


    public void insertConvenio(Convenio convenio){
        convenioDao.insertConvenio(convenio);
    }

    public List<Convenio> findAllConvenio(Convenio convenio){
       return convenioDao.findAllConvenio(convenio);
    }

    public Convenio findByIdConvenio(Convenio convenio){
        convenioDao.findByIdConvenio( 1l);
        return null;
    }

    public void updateConvenio(Convenio convenio){
        convenioDao.updateConvenio(convenio);
    }

    public void disableConvenio(Convenio convenio){
        convenioDao.disableConvenio(convenio);
    }

}
