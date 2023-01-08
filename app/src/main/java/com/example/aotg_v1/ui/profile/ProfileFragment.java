package com.example.aotg_v1.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.aotg_v1.R;
import com.example.aotg_v1.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //profileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        //Navigate from profileFragment to QuizzizActivity via button
        Button BtnQuizziz = view.findViewById(R.id.QuizzizBtn);
        View.OnClickListener OCLQuizziz = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(view).navigate(R.id.navigation_quizziz);
            }
        };
        BtnQuizziz.setOnClickListener(OCLQuizziz);

        //Navigate from profileFragment to WordWallActivity via button
        Button BtnWordwall = view.findViewById(R.id.WordwallBtn);
        View.OnClickListener OCLWordwall = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(view).navigate(R.id.navigation_wordwall);
            }
        };
        BtnWordwall.setOnClickListener(OCLWordwall);

        //Navigate from profileFragment to KahootActivity via button
        Button BtnKahoot = view.findViewById(R.id.KahootBtn);
        View.OnClickListener OCLKahoot = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(view).navigate(R.id.navigation_kahoot);
            }
        };
        BtnKahoot.setOnClickListener(OCLKahoot);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}