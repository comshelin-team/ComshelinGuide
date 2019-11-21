package com.comshelin.comshelinguide.ui.add;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;

import com.comshelin.comshelinguide.R;

public class AddActivity extends AppCompatActivity {
    ActionBar actionBar;
    CardView cv_form, cv_input;
    ImageButton ib_close_form, ib_send;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTheme(R.style.AppThemeActionBar);

        actionBar = getSupportActionBar();
        cv_input = findViewById(R.id.cv_input);
        cv_form = findViewById(R.id.cv_form);
        ib_close_form = findViewById(R.id.ib_close_form);
        ib_send = findViewById(R.id.ib_send);
        ratingBar = findViewById(R.id.ratingBar);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Restaurant");
        cv_form.setVisibility(View.GONE);
        ib_close_form.setVisibility(View.GONE);

        cv_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv_form.setVisibility(View.VISIBLE);
                ib_close_form.setVisibility(View.VISIBLE);
            }
        });

        ib_close_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv_form.setVisibility(View.GONE);
                ib_close_form.setVisibility(View.GONE);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                cv_form.setVisibility(View.VISIBLE);
                ib_close_form.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(cv_form.getVisibility() == View.VISIBLE) {
            cv_form.setVisibility(View.GONE);
            ib_close_form.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
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
