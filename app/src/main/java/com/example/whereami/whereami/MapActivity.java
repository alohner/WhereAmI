package com.example.whereami.whereami;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

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
    ScaleGestureDetector SGD;
    ImageView IMG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Initialise la carte
        mapInit();
        //Récupère les informations passé en paramètre de l'activité
        Bundle b = getIntent().getExtras();

        FrameLayout view =(FrameLayout) findViewById(R.id.FrameLayout);
        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.TOP | Gravity.LEFT);
        IMG = (ImageView) findViewById(R.id.IMG_Map);
        view.setOnTouchListener(new PanAndZoomListener(view, IMG, PanAndZoomListener.Anchor.TOPLEFT));

        //on récupère la position de l'utilisateur
        if ( b !=null)
        {
            userPos = indoorMap.getNodeWithName(b.getString("NamePosition"));
        }
        userPos = indoorMap.getNodeWithName("P1-6090");
        if (userPos != null)//Si on l'a trouvé alors on affiche
        {
            locateHim(userPos.getPosition());
            System.out.println(userPos.getPosition());
        } else {
            //petit message d'erreur
            Toast.makeText(getApplicationContext(), "Erreur Position inconnue !!", Toast.LENGTH_LONG).show();
        }
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
        IMG = (ImageView) findViewById(R.id.IMG_Map);
        IMG.setImageBitmap(ProcessingBitmap(position));
    }

    private Bitmap ProcessingBitmap(Position pos) {
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
}
