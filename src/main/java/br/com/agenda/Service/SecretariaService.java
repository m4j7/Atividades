package br.com.agenda.Service;

import br.com.agenda.Dao.SecretariaDao;
import br.com.agenda.Model.Paciente;
import br.com.agenda.Model.Secretaria;

public class SecretariaService {

    SecretariaDao secretariaDao = new SecretariaDao();


    public void insertSecretaria(Secretaria secretaria){

        secretariaDao.insertSecretaria(secretaria);
    }

    public Paciente findAllSecretaria(Secretaria secretaria){
        return (Paciente) secretariaDao.findAllSecretaria();
    }

    public Secretaria findByIdSecretaria(Secretaria secretaria){
        return secretariaDao.findByIdSecretaria(1l);
    }

    public void updateSecretaria(Secretaria secretaria){
        secretariaDao.updateSecretaria(secretaria);
    }



}
