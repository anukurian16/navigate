package com.example.akurian.navigate;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.qozix.tileview.TileView;
import com.qozix.tileview.paths.CompositePathView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TileView tileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        double[] xCoordinates = {230,100,230,300,370,440,520,590,660,740,230,300,370,440,520,590,660,740,230,300,370,440,520,590,660,740};
//        double[] yCoordinates = {550,460,460,460,460,460,460,460,460,460,280,280,280,280,280,280,280,280,115,115,115,115,115,115,115,115};
          double[] xCoordinates = {250,100,250,330,400,470,550,630,710,790,250,330,400,470,550,630,710,790,250,330,400,470,550,630,710,790,790};
          double[] yCoordinates = {970,820,820,820,820,820,820,820,820,820,500,500,500,500,500,500,500,500,180,180,180,180,180,180,180,180,970};
        final Path path=new Path();
        CompositePathView.DrawablePath drawablePath = new CompositePathView.DrawablePath();
        int i;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tileView = (TileView) findViewById(R.id.tile);
        tileView.setSize(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);  // the original size of the untiled image
        tileView.addDetailLevel(1f, "Grocery-Store-Layout.png", getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        //tileView.defineBounds(0, 0, 1000, 1000);


        path.moveTo((float) xCoordinates[0], (float) yCoordinates[0]);
        for(i=1;i<yCoordinates.length;i++) {
            mark(xCoordinates[i], yCoordinates[i]);
//            path.lineTo((float)xCoordinates[i],(float)yCoordinates[i]);
       }
        path.lineTo((float)xCoordinates[2],(float)yCoordinates[2]);
        path.lineTo((float)xCoordinates[4],(float)yCoordinates[4]);
        path.lineTo((float)xCoordinates[12],(float)yCoordinates[12]);
        path.lineTo((float)xCoordinates[16],(float)yCoordinates[16]);
        path.lineTo((float)xCoordinates[24],(float)yCoordinates[24]);
        path.lineTo((float)xCoordinates[25],(float)yCoordinates[25]);
        path.lineTo((float)xCoordinates[17],(float)yCoordinates[17]);
        path.lineTo((float)xCoordinates[9],(float)yCoordinates[9]);
        path.lineTo((float)xCoordinates[26],(float)yCoordinates[26]);
        

        drawablePath.path = path;
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        drawablePath.paint = p;
        p.setColor(Color.RED);
        p.setStrokeWidth(10);
        tileView.drawPath(drawablePath);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void mark(double x, double y) {
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.marker);
        tileView.addMarker(imageView, x, y, -0.5f, -1.0f);

    }
}
