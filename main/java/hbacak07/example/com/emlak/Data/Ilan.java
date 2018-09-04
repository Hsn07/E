package hbacak07.example.com.emlak.Data;

public class Ilan {
    int id;
    int personel_id;
    String Ad;
    String tur;
    String il;
    String ilce;
    int mxm;
    String ozellikler;
    int durum;
    int fiyat;

    public Ilan(int id, int personel_id, String ad, String tur, String il, String ilce, int mxm, String ozellikler,int fiyat ,int durum) {
        this.id = id;
        this.personel_id = personel_id;
        Ad = ad;
        this.tur = tur;
        this.il = il;
        this.ilce = ilce;
        this.mxm = mxm;
        this.ozellikler = ozellikler;
        this.durum = durum;
        this.fiyat = fiyat;
    }
    public Ilan() {
        this.id = 0;
        this.personel_id = 0;
        Ad = "Ad";
        this.tur = "Tür";
        this.il = "İl";
        this.ilce = "İlce";
        this.mxm = 0;
        this.ozellikler = "Özellikler";
        this.durum = 0;
        fiyat=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public int getMxm() {
        return mxm;
    }

    public void setMxm(int mxm) {
        this.mxm = mxm;
    }

    public String getOzellikler() {
        return ozellikler;
    }

    public void setOzellikler(String ozellikler) {
        this.ozellikler = ozellikler;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }
}
