package sqaa.com.cmrcet.sqaa;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {
    Button btn1,btn2;
    ImageView img;
    static final int CAM_REQ=1;
    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_camera, container, false);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.button2);
        img=(ImageView) view.findViewById(R.id.imageView2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent cameraIntent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File imgFiles=getFile();
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imgFiles));
                    //     cameraIntent.putExtra( android.provider.MediaStore.EXTRA_SIZE_LIMIT, "7200");
                    startActivityForResult(cameraIntent,CAM_REQ);
                }catch(Exception e){
                    Toast.makeText(getContext(),"Failed in capture image",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    GPSTracker gps = new GPSTracker(getActivity());

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Toast t=Toast.makeText(getContext(),"latitude - "+latitude+" and longitude-"+longitude,Toast.LENGTH_LONG);
                    t.show();

                }catch(Exception e){
                    Toast.makeText(getContext(),"Failed to capture GPS",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private File getFile(){

        File file= new File("sdcard/camerastorage");
        if(!file.exists()){
            file.mkdir();
        }
        File imgFile=new File(file,"capturedpics.jpg");
        return imgFile;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/camerastorage/capturedpics.jpg";

        class PhotoTask extends AsyncTask<Cloudinary,Object,Object>{
            Object o;
            @Override
            protected Object doInBackground(Cloudinary... params) {
                try {
                    o = params[0].uploader().upload("sdcard/camerastorage/capturedpics.jpg", ObjectUtils.emptyMap());

                    // Toast t=Toast.makeText(getContext(),"Upload is successful",Toast.LENGTH_LONG);
                    //  t.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    //    Toast.makeText(getContext(),"Failure",Toast.LENGTH_LONG).show();
                }
                return o;
            }

            @Override
            protected void onPostExecute(Object s) {
                try {
                    super.onPostExecute(s);
                    String path="sdcard/camerastorage";
                    img.setImageDrawable(Drawable.createFromPath(path));
//                    HashMap hm = (HashMap)s;
//                    String urls = (String)hm.get("url");
                    GPSTracker gps = new GPSTracker(getActivity());
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Toast t=Toast.makeText(getContext(),"Upload is successful and image captured at latitude-"+latitude+"and longitude-"+longitude,Toast.LENGTH_LONG);
                    t.show();
//                    URL url = new URL(urls);
//                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                    img.setImageBitmap(bmp);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"Failed in postexecute",Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
        Map config = new HashMap();
        config.put("cloud_name", "dgbzpf9b6");
        config.put("api_key", "742166653246826");
        config.put("api_secret", "fHF__DOOHvejulu9qMtUt3Mdr9c");
        Cloudinary cloudinary = new Cloudinary(config);
        PhotoTask photoTask = new PhotoTask();
        photoTask.execute(cloudinary);


    }
}
