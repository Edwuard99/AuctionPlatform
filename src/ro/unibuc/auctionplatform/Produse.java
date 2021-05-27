package ro.unibuc.auctionplatform;

import org.jetbrains.annotations.NotNull;

public class Produse {
    @NotNull
    protected final int id;
    protected String numeProduse;
    protected String descriere;
    private static int produseCnt = 0;

    public Produse(String numeProduse, String descriere) {
        this.numeProduse = numeProduse;
        this.descriere = descriere;
        produseCnt++;
        this.id = produseCnt;
    }

    public int getId() {
        return id;
    }

    public String getNumeProduse() {
        return numeProduse;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setNumeProduse(String numeProduse) {
        this.numeProduse = numeProduse;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Produse{" +
                "id=" + id +
                ", numeProduse='" + numeProduse + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }

    public String toString1() {
        return numeProduse + ", " + descriere;
    }
}
