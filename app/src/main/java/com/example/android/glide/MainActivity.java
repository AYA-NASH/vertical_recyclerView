package com.example.android.glide;


import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //our variables
    private ArrayList<String> mNames = new ArrayList<> (  );
    private ArrayList<String> mImageUrls = new ArrayList<> (  );

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        initImageBitmaps();
    }


    private void initImageBitmaps(){

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();
    }
    //setting up the recyclerView
    private void initRecyclerView(){
        //getting the recycler view element from the layout_list_item.xml
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //creating an object of our custom Adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter( mImageUrls,mNames, this);

        //matching the recycler view with the Adapter
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager (this));
    }
}
