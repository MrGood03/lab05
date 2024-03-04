package com.example.lab05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText txt;
        CheckBox ch1;
        CheckBox ch2;
        EditText txt1;

    public void ODlg(View v)
    {
        try
        {

                String s =txt.getText().toString();
                Intent i =new Intent(this,MainActivity2.class);
                i.putExtra("abc",s);
                startActivityForResult(i,555);
                txt1=findViewById(R.id.ETxt1);
                ch1= findViewById(R.id.checkF);
                ch2 = findViewById(R.id.checkS);
                String t1= txt1.getText().toString();
                Intent intent   = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("CBox1",ch1.isChecked());
                intent.putExtra("CBox2",ch2.isChecked());
                intent.putExtra("Text1",t1);
                startActivity(intent);



        }
        catch (Exception ignored){}
    }
    public void EAp (View v)
    {
        try {


            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_layout, null);
            builder.setIcon(R.drawable.android);
            TextView title = (TextView) view.findViewById(R.id.title);

            builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }


            });
            builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Выход отменён", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setView(view);
            builder.show();
        }
        catch (Exception ignored){}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txt = findViewById(R.id.ETxt1);
            Intent i =getIntent();
            String s= i.getStringExtra("abc");
            txt1=findViewById(R.id.ETxt1);
            ch1=findViewById(R.id.checkF);
            ch2= findViewById(R.id.checkS);
            Boolean s1= getIntent().getBooleanExtra("switch1",false);
            Boolean s2= getIntent().getBooleanExtra("switch2",false);
            String t2= getIntent().getStringExtra("Text2");
            txt1.setText(t2);
            ch1.setChecked(s1);
            ch2.setChecked(s2);



        }
        catch (Exception ignored){}


    }




}