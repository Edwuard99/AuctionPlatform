//package ro.unibuc.auctionplatform.servicii;
//import ro.unibuc.auctionplatform.Bids;
//import java.sql.*;
//
//public class DaoBids {
//    private static DaoUtilizatori daoBids = null;
//    private final String insertBids = "insert into utilizatori (nume, data_nasterii, adresa) values (?, ?, ?)";
//    private Connection connection;
//    private Object Utilizatori;
//
//    //Conexiunea cu DB
//    private DaoBids() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static DaoBids getInstance() {
//        if (daoBids == null)  //verifica daca e creat obiect, daca nu a fost deja creat
//        {
//            daoBids = new DaoBids();
//        }
//        return daoBids;  //returneaza obiectul deja creat, obtin o singura instanta a clasei respective
//    }
//
//    public void insert(Bids bids) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(insertBids);
//            preparedStatement.setString(1, bids.getProduct());
//            preparedStatement.setDate(2, (Date) bids.getDate());
//            preparedStatement.setInt(3, bids.getStartingBid());
//            preparedStatement.setInt(4, bids.getBuyOut());
//
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Bids selecteazaBidsCuNumele(String nume) {
//        Bids bids = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, PRODUCT, DATE, ADRESA FROM BIDS WHERE NUME = ?");
//            preparedStatement.setString(1, nume);
//            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery ca sa fac select si imi reurneaza un ResultSet
//            //ResultSet contine mai multe randuri din DB
//            while (resultSet.next())   //cu next se duce pe primul rand din baza mea de date
//            {
//                //in primul rand iau campurile corespondente campurilor de pe utilizatorul meu ca sa imi creez unul
//                bids = new Bids(resultSet.getInt(1));  //primeste id-ul utilizatorului, 1 este numarul coloanei (ordinea din SELECT)
//                bids.setUserName(resultSet.getString(2));
//                bids.setDataNasterii(resultSet.getDate(3));
//                bids.setAdress(resultSet.getString(4));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bids;   //imi returneaza un utilizator care se duce in Actiuni pentru a il afisa
//    }
//
//    public Utilizatori getUtilizatorDupaID(int id) {
//        Utilizatori utilizatori = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NUME, DATA_NASTERII, ADRESA FROM UTILIZATOR WHERE ID = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery ca sa fac select si imi reurneaza un ResultSet
//            //ResultSet contine mai multe randuri din DB
//            while (resultSet.next())   //cu next se duce pe primul rand din baza mea de date
//            {
//                //in primul rand iau campurile corespondente campurilor de pe utilizatorul meu ca sa imi creez unul
//                Utilizatori = new Utilizatori(resultSet.getInt(1));  //primeste id-ul utilizatorului, 1 este numarul coloanei (ordinea din SELECT)
//                utilizatori.setUserName(resultSet.getString(2));
//                utilizatori.setDataNasterii(resultSet.getDate(3));
//                utilizatori.setAdress(resultSet.getString(4));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return utilizatori;   //imi returneaza un utilizator care se duce in Actiuni pentru a il afisa
//    }
//
//    public void deleteUtilizator(String nume) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM UTILIZATOR WHERE NUME = ?");
//            preparedStatement.setString(1, nume);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void actualizeazaAdresa(String nume, String adresa) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE UTILIZATOR SET ADRESA = ? WHERE NUME = ?");
//            preparedStatement.setString(1, adresa);
//            preparedStatement.setString(2, nume);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}