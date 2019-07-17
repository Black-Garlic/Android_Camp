package com.example.androidcamp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        
        setButtons();
    }

    private void setButtons() {
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            displayDialolg();
        } else if (v.getId() == R.id.button2) {
            displayRadio();
        } else if (v.getId() == R.id.button3) {
            displayCheck();
        } else if (v.getId() == R.id.button4) {
            displayCustom();
        } else if (v.getId() == R.id.button5) {
            displayAlert();
        } else if (v.getId() == R.id.button6) {
            displayCustom();
        }
    }

    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void displayDialolg() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본 대화 상자");
        dlg.setMessage("이것은 기본 대화상자 입니다");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("OK");
            }
        });
        dlg.setPositiveButton("Cancle", null);
        dlg.show();
    }

    private void displayRadio() {
        final String data[] = {"치킨", "스파게티"};
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("라디오 대화 상자");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setSingleChoiceItems(data, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(data[which]);
            }
        });
        dlg.setPositiveButton("확인", null); 
        dlg.show();
    }

    private void displayCheck() {
        final String data[] = {"피아노", "독서", "영화보기", "코딩하기"};
        final boolean checked[] = {false, false, false, false};
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("취미를 고르세요");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checked[which] = isChecked;
            }
        });
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                for (int i = 0; i < checked.length; i++) {
                    if(checked[i]) str = str + ", " + data[i];
                }
                displayToast(str);
            }
        });
        dlg.show();
    }

    private void displayCustom() {
        View dlgView = View.inflate(this, R.layout.custom_dlg, null);
        final EditText e1 = dlgView.findViewById(R.id.editText);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("메뉴 선택");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(dlgView);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(e1.getText().toString());
            }
        });
        dlg.setPositiveButton("Cancle", null);
        dlg.show();
    }

    private void displayAlert() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본 대화 상자");
        dlg.setMessage("이것은 기본 대화상자 입니다");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("OK");
            }
        });
        dlg.setPositiveButton("Cancle", null);
        dlg.show();
    }

}
