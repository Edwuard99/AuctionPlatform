package ro.unibuc.auctionplatform.servicii;
import ro.unibuc.auctionplatform.servicii.Audit;
import java.sql.*;


public class DaoAudit {

    private static DaoAudit daoAudit = null;
    private final String insertAudit = "insert into audit(actiune, timestamp_audit) values (?,?)";
    private Connection connection;

    private DaoAudit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionplatform", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static DaoAudit getInstance() {
        if (daoAudit == null) {
            daoAudit = new DaoAudit();
        }
        return daoAudit;
    }
    public void insert(Audit audit) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAudit);
            preparedStatement.setString(1, audit.getActiune());
            preparedStatement.setTimestamp(2, new Timestamp(audit.getDataActiunii().getTime()));

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}