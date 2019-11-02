package bday.gits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Wishes extends AppCompatActivity {

    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout ll3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishes);
        ll1=(LinearLayout)findViewById(R.id.bitwa);
        ll2=(LinearLayout)findViewById(R.id.minion);
        ll3=(LinearLayout)findViewById(R.id.dog);
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wishes.this,BitwaWish.class));
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wishes.this,MinionWish.class));
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wishes.this,DogWish.class));
            }
        });
    }
}
