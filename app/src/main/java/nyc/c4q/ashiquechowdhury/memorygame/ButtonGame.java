package nyc.c4q.ashiquechowdhury.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ButtonGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_game);
    }

    public void startGame(View view){
        Toast.makeText(this,"Watch the buttons and repeat!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void quit(View view){
        finish();
    }


}

