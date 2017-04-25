package ex01.example.com.ex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckboxDemo extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {
    //1.위젯 선언
    CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);
        //2. 위젯 가져오기
        check = (CheckBox)findViewById(R.id.check);

        //3. 이벤트처리
        //체크박스의 체크 상태가 변경되면 현재 클래스에 implement된
        //onCheckedChanged 메서드가 호출됨
        check.setOnCheckedChangeListener(this);

    }

    //체크박스를 체크할때 호출되는 메서드
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            check.setText("체크 상태");

        }else{
            check.setText("체크되지 않은 상태");
        }
    }


}
