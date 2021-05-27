package ro.unibuc.auctionplatform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public interface InterfataAdmin {

    ArrayList<Utilizatori> utilizatori = new ArrayList<>();
    ArrayList<Produse> produse = new ArrayList<>();
    ArrayList<Licitatii> licitatii = new ArrayList<>();

    default Date parseDate(Scanner cin) {
        try {
            String date = cin.next();
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    Utilizatori getUtilizatoriById(int id);
    Produse getProduseById(int id);
    Licitatii getLicitatiiById(int id);

    Utilizatori addUtilizatori(Scanner in);
    void addProduse(Scanner in);
    void addLicitatii(Scanner in);
    void addBids(Scanner in);



}
