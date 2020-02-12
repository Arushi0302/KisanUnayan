package com.example.sih.ui.Details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sih.R;

import java.io.IOException;
import java.util.Objects;

public class DetailsFragment extends Fragment {

    private DetailsViewModel detailsViewModel;

    public static ImageView picture;
    public int PICK_IMAGE_REQUEST = 1;
    private AutoCompleteTextView VaF;
    private Button pic;
    private Button submit;
    EditText price, quantity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detailsViewModel =
                ViewModelProviders.of(this).get(DetailsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crop_details, container, false);

        VaF = root.findViewById(R.id.crop);
        pic = root.findViewById(R.id.addpic);
        submit = root.findViewById(R.id.submit);
        picture = root.findViewById(R.id.croppic);
        price = root.findViewById(R.id.price);
        quantity = root.findViewById(R.id.qty);

        ArrayAdapter<CharSequence> utl = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.Crops, R.layout.support_simple_spinner_dropdown_item);
        this.VaF.setAdapter(utl);

        this.pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), DetailsFragment.this.PICK_IMAGE_REQUEST);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (price.getText().toString().equals("") || quantity.getText().toString().equals("") ||
                VaF.getText().toString().equals("") || picture.getDrawable() == null) {

                    AlertDialog.Builder bd = new AlertDialog.Builder(getContext());
                    bd.setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = bd.create();
                    alertDialog.setTitle("Please enter all details properly !!!");
                    alertDialog.show();
                }

                else
                {
                    Toast.makeText(getContext(), "Data Stored succesfully", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder bd = new AlertDialog.Builder(getContext());
                    bd.setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AlertDialog.Builder bd = new AlertDialog.Builder(getContext());
                            bd.setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    price.setText("");
                                    quantity.setText("");
                                    VaF.setText("");
                                    picture.setImageDrawable(null);
                                }
                            }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            AlertDialog alertDialog = bd.create();
                            alertDialog.setTitle("Would you like to add another crop ?");
                            alertDialog.show();
                        }
                    });
                    AlertDialog alertDialog1 = bd.create();
                    alertDialog1.setTitle("Crop Added Successfully");
                    alertDialog1.show();
                }
            }
        });
        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.PICK_IMAGE_REQUEST && resultCode == -1 && data != null && data.getData() != null) {
            try {
                picture.setImageBitmap(MediaStore.Images.Media.getBitmap(Objects.requireNonNull(getContext()).
                        getContentResolver(), data.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}