package edu.cs.birzeit.thread_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
    }

    public void btnMessage_Click(View view) {
        Toast.makeText(this, "Hello There", Toast.LENGTH_SHORT).show();
    }

    public void btnWork_Click(View view) {


        Thread thread = new Thread(new MyTask(5));

        thread.start();



    }

    class MyTask implements Runnable{
        int seconds;

        public MyTask(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {

            for(int i = 0; i<seconds; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            txt.post(new Runnable() {
                @Override
                public void run() {
                    txt.setText("Done,.... ");
                }
            });
        }
    }

    public void btnFreez_Click(View view) {

       for(int i = 0; i< 5; i++){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        txt.setText("Done freezing..");
    }
}