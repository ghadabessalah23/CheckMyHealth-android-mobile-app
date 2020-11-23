package enis.rnu.checkmyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;

import android.media.AudioManager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashScreenActivity extends AppCompatActivity {
    private MediaPlayer mPlayer = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView splashIcon = (ImageView) findViewById(R.id.imageView);


       /* Animation animation1 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);*/
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate);

       /* animation.setDuration(3000);*/
        splashIcon.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mPlayer = MediaPlayer.create(SplashScreenActivity.this, R.raw.welcome);
                mPlayer.start();
                setVolumeControlStream(AudioManager.STREAM_MUSIC);

                            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer.reset();
                    mPlayer.release();
                }
                Intent intent = new Intent(SplashScreenActivity.this,MenuActivity.class);
                SplashScreenActivity.this.startActivity(intent);
                finish();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });










    }


    }









