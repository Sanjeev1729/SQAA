package sqaa.com.cmrcet.sqaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class dashboard extends AppCompatActivity {

    TextView tv;
    String server_url="http://192.168.1.101:7777/info.php";
    StringRequest stringRequest;
    RequestQueue requestQueue;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
    }
}
