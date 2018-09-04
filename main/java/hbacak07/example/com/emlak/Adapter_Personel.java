package hbacak07.example.com.emlak;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hbacak07.example.com.emlak.Data.Personel;

public class Adapter_Personel extends BaseAdapter {
    private ArrayList<Personel> personel_list;
    private LayoutInflater inflater;
    Activity activity;

    public Adapter_Personel(ArrayList<Personel> personel_list, Activity activity) {
        this.personel_list = personel_list;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return personel_list.size();
    }

    @Override
    public Object getItem(int position) {
        return personel_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View satirview=inflater.inflate(R.layout.satir_personel,null);

        TextView tvp_isim=satirview.findViewById(R.id.tvp_isim);
        TextView tvp_telefon=satirview.findViewById(R.id.tvp_telefon);
        TextView tvp_rutbe=satirview.findViewById(R.id.tvp_rutbe);

        Personel personel=personel_list.get(position);

        String str=String.valueOf(personel.getRutbe());
        tvp_isim.setText(personel.getAd()+" "+personel.getSoyad());
        tvp_telefon.setText(personel.getTelefon());
        tvp_rutbe.setText(str);


        return satirview;
    }
}
