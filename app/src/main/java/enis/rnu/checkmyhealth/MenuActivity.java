package enis.rnu.checkmyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton imageButton_img = (ImageButton)findViewById(R.id.imageButton_img);
        imageButton_img.setOnClickListener(new ImageButton.OnClickListener()
        {
            @Override
            public void onClick(View imageButton_img) {
                Intent intent=new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
