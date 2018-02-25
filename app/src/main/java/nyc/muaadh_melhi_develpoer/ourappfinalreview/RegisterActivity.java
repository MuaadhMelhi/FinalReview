package nyc.muaadh_melhi_develpoer.ourappfinalreview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, password, confirmPassword;
    private Button submitButton;
    private SharedPreferences registerSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setUP();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= registerSharedPref.edit();
                if(username.getText().toString()!=null && password.getText().toString()!=null &&
                        confirmPassword.getText().toString()!=null
                        && confirmPassword.getText().toString().equals(password.getText().toString())) {
                  editor.putString("user"+username.getText().toString(), username.getText().toString());
                  editor.putString("password"+username.getText().toString(), password.getText().toString());
                  editor.commit();
                  finish();
                }
            }
        });


    }

    private void setUP() {
        username= findViewById(R.id.register_username_edittext);
        password= findViewById(R.id.register_password_edittext);
        confirmPassword= findViewById(R.id.confirm_password_edittext);
        submitButton= findViewById(R.id.submit_button);

        Intent intent= getIntent();
        registerSharedPref= getApplicationContext().getSharedPreferences(intent.getStringExtra("shared"), MODE_PRIVATE);


    }
}
