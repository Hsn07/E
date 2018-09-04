package hbacak07.example.com.emlak;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private ImageView img_icon;
    private static int zaman=5000;
    AnimationDrawable draw_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        img_icon=findViewById(R.id.img_logo);

        img_icon.setBackgroundResource(R.drawable.drawableanimation);
        draw_anim= (AnimationDrawable) img_icon.getBackground();
        draw_anim.start();


        /*Animation anim= AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        img_icon.startAnimation(anim);*/
        /*img_kare.setBackgroundResource(R.drawable.drawable_animation);

        wifi_Animation= (AnimationDrawable) img_kare.getBackground();
        wifi_Animation.start();*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent git=new Intent(SplashScreen.this,Anasayfa.class);
                startActivity(git);
                finish();
            }
        },zaman);


    }
}
