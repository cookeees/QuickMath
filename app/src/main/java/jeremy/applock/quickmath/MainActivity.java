package jeremy.applock.quickmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        TextView t5 = findViewById(R.id.t5);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/oj.ttf");
        b1.setTypeface(typeface);
        b2.setTypeface(typeface);
        b3.setTypeface(typeface);
        b4.setTypeface(typeface);
        t5.setTypeface(typeface);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        //now get Editor
        final SharedPreferences.Editor editor = sharedPref.edit();

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newString = "E";
                editor.putString("MODE", newString);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, Load.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newString = "M";
                editor.putString("MODE", newString);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, Load.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newString = "A";
                editor.putString("MODE", newString);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, Load.class);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newString = "B";
                editor.putString("MODE", newString);
                editor.commit();
                Intent intent = new Intent(MainActivity.this, Load.class);
                startActivity(intent);
            }
        });
    }

}

