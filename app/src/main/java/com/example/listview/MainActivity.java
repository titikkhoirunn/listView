package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdapterPahlawan adapterPahlawan;
    private String[] dataNama;
    private TypedArray dataFoto;
    private  ArrayList<Model_pahlawan> pahlawans ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list_view = findViewById(R.id.list_pahlawan);
        adapterPahlawan = new AdapterPahlawan(this);
        list_view.setAdapter(adapterPahlawan);

        prepare();
        tambahItem();
    }
    private void prepare(){
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataFoto = getResources().obtainTypedArray(R.array.data_photo);

    }
    private void tambahItem(){
        pahlawans = new ArrayList<>();
        for (int i = 0; i < dataNama.length; i++){
            Model_pahlawan modelPahlawan = new Model_pahlawan();
            modelPahlawan.setFoto(dataFoto.getResourceId(i, -1));
            modelPahlawan.setNama(dataNama[i]);
            pahlawans.add(modelPahlawan);
        }
        adapterPahlawan.setPahlawans(pahlawans);
    }
}
