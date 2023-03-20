package com.example.billingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText client_id_edit_text;
    private EditText client_name_edit_text;
    private EditText prd_name_edit_text;
    private EditText prd_price_edit_text;
    private EditText prd_qty_edit_text;
    private TextView billing_total_text_view;
    private TextView client_info_text_view;
    private Button total_input_button;
    private Button total_record_button;
    private Button previous_button;
    private Button next_button;

    private static String log = "BillingProject";
    private static final String KEY_INDEX = "index";
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Billing bill1 = new Billing(105, "Johnston Jane", "Chair", 99.99, 2);
        Billing bill2= new Billing(108, "Fikhali Samuel", "Table", 139.99, 1);
                Billing bill3 = new Billing(113, "Samson Amina", "KeyUSB", 14.99, 2);

                Billing[] allBills = new Billing[]{bill1,bill2,bill3};

        client_id_edit_text = (EditText) findViewById(R.id.client_id_edit_text) ;
        client_name_edit_text = (EditText) findViewById(R.id.client_name_edit_text) ;
        prd_name_edit_text = (EditText) findViewById(R.id.prd_name_edit_text);
        prd_price_edit_text = (EditText) findViewById(R.id.prd_price_edit_text);
        prd_qty_edit_text = (EditText) findViewById(R.id.prd_qty_edit_text);

        client_info_text_view = (TextView) findViewById(R.id.client_info_text_view) ;

total_input_button = (Button) findViewById(R.id.total_input_button);
total_input_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {


            Billing bill = new Billing();
            bill.setClient_id(Integer.parseInt(client_id_edit_text.getText().toString()));
            bill.setClient_name(client_name_edit_text.getText().toString());
            bill.setPrd_qty(Integer.parseInt(prd_qty_edit_text.getText().toString()));
            bill.setPrd_price(Double.parseDouble(prd_price_edit_text.getText().toString()));
            bill.setProduct_name(prd_name_edit_text.getText().toString());

            client_info_text_view.setText(bill.CalculateBilling());
            Toast.makeText(MainActivity.this, allBills[index].CalculateBilling(), Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            
        }
    }
});

total_record_button = (Button)  findViewById(R.id.total_record_button);
total_record_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            client_info_text_view.setText(allBills[index].CalculateBilling());
            Toast.makeText(MainActivity.this, allBills[index].CalculateBilling(), Toast.LENGTH_SHORT).show();
        } catch (Exception e){

        }

    }
});

previous_button = (Button) findViewById(R.id.previous_button);
previous_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        index = (Math.abs(index-1))%allBills.length;

    }
});

next_button=(Button) findViewById(R.id.next_button);
next_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        index = (Math.abs(index+1))%allBills.length;
    }
});













    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        Log.d(log, "onSaveInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX,index);
    }

    @Override
    public void onStart() {

        super.onStart();
        Log.d(log,"onStart() called");
    }

    @Override
    public void onPause() {

        super.onPause();
        Log.d(log, "onPause() called");
    }
    @Override
    public void onResume() {

        super.onResume();
        Log.d(log, "onResume() called");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d(log, "onDestroy() called");
    }

    @Override
    public void onStop() {

        super.onStop();
        Log.d(log, "onStop() called");
    }
}