package com.androidcss.jsonexample.activity;

import com.androidcss.jsonexample.R;
import com.bumptech.glide.Glide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String s = getIntent().getStringExtra("key");
        TextView tv = (TextView)findViewById(R.id.image_description);
        tv.setText(s);

        //Intent intent= getIntent();
        String a = getIntent().getStringExtra("image1");
        ImageView imageView = (ImageView) findViewById(R.id.image);


        Glide.with(this)
                .load(a)
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(imageView);
/*
        ImageView tv1 = (ImageView) findViewById(R.id.image);

        Glide.with(DetailsActivity.this).load(getIntent().getStringExtra("IMAGE_URL"))
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(tv1);



        ImageView i = (ImageView) findViewById(R.id.image);
        String imageUrl = getIntent().getStringExtra("IMAGE_URL");
        Glide.with(DetailsActivity.this).load(imageUrl).into(i);
*/






    }
}






