package com.example.appdivinoamor.ui.contactanos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appdivinoamor.databinding.FragmentGalleryBinding;
import com.example.appdivinoamor.databinding.FragmentsContactanosBinding;

public class ContactosFragment extends Fragment {

    private FragmentsContactanosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactosViewModel galleryViewModel =
                new ViewModelProvider(this).get(ContactosViewModel.class);

        binding = FragmentsContactanosBinding.inflate(inflater, container, false);
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