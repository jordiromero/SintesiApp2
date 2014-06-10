package com.iesebre.sintesiapp2.sintesiapp;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MenuTotActivity extends ListActivity {

    private ProgressDialog pDialog;
    private static final String url_image = "http://192.168.1.38/sintesi/assets/images/menu/";

    //Creating JSON Parser Object
    JSONParser jsonParser = new JSONParser();
    ArrayList<HashMap<String, String>> menuList;
    JSONArray menu = null;
    //Json URL
    private static final String MENU_URL = "http://192.168.1.39/sintesi/index.php/main/jsonGet";

    //JSON node names
    private static final String TAG_MENU = "menu";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_NAME = "name";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_TYPE = "m_type";
    private static final String TAG_PRICE = "price";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tot);

        menuList = new ArrayList<HashMap<String, String>>();
        new LoadMenu().execute();
    }

    class LoadMenu extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(MenuTotActivity.this);
            pDialog.setMessage("Carregant Menu");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected  String doInBackground(String... args){
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jsonParser.makeHttpRequest(MENU_URL, "POST", params);
            Log.d("Menu JSON: ", json.toString());
            try{
                menu = json.getJSONArray(TAG_MENU);
                for (int i = 0; i<menu.length();i++){
                    JSONObject c = menu.getJSONObject(i);
                    String image = c.getString(TAG_IMAGE);
                    String name = c.getString(TAG_NAME);
                    String description = c.getString(TAG_DESCRIPTION);
                    String type = c.getString(TAG_TYPE);
                    String price = c.getString(TAG_PRICE);

                    //new hashmap

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put(TAG_IMAGE,url_image + image);
                    map.put(TAG_NAME, "Producte: " + name);
                    map.put(TAG_DESCRIPTION, "Descripció: "+description);
                    map.put(TAG_TYPE, "Tipus: "+type);
                    map.put(TAG_PRICE, "Preu: "+price + " €");
                    menuList.add(map);

                }

            }catch (JSONException e){
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String file_url){
            pDialog.dismiss();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ListAdapter adapter = new SimpleAdapter(
                            MenuTotActivity.this, menuList, R.layout.menu_tot, new String[]{TAG_IMAGE, TAG_NAME, TAG_DESCRIPTION, TAG_TYPE, TAG_PRICE},
                            new int[] {R.id.image_tot, R.id.nom_tot, R.id.descrip_tot, R.id.tipus_m_tot, R.id.preu_tot});

                    setListAdapter(adapter);
                }
            });
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tot, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
