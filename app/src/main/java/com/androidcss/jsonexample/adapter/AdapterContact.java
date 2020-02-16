package com.androidcss.jsonexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import com.androidcss.jsonexample.activity.DetailsActivity;
import com.bumptech.glide.Glide;
import com.androidcss.jsonexample.R;
import com.androidcss.jsonexample.model.DataContact;

/**
 * Created by x on 9/7/2016.
 */
public class AdapterContact extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context context;
    private LayoutInflater inflater;
    List<DataContact> data= Collections.emptyList();
    DataContact current;
    int currentPos=0;
    String url = "https://www.primerpasito.com/testexample/images/";

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterContact(Context context, List<DataContact> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_contact, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        final DataContact current=data.get(position);
        myHolder.textFishName.setText(current.fishName);
        myHolder.textSize.setText( current.sizeName);
        //myHolder.textType.setText("Category: " + current.catName);
        //myHolder.textPrice.setText("Rs. " + current.price + "\\Kg");
        //myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide

        Glide.with(context).load(url + current.fishImage)
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(myHolder.ivFish);


        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " Just cliked item at position " + current.fishName, Toast.LENGTH_LONG).show();


                Intent activityTwo = new Intent(context, DetailsActivity.class);
                activityTwo.putExtra("key", current.fishName);
                //activityTwo.putExtra("key1", current.fishImage);
                Intent intent = new Intent(context, DetailsActivity.class);
                String imageUrl = url + current.fishImage;
                intent.putExtra("image1",data.get(position).getImage_url());

               // intent.putExtra("IMAGE_URL", imageUrl);

                context.startActivity(activityTwo);



            }
        });

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textFishName;
        ImageView ivFish;
        TextView textSize;
        //TextView textType;
        //TextView textPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            //textType = (TextView) itemView.findViewById(R.id.textType);
            //textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }

}
