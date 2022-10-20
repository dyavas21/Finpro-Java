package src;

import java.io.*;
import java.util.*;
import java.util.Random.*;

import static java.rmi.Naming.list;


public class main {
    public static void main(String[] args) throws Exception{
        File file = new File("output.txt");
        ArrayList<Perjalanan> Perjalananlist = new ArrayList<Perjalanan>();
        ObjectOutputStream oos =  null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            Perjalananlist = (ArrayList<Perjalanan>)ois.readObject();
            ois.close();
        }

//Customer
        File fileCustomer = new File("customer.txt");
        ArrayList<Customer> Customerlist = new ArrayList<Customer>();
        ObjectOutputStream oosC =  null;
        ObjectInputStream oisC = null;

        if (fileCustomer.isFile()){
            oisC = new ObjectInputStream(new FileInputStream(fileCustomer));
            Customerlist = (ArrayList<Customer>)oisC.readObject();
            oisC.close();
        }

        //Boarding
        File fileBoarding = new File("boarding.txt");
        ArrayList<Boarding> BoardingList = new ArrayList<Boarding>();
        ObjectOutputStream oosb =  null;
        ObjectInputStream oisb = null;

        if (fileBoarding.isFile()){
            oisb = new ObjectInputStream(new FileInputStream(fileBoarding));
            BoardingList = (ArrayList<Boarding>)oisb.readObject();
            oisb.close();
        }

        Scanner forInt = new Scanner(System.in);
        Scanner forStr = new Scanner(System.in);
        int chooseRole = -1;
        Random random = new Random();

