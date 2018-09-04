package hbacak07.example.com.emlak.Data;

public class Personel extends Kisi {


    int rutbe;
    String kullanici_adi;
    String sifre;

    public Personel(int id, String ad, String soyad, String telefon, int durum, int rutbe, String kullanici_adi, String sifre) {
        super(id, ad, soyad, telefon, durum);
        this.rutbe = rutbe;
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
    }

    public Personel() {
        this.rutbe = 0;
        this.kullanici_adi = "kullanici_adi";
        this.sifre = "sifre";
    }

    public int getRutbe() {
        return rutbe;
    }

    public void setRutbe(int rutbe) {
        this.rutbe = rutbe;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
