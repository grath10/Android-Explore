package com.example.dell.app;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class FeedbackActivity extends AppCompatActivity {
    private static final String TAG = "FeedbackActivity";
    private String[] items = new String[]{"61780001:2", "61780002:6"};
    private Button control_btn;
    private Spinner client_picker;
    private LinearLayout outerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        control_btn = (Button)findViewById(R.id.button);
        client_picker = (Spinner)findViewById(R.id.clientPicker);
        outerLayout = (LinearLayout)findViewById(R.id.switchContainer);
        control_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clientInfo = (String)client_picker.getSelectedItem();
                String[] clientArr = clientInfo.split(":");
                String clientId = clientArr[0];
                int children = outerLayout.getChildCount();
                boolean[] states = new boolean[children];
                for (int i = 0; i < children; i++) {
                   LinearLayout innerLayout = (LinearLayout)outerLayout.getChildAt(i);
                   Switch oneSwitch = (Switch) innerLayout.getChildAt(1);
                   boolean status = oneSwitch.isChecked();
                   states[i] = status;
                }
            }
        });
        initSpinner();
    }

    private void initSpinner(){
        String[] clients = new String[]{"61780001", "61780002"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, clients);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        client_picker.setAdapter(adapter);
        client_picker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = items[i];
                createDynamicSwitches(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void createDynamicSwitches(String selectedItem){
        String[] strArr = selectedItem.split(":");
        int num = Integer.parseInt(strArr[1]);
        cleanLastLayout();
        for (int i = 0; i < num; i++) {
            View childView = createHorizontalLine(this, i);
            outerLayout.addView(childView);
        }
    }

    private void cleanLastLayout(){
        outerLayout.removeAllViews();
    }

    private View createHorizontalLine(Context context, int index){
        LinearLayout lineLayout = new LinearLayout(context);
        lineLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lineLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView label = new TextView(context);
        label.setText(index + "");
        Switch oneSwitch = new Switch(context);
        lineLayout.addView(label);
        lineLayout.addView(oneSwitch);
        return  lineLayout;
    }
}
