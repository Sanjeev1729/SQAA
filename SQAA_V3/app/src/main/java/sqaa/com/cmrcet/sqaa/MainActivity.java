package sqaa.com.cmrcet.sqaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    EditText tv,tv1;
    Button b1;
    private ProgressBar progressBar;
    String server_url="http://sankaranstandards.com/web_service/login";
    StringRequest stringRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(EditText)findViewById(R.id.editText);
        tv1=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        requestQueue= Volley.newRequestQueue(this);
        progressBar.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if(v==b1){
                                          startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                                          progressBar.setVisibility(View.VISIBLE);
                                       stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                                           @Override
                                           public void onResponse(String response) {
                                               try {
                                                   JSONObject jsonObject = new JSONObject(response);
                                                if(jsonObject.getString("login").equalsIgnoreCase("success")){
                                                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                                                    progressBar.setVisibility(View.INVISIBLE);
                                                }
                                                else{
                                                    progressBar.setVisibility(View.INVISIBLE);
                                                    Toast t=Toast.makeText(getApplicationContext(),"Invalid Credential",Toast.LENGTH_SHORT);
                                                    t.show();
                                                    tv.setText("");
                                                    tv1.setText("");
                                                    progressBar.setVisibility(View.INVISIBLE);
                                                }


                                               }catch(JSONException e){
                                              e.printStackTrace();
                                               }
                                           }
                                       }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {

                                           }
                                       }){
                                           @Override
                                           protected Map<String, String> getParams() throws AuthFailureError {
                                               HashMap<String,String> hashMap=new HashMap<String, String>();
                                               hashMap.put("username",tv.getText().toString());
                                               hashMap.put("password",tv1.getText().toString());

                                            return hashMap;
                                           }
                                       };
                                 requestQueue.add(stringRequest);
                                      }

                                  }
                              }

        );
    }
}
