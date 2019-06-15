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
public class lessonobs extends Fragment {
    Button btn1;
    public lessonobs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lessonobs, container, false);
        btn1=(Button)view.findViewById(R.id.btnsubmitobs);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formgen frmgen  = new formgen();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,frmgen,frmgen.getTag()).commit();
                Toast.makeText(getContext(),"Upload Failed",Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }


}
