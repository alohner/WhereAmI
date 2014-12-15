package com.example.whereami.whereami;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import MapGraphe.DijkstraAlgo;
import MapGraphe.Graph;
import MapGraphe.Node;
import MapGraphe.Position;
import MapGraphe.TypeNode;

/**
 * Created by Antonin on 14/12/2014.
 */
public class ItineraireActivity extends Activity {

    //Map de la fac
    public Node positionDep;
    public Node positionEnd;

    public Graph map = new Graph();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itineraire);

        //Récupère les informations passé en paramètre de l'activité
        Bundle b = getIntent().getExtras();

        //on récupère la position de l'utilisateur
        if ( b !=null)
        {
            positionDep = map.getNodeWithName(b.getString("NamePosition"));
        }

        Button valide = (Button)findViewById(R.id.B_FindItineraire);
        valide.setOnClickListener(validateListener);
    }

    View.OnClickListener validateListener = new View.OnClickListener() {
        public void onClick(View v) {
            EditText edittext = (EditText) findViewById(R.id.NameRoomFind);
            positionEnd = map.getNodeWithName(edittext.getText().toString());
            if (positionEnd!=null) {
                /***************************** Problème pour affichage
                 Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                 intent.putExtra("NamePosition", positionDep);
                 intent.putExtra("GoalPosition", edittext.getText().toString());
                 startActivity(intent);
                 *Donc affichage temporaire dans une liste toute moche*********/
                afficheItineraire();
            } else {
                //petit message d'erreur
                Toast.makeText(getApplicationContext(), "Cette salle n'existe pas...", Toast.LENGTH_LONG).show();
            }
        }
    };


    /***
     * Affiche itinéraire
     */
    public void afficheItineraire()
    {
        DijkstraAlgo da = new DijkstraAlgo(map);
        da.execute(positionDep);
        LinkedList<Node> path = da.getPath(positionEnd);
        ListView list = (ListView)findViewById(R.id.listView);

        if (path!=null)
        {
            ArrayList<String> listeNoeud = new ArrayList<String>();
            int j = 1;
            for (Node n : path)
            {
                if (n.getType()== TypeNode.RoomClass){
                    listeNoeud.add(j+"/ "+ n.getName());
                    j++;
                }
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    listeNoeud);
            list.setAdapter(arrayAdapter);
        }else{
            Toast.makeText(getApplicationContext(), "Pas d'itinéraire entre ces positions !!", Toast.LENGTH_LONG).show();
        }

    }


}
