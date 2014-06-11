package com.iesebre.sintesiapp2.sintesiapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class MenuTotActivity extends Activity {

    ListView lv;
    MenuListAdapter adapter;
    List<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tot);

        lv = (ListView)findViewById(R.id.list);
        menus = new ArrayList<Menu>();

        lv.setOnScrollListener(new EndlessScrollListener(){
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                new LoadMenuTask(MenuTotActivity.this,adapter).execute(page);
            }
        });

        adapter = new MenuListAdapter(this, menus);
        lv.setAdapter(adapter);

        new LoadMenuTask(this, adapter).execute(1);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
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

