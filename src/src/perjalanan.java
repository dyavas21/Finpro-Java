package src;

import java.io.Serializable;

class Perjalanan implements Serializable {

    private String rute, namaKereta, sBerangkat, sDatang, jenTiket;
    private int hargaTiket, jumTiket, noKereta;

    public int getNoKereta() {
        return noKereta;
    }

    public void setNoKereta(int noKereta) {
        this.noKereta = noKereta;
    }

    Perjalanan (int noKereta, String rute, String namaKereta, String sBerangkat, String sDatang, String jenTiket, int jumTiket, int hargaTiket){
        this.noKereta = noKereta;
        this.rute = rute;
        this.namaKereta = namaKereta;
        this.sBerangkat = sBerangkat;
        this.sDatang = sDatang;
        this.jenTiket = jenTiket;
        this.jumTiket = jumTiket;
        this.hargaTiket = hargaTiket;

    }

     public void showPerjalanan (){
         System.out.print("   " + this.noKereta + "\t\t\t" + this.rute + "\t\t\t\t" + this.namaKereta + "\t\t\t\t" +
                 this.sBerangkat + "\t\t\t\t\t\t" + this.sDatang + "\t\t\t\t\t" + this.jenTiket +
                 "\t\t\t\t\t\t" + this.jumTiket + "\t\t\t\t\t\t" + this.hargaTiket + "\n\n");
     }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    public String getsBerangkat() {
        return sBerangkat;
    }

    public void setsBerangkat(String sBerangkat) {
        this.sBerangkat = sBerangkat;
    }

    public String getsDatang() {
        return sDatang;
    }

    public void setsDatang(String sDatang) {
        this.sDatang = sDatang;
    }

    public String getJenTiket() {
        return jenTiket;
    }

    public void setJenTiket(String jenTiket) {
        this.jenTiket = jenTiket;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(int hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    public int getJumTiket() {
        return jumTiket;
    }

    public void setJumTiket(int jumTiket) {
        this.jumTiket = jumTiket;
    }


}

