package nyc.c4q.ashiquechowdhury.simon_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nyc.c4q.wesniemarcelin.newmemgameapp.R;


public class Simon extends AppCompatActivity {
    MediaPlayer mp;
    Handler handler = new Handler();
    private List<Integer> computerColors = new ArrayList<>();
    private List<Integer> userColors = new ArrayList<>();
    Random random = new Random();
    int currentButtonIndex = -1;
    int level = 1;

    Button redButton;
    Button greenButton;
    Button yellowButton;
    Button blueButton;
    TextView lvl;

    Integer buttonArray[] = {
            R.id.blueBttn,
            R.id.greenBttn,
            R.id.redBttn,
            R.id.yellowBttn
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);

        redButton = (Button) findViewById(R.id.redBttn);
        greenButton = (Button) findViewById(R.id.greenBttn);
        yellowButton = (Button) findViewById(R.id.yellowBttn);
        blueButton = (Button) findViewById(R.id.blueBttn);
        lvl = (TextView) findViewById(R.id.round_number);

        startLevel();
    }

    private void startLevel() {
        currentButtonIndex=-1;
        userColors.clear();
        lvl.setText(String.valueOf(level++));
        computerTurn();
    }

    private void computerTurn() {
        addRandomColor();
        flashColors();
    }

    void flashColors(){
        for (int i = 0; i < computerColors.size(); i++) {
            switch(computerColors.get(i)) {
                case R.id.blueBttn:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blinkblue();
                        }
                    }, 1000 * (i+1));
                    break;
                case R.id.yellowBttn:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blinkyellow();
                        }
                    }, 1000 * (i+1));
                    break;
                case R.id.greenBttn:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blinkgreen();
                        }
                    }, 1000 * (i+1));
                    break;
                case R.id.redBttn:
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blinkred();
                        }
                    }, 1000 * (i+1));
                    break;
            }
        }
    }

    int number = 400;

    void blinkblue() {
        blueButton.setBackgroundResource(R.color.brightblue);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                blueButton.setBackgroundResource(R.color.DarkBlue);
            }
        }, number);
    }
    void blinkyellow(){
        yellowButton.setBackgroundResource(R.color.brightyellow);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                yellowButton.setBackgroundResource(R.color.DarkYellow);
            }
        }, number);
    }
    void blinkgreen(){
        greenButton.setBackgroundResource(R.color.brightGreen);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                greenButton.setBackgroundResource(R.color.DarkGreen);
            }
        }, number);
    }
    void blinkred(){
        redButton.setBackgroundResource(R.color.brightred);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                redButton.setBackgroundResource(R.color.Red);
            }
        }, number);
    }

    public void addRandomColor(){
        int rand = random.nextInt(4);
        Integer randButtn = buttonArray[rand];
        computerColors.add(randButtn);
    }

    private void checkforWin() {
        if(computerColors.equals(userColors)){

            Toast.makeText(this, "CONGRATULATIONS", Toast.LENGTH_LONG).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startLevel();
                }
            }, 300);


            Intent intent = new Intent(this, CongratsActivity.class);
            startActivity(intent);
        }
        else {



            if(!computerColors.get(currentButtonIndex).equals(userColors.get(currentButtonIndex))){
                              loserSound();
                Toast.makeText(this, "GAME OVER", Toast.LENGTH_LONG).show();
                lvl.setText(String.valueOf(1));

                recreate();
            }
        }
    }


    public void clickedButton(View view){
        currentButtonIndex++;
        playSound();
        switch(view.getId()){
            case R.id.redBttn:
                userColors.add(R.id.redBttn);
                checkforWin();
                blinkred();
                break;
            case R.id.blueBttn:
                userColors.add(R.id.blueBttn);
                checkforWin();
                blinkblue();
                break;
            case R.id.greenBttn:
                userColors.add(R.id.greenBttn);
                checkforWin();
                blinkgreen();
                break;
            case R.id.yellowBttn:
                userColors.add(R.id.yellowBttn);
                checkforWin();
                blinkyellow();
                break;
        }
    }

    void playSound(){
        mp = MediaPlayer.create(this, R.raw.buttonsound);
        mp.start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mp.release();
            }
        },1000);
    }

    void loserSound(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.wrong_move);
        mp.start();
    }
}

