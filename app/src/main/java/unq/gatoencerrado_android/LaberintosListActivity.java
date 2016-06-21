package unq.gatoencerrado_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LaberintosListActivity extends AppCompatActivity
        implements LaberintosListFragment.Callbacks {


    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laberintos_list_activity);

        if (findViewById(R.id.laberinto_detail_container) != null) {

            mTwoPane = true;
            ((LaberintosListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.laberinto_list))
                    .setActivateOnItemClick(true);
        }
    }


    @Override
    public void onItemSelected(Laberinto laberinto) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putSerializable(LaberintosDetailFragment.ARG_ITEM_ID, laberinto);
            LaberintosDetailFragment fragment = new LaberintosDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.laberinto_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, LaberintoDetailActivity.class);
            detailIntent.putExtra(LaberintosDetailFragment.ARG_ITEM_ID, laberinto);
            startActivity(detailIntent);
        }
    }

}
