import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    final String URL = "Jdbc:mysql://localhost:3306/";
    final String USER = "root";
    final String PASSWORD = "root99";
    final String CONSULTA = "select * from aluno";

        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conectado!");
        Statement st = con.createStatement();
        System.out.println("Statment criado!");

        String query = "insert into aluno(nome, matricula) values (?,?)";

        PreparedStatement stmt = con.prepareStatement(query);

        String nome = JOptionPane.showInputDialog("Digite o nome do aluno");
        String matricula = JOptionPane.showInputDialog("Insira a matricula do aluno");

        stmt.setString(1, nome);
        stmt.setString(2, matricula);


        int linhasAfetadas = stmt.executeUpdate();
        System.out.println("Dados inseridos!");

        ResultSet resultSet = stmt.executeQuery(CONSULTA);

        while (resultSet.next()){
            System.out.println(resultSet.getString("Nome"));
            System.out.println(resultSet.getString("Matricula"));
        }

    } catch (Exception e){
        System.out.println(e);
        e.printStackTrace();

    }
}
}