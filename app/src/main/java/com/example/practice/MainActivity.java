//package com.example.practice;
// MainActivity

//ExSample2_03.java 基本的なイベント処理のサンプル
package com.example.practice;

import android.app.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    Button bt;
    Button bt2;
    RadioButton rb[] = new RadioButton[3];
    RadioGroup rg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll =new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);
        tv.setText("こんにちは！");

        bt = new Button(this);
        bt.setText("検索");

        bt2 = new Button(this);
        bt2.setText("押してみなはれ");

        et = new EditText(this);  //エディットテキストの生成

        for(int i=0; i<rb.length; i++)  //ラジオボタンの各要素の生成
            rb[i] = new RadioButton(this);
        rb[0].setText("近江町市場");  //ラジオボタンのテキストの設定
        rb[1].setText("東茶屋街");
        rb[2].setText("武家屋敷");
        rg = new RadioGroup(this);  //ラジオグループの生成
        for(int i=0; i<rb.length; i++)  //ラジオグループにラジオボタンを登録
            rg.addView(rb[i]);
        rb[0].setChecked(true);


        ll.addView(tv);
        ll.addView(bt);
        ll.addView(bt2);
        ll.addView(et);
        ll.addView(rg);  //リニアレイアウトへラジオグループの登録

        //匿名クラスによる記述法
        bt2.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        tv.setText(et.getText() + "を検索しました。");
                        bt2.setEnabled(false);  //ボタンの無効化
                    }
                }
        );

        bt.setOnClickListener(new ExSampleClickListener());  //ボタンがクリックされるときのリスナー登録
        //bt.setOnTouchListener(new ExSampleTouchListener());  //ボタンがタッチされるときのリスナー登録
        for(int i=0; i<rb.length; i++)
            rb[i].setOnClickListener(new ExSampleClickListener());  //ラジオボタンクリック時のリスナー登録

    }

    class ExSampleClickListener implements OnClickListener{  //ボタンがクリックされたときのイベント処理
        public void onClick(View v){
            tv.setText("兼六園がおすすめです！");
        }  //ボタンがクリックされたときの具体的な処理
    }

/*    class ExSampleTouchListener implements OnTouchListener{  //ボタンがタッチされたときのイベント処理
    	public boolean onTouch(View v, MotionEvent e){
    		if(e.getAction() == MotionEvent.ACTION_DOWN){  //ボタンが押されているときの具体的な処理
    			tv.setText("検索中です...");
    		}
            else if(e.getAction() == MotionEvent.ACTION_UP){  //ボタンが上がった時の具体的な処理
            	tv.setText("21世紀美術館がおすすめです!");
            }
    		return true;
    	}
    }*/
}