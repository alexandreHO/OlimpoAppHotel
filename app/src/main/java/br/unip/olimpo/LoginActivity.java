package br.unip.olimpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin ;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        TextView txtCreateAcc = (TextView) findViewById(R.id.txtCreateAcc);

        txtCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ActivityCreateAccount.class);
                startActivity(intent);
            }
        });

        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        btnLogin = (Button) findViewById(R.id.button15);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(view1 -> {

            String user = email.getText().toString();
            String pass = password.getText().toString();

            if (user.equals("") || pass.equals("")) {
                Toast.makeText(LoginActivity.this, "Preencha todos os campos",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                Boolean checkUserPass = DB.checkUserNamePassword(user, pass);
                if (checkUserPass == true) {
                    Toast.makeText(LoginActivity.this, "Preencha com e-mail", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ProfileFragment.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login ou Senha inválida",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}