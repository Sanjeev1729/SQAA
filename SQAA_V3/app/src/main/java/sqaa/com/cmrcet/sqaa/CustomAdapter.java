package sqaa.com.cmrcet.sqaa;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by KH9198 on 4/8/2017.
 */

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
          }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.list_xml, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;

        switch (v.getId())
        {
            case R.id.InstitutionStatus:
                Snackbar.make(v, "Release date " +dataModel.getInstitutionStatus(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_xml, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.InstitutionName);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.InstitutionStatus);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        viewHolder.txtName.setText(dataModel.getInstitutionName());
        if(dataModel.getInstitutionStatus().equals("Visited"))
        viewHolder.txtType.setText(dataModel.getInstitutionStatus());
        else{
            viewHolder.txtType.setText(dataModel.getInstitutionStatus());
            viewHolder.txtType.setTextColor(getContext().getResources().getColor(R.color.Red));
        }
        // Return the completed view to render on screen
        return convertView;
    }
}