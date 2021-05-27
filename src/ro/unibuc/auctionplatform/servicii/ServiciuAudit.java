package ro.unibuc.auctionplatform.servicii;
import ro.unibuc.auctionplatform.servicii.Audit;
import ro.unibuc.auctionplatform.servicii.DaoAudit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
public class ServiciuAudit {

    private static ServiciuAudit serviciuAudit = null;
    private final DaoAudit daoAudit;
    private ServiciuAudit() {
        daoAudit = DaoAudit.getInstance();
    }

    public static ServiciuAudit getInstance() {
        if (serviciuAudit == null) {
            serviciuAudit = new ServiciuAudit();
        }
        return serviciuAudit;
    }


    //creeaza un audit
    public void inregistrareAudit(String actiune) {
        Audit audit = new Audit(actiune, new Date(System.currentTimeMillis()));
        inregistreazaInFisier(audit);
        daoAudit.insert(audit);
    }

    private void inregistreazaInFisier(Audit audit) {
        try {
            File file = new File("time.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.write(audit.toString());
            writer.newLine();
            writer.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

