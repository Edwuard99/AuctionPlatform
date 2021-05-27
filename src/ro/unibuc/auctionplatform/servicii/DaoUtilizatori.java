package ro.unibuc.auctionplatform.servicii;
import ro.unibuc.auctionplatform.InterfataAdmin;
import ro.unibuc.auctionplatform.Utilizatori;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DaoUtilizatori {
    private static DaoUtilizatori daoUtilizatori;
    private Connection connection;
//    private final String insertUtilizatori = "insert into utilizatori (userName, adress, birthday, phoneNumber) values ( ?, ?, ?, ?)";
    // Conexiunea cu DB


    private DaoUtilizatori() {
        try {
            if (connection == null || connection.isClosed()) {
//                incarca driverul din mysql
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionplatform" , "root", "root");
                creeazaTabel();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void creeazaTabel(){
        final String query = "CREATE TABLE IF NOT EXISTS utilizatori (\n" +
                "id INT PRIMARY KEY AUTO_INCREMENT , \n" +
                "userName VARCHAR(128) NOT NULL, \n" +
                "adress VARCHAR(128) NOT NULL, \n" +
                "birthday DATE NOT NULL, \n" +
                "phoneNumber VARCHAR(10) NOT NULL)";
        try{
            Statement statement = connection.createStatement();
            statement.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DaoUtilizatori getInstance() {
        if (daoUtilizatori == null)
            daoUtilizatori = new DaoUtilizatori();
        return daoUtilizatori;
    }

    private Utilizatori mapToUtilizatori(ResultSet resultSet) throws SQLException {
        Utilizatori utilizatori = new Utilizatori(resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5));
        return utilizatori;
    }

    public void read(){
        final String query = "SELECT * FROM utilizatori";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                InterfataAdmin.utilizatori.add(mapToUtilizatori(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Nu s au putut lua toti utilizatorii: ");
        }
    }

    public void write(Utilizatori utilizatori) {
        final String query = "INSERT into utilizatori(userName, adress, birthday, phoneNumber) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setString(1, utilizatori.getUserName());
            preparedStatement.setString(2, utilizatori.getAdress());

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String data = df.format(utilizatori.getBirthday());
            System.out.println(data);
            Date date = Date.valueOf(df.format(utilizatori.getBirthday()));
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4,utilizatori.getPhoneNumber());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}