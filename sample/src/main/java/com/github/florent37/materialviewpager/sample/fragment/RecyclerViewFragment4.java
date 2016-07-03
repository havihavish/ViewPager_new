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
import com.github.florent37.materialviewpager.sample.TestRecyclerViewAdapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 01-07-2016.
 */
public class RecyclerViewFragment4 extends Fragment {
    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Object> mContentItems = new ArrayList<>();

    public static RecyclerViewFragment4 newInstance() {
        return new RecyclerViewFragment4();
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

        mAdapter = new TestRecyclerViewAdapter4(mContentItems);

        //mAdapter = new RecyclerViewMaterialAdapter();
        mRecyclerView.setAdapter(mAdapter);

        {
            /*for (int i = 0; i < ITEM_COUNT; ++i) {
                mContentItems.add(new Object());
            }*/
            mContentItems.add(new Object("Insignia 2k16","Nandamuri Taraka Rama Rao Jr. (born 20 May 1983) is an Indian film actor, Kuchipudi dancer, and playback singer known for his works exclusively in Telugu cinema. He is the grandson of veteran Telugu actor, former Chief Minister (CM) of Andhra Pradesh, N. T. Rama Rao.[3] In 1996, he was starred as a child artist in Ramayanam, which won the National Film Award for Best Children's Film for that year. He achieved his breakthrough success in 2001 with the film Student No.1. He is best known for his works in box office hits such as Aadi (2002), Simhadri (2003), Rakhi (2006),Yamadonga (2007), Adhurs (2010), Brindavanam (2010), Baadshah (2013), Temper (2015), and Nannaku Prematho",R.drawable.image2));

            mAdapter.notifyDataSetChanged();
        }
    }
}
