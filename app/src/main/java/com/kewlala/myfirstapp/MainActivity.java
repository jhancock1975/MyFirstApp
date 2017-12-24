package com.kewlala.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.text.BidiFormatter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* important note: we must call setContentView before
            findViewById - we were getting a null pointer exception
            when the code to get the textView was above the call to
            setContentView
         */
        TextView textView = findViewById(R.id.activityMainHelloWorldTxt);
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        String helloWorld = getResources().getString(R.string.hello_world);
        //always use BidiFormatter.unicodeWrap for strings to
        //get proper left-to-right or right-to-left formatting

        //always use string.format for numbers to properly
        //render numbers
        textView.setText(bidiFormatter.unicodeWrap(helloWorld));


    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();


        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
