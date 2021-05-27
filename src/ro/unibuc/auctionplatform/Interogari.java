package ro.unibuc.auctionplatform;

import ro.unibuc.auctionplatform.servicii.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Interogari implements InterfataAdmin {


    private DaoUtilizatori daoUtilizatori = DaoUtilizatori.getInstance();
    private DaoProduse daoProduse = DaoProduse.getInstance();
    private DaoLicitatii daoLicitatii = DaoLicitatii.getInstance();
    private DaoAudit daoAudit = DaoAudit.getInstance();

    @Override
    public Utilizatori getUtilizatoriById(int id) {
        for (Utilizatori utilizator : utilizatori) {
            if (utilizator.getId() == id)
                return utilizator;
        }
        return null;
    }

    @Override
    public Produse getProduseById(int id) {
        for (Produse produs : produse) {
            if (produs.getId() == id)
                return produs;
        }
        return null;
    }

    @Override
    public Licitatii getLicitatiiById(int id) {
        for (Licitatii licitatie : licitatii) {
            if (licitatie.getId() == id)
                return licitatie;
        }
        return null;
    }

    @Override
    public Utilizatori addUtilizatori(Scanner in) {
        System.out.println("username");
        String userName = in.next();

        System.out.println("adresa");
        String adress = in.next();

        System.out.println("Data nasterii aaaa-ll-zz");
        Date birthday = parseDate(in);

        System.out.println("Numar de telefon");
        String phoneNumber = in.next();

        Utilizatori utilizator = new Utilizatori(userName, adress, birthday, phoneNumber);
        utilizatori.add(utilizator);
        daoUtilizatori.write(utilizator);
        ServiciuScriere.getInstance().scrieLinie(utilizator.toString1(), new File("utilizatori.csv"));
        return utilizator;
    }


    public void addProduse(Scanner in) {
        System.out.println("Nume produs");
        String numeProduse = in.next();

        System.out.println("Descriere produs");
        String descriere = in.next();

        Produse produs = new Produse(numeProduse, descriere);
        produse.add(produs);
        daoProduse.insert(produs);
        ServiciuScriere.getInstance().scrieLinie(produs.toString1(), new File("produse.csv"));

    }

    public void addLicitatii(Scanner in) {
        System.out.println("Produs");
        String product = in.next();

        System.out.println("Data la care se liciteaza");
        Date date = parseDate(in);

        System.out.println("Pretul de la care se porneste licitatia");
        int startingBid = in.nextInt();

        System.out.println("Pretul la care poti cumpara produsul fara sa il mai licitezi");
//        afiseazaUtilizatoriDB();

        int buyOut = in.nextInt();

        Licitatii licitatie = new Licitatii(product, date, startingBid, buyOut);
        licitatii.add(licitatie);
        daoLicitatii.insert(licitatie);
        ServiciuScriere.getInstance().scrieLinie(licitatie.toString1(), new File("licitatii.csv"));

    }

    public void addBids(Scanner in) {
        System.out.println("Produsul pentru care licitati");
        String product = in.next();

        System.out.println("Data la care licitati de forma aaaa-ll-zz");
        Date date = parseDate(in);

        System.out.println("Pretul de la care porneste licitatia");
        int startingBid = in.nextInt();

        System.out.println("Pretul de buyout pe care sunteti dispusi sa il oferiti");
        int buyOut = in.nextInt();

        Bids bids= new Bids(product,date,startingBid,buyOut);

        ServiciuScriere.getInstance().scrieLinie(bids.toString1(), new File("bids.csv"));

    }

    public void case1() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("A fost adaugat un utilizator nou: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case2() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("A fost adaugat un produs nou: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case3() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("A fost adaugata o noua licitatie: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case4() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Un nou bid a fost adaugat: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case5() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a cerut afisarea unui utilizator dupa ID: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case6() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a cerut afisarea unui produs dupa ID: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case7() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a cerut afisarea unei licitatii dupa ID: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }
}
