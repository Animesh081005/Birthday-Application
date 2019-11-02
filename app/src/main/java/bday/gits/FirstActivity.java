package bday.gits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FirstActivity extends AppCompatActivity {

    LinearLayout wish;
    LinearLayout website;
    LinearLayout reading;
    LinearLayout random;
    LinearLayout call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        wish=(LinearLayout)findViewById(R.id.wishes);
        website=(LinearLayout)findViewById(R.id.websites);
        reading=(LinearLayout)findViewById(R.id.reading);
        random=(LinearLayout)findViewById(R.id.random);
        call=(LinearLayout)findViewById(R.id.call);
        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,Wishes.class));
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,Websites.class));
            }
        });
        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,Reading.class));
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,Random_Things.class));
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,Call_me.class));
            }
        });

    }
}
