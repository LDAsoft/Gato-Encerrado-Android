package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import domain.Laberinto;
import unq.gatoencerrado_android.R;

/**
 * Created by B032679 on 22/06/2016.
 */
public class LaberintoAdapter{
        //extends ArrayAdapter<Laberinto> {

    public LaberintoAdapter(Context context, List<Laberinto> laberintos) {
        /* super(context, R.layout.laberinto_row, laberintos); */
    }
/*
    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.laberinto_row, parent, false);

        final Laberinto laberinto = getItem(position);

        TextView tvPelicula = (TextView) rowView.findViewById(R.id.lblPelicula);

        tvPelicula.setText(laberinto.toString());

        TextView tvActores = (TextView) rowView.findViewById(R.id.lblActores);

        tvActores.setText(laberinto.getActores());

        return rowView;
    }
*/

}
