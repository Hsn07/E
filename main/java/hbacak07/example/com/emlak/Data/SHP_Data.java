package hbacak07.example.com.emlak.Data;

import android.content.SharedPreferences;

public class SHP_Data {
    SharedPreferences sharedPreferences;
    String dosyaadi="com.example.hsn07.calarsaat";
    int ses,dk;

    public SHP_Data(SharedPreferences sharedPreferences, String dosyaadi) {
        this.sharedPreferences = sharedPreferences;
        this.dosyaadi = dosyaadi;
    }
    public void deneme(){
        //sharedPreferences = SharedPreferences.getSharedPreferences(dosyaadi,MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("erteledk",dk);
        editor.putInt("alarmseviye",ses);
        editor.commit();
    }
    private void getir() {
        Boolean durum=sharedPreferences.getBoolean("sbildirim",true);
        ses=sharedPreferences.getInt("alarmseviye",5);
        dk=sharedPreferences.getInt("erteledk",5);
    }


}
