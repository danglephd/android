package com.example.danglph.myapplication1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lord.sprite.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        // Set fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new SpriteView(this));

//        setContentView(new NewSpriteView(this));


//        Log.d(TAG, "Starting...");
//
//        btn = (Button) findViewById(R.id.button2);
//        if (btn != null) {
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    try {
//                        TextView viewer = (TextView) findViewById(R.id.textView);
//                        viewer.setText("button2 Click");
//                    } catch (Exception ex) {
//                        Log.d(TAG, ex.getMessage());
//                    }
//                }
//            });
//        } else {
//            Log.d(TAG, "btn null...");
//        }

    }

    protected void btClick(View item) {
        try {
            EditText et = (EditText) findViewById(R.id.editText);
            TextView viewer = (TextView) findViewById(R.id.textView);
            viewer.setText(et.getText());
            ((Button)item).setText("Abc");
        }catch (Exception ex){
            Log.e(TAG, ex.getMessage(), ex);
        }
    }

}
