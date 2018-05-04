package example.coolweather.android.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import example.coolweather.android.db.City;
import example.coolweather.android.db.County;
import example.coolweather.android.db.Province;
import example.coolweather.android.gson.Weather;

//解析处理返回的json数据
//先使用JsonArray和JsonObject将数据解析出来，然后组装成实体类对象，再调用save()方法将数据存储在数据库中

public class Utility {

    //解析和处理服务器返回的省级数据
    public static List<Province> handleProvinceResponse(String response) {
        List<Province> list = null;
        if (!TextUtils.isEmpty( response )) {
            list = new Gson().fromJson( response, new TypeToken<ArrayList<Province>>() {
            }.getType() );
        }

        return list == null ? Collections.<Province>emptyList() : list;
    }

    public static boolean handleCityResponse(String response, int provinceID) {

        if (!TextUtils.isEmpty( response )) {

            try {

                JSONArray allCites = new JSONArray( response );

                for (int i = 0; i < allCites.length(); i++) {

                    JSONObject cityObject = allCites.getJSONObject( i );

                    City city = new City();

                    city.setCityName( cityObject.getString( "name" ) );

                    city.setCityCode( cityObject.getInt( "id" ) );

                    city.setProvinceId( provinceID );

                    //  city.save();
                }

                return true;


            } catch (JSONException e) {

                e.printStackTrace();
            }


        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityID) {

        if (!TextUtils.isEmpty( response )) {

            try {

                JSONArray allCounties = new JSONArray( response );

                for (int i = 0; i < allCounties.length(); i++) {

                    JSONObject countyObject = allCounties.getJSONObject( i );

                    County county = new County();

                    county.setCountyName( countyObject.getString( "name" ) );

                    county.setWeatherId( countyObject.getString( "weather_id" ) );

                    county.setCityId( cityID );

                    //  county.save();

                }

                return true;


            } catch (JSONException e) {

                e.printStackTrace();
            }

        }

        return false;
    }

    //将返回的Json数据解析成Weather实体类
    public static Weather handleWeatherResponse(String response) {

        try {

            JSONObject jsonObject = new JSONObject( response );

            JSONArray jsonArray = jsonObject.getJSONArray( "HeWeather" );

            String weatherContent = jsonArray.getJSONObject( 0 ).toString();

            return new Gson().fromJson( weatherContent, Weather.class );

        } catch (JSONException e) {

            e.printStackTrace();
        }

        return null;

    }

}
