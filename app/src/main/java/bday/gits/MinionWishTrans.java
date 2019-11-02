package bday.gits;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MinionWishTrans extends AppCompatActivity {

    private int sTime =0, eTime =0, fTime = 5000, bTime = 5000;
    ImageButton play_button,forward,backward;
    MediaPlayer md;
    SeekBar seekBar;
    Button translate;
    Handler handler=new Handler();
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_wish_trans);
        getInIt();
        md.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                count=0;
                play_button.setBackgroundResource(android.R.drawable.ic_media_play);
            }
        });
        eTime=md.getDuration();
        seekUpdation();
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                md.stop();
                startActivity(new Intent(MinionWishTrans.this,MinionWish.class));
                finish();
            }
        });
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((sTime+fTime)<eTime)
                {
                    sTime=sTime+fTime;
                    md.seekTo(sTime);
                }
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((sTime-bTime)>0)
                {
                    sTime=sTime-bTime;
                    md.seekTo(sTime);
                }
            }
        });

    }
    public void getInIt()
    {
        translate=(Button)findViewById(R.id.topbtn);
        play_button=(ImageButton)findViewById(R.id.play);
        forward=(ImageButton)findViewById(R.id.forward);
        backward=(ImageButton)findViewById(R.id.backward);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        md=MediaPlayer.create(this,R.raw.minionwishaudioeng);
        seekBar.setMax(md.getDuration());
        seekBar.setClickable(false);

    }
    public void logic()
    {
        if(count==1)
        {
            md.pause();
            count=0;
            play_button.setBackgroundResource(android.R.drawable.ic_media_play);
        }
        else {
            md.start();
            count = 1;
            play_button.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
    }

    public void seekUpdation() {

        sTime=md.getCurrentPosition();
        seekBar.setProgress(sTime);
        handler.postDelayed(run, 100);
    }
    Runnable run=new Runnable(){
        @Override
        public void run()
        {
            seekUpdation();
        }
    };

    @Override
    public void onBackPressed() {
        md.stop();
        finish();
        super.onBackPressed();
    }
    protected void onUserLeaveHint() {
        count=1;
        logic();
        super.onUserLeaveHint();
    }
}