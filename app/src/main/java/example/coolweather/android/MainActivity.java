package example.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_main );

        SharedPreferences prefe = PreferenceManager.getDefaultSharedPreferences( this );

        if (prefe.getString( "weather", null ) != null) {

            Intent intent = new Intent( this, WeatherActivity.class );

            startActivity( intent );

            finish();

        }
    }
}
