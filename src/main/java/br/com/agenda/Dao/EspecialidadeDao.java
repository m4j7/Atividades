package br.com.agenda.Dao;

import br.com.agenda.Connection.ConnectionFactory;
import br.com.agenda.Model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDao {

    private static Connection connection;

    public EspecialidadeDao() {

        try {
            this.connection = ConnectionFactory.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEspecialidade(Especialidade especialidade){

        String sql = "INSERT INTO especialidade (cadastrado, nmespeciaidade) VALUES (now(), ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, especialidade.getNmEspecialidade());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO INSERIR NA TABELA CONVENIO");
        }
    }

    public List<Especialidade> findAllEspecialidade(Especialidade especialidade){

        String sql = "SELECT * FROM especialidade";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Especialidade> lista = new ArrayList<>();

            while (resultSet.next()){

                Especialidade esp = new Especialidade();

                esp.setId(resultSet.getLong("id"));
                esp.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());

                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    esp.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    esp.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                esp.setNmEspecialidade(resultSet.getString("nmespeciaidade"));

                lista.add(esp);
            }

            return lista;

        } catch (SQLException e){
            e.printStackTrace();
        }
       return null;
    }

    public Especialidade findByIdEspecialidade(long especialidade){

        String sql = "SELECT * FROM especialidade WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setLong(1, convenio_id );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Especialidade especialidade1 = new Especialidade();

                especialidade1.setId(resultSet.getLong("id"));
                especialidade1.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    especialidade1.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    especialidade1.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                especialidade1.setNmEspecialidade(resultSet.getString("nmespeciaidade"));

                System.out.println(especialidade1);
                return especialidade1;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
      return null;
    }

    public void updateEspecialidade(Especialidade especialidade){

        String sql = "UPDATE especialidade SET atualizado = now(), nmespeciaidade = ? WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,especialidade.getNmEspecialidade());
            //preparedStatement.setLong(2, especialidade.getId());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void disableEspecialidade(Especialidade especialidade){

        String sql = "UPDATE especialidade SET excluido = now() WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
           // preparedStatement.setLong(1, especialidade.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
