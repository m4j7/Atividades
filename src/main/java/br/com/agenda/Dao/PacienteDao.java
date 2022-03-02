package br.com.agenda.Dao;

import br.com.agenda.Connection.ConnectionFactory;
import br.com.agenda.Model.Convenio;
import br.com.agenda.Model.Paciente;
import br.com.agenda.Model.Sexo;
import br.com.agenda.Model.TpAtendimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private static Connection connection;

    public PacienteDao() {

        try {
            this.connection = ConnectionFactory.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPaciente(Paciente paciente){

        String sql = "INSERT INTO paciente(cadastrado,nmpessoa ,email,login,senha,nrcpf,nrrg,nrtelefone,sexo," +
                "tpatendimento,id_convenio,nrcartaoconv ,dtvencimentoConv )" +
                "VALUES(now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, paciente.getNmPessoa());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getLogin());
            preparedStatement.setString(4, paciente.getSenha());
            preparedStatement.setString(5, paciente.getNrCpf());
            preparedStatement.setString(6, paciente.getNrRg());
            preparedStatement.setString(7, paciente.getNrTelefone());
            preparedStatement.setString(8, paciente.getSexo().valor);
            preparedStatement.setString(9, paciente.getTpAtendimento().valor);
            preparedStatement.setLong(10, paciente.getConvenio().getId());
            preparedStatement.setString(11, paciente.getNrCartaoConv());
            preparedStatement.setTimestamp(12, Timestamp.valueOf(paciente.getDtVencimentoConv()));
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                paciente.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Paciente> findAllPaciente(Paciente paciente){

        String sql = "SELECT * FROM paciente";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Paciente> listaDePacientes = new ArrayList<>();

            while (resultSet.next()){
                Paciente paciente1= new Paciente();

                paciente.setId(resultSet.getLong("id"));
                paciente.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    paciente.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    paciente.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                paciente1.setNmPessoa(resultSet.getString("nome"));
                paciente1.setEmail(resultSet.getString("email"));
                paciente1.setLogin(resultSet.getString("login"));
                paciente1.setSenha(resultSet.getString("senha"));
                paciente1.setNrCpf(resultSet.getString("nrcpf"));
                paciente1.setNrRg(resultSet.getString("nrrg"));
                paciente1.setNrTelefone(resultSet.getString("nrtelefone"));

                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        paciente.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        paciente.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        paciente.setSexo(Sexo.outro);
                        break;
                }
                switch (resultSet.getString("tipo_atendimento")){
                    case "Plano":
                        paciente.setTpAtendimento(TpAtendimento.plano);
                        break;
                    case "Convenio":
                        paciente.setTpAtendimento(TpAtendimento.convenio);
                        break;
                }
                ConvenioDao convenioDao = new ConvenioDao();
                Convenio convenio = convenioDao.findByIdConvenio(resultSet.getLong("id_convenio"));
                paciente1.setConvenio(convenio);
                paciente1.setNrCartaoConv(resultSet.getString("nrcartaoConv "));
                paciente1.setDtVencimentoConv(resultSet.getTimestamp("dtvencimentoconv").toLocalDateTime());

                listaDePacientes.add(paciente1);
            }

            return listaDePacientes;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;

    }


    public Paciente findByIdPaciente(long paciente){


        String sql = "SELECT * FROM paciente WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setLong(1, paciente_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Paciente paciente1 = new Paciente();

                paciente.setId(resultSet.getLong("id"));
                paciente.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    paciente.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    paciente.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }

                paciente1.setNmPessoa(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setLogin(resultSet.getString("login"));
                paciente.setSenha(resultSet.getString("senha"));
                paciente.setNrCpf(resultSet.getString("nrcpf"));
                paciente.setNrRg(resultSet.getString("nrrg"));
                paciente.setNrTelefone(resultSet.getString("nrtelefone"));

                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        paciente.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        paciente.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        paciente.setSexo(Sexo.outro);
                        break;
                }
                switch (resultSet.getString("tipo_atendimento")){
                    case "Plano":
                        paciente.setTpAtendimento(TpAtendimento.plano);
                        break;
                    case "Convenio":
                        paciente.setTpAtendimento(TpAtendimento.convenio);
                        break;
                }

                ConvenioDao convenioDao = new ConvenioDao();
                Convenio convenio = convenioDao.findByIdConvenio(resultSet.getLong("id_convenio"));
                paciente.setConvenio(convenio);
                paciente.setNrCartaoConv(resultSet.getString("nracrtaoconv"));
                paciente.setDtVencimentoConv(resultSet.getTimestamp("dtvencimentoconv").toLocalDateTime());

                return paciente;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }


    public void updatePaciente(Paciente paciente){

        String sql = "UPDATE paciente SET atualizado = now(),nmpessoa = ? ,email = ?,login = ?,senha = ?,nrcpf = ?,nrrg = ?,nrtelefone = ?,sexo = ?," +
                "tpatendimento = ?,id_convenio = ?,nrcartaoconv = ? ,dtvencimentoConv = ? WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, paciente.getNmPessoa());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getLogin());
            preparedStatement.setString(4, paciente.getSenha());
            preparedStatement.setString(5, paciente.getNrCpf());
            preparedStatement.setString(6, paciente.getNrRg());
            preparedStatement.setString(7, paciente.getNrTelefone());
            preparedStatement.setString(8, paciente.getSexo().valor);
            preparedStatement.setString(9, paciente.getTpAtendimento().valor);
            preparedStatement.setLong(10, paciente.getConvenio().getId());
            preparedStatement.setString(11, paciente.getNrCartaoConv());
            preparedStatement.setTimestamp(12, Timestamp.valueOf(paciente.getDtVencimentoConv()));

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disablePaciente(Paciente paciente){

        String sql = "UPDATE paciente SET excluido = now() WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, paciente.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }



}
