package ex01.example.com.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test","onCreate() 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test","onStart() 호출");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("test","onPostResume() 호출");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test","onResume() 호출");

    }

    //버튼을 누르면 실행되는 메서드
    public void onClick(View v){

        //new Intent(현재클래스.this, 다음 화면 클래스.class)
        Intent intent = null;
        //v.getId() : 클릭한 버튼의 아이디
        //R : 리소스 저장 클래스
        switch(v.getId()){
            case R.id.button1:
                intent = new Intent(this, ImageViewDemo.class);
                break;
            case R.id.button2:
                intent = new Intent(this, Exchange.class);
                break;
            case R.id.button3:
                intent = new Intent(this, BmiActivity.class);
                break;
            case R.id.button4:
                intent = new Intent(this, CheckboxDemo.class);
                break;
            case R.id.button5:
                intent = new Intent(this, RadioDemo.class);
                break;
            case R.id.button6:
                intent = new Intent(this, YutActivity.class);
                break;
            case R.id.button7:
                intent = new Intent(this, ScrollActivity.class);
                break;
            case R.id.button8:
                intent = new Intent(this, WebViewDemo.class);
                break;
        }
        //화면 전환
        startActivity(intent);

    }
}
