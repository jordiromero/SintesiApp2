package com.iesebre.sintesiapp2.sintesiapp;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by jordi on 03/06/14.
 */
public class ArrososFragment extends ListFragment {




   /** @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.arrosos_layout, container, false);

        return rootView;
        }**/
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[]{"1", "2","3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.menu_tot,values);
        setListAdapter(adapter);
    }


}
