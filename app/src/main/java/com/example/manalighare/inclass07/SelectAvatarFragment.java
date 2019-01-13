package com.example.manalighare.inclass07;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectAvatarFragment extends Fragment implements View.OnClickListener {


    private ImageView avatar_f_1;
    private ImageView avatar_f_2;
    private ImageView avatar_f_3;
    private ImageView avatar_m_1;
    private ImageView avatar_m_2;
    private ImageView avatar_m_3;

    SelectAvatarInterface mListener;


    public SelectAvatarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener=(SelectAvatarInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Should Implment interface");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_select_avatar, container, false);
        getActivity().setTitle("Select Avatar");

        avatar_f_1=(ImageView)view.findViewById(R.id.avatar_f_1);
        avatar_f_2=(ImageView)view.findViewById(R.id.avatar_f_2);
        avatar_f_3=(ImageView)view.findViewById(R.id.avatar_f_3);
        avatar_m_1=(ImageView)view.findViewById(R.id.avatar_m_1);
        avatar_m_2=(ImageView)view.findViewById(R.id.avatar_m_2);
        avatar_m_3=(ImageView)view.findViewById(R.id.avatar_m_3);

        avatar_f_1.setOnClickListener(this);
        avatar_f_2.setOnClickListener(this);
        avatar_f_3.setOnClickListener(this);
        avatar_m_1.setOnClickListener(this);
        avatar_m_2.setOnClickListener(this);
        avatar_m_3.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.avatar_f_1){

            mListener.getAvatar("avatar_f_1");

        }
        else if(v.getId()==R.id.avatar_f_2){
            mListener.getAvatar("avatar_f_2");


        }
        else if(v.getId()==R.id.avatar_f_3){

            mListener.getAvatar("avatar_f_3");
       }

        else if(v.getId()==R.id.avatar_m_1){

            mListener.getAvatar("avatar_m_1");
        }

        else if(v.getId()==R.id.avatar_m_2){

            mListener.getAvatar("avatar_m_2");
       }

        else if(v.getId()==R.id.avatar_m_3){

            mListener.getAvatar("avatar_m_3");
        }

    }


    public interface SelectAvatarInterface{
        void getAvatar(String img_name);
    }




}
