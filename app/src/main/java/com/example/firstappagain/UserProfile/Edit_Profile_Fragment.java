package com.example.firstappagain.UserProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.firstappagain.R;
import com.example.firstappagain.Uttils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class Edit_Profile_Fragment extends Fragment {

    ImageView back_arrow_img;
    UniversalImageLoader imageLoader;
    String imgURL;
    ImageView profileImage;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        imageLoader=new UniversalImageLoader(getContext());

        profileImage=view.findViewById(R.id.id_profilePic);

        back_arrow_img=view.findViewById(R.id.id_back_arrow);
        back_arrow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });


        setprofilePic();
        return view;

    }

    private void setprofilePic() {
        imgURL="futureuniversity.com/wp-content/uploads/2017/11/android.png";
        imageLoader.setImage(imgURL,profileImage,null,"http://");
    }





}
