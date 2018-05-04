package example.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName( "comf" )
    public Comfort comfort;

    @SerializedName( "cw" )
    public CarWash carWash;

    public Sport sport;

}
