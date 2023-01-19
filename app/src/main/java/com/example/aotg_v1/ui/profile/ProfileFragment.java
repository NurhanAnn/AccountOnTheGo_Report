package com.example.aotg_v1.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.aotg_v1.DBHelper;
import com.example.aotg_v1.KahootActivity;
import com.example.aotg_v1.LoginActivity;
import com.example.aotg_v1.MainActivity;
import com.example.aotg_v1.Notes;
import com.example.aotg_v1.QuizzizActivity;
import com.example.aotg_v1.R;
import com.example.aotg_v1.RegisterActivity;
import com.example.aotg_v1.SettingsActivity;
import com.example.aotg_v1.WordwallActivity;
import com.example.aotg_v1.databinding.ActivityMainBinding;
import com.example.aotg_v1.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    DBHelper DB;
    LoginActivity Login;
    private ProfileFragment profile_frag;
    String user;

    private FragmentProfileBinding binding;

    public String age;

    public ProfileFragment(){
        System.out.println("in ProfileFragment constructor: " + this.age);
        System.out.println("in ProfileFragment constructor(kalau age shajaa): " + age);

    }
    public ProfileFragment(String your_text) {
        this.age = your_text;
        System.out.println("in ProfileFragment constructor: " + this.age);
        System.out.println("in ProfileFragment constructor(kalau age shajaa): " + age);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);



//        binding = FragmentProfileBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View view = inflater.inflate(R.layout.fragment_profile,container,false);


        DBHelper DB = new DBHelper(getContext());
        //display age
//        Intent r = new Intent(MainActivity.this, RegisterActivity.class);
//        startActivity(r);
        Intent intent = getActivity().getIntent();
        user = intent.getStringExtra("username");
        System.out.println(user);
        ProfileFragment profFrag = new ProfileFragment(user);

        TextView TVage = view.findViewById(R.id.TVage);
        TextView TVedubackground = view.findViewById(R.id.TVedubackground);
        TextView TVusername = view.findViewById(R.id.TVUserName);
        String age_value = DB.displayAge(user);
        String edubg_value = DB.displayeduBackground(user);
        String usernm_value = user;

//        System.out.println(age_value + "----------------------");
        TVage.setText(age_value);
        TVedubackground.setText(edubg_value);
        TVusername.setText(usernm_value);

//        TVage.setText("hello");
        System.out.println("Sini masih di main activity nape null ek: " + age_value);

        //final TextView textView = binding.textNotifications;
        //profileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

//        DBHelper DB = new DBHelper(getContext());
//        //display age
//        Intent r = new Intent(ProfileFragment.this, RegisterActivity.class);
//        startActivity(r);
//        Intent intent = getIntent();
//        String user = intent.getStringExtra("username");
//
//        TextView TVage = view.findViewById(R.id.TVage);
////        String age_value = DB.displayAge();
//        System.out.println("In onview Created: " + age);
//        TVage.setText(age);
//        new ProfileFragment();


        //Navigate from profileFragment to QuizzizActivity via button
        Button BtnQuizziz = view.findViewById(R.id.QuizzizBtn);
        View.OnClickListener OCLQuizziz = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), QuizzizActivity.class);
                intent.putExtra("username",user);
                startActivity(intent);
            }
        };
        BtnQuizziz.setOnClickListener(OCLQuizziz);

        //Navigate from profileFragment to WordWallActivity via button
        Button BtnWordwall = view.findViewById(R.id.WordwallBtn);
        View.OnClickListener OCLWordwall = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), WordwallActivity.class);
                intent.putExtra("username",user);
                startActivity(intent);
            }
        };
        BtnWordwall.setOnClickListener(OCLWordwall);

        //Navigate from profileFragment to KahootActivity via button
        Button BtnKahoot = view.findViewById(R.id.KahootBtn);
        View.OnClickListener OCLKahoot = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), KahootActivity.class);
                intent.putExtra("username",user);
                startActivity(intent);
            }
        };
        BtnKahoot.setOnClickListener(OCLKahoot);

        //Navigate from profileFragment to SettingsActivity via button
        ImageButton BtnSettings = view.findViewById(R.id.settings);
        View.OnClickListener OCLSettings = new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Navigation.findNavController(view).navigate(R.id.navigation_settings);
                Intent intent  = new Intent(getActivity(), SettingsActivity.class);
                intent.putExtra("username",user);
                startActivity(intent);
            }
        };
        BtnSettings.setOnClickListener(OCLSettings);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}