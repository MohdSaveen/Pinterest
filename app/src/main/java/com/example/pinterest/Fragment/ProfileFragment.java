package com.example.pinterest.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pinterest.LoginActivity;
import com.example.pinterest.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {

    private ImageView imgProfile;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private TextView TextUserName;
    private EditText editTextEmail;
    private TextView textViewLogOut;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextFirstName=view.findViewById(R.id.firstName);
        editTextLastName=view.findViewById(R.id.lastName);
        TextUserName=view.findViewById(R.id.userName);
        editTextEmail=view.findViewById(R.id.emailProfile);
        imgProfile=view.findViewById(R.id.imgProfilePic);
        textViewLogOut=view.findViewById(R.id.logOut);

        GoogleSignInAccount googleSignInAccount= GoogleSignIn.getLastSignedInAccount(getContext());
        editTextFirstName.setText(googleSignInAccount.getGivenName());
        editTextLastName.setText(googleSignInAccount.getFamilyName());
        TextUserName.setText(googleSignInAccount.getId());
        editTextEmail.setText(googleSignInAccount.getEmail());
        Glide.with(getContext()).load(googleSignInAccount.getPhotoUrl()).into(imgProfile);

        textViewLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });
    }

}