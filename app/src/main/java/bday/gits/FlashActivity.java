package bday.gits;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class FlashActivity extends AppCompatActivity {

    MediaPlayer md;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ll=(LinearLayout)findViewById(R.id.ll);
        ll.setVisibility(View.INVISIBLE);
        md=MediaPlayer.create(this,R.raw.bdayscream);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                md.start();
                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                ll.startAnimation(startAnimation);
                ll.setVisibility(View.VISIBLE);
            }
        },800);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ;
            }
        },1000);
        Button btn=(Button)findViewById(R.id.pButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FlashActivity.this,FirstActivity.class));
                finish();
            }
        });
    }
}
