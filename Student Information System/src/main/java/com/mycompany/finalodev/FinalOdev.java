package com.mycompany.finalodev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class FinalOdev {

public static void main(String[] args) throws IOException {
         Scanner giris = new Scanner(System.in); 
         int secim;  
  
        do {
            
            System.out.println("[1] Bilgi Gir");
            System.out.println("[2] Ogrenci Arama");
            System.out.println("[3] Ogrenci Silme");
            System.out.println("[4] Cikis");
            System.out.print("Secim Yapiniz: ");
            secim = giris.nextInt();
            giris.nextLine(); 
            
            switch(secim) {
                case 1:
                    bilgiGir();
                    break;
                case 2:
                    ogrenciAra();
                    break;               
                case 3:
                    ogrenciSil();
                    break;
                case 4:
                    System.out.println("Program Sonlandirildi.");
                    break;
                default:
                    System.out.println("Gecersiz secim, lutfen tekrar deneyiniz.");
            }
        } while (secim != 4);
        
        giris.close();
    }
  

public static void bilgiGir() throws IOException {
        FileWriter yazici=new FileWriter("OgrenciListe.txt",true);
        BufferedReader bfr=new BufferedReader(new FileReader("OgrenciListe.txt"));
        Scanner bilgiGiris = new Scanner(System.in);
        

        System.out.println("Ogrenci Adi Girin: ");
        String ad=bilgiGiris.nextLine();
        yazici.write(ad+" ");
        
        System.out.println("Ogrenci Soyadi Girin: ");
        String soyad=bilgiGiris.nextLine();
        yazici.write(soyad+" ");
        
        System.out.println("Ogrenci Sinif Girin(1,2,3..) Gibi: ");
        int snf=bilgiGiris.nextInt();
        String sinifNo=String.valueOf(snf);
        yazici.write(sinifNo+" ");
        
        System.out.println("Ogrenci Cinsiyer Girin(E/K) Gibi: ");
        String Cinsiyet=bilgiGiris.next();
        yazici.write(Cinsiyet+" ");
        
        System.out.println("Ogrenci Numarasi Girin(1111,2222,...) Gibi: ");
        int no=bilgiGiris.nextInt();
        String numara=String.valueOf(no);
        
        String satir;
        boolean kelimeVarMi=false;
        while ((satir = bfr.readLine()) != null) {
                if (satir.contains(numara)) {
                    kelimeVarMi = true;
                    break;
                }
            }
        
        if(kelimeVarMi){
            System.out.println("Bu Numara Baskasina Ait ! Tekrar Giriniz ");
            
        }
        else{
            yazici.write(numara+"\n");
        }   
        yazici.close();  
    }


public static void ogrenciAra() throws FileNotFoundException, IOException {
      Scanner giris=new Scanner(System.in);
      BufferedReader bfr=new BufferedReader(new FileReader("OgrenciListe.txt"));
      int ArananNo,ArananSnf;

      System.out.println("Aranan Ogrencinin Sinifini Girin: ");
      ArananSnf=giris.nextInt();
      
      System.out.println("Aranan Ogrencinin 4 Haneli Numarasini Girin: ");
      ArananNo=giris.nextInt();
      
      String ArananNumara=String.valueOf(ArananNo);
      String ArananSinif=String.valueOf(ArananSnf);
    
      String satir;
      
      boolean NumaraVarMi=false;
      boolean SinifVarMi=false;
        
        while ((satir = bfr.readLine()) != null) {
                 
                String[] Dizi=satir.split(" ");
                if(Dizi[2].equals(ArananSinif) && Dizi[4].equals(ArananNumara)){
                    NumaraVarMi=true;
                    SinifVarMi=true;
                }
                
            } 
                if(NumaraVarMi && SinifVarMi){
                System.out.println("Aranan Ogrenci Siniftadir");
                }
                else{
                System.out.println("Aranan Ogrenci Bulunamadi.");
                } 
        
}


public static void ogrenciSil() throws FileNotFoundException, IOException {
        Scanner giris=new Scanner(System.in);
        BufferedReader bfr = new BufferedReader(new FileReader("OgrenciListe.txt"));
        BufferedWriter bfw =new BufferedWriter(new FileWriter("OgrenciListeYeni.txt"));
        File Silinenler=new File("OgrenciListeYeni.txt");
        String DosyaAdi="OgrenciListe.txt";
        
        System.out.println("Lutfen Silinecek Ogrenci Numarasi Girin: ");
        String SilinecekNo=giris.nextLine();
        
        String satir;
            while ((satir = bfr.readLine()) != null) {
               if (!satir.contains(SilinecekNo)) {
                    bfw.write(satir + "\n");
                }
               }
            bfr.close();
            bfw.close();

            if (!new File("OgrenciListe.txt").delete()) {
            }

            
            if (!(Silinenler).renameTo(new File("OgrenciListe.txt"))) {
            }

            System.out.println("'" + SilinecekNo + "' numarali ogrenci '" + DosyaAdi + 
                    "' dosyasindan silindi.Guncel Liste Olusturuldu Lutfen Kontrol Edin !!! ");
            }



}