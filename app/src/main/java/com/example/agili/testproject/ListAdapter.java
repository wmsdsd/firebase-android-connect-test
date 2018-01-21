package com.example.agili.testproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by agili on 2017-12-24.
 */

public class ListAdapter extends BaseAdapter{
    List<User> userList;
    Context context;
    LayoutInflater inflater;

    public ListAdapter(List<User> userList, Context context){
        this.userList = userList;
        this.context = context;
        this.inflater = (LayoutInflater) context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView age = (TextView)convertView.findViewById(R.id.age);

        User user = userList.get(i);
        name.setText(user.name);
        age.setText(user.name);

        return convertView;
    }
}
