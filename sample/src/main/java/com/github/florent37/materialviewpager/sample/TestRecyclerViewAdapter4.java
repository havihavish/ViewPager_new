package com.github.florent37.materialviewpager.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.materialviewpager.sample.fragment.Object;

import java.util.List;

/**
 * Created by hp on 02-07-2016.
 */
public class TestRecyclerViewAdapter4 extends RecyclerView.Adapter<TestRecyclerViewAdapter4.PersonViewHolder> {
    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    int lastPosition=-1;
    Context context1;
    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    public TestRecyclerViewAdapter4(List<Object> contents) {
        this.contents = contents;
    }

    /*public TestRecyclerViewAdapter42(List<Object> contents) {
        this.contents = contents;
    }*/

  /*  public TestRecyclerViewAdapter42(List<Object> contents) {this.contents = contents;
    }*/

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        Context context;
        FrameLayout container;

        PersonViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            cv = (CardView) itemView.findViewById(R.id.cv);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personAge = (TextView) itemView.findViewById(R.id.person_contact);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
            container=(FrameLayout)itemView.findViewById(R.id.frame_layout);


        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            // RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) v.getTag();
            int position = getAdapterPosition();
            switch (position) {
                case 0:

                    i.setData(Uri.parse("http://www.google.com"));

                    break;

                case 1:
                    i.setData(Uri.parse("http://www.youtube.com"));
                    break;

                default:
                    i.setData(Uri.parse("http://www.facebook.com"));
                    break;
            }
            context.startActivity(i);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context1=parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card1, parent, false);
        return new PersonViewHolder(view) {
        };

    }


    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.personName.setText(contents.get(i).name);
        personViewHolder.personAge.setText(contents.get(i).age);
        personViewHolder.personPhoto.setImageResource(contents.get(i).photoId);

    }

}
