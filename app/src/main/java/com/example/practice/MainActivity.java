//ExSample2_04.java 画面とキーボード操作に関するサンプル
package com.example.practice;
import android.app.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll =new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);
        tv.setText("金沢へようこそ！");

        ll.addView(tv);
    }

    public boolean onTouchEvent(MotionEvent e){  //画面がタッチされているときの処理
        if(e.getAction() == MotionEvent.ACTION_DOWN){
            tv.setText("検索を開始しますか？");
        }
        else if(e.getAction() == MotionEvent.ACTION_UP){
            tv.setText("近江町市場がおすすめです！");
        }
        return true;
    }

    public boolean onKeyDown(int keycode, KeyEvent e){  //キーボードが押されたときの処理
        String str;
        switch(keycode){
            case KeyEvent.KEYCODE_DPAD_UP:
                str = "北を探します"; break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                str = "南を探します"; break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                str = "西を探します"; break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                str = "東を探します"; break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                str = "現在地を探します"; break;
            default:
                str = "矢印キーを押してください";
        }
        tv.setText(str);
        return true;
    }
}