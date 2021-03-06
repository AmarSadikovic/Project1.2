package se.mah.af6851.project12;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amar on 2017-01-23.
 */

public class ListAdapter extends ArrayAdapter<Sensor> {
    private LayoutInflater inflater;


    public ListAdapter(Context context,  List<Sensor> sensorList) {
        super(context, R.layout.adapter_layout , sensorList);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = (LinearLayout)inflater.inflate( R.layout.adapter_layout,parent,false);
            holder = new ViewHolder();
            holder.tv = (TextView)convertView.findViewById(R.id.tvAdapter);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv.setText(getItem(position).getName());

        return convertView;
    }

    private class ViewHolder{
        TextView tv;
    }
}
