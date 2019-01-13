package com.example.manalighare.inclass07;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayProfileFragment extends Fragment {


    DisplayProfileInterface mListener;
    private Button Edit;
    private TextView name;
    private TextView dept;
    private TextView s_id;
    private ImageView dp;



    public DisplayProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener=(DisplayProfileInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Should Implment interface");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_display_profile, container, false);
        getActivity().setTitle("Display My Profile");
        Edit=(Button)view.findViewById(R.id.edit);
        name=(TextView)view.findViewById(R.id.display_name);
        dept=(TextView)view.findViewById(R.id.display_department);
        s_id=(TextView)view.findViewById(R.id.display_ID);
        dp=(ImageView)view.findViewById(R.id.imageView);


        Student student=(Student)getArguments().getSerializable("STUDENT_KEY");

        name.setText(student.fname+" "+student.lname);
        dept.setText(student.dept);
        s_id.setText(student.S_ID);

        String img_name=student.image_name;

        if(img_name.equals("avatar_f_1")){

            dp.setImageResource(R.drawable.avatar_f_1);

        }
        else if(img_name.equals("avatar_f_2")){

            dp.setImageResource(R.drawable.avatar_f_2);

        }
        else if(img_name.equals("avatar_f_3")){

            dp.setImageResource(R.drawable.avatar_f_3);
        }

        else if(img_name.equals("avatar_m_1")){

            dp.setImageResource(R.drawable.avatar_m_1);
        }

        else if(img_name.equals("avatar_m_2")){

            dp.setImageResource(R.drawable.avatar_m_2);
        }

        else if(img_name.equals("avatar_m_3")){

            dp.setImageResource(R.drawable.avatar_m_3);

        }




        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoMyProfile();
            }
        });

        return view;
    }



    public interface DisplayProfileInterface{

        void gotoMyProfile();
    }

}
