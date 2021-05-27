package ro.unibuc.auctionplatform;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Utilizatori {

    @NotNull
    protected final int id;
    protected String userName;
    protected String adress;
    protected String phoneNumber;
    protected Date birthday;
    private static int utilizatoriCnt = 0;

    public Utilizatori(int id) {
        this.id = id;
    }


    public Utilizatori(@NotNull String userName, String adress, Date birthday, String phoneNumber) {
        this.userName = userName;
        this.adress = adress;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        utilizatoriCnt++;
        this.id = utilizatoriCnt;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getAdress() {
        return adress;
    }

    public int getId() {
        return id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Utilizatori{" +
                "userName='" + userName + '\'' +
                ", adress='" + adress + '\'' +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String toString1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return userName + ", " + adress + ", " + phoneNumber + ", " + simpleDateFormat.format(birthday);
    }

    public static void setDataNasterii(java.sql.Date date) {
    }
}
