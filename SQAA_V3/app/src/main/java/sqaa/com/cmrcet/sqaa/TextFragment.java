package sqaa.com.cmrcet.sqaa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {

    Button b1;
    EditText ed1;
    String server_url="http://sankaranstandards.com/web_service/login";
    StringRequest stringRequest;
    RequestQueue requestQueue;
    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_text, container, false);
        b1=(Button) v.findViewById(R.id.btn1);
        ed1=(EditText) v.findViewById(R.id.editText);
        requestQueue= Volley.newRequestQueue(getActivity());
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                                          @Override
                                          public void onResponse(String response) {
                                              try {
                                                  JSONObject jsonObject = new JSONObject(response);
                                              }catch(Exception e){

                                              }
                                          }
                                      }, new Response.ErrorListener() {
                                          @Override
                                          public void onErrorResponse(VolleyError error) {

                                          }
                                      }){
                                          protected Map<String, String> getParams() throws AuthFailureError {
                                              HashMap<String, String> hashMap = new HashMap<String, String>();
                                              hashMap.put("username", ed1.getText().toString());
                                              return  hashMap;
                                          }
                                      };


                                  }
        }

        );
        return null;
    }

}
