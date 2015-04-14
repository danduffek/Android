package com.example.dduffek.dynamicfragmentsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dan on 4/12/2015.
 */
public class TopFragmentContainer extends Fragment {

    private static final String FRAG_A = "FragA";
    private static final String FRAG_B = "FragB";
    private boolean hasBfragment = false;

    public static TopFragmentContainer newInstance() {
        return new TopFragmentContainer();
    }

    public TopFragmentContainer() {
        super();
        Log.i("TOP", "In TopFragmentContainer.");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("TOP", "In onCreate.");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("TOP", "In onCreateView.");
        return inflater.inflate(R.layout.top_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i("TOP", "In onViewCreated.");

        hasBfragment = view.findViewById(R.id.fragmentBcontainer) != null;

        if (savedInstanceState == null) {
            FragmentA FragA = FragmentA.newInstance();
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentAcontainer, FragA, FRAG_A)
                    .commit();
        }
        if (hasBfragment) {
            FragmentB MyFragB = (FragmentB)
                    getChildFragmentManager().findFragmentByTag(FRAG_B);
            if (MyFragB == null) {
                MyFragB = FragmentB.newInstance();
                getChildFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentBcontainer, MyFragB, FRAG_B)
                        .commit();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
