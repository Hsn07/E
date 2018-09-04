package hbacak07.example.com.emlak.Data;

public class Bilgi {
    int id;
    String isim;
    String aciklama;
    int fiyat;

    public Bilgi(int id, String isim, String aciklama, int fiyat) {
        this.id = id;
        this.isim = isim;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
