package com.example.aotg_v1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.aotg_v1.R;
import com.example.aotg_v1.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        //Navigate from homeFragment to Pyear1activity via button
        Button BtnPyears = view.findViewById(R.id.BtnPyears);
        View.OnClickListener OCLPyears = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(view).navigate(R.id.BtnPyears);
            }
        };
        BtnPyears.setOnClickListener(OCLPyears);

        //Navigate from homeFragment to Notes1activity via button
        Button BtnNotes = view.findViewById(R.id.BtnNotes);
        View.OnClickListener OCLNotes = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(view).navigate(R.id.navigation_notes);
            }
        };
        BtnNotes.setOnClickListener(OCLNotes);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}