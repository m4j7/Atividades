package br.com.agenda.Dao;

import br.com.agenda.Connection.ConnectionFactory;
import br.com.agenda.Model.Especialidade;
import br.com.agenda.Model.Medico;
import br.com.agenda.Model.Sexo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDao {

    private static Connection connection;


    public MedicoDao(){
        try {
            this.connection = ConnectionFactory.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMedico(Medico medico){

        String sql = "INSERT INTO medico (cadastrado,nome,email,login,senha,nrcpf,nrrg,nrtelefone,sexo," +
                "id_especialidade,nrcrm,consultorio,porcenparticipacao) " +
                "VALUES(now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, medico.getNmPessoa());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getLogin());
            preparedStatement.setString(4, medico.getSenha());
            preparedStatement.setString(5, medico.getNrCpf());
            preparedStatement.setString(6, medico.getNrRg());
            preparedStatement.setString(8, medico.getNrTelefone());
            preparedStatement.setString(10, medico.getSexo().valor);
            preparedStatement.setLong(11, medico.getNmEspecialidade().getId());
            preparedStatement.setString(12, medico.getNrCrm());
            preparedStatement.setString(13, medico.getConsultorio());
            preparedStatement.setBigDecimal(14, medico.getPorcenParticipacao());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                medico.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List <Medico> findAllMedico(){

        String sql = "SELECT * FROM medico";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Medico> listaDeMedicos = new ArrayList<>();

            while (resultSet.next()){
                Medico medico = new Medico();

                medico.setId(resultSet.getLong("id"));
                medico.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    medico.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    medico.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                medico.setNmPessoa(resultSet.getString("nmpessoa"));
                medico.setEmail(resultSet.getString("email"));
                medico.setLogin(resultSet.getString("login"));
                medico.setSenha(resultSet.getString("senha"));
                medico.setNrCpf(resultSet.getString("nrcpf"));
                medico.setNrRg(resultSet.getString("nrrg"));
                medico.setNrTelefone(resultSet.getString("nrtelefone"));

                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        medico.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        medico.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        medico.setSexo(Sexo.outro);
                        break;
                }
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                Especialidade especialidade1 = especialidadeDao.findByIdEspecialidade(resultSet.getLong("id_especialidade"));
                medico.setNmEspecialidade(especialidade1);

                medico.setNrCrm(resultSet.getString("nrcrm"));
                medico.setConsultorio(resultSet.getString("consultorio"));
                medico.setPorcenParticipacao(resultSet.getBigDecimal("porcenparticipacao"));

                listaDeMedicos.add(medico);
            }

            return listaDeMedicos;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Medico findByIdMedico(Long medico_id){

        String sql = "SELECT * FROM medico WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, medico_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Medico medico = new Medico();

                medico.setId(resultSet.getLong("id"));
                medico.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    medico.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    medico.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                medico.setNmPessoa(resultSet.getString("nmpessoa"));
                medico.setEmail(resultSet.getString("email"));
                medico.setLogin(resultSet.getString("login"));
                medico.setSenha(resultSet.getString("senha"));
                medico.setNrCpf(resultSet.getString("cpf"));
                medico.setNrRg(resultSet.getString("rg"));
                medico.setNrTelefone(resultSet.getString("telefone"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        medico.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        medico.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        medico.setSexo(Sexo.outro);
                        break;
                }
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                Especialidade especialidade = especialidadeDao.findByIdEspecialidade(resultSet.getLong("id_especialidade"));
                medico.setNmEspecialidade(especialidade);

                medico.setNrCrm(resultSet.getString("nrcrm"));
                medico.setConsultorio(resultSet.getString("consultorio"));
                medico.setPorcenParticipacao(resultSet.getBigDecimal("porcenparticipacao"));

                return medico;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateMedico(Medico medico){

        String sql = "UPDATE medico SET atualizado = now(),nmpessoa = ?,email = ?,login = ?,senha = ?," +
                "nrrg = ?,nrcep = ?,nrtelefone = ?,sexo = ?,id_especialidade = ?," +
                "nrcrm = ?,consultorio = ?,porcenparticipacao = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,medico.getNmPessoa());
            preparedStatement.setString(2,medico.getEmail());
            preparedStatement.setString(3,medico.getLogin());
            preparedStatement.setString(4,medico.getSenha());
            preparedStatement.setString(5,medico.getNrCpf());
            preparedStatement.setString(6,medico.getNrRg());
            preparedStatement.setString(7,medico.getNrTelefone());
            preparedStatement.setString(8,medico.getSexo().valor);
            preparedStatement.setLong(9,medico.getNmEspecialidade().getId());
            preparedStatement.setString(10,medico.getNrCrm());
            preparedStatement.setString(11,medico.getConsultorio());
            preparedStatement.setBigDecimal(12,medico.getPorcenParticipacao());
            preparedStatement.setLong(13, medico.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableMedico(Medico medico){

        String sql = "UPDATE medico SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, medico.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


}
