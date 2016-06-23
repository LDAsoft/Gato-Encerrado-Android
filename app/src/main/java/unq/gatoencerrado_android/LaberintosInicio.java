package unq.gatoencerrado_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class LaberintosInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto_app_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((LaberintosListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.laberintos_list))
                .setActivateOnItemClick(true);
    }


}
