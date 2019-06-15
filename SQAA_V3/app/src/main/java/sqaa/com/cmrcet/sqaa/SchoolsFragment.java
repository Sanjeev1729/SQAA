package sqaa.com.cmrcet.sqaa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolsFragment extends Fragment {

   Button evalbtn;

    public SchoolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_schools, container, false);
        evalbtn=(Button)view.findViewById(R.id.evalbtn);
        evalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formgen formgen=new formgen();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,formgen,formgen.getTag()).commit();

            }
        });

        return  view;
    }

}
