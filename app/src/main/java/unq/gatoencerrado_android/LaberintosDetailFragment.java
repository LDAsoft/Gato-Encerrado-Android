package unq.gatoencerrado_android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import domain.Laberinto;

/**
 * Created by B032679 on 20/06/2016.
 */
public class LaberintosDetailFragment extends Fragment{

    public static final String ARG_ITEM_ID = "item_id";
    private Laberinto laberinto;

    public LaberintosDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            laberinto = (Laberinto) getArguments().get(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            activity.setTitle(laberinto.getNombre());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_laberinto_detail, container, false);

        if (laberinto != null) {

            ImageView imgLaberinto = ((ImageView) rootView.findViewById(R.id.imagen_laberinto));
            //imgLaberinto.setImageDrawable(getResources().getDrawable(new GeneroAdapter().getIconoGenero(pelicula)));

            ((TextView) rootView.findViewById(R.id.nombre_laberinto)).setText(laberinto.getNombre());
            ((TextView) rootView.findViewById(R.id.descripcion_laberinto)).setText(laberinto.getDescripcion());
        }
        return rootView;
    }

}
