package ex01.example.com.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {
    //1.위젯변수 선언
    TextView textResult;
    Button button100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);

        //2.위젯 연결
        textResult = (TextView) findViewById(R.id.textResult);
        button100 = (Button) findViewById(R.id.button100);

        Intent intent = getIntent();
        //객체 직렬화를 풀어서 다시 원래객체타입으로 복원시켜줌
        BmiDTO dto = (BmiDTO)intent.getSerializableExtra("dto");
        String name = dto.getName();
        int age = dto.getAge();
        double bmi = dto.getBmi();
        String result = dto.getResult();

//        String name = intent.getStringExtra("name");
//        String age = intent.getStringExtra("age");
//        double bmi = intent.getDoubleExtra("bmi",0);//기본값 넣어줘야됨
//        String result = intent.getStringExtra("result");

        textResult.setText("이름"+name+"\n"
                +"나이:"+age+"\n"
                +"bmi지수:"+bmi+"\n"
                +"결과:" +result
        );
        //4.버튼클릭 이벤트
        button100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();//현재화면을 종료
            }
        });
    }
}
