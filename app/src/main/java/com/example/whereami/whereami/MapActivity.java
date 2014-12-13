package com.example.whereami.whereami;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import MapGraphe.Graph;
import MapGraphe.Node;
import MapGraphe.Position;

/**
 * Created by Quentin on 26/11/2014.
 * @version 2.0 le 11/12/2014 par Antonin
 */
public class MapActivity extends Activity {

    //Map de la fac
    public Graph indoorMap;
    public Node userPos;
    private String salleActuelle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Initialise la carte
        mapInit();
        //Récupère les informations passé en paramètre de l'activité
        Bundle b = getIntent().getExtras();
        if(b != null) {
            salleActuelle = b.getString("NamePosition");

            ImageView img = (ImageView) findViewById(R.id.IMG_Map);
            img.setImageResource(R.drawable.planuqac);

            //on récupère la position de l'utilisateur
            userPos = indoorMap.getNodeWithName(b.getString("NamePosition"));
            if (userPos!=null)//Si on l'a trouvé alors on affiche
            {
                locateHim(userPos.getPosition());
            }else
            {
                //petit message d'erreur
                Toast.makeText(getApplicationContext() , "Erreur Position inconnue !!", Toast.LENGTH_LONG).show();
            }

        }
        //Toast.makeText(getApplicationContext() , b.getString("room"), Toast.LENGTH_LONG).show();



    }

    private void mapInit() {
        indoorMap = new Graph();
    }

    /***
     * Permet de positionner le curseur de position à l'endroit où se situe l utilisateur
     * @param position du curseur
     */
    private void locateHim(Position position) {
        //System.out.println(IndoorMap.get(positionIndex).getNamePosition() + " / " + IndoorMap.get(positionIndex).getX() + " / " + IndoorMap.get(positionIndex).getY());
        ImageView img = (ImageView) findViewById(R.id.IMG_Point);
        img.setX(position.getX());
        img.setY(position.getY());
        img.setVisibility(View.VISIBLE);
    }


}
