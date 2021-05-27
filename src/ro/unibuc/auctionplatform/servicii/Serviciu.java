package ro.unibuc.auctionplatform.servicii;
import ro.unibuc.auctionplatform.Utilizatori;
import ro.unibuc.auctionplatform.UtilizatoriList;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Serviciu {
    private static Serviciu serviciu = null;

    private String file = "src/ro/unibuc/auctionplatform/Utilizatori.csv";


    private ServiciuScriere serviciuScriere;
    private ServiciuCitire serviciuCitire;


    private Serviciu() {
        serviciuCitire = ServiciuCitire.getInstance();
        serviciuScriere = ServiciuScriere.getInstance();
    }

    public static Serviciu getInstance() {
        if (serviciu == null) {
            serviciu = new Serviciu();
        }
        return serviciu;
    }
//    public void scrie(Utilizatori utilizatori) {
//        serviciuScriere.scrieLinie(utilizatori.toCsv(), new File(file));
//    }
//
//    public List<Utilizatori> citesteOrdonatDupaData() {
//        List<Utilizatori> utilizatori = new ArrayList<>();
//        List<String> continutCsv = serviciuCitire.citesteContinutFisier(new File(file));
//        for (String linieCsv : continutCsv) {
//            Utilizatori obiectUtilizatori;
//            obiectUtilizatori = transformaCsv(linieCsv);
//            utilizatori.add(obiectUtilizatori);
//        }
//    }

//    private Utilizatori transformaCsv(String linieCsv) {
//        String[] split = linieCsv.split(",");  //pentru fiecare linie face split si extrage un array de campuri
//        //apoi creeaza un nou utilizator
//        try {
//            return new Utilizatori(split[0], new SimpleDateFormat("yyyy-mm-dd").parse(split[1]), split[2]); //parsarea datei
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}