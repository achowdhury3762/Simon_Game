package nyc.c4q.ashiquechowdhury.memorygame;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    Random random = new Random();
    private static final int RED = Color.RED;
    private static final int YELLOW = Color.YELLOW;
    private static final int GREEN = Color.GREEN;
    private static final int BLUE = Color.BLUE;
    Handler handler;
    int level =1;
    TextView lvl;
    List<Buttons> randButton = new ArrayList<>();
    List<Buttons> userColors = new ArrayList<>();
    int count = 0;

    int colorArray[] = {
            RED,
            YELLOW,
            GREEN,
            BLUE
    };

    Buttons buttonArray[] = {
            Buttons.REDBUTTON,
            Buttons.GREENBUTTON,
            Buttons.BLUEBUTTON,
            Buttons.YELLOWBUTTON
    };
    private boolean winning = true;

    public void addRandomButton(){
        int rand = random.nextInt(4);
        Buttons randButtn = buttonArray[rand];
        randButton.add(randButtn);
    }

    public void flashColors(){
        handler = new Handler();
        Runnable runner = new Runnable(){
            @Override
            public void run() {
                if(count==randButton.size()){
                    Log.d("a","count = randomButton.size");
                    Button button = (Button) findViewById(randButton.get(count-1).id);
                    button.setBackgroundResource(R.drawable.colorbuttns);
                    return;
                }
                if(count>=1){
                    Log.d("a","count > = 1");
                    Button button = (Button) findViewById(randButton.get(count-1).id);
                    button.setBackgroundResource(R.drawable.colorbuttns);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Button button = (Button) findViewById(randButton.get(count-1).id);
                            button.setBackgroundResource(R.drawable.colorbuttns);
                        }
                    }, 300);
                }
                Log.d("a","runnn");
                Button button = (Button) findViewById(randButton.get(count).id);
                button.setBackgroundColor(button.getCurrentTextColor());
                count++;
                handler.postDelayed(this,800);
            }
        };
        handler.postDelayed(runner,800);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_game);
        lvl = (TextView) findViewById(R.id.level);
        startLevel();
    }




    public void click(View view){
        switch(view.getId()){
            case R.id.bluebtn:
                userColors.add(Buttons.BLUEBUTTON);
                break;
            case R.id.greenbtn:
                userColors.add(Buttons.GREENBUTTON);
                break;
            case R.id.yellowbtn:
                userColors.add(Buttons.YELLOWBUTTON);
                break;
            case R.id.redbtn:
                userColors.add(Buttons.REDBUTTON);
                break;
        }
        if(userColors.size()==randButton.size()){
            Log.d("UserSize",String.valueOf(userColors.size()));
            checkForWin();
        }
    }

    private void checkForWin() {
        if(randButton.equals(userColors)){
            startLevel();
        }
        else {
            Toast.makeText(this, "Hah", Toast.LENGTH_LONG).show();
            lvl.setText(String.valueOf(1));
            level = 1;
            randButton.clear();
            userColors.clear();
            startLevel();
        }
    }

    private void startLevel() {
        userColors.clear();
        lvl.setText(String.valueOf(level++));
        computerTurn();
    }

    private void computerTurn() {
        addRandomButton();
        count=0;
        flashColors();
    }
}