package com.comshelin.comshelinguide.ui.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.comshelin.comshelinguide.R;
import com.comshelin.comshelinguide.ui.chat.ChatActivity;

public class InfoActivity extends AppCompatActivity {
    Button btn_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btn_review = findViewById(R.id.btn_review);

        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InfoActivity.this, ChatActivity.class));
            }
        });
    }
}
