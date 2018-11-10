package cz.radejova.kaja.login_lekce04;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class ResultActivity extends AppCompatActivity {
    private TextView logged_user_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Hawk.init(this).build(); //musim znovu na dalsi aktivite nainicializovat Hawka!

        logged_user_textView = findViewById(R.id.logged_user_textView);

        User user = Hawk.get("user");

        logged_user_textView.setText("Přihlášený uživatel: " + user.firstName + " " + user.lastName);
    }

    public void odhlasitSe(View view) {
        Hawk.delete("user");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); //chci volat tuhle metodu kvuli pruchodu tlacitkem zpet, po zavolani teto metody se aktivita uplne ukonci a nebude mozne si znovu otevrit stranku s podrobnostmi uzivatele
    }

}
