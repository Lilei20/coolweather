package example.coolweather.android.db;


import com.google.gson.annotations.SerializedName;

public class Province {

    private int id;

    @SerializedName( "name" )
    private String provinceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

}
