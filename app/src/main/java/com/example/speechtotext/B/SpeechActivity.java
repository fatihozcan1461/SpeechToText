package com.example.speechtotext.B;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.speechtotext.C.MicActivity;
import com.example.speechtotext.R;

import java.util.Timer;
import java.util.TimerTask;

public class SpeechActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.b_activity_speech );
        setViewPager();
    }
    //Viewpager
    private Timer     timer = null;
    private int       timekitper = 0;
    private ViewPager viewPager;
    private Bitmap[]  benu = null;
    private ViewPagerAdapter viewPagerAdapter;

    public void setViewPager()
    {
        Drawable drawable = getResources().getDrawable( R.drawable.istanbul );
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        benu = new Bitmap[1];
        benu[0] = bitmap;

        viewPager = findViewById( R.id.viewPage );
        viewPager.setOffscreenPageLimit( 1 );
        viewPagerAdapter = new ViewPagerAdapter( this,benu );
        viewPager.setAdapter( viewPagerAdapter );

        ViewGroup.LayoutParams params = viewPager.getLayoutParams(  );
        params.height = getResources().getDisplayMetrics().widthPixels;
        viewPager.setLayoutParams(params);
        viewPager.setClipToPadding( false );

        int value =16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (value*d);
        viewPager.setPadding( margin,margin,margin,margin );
        viewPager.setPageMargin( margin/2 );

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post( new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem( (viewPager.getCurrentItem()+1),true );
                        timekitper++;
                        if(timekitper==200)
                        {
                            timer.cancel();
                        }
                    }
                } );
            }
        };

        timer = new Timer(  );
        timer.schedule( timerTask,500,5000 );
    }

    public void buton_microfon(View view) {
        startActivity( new Intent( SpeechActivity.this, MicActivity.class ) );
        finish();
    }
}
