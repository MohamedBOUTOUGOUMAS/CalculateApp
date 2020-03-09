package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button [] btnNumbers = new Button[10];
    Button btnPlus;
    Button btnMoins;
    Button btnDiv;
    Button btnMul;
    Button btnC;
    Button btnEgal;
    Button btnPoint;
    TextView ecran;
    CalculateModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);
        btnMoins = findViewById(R.id.btnMoins);
        btnMoins.setOnClickListener(this);
        btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        btnEgal = findViewById(R.id.btnEqual);
        btnEgal.setOnClickListener(this);
        btnPoint = findViewById(R.id.btnDot);
        btnPoint.setOnClickListener(this);

        for (int i=1; i <= 10; i++) {
            btnNumbers[i-1] = findViewById(
                    getResources().getIdentifier("button"+i, "id", getPackageName())
            );
            btnNumbers[i-1].setOnClickListener(this);
        }

        ecran = findViewById(R.id.textView);
        model = new CalculateModel();
    }

    @Override
    public void onClick(View v){
        if(v.equals(btnPlus)) model.setOperator('+');
        else if(v.equals(btnMoins)) model.setOperator('-');
        else if(v.equals(btnDiv)) model.setOperator('/');
        else if(v.equals(btnMul)) model.setOperator('*');
        else if(v.equals(btnC)){
            model.clear();
            ecran.setText("0");
        }
        else if(v.equals(btnEgal)){
            double res = model.calculate();
            ecran.setText(String.valueOf(res));
            model.setFirstValue(String.valueOf(res));
            model.setSecondValue("");
            model.setOperator(' ');
        }
        else{
            Button numberBtn = (Button) v;
            if( model.getOperator() == ' '){
                model.addFirstValueNumber(numberBtn.getText().toString());
                ecran.setText(String.valueOf(model.getFirstValue()));
            }else{
                model.addSecondValueNumber(numberBtn.getText().toString());
                ecran.setText(String.valueOf(model.getSecondValue()));
            }
        }
    }
}
