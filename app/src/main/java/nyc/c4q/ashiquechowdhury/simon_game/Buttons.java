package nyc.c4q.ashiquechowdhury.simon_game;

import nyc.c4q.wesniemarcelin.newmemgameapp.R;

/**
 * Created by ashiquechowdhury on 10/1/16.
 */
public enum Buttons {
    REDBUTTON(R.id.redBttn),
    YELLOWBUTTON(R.id.yellowBttn),
    GREENBUTTON(R.id.greenBttn),
    BLUEBUTTON(R.id.blueBttn);

    public int id;

    private Buttons(int value){
        id = value;
    }

}