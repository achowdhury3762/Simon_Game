package nyc.c4q.ashiquechowdhury.simon_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.newmemgameapp.R;

public class NewGame extends AppCompatActivity {
    Button newGame;
    Button endGame;
    ImageView simon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        newGame = (Button) findViewById(R.id.play_again);
        endGame = (Button) findViewById(R.id.end_game);
        simon = (ImageView) findViewById(R.id.simon_says_icon);





        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGame.this, Simon.class);
                startActivity(intent);
            }
        });


        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playBye();


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onDestroy();
                        finish();
                    }
                }, 1000);

            }
        });
    }

    void playBye(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bye_sound);
        mp.start();
    }

    @Override
    protected void onDestroy() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
