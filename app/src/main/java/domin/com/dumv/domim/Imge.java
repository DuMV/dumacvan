package domin.com.dumv.domim;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 8470p on 9/19/2016.
 */
public class Imge extends TextView {
    public Imge(Context context) {
        super(context);
    }

    public Imge(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Imge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai,dai); setTextSize(dai/3);
    }
}
