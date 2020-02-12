package com.example.sih.ui.PROFILE.Address_Profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.sih.R;
import com.example.sih.ui.PROFILE.Agri_Profile.AgriProfileFragment;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class AddressProfileFragment extends Fragment {

    private AddressProfileViewModel addressProfileViewModel;
    Button submit;
    EditText al1, al2, pin, cityet;
    SearchableSpinner statespin, districtspin;
    String Aline1, Aline2, pincode, city;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addressProfileViewModel = ViewModelProviders.of(this).get(AddressProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile_address, container, false);

        submit = root.findViewById(R.id.submit);
        al1 = root.findViewById(R.id.al1);
        al2 = root.findViewById(R.id.al2);
        pin = root.findViewById(R.id.pin);
        cityet = root.findViewById(R.id.city);
        statespin = root.findViewById(R.id.state);
        districtspin = root.findViewById(R.id.district);

        Aline1 = al1.getText().toString();
        Aline2 = al2.getText().toString();
        pincode = pin.getText().toString();
        city = cityet.getText().toString();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Aline1.equals("") || Aline2.equals("") || pincode.equals("") || city.equals("") ||
                        statespin.getSelectedItem().equals("") || districtspin.getSelectedItem().equals("")) {
                   AlertDialog.Builder bd = new AlertDialog.Builder(getContext());
                    bd.setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = bd.create();
                    alertDialog.setTitle("Please enter all details properly !!!");
                    alertDialog.show();

                } else {
                    AlertDialog.Builder bd = new AlertDialog.Builder(getContext());
                    bd.setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = bd.create();
                    alertDialog.setTitle("Thank you for the details");
                    alertDialog.show();
                }
            }
        });
        return root;
    }
}