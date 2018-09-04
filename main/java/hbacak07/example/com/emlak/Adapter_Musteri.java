package hbacak07.example.com.emlak;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hbacak07.example.com.emlak.Data.Ilan;
import hbacak07.example.com.emlak.Data.Musteri;

public class Adapter_Musteri extends BaseAdapter {
    private ArrayList<Musteri> musteri_list;
    private LayoutInflater inflater;
    Activity activity;

    public Adapter_Musteri(ArrayList<Musteri> musteri_list, Activity activity) {
        this.musteri_list = musteri_list;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return musteri_list.size();
    }

    @Override
    public Object getItem(int position) {
        return musteri_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View satirView=inflater.inflate(R.layout.satir_musteri,null);

        TextView tvm_isim=satirView.findViewById(R.id.tvm_isim);
        TextView tvm_telefon=satirView.findViewById(R.id.tvm_telefon);
        TextView tvm_not=satirView.findViewById(R.id.tvm_not);

        Musteri musteri=musteri_list.get(position);

        tvm_isim.setText(musteri.getAd()+" "+musteri.getSoyad());
        tvm_telefon.setText(musteri.getTelefon());
        tvm_not.setText(musteri.getNot());

        return satirView;
    }
}
