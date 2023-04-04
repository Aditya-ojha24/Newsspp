package com.example.n;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsdetailActivity extends AppCompatActivity {

    String title,desc,content,imageurl,url;
    private TextView  titletv,subdescTv,contenttv;
    private ImageView newsTv;
    private Button readnewsbtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        title=getIntent().getStringExtra("title");
        content=getIntent().getStringExtra("content");
        imageurl=getIntent().getStringExtra("image");
        url=getIntent().getStringExtra("url");
        desc=getIntent().getStringExtra("description");
        titletv=findViewById(R.id.idTVTitle);
        subdescTv=findViewById(R.id.idTVsubdescription);
        contenttv=findViewById(R.id.idTVcontent);
        newsTv=findViewById(R.id.idIVNews);
        readnewsbtn=findViewById(R.id.idBTReadNews);
        titletv.setText(title);
        subdescTv.setText(desc);
        contenttv.setText(content);
        Picasso.get().load(imageurl).into(newsTv);
        readnewsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}