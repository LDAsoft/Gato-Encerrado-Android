package unq.gatoencerrado_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by B032679 on 20/06/2016.
 */
public class LaberintoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putSerializable(LaberintosDetailFragment.ARG_ITEM_ID,
                    getIntent().getSerializableExtra(LaberintosDetailFragment.ARG_ITEM_ID));

            LaberintosDetailFragment fragment = new LaberintosDetailFragment();

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction().add(R.id.laberinto_detail_container, fragment).commit();
        }

    }

}
