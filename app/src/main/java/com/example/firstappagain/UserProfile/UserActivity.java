package com.example.firstappagain.UserProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.firstappagain.R;
import com.example.firstappagain.Uttils.BtnNanigationViewHelper;
import com.example.firstappagain.Uttils.GridAdapterRecycle;
import com.example.firstappagain.Uttils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    private static final String TAG = "UserActivity";
    BottomNavigationViewEx navigationViewExBtn;
    Toolbar toolbarProfile;
    ProgressBar progressBar;
    ImageView profileImg;
    ArrayList<String> URL_ArrayList;

    RecyclerView.LayoutManager manager;
    GridView ImgRecyclerView;
    ImageView imageViewProfileSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);





        profileImg = findViewById(R.id.profile_image);
        progressBar = findViewById(R.id.progrespar);
        progressBar.setVisibility(View.GONE);
        toolbarProfile = findViewById(R.id.toolbarProfileId);
        imageViewProfileSetting = findViewById(R.id.img_profile_setting_menu);


        setImageProfile();
        setUpToolBBarProfileUser();
        setUpGridView();
        setUpNavBar();
    }

    private void setUpGridView() {

        manager=new GridLayoutManager(this,3);
        ImgRecyclerView =findViewById(R.id.recycleGridImafe);


        //edit Image to make square +class square
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = widthPixels / 3;
        ImgRecyclerView.setColumnWidth(imageWidth);


        URL_ArrayList=new ArrayList<>();

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCeqazBXkDRwVqiXdRgpwNumCjAXDgyPPKay5qQd-Ig59S6em9dg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXFWEBa4MpJod4vTQOzXsOZxbUPSVEmDVehA9Os6_lnroqBxFOzA");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCWvZenuB15cWleaph26jD9VFXhaZ1A4o0h7QUzpgVtIYTIMvm");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmxdNTbsSo0onV1q64qUn0LjKZyxIZl2foVfDwrwnAE0t6zj0l7w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKUITT0BBVoBjHh1s9pEFr7NXK_jyNIozqLh1pVSasFxxFxqihMg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwObeRT4OSO-f-TtAIGV-DQJqLvjwet87JjUZ2lTtUMmf0HkgyPQ");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZTOWoOLzWnm4qDXonVx0_fgvJIB6k40XQMCVvCzVSPL6-En_4_w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoGbPei63-AEg4U_iTJey2juASdLPV76bRqCo1xRnA9bIfLoaH");
        URL_ArrayList.add("https://i.ytimg.com/vi/Zpvv9TdQU2k/maxresdefault.jpg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCqlQy_u6OFfHotPByVnWl8BlI-VvgI9hZ32OeNRQVvBtfHE75zw");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCeqazBXkDRwVqiXdRgpwNumCjAXDgyPPKay5qQd-Ig59S6em9dg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXFWEBa4MpJod4vTQOzXsOZxbUPSVEmDVehA9Os6_lnroqBxFOzA");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCWvZenuB15cWleaph26jD9VFXhaZ1A4o0h7QUzpgVtIYTIMvm");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmxdNTbsSo0onV1q64qUn0LjKZyxIZl2foVfDwrwnAE0t6zj0l7w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKUITT0BBVoBjHh1s9pEFr7NXK_jyNIozqLh1pVSasFxxFxqihMg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwObeRT4OSO-f-TtAIGV-DQJqLvjwet87JjUZ2lTtUMmf0HkgyPQ");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZTOWoOLzWnm4qDXonVx0_fgvJIB6k40XQMCVvCzVSPL6-En_4_w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoGbPei63-AEg4U_iTJey2juASdLPV76bRqCo1xRnA9bIfLoaH");
        URL_ArrayList.add("https://i.ytimg.com/vi/Zpvv9TdQU2k/maxresdefault.jpg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCqlQy_u6OFfHotPByVnWl8BlI-VvgI9hZ32OeNRQVvBtfHE75zw");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCeqazBXkDRwVqiXdRgpwNumCjAXDgyPPKay5qQd-Ig59S6em9dg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXFWEBa4MpJod4vTQOzXsOZxbUPSVEmDVehA9Os6_lnroqBxFOzA");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCWvZenuB15cWleaph26jD9VFXhaZ1A4o0h7QUzpgVtIYTIMvm");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmxdNTbsSo0onV1q64qUn0LjKZyxIZl2foVfDwrwnAE0t6zj0l7w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKUITT0BBVoBjHh1s9pEFr7NXK_jyNIozqLh1pVSasFxxFxqihMg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwObeRT4OSO-f-TtAIGV-DQJqLvjwet87JjUZ2lTtUMmf0HkgyPQ");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZTOWoOLzWnm4qDXonVx0_fgvJIB6k40XQMCVvCzVSPL6-En_4_w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoGbPei63-AEg4U_iTJey2juASdLPV76bRqCo1xRnA9bIfLoaH");
        URL_ArrayList.add("https://i.ytimg.com/vi/Zpvv9TdQU2k/maxresdefault.jpg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCqlQy_u6OFfHotPByVnWl8BlI-VvgI9hZ32OeNRQVvBtfHE75zw");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCeqazBXkDRwVqiXdRgpwNumCjAXDgyPPKay5qQd-Ig59S6em9dg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXFWEBa4MpJod4vTQOzXsOZxbUPSVEmDVehA9Os6_lnroqBxFOzA");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCWvZenuB15cWleaph26jD9VFXhaZ1A4o0h7QUzpgVtIYTIMvm");

        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlIUSgi1n7VJyKfuO2LnxJYyRjSvDo19IIRDWDf3v9hE35ip9W");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmxdNTbsSo0onV1q64qUn0LjKZyxIZl2foVfDwrwnAE0t6zj0l7w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKUITT0BBVoBjHh1s9pEFr7NXK_jyNIozqLh1pVSasFxxFxqihMg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwObeRT4OSO-f-TtAIGV-DQJqLvjwet87JjUZ2lTtUMmf0HkgyPQ");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZTOWoOLzWnm4qDXonVx0_fgvJIB6k40XQMCVvCzVSPL6-En_4_w");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoGbPei63-AEg4U_iTJey2juASdLPV76bRqCo1xRnA9bIfLoaH");
        URL_ArrayList.add("https://i.ytimg.com/vi/Zpvv9TdQU2k/maxresdefault.jpg");
        URL_ArrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCqlQy_u6OFfHotPByVnWl8BlI-VvgI9hZ32OeNRQVvBtfHE75zw");


        ImgRecyclerView.setAdapter(new GridAdapterRecycle(URL_ArrayList,this));
    }


    String imgURL;
    UniversalImageLoader imageLoader;

    private void setImageProfile() {
        imageLoader = new UniversalImageLoader(this);
        imgURL = "futureuniversity.com/wp-content/uploads/2017/11/android.png";
        imageLoader.setImage(imgURL, profileImg, null, "http://");
    }


    private void setUpToolBBarProfileUser() {
        setSupportActionBar(toolbarProfile);
        imageViewProfileSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, Setting_Activity.class);
                startActivity(intent);
            }
        });
    }


    private void setUpNavBar() {
        navigationViewExBtn = findViewById(R.id.bottmNavView);
        Log.d(TAG, "on creat started");
        BtnNanigationViewHelper.moveAnimatAndText(navigationViewExBtn);
        BtnNanigationViewHelper.enableNavigation(this, navigationViewExBtn);

        //to change icon for navigation
        Menu menu = navigationViewExBtn.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }


}
