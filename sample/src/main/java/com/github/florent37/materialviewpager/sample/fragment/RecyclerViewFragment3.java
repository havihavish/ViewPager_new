package com.github.florent37.materialviewpager.sample.fragment;

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
import com.github.florent37.materialviewpager.sample.TestRecyclerViewAdapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 01-07-2016.
 */
public class RecyclerViewFragment3 extends Fragment {
    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Object2> mContentItems = new ArrayList<>();

    public static RecyclerViewFragment3 newInstance() {
        return new RecyclerViewFragment3();
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

        mAdapter = new TestRecyclerViewAdapter3(mContentItems);

        //mAdapter = new RecyclerViewMaterialAdapter();
        mRecyclerView.setAdapter(mAdapter);

        {
            /*for (int i = 0; i < ITEM_COUNT; ++i) {
                mContentItems.add(new Object2());
            }*/
            mContentItems.add(new Object2("Who is insignia?","It is Alphaz Fest"));
            mContentItems.add(new Object2("Who is the Director of NIT Delhi?","Sharma is the director of nit delhi"));
            mContentItems.add(new Object2("How are You?","I am Fine but I am missing something"));
            mContentItems.add(new Object2("What is Your team count?","Our team is of 4,Surya,Havish,Vengal,Chandan"));
            mContentItems.add(new Object2("Where is Nit Delhi?","Nit Delhi is in Narela,Delhi"));
            mContentItems.add(new Object2("Youtube","co sponsor"));
            mAdapter.notifyDataSetChanged();
        }
    }
}
