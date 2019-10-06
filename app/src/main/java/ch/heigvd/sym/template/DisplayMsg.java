/*
 * File     : DisplayMsg.java
 * Project  : Labo01 SYM
 * Author   : Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date     : 6 octobre 2019
 *
 * Ce code implémente les fonctionnalités demandées suite au login correct de l'utilisateur.
 *
 */

package ch.heigvd.sym.template;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


public class DisplayMsg extends GenericActivity {

    static {
        // For logging purposes
        TAG = DisplayMsg.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_msg);

        setTitle("Message");
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String mail = intent.getStringExtra(MainActivity.EXTRA_MAIL);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.email);
        textView.setText(mail);


        // permet d'afficher l imei du telephone
        TelephonyManager tm = (TelephonyManager)getSystemService((TELEPHONY_SERVICE));
        String imei = "IMEI - " + tm.getImei();

        TextView timei = findViewById(R.id.imei);
        timei.setText(imei);

        // permet d afficher la photo qui se trouve dans la carte sd
        ImageView iv = findViewById(R.id.img);
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String fileString = file.toString() + "/simpson.png";
        iv.setImageURI(Uri.parse(fileString));

        // quitter
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener((v) -> {
                finish();
        });

    }


}
