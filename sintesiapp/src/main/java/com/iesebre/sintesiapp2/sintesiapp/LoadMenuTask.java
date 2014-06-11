package com.iesebre.sintesiapp2.sintesiapp;

import android.app.Activity;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordi on 11/06/14.
 */
public class LoadMenuTask extends AsyncTask<Integer, Void, Boolean> {

    private Activity activity;
    private MenuListAdapter adapter;
    private List<Menu> menus = new ArrayList<Menu>();
    private String URL = "http://192.168.1.39/sintesi/index.php/main/jsonGet/";
    HttpClient httpClient = new DefaultHttpClient();
    HttpResponse response;

    public LoadMenuTask(MenuTotActivity activity, MenuListAdapter adapter){
        this.activity = activity;
        this.adapter = adapter;
    }
    @Override
    protected void onPreExecute(){

    }
    @Override
    protected Boolean doInBackground(Integer... parameters){
        int npagina = parameters[0];
        String url_api = URL+String.valueOf(npagina);
        try{
            response = httpClient.execute(new HttpGet(url_api));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                JSONObject jsonObj = new JSONObject(EntityUtils.toString(response.getEntity()));
                JSONArray jArray = jsonObj.getJSONArray("MenuList");
                for (int i=0; i<jArray.length();i++){
                    JSONObject jObject = jArray.getJSONObject(i);
                    String image = jObject.getString("image");
                    String name = jObject.getString("name");
                    String description = jObject.getString("description");
                    String type_m = jObject.getString("type_m");
                    String price = jObject.getString("price");
                    Menu m = new Menu();
                    m.setImage(image);
                    m.setName(name);
                    m.setDescription(description);
                    m.setM_type(type_m);
                    m.setPrice(price);
                }
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result){
        if(result){
            adapter.setData(menus);
        }
    }
}
