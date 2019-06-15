package sqaa.com.cmrcet.sqaa;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * Created by KH9198 on 4/7/2017.
 */
public class VideoCameraFragment extends Fragment {
    private Uri fileUri;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    public static VideoCameraFragment ActivityContext =null;
    public static TextView output;

    Button btn1;
    ImageView img;
    static final int CAM_REQ=1;
    public VideoCameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video, container, false);

        ActivityContext = this;

        Button buttonRecording = (Button)view.findViewById(R.id.recording);
        Button btn2 = (Button)view.findViewById(R.id.button2);

        buttonRecording.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                // create new Intentwith with Standard Intent action that can be
                // sent to have the camera application capture an video and return it.
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

                // create a file to save the video
                fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);

                // set the image file name
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                // set the video image quality to high
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

                // start the Video Capture Intent
                startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);

            }});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    GPSTracker gps = new GPSTracker(getActivity());

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Toast t=Toast.makeText(getContext(),"latitude - "+latitude+" and longitude - "+longitude,Toast.LENGTH_LONG);
                    t.show();
                }catch(Exception e){
                    Toast.makeText(getContext(),"Failed to capture GPS",Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }
    private static Uri getOutputMediaFileUri(int type){
            VideoCameraFragment vid = new VideoCameraFragment();
        return Uri.fromFile(vid.getOutputMediaFile(type));
    }

    private File getOutputMediaFile(int type){

        File file= new File("sdcard/videostorage");
        if(!file.exists()){
            file.mkdir();
        }
        File imgFile=new File(file,"capturedvideo.mp4");
        return imgFile;
    }
    /** Create a File for saving an image or video */
    private  File getFile(int type){

        // Check that the SDCard is mounted
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraVideo");


        // Create the storage directory(MyCameraVideo) if it does not exist
        if (! mediaStorageDir.exists()){

            if (! mediaStorageDir.mkdirs()){

                output.setText("Failed to create directory MyCameraVideo.");
                Toast.makeText(getContext(), "Failed to create directory MyCameraVideo.", Toast.LENGTH_LONG).show();

                Log.d("MyCameraVideo", "Failed to create directory MyCameraVideo.");
                return null;
            }
        }


        // Create a media file name

        // For unique file name appending current timeStamp with file name
        java.util.Date date= new java.util.Date();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(date.getTime());

        File mediaFile;

        if(type == MEDIA_TYPE_VIDEO) {

            // For unique video file name appending current timeStamp with file name
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");

        } else {
            return null;
        }

        return mediaFile;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // After camera screen this code will excuted

        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

        //        output.setText("Video File : " +data.getData());

                // Video captured and saved to fileUri specified in the Intent
                Toast.makeText(getContext(), "Video saved to:"  , Toast.LENGTH_LONG).show();

                class PhotoTask extends AsyncTask<Cloudinary,Object,Object>{
                    Object o;
                    @Override
                    protected Object doInBackground(Cloudinary... params) {
                        try {
                            o = params[0].uploader().upload("sdcard/videostorage/capturedvideo.mp4", ObjectUtils.asMap("resource_type", "video"));

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(),"Failure",Toast.LENGTH_LONG).show();
                        }
                        return o;
                    }

                    @Override
                    protected void onPostExecute(Object s) {
                        try {
                            super.onPostExecute(s);
                            String path="sdcard/videostorage";
                           // img.setImageDrawable(Drawable.createFromPath(path));
//                    HashMap hm = (HashMap)s;
//                    String urls = (String)hm.get("url");
                            GPSTracker gps = new GPSTracker(getActivity());
                            double latitude = gps.getLatitude();
                            double longitude = gps.getLongitude();
                            Toast t=Toast.makeText(getContext(),"Upload is successful and  captured at latitude-"+latitude+"and longitude-"+longitude,Toast.LENGTH_LONG);
                            t.show();
//
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



            } else if (resultCode == RESULT_CANCELED) {

                output.setText("User cancelled the video capture.");

                // User cancelled the video capture
                Toast.makeText(getContext(), "User cancelled the video capture.",
                        Toast.LENGTH_LONG).show();

            } else {

                output.setText("Video capture failed.");

                // Video capture failed, advise user
                Toast.makeText(getContext(), "Video capture failed.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}

