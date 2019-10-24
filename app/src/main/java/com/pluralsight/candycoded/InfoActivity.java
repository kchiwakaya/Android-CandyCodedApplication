package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    ImageView phone,Address;
    TextView phone_num,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        phone = (ImageView) findViewById(R.id.image_view_phone);
        Address = (ImageView)findViewById(R.id.image_view_map);
        phone_num = (TextView) findViewById(R.id.text_view_phone);
        address =(TextView)findViewById(R.id.text_view_address);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPhoneIntent();
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMapIntent();
            }
        });


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    public void createMapIntent()
    {
        //Uri uri = Uri.parse("geo:0,0?q=618+E+South+St+Orlando, FL");
        Uri uri = Uri.parse("geo:22.1253,56.566");
        Intent createMapIntent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(createMapIntent);
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent()
    {
        String phone_Number="45";
        Uri uri = Uri.parse("tel:"+phone_Number);
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}
