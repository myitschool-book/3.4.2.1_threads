package ru.samsung.itschool.mdev.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String str="";
    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1= findViewById(R.id.text1);
        AnotherThread anotherThread=new AnotherThread();
        anotherThread.start();
    }

    class AnotherThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(1000); // Приостанавливает поток на 1 секунду
                } catch(InterruptedException e){}
                str = str + "2";
            }
        }
    }

    public void refresh(View view) {
        text1.setText(str);
    }
}