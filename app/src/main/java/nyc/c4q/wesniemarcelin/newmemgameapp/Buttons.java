package nyc.c4q.wesniemarcelin.newmemgameapp;

import android.widget.Button;

/**
 * Created by wesniemarcelin on 9/30/16.
 */

public enum Buttons {
    PINKBUTTON(R.id.red),
    YELLOWBUTTON(R.id.yellow),
    GREENBUTTON(R.id.green),
    BLUEBUTTON(R.id.blue);


    public int id;

    private Buttons(int value){
        id = value;
    }

}
