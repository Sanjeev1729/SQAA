package sqaa.com.cmrcet.sqaa;

/**
 * Created by KH9198 on 4/22/2017.
 */


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
public class EvidenceForm extends Fragment {

    Button btn1;
    Button cam1;
    Button cam2;
    Button cam3;
    Button cam4;
    Button cam5;
    Button video1;
    Button video2;
    Button video3;
    Button video4;
    Button video5;

    public EvidenceForm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.evidence_form, container, false);
        btn1=(Button)view.findViewById(R.id.btnsubmitevid);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formgen frmgen  = new formgen();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,frmgen,frmgen.getTag()).commit();
                Toast.makeText(getContext(),"Upload Failed",Toast.LENGTH_SHORT).show();
            }
        });
        cam1=(Button)view.findViewById(R.id.Ibtn1ps1);
        cam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraFragment cameraFragment=new CameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,cameraFragment,cameraFragment.getTag()).commit();
            }
        });
        video1=(Button)view.findViewById(R.id.Ibtn2ps1);
        video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoCameraFragment videoCameraFragment = new VideoCameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,videoCameraFragment,videoCameraFragment.getTag()).commit();
            }
        });
        cam2=(Button)view.findViewById(R.id.Ibtn1ps2);
        cam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraFragment cameraFragment=new CameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,cameraFragment,cameraFragment.getTag()).commit();
            }
        });
        video2=(Button)view.findViewById(R.id.Ibtn2ps2);
        video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoCameraFragment videoCameraFragment = new VideoCameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,videoCameraFragment,videoCameraFragment.getTag()).commit();
            }
        });
        cam3=(Button)view.findViewById(R.id.Ibtn1ps3);
        cam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraFragment cameraFragment=new CameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,cameraFragment,cameraFragment.getTag()).commit();
            }
        });
        video3=(Button)view.findViewById(R.id.Ibtn2ps3);
        video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoCameraFragment videoCameraFragment = new VideoCameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,videoCameraFragment,videoCameraFragment.getTag()).commit();
            }
        });
        cam4=(Button)view.findViewById(R.id.Ibtn1ps4);
        cam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraFragment cameraFragment=new CameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,cameraFragment,cameraFragment.getTag()).commit();
            }
        });
        video4=(Button)view.findViewById(R.id.Ibtn2ps4);
        video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoCameraFragment videoCameraFragment = new VideoCameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,videoCameraFragment,videoCameraFragment.getTag()).commit();
            }
        });
        cam5=(Button)view.findViewById(R.id.Ibtn1ps5);
        cam5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraFragment cameraFragment=new CameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,cameraFragment,cameraFragment.getTag()).commit();
            }
        });
        video5=(Button)view.findViewById(R.id.Ibtn2ps5);
        video5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoCameraFragment videoCameraFragment = new VideoCameraFragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.RelativeLayoutFrag,videoCameraFragment,videoCameraFragment.getTag()).commit();
            }
        });
        return view;
    }

}
