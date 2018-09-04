package hbacak07.example.com.emlak;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import hbacak07.example.com.emlak.Data.Personel;

public class Anasayfa extends AppCompatActivity {

    TextView tv_yeni_emlak;
    TextView tv_yeni_kisi;
    TextView tv_yeni_personel;
    TextView tv_emlak_islemleri;
    TextView tv_personel_islemleri;
    TextView tv_kisi_islemleri;
    Alert_Dialogs alert_dialogs;
    Boolean durum=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        initialize();

        final Alert_Dialogs alert=new Alert_Dialogs(Anasayfa.this);

        tv_yeni_emlak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_yeniemlak();
            }
        });

        tv_yeni_kisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_yenikisi();
            }
        });

        tv_yeni_personel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_yenipersonel();
            }
        });
        tv_emlak_islemleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                git_islem(1);
            }
        });
        tv_kisi_islemleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                git_islem(2);
            }
        });
        tv_personel_islemleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                git_islem(3);
            }
        });


    }

    public void initialize(){
        tv_yeni_emlak=findViewById(R.id.tv_yeniemlak);
        tv_yeni_kisi=findViewById(R.id.tv_yenikisi);
        tv_yeni_personel=findViewById(R.id.tv_yenipersonel);
        tv_emlak_islemleri=findViewById(R.id.tv_ilanislemleri);
        tv_kisi_islemleri=findViewById(R.id.tv_kisiislemleri);
        tv_personel_islemleri=findViewById(R.id.tv_personelislemleri);

        ////////////////////////////////////////////////
        alert_dialogs=new Alert_Dialogs(this);
    }

    public void git_islem(int veri){
        Intent git=new Intent(Anasayfa.this,Database_Islemleri.class);
        git.putExtra("veri",veri);
        startActivity(git);
    }

   public void alert_yeniemlak(){
        alert_dialogs.alert_yeniemlak("Yeni İlan",durum);
   }

   public void alert_yenikisi(){
        alert_dialogs.alert_yenikisi("Yeni Kişi",durum);
   }

   public void alert_yenipersonel(){
        alert_dialogs.alert_yenipersonel("Yeni Personel",durum);
   }
}
