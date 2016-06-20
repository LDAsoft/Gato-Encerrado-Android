package unq.gatoencerrado_android;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class LaberintosListActivity extends FragmentActivity
        implements LaberintoListFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Laberintos_List_Activity);
    }
/*
    if (findViewById(R.id.laberinto_detail_container) != null) {
        ((LaberintosListFragment) getSupportFragmentManager().findFragmentById(R.id.laberinto_list))
                .setActivateOnItemClick(true);
    }
    */

    @Override
    public void onItemSelected(String id) {
        Intent detailIntent = new Intent(this, LaberintoDetailActivity.class);
        detailIntent.putExtra(LaberintoDetailFragment.ARG_ITEM_ID, id);
        startActivity(detailIntent);
    }
}
