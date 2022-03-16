package com.example.delacasa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText variable1,variable2; //declared edit text
    Button btnAdd, btnSub, btnMul, btnDiv, btnEql; //declared buttons
    TextView resultTxt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text boxes
        variable1 = findViewById(R.id.editFirstVariable);
        variable2 = findViewById(R.id.editSecondVariable);

        //buttons
        btnAdd = findViewById(R.id.btnAddition);
        btnSub = findViewById(R.id.btnSubtraction);
        btnMul = findViewById(R.id.btnMultiplication);
        btnDiv = findViewById(R.id.btnDivision);
        btnEql = findViewById(R.id.btnEquals);

        //text view answer
        resultTxt = findViewById(R.id.textResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEql.setOnClickListener(this);

        double var1, var2;

        var1 = Double.parseDouble(String.valueOf(variable1.getText()));
        var2 = Double.parseDouble(String.valueOf(variable2.getText()));

    }
    @Override
    public void onClick(View v) {

        //text boxes
        variable1 = findViewById(R.id.editFirstVariable);
        variable2 = findViewById(R.id.editSecondVariable);

        //buttons
        btnAdd = findViewById(R.id.btnAddition);
        btnSub = findViewById(R.id.btnSubtraction);
        btnMul = findViewById(R.id.btnMultiplication);
        btnDiv = findViewById(R.id.btnDivision);
        btnEql = findViewById(R.id.btnEquals);

        //text view answer
        resultTxt = findViewById(R.id.textResult);

        double var1, var2;

        var1 = Double.parseDouble(String.valueOf(variable1.getText()));
        var2 = Double.parseDouble(String.valueOf(variable2.getText()));

        switch (v.getId()) {
            case R.id.btnAddition:
                resultTxt.setText(String.valueOf( var1 + var2 ));
                break;
            case R.id.btnSubtraction:
                resultTxt.setText(String.valueOf( var1 - var2 ));
                break;
            case R.id.btnMultiplication:
                resultTxt.setText(String.valueOf( var1 * var2 ));
                break;
            case R.id.btnDivision:
                resultTxt.setText(String.valueOf( var1 / var2 ));
                break;
            case R.id.btnEquals:
                resultTxt.setText(String.valueOf( var1 % var2 ));
                break;

        }
    }


}