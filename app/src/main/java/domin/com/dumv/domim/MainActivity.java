package domin.com.dumv.domim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dataa.getInstrum().k=8;
        Dataa.getInstrum().soO=64;
        Dataa.getInstrum().soBom=16;
        startActivity(new Intent(this,manChoi.class));
    }
}
