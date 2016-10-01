package nyc.c4q.ashiquechowdhury.memorygame;

/**
 * Created by ashiquechowdhury on 9/27/16.
 */
public enum Buttons {
    REDBUTTON(R.id.redbtn),
    GREENBUTTON(R.id.greenbtn),
    BLUEBUTTON(R.id.bluebtn),
    YELLOWBUTTON(R.id.yellowbtn);

    public int id;
    private Buttons(int value){
        id = value;
    }
}