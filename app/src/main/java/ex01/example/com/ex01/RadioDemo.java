 package ex01.example.com.ex01;

 import android.graphics.Color;
 import android.os.Bundle;
 import android.support.annotation.IdRes;
 import android.support.v7.app.AppCompatActivity;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;

 public class RadioDemo extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
     //1.변수선언
    RadioButton rdoRed, rdoGreen, rdoBlue;
    RadioGroup rdoGroup;
     LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio);
        // 2. 위젯 참조변수 설정
        rdoRed = (RadioButton)findViewById(R.id.rdoRed);
        rdoGreen = (RadioButton)findViewById(R.id.rdoGreen);
        rdoBlue = (RadioButton)findViewById(R.id.rdoBlue);
        rdoGroup = (RadioGroup)findViewById(R.id.rdoGroup);
        layout = (LinearLayout)findViewById(R.id.layout);

        //3.이벤트처리
        rdoGroup.setOnCheckedChangeListener(this);
    }

     @Override
     public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.rdoBlue:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.rdoGreen:
                layout.setBackgroundColor(Color.GREEN);

                break;
            case R.id.rdoRed:
                layout.setBackgroundColor(Color.RED);

                break;
        }
     }
 }
