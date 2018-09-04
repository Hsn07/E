package hbacak07.example.com.emlak;

import android.app.Dialog;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hbacak07.example.com.emlak.Data.Bilgi;
import hbacak07.example.com.emlak.Data.DataBase;
import hbacak07.example.com.emlak.Data.Ilan;
import hbacak07.example.com.emlak.Data.Musteri;
import hbacak07.example.com.emlak.Data.Personel;

public class Database_Islemleri extends AppCompatActivity {
    ListView lv_liste;
    TextView tv_aciklama;
    int tablo_no=1; // bir önceki sayfadan alınacak...
    String bilgilendirme=" ";

    ArrayList<Musteri> list_musteri=new ArrayList<Musteri>();
    ArrayList<Personel> list_personel=new ArrayList<Personel>();
    ArrayList<Ilan> list_ilan=new ArrayList<Ilan>();
    Alert_Dialogs alert;

    DataBase db;
    Adapter_Ilan adapter_ilan;
    Adapter_Musteri adapter_musteri;
    Adapter_Personel adapter_personel;



    public void initialize(){
        lv_liste=findViewById(R.id.lv_liste);
        tv_aciklama=findViewById(R.id.tv_aciklama);

        //

        alert=new Alert_Dialogs(this);

        //

        db=new DataBase(Database_Islemleri.this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database__islemleri);
        initialize();


        /////////////////////////////////////////////////////

        tablo_no=getIntent().getIntExtra("veri",0);
        try {

            if (tablo_no==1){
                bilgilendirme="---> İlan Listesi <---";
                list_ilan=db.ilan_getir();
                adapter_ilan=new Adapter_Ilan(list_ilan,this);
                lv_liste.setAdapter(adapter_ilan);
            }else if (tablo_no==2){
                bilgilendirme="---> Kişi Listesi <---";
                list_musteri=db.musteri_getir();
                adapter_musteri=new Adapter_Musteri(list_musteri,this);
                lv_liste.setAdapter(adapter_musteri);
            }else if (tablo_no==3){
                bilgilendirme="---> Personel Listesi <---";
                list_personel=db.personel_getir();
                adapter_personel=new Adapter_Personel(list_personel,this);
                lv_liste.setAdapter(adapter_personel);
            }else {
                bilgilendirme="---> Hatalı Tablolar Mevcuttur... <---";
            }

        }catch (Exception e){};
        tv_aciklama.setText(bilgilendirme.toString());


        lv_liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*if (tablo_no==1){
                    alert.alert_yeniemlak("Emlaklar",false);
                }else if (tablo_no==2){
                    alert.alert_yenikisi("Kişiler",false);
                }else if (tablo_no==3){
                    alert.alert_yenipersonel("Personel",false);
                }else {
                    String bilgilendirme="---> Hatalı Tablolar Mevcuttur... <---";
                }*/
                Bottomsheet();
            }
        });
    }

    public void Bottomsheet(){
        BottomSheetDialog sheetDialog=new BottomSheetDialog(Database_Islemleri.this);
        View parentview=getLayoutInflater().inflate(R.layout.bottom_sheet,null);
        sheetDialog.setContentView(parentview);

        BottomSheetBehavior sheetBehavior=BottomSheetBehavior.from((View) parentview.getParent() );
        sheetBehavior.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,getResources().getDisplayMetrics()));

        sheetDialog.show();
    }
}
