package sqaa.com.cmrcet.sqaa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class formgen extends Fragment {

     Button btn1,btn2;

    public formgen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_formgen, container, false);
        btn1=(Button)view.findViewById(R.id.idlessonobs);
        btn2=(Button)view.findViewById(R.id.idevidence);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lessonobs lessonobs=new lessonobs();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,lessonobs,lessonobs.getTag()).commit();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvidenceForm evidenceForm = new EvidenceForm();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,evidenceForm,evidenceForm.getTag()).commit();


            }
        });
        return view;
    }

}
