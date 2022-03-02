package br.com.agenda.Dao;

import br.com.agenda.Connection.ConnectionFactory;
import br.com.agenda.Model.Agenda;
import br.com.agenda.Model.Medico;
import br.com.agenda.Model.Paciente;
import br.com.agenda.Model.StAgendamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDao {

    private static Connection connection;

    public AgendaDao() {

        try {
            this.connection = ConnectionFactory.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAgendamento(Agenda agenda){

        String sql = "INSERT INTO agenda (cadastrado,id_paciente,id_medico,statusagendamento,dataabertura,stencaixe)" +
                "VALUES(now(),?,?,?,?,?)";


        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,agenda.getPaciente().getId());
            preparedStatement.setLong(2, agenda.getMedico().getId());
            preparedStatement.setString(3, agenda.getStatusAgendamento().valor);
            //preparedStatement.setTimestamp(4, Timestamp.valueOf(agenda.getDataAbertura(resultSet.getTimestamp("dataAbertura").toLocalDateTime()));
            preparedStatement.setBoolean(5, agenda.getStEncaixe());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                agenda.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Agenda> findAllAgendamento(){

        String sql = "SELECT * FROM agenda";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Agenda> listaDeAgendas = new ArrayList<>();

            while (resultSet.next()){
                Agenda agenda = new Agenda();

                agenda.setId(resultSet.getLong("id"));
                agenda.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    agenda.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    agenda.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                agenda.setPaciente(paciente);

                MedicoDao medicoDao = new MedicoDao();
                Medico medico = medicoDao.findByIdMedico(resultSet.getLong("id_medico"));
                agenda.setMedico(medico);

                switch (resultSet.getString("statusagendamento")){
                    case "Pendente":
                        agenda.setStatusAgendamento(StAgendamento.pendente);
                        break;
                    case "Aprovado":
                        agenda.setStatusAgendamento(StAgendamento.aprovado);
                        break;
                    case "Cancelado":
                        agenda.setStatusAgendamento(StAgendamento.cancelado);
                        break;
                    case "Compareceu":
                        agenda.setStatusAgendamento(StAgendamento.compareceu);
                        break;
                    case "Não Compareceu":
                        agenda.setStatusAgendamento(StAgendamento.ncompareceu);
                        break;
                    case "Rejeitado":
                        agenda.setStatusAgendamento(StAgendamento.rejeitado);
                        break;
                }

                agenda.getDataAbertura(resultSet.getTimestamp("dataabertura").toLocalDateTime());
                agenda.setStEncaixe(resultSet.getBoolean("stencaixe"));

                listaDeAgendas.add(agenda);
            }

            return listaDeAgendas;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Agenda findByIdAgendamento(Long agenda_id){

        String sql = "SELECT * FROM agenda WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, agenda_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Agenda agenda = new Agenda();

                agenda.setId(resultSet.getLong("id"));
                agenda.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    agenda.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    agenda.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                agenda.setPaciente(paciente);

                MedicoDao medicoDao = new MedicoDao();
                Medico medico = medicoDao.findByIdMedico(resultSet.getLong("id_medico"));
                agenda.setMedico(medico);

                switch (resultSet.getString("statusagendamento")){
                    case "Pendente":
                        agenda.setStatusAgendamento(StAgendamento.pendente);
                        break;
                    case "Aprovado":
                        agenda.setStatusAgendamento(StAgendamento.aprovado);
                        break;
                    case "Cancelado":
                        agenda.setStatusAgendamento(StAgendamento.cancelado);
                        break;
                    case "Compareceu":
                        agenda.setStatusAgendamento(StAgendamento.compareceu);
                        break;
                    case "Não Compareceu":
                        agenda.setStatusAgendamento(StAgendamento.ncompareceu);
                        break;
                    case "Rejeitado":
                        agenda.setStatusAgendamento(StAgendamento.rejeitado);
                        break;
                }

                agenda.getDataAbertura(resultSet.getTimestamp("dataAbertura").toLocalDateTime());
                agenda.setStEncaixe(resultSet.getBoolean("StEncaixe "));

                return agenda;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateAgendamento(Agenda agenda){

        String sql = "UPDATE agenda SET atualizado = now(),id_paciente = ?,id_medico = ?," +
                "statusagendamento = ?,dataabertura  = ?,stencaixe = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,agenda.getPaciente().getId());
            preparedStatement.setLong(2,agenda.getMedico().getId());
            preparedStatement.setString(3,agenda.getStatusAgendamento().valor);
           // preparedStatement.setTimestamp(4,Timestamp.valueOf(String.valueOf(agenda.getDataAbertura));
            preparedStatement.setBoolean(5,agenda.getStEncaixe());
            preparedStatement.setLong(6, agenda.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableAgendamento(Agenda agenda){

        String sql = "UPDATE agenda SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, agenda.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
