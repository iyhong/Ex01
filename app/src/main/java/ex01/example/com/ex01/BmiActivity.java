package ex01.example.com.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    //1.변수선언
    EditText editName, editAge, editHeight, editWeight;
    Button button1;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        //2.위젯 생성(R.java에서 아이디 참조)
        editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText)findViewById(R.id.editAge);
        editHeight = (EditText)findViewById(R.id.editHeight);
        editWeight = (EditText)findViewById(R.id.editWeight);
        button1 = (Button)findViewById(R.id.button1);
        textResult = (TextView)findViewById(R.id.textResult);

        //3.이벤트 처리
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(BmiActivity.this, BmiResultActivity.class);

                //bmi 몸무게/(신장*신장)
                double kg = Double.parseDouble(editWeight.getText().toString());
                double height = Double.parseDouble(editHeight.getText().toString())/100;
                //18.5 저체중 18.5~23정상, 23~25과체중
                //25~30비만 30이상 고도비만
                String result="";
                double bmi = kg / (height * height);
                if( bmi <18.5){
                    result="저체중";
                }else if(bmi>=18.5 && bmi<23){
                    result="정상";
                }else if(bmi>=23 && bmi<25) {
                    result = "과체중";
                }else if(bmi>=25 && bmi<30) {
                    result = "비만";
                }else if(bmi>=30){
                    result = "고도비만";
                }
                //intent.putExtra("변수명", 값)
                //intent에 맵처럼 값을 담아 넘긴다.
                BmiDTO dto = new BmiDTO();
                dto.setAge(Integer.parseInt(editAge.getText().toString()));
                dto.setName(editName.getText().toString());
                dto.setBmi(bmi);
                dto.setResult(result);
                intent.putExtra("dto", dto);

//                intent.putExtra("bmi", bmi);
//                intent.putExtra("result",result);
//                intent.putExtra("name", editName.getText().toString());
//                intent.putExtra("age", editAge.getText().toString());

                startActivity(intent);

               // textResult.setText("bmi 지수 :"+bmi+"\n"+ result+"입니다.");

            }
        });

    }
//화면을 재시작할때 호출
    @Override
    protected void onResume() {
        super.onResume();
        editAge.setText("");
        editHeight.setText("");
        editName.setText("");
        editWeight.setText("");
    }
}
