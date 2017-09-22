package com.example.dell.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "BroadcastActivity";
    private Button btn_sendMsg;
    private EditText et_messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        et_messages = (EditText) findViewById(R.id.message_broadcast);
        btn_sendMsg = (Button) findViewById(R.id.send_broadcast);
        btn_sendMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_broadcast:
                String msg = et_messages.getText().toString();
                // 删去回车符
                msg = msg.replace("\r\n","");
                char[] charArr = msg.toCharArray();
                StringBuilder builder = new StringBuilder();
                for (char character : charArr) {
                    builder.append(Integer.toHexString(character));
                }
                Log.i(TAG, builder.toString());
                break;
            default:
                break;
        }
    }

    private boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
}
