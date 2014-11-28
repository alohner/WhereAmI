package com.example.whereami.whereami;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Quentin on 26/11/2014.
 */
public class MapActivity extends Activity {
    public ArrayList<mapPosition> IndoorMap = new ArrayList<mapPosition>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapInit();

        Bundle b = getIntent().getExtras();
        //Toast.makeText(getApplicationContext() , b.getString("room"), Toast.LENGTH_LONG).show();

        ImageView img = (ImageView) findViewById(R.id.IMG_Map);
        img.setImageResource(R.drawable.map);

        locateHim(b.getString("room"));
    }

    private void mapInit() {
        IndoorMap.add(new mapPosition("bacon",-180,433));
        IndoorMap.add(new mapPosition("cookie",50,20));
    }

    private void locateHim(String room) {
        boolean positionExist = false;
        int positionIndex = 0;

        for (int i = 0; i < IndoorMap.size (); i++) {
            if(IndoorMap.get(i).getNamePosition().toString().equalsIgnoreCase(room)){
                positionExist = true;
                positionIndex = i;
            }
        }

        if(positionExist){
            //System.out.println(IndoorMap.get(positionIndex).getNamePosition() + " / " + IndoorMap.get(positionIndex).getX() + " / " + IndoorMap.get(positionIndex).getY());
            ImageView img = (ImageView) findViewById(R.id.IMG_Point);
            img.setX(IndoorMap.get(positionIndex).getX());
            img.setY(IndoorMap.get(positionIndex).getY());
            img.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(getApplicationContext() , "Salle non répertoriée", Toast.LENGTH_LONG).show();
        }
    }
}
