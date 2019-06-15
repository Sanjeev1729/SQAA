package sqaa.com.cmrcet.sqaa;

/**
 * Created by KH9198 on 4/22/2017.
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class GPSActivity extends Activity {

    TextView textview1,textview2,textView3,textview4,textView5,textview6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_locations);
        GPSTracker gps = new GPSTracker(this);
        textview1 =(TextView)findViewById(R.id.fieldLatitude);
        textview2 =(TextView)findViewById(R.id.fieldLongitude);
        textView3 =(TextView)findViewById(R.id.fieldAddressLine);


        if(gps.canGetLocation()){
            textview1.setText(String.valueOf(gps.getLatitude()));

            textview2.setText(String.valueOf(gps.getLongitude()));

//            textview4.setText(String.valueOf(gps.getCountryName(this.getApplicationContext())));

        }
    }
}
