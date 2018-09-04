package hbacak07.example.com.emlak.Data;

public class Musteri extends Kisi {

    String not;
    int tarih;

    public Musteri() {
        this.not = "not";
        this.tarih = 0;
    }

    public Musteri(int id, String ad, String soyad, String telefon, int durum, String not, int tarih) {
        super(id, ad, soyad, telefon, durum);
        this.not = not;
        this.tarih = tarih;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }

    public int getTarih() {
        return tarih;
    }

    public void setTarih(int tarih) {
        this.tarih = tarih;
    }
}
