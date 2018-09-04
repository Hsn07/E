package hbacak07.example.com.emlak.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Emlak";
    private static final int DATABASE_VERSION=1;

    public DataBase(Context context) {//, String name, SQLiteDatabase.CursorFactory factory, int version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ILANLISTESI="CREATE TABLE ilan("+"id INTEGER , " +
                "perid INTEGER , " +
                "ad VARCHAR , " +
                "tur VARCHAR , " +
                "il VARCHAR , " +
                "ilce VARCHAR , " +
                "uzunluk INTEGER , " +
                "ozellikler VARCHAR , " +
                "durum INTEGER , " +
                "fiyat INTEGER)";
        db.execSQL(CREATE_ILANLISTESI);
        String CREATE_PERSONELLISTESI="CREATE TABLE personel("+"id INTEGER , " +
                "ad VARCHAR , " +
                "soyad VARCHAR , " +
                "telefon VARCHAR , " +
                "rutbe INTEGER , " +
                "kisaisim VARCHAR , " +
                "sifre VARCHAR , " +
                "durum INTEGER  )";
        db.execSQL(CREATE_PERSONELLISTESI);
        String CREATE_MUSTERILISTESI="CREATE TABLE musteri("+"id INTEGER , " +
                "ad VARCHAR , " +
                "soyad VARCHAR , " +
                "telefon VARCHAR , " +
                "bilgi VARCHAR , " +
                "tarih INTEGER , " +
                "durum INTEGER  )";
        db.execSQL(CREATE_MUSTERILISTESI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS ilan");
        db.execSQL("DROP TABLE IF EXISTS personel");
        db.execSQL("DROP TABLE IF EXISTS musteri");
        onCreate(db);
    }
    //-------------------> İlan İşlemleri <-----------------

    public void yeni_ilan(Ilan ilan){
        SQLiteDatabase db=this.getWritableDatabase();
        String INSERT_ILAN_SQL="INSERT INTO ilan(id,perid,ad,tur,il,ilce,uzunluk,ozellikler,durum,fiyat)"+
                "VALUES ('"+ilan.getId()+"','"+ilan.getPersonel_id()+"','"+ilan.getAd()+"','"+ilan.getTur()+"','"+ilan.getIl()+"','"+ilan.getIlce()+"','"+ilan.getMxm()+"','"+ilan.getOzellikler()+"','"+ilan.getDurum()+"','"+ilan.getFiyat()+"')";
        db.execSQL(INSERT_ILAN_SQL);
        db.close();

    }

    public ArrayList<Ilan> ilan_getir(){
        SQLiteDatabase db=this.getWritableDatabase();

        String SELECT_ILAN="SELECT * FROM ilan ";//id,perid,ad,tur,il,ilce,uzunluk,ozellikler,durum
        Cursor cursor=db.rawQuery(SELECT_ILAN,null);

        ArrayList<Ilan> ilan_listesi=new ArrayList<Ilan>();

        if (cursor!=null){
            cursor.moveToFirst();
            do{
                Ilan ilan=new Ilan();
                ilan.setId(cursor.getInt(0));
                ilan.setPersonel_id(cursor.getInt(1));
                ilan.setAd(cursor.getString(2));
                ilan.setTur(cursor.getString(3));
                ilan.setIl(cursor.getString(4));
                ilan.setIlce(cursor.getString(5));
                ilan.setMxm(cursor.getInt(6));
                ilan.setOzellikler(cursor.getString(7));
                ilan.setDurum(cursor.getInt(8));
                ilan.setFiyat(cursor.getInt(9));

                ilan_listesi.add(ilan);

            }while (cursor.moveToNext());
        }
        return ilan_listesi;
    }

    public void ilan_sil(){
        SQLiteDatabase db=this.getWritableDatabase();


    }

    //-----------------------> Müşteri İşlemleri<----------------------

    public void yeni_Musteri(Musteri musteri){
        SQLiteDatabase db=this.getWritableDatabase();
        String INSERT_MUSTERI_SQL="INSERT INTO musteri(id,ad,soyad,telefon,bilgi,tarih,durum)"+
                "VALUES ('"+musteri.getId()+"','"+musteri.getAd()+"','"+musteri.getSoyad()+"','"+musteri.getTelefon()+"','"+musteri.getNot()+"','"+musteri.getTarih()+"','"+0+"')";
        db.execSQL(INSERT_MUSTERI_SQL);
        db.close();

    }

    public ArrayList<Musteri> musteri_getir(){
        SQLiteDatabase db=this.getWritableDatabase();

        String SELECT_MUSTERI="SELECT * FROM musteri ";//id,perid,ad,tur,il,ilce,uzunluk,ozellikler,durum
        Cursor cursor=db.rawQuery(SELECT_MUSTERI,null);

        ArrayList<Musteri> musteri_listesi=new ArrayList<Musteri>();

        if (cursor!=null){
            cursor.moveToFirst();
            do{
                Musteri musteri=new Musteri();
                musteri.setId(cursor.getInt(0));
                musteri.setAd(cursor.getString(1));
                musteri.setSoyad(cursor.getString(2));
                musteri.setTelefon(cursor.getString(3));
                musteri.setNot(cursor.getString(4));
                musteri.setTarih(cursor.getInt(5));
                musteri.setDurum(cursor.getInt(6));

                musteri_listesi.add(musteri);

            }while (cursor.moveToNext());
        }
        return musteri_listesi;
    }

    public void musteri_sil(){
        SQLiteDatabase db=this.getWritableDatabase();


    }

    //----------------------> Kişi İşlemleri <----------------------------

    public void yeni_personel(Personel personel){
        SQLiteDatabase db=this.getWritableDatabase();
        String INSERT_PERSONEL_SQL="INSERT INTO personel(id,ad,soyad,telefon,rutbe,kisaisim,sifre,durum)"+
                "VALUES ('"+personel.getId()+"','"+personel.getAd()+"','"+personel.getSoyad()+"','"+personel.getTelefon()+"','"+personel.getRutbe()+"','"+personel.getKullanici_adi()+"','"+personel.getSifre()+"','"+0+"')";
        db.execSQL(INSERT_PERSONEL_SQL);
        db.close();

    }

    public ArrayList<Personel> personel_getir(){
        SQLiteDatabase db=this.getWritableDatabase();

        String SELECT_PERSONEL="SELECT * FROM personel ";//id,perid,ad,tur,il,ilce,uzunluk,ozellikler,durum
        Cursor cursor=db.rawQuery(SELECT_PERSONEL,null);

        ArrayList<Personel> personel_listesi=new ArrayList<Personel>();

        if (cursor!=null){
            cursor.moveToFirst();
            do{
                Personel personel=new Personel();
                personel.setId(cursor.getInt(0));
                personel.setAd(cursor.getString(1));
                personel.setSoyad(cursor.getString(2));
                personel.setTelefon(cursor.getString(3));
                personel.setRutbe(cursor.getInt(4));
                personel.setKullanici_adi(cursor.getString(5));
                personel.setSifre(cursor.getString(6));
                personel.setDurum(cursor.getInt(7));

                personel_listesi.add(personel);

            }while (cursor.moveToNext());
        }
        return personel_listesi;
    }

    public void personel_sil(){
        SQLiteDatabase db=this.getWritableDatabase();


    }

    //////////////////////////////////////////////////

    /*
    public void talebegüncelle(GTalebe gtalebe){
        SQLiteDatabase db=this.getWritableDatabase();

        String UPPDATE_TALEBE="UPDATE Talebelistesi SET adet = " + gtalebe.getAdet() + " WHERE id = " +gtalebe.getId();

            db.execSQL(UPPDATE_TALEBE);

        db.close();

    }
    public void talebesil(String id){
        SQLiteDatabase db=this.getWritableDatabase();

        String DELETE_TALEBE="DELETE FROM Talebelistesi WHERE id="+id;

        db.execSQL(DELETE_TALEBE);

        db.close();
    }
*/
}
