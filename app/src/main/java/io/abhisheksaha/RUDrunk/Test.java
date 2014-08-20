package io.abhisheksaha.RUDrunk;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import io.abhisheksaha.RUDrunk.R;



public class Test extends ActionBarActivity {
    int x;
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_test);
        x=9;
        final TextView localTextView = (TextView) findViewById(R.id.addr);
        LocationManager localLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        localLocationManager.getLastKnownLocation("gps");
        localLocationManager.requestLocationUpdates("gps", 2000L, 10.0F, new LocationListener() {
            public void onLocationChanged(Location paramAnonymousLocation) {
                double d1 = paramAnonymousLocation.getLatitude();
                double d2 = paramAnonymousLocation.getLongitude();
                Geocoder localGeocoder = new Geocoder(Test.this.getApplicationContext(), Locale.getDefault());
                try {
                    List localList = localGeocoder.getFromLocation(d1, d2, 1);
                    if (localList.size() == 1) {
                        Address localAddress = (Address) localList.get(0);
                        Object[] arrayOfObject = new Object[3];
                        if (localAddress.getMaxAddressLineIndex() > 0) ;
                        for (String str1 = localAddress.getAddressLine(0); ; str1 = "") {
                            arrayOfObject[0] = str1;
                            arrayOfObject[1] = localAddress.getAddressLine(1);
                            arrayOfObject[2] = localAddress.getCountryName();
                            String str2 = String.format("%s, %s, %s", arrayOfObject);
                            localTextView.setText(str2);
                            if(x==9){
                            Test.this.waititout();}
                            return;
                        }
                    }
                } catch (IOException localIOException) {
                    localIOException.printStackTrace();
                    return;
                } catch (InterruptedException localInterruptedException) {
                    localInterruptedException.printStackTrace();
                }
            }

            public void onProviderDisabled(String paramAnonymousString) {
                localTextView.setText("TURN ON GPS DUMMY");
            }

            public void onProviderEnabled(String paramAnonymousString) {
            }

            public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {
            }
        });
    }

    protected void onRestart(){
        super.onRestart();

        x=23;

    }


    public boolean onCreateOptionsMenu(Menu paramMenu) {
        // getMenuInflater().inflate(2131492866, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131034180)
            return true;
        return super.onOptionsItemSelected(paramMenuItem);
    }




}