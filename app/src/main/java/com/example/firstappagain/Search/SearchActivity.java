package com.example.firstappagain.Search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.firstappagain.R;
import com.example.firstappagain.Uttils.BtnNanigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";
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
        MenuItem menuItem=menu.getItem(1);
        menuItem.setChecked(true);

     }


}
