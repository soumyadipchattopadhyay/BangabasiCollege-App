package com.bangabasi_college.ui.developer;


import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bangabasi_college.R;

public class DeveloperFragment extends Fragment {
    private DeveloperViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DeveloperViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dev, container, false);

        root.findViewById(R.id.card1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/tutu19Oct2000"));
                startActivity(i);
            }
        });
        /**-----------------------------------------------------------------------------------------
         * -----------------------------------------------------------------------------------------
         * -------------------------DEVELOPED BY SOUMYADIP CHATTOPADHYAY----------------------------
         * -----------------------------------------------------------------------------------------
         -----------------------------------------------------------------------------------------*/

        root.findViewById(R.id.card2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://twitter.com/soumyadipCMSA"));
                startActivity(i);
            }
        });

        /**-----------------------------------------------------------------------------------------
         * -----------------------------------------------------------------------------------------
         * -------------------------DEVELOPED BY SOUMYADIP CHATTOPADHYAY----------------------------
         * -----------------------------------------------------------------------------------------
         -----------------------------------------------------------------------------------------*/
        root.findViewById(R.id.card3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/soumyadipchattopadhyay"));
                startActivity(i);
            }
        });

        return root;
    }
}
