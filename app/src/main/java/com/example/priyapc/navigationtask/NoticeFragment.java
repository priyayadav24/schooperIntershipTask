package com.example.priyapc.navigationtask;

/**
 * Created by PriyaPC on 02-04-2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gsonStructures.NoticeGSON;
import remote.SOService;
import rest.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeFragment extends Fragment {

    private RecyclerView rv;
    private SOService mService;
    private List<NoticeGSON> mNoticeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notice, container, false);

        mService = ApiUtils.getSOService();

        rv = (RecyclerView)rootView.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        loadAnswers();

        return rootView;
    }

    public void loadAnswers() {
        mService.getNotices().enqueue(new Callback<List<NoticeGSON>>() {

            @Override
            public void onResponse(Call<List<NoticeGSON>> call, Response<List<NoticeGSON>> response) {
                mNoticeList = response.body();
                initializeAdapter();
            }

            @Override
            public void onFailure(Call<List<NoticeGSON>> call, Throwable t) {
                int i = 10;
                ++i;
            }
        });
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(mNoticeList);
        rv.setAdapter(adapter);
    }

}