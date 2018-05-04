package example.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    public String date;

    @SerializedName( "tem" )
    public Temperature temperature;

    @SerializedName( "cond" )
    public More more;

}
