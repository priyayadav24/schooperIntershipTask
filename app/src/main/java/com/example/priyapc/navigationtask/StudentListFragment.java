package com.example.priyapc.navigationtask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gsonStructures.StudentGSON;
import remote.SOService;
import rest.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PriyaPC on 02-04-2017.
 */

public class StudentListFragment extends Fragment {

    private RecyclerView rv;
    private SOService mService;
    private List<StudentGSON> mStudentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_studentlist, container, false);

        mService = ApiUtils.getSOService();

        rv = (RecyclerView)rootView.findViewById(R.id.rvStud);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        studLoadAnswers();

        return rootView;
    }

    public void studLoadAnswers(){

        mService.getStudents().enqueue(new Callback<List<StudentGSON>>() {
            @Override
            public void onResponse(Call<List<StudentGSON>> call, Response<List<StudentGSON>> response) {
                mStudentList = response.body();
                initializeAdapter();
            }

            @Override
            public void onFailure(Call<List<StudentGSON>> call, Throwable t) {
                int i = 10;
                ++i;

            }
        });
    }

    private void initializeAdapter(){
        StudentAdapter adapter = new StudentAdapter(mStudentList);
        rv.setAdapter(adapter);
    }
}
