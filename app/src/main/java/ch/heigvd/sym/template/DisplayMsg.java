package ch.heigvd.sym.template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;


public class DisplayMsg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_msg);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String mail = intent.getStringExtra(MainActivity.EXTRA_MAIL);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.email);
        textView.setText(mail);

        TelephonyManager tm = (TelephonyManager)getSystemService((TELEPHONY_SERVICE));
        String imei = tm.getImei();

                TextView timei = findViewById(R.id.imei);
        timei.setText(imei);
    }
}
