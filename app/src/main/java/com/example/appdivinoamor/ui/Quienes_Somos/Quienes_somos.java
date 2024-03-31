package com.example.appdivinoamor.ui.Quienes_Somos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appdivinoamor.databinding.FragmentQuienesSomosBinding;

public class Quienes_somos extends Fragment{

    private @NonNull FragmentQuienesSomosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Quienes_Somos_ViewModel quienes_somos_viewModel =
                new ViewModelProvider(this).get(Quienes_Somos_ViewModel.class);

        binding = FragmentQuienesSomosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
