package com.example.appdivinoamor.ui.noticias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appdivinoamor.databinding.FragmentHomeBinding;
import com.example.appdivinoamor.databinding.FragmentNoticiasBinding;

public class NoticiaFragment extends Fragment {

    private FragmentNoticiasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NoticiaViewModel noticiaViewModel =
                new ViewModelProvider(this).get(NoticiaViewModel.class);

        binding = FragmentNoticiasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        noticiaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}