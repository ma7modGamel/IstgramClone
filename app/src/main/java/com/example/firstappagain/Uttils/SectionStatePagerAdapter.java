package com.example.firstappagain.Uttils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {



    HashMap<Fragment,Integer> mfragment=new HashMap<>();
    HashMap<Integer,String> mfragmentName=new HashMap<>();
    HashMap<String,Integer> mfragmentNumber=new HashMap<>();
    List<Fragment> mfragmentList=new ArrayList<>();

    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mfragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    public void  addFragment(Fragment fragment,String FragmentName){

        mfragmentList.add(fragment);

        mfragment.put(fragment,mfragmentList.size()-1);
        mfragmentName.put(mfragmentList.size()-1,FragmentName);
        mfragmentNumber.put(FragmentName,mfragmentList.size()-1);

    }
    public Integer getfragmentNumber(Fragment fm){
        if(mfragmentNumber.containsKey(fm)){
            return mfragmentNumber.get(fm);
        }else {

            return null;
        }
    }
    public String getFragmrntName(Integer FragmentNumber){
        if(mfragmentName.containsKey(FragmentNumber)){
            return mfragmentName.get(FragmentNumber);
        }else {
            return null;
        }

    }
    public Integer getFragmentNumber(String FragmentName) {
        if (mfragmentNumber.containsKey(FragmentName)) {
            return mfragmentNumber.get(FragmentName);
        } else {
            return null;
        }
    }



}
