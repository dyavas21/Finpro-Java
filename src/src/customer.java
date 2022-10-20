package src;
import java.io.*;


class Customer implements Serializable {
    private String nama, alamat, password, username, rute;
    private long nik;

    private int qtyTicket, bookNumber, seatNumber;

    public int getQtyTicket() {
        return qtyTicket;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void setQtyTicket(int qtyTicket) {
        this.qtyTicket = qtyTicket;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    Customer (String nama, String password, String alamat, long nik, int qtyTicket, int bookNumber, int seatNumber, String rute){
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.nik = nik;
        this.qtyTicket = qtyTicket;
        this.bookNumber = bookNumber;
        this.seatNumber = seatNumber;
        this.rute = rute;
    }

    public void showCustomer (){
        System.out.print("  " + this.nama + "\t\t" + this.alamat + "\t\t\t" + this.nik + "\t\t\t\t" + this.qtyTicket +
                "\t\t\t\t\t" + this.bookNumber + "\t\t\t\t" + this.seatNumber + "\t\t\t" + this.rute +  "\n\n");
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getAlamat() {
        return alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getNik() {
        return nik;
    }

    public void setNik(long nik) {
        this.nik = nik;
    }
}

