//package com.example.practice;
// MainActivity

//ExSample2_03.java 基本的なイベント処理のサンプル
package com.example.practice;

import android.app.*;
import android.graphics.Color;
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
    ListView lv1, lv2;
    Spinner sp;

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
        rb[0].setText("red");  //ラジオボタンのテキストの設定
        rb[1].setText("blue");
        rb[2].setText("yellow");
        rg = new RadioGroup(this);  //ラジオグループの生成
        for(int i=0; i<rb.length; i++)  //ラジオグループにラジオボタンを登録
            rg.addView(rb[i]);
        rb[0].setChecked(true);


        //lv1 = new ListView(this);  //リストビュー1の生成
        lv2 = new ListView(this);  //リストビュー2の生成
        sp = new Spinner(this);  //スピナーの生成

        Integer[] pix ={4,8,12,
                16,20};  //リストビュー、スピナーに格納するテキストデータ

        ArrayAdapter<Integer> ad = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, pix);  //テキストをリストビュー、スピナーに渡すためのアレイアダプター
        //lv1.setAdapter(ad);  //リストビュー1にアレイアダプターを登録
        lv2.setAdapter(ad);  //リストビュー2にアレイアダプターを登録

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  //アレイアダプターにドロップダウンリストを設定
        sp.setAdapter(ad);  //スピナーにアレイアダプターを登録

        ScrollView sv = new ScrollView(this);  //スクロールビューの生成


        ll.addView(tv);
        ll.addView(et);
        ll.addView(bt);
        ll.addView(bt2);
        ll.addView(rg);  //リニアレイアウトへラジオグループの登録
        //ll.addView(lv1);  //リニアレイアウトにリストビューを設定
        ll.addView(sp);  //リニアレイアウトにスピナーを設定
        ll.addView(sv);  //リニアレイアウトにスピナーを設定
        //sv.addView(lv2);  //スクロールビューにリストビューを設定

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
            rb[i].setOnClickListener(new ExSampleClickListener2());  //ラジオボタンクリック時のリスナー登録

        //lv1.setOnItemClickListener(new ExSampleItemClickListener());  //リストビュー1のアイテムクリック時のリスナー登録
        //lv2.setOnItemClickListener(new ExSampleItemClickListener());  //リストビュー2のアイテムクリック時のリスナー登録
        sp.setOnItemSelectedListener(new ExSampleItemSelectedListener());  //スピナーのアイテム選択時のリスナー登録
    }

    class ExSampleClickListener implements OnClickListener{  //ボタンがクリックされたときのイベント処理
        public void onClick(View v){
            tv.setText("兼六園がおすすめです！");
        }  //ボタンがクリックされたときの具体的な処理
    }

    class ExSampleClickListener2 implements OnClickListener{  //ボタンがクリックされたときのイベント処理
        public void onClick(View v){
            TextView tmp = (TextView) v;
            String str = tmp.getText().toString();
            if (str == "red"){
                tv.setTextColor(Color.RED);  //テキストの色の設定
            }
            else if (str == "blue"){
                tv.setTextColor(Color.BLUE);  //テキストの色の設定
            }
            else if (str == "yellow"){
                tv.setTextColor(Color.YELLOW);  //テキストの色の設定
            }

        }  //ボタンがクリックされたときの具体的な処理
    }




    /*
    class ExSampleItemClickListener implements AdapterView.OnItemClickListener {  //リストビューのアイテムクリック時のイベント処理
        public void onItemClick(AdapterView<?>v, View iv, int pos, long id){
            TextView tmp = (TextView) iv;
            tv.setText(tmp.getText() + "を表示します。");
        }
    }*/

    class ExSampleItemSelectedListener implements AdapterView.OnItemSelectedListener {  //スピナーのアイテムクリック時のイベント処理
        public void onItemSelected(AdapterView<?>v, View iv, int pos, long id){
            TextView tmp = (TextView) iv;
            String str = tmp.getText().toString();
            int i = Integer.parseInt(str);

            tv.setText(tmp.getText() + "を表示します。");
            tv.setTextSize(i*2);  //テキストサイズの設定
        }
        public void onNothingSelected(AdapterView<?> arg0){}
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