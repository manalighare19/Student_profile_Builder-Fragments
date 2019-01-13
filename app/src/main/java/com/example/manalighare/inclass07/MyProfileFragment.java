package com.example.manalighare.inclass07;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {


    private ImageView avatar;

    private Button save;

    private EditText fname;
    private EditText lname;
    private EditText s_id;
    private RadioGroup dept_group;


    private String dept_name;
    private String first_name;
    private String last_name;
    private String student__id;
    private String image_name="";

    MyprofileInterface mListener;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener=(MyprofileInterface)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.fragment_my_profile, container, false);

        getActivity().setTitle("My Profile");

        avatar=(ImageView) view.findViewById(R.id.avatar);
        save=(Button) view.findViewById(R.id.save);
        fname=(EditText) view.findViewById(R.id.f_name);
        lname=(EditText) view.findViewById(R.id.l_name);
        s_id=(EditText) view.findViewById(R.id.student_id);
        dept_group=(RadioGroup) view.findViewById(R.id.department);


        final MainActivity mainActivity=(MainActivity)getActivity();
        String image_name=mainActivity.getImage_name();

        if(image_name.equals("avatar_f_1")){
            avatar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.avatar_f_1));
        }
        else if (image_name.equals("avatar_f_2")){
            avatar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.avatar_f_2));
        }
        else if (image_name.equals("avatar_f_3")){
            avatar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.avatar_f_3));
        }
        else if (image_name.equals("avatar_m_1")){
            avatar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.avatar_m_1));
        }
        else if (image_name.equals("avatar_m_2")){
            avatar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.avatar_m_2));
        }
        else if (image_name.equals("avatar_m_3")){
            avatar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.avatar_m_3));
        }else{

        }

        dept_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton)view.findViewById(checkedId);
                dept_name=rb.getText().toString();
                RadioButton tmp=view.findViewById(R.id.other);
                tmp.setError(null);
            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.gotoSelectAvatar();

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Student student=new Student();
                first_name=fname.getText().toString();
                last_name=lname.getText().toString();
                student__id=s_id.getText().toString();

                if(isEverythingFilled(v)){
                    mListener.gotoDisplayMyProfile(first_name,last_name,student__id,dept_name);
                }

            }
        });

        return view;
    }


    public interface MyprofileInterface{
        void gotoSelectAvatar();
        void gotoDisplayMyProfile(String first_name,String last_name,String student__id,String dept_name);
    }


    public Boolean isEverythingFilled(View view){

        int tmp=0;

        if(TextUtils.isEmpty(first_name)){
            TextView f=getView().findViewById(R.id.f_name);
            f.setError("Please Enter First Name");
            tmp=1;
        }

        if(TextUtils.isEmpty(last_name)){
            TextView l=getView().findViewById(R.id.l_name);
            l.setError("Please Enter Last Name");
            tmp=1;
        }

        if(TextUtils.isEmpty(student__id)){

            TextView s_id=getView().findViewById(R.id.student_id);
            s_id.setError("Please Enter Student ID");
            tmp=1;


        }else if(student__id.length()!=9){
            TextView s_id=getView().findViewById(R.id.student_id);
            s_id.setError("Please Enter your 9-Digit Student ID");
            tmp=1;
        }


        if(TextUtils.isEmpty(dept_name)){
            RadioButton dept_name=getView().findViewById(R.id.other);
            dept_name.setError("Please Enter Department Name");
            tmp=1;
        }


       if(tmp==1){
            return false;
       }else {
           return true;
       }

    }


}
