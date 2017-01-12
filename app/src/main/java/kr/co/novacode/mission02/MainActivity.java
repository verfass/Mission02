package kr.co.novacode.mission02;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Activity activity;
    Button button01, button02;
    TextView textView;
    EditText editText;
    Editable smsMsg;
    TextWatcher textWatcher;
    int textCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        editText = (EditText)findViewById(R.id.editText);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                smsMsg = editText.getText();
                textCnt = smsMsg.length();
                printSmsLength(textCnt);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        editText.addTextChangedListener(textWatcher);


        button01 = (Button)findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsMsg = editText.getText();
                Toast.makeText(MainActivity.this, smsMsg, Toast.LENGTH_LONG).show();
            }
        });

        button02 = (Button)findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = MainActivity.this;
                activity.finish();
            }
        });

        printSmsLength(0);
    }

    public void printSmsLength(int cnt) {
        textView.setText(cnt + "/80 Byte");
    }


}
