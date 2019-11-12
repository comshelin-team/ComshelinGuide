package com.comshelin.comshelinguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ChatActivity extends AppCompatActivity {
    ActionBar actionBar;
    CardView cv_chatStar, cv_chatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        actionBar = getSupportActionBar();
        cv_chatStar = findViewById(R.id.cv_chatStar);
        cv_chatInput = findViewById(R.id.cv_chatInput);

        actionBar.setDisplayHomeAsUpEnabled(true);

        cv_chatInput.setVisibility(View.GONE);

        cv_chatStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cv_chatInput.setVisibility(View.VISIBLE);
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
