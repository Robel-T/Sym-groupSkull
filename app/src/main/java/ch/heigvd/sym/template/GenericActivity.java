/*
 * File     : GenericActivity.java
 * Project  : Labo01 SYM
 * Author   : Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date     : 6 octobre 2019
 *
 * Ce code override les fonctions principales d'une Activity. Dans notre cas, le but était
 * de faire apparaître des logs dès que l'Activity appelait l'une de ces fonctions.
 *
 */

package ch.heigvd.sym.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class GenericActivity extends AppCompatActivity {

    protected static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, "-- onStart --");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "-- onStop  --");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w(TAG, "- onRestart -");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "-- onPause --");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "-- onResume -");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "- onDestroy -");
    }


}
