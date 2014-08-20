package io.abhisheksaha.RUDrunk;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.abhisheksaha.RUDrunk.R;

public class Front extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FjallaOne.ttf");

        Date localDate = new Date();
        Calendar localCalendar = GregorianCalendar.getInstance();
        localCalendar.setTime(localDate);

        final Intent localIntent1 = new Intent(Front.this, io.abhisheksaha.RUDrunk.DrunkTest.class);
        final Intent localIntent2 = new Intent(Front.this, io.abhisheksaha.RUDrunk.Test.class);
        Button localButton1 = (Button) findViewById(R.id.maybe);
        Button localButton2 = (Button) findViewById(R.id.yes);
        localButton1.setTypeface(typeface);
        localButton2.setTypeface(typeface);
        localButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {

                startActivity(localIntent1);

            }
        });

        localButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {

                startActivity(localIntent2);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.front, menu);
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
