package com.example.sih.ui.PROFILE.Personal_Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sih.R;

public class PersonalProfileFragment extends Fragment {

    private PersonalProfileViewModel personalProfileViewModel;
    private Button submit;
    private EditText fullname, contact1, contact2, age;
    private RadioGroup gender;
    private RadioButton rb_male, rb_female;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalProfileViewModel =
                ViewModelProviders.of(this).get(PersonalProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile_personal, container, false);

        submit = root.findViewById(R.id.submit);
        fullname = root.findViewById(R.id.fn);
        age = root.findViewById(R.id.age);
        contact1 = root.findViewById(R.id.cn);
        contact2 = root.findViewById(R.id.acn);
        rb_male = root.findViewById(R.id.male);
        rb_female = root.findViewById(R.id.female);

        gender = root.findViewById(R.id.rg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("***********************", fullname.getText().toString());
                if (fullname.getText().toString().trim().equals("") || contact1.getText().toString().trim().equals("") || age.getText().toString().trim().equals("")) {
                    Toast.makeText(getContext(), "Enter All details properly", Toast.LENGTH_SHORT).show();
                } else {
                    if (gender.getCheckedRadioButtonId() == R.id.male) {
                        Toast.makeText(getContext(), "Male verified", Toast.LENGTH_SHORT).show();
                    } else if (gender.getCheckedRadioButtonId() == R.id.female) {
                        Toast.makeText(getContext(), "Female verified", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Select Gender too", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return root;
    }
}