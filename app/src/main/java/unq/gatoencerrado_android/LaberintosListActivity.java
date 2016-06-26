package unq.gatoencerrado_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import adapter.LaberintoAdapter;
import domain.Laberinto;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LaberintosListActivity extends AppCompatActivity
        implements LaberintosListFragment.Callbacks, View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto_app_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onItemSelected(Integer laberintoId) {
        Intent detailIntent = new Intent(this, LaberintoDetailActivity.class);
        //Log.w("Laberintos", laberinto.getNombre());
        detailIntent.putExtra(LaberintosDetailFragment.ARG_ITEM_ID, laberintoId);
        startActivity(detailIntent);
    }


    private void traerInventario(){


    }

    @Override
    public void onClick(View v) {
        traerInventario();
    }
}
