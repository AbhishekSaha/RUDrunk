package io.abhisheksaha.RUDrunk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.abhisheksaha.RUDrunk.R;

@SuppressLint("NewApi")
public class DrunkTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drunk_test);

        Date localDate = new Date();
        Calendar localCalendar = GregorianCalendar.getInstance();

        int i = 467 + (int) (Math.random() * 379);
        int j = 467 + (int) (Math.random() * 379);
        int k = i + j;
        String str1 = Integer.toString(i);
        String str2 = Integer.toString(j);
        final String str3 = Integer.toString(k);
        final Intent localIntent = new Intent(this, io.abhisheksaha.RUDrunk.Test.class);
        String str4 = str1.concat("\n+").concat(str2);
        ((TextView) findViewById(R.id.doc)).setText(str4);

        new CountDownTimer(30000L, 1000L) {
            public void onFinish() {
                DrunkTest.this.startActivity(localIntent);
            }

            public void onTick(long paramAnonymousLong) {
            }
        }
                .start();
        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                EditText localEditText = (EditText) DrunkTest.this.findViewById(R.id.editText1);
                if (localEditText.getText().toString().equals(str3)) {
                    localEditText.setText("NOT DRUNK");
                    return;
                } else {
                    DrunkTest.this.startActivity(localIntent);
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131034180)
            return true;
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public static class PlaceholderFragment extends Fragment {
        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            return null;
        }
    }
}