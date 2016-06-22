package unq.gatoencerrado_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import domain.Laberinto;

/**
 * Created by B032679 on 20/06/2016.
 */
public class LaberintosListFragment extends ListFragment {

         //Only used on tablets.
        private static final String STATE_ACTIVATED_POSITION = "activated_position";
        private Callbacks mCallbacks = sDummyCallbacks;
         //Only used on tablets.
        private int mActivatedPosition = ListView.INVALID_POSITION;

        public interface Callbacks {
            void onItemSelected(Laberinto laberinto);
        }

    /*
        @Override
        public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
            return super.onCreateAnimation(transit, enter, nextAnim);
        }
*/

        private static Callbacks sDummyCallbacks = new Callbacks() {
            @Override
            public void onItemSelected(Laberinto laberinto) {
            }
        };

    //laberinto para instanciar el fragmento
        public LaberintosListFragment() {
        }

    //Instancia el repositorio
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setListAdapter(new PeliculaAdapter(
              //      getActivity(),
              //      RepoPeliculas.getInstance().getPeliculas(null, 10)));

        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Restore the previously serialized activated item position.
            if (savedInstanceState != null
                    && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
                setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
            }
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            // Activities containing this fragment must implement its callbacks.
            if (!(activity instanceof Callbacks)) {
                throw new IllegalStateException("Activity must implement fragment's callbacks.");
            }

            mCallbacks = (Callbacks) activity;
        }

        @Override
        public void onDetach() {
            super.onDetach();
            // Reset the active callbacks interface to the dummy implementation.
            mCallbacks = sDummyCallbacks;
        }

        @Override
        public void onListItemClick(ListView listView, View view, int position, long id) {
            super.onListItemClick(listView, view, position, id);

            //Laberinto laberinto = RepoPeliculas.getInstance().getPelicula(id);
            //mCallbacks.onItemSelected(laberinto);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            if (mActivatedPosition != ListView.INVALID_POSITION) {
                // Serialize and persist the activated item position.
                outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
            }
        }

        public void setActivateOnItemClick(boolean activateOnItemClick) {
            getListView().setChoiceMode(activateOnItemClick
                    ? ListView.CHOICE_MODE_SINGLE
                    : ListView.CHOICE_MODE_NONE);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.laberintos_list_fragment, null, false);
        }

        private void setActivatedPosition(int position) {
            if (position == ListView.INVALID_POSITION) {
                getListView().setItemChecked(mActivatedPosition, false);
            } else {
                getListView().setItemChecked(position, true);
            }

            mActivatedPosition = position;
        }
    }