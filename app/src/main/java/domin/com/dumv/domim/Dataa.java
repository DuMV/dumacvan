package domin.com.dumv.domim;

import java.util.ArrayList;

import thuvien.CongCu;
import thuvien.O;

/**
 * Created by 8470p on 9/19/2016.
 */
public class Dataa {
    public static Dataa dataa;
    ArrayList<O> arr;
    int k,soBom,soO,time,soO2,so;
    CongCu cc= new CongCu();
    static {
        dataa= new Dataa();
    }

    public static Dataa getInstrum() {
        return dataa;
    }
    public void KhoiTao100 (){
        arr= new ArrayList<>(cc.KhoiTaoO(soBom, soO,k));
       soO2=soO-soBom;
    }
    public void showAll(){
        for(int i=0;i<arr.size();i++){
             arr.get(i).setMtrangThai(true);
        }
    }
    public boolean tinhsoBom(){
        int s1=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).isMtrangThai()){
               s1++;
            }
        }
        so=s1;
        if(s1==soO2){
            return true;
        }               else {
            return false;
        }
    }
}
