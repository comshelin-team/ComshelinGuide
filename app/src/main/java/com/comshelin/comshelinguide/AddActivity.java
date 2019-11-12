package com.comshelin.comshelinguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AddActivity extends AppCompatActivity {
    ActionBar actionBar;
    CardView cv_star, cv_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTheme(R.style.AppThemeActionBar);

        actionBar = getSupportActionBar();
        cv_star = findViewById(R.id.cv_star);
        cv_input = findViewById(R.id.cv_input);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Restaurant");
        cv_input.setVisibility(View.GONE);

        cv_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv_input.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
