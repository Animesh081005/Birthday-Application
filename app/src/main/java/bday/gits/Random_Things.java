package bday.gits;

import android.content.Intent;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Random_Things extends AppCompatActivity {

    LinearLayout selfie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random__things);
        selfie=(LinearLayout)findViewById(R.id.selfie);
        selfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("android.intent.extras.CAMERA_FACING",1);
                startActivity(intent);
            }
        });
    }
}
