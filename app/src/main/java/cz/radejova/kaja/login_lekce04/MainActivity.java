package cz.radejova.kaja.login_lekce04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText surname;
    private String nameText;
    private String surnameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_editText);
        surname = findViewById(R.id.surname_editText);

        Hawk.init(this).build();

        if (Hawk.contains("user")) {
            startActivity(new Intent(this, ResultActivity.class));
            finish();
        }
    }

    public void prihlasitSe(View view) {
        nameText = name.getText().toString();
        surnameText = surname.getText().toString();

//osetreni prazdneho vstupu
        if (nameText.length() == 0 || surnameText.length() == 0) {
            Toast.makeText(this, "Zadejte jméno a přijmení.", Toast.LENGTH_LONG).show();
        } else {

// ulozeni usera do Hawk
            Hawk.put("user", new User(nameText, surnameText));

            startActivity(new Intent(this, ResultActivity.class));
            finish();
        }

    }
}
