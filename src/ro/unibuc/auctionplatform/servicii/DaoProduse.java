package ro.unibuc.auctionplatform.servicii;
import ro.unibuc.auctionplatform.Produse;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DaoProduse {

    private static DaoProduse daoProduse  = null;
    private final String insertProduse = "insert into produse (numeProduse, descriere) values (?, ?) ";
    private Connection connection;

    // Connection with DataBase
    private DaoProduse()
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


    public static DaoProduse getInstance() {
        if (daoProduse == null)
        {
            daoProduse = new DaoProduse();
        }
        return daoProduse;
    }

    public void insert(Produse produse){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertProduse);
            preparedStatement.setString(1, produse.getNumeProduse());
            preparedStatement.setString(2, produse.getDescriere());

            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
