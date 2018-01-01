package jeremy.applock.quickmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;

public class Load extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        final Handler handler = new Handler();
        final TextView textView = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/oj.ttf");
        textView.setTypeface(typeface);
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(n.get()));
                if(n.getAndDecrement() >= 1 )
                    handler.postDelayed(this, 1000);
                else {

                    String Mode = sharedPref.getString("MODE", "Not Available");
                    if (Mode.equals("E")) {
                        textView.setVisibility(View.GONE);
                        Intent intent = new Intent(Load.this, Easy.class);
                        startActivity(intent);
                    }
                    else if (Mode.equals("M")){
                        textView.setVisibility(View.GONE);
                        Intent intent = new Intent(Load.this, Medium.class);
                        startActivity(intent);
                    }
                    else if (Mode.equals("A")){
                        textView.setVisibility(View.GONE);
                        Intent intent = new Intent(Load.this, Advanced.class);
                        startActivity(intent);
                    }
                    else if (Mode.equals("B")){
                        textView.setVisibility(View.GONE);
                        Intent intent = new Intent(Load.this, Basic.class);
                        startActivity(intent);
                    }
                }
            }

        };

        handler.postDelayed(counter, 1000);

    }

}


