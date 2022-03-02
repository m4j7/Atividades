package br.com.agenda.Dao;

import br.com.agenda.Connection.ConnectionFactory;
import br.com.agenda.Model.Secretaria;
import br.com.agenda.Model.Sexo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecretariaDao {

    private static Connection connection;


    public SecretariaDao(){
        try {
            this.connection = ConnectionFactory.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSecretaria(Secretaria secretaria){

        String sql = "INSERT INTO secretaria(cadastrado,nmpessoa ,email,login,senha,nrcpf,nrrg,nrtelefone,sexo," +
                "nrPis ,dtContratacao ,salario )" +
                "VALUES(now(),?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, secretaria.getNmPessoa());
            preparedStatement.setString(2, secretaria.getEmail());
            preparedStatement.setString(3, secretaria.getLogin());
            preparedStatement.setString(4, secretaria.getSenha());
            preparedStatement.setString(5, secretaria.getNrCpf());
            preparedStatement.setString(6, secretaria.getNrRg());
            preparedStatement.setString(7,  secretaria.getNrTelefone());
            preparedStatement.setString(8, secretaria.getSexo().valor);
            preparedStatement.setBigDecimal(11, secretaria.getSalario());
            preparedStatement.setTimestamp(12, Timestamp.valueOf(secretaria.getDtContratacao()));
            preparedStatement.setString(13, secretaria.getNrPis());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                secretaria.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Secretaria> findAllSecretaria(){

        String sql = "SELECT * FROM secretaria";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Secretaria> listaDeSecretarias = new ArrayList<>();

            while (resultSet.next()){
                Secretaria secretaria1 = new Secretaria();

                secretaria1.setId(resultSet.getLong("id"));
                secretaria1.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    secretaria1.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    secretaria1.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                secretaria1.setNmPessoa(resultSet.getString("nome"));
                secretaria1.setEmail(resultSet.getString("email"));
                secretaria1.setLogin(resultSet.getString("login"));
                secretaria1.setSenha(resultSet.getString("senha"));
                secretaria1.setNrCpf(resultSet.getString("nrcpf"));
                secretaria1.setNrRg(resultSet.getString("nrrg"));
                secretaria1.setNrTelefone(resultSet.getString("nrtelefone"));

                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        secretaria1.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        secretaria1.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        secretaria1.setSexo(Sexo.outro);
                        break;
                }
                secretaria1.setSalario(resultSet.getBigDecimal("salario"));
                secretaria1.setDtContratacao(resultSet.getTimestamp("dtcontratacao").toLocalDateTime());
                secretaria1.setNrPis(resultSet.getString("nrpis"));

                listaDeSecretarias.add(secretaria1);
            }



            return listaDeSecretarias;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Secretaria findByIdSecretaria(Long secretaria_id){

        String sql = "SELECT * FROM secretaria WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, secretaria_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Secretaria secretaria1 = new Secretaria();

                secretaria1.setId(resultSet.getLong("id"));
                secretaria1.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    secretaria1.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    secretaria1.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }

                secretaria1.setNmPessoa(resultSet.getString("nome"));
                secretaria1.setEmail(resultSet.getString("email"));
                secretaria1.setLogin(resultSet.getString("login"));
                secretaria1.setSenha(resultSet.getString("senha"));
                secretaria1.setNrCpf(resultSet.getString("nrcpf"));
                secretaria1.setNrRg(resultSet.getString("nrrg"));
                secretaria1.setNrTelefone(resultSet.getString("nrtelefone"));

                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        secretaria1.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        secretaria1.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        secretaria1.setSexo(Sexo.outro);
                        break;
                }
                secretaria1.setSalario(resultSet.getBigDecimal("salario"));
                secretaria1.setDtContratacao(resultSet.getTimestamp("dtcontratacao").toLocalDateTime());
                secretaria1.setNrPis(resultSet.getString("nrpis"));

                return secretaria1;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateSecretaria(Secretaria secretaria){

        String sql = "UPDATE secretaria SET atualizado = now(),nmpessoa = ? ,email = ?,login = ?,senha = ? = ?,nrcpf = ?,nrrg = ?,nrtelefone = ?,sexo = ? +" +
                "nrPis = ? ,dtContratacao = ? ,salario = ?" +
                "pis = ? WHERE id = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,secretaria.getNmPessoa());
            preparedStatement.setString(2,secretaria.getEmail());
            preparedStatement.setString(3, secretaria.getLogin());
            preparedStatement.setString(4,secretaria.getSenha());
            preparedStatement.setString(5,secretaria.getNrCpf());
            preparedStatement.setString(6,secretaria.getNrRg());
            preparedStatement.setString(7,secretaria.getNrCpf());
            preparedStatement.setString(8,secretaria.getSexo().valor);
            preparedStatement.setBigDecimal(9,secretaria.getSalario());
            preparedStatement.setTimestamp(10, Timestamp.valueOf(secretaria.getDtContratacao()));
            preparedStatement.setString(11,secretaria.getNrPis());
            preparedStatement.setLong(12, secretaria.getId());
            preparedStatement.execute();
            preparedStatement.close();


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableSecretaria(Secretaria secretaria){

        String sql = "UPDATE secretaria SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, secretaria.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
