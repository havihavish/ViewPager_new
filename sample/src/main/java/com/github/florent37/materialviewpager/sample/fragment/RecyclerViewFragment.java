package com.github.florent37.materialviewpager.sample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.github.florent37.materialviewpager.sample.R;
import com.github.florent37.materialviewpager.sample.TestRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends Fragment {

    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Object> mContentItems = new ArrayList<>();
    Context context;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager;

        if (GRID_LAYOUT) {
            layoutManager = new GridLayoutManager(getActivity(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity());
        }
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

        mAdapter = new TestRecyclerViewAdapter(mContentItems);

        //mAdapter = new RecyclerViewMaterialAdapter();
        mRecyclerView.setAdapter(mAdapter);

        {
            /*for (int i = 0; i < ITEM_COUNT; ++i) {
                mContentItems.add(new Object());
            }*/
            mContentItems.add(new Object("Aditya","71254639889",R.drawable.image3));
            mContentItems.add(new Object("Tejesh","987456123",R.drawable.image3));
            mContentItems.add(new Object("Sravan","897546213",R.drawable.image3));
            mContentItems.add(new Object("Shehnaz","874596213",R.drawable.image3));
            mContentItems.add(new Object("Yoga","893256471",R.drawable.image3));
            mContentItems.add(new Object("Avtansh","99999999999",R.drawable.image3));
            mContentItems.add(new Object("Surya","99999999999",R.drawable.image3));
            mContentItems.add(new Object("Yoga","99999999999",R.drawable.image3));
            mContentItems.add(new Object("Yoga","99999999999",R.drawable.image3));
            mContentItems.add(new Object("Yoga","99999999999",R.drawable.image3));
            mContentItems.add(new Object("Yoga","99999999999",R.drawable.image3));
            mAdapter.notifyDataSetChanged();
        }
    }
}


