package com.example.agili.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    List<User> userList = new ArrayList<>();

    ListView listView;
    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //파이어 베이스와 연결
        database = FirebaseDatabase.getInstance();
        Log.i("start", "start");

        // 파이어 베이스에서 레퍼런스를 가져옴
        ref = database.getReference("User");

        // 파이어베이스 에서 데이터를 가져 옴
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    User user = snapshot.getValue(User.class);
                    user.User = snapshot.getKey();
                    Log.i("id", user.User);
                    Log.i("UserName", user.getName());
                    Log.i("UserAge", String.valueOf(user.getAge()));

                    userList.add(user);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("MainActivity", "loadPost:onCancelled", databaseError.toException());
            }
        });

        // 4. 리스트뷰에 목록 세팅
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ListAdapter(userList, this);
        listView.setAdapter(adapter);


    }
}
