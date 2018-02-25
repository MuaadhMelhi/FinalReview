package nyc.muaadh_melhi_develpoer.ourappfinalreview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String SHARED_PREF_KEY = "sharedPrefsTesting";
    private EditText username, password;
    private CheckBox checkbox;
    private Button submit, register;
    private SharedPreferences login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUp();


        //Login
        //if the checkbox is not check ...has info
        //when you run the app again ......sharedpref has info
        if (login.getBoolean("isChecked", false)) {
            username.setText(login.getString("username",""));
            password.setText(login.getString("password", ""));
            checkbox.setChecked(login.getBoolean("isChecked",false));
        }
        //app run>?check ..you get it

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = login.edit();
                if (checkbox.isChecked()) {
                    editor.putString("username", username.getText().toString());//null
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("isChecked", checkbox.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", checkbox.isChecked());
                    editor.commit();
                }

                String checkUser= login.getString("user" + username.getText().toString(), "");
                String checkPassword= login.getString("password" + username.getText().toString(), null);

                if(username.getText().toString().equals(checkUser) && password.getText().toString().equals(checkPassword)) {
                    //do something
                    Toast.makeText(LoginActivity.this, "THIS IS WORKINGGG!! YOU LOG IN! JUST KIDDING", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, PokeActivity.class));

                } else {
                    Toast.makeText(LoginActivity.this, "GO REGISTER ASSHOLE!~!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //SetUp
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("shared", SHARED_PREF_KEY);
                startActivity(intent);
            }
        });


    }

    private void setUp() {
        username = findViewById(R.id.username_edittext);
        password = findViewById(R.id.password_edittext);
        checkbox = findViewById(R.id.remember_me_checkbox);
        submit = findViewById(R.id.submit_button);
        register = findViewById(R.id.register_button);

        login = getApplicationContext().getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
    }


}
