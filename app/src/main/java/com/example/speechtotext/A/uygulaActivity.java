package com.example.speechtotext.A;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.speechtotext.B.SpeechActivity;
import com.example.speechtotext.R;
import com.google.cloud.speech.v1.SpeechContext;

public class uygulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_uygula );

        new SplashActivity().execute(  );
    }

    class SplashActivity  extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                Thread.sleep( 1500 );
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute( aVoid );
            startActivity( new Intent( uygulaActivity.this,
                    SpeechActivity.class ) );
            finish();
        }
    }
}
