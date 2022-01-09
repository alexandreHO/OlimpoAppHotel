package br.unip.olimpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCreateAccount extends AppCompatActivity {

    EditText email, password, rePassword, completeName, clientCPF;
    TextView signIn;
    Button signUp;
    DBHelper DB;
    ValidaCPF vCPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        rePassword = (EditText) findViewById(R.id.editTextTextPassword2);
        signUp = (Button) findViewById(R.id.button15);
        signIn = (TextView) findViewById(R.id.textView20);
        completeName = (EditText) findViewById(R.id.editTextTextPassword3);
        clientCPF = (EditText) findViewById(R.id.editTextTextPassword4);
        DB = new DBHelper(this);
        vCPF = new ValidaCPF();

        signUp.setOnClickListener(view1 -> {

            String user = email.getText().toString();
            String pass = password.getText().toString();
            String repass = rePassword.getText().toString();
            String name = completeName.getText().toString();
            String CPF = clientCPF.getText().toString();

            if (user.equals("") || pass.equals("") || repass.equals("") || name.equals("")) {
                Toast.makeText(ActivityCreateAccount.this, "Preencha todos os campos",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                if (pass.equals(repass)) {
                    Boolean checkUser = DB.checkUserName(user) && DB.checkCPF(CPF);
                    if (checkUser == false) {
                        Boolean validaCPF = vCPF.isCPF(CPF);
                        if (validaCPF == true){
                            Boolean insert = DB.insertData(user, pass, name, CPF);
                            if (insert == true) {
                                Toast.makeText(ActivityCreateAccount.this, "Conta criada com sucesso",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ProfileFragment.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ActivityCreateAccount.this, "Não foi possível criar sua conta",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(ActivityCreateAccount.this, "CPF inválido",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(ActivityCreateAccount.this, "E-mail ou CPF já cadastrado",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(ActivityCreateAccount.this, "Senhas não coincidem",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        signIn.setOnClickListener(view2 -> {

            super.finish();

        });


    }

}