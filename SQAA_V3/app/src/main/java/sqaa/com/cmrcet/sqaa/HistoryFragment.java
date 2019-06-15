package sqaa.com.cmrcet.sqaa;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {



    ArrayList<DataModel> dataModels;
    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
     //   getActivity().getActionBar().setTitle(getResources().getString(R.string.Institution_list));
        ListView listView = (ListView) view.findViewById(R.id.data);
        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Delhi Public School", "Visited"));
        dataModels.add(new DataModel("KV AFS Begumpet", "Visited"));
        dataModels.add(new DataModel("CMRCET", "Not Visited"));
        dataModels.add(new DataModel("Bhashyam High School","Visited"));

        CustomAdapter adapter= new CustomAdapter(dataModels,getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getInstitutionName()+"\n"+dataModel.getInstitutionStatus(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });

        return view;
    }

}
