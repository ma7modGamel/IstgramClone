package com.example.firstappagain.UserProfile;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.example.firstappagain.R;
import com.example.firstappagain.Uttils.BtnNanigationViewHelper;
import com.example.firstappagain.Uttils.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class Setting_Activity extends AppCompatActivity {

    private static final String TAG = "Setting_Activity";


    SectionStatePagerAdapter msectionStatePagerAdapter;
    ImageView imageViewBackArrow;
    RelativeLayout mRelativeLayout;
    ViewPager mviewPager;
    ArrayAdapter arrayAdapter;
    ListView listViewSetting;
    BottomNavigationViewEx navigationViewExBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        listViewSetting=findViewById(R.id.lv_setting);
        mRelativeLayout=findViewById(R.id.relative1);
        navigationViewExBtn=findViewById(R.id.bottmNavView);
        mviewPager=findViewById(R.id.viewpager_id);
        imageViewBackArrow=findViewById(R.id.id_back_arrow);



        imageViewBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         setUpNavigationbar();
         setUpListSetting();
         setUpFragments();

    }

    private void setUpFragments() {
        msectionStatePagerAdapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        msectionStatePagerAdapter.addFragment(new Edit_Profile_Fragment(),getString(R.string.editProfile));
        msectionStatePagerAdapter.addFragment(new SignOut_Fragment(),getString(R.string.signOut));

    }


    private void setUpListSetting() {
        ArrayList<String> stringArrayList=new ArrayList<>();
        stringArrayList.add(getString(R.string.editProfile));
        stringArrayList.add(getString(R.string.signOut));

        arrayAdapter=new ArrayAdapter(Setting_Activity.this,android.R.layout.simple_list_item_1,stringArrayList);
        listViewSetting.setAdapter(arrayAdapter);

        listViewSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setViewPager(position);
            }
        });

    }

    private void setViewPager(int FragmentNumber) {
        mRelativeLayout.setVisibility(View.GONE);
        mviewPager.setAdapter(msectionStatePagerAdapter);
        mviewPager.setCurrentItem(FragmentNumber);
    }


    private void setUpNavigationbar() {

        //to remove Animat and text
        BtnNanigationViewHelper.moveAnimatAndText(navigationViewExBtn);
        BtnNanigationViewHelper.enableNavigation(this,navigationViewExBtn);

        //to change icon for navigation
        Menu menu=navigationViewExBtn.getMenu();
        MenuItem menuItem=menu.getItem(4);
        menuItem.setChecked(true);
    }
}
