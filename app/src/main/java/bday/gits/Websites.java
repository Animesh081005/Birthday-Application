package bday.gits;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class Websites extends AppCompatActivity {

    LinearLayout gits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        gits=(LinearLayout)findViewById(R.id.gitswebsite);
        gits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://prettydarncute.com/"));
                    startActivity(intent);
            }
        });
    }
}
