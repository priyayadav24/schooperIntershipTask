package com.example.priyapc.navigationtask;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

import gsonStructures.StudentGSON;


/**
 * Created by PriyaPC on 04-04-2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentListViewHolder> {

    public static class StudentListViewHolder extends RecyclerView.ViewHolder {

        TextView first_name;
        TextView last_name;
        TextView id;
        TextView address;
        TextView dob;
        TextView mobile;
        TextView username;


        StudentListViewHolder(View itemView) {
            super(itemView);
            first_name = (TextView)itemView.findViewById(R.id.first_name);
            last_name = (TextView)itemView.findViewById(R.id.last_name);
            id = (TextView)itemView.findViewById(R.id.student_id);
            address = (TextView)itemView.findViewById(R.id.address);
            dob = (TextView)itemView.findViewById(R.id.DOB);
            mobile = (TextView)itemView.findViewById(R.id.mobile);
            username = (TextView)itemView.findViewById(R.id.username);
        }

    }

    List<StudentGSON> studentLists;

    StudentAdapter(List<StudentGSON> studentLists){
        this.studentLists = studentLists;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public StudentAdapter.StudentListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_item, viewGroup, false);
        StudentListViewHolder pvh = new StudentListViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(StudentListViewHolder studentListViewHolder, int i) {
        studentListViewHolder.first_name.setText(studentLists.get(i).getFirst_name());
        studentListViewHolder.last_name.setText(studentLists.get(i).getLast_name());
        studentListViewHolder.id.setText(studentLists.get(i).getId());
        studentListViewHolder.address.setText(studentLists.get(i).getAddress());
        studentListViewHolder.dob.setText(studentLists.get(i).getDOB());
        studentListViewHolder.mobile.setText(studentLists.get(i).getMobile());
        studentListViewHolder.username.setText(studentLists.get(i).getUsername() == null ? "N/A" : studentLists.get(i).getUsername());

    }

    @Override
    public int getItemCount() {  return studentLists.size();  }


}
