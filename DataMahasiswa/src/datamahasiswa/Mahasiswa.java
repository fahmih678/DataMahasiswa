/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.util.Date;

/**
 *
 * @author Fahmi Habibi
 */
public class Mahasiswa {
    String nimMahasiswa;
    String namaMahasiswa;
    String tanggal;
    String gender;
    
    Mahasiswa(String nim, String nama,String date ,int gen){
        this.nimMahasiswa = nim;
        this.namaMahasiswa = nama;
        this.tanggal= date;
        
        if (gen == 1){
            this.gender = "Laki-laki";
        }else if(gen == 2){
            this.gender = "Perempuan";
        }
    }
    
    void print(){
        System.out.println("NIM         : " + this.nimMahasiswa);
        System.out.println("Nama        : " + this.namaMahasiswa);
        System.out.println("Tgl Lahir   : " + this.tanggal);
        System.out.println("Kelamin     : " + this.gender);
        System.out.println("---------------------------------");

    }
}
