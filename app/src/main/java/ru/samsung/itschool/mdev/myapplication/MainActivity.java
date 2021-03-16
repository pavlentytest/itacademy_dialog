package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragment1DataListener {

    private Button btn1, btn2;

    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment1());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // loadFragment(new Fragment2());
                MyDialog md = new MyDialog();
                md.show(getSupportFragmentManager(),null);
            }
        });
    }

    private void loadFragment(Fragment f) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        Bundle arg = new Bundle();
        arg.putString(KEY, "something");
        f.setArguments(arg);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onFragment1DataListener(String str) {
        Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_LONG).show();
    }
}