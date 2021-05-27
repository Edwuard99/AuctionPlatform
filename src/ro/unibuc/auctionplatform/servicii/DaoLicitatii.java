package ro.unibuc.auctionplatform.servicii;
import ro.unibuc.auctionplatform.InterfataAdmin;
import ro.unibuc.auctionplatform.Licitatii;
import ro.unibuc.auctionplatform.Utilizatori;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


// DAO = DataBase Access Object

public class DaoLicitatii {

    private static DaoLicitatii daoLicitatii = null;
    private final String insertLicitatii = "insert into licitatii(product, date, startingBid, buyOut) values (?, ?, ?, ?)";
    private Connection connection;

    // fac conexiunea cu baza de date
    private DaoLicitatii()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionplatform", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DaoLicitatii getInstance() {
        if (daoLicitatii == null) {
            daoLicitatii = new DaoLicitatii();
        }
        return daoLicitatii;
    }

    private Licitatii mapToLicitatii(ResultSet resultSet) throws SQLException {
        Licitatii licitatii = new Licitatii(resultSet.getString(1), resultSet.getDate(2), resultSet.getInt(3), resultSet.getInt(4));
        return licitatii;
    }

    public void read(){
        final String query = "SELECT product, date, startingBid, buyOut FROM licitatii";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                InterfataAdmin.licitatii.add(mapToLicitatii(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Nu s au putut lua toate licitatiile: ");
        }
    }
    public void insert(Licitatii licitatii){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertLicitatii);
            preparedStatement.setString(1, licitatii.getProduct());

//          Am avut o problema cand incercam sa incarc data din util.java in data din sql si am facut asta:
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String data = df.format(licitatii.getDate());
            System.out.println(data);
            Date date = Date.valueOf(df.format(licitatii.getDate()));

            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, licitatii.getStartingBid());
            preparedStatement.setInt(4, licitatii.getBuyOut());

            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
