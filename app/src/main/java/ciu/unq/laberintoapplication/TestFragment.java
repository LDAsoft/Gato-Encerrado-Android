package ciu.unq.laberintoapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ciu.unq.laberintoapplication.R;

public class TestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return layoutInflater.inflate(R.layout.test_fragment_view, viewGroup, false);
    }
}
