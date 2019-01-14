package com.example.firstappagain.Likes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.firstappagain.R;
import com.example.firstappagain.Uttils.BtnNanigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class LikeActivity extends AppCompatActivity {
    private static final String TAG = "LikeActivity";

    BottomNavigationViewEx navigationViewExBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationViewExBtn=findViewById(R.id.bottmNavView);

        Log.d(TAG,"on creat started");
        BtnNanigationViewHelper.moveAnimatAndText(navigationViewExBtn);
        BtnNanigationViewHelper.enableNavigation(this,navigationViewExBtn);

        //to change icon for navigation
        Menu menu=navigationViewExBtn.getMenu();
        MenuItem menuItem=menu.getItem(3);
        menuItem.setChecked(true);
     }

}
