package com.crisspian.logotrivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.crisspian.logotrivia.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;

    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTitleBinding.inflate(inflater, container,false);
        View view = binding.getRoot();

        binding.comenzarTriviaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.nameTv.getText().toString().isEmpty()) {
                    addLogoTriviaFragment(binding.nameTv.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Debes escribir tu nombre", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }


    private void addLogoTriviaFragment(String name) {
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name, "");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, logoTriviaFragment, TitleFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }


}