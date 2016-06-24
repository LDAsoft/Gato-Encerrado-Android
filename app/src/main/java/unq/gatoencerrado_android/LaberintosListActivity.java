package unq.gatoencerrado_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import domain.Laberinto;

public class LaberintosListActivity extends AppCompatActivity
        implements LaberintosListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto_app_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onItemSelected(Laberinto laberinto) {
        Intent detailIntent = new Intent(this, LaberintoDetailActivity.class);
        Log.w("Laberintos", laberinto.getNombre());
        detailIntent.putExtra(LaberintosDetailFragment.ARG_ITEM_ID, laberinto);
        startActivity(detailIntent);
    }
}
