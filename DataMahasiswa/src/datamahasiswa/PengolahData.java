/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;  


/**
 *
 * @author Fahmi Habibi
 */
public class PengolahData {
   ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>();
   Scanner input = new Scanner(System.in);
   
   String nim;
   String nama;
   int gen;
   int option;
    
   void tampilanMenu() throws ParseException{
       boolean menu = true;

       while(menu){
           System.out.println(">>>>>>><<<<<<<");
           System.out.println("Data Mahasiswa");
           System.out.println("^^^^^^^^^^^^^^");
           System.out.println("Menu : ");
           System.out.println("1. Tambah Data");
           System.out.println("2. Hapus Data");
           System.out.println("3. Cari Data");
           System.out.println("4. Tampilkan Data");
           System.out.println("5. Keluar");
           System.out.print("Pilihan Menu : ");
           this.option = input.nextInt();
           input.nextLine();
           switch(option){
               case 1:
                   char case1 = 'y';
                   while(case1 == 'y'){
                       tambahMahasiswa();
                       System.out.println("-----");
                       System.out.print("Tambah data lagi (y/n) : ");
                       case1 = input.next().charAt(0);
                       System.out.println("-----");
                   }
                   break;
               case 2:
                   hapusDataMahasiswa();
                   break;
               case 3:
                   cariDataMahasiswa();
                   break;
               case 4:
                   tampilData();
                   break;
               case 5:
                   menu = false;
                   break;
               default:
                   System.out.println("XXX Menu yang anda pilih tidak ada XXX");
           }
       }
   }
   
   // Menambah Data Mahasiswa
   void tambahMahasiswa() throws ParseException{
       String a = "n";
       String tgl, bln, thn;
       String date;

       input.nextLine();
       System.out.println(">>Masukkan Data Mahasiswa<<");
       System.out.print("Masukkan NIM   : ");
       this.nim = input.nextLine();
       System.out.print("Masukkan Nama  : ");
       this.nama = input.nextLine();
       System.out.println("Tanggal Lahir (Masukan Angka)");
       System.out.print(">> Tanggal : ");
       tgl = input.nextLine();
       System.out.print(">> Bulan   : ");
       bln = input.nextLine();
       System.out.print(">> Tahun   : ");
       thn = input.nextLine();
       System.out.print("1. Laki-laki/2. Perempuan : ");
       gen = input.nextInt();
       
       // Date Converter
       date = tgl+"-"+bln+"-"+thn;
       Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
       SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
       date = format.format(date1);

       this.dataMahasiswa.add(new Mahasiswa(nim,nama, date, gen));
   }
   
   // Menghapus Data Mahasiswa
   void hapusDataMahasiswa(){
       boolean ditemukan = false;
       int index = -1;
       
       System.out.println("");
       System.out.print("NIM mahasiswa yang ingin di hapus : ");
       this.nim = input.nextLine();
       System.out.println("...");
       
       for(int i=0; i<this.dataMahasiswa.size(); i++){
           if (this.dataMahasiswa.get(i).nimMahasiswa.equals(nim)){
               index = i;
               ditemukan = true;
           }
       }
       if (ditemukan == true){
           this.dataMahasiswa.removeIf(item -> item.nimMahasiswa.equals(nim));
           System.out.println("[Data Mahasiswa dengan NIM " + nim + " berhasil dihapus]");
       }else {
           System.out.println("______________XXX_______________");
           System.out.println("[Data Mahasiswa tidak ditemukan]");
           System.out.println("             |v-v|              ");
       }
       System.out.println("");
       
   }
   
   // Mencari Data Mahasiswa
   void cariDataMahasiswa(){
       boolean ditemukan = false;
       int index = -1;
       String gend = null;
       
       System.out.println("");
       System.out.println("Cari Data Mahasiswa");
       System.out.println("1. Berdasarkan NIM");
       System.out.println("2. Berdasarkan Gender");
       System.out.print("Pilihan : ");
       this.option = input.nextInt();
       input.nextLine();

       switch (option) {
           case 1:
               System.out.print("Masukkan NIM : ");
               this.nim = input.nextLine();
               System.out.println("...");

               for(int i=0; i<this.dataMahasiswa.size(); i++){
                   if (this.dataMahasiswa.get(i).nimMahasiswa.equals(nim)){
                       index = i;
                       ditemukan = true;
                   }
               }
               if (ditemukan == true){
                   this.dataMahasiswa.get(index).print();
               } else {
                   System.out.println("______________XXX_______________");
                   System.out.println("[Data Mahasiswa tidak ditemukan]");
                   System.out.println("             |v-v|              ");
               }
               break;
           case 2:
               System.out.println("1. Laki-laki");
               System.out.println("2. Perempuan");
               System.out.print("Masukkan filter : ");
               this.gen = input.nextInt();
               System.out.println("...");
               
               if (gen == 1){
                    gend = "Laki-laki";
               }else if(gen == 2){
                    gend = "Perempuan";
               }else{
                   System.out.println("Maaf menu tidak ada");
               }
               
               for(int i=0; i<this.dataMahasiswa.size(); i++){
                   if (this.dataMahasiswa.get(i).gender.equals(gend)){
                       index = i;
                       dataMahasiswa.get(index).print();
                       ditemukan = true;
                   }
               }
               if (ditemukan == false){
                   System.out.println("______________XXX_______________");
                   System.out.println("[Data Mahasiswa tidak ditemukan]");
                   System.out.println("             |v-v|              ");
               }
                break;    
           default:
               System.out.println("_________XXX__________");
               System.out.println("Maaf pilihan tidak ada");
               System.out.println("         ^^^          ");
       }
   }
   
   // Menampilkan Data
   void tampilData(){
       int index = 0;
       System.out.println("-------------------------------");
       if (this.dataMahasiswa.isEmpty()){
           System.out.println("____________000______________");
           System.out.println("    Data Mahasiswa Kosong    ");
           System.out.println("            ---              ");
       } else{
           for(Mahasiswa item: this.dataMahasiswa){
                System.out.println("Mahasiswa nomer "+(index+1));
                item.print();
                index++;
           }
           System.out.println("Jumlah Mahasiswa yang terdaftar = "+ index);
       }
   }
   
}