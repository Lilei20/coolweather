package example.coolweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

//遍历全国省市县
//和服务器进行交互发送HTTP请求传入请求地址，注册回调进行服务器响应
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel( HttpLoggingInterceptor.Level.BODY );
        builder.addInterceptor( interceptor );
        OkHttpClient client = builder.build();
        Request request = new Request.Builder().url( address ).build();
        client.newCall( request ).enqueue( callback );
    }
}
