package com.co.co_finallabquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etAuthor, etQuote;
    String filename, author, quote, message;
    FileOutputStream fos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAuthor = (EditText) findViewById(R.id.author);
        etQuote = (EditText) findViewById(R.id.quote);

    }

    public void saveRecord(View view){
        author = etAuthor.getText().toString();
        quote = "\"" + etQuote.getText().toString() + "\"";
        filename = "famousquote.txt";
        message = author + "/" + quote;

        if(etAuthor.getText().toString() == null || etQuote.getText().toString() == null){
            Toast.makeText(this, "Please complete the required fields to continue", Toast.LENGTH_LONG).show();
        }else{
            try{
                fos = openFileOutput(filename, Context.MODE_PRIVATE);
                fos.write(message.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(this, "Quote saved!", Toast.LENGTH_LONG).show();
        }
    }

    public void next(View view){
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }
}
