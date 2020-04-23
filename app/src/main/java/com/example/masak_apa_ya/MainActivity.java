package com.example.masak_apa_ya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    TextView menu;
    Button button;
    boolean status = false;
    private String[] menus;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getXML();
        setArray();


        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (status){
                    status = false;
                    thread.interrupt();
                    button.setText("ROLLING");
                }else{
                    status = true;
                    createThread();
                    thread.start();
                    button.setText("Berhenti");
                }

            }
        });
    }

    private void getXML(){
        menu = findViewById(R.id.menu);
        button = findViewById(R.id.button);
    }

    private void createThread(){
        final Random rand = new Random();
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (status){
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                menu.setText(menus[rand.nextInt(menus.length)]);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
    }

    private void setArray(){
        menus = new String[]{
            "Semur",
            "Bakso",
            "Soto daging",
            "Soto ayam",
            "Rawon",
            "Ayam teriyaki",
            "Sambal goreng kentang",
            "Koloke",
            "Cumi crispy",
            "Sayur asem",
            "Sayur bening",
            "Eseng eseng mie",
            "Nasi goreng",
            "Kering tempe tahu",
            "Bebek purnama",
            "Jamur crispy",
            "Sop",
            "Sayur bayam",
            "Capcay",
            "Olahan ceker",
            "Tahu tempe bacem",
            "Sarden",
            "Perkedel",
            "Ayam mentega",
            "Ayam madu",
            "Sate",
            "Udang goreng",
            "Bihun",
            "Terong balado",
            "Opor",
            "Sayur kelor",
            "Acar",
            "Sayur bobor",
            "Pindang suwir",
            "Ayam suwir",
            "Bali",
            "Ayam asam manis",
            "Fuyunghai",
            "Serundeng",
            "Martabak mie"
        };
    }
}
