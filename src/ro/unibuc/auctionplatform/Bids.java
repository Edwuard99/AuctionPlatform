package ro.unibuc.auctionplatform;


//bids vor fi  preturile care se liciteaza

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Bids extends Licitatii{
    public Bids(@NotNull String product, Date date, int startingBid, int buyOut) {
        super(product, date, startingBid, buyOut);
    }
}
