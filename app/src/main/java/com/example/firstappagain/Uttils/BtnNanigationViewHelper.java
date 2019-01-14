package com.example.firstappagain.Uttils;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.firstappagain.AddPhoto.AddPhotoActivity;
import com.example.firstappagain.Home.HomeActivity;
import com.example.firstappagain.Likes.LikeActivity;
import com.example.firstappagain.R;
import com.example.firstappagain.Search.SearchActivity;
import com.example.firstappagain.UserProfile.UserActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BtnNanigationViewHelper {


    public static void moveAnimatAndText(BottomNavigationViewEx navigationViewExBtn) {
        //move animation and text
        navigationViewExBtn.enableAnimation(false);
        navigationViewExBtn.setTextVisibility(false);
    }


    public static void enableNavigation(final Context context, BottomNavigationViewEx viewBtn) {

        viewBtn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                Intent intentPage;

                switch (menuItem.getItemId()) {
                    case R.id.home_id:
                        intentPage = new Intent(context, HomeActivity.class);//index item:0
                        context.startActivity(intentPage);
                        break;
                    case R.id.search_id:
                        intentPage = new Intent(context, SearchActivity.class);//index item:1
                        context.startActivity(intentPage);
                        break;
                    case R.id.add_id:
                        intentPage = new Intent(context, AddPhotoActivity.class);//index item:2
                        context.startActivity(intentPage);
                        break;
                    case R.id.favorit_id:
                        intentPage = new Intent(context, LikeActivity.class);//index item:3
                        context.startActivity(intentPage);
                        break;
                    case R.id.user_id:
                        intentPage = new Intent(context, UserActivity.class);//index item:4
                        context.startActivity(intentPage);
                        break;

                }

                return false;
            }
        });

    }

}
