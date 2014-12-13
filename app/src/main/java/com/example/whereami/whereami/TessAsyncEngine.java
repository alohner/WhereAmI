package com.example.whereami.whereami;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import com.example.whereami.whereami.ImageDialog;
import com.example.whereami.whereami.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Quentin on 11/12/2014.
 */
public class TessAsyncEngine extends AsyncTask<Object, Void, String> {

    static final String TAG = "DBG_" + TessAsyncEngine.class.getName();

    private Bitmap bmp;

    private Activity context;


    @Override
    protected String doInBackground(Object... params) {

        try {

            if(params.length < 2) {
                Log.e(TAG, "Error passing parameter to execute - missing params");
                return null;
            }

            if(!(params[0] instanceof Activity) || !(params[1] instanceof Bitmap)) {
                Log.e(TAG, "Error passing parameter to execute(context, bitmap)");
                return null;
            }

            context = (Activity)params[0];

            bmp = (Bitmap)params[1];

            if(context == null || bmp == null) {
                Log.e(TAG, "Error passed null parameter to execute(context, bitmap)");
                return null;
            }

            int rotate = 0;

            if(params.length == 3 && params[2]!= null && params[2] instanceof Integer){
                rotate = (Integer) params[2];
            }

            if(rotate >= -180 && rotate <= 180 && rotate != 0)
            {
                bmp = Tools.preRotateBitmap(bmp, rotate);
                Log.d(TAG, "Rotated OCR bitmap " + rotate + " degrees");
            }

            TessEngine tessEngine =  TessEngine.Generate(context);

            bmp = bmp.copy(Bitmap.Config.ARGB_8888, true);

            String result = tessEngine.detectText(bmp);

            Log.d(TAG, result);

            return result;

        } catch (Exception ex) {
            Log.d(TAG, "Error: " + ex + "\n" + ex.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {

        if(s == null || bmp == null || context == null)
            return;

        /*s.replaceAll("/", "");
        s.replaceAll("!", "");
        s.replaceAll("@", "");
        s.replaceAll("#", "");
        s.replaceAll("$", "");
        s.replaceAll("%", "");
        s.replaceAll("^", "");
        s.replaceAll("&", "");
        s.replaceAll("_", "");
        s.replaceAll(";", "");
        s.replaceAll(":", "");
        s.replaceAll("=", "");
        s.replaceAll("|", "");
        s.replaceAll("<", "");
        s.replaceAll(">", "");
        s.replaceAll("~", "");
        s.replaceAll(",", "");
        s.replaceAll(".", "");
        s.replaceAll("'", "");
        s.replaceAll(" ", "");
        s.replaceAll("a", "");
        s.replaceAll("b", "");
        s.replaceAll("c", "");
        s.replaceAll("d", "");
        s.replaceAll("e", "");
        s.replaceAll("f", "");
        s.replaceAll("g", "");
        s.replaceAll("h", "");
        s.replaceAll("i", "");
        s.replaceAll("j", "");
        s.replaceAll("k", "");
        s.replaceAll("l", "");
        s.replaceAll("m", "");
        s.replaceAll("n", "");
        s.replaceAll("o", "");
        s.replaceAll("q", "");
        s.replaceAll("r", "");
        s.replaceAll("s", "");
        s.replaceAll("t", "");
        s.replaceAll("u", "");
        s.replaceAll("v", "");
        s.replaceAll("w", "");
        s.replaceAll("x", "");
        s.replaceAll("y", "");
        s.replaceAll("z", "");
        s.replaceAll("A", "");
        s.replaceAll("B", "");
        s.replaceAll("C", "");
        s.replaceAll("D", "");
        s.replaceAll("E", "");
        s.replaceAll("F", "");
        s.replaceAll("G", "");
        s.replaceAll("H", "");
        s.replaceAll("I", "");
        s.replaceAll("J", "");
        s.replaceAll("K", "");
        s.replaceAll("L", "");
        s.replaceAll("M", "");
        s.replaceAll("N", "");
        s.replaceAll("O", "");
        s.replaceAll("Q", "");
        s.replaceAll("R", "");
        s.replaceAll("S", "");
        s.replaceAll("T", "");
        s.replaceAll("U", "");
        s.replaceAll("V", "");
        s.replaceAll("W", "");
        s.replaceAll("X", "");
        s.replaceAll("Y", "");
        s.replaceAll("Z", "");*/

        Log.d("TAG","LE STRING = "+s);
        Pattern p = Pattern.compile("P[0-9]-[0-9]{4}");
        Matcher m = p.matcher(s);
        Boolean b = m.matches();

        String resultat =""; //string à afficher dans le popup

        if(b){
            Log.d("cool","texte ok");
            resultat = s;
        }

        else
        resultat = "Données Illisibles";

        ImageDialog.New()
                .addBitmap(bmp)
               .addTitle(resultat)
               .show(context.getFragmentManager(), TAG);

        Intent intent = new Intent(context.getApplicationContext(), MapActivity.class);
        intent.putExtra("NamePosition", s);
       // context.startActivity(intent);

        super.onPostExecute(s);
    }
}
