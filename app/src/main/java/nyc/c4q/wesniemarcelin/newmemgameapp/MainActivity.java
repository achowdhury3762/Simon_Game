package nyc.c4q.wesniemarcelin.newmemgameapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int time = 3000;
    private static final int RED = Color.RED;
    private static final int YELLOW = Color.YELLOW;
    private static final int GREEN = Color.GREEN;
    private static final int BLUE = Color.BLUE;
    Handler handler;
    List<Buttons> randButton = new ArrayList<>();
    List<Integer> userColors = new ArrayList<>();
    Button currentButton;
    int count = 0;

    int colorArray[] = {
            RED,
            YELLOW,
            GREEN,
            BLUE
    };


    Buttons buttonArray[] = {
            Buttons.PINKBUTTON,
            Buttons.GREENBUTTON,
            Buttons.BLUEBUTTON,
            Buttons.YELLOWBUTTON
    };

    public void flashColors() {
        handler = new Handler();
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                if (count == randButton.size()) {
                    Button button = (Button) findViewById(randButton.get(count - 1).id);
                    button.setBackgroundColor(randButton.get(count+1  ).id);
                    return;
                }
                if (count >= 1) {
                    Button button = (Button) findViewById(randButton.get(count - 1).id);
                    button.setBackgroundColor(Color.WHITE);
                }
                Button button = (Button) findViewById(randButton.get(count).id);
                button.setBackgroundColor(button.getCurrentTextColor());
                count++;

                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runner, 1000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        randButton.add(Buttons.PINKBUTTON);
        randButton.add(Buttons.GREENBUTTON);
        randButton.add(Buttons.BLUEBUTTON);
        randButton.add(Buttons.YELLOWBUTTON);

        flashColors();
    }
}


