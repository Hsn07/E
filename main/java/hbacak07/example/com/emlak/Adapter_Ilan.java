package hbacak07.example.com.emlak;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hbacak07.example.com.emlak.Data.Ilan;

public class Adapter_Ilan extends BaseAdapter {

    private ArrayList<Ilan> ilan_list;
    private LayoutInflater inflater;
    Activity activity;

    public Adapter_Ilan(ArrayList<Ilan> ilan_list, Activity activity) {
        this.ilan_list = ilan_list;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return ilan_list.size();
    }

    @Override
    public Object getItem(int position) {
        return ilan_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        View satirView=inflater.inflate(R.layout.satir_ilan,null);

        ImageView resim=satirView.findViewById(R.id.img_resim);
        TextView ad=satirView.findViewById(R.id.tv_isad);
        TextView tip=satirView.findViewById(R.id.tv_istip);
        TextView bilgi=satirView.findViewById(R.id.tv_isbilgi);
        TextView fiyat=satirView.findViewById(R.id.tv_ifiyat);


        Ilan ilan=ilan_list.get(position);
        String str=String.valueOf(ilan.getFiyat());
        ad.setText(ilan.getAd());
        tip.setText(String.valueOf(ilan.getTur()));
        bilgi.setText(ilan.getIlce()+"/"+ilan.getIl());
        fiyat.setText(str);

        return satirView;
    }
}
