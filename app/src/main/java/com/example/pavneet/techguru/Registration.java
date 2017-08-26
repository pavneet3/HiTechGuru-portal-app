package com.example.pavneet.techguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    Spinner courses;
    ArrayAdapter<CharSequence> SpinnerAdapter;
    String str_course, str_name, str_phone, str_email, str_address;
    EditText name, phone, etaddress, email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registration);

        courses = (Spinner) findViewById(R.id.courses);
        SpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courses.setAdapter(SpinnerAdapter);
        courses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_course = courses.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        name= (EditText) findViewById(R.id.etname);
        phone= (EditText) findViewById(R.id.etphone);
        etaddress= (EditText) findViewById(R.id.etaddress);
        email= (EditText) findViewById(R.id.etemail);
        register = (Button) findViewById(R.id.button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_name = name.getText().toString();
                str_phone = phone.getText().toString();
                str_email = email.getText().toString();
                str_address = etaddress.getText().toString();
                //initialize();
                if (validation()) {
                    String type = "register";
                    BcWorker bcWorker = new BcWorker(Registration.this);
                    bcWorker.execute(type, str_name, str_email, str_phone, str_address, str_course);


                    name.setText("");
                    phone.setText("");
                    email.setText("");
                    etaddress.setText("");
                }
            }
        });
    }

    public void initialize() {
        str_name = name.getText().toString();
        str_phone = phone.getText().toString();
        str_email = email.getText().toString();
        str_address = etaddress.getText().toString();
    }

    public boolean validation() {
        boolean valid = true;
        if (str_name.isEmpty() || str_name.length() < 2 || str_name.length() > 32) {
            name.setError("please enter valid name");
            valid = false;
        }

        if (str_email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
            email.setError("please enter valid email address");
            valid = false;
        }
        if (str_phone.isEmpty() || !Patterns.PHONE.matcher(str_phone).matches()) {
            phone.setError("please enter valid contact no.");
            valid = false;
        }
        if (str_address.isEmpty()) {
            etaddress.setError("please enter address");
            valid = false;
        }
        if (str_course.equals("--Select A Course--")) {
            Toast.makeText(Registration.this, "Please select a course", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;

    }
}



