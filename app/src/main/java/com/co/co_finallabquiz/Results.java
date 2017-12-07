package com.co.co_finallabquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Results extends AppCompatActivity {

    TextView tvAuthor, tvQuote;
    FileInputStream fis = null;
    String filename, result;
    String[] content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvAuthor = (TextView) findViewById(R.id.author);
        tvQuote = (TextView) findViewById(R.id.quote);

        filename = "famousquote.txt";
        try{
            fis = openFileInput(filename);
            StringBuffer fileContent = new StringBuffer("");
            byte[] buffer = new byte[1024];
            int n;

            while((n = fis.read(buffer)) != -1){
                fileContent.append(new String(buffer, 0, n));
            }
            result = fileContent.toString();
            content = result.split("/");

            tvAuthor.setText(content[0]);
            tvQuote.setText(content[1]);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
