package src;

import java.io.Serializable;

class Boarding implements Serializable {

    private String nama, rute;
    private int seatNumber, noKereta;

    Boarding (String nama, String rute, int seatNumber, int noKereta){
        this.nama = nama;
        this.rute = rute;
        this.seatNumber = seatNumber;
        this.noKereta = noKereta;
    }

    public void showBoarding (){
        System.out.println("+=======================================================================+");
        System.out.println("|  No  |\t\tNama\t\t|\t\tSeat Number\t\t|\t\tRute\t\t| ");
        System.out.println("+=======================================================================+");
        System.out.print("   " + this.noKereta + "\t\t\t" + this.nama + "\t\t\t\t\t" + this.seatNumber + "\t\t\t\t" +
                this.rute );
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getNoKereta() {
        return noKereta;
    }

    public void setNoKereta(int noKereta) {
        this.noKereta = noKereta;
    }
}


