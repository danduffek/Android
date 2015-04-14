package com.example.dduffek.dynamicfragmentsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {

    public static FragmentA newInstance() {
        Log.i("A", "In newInstance.");
        FragmentA myFragA = new FragmentA();
        Bundle args = new Bundle();
        myFragA.setArguments(args);
        return myFragA;
    }

    public FragmentA() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("A", "In onCreate.");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i("A", "In onAttach.");
        super.onAttach(activity);
        Fragment parent = getParentFragment();
        Object objectToCast = parent != null ? parent : activity;
//        try {
//            listener = (ContactListFragmentListener) objectToCast;
//        }
//        catch (ClassCastException e) {
//            throw new ClassCastException(objectToCast.getClass().getSimpleName()
//                    + " must implement ContactListFragmentListener");
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("A", "In onCreateView.");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i("A", "In onViewCreated.");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("A", "In onActivityCreated.");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
