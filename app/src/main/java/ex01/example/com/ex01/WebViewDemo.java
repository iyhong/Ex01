package ex01.example.com.ex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class WebViewDemo extends AppCompatActivity {

    EditText editUrl;
    Button button;
    WebView webview1;
    ProgressBar progress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        editUrl = (EditText)findViewById(R.id.editUrl);
        button = (Button)findViewById(R.id.button);
        webview1 = (WebView)findViewById(R.id.webview1);
        progress1 = (ProgressBar)findViewById(R.id.progress1);


        //현재 화면의 웹뷰에 웹브라우저 내용이 출력되도록 설정
        webview1.setWebViewClient(new WebViewClient());

        //웹뷰에 프로그래스바 연결
        webview1.setWebChromeClient(new WebChromeClient(){

            //진행률이 변경될때 호출되는 메서드
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // newProgress => 진행률 변경값
                progress1.setProgress(newProgress);

                // View.GONE 화면표시x, 자리차지하지 않음
                // View.INVISEIBLE 화면표시x, 자리는 차지함
                // View.VISIBLE 화면표시o
                if(newProgress == 100){
                    progress1.setVisibility(View.GONE); //숨김
                }else{
                    progress1.setVisibility(View.VISIBLE);//표시
                }

                super.onProgressChanged(view, newProgress);
            }
        });

        //버튼 클릭 이벤트
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editUrl.getText().toString();
                //사용자가 입력한 url에 http:// 가 없으면 추가해줌
                if(url.indexOf("http://")== -1){
                    url = "http://" + url;
                }
                //웹뷰에 url을 받아 로드한다.
                webview1.loadUrl(url);
            }
        });
    }
}
