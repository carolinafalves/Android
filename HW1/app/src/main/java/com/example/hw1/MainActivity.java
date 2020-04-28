package com.example.hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnStar;
    Button btnZero;
    Button btnHashtag;
    Button btnDelete;
    Button btnCall;
    Button btnid1 ;
    Button btnid2 ;
    Button btnid3 ;


    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFive = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnStar = findViewById(R.id.buttonStar);
        btnZero = findViewById(R.id.buttonZero);
        btnHashtag = findViewById(R.id.buttonHashtag);
        btnDelete = findViewById(R.id.buttonDelete);
        btnCall = findViewById(R.id.buttonCall);
        btnid1 = findViewById(R.id.buttonid1);
        btnid2 = findViewById(R.id.buttonid2);
        btnid3 = findViewById(R.id.buttonid3);


        input = findViewById(R.id.editText);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

    }



    public void one(View v) {
        onButtonClick(btnOne, input,"1");
    }
    public void two(View v) {
        onButtonClick(btnTwo, input,"2");
    }
    public void three(View v) {
        onButtonClick(btnThree, input,"3");
    }
    public void four(View v) {
        onButtonClick(btnFour, input,"4");
    }
    public void five(View v) {
        onButtonClick(btnFive, input, "5");
    }
    public void six(View v) {
        onButtonClick(btnSix, input, "6");
    }
    public void seven(View v) {
        onButtonClick(btnSeven, input, "7");
    }
    public void eight(View v) {
        onButtonClick(btnEight, input, "8");
    }
    public void nine(View v) {
        onButtonClick(btnNine, input, "9");
    }
    public void star(View v) {
        onButtonClick(btnStar, input, "*");
    }
    public void zero(View v) {
        onButtonClick(btnZero, input, "0");
    }
    public void hashtag(View v) {
        onButtonClick(btnHashtag, input, "#");
    }
    public void onDelete(View v) {
        input.setText("");
    }
    public void id1(View v){
        onButtonClick(btnid1, input, "91111111");
        makePhoneCall();
    }
    public void id2(View v){
        onButtonClick(btnid2, input, "92222222");
        makePhoneCall();
    }
    public void id3(View v){
        onButtonClick(btnid1, input, "93333333");
        makePhoneCall();
    }


    private void makePhoneCall () {
        if (input.getText().length() > 0) {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL );
            } else {
                String call = "tel:" + input.getText();
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(call)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }else {
                Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onButtonClick(Button button, EditText inputNumber, String number){
        String cache= input.getText().toString();
        inputNumber.setText(cache + number);
    }
}
