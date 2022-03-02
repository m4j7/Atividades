package br.com.agenda.Dao;

import br.com.agenda.Connection.ConnectionFactory;
import br.com.agenda.Model.Convenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConvenioDao {

    private static Connection connection;
    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public ConvenioDao() {
        try {
            this.connection = ConnectionFactory.getConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertConvenio(Convenio convenio){
        String sql = "INSERT INTO convenio (cadastrado, nmconvenio, vlconvenio) VALUES (now(), ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, convenio.getNmConvenio());
            stmt.setBigDecimal(2, convenio.getVlConvenio());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO INSERIR NA TABELA CONVENIO");
        }
    }

    public List<Convenio> findAllConvenio(Convenio convenio){

        String sql = "SELECT * FROM convenio";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Convenio> lista = new ArrayList<>();

            while (resultSet.next()){

                Convenio conv = new Convenio();

                conv.setId(resultSet.getLong("id"));
                conv.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());

                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    conv.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    conv.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                conv.setNmConvenio(resultSet.getString("nmconvenio"));
                conv.setVlConvenio(resultSet.getBigDecimal("vlconvenio"));

                lista.add(conv);
            }

            return lista;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;


    }

    public Convenio findByIdConvenio( Long id_convenio ){

        String sql = "SELECT * FROM convenio WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id_convenio );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Convenio convenio1 = new Convenio();
                convenio1.setId(resultSet.getLong("id"));
                convenio1.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    convenio1.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    convenio1.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                convenio1.setNmConvenio(resultSet.getString("nmconvenio"));
                convenio1.setVlConvenio(resultSet.getBigDecimal("vlconvenio"));

                System.out.println(convenio1);
                return convenio1;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;

    }

    public void updateConvenio(Convenio convenio ){
        String sql = "UPDATE convenio SET atualizado = now(),nmconvenio = ?,vlconvenio = ? WHERE id = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,convenio.getNmConvenio());
            preparedStatement.setBigDecimal(2,convenio.getVlConvenio());
            //preparedStatement.setLong(3, convenio.getId());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void disableConvenio(Convenio convenio ){

        String sql = "UPDATE convenio SET excluido = now() WHERE id = 3";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setLong(1, convenio.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }



}
