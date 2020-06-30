package com.example.android.glide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImages = new ArrayList<> ();
    private ArrayList<String> mImagesNames = new ArrayList<> ();
    private Context mContext ;

    public RecyclerViewAdapter ( ArrayList<String> mImages, ArrayList<String> mImagesNames, Context mContext ) {
        this.mImages = mImages;
        this.mImagesNames = mImagesNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
        //inflates the view
        View view = LayoutInflater.from(parent.getContext ())
                    .inflate ( R.layout.layout_list_item ,parent , false);
        //creating a ViewHolder object
        viewHolder holder = new viewHolder (view );
        return holder ;
    }

    @Override
    public void onBindViewHolder ( @NonNull viewHolder holder, final int position ) {


        //getting the image and putting it into the holder's circleImage view
        Glide.with ( mContext )
                .asBitmap ()
                .load ( mImages.get(position) )
                .into(holder.image);
        //setting the the name of that image
        holder.imageName.setText ( mImagesNames.get ( position ) );

        //showing a toast message by clicking on the item
        holder.parentLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View v ) {
                Toast.makeText ( mContext , mImagesNames.get ( position ),Toast.LENGTH_SHORT)
                .show ();
            }
        } );
    }

    @Override
    public int getItemCount () {
        return mImagesNames.size ();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private CircleImageView image ;
        private TextView imageName ;
        private LinearLayout parentLayout ;
        public viewHolder (  View itemView ) {
            super ( itemView );
            image = itemView.findViewById ( R.id.image );
            imageName = itemView.findViewById ( R.id.imageName );
            parentLayout = itemView.findViewById ( R.id.parent_layout );
        }
    }
}
