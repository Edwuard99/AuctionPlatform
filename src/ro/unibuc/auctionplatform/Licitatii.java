package ro.unibuc.auctionplatform;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Licitatii {
    @NotNull
    protected final String product;
    protected final Date date;
    protected final int startingBid;
    protected final int buyOut; //pretul cu care pot cumpara fara sa licitez
    protected final int id;
    private static int licitatiiCnt = 0;


    public Licitatii(@NotNull String product, Date date, int startingBid, int buyOut) {
        this.product = product;
        this.date = date;
        this.startingBid = startingBid;
        this.buyOut = buyOut;

        licitatiiCnt++;
        this.id = licitatiiCnt;
    }

    public String getProduct() {
        return product;
    }

    public Date getDate() {
        return date;
    }

    public int getStartingBid() {
        return startingBid;
    }

    public int getBuyOut() {
        return buyOut;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Licitatii{" +
                "product='" + product + '\'' +
                ", date=" + date +
                ", startingBid=" + startingBid +
                ", buyOut=" + buyOut +
                ", id=" + id +
                '}';
    }

    public String toString1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return  product + ", " + simpleDateFormat.format(date) + ", " + startingBid + ", " + buyOut;
    }
}
