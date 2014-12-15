package com.example.whereami.whereami;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

import MapGraphe.DijkstraAlgo;
import MapGraphe.Graph;
import MapGraphe.Node;
import MapGraphe.Position;

/**
 * Created by Quentin on 26/11/2014.
 * @version 2.0 le 11/12/2014 par Antonin
* @version 3.0 le 13/12/2014 par Antonin
 */
public class MapActivity extends Activity{


    //Map de la fac
    public Graph indoorMap;
    public Node userPos;
    ScaleGestureDetector SGD;
    ImageView IMG;
    public Node userGoal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Initialise la carte
        mapInit();
        //Récupère les informations passé en paramètre de l'activité
        Bundle b = getIntent().getExtras();

        FrameLayout view =(FrameLayout) findViewById(R.id.FrameLayout);
        //FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.TOP | Gravity.LEFT);
        IMG = (ImageView) findViewById(R.id.IMG_Map);
        view.setOnTouchListener(new PanAndZoomListener(view, IMG, PanAndZoomListener.Anchor.TOPLEFT));


        //on récupère la position de l'utilisateur
        if ( b !=null)
        {
            userPos = indoorMap.getNodeWithName(b.getString("NamePosition"));
            userGoal = indoorMap.getNodeWithName(b.getString("GoalPosition"));
        }
        //userPos = indoorMap.getNodeWithName("P1-7070");
        if (userPos != null)//Si on l'a trouvé alors on affiche
        {
            locateHim(userPos.getPosition());
            System.out.println(userPos.getPosition());
        } else {
            //petit message d'erreur
            Toast.makeText(getApplicationContext(), "Erreur Position inconnue !!", Toast.LENGTH_LONG).show();
        }

        //Gestion de l'itinéraire
        ItineraireInit();
    }

    private void mapInit() {
        indoorMap = new Graph();
    }

    /**
     * Permet de positionner le curseur de position à l'endroit où se situe l utilisateur
     *
     * @param position du curseur
     */
    private void locateHim(Position position) {

        IMG.setImageBitmap(MakeBitmapWithPosition(position));
    }

    /***
     * Permet de coller les deux images ensembles (map + position de l'utilisateur)
     * @param pos
     * @return nouvelle image a afficher
     */
    private Bitmap MakeBitmapWithPosition(Position pos) {
        Bitmap bm1 = null;
        Bitmap bm2 = null;
        Bitmap newBitmap = null;
        bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.plan_uqac);
        bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.greenflag);
        int w = bm1.getWidth();
        int h =  bm1.getHeight();

        Bitmap.Config config = bm1.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }

        newBitmap = Bitmap.createBitmap(w, h, config);
        Canvas newCanvas = new Canvas(newBitmap);

        newCanvas.drawBitmap(bm1, 0, 0, null);

        Paint paint = new Paint();
        paint.setAlpha(128);
        newCanvas.translate(pos.getX(),pos.getY());
        newCanvas.drawBitmap(bm2, pos.getX(), pos.getY(), paint);
        return newBitmap;
    }


    /***
     * Permet de dessiner l'itinéraire sur la carte si il y en a un
     * @param itineraire
     * @return nouvelle image à afficher
     */
    private Bitmap MakeBitmapWithItineraire(LinkedList<Node> itineraire)
    {
        Bitmap bm1 = null;
        Bitmap bm2 = null;
        Bitmap newBitmap = null;
        bm1 = MakeBitmapWithPosition(userPos.getPosition());
        bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.redflag);

        int w = bm1.getWidth();
        int h =  bm1.getHeight();
        Bitmap.Config config = bm1.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }

        newBitmap = Bitmap.createBitmap(w, h, config);
        Canvas newCanvas = new Canvas(newBitmap);

        //On ajoute le redflag sur le point d'arrivée
        newCanvas.drawBitmap(bm1, 0, 0, null);
        Paint paint = new Paint();
        paint.setAlpha(128);
        newCanvas.translate(userGoal.getPosition().getX(), userGoal.getPosition().getY());
        newCanvas.drawBitmap(bm2, userGoal.getPosition().getX(),userGoal.getPosition().getY(), paint);

        newCanvas.translate(0,0);
        //On déssine l'itinéraire
        Paint paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStrokeWidth(10);
        /*for(int i= 0;i<itineraire.size()-1;i+=2)
        {
            Node n = itineraire.get(i);
            Log.d("Path",n.getName());
            Node n2 = itineraire.get(i+1);
            Log.d("Path",n2.getName());
            newCanvas.drawLine(n.getPosition().getX(),n.getPosition().getY(),n2.getPosition().getX(),n2.getPosition().getY(),
                    paint2);
        }
        for (Node drax:itineraire)
        {
            newCanvas.drawPoint(drax.getPosition().getX(),drax.getPosition().getY(),paint2);
        }*/


        return newBitmap;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    public void ItineraireInit()
    {
        if (userGoal!=null)//Si on a un itinéraire a affiché
        {
            DijkstraAlgo da=new DijkstraAlgo(indoorMap);
            da.execute(userPos);
            LinkedList<Node> linkedList= da.getPath(userGoal);
           if (linkedList == null)
           {
               Toast.makeText(getApplicationContext(), "Pas d'itinéraire entre ces positions !!", Toast.LENGTH_LONG).show();
           }else{
               IMG.setImageBitmap(MakeBitmapWithItineraire(linkedList));
           }

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itinéraire_button) {
            if (userPos!=null)
            {
                Intent intent = new Intent(getApplicationContext(), ItineraireActivity.class);
                intent.putExtra("NamePosition",userPos.getName());
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Vous n'êtes pas localisé !", Toast.LENGTH_LONG).show();
            }
        }
        if (id ==R.id.retour_menu_button)
        {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
