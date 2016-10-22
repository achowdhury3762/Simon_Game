package nyc.c4q.ashiquechowdhury.simon_game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import nyc.c4q.wesniemarcelin.newmemgameapp.R;

/**
 * Created by wesnie on 10/1/16.
 */
public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_up);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setAnimation(animation);


//        ImageView image = (ImageView) findViewById(R.id.imageView);
//        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.hyperspacejump);
//        image.startAnimation(hyperspaceJump);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, Simon.class));
                finish();
            }
        }, 6000);

    }
}