package com.example.sih.ui.PROFILE.Agri_Profile;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sih.R;

import java.util.ArrayList;
import java.util.List;

public class AgriProfileFragment extends Fragment {

    private AgriProfileViewModel agriProfileViewModel;
    List<AgriProfileViewModel.Item> kitems, ritems, zitems;
    ListView Kharif_lv, rabi_lv, zaid_lv;
    AgriProfileViewModel.ItemsListAdapter kharifAdapter, rabiAdapter, zaidAdapter;
    Button submit;
    CheckBox checkBox;

    ArrayList<String> kharifcrops = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        agriProfileViewModel =
                ViewModelProviders.of(this).get(AgriProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile_agri, container, false);

        Kharif_lv = root.findViewById(R.id.klv);
        rabi_lv = root.findViewById(R.id.rlv);
        zaid_lv = root.findViewById(R.id.zlv);
        submit = root.findViewById(R.id.submit);

        checkBox = root.findViewById(R.id.cb);

        final SparseBooleanArray[] sparseBooleanArray = new SparseBooleanArray[1];

        initKItems();
        initRItems();
        initZItems();

        kharifAdapter = new AgriProfileViewModel.ItemsListAdapter(getContext(), kitems);
        Kharif_lv.setAdapter(kharifAdapter);
        Kharif_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getContext(), ((AgriProfileViewModel.Item) (parent.getItemAtPosition(position))).ItemString,
                        Toast.LENGTH_LONG).show();
            }
        });

        rabiAdapter = new AgriProfileViewModel.ItemsListAdapter(getContext(), ritems);
        rabi_lv.setAdapter(rabiAdapter);
        rabi_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getContext(), ((AgriProfileViewModel.Item) (parent.getItemAtPosition(position))).ItemString,
                        Toast.LENGTH_LONG).show();
            }
        });

        zaidAdapter = new AgriProfileViewModel.ItemsListAdapter(getContext(), zitems);
        zaid_lv.setAdapter(zaidAdapter);
        zaid_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getContext(), ((AgriProfileViewModel.Item) (parent.getItemAtPosition(position))).ItemString,
                        Toast.LENGTH_LONG).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), kharifcrops.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void initKItems() {
        kitems = new ArrayList<>();

        TypedArray arrayText = getResources().obtainTypedArray(R.array.Kharif_Crops);

        for (int i = 0; i < arrayText.length(); i++) {
            String s = arrayText.getString(i);
            boolean b = false;
            AgriProfileViewModel.Item item = new AgriProfileViewModel.Item(s, b);
            kitems.add(item);
        }
        arrayText.recycle();
    }

    private void initRItems() {
        ritems = new ArrayList<>();

        TypedArray arrayText = getResources().obtainTypedArray(R.array.Rabi_Crops);

        for (int i = 0; i < arrayText.length(); i++) {
            String s = arrayText.getString(i);
            boolean b = false;
            AgriProfileViewModel.Item item = new AgriProfileViewModel.Item(s, b);
            ritems.add(item);
        }
        arrayText.recycle();
    }

    private void initZItems() {
        zitems = new ArrayList<>();

        TypedArray arrayText = getResources().obtainTypedArray(R.array.Zaid_Crops);

        for (int i = 0; i < arrayText.length(); i++) {
            String s = arrayText.getString(i);
            boolean b = false;
            AgriProfileViewModel.Item item = new AgriProfileViewModel.Item(s, b);
            zitems.add(item);
        }
        arrayText.recycle();
    }

}