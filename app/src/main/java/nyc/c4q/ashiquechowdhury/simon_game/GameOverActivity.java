package nyc.c4q.ashiquechowdhury.simon_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import nyc.c4q.wesniemarcelin.newmemgameapp.R;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        ImageView imageView = (ImageView) findViewById(R.id.congrats);
        imageView.setAnimation(animation);

        playConrats();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(GameOverActivity.this, Simon.class));
                finish();
            }
        }, 6000);


    }

    void playConrats(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.gameover);
        mp.start();
    }
}
