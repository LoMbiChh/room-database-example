package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdatabaseexample.myDb.MyRoomDatabase;
import com.example.roomdatabaseexample.myDb.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addToDatabaseClick(View view) {
        MyRoomDatabase myRoomDatabase = MyRoomDatabase.getDbInstance(this);

        User user = new User("Matteo", "Lombardi");
        myRoomDatabase.userDao().insertUser(user);

        Toast.makeText(this, "User created", Toast.LENGTH_SHORT).show();
    }

    public void printDatabaseClick(View view) {
        MyRoomDatabase myRoomDatabase = MyRoomDatabase.getDbInstance(this);
        List<User> userList = myRoomDatabase.userDao().getAllUsers();

        for (User user : userList) {
            System.out.println(user.firstName + " " + user.lastName);
        }

        Toast.makeText(this, "Database printed", Toast.LENGTH_SHORT).show();
    }
}