package ro.unibuc.auctionplatform;

import ro.unibuc.auctionplatform.servicii.DaoLicitatii;
import ro.unibuc.auctionplatform.servicii.DaoUtilizatori;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DaoUtilizatori daoUtilizatori = DaoUtilizatori.getInstance();
        daoUtilizatori.read();

        DaoLicitatii daoLicitatii = DaoLicitatii.getInstance();
        daoLicitatii.read();
        System.out.println("Pentru a adauga un utilizator apasati 1");
        System.out.println("Pentru a adauga un produs apasati 2");
        System.out.println("Pentru a adauga o licitatie apasati 3");
        System.out.println("Pentru a adauga un bid apasati 4");
        System.out.println("Pentru a vedea un utilizator dupa id apasati 5");
        System.out.println("Pentru a vedea un produs dupa id apasati 6");
        System.out.println("Pentru a vedea o licitatie dupa id apasati 7");

        int optiune = in.nextInt();
        Interogari interogari = new Interogari();

        while(optiune>0)
        {
            try {
                switch (optiune) {
                    case 1:
                        interogari.addUtilizatori(in);
                        interogari.case1();
                        break;
                    case 2:
                        interogari.addProduse(in);
                        interogari.case2();
                        break;
                    case 3:
                        interogari.addLicitatii(in);
                        interogari.case3();
                        break;
                    case 4:
                        interogari.addBids(in);
                        interogari.case4();
                        break;
                    case 5:
                        System.out.println(interogari.getUtilizatoriById(in.nextInt()).toString());
                        interogari.case5();
                        break;
                    case 6:
                        System.out.println(interogari.getProduseById(in.nextInt()).toString());
                        interogari.case6();
                        break;
                    case 7:
                        System.out.println(interogari.getLicitatiiById(in.nextInt()).toString());
                        interogari.case7();
                        break;
                    default:
                        System.out.println("Optiunea nu este valida!!!");
                        break;
                }
            } catch (Exception e)
            {
//                tratez toate exceptiile
                e.printStackTrace();
            }
            System.out.println("introduceti optiunea dumneavoastra sau apasati -1");
            optiune = in.nextInt();
        }
        System.out.println("La revedere!");
    }
}
