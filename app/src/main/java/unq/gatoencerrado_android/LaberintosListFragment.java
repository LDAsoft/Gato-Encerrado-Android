package unq.gatoencerrado_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import adapter.InventarioAdapter;
import domain.Inventario;
import domain.Laberinto;
import adapter.LaberintoAdapter;
import service.LaberintosService;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
/**
 * Created by B032679 on 20/06/2016.
 */
public class LaberintosListFragment extends ListFragment implements View.OnClickListener {

    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    private int mActivatedPosition = ListView.INVALID_POSITION;

    private Callbacks mCallbacks = sDummyCallbacks;
    private LaberintosService laberintosService;

    public interface Callbacks {
        void onItemSelected(Integer laberintoId);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(Integer laberintoId) {
        }
    };

    public LaberintosListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // IMPORTANTE
        // Por un bug de retrofit 2.0, la BASE_URL debe tener una / al final
        // y la dirección del service debe comenzar sin /, como un path relativo
        String BASE_URL = "http://192.168.1.38:9000/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        laberintosService = retrofit.create(LaberintosService.class);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        Laberinto laberinto = (Laberinto) listView.getAdapter().getItem(position);
        Toast.makeText(getContext(), laberinto.getNombre(), Toast.LENGTH_LONG).show();

        mCallbacks.onItemSelected(laberinto.getId());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cargarLaberintos();
        return inflater.inflate(R.layout.laberinto_list_fragment, container, false);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }

    private void cargarLaberintos() {

        //EditText campoBusqueda = (EditText) this.getView().findViewById(R.id.idLaberintoBusqueda);
        //String idLaberinto = campoBusqueda.getText().toString();

        Call<List<Laberinto>> laberintoCall = laberintosService.getLaberintos("1");

        laberintoCall.enqueue(new Callback<List<Laberinto>>() {

            @Override
            public void onResponse(Response<List<Laberinto>> response, Retrofit retrofit) {
                List<Laberinto> laberintos = response.body();

                setListAdapter(new LaberintoAdapter(getActivity(),laberintos));

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Log.e("app", t.getMessage());
            }
        });
    }

}