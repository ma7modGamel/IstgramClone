package com.example.firstappagain.Home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.firstappagain.LogIn.LoginActivity;
import com.example.firstappagain.R;
import com.example.firstappagain.Uttils.BtnNanigationViewHelper;
import com.example.firstappagain.Uttils.SectionPagerAdapter;
import com.example.firstappagain.Uttils.UniversalImageLoader;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    BottomNavigationViewEx navigationViewExBtn;
    SectionPagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationViewExBtn=findViewById(R.id.bottmNavView);
        viewPager=findViewById(R.id.viewpager_id);
        tabLayout=findViewById(R.id.tabs_id);
        FirebaseApp.initializeApp(this);
        Log.e(TAG,"on creat started");
        setUpFireBase();
        initProfilePic();
        setUpNavigationbar();
        setUpViewPager();

     }




    private void setUpViewPager() {
        pagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());
        Log.e(TAG, "setUpViewPager: ");
        pagerAdapter.addFragment(new Camera_Fragment());
        pagerAdapter.addFragment(new Home_Fragment());
        pagerAdapter.addFragment(new Message_Fragment());
        viewPager.setAdapter(pagerAdapter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instgram_logo);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_message);

    }

    private void setUpNavigationbar() {
        Log.e(TAG, "setUpNavigationbar: " );
        //to remove Animat and text
        BtnNanigationViewHelper.moveAnimatAndText(navigationViewExBtn);
        BtnNanigationViewHelper.enableNavigation(this,navigationViewExBtn);

        //to change icon for navigation
        Menu menu=navigationViewExBtn.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);
    }
    public void initProfilePic() {
        UniversalImageLoader universalImageLoader =new UniversalImageLoader(this);
        ImageLoader.getInstance().init(universalImageLoader.imageConfig());

    }

//**************************** firebase ************/

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener listener;
    private void setUpFireBase() {
        Log.e(TAG, "setUpFireBase: " );
        auth=FirebaseAuth.getInstance();
        listener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                checkCurrentUser(currentUser);
            }
        };

    }

    private void checkCurrentUser(FirebaseUser currentUser) {
        Log.e(TAG, "checkCurrentUser: 1" );
        if(currentUser==null){
            Log.e(TAG, "checkCurrentUser:3" );
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(listener);
        checkCurrentUser(auth.getCurrentUser());
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(listener);
    }
}
