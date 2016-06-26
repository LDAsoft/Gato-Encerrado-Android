package unq.gatoencerrado_android;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import adapter.LaberintoAdapter;
import domain.Laberinto;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import service.LaberintosService;

/**
 * Created by B032679 on 20/06/2016.
 */
public class LaberintosDetailFragment extends Fragment{

    public static final String ARG_ITEM_ID = "item_id";
    public LaberintosDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            String laberintoId = getArguments().getString(ARG_ITEM_ID);

        obtenerLaberinto(laberintoId);

        }
    }

    private void obtenerLaberinto(String laberintoId) {

        LaberintosService labServ = crearServicio();
        Call<Laberinto> laberintoIdCall = labServ.getDetalleLaberinto("1", laberintoId);

        laberintoIdCall.enqueue(new Callback<Laberinto>() {

            @Override
            public void onResponse(Response<Laberinto> response, Retrofit retrofit) {

                Laberinto laberinto = response.body();
                mostrarLaberinto(laberinto);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Log.e("app", t.getMessage());
            }
        });

    }

    private void mostrarLaberinto(Laberinto laberinto){
        ImageView imgLaberinto = ((ImageView) this.getView().findViewById(R.id.imagen_laberinto));
        //imgLaberinto.setImageDrawable(getResources().getDrawable(new GeneroAdapter().getIconoGenero(pelicula)));

        ((TextView) this.getView().findViewById(R.id.nombre_laberinto)).setText(laberinto.getNombre());
        ((TextView) this.getView().findViewById(R.id.descripcion_laberinto)).setText(laberinto.getDescripcion());
    }

    private LaberintosService crearServicio(){

        String BASE_URL = "http://192.168.1.38:9000/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LaberintosService laberintosService = retrofit.create(LaberintosService.class);
        return laberintosService;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.laberinto_detail_fragment, container, false);
        return rootView;
    }

}
