package br.com.agenda;

import br.com.agenda.Dao.EspecialidadeDao;
import br.com.agenda.Model.Agenda;
import br.com.agenda.Model.Convenio;
import br.com.agenda.Model.Especialidade;
import br.com.agenda.Service.AgendaService;
import br.com.agenda.Service.ConvenioService;
import br.com.agenda.Service.EspecialidadeService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

       BigDecimal bigDecimal = new BigDecimal( "3");

       Especialidade especialidade = new Especialidade("medico");
       EspecialidadeService es = new EspecialidadeService();

      es.disableEspecialidade(especialidade);

    }




}
