package com.iesebre.sintesiapp2.sintesiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        // Dashboard News feed button
        Button btn_reserva_crea = (Button) findViewById(R.id.btn_crea_reserva);

        // Dashboard Friends button
        Button btn_reserva_consulta = (Button) findViewById(R.id.btn_busca_reserva);

        // Dashboard Messages button
        Button btn_mapa = (Button) findViewById(R.id.btn_mapa);

        // Dashboard Places button
        Button btn_usuaris = (Button) findViewById(R.id.btn_usuaris);

        // Dashboard Events button
        Button btn_consulta_menu = (Button) findViewById(R.id.btn_menu_consulta);

        // Dashboard Photos button
        Button btn_crea_menu = (Button) findViewById(R.id.btn_menu_crear);

        /**
         * Handling all button click events
         * */

        // Listening to News Feed button click
        btn_reserva_crea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), CreaReserva.class);
                startActivity(i);
            }
        });

        // Listening Friends button click
        btn_reserva_consulta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), ConsultaReserva.class);
                startActivity(i);
            }
        });

        // Listening Messages button click
        btn_mapa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MapaActivity.class);
                startActivity(i);
            }
        });

        // Listening to Places button click
        btn_usuaris.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), UsersActivity.class);
                startActivity(i);
            }
        });

        // Listening to Events button click
        btn_consulta_menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), ConsultaMenu.class);
                startActivity(i);
            }
        });

        // Listening to Photos button click
        btn_crea_menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), CreaMenu.class);
                startActivity(i);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
