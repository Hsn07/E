package hbacak07.example.com.emlak;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import hbacak07.example.com.emlak.Data.DataBase;
import hbacak07.example.com.emlak.Data.Ilan;
import hbacak07.example.com.emlak.Data.Musteri;
import hbacak07.example.com.emlak.Data.Personel;

public class Alert_Dialogs {

    Context context;
    DataBase db;

    public Alert_Dialogs(Context context) {
        this.context = context;
        db=new DataBase(context);
    }

    public void alert_yeniemlak(String text,Boolean durum){
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.a_emlak);

        TextView bilgi=dialog.findViewById(R.id.tv_etext);

        final EditText et_ad=dialog.findViewById(R.id.et_ad);
        final EditText et_il=dialog.findViewById(R.id.et_il);
        final EditText et_ilce=dialog.findViewById(R.id.et_ilce);
        final EditText et_tip=dialog.findViewById(R.id.et_tip);
        final EditText et_uzunluk=dialog.findViewById(R.id.et_uzunluk);
        final EditText et_fiyat=dialog.findViewById(R.id.et_fiyat);
        final EditText et_not=dialog.findViewById(R.id.et_not);

        final RadioGroup rg_a=dialog.findViewById(R.id.rg_a);
        RadioButton rb_aguncelle=dialog.findViewById(R.id.rb_aguncelle);
        RadioButton rb_asil=dialog.findViewById(R.id.rb_asil);

        final CheckBox cb_aaktif=dialog.findViewById(R.id.cb_aaktif);

        Button btn_iptal=dialog.findViewById(R.id.btn_iptal);
        Button btn_kaydet=dialog.findViewById(R.id.btn_kaydet);

        bilgi.setText(text.toString());
        if (durum==false){
            cb_aaktif.setVisibility(View.GONE);
        }

        cb_aaktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_aaktif.isChecked()){
                    rg_a.setVisibility(View.VISIBLE);
                    et_il.setEnabled(true);


                }else {
                    rg_a.setVisibility(View.GONE);
                    et_il.setEnabled(false);
                }
            }
        });

        final Ilan ilan=new Ilan();



        btn_iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilan.setId(10000);
                ilan.setPersonel_id(1000);
                ilan.setAd(et_ad.getText().toString());
                ilan.setIl(et_il.getText().toString());
                ilan.setIlce(et_ilce.getText().toString());
                ilan.setMxm(Integer.parseInt(et_uzunluk.getText().toString()));
                ilan.setOzellikler(et_not.getText().toString());
                ilan.setTur(et_tip.getText().toString());
                ilan.setDurum(0);//
                ilan.setFiyat(Integer.parseInt(et_fiyat.getText().toString()));

                db.yeni_ilan(ilan);
            }
        });


        dialog.show();
    }

    public void alert_yenikisi(String text,Boolean durum){
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.a_kisi);

        TextView bilgi=dialog.findViewById(R.id.tv_ktext);
        final EditText etk_ad=dialog.findViewById(R.id.etk_ad);
        final EditText etk_soyad=dialog.findViewById(R.id.etk_soyad);
        final EditText etk_telefon=dialog.findViewById(R.id.etk_telefon);
        EditText etk_adres=dialog.findViewById(R.id.etk_adres);
        final EditText etk_not=dialog.findViewById(R.id.etk_not);

        final RadioGroup rg_k=dialog.findViewById(R.id.rg_k);
        RadioButton rb_kguncelle=dialog.findViewById(R.id.rb_kguncelle);
        RadioButton rb_ksil=dialog.findViewById(R.id.rb_ksil);

        final CheckBox cb_kaktif=dialog.findViewById(R.id.cb_kaktif);

        Button btnk_iptal=dialog.findViewById(R.id.btnk_iptal);
        Button btnk_kaydet=dialog.findViewById(R.id.btnk_kaydet);

        bilgi.setText(text.toString());
        if (durum=false)
        {
            cb_kaktif.setVisibility(View.GONE);
        }

        cb_kaktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_kaktif.isChecked()){
                    rg_k.setVisibility(View.VISIBLE);
                }else{
                    rg_k.setVisibility(View.GONE);
                }
            }
        });

        btnk_iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnk_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Musteri musteri=new Musteri();
                musteri.setId(10000);
                musteri.setAd(etk_ad.getText().toString());
                musteri.setSoyad(etk_soyad.getText().toString());
                musteri.setTelefon(etk_telefon.getText().toString());
                musteri.setTarih(19970621);
                musteri.setNot(etk_not.getText().toString());
                musteri.setDurum(0);

                db.yeni_Musteri(musteri);

                dialog.dismiss();
            }
        });


        dialog.show();
    }

    public void alert_yenipersonel(String text,Boolean durum){
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.a_personel);

        TextView bilgi=dialog.findViewById(R.id.tv_ptext);
        final EditText etp_ad=dialog.findViewById(R.id.etp_ad);
        final EditText etp_soyad=dialog.findViewById(R.id.etp_soyad);
        final EditText etp_telefon=dialog.findViewById(R.id.etp_telefon);
        EditText etp_adres=dialog.findViewById(R.id.etp_rutbe);

        final RadioGroup rg_p=dialog.findViewById(R.id.rg_p);
        RadioButton rb_pguncelle=dialog.findViewById(R.id.rb_pguncelle);
        RadioButton rb_psil=dialog.findViewById(R.id.rb_psil);

        final CheckBox cb_paktif=dialog.findViewById(R.id.cb_paktif);

        Button btnp_iptal=dialog.findViewById(R.id.btnp_iptal);
        Button btnp_kaydet=dialog.findViewById(R.id.btnp_kaydet);

        if (durum==false){
            cb_paktif.setVisibility(View.GONE);
        }

        cb_paktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_paktif.isChecked()){
                    rg_p.setVisibility(View.VISIBLE);
                }else {
                    rg_p.setVisibility(View.GONE);
                }
            }
        });

        bilgi.setText(text.toString());

        btnp_iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnp_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Personel personel=new Personel();
                personel.setId(1000);
                personel.setAd(etp_ad.getText().toString());
                personel.setSoyad(etp_soyad.getText().toString());
                personel.setTelefon(etp_telefon.getText().toString());
                personel.setDurum(0);
                personel.setRutbe(0);
                personel.setKullanici_adi("kullanici adi");
                personel.setSifre("Sifre");

                db.yeni_personel(personel);
            }
        });


        dialog.show();
    }

}
