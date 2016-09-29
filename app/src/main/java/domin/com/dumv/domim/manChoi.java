package domin.com.dumv.domim;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 8470p on 9/19/2016.
 */
public class manChoi extends AppCompatActivity {
    GridView gdv;
    int i = 0, x = 0,t=0;
    adaptt adaptt;
    TextView txv,txvThoiGian;
    ImageView imgDD;
    ImageView imgDD2,imgreset,imgComplete;
    CountDownTimer timer;
    ArrayList<oDanhDau> arr;
    int sobom;
    int time=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_man_choi);
        gdv = (GridView) findViewById(R.id.mangBom);
        txv = (TextView) findViewById(R.id.txvSoBom);
        imgDD = (ImageView) findViewById(R.id.imgDD);
        imgDD2 = (ImageView) findViewById(R.id.imgDD2);
        imgreset=(ImageView)findViewById(R.id.imgreset);
        imgComplete=(ImageView)findViewById(R.id.imgComplete);
        txvThoiGian=(TextView)findViewById(R.id.txvThoiGian);

        sobom=Dataa.getInstrum().soBom;
        txv.setText(""+sobom);

        timer= new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time++;
                txvThoiGian.setText((time/60)+":"+(time%60));
       }

            @Override
            public void onFinish() {
                timer.start();
            }
        } ;

      // timer.start();

        imgComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(t==0){
                      timer.cancel();
                     gdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                         }
                     });
                     imgComplete.setImageResource(R.drawable.complete);
                     t=1;
                 }     else if(t==1){
                     timer.start();
                     gdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                             setClick(position);

                         }
                     });
                     imgComplete.setImageResource(R.drawable.pause);
                     t=0;
                 } else {

                 }
            }
        });

        imgreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr = new ArrayList<>();
                Dataa.getInstrum().KhoiTao100();
                adaptt = new adaptt(manChoi.this, R.layout.layout_man_choi, Dataa.getInstrum().arr);
                gdv.setAdapter(adaptt);
                gdv.setNumColumns(Dataa.getInstrum().k);
                i = 0;
                time=0;
                timer.cancel();
                txvThoiGian.setText((time/60)+":"+(time%60));
                imgComplete.setImageResource(R.drawable.complete);
                t=1;
                sobom=Dataa.getInstrum().soBom;
                txv.setText(""+sobom);
            }
        });
        imgDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sobom==0){
                    }else {
                    x = 1;

                }
            }
        });
        imgDD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sobom==Dataa.getInstrum().soBom){
                  }else {

                    x = 2;
               }
            }
        });





    }

    private void xetItemBom(int position) {
        if (adaptt.getItem(position).getmGiaTri() == -1) {
            i = 1;
            Toast.makeText(manChoi.this, "Ban Da Thua", Toast.LENGTH_SHORT).show();
             timer.cancel();
            t=2;
            Dataa.getInstrum().showAll();
            adaptt.notifyDataSetChanged();
        } else {
            Dataa.getInstrum().cc.trave(Dataa.getInstrum().arr, Dataa.getInstrum().k, position);

        }
        if (Dataa.getInstrum().tinhsoBom()) {
            i = 1;
            Toast.makeText(manChoi.this, "You Win", Toast.LENGTH_SHORT).show();
            t=2;
            Dataa.getInstrum().showAll();
            adaptt.notifyDataSetChanged();
        }

    }

    private void chuyenGT(int po) {
        if(Dataa.getInstrum().arr.get(po).isMtrangThai()==false){
        arr.add(new oDanhDau(adaptt.getItem(po).getmGiaTri(), po));
            sobom--;}
    }

    private void update() {
        for (int i = 0; i < arr.size(); i++) {
            Dataa.getInstrum().arr.get(arr.get(i).getVt()).setmGiaTri(10);
            Dataa.getInstrum().arr.get(arr.get(i).getVt()).setMtrangThai(false);

        }

        adaptt.notifyDataSetChanged();

    }

    private void udate(){
        for (int i = 0; i < arr.size(); i++) {
            Dataa.getInstrum().arr.get(arr.get(i).getVt()).setmGiaTri(arr.get(i).getGt());
        }
    }
    private void udate2(int p){
        for (int i = 0; i < arr.size(); i++) {
            if (p == arr.get(i).getVt()) {
          arr.remove(i);
                sobom++;
            }
        }
    }
    private boolean check(int po) {
        boolean b = false;
        for (int i = 0; i < arr.size(); i++) {
            if (po == arr.get(i).getVt()) {
                b = true;
                break;
            }
        }
        return b;
    }
    private void setClick(int position){
        udate();
        if (i == 0) {
            if (x == 1) {
                chuyenGT(position);
                update();
                x = 0;
            } else if(x==2) {
                udate2(position);
                update();
                x=0;
            }else {
                if (!check(position)) {
                    xetItemBom(position);
                    update();
                }
            }

        }
        txv.setText(""+sobom);
    }
}
