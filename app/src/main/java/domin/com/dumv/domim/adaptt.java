package domin.com.dumv.domim;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import thuvien.O;

/**
 * Created by 8470p on 9/19/2016.
 */
public class adaptt extends ArrayAdapter<O> {
    ArrayList<O> arr;
    Context ct;

    public adaptt(Context context, int resource, List<O> objects) {
        super(context, resource, objects);
        ct = context;
        arr = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_o, null);
        }
        if (arr.size() > 0) {
         LinearLayout la= (LinearLayout)row.findViewById(R.id.la);
            TextView txv = (TextView) row.findViewById(R.id.img);
            if (arr.get(position).isMtrangThai()) {

                if (arr.get(position).getmGiaTri() == -1) {
                    txv.setBackgroundResource(R.drawable.boom);
                 la.setBackgroundColor(Color.parseColor("#ffffff"));
                } else if (arr.get(position).getmGiaTri() == 0) {
                    txv.setText(" ");
                    txv.setBackgroundColor(Color.parseColor("#ffffff"));
                    la.setBackgroundColor(Color.parseColor("#000000"));
                } else if(arr.get(position).getmGiaTri()!=0&&arr.get(position).getmGiaTri()!=-1){
                    txv.setBackgroundColor(Color.parseColor("#ffffff"));
                    la.setBackgroundColor(Color.parseColor("#000000"));
                    txv.setText(Integer.toString(arr.get(position).getmGiaTri()));
                }
            } else {
                if(arr.get(position).getmGiaTri()==10){
                txv.setBackgroundResource(R.drawable.cam);
                    la.setBackgroundColor(Color.parseColor("#ffffff"));
            }   else{
                txv.setText(" ");
                    la.setBackgroundColor(Color.parseColor("#000000"));
                    txv.setBackgroundColor(Color.parseColor("#c0c0c0"));
            }       }
        }
        return row;
    }
}
