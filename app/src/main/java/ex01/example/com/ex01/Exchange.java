package ex01.example.com.ex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exchange extends AppCompatActivity {
//1.위젯 선언
    EditText dollar;
    Button button;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange);
        //2.위젯 생성
        dollar = (EditText)findViewById(R.id.dollar);
        button = (Button) findViewById(R.id.button);
        txtResult = (TextView) findViewById(R.id.txtResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText는 getText().toString()을 해야 스트링으로 변환됨
                if(dollar.getText().toString().equals("")){
                    //Toast.makeText(출력할 클래스.this, "메시지", 출력옵션).show()
                    //Toast.LENGTH_LONG 과 Toast.LENGTH_SHORT 은 토스트 보여주는 시간
                    Toast.makeText(Exchange.this, "숫자를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                int intDollar = Integer.parseInt(dollar.getText().toString());
                int money = intDollar * 1100;
                //String.format("출력형식", 출력할값
                txtResult.setText(intDollar+"달러 = "
                        +String.format("%,d",money)+"원 입니다");
            }
        });
    }
}
