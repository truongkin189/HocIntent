package com.example.hocintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdaper extends BaseAdapter
{
    private Context context;
    private int layout;
    private List<Student> listStudent;

    public StudentAdaper(Context context, int layout, List<Student> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout , null);
        //anh xa view
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView age = (TextView) convertView.findViewById(R.id.age);
        TextView sex = (TextView) convertView.findViewById(R.id.sex);

        //gan gai tri
        Student student = listStudent.get(position);
        name.setText("Tên: "+student.getName());
        age.setText("Tuổi: "+student.getAge());
        sex.setText("Giới tính: "+student.getSex());
        return convertView;
    }
}
