package com.idinastoto.uts12141412;
import java.util.Scanner;
public class Uts12141412 {
     String nama;
    byte level = 1;
    byte peluang = 5, sisa;
    short tebak;
    short banyak=0;
    int acak, score=0;
    char jawab;
    int total = 0, x=0;
    int[] riwayat = new int[5];
    
    public int Level(){
        return level*100;
    }
    public void hasilTebakan(){
      sisa--;
      banyak++;
        System.out.println("Tebakan anda ? " + tebak);
        if (tebak<acak){
            System.out.print("Tebakan anda telalu kecil!");
        }
        if (tebak>acak){
            System.out.print("Tebakan anda telalu besar!");
        }
        if (tebak==acak){
            System.out.print("Selamat anda berhasil menebak sebanyak " + banyak + " kali tebakan");
        }
        if (sisa>0&&tebak!=acak){
            System.out.println("Kesempatan anda tinggal " + sisa + " kali lagi.");
        }
        if (sisa<=0) {
            System.out.println("Game Over");
        }
    }
    public void Score() {
        if (banyak>0){
            score= 100*level;
        }
        if (banyak>1){
            score= 70*level;
        }
        if (banyak>2){
            score= 50*level;
        }
        if (banyak>3){
            score= 30*level;
        }
        if (banyak>4){
            score= 0*level;
        }
        System.out.println();
        System.out.println(nama + "\t: " + score);
        total=total+score;
    }
    public void History(){
        riwayat[x]=total;
    }
    public void totalScore(){
        System.out.println("Total score yang anda dapat : " + total);
    }
    public void Reset(){
    level = 1;
    peluang = 5;
    banyak=0;
    total=0;
    }
    public static void main(String[] args) {
        Uts12141412 main = new Uts12141412();
        Scanner inputString = new Scanner(System.in);
        Scanner inputAngka = new Scanner(System.in);
        do{
        System.out.println("Masukan nama anda untuk memulai atau tekan 'T (besar)' utuk keluar.");
        main.nama=inputString.nextLine();
          if ("T".equals(main.nama)){
              break;
          }
          else{
            do {
            main.acak = (short) (Math.random()*main.Level());
            System.out.println("# Level " + main.level);
            System.out.println("Selamat Datang " + main.nama);
            System.out.println("Silakan tebak angka antara 1 s/d " + main.Level());
            System.out.println("Kesempatan Anda Tinggl " + main.peluang + " kali");
            main.sisa=main.peluang;
            do{
                System.out.println();
                System.out.println("Masukkan Tebakan Anda : ");
                main.tebak = inputAngka.nextShort();
                main.hasilTebakan();
            }while(main.tebak!=main.acak&&main.sisa>0);
            if (main.tebak==main.acak){
                main.Score();
                System.out.println("Apakah anda ingin melanjutkan ke level berikutnya ? (y/t)");
                main.jawab=inputString.nextLine().charAt(0);
                main.level++;
                main.banyak=0;
            }
            else {break;}
            }while(main.jawab=='y');
            main.totalScore();
            main.Reset();
          }
        }while(!"T".equals(main.nama));
    }    
}  