        do {
            System.out.println("\n\n1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose role: ");
            chooseRole = forInt.nextInt();

            switch (chooseRole){
                case 1:
                    int chooseAdmin = -1;
                    do {
                        System.out.println("\n\n1. Lihat Rute Perjalanan");
                        System.out.println("2. Tambah Rute Perjalanan");
                        System.out.println("3. Hapus Perjalanan");
                        System.out.println("4. Exit");
                        System.out.print("Pilihan : ");
                        chooseAdmin = forInt.nextInt();

                        switch (chooseAdmin){
                            case 1:
                                System.out.println("+=====================================================================================================================================================================================+");
                                System.out.println("+ No. |\t\t\tRute Perjalanan\t\t\t|\tNama Kereta Api\t|\tStasiun Keberangkatan\t|\tStasiun Kedatangan\t|\tKelas Kereta Api\t|\tJumlah Tiket Tersedia\t|\tHarga Tiket  +");
                                System.out.println("+=====================================================================================================================================================================================+");
                                if (Perjalananlist.isEmpty()){
                                    System.out.println("empty");
                                }else {
                                    int i = 0;
                                    while (i < Perjalananlist.size()){
                                        Perjalananlist.get(i).showPerjalanan();
                                        i++;
                                    }
                                }
                                break;

                            case 2 :
                                int noKereta;
                                do {
                                    System.out.print("Masukkan no kereta: ");
                                    noKereta = forInt.nextInt();
                                }while (noKereta == (int) noKereta);



                                System.out.print("Masukkan rute perjalanan: ");
                                String rute = forStr.nextLine();

                                System.out.print("Nama Kereta Api: ");
                                String namaKereta = forStr.nextLine();

                                System.out.print("Stasiun Keberangkatan: ");
                                String sBerangkat = forStr.nextLine();

                                System.out.print("Stasiun Kedatangan: ");
                                String sDatang = forStr.nextLine();

                                System.out.print("Kelas Kereta Api: ");
                                String jenTiket = forStr.nextLine();

                                System.out.print("Harga Tiket: ");
                                int hargaTiket = forInt.nextInt();


                                System.out.print("Jumlah Tiket Tersedia: ");
                                int jumTiket = forInt.nextInt();

                                Perjalananlist.add(new Perjalanan(noKereta, rute, namaKereta, sBerangkat, sDatang, jenTiket, jumTiket, hargaTiket));
                                oos = new ObjectOutputStream(new FileOutputStream(file));
                                oos.writeObject(Perjalananlist);
                                oos.close();
                                break;

                            case 3 :
                                if(file.isFile()){
                                    ois = new ObjectInputStream(new FileInputStream(file));
                                    Perjalananlist = (ArrayList<Perjalanan>)ois.readObject();
                                    ois.close();

                                    boolean found = false;
                                    System.out.print("No kereta ke berapa yang ingin di hapus dari 1 - " + Perjalananlist.size() + " : ");
                                    int deleteNoKereta = forInt.nextInt();
                                    li = Perjalananlist.listIterator();
                                    while (li.hasNext()){
                                        Perjalanan b = (Perjalanan)li.next();
                                        if (b.getNoKereta() == deleteNoKereta){
                                            li.remove();
                                            found = true;
                                        }
                                    }if (!found)
                                        System.out.println("Data tidak ditemukan..!");
                                    else{
                                        oos = new ObjectOutputStream(new FileOutputStream(file));
                                        oos.writeObject(Perjalananlist);
                                        oos.close();
                                        System.out.println("Delete berhasil....!");
                                    }

                                }else {
                                    System.out.println("File tidak ada....!");
                                }
                                break;

                            case 4 :

                                break;

                            case 5:
                                break;
                        }
                    }while (chooseAdmin!=4);
                    break;

                case 2 :

                    int chooseUser2 = -1;
                    do {
                        String namaCheck = null;
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Exit");
                        System.out.print("Pilihan: ");
                        int pilihan = forInt.nextInt();
                        switch (pilihan){
                            case 1:
                                System.out.print("Input nama: ");
                                String nama = forStr.nextLine();

                                System.out.print("Input password: ");
                                String password = forStr.nextLine();

                                System.out.print("Input NIK: ");
                                long nik = forInt.nextLong();

                                System.out.print("input kota asal: ");
                                String alamat = forStr.nextLine();

                                Customerlist.add(new Customer(nama, password, alamat, nik, 0, 0, 0, null));
                                oosC = new ObjectOutputStream(new FileOutputStream(fileCustomer));
                                oosC.writeObject(Customerlist);
                                oosC.close();
                                break;

                            case 2:
                                boolean found = false;
                                do {
                                    System.out.print("nama: ");
                                    String namaLog = forStr.nextLine();
                                    System.out.print("password: ");
                                    String passLog = forStr.nextLine();
                                    li = Customerlist.listIterator();
                                    while (li.hasNext()){
                                        Customer a = (Customer)li.next();
                                        if (a.getNama().contains(namaLog) && a.getPassword().contains(passLog)){
                                            namaCheck = a.getNama();
                                            found = true;
                                        }
                                    }if(!found){
                                        System.out.println("Nama atau password salah!");
                                    }
                                }while (found == false);
                                int chooseUser = -1;
                                do {
                                    System.out.println("\n\n1. Order Tiket");
                                    System.out.println("2. Show Info");
                                    System.out.println("3. Check in");
                                    System.out.println("4. Cetak Boarding Pass");
                                    System.out.println("5. Logout");
                                    System.out.print("Pilihan : ");
                                    chooseUser = forInt.nextInt();
                                    switch (chooseUser){
                                        case 1:
                                            System.out.println("+==================================================================================================================================================================================+");
                                            System.out.println("+ No. |\t\t\tRute Perjalanan\t\t\t|\tNama Kereta Api\t|\tStasius Keberangkatan\t|\tStasius Kedatangan\t|\tKelas Kereta Api\t|\tHarga Tiket\t|\tJumlah Tiket Tersedia  +");
                                            System.out.println("+==================================================================================================================================================================================+");
                                            if (Perjalananlist.isEmpty()){
                                                System.out.println("empty");
                                            }else {
                                                int i = 0;
                                                while (i < Perjalananlist.size()){
                                                    Perjalananlist.get(i).showPerjalanan();
                                                    i++;
                                                }
                                            }
                                            System.out.println("+==================================================================================================================================================================================+");
                                            System.out.print("\n\nPilih Tiket mana yang ingin dibeli: ");
                                            int pilihTiket = forInt.nextInt();
                                            li = Perjalananlist.listIterator();
                                            while (li.hasNext()){
                                                Perjalanan a = (Perjalanan)li.next();
                                                if (a.getNoKereta() == pilihTiket){
                                                    int totalTiket = a.getJumTiket() - 1;
                                                    a.setJumTiket(totalTiket);
                                                }
                                            }
                                            oos = new ObjectOutputStream(new FileOutputStream(file));
                                            oos.writeObject(Perjalananlist);
                                            oos.close();

                                            li = Perjalananlist.listIterator();
                                            while (li.hasNext()){
                                                Perjalanan a = (Perjalanan)li.next();
                                                li = Customerlist.listIterator();
                                                while (li.hasNext()){
                                                    Customer b = (Customer)li.next();
                                                    if (b.getNama().contains(namaCheck)){
                                                        int tiketCust = b.getQtyTicket() + 1;
                                                        b.setQtyTicket(tiketCust);
                                                        String rute = Perjalananlist.get(pilihTiket-1).getRute();
                                                        b.setRute(rute);
                                                        int x = random.nextInt(900) + 100;
                                                        int bookNumber = b.getBookNumber() + x;
                                                        b.setBookNumber(bookNumber);
                                                    }
                                                }
                                            }

                                            oosC = new ObjectOutputStream(new FileOutputStream(fileCustomer));
                                            oosC.writeObject(Customerlist);
                                            oosC.close();
                                            break;

                                        case 2:
                                            System.out.println("+===============================================================================================================+");
                                            System.out.println("+ Nama  |\tAlamat\t|\t\tNIK\t\t|\tTiket yang dimiliki\t|\tBook Number\t|\tSeat Number\t|\t\tRute\t\t+");
                                            System.out.println("+===============================================================================================================+");
                                            if (Customerlist.isEmpty()){
                                                System.out.println("empty");
                                                System.out.println("+===============================================================================================================+");
                                            }else {
                                                li = Customerlist.listIterator();
                                                while (li.hasNext()){
                                                    Customer b = (Customer)li.next();
                                                    if(b.getNama().equals(namaCheck)){
                                                            b.showCustomer();
                                                    }
                                                }
                                                System.out.println("+===============================================================================================================+");
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Silahkan checkin tiket yang sudah kamu beli");
                                            System.out.print("Input booking ID: ");
                                            int bookID = forInt.nextInt();
                                            li = Customerlist.listIterator();
                                            while (li.hasNext()){
                                                Customer b = (Customer)li.next();
                                                if (b.getBookNumber() == (bookID) && b.getNama().equals(namaCheck)){
                                                    li = Perjalananlist.listIterator();
                                                    while (li.hasNext()){
                                                        Perjalanan a = (Perjalanan)li.next();
                                                        if(a.getRute().contains(b.getRute())){
                                                            System.out.println("Harga tiket yang harus dibayar: " + a.getHargaTiket());
                                                            System.out.print("Tekan Y untuk bayar: ");
                                                            String bayar = forStr.next();
                                                            if (bayar.equals("y")){
                                                                int x = random.nextInt(99) + 10;
                                                                int seatNumber = b.getSeatNumber() + x;
                                                                b.setSeatNumber(seatNumber);
                                                            }else {
                                                                System.out.println("gagal");
                                                            }
                                                        }
                                                    }
                                                }else {
//                                                    System.out.println("salah");
                                                }
                                                oosC = new ObjectOutputStream(new FileOutputStream(fileCustomer));
                                                oosC.writeObject(Customerlist);
                                                oosC.close();
                                            }
                                            break;
                                        case 4:
                                            li = Perjalananlist.listIterator();
                                            BoardingList.add(new Boarding(null, null, 0, 0));
                                            while (li.hasNext()){
                                                Perjalanan a = (Perjalanan)li.next();
                                                int noKeretaFinal = a.getNoKereta();
                                                String ruteFinal = a.getRute();
                                                li = Customerlist.listIterator();
                                                while (li.hasNext()){
                                                    Customer b = (Customer)li.next();
                                                    if (b.getNama().contains(namaCheck)){
                                                        String namaFinal = b.getNama();
                                                        int seatFinal = b.getSeatNumber();
                                                        li = BoardingList.listIterator();
                                                        while (li.hasNext()){
                                                            Boarding c = (Boarding)li.next();
                                                            c.setNama(namaFinal);
                                                            c.setSeatNumber(seatFinal);
                                                            c.setNoKereta(noKeretaFinal);
                                                            c.setRute(ruteFinal);
                                                        }
                                                    }
                                                }
                                            }
                                            BoardingList.get(0).showBoarding();
                                            oosb = new ObjectOutputStream(new FileOutputStream(fileBoarding));
                                            oosb.writeObject(BoardingList);
                                            oosb.close();
                                            break;
                                        case 5:
                                            break;
                                    }
                                }while (chooseUser!=5);
                                break;
                        }
                        break;
                    }while (chooseUser2!=3);

                case 3:
                    break;
            }
        }while (chooseRole!=3);
    }
}