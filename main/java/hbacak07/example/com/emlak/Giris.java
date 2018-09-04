package hbacak07.example.com.emlak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Giris extends AppCompatActivity {

    EditText et_kullaniciadi;
    EditText et_sifre;
    CheckBox cb_durum;
    Button btn_kaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        /////
        initialize();
        /////
        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git_Anasayfa=new Intent(Giris.this,Anasayfa.class);
                startActivity(git_Anasayfa);
            }
        });




    }
    public void initialize(){
        et_kullaniciadi=findViewById(R.id.et_kullaniciadi);
        et_sifre=findViewById(R.id.et_sifre);
        cb_durum=findViewById(R.id.cb_bilkay);
        btn_kaydet=findViewById(R.id.btn_giris);
    }

}
