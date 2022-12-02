package com.example.project_app_thu_cung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link vi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vi extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public vi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vi.
     */
    // TODO: Rename and change types and number of parameters
    public static vi newInstance(String param1, String param2) {
        vi fragment = new vi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_vi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtnamestk,txtnamemapin,txtnamebank;
        EditText txtstk,txtmapin;
        Spinner txtbank;
        Button btnthem;
        ImageButton btnadd;

        txtnamestk =view.findViewById(R.id.txt_vi_namestk);
        txtnamemapin = view.findViewById(R.id.txt_vi_namemaping);
        txtnamebank= view.findViewById(R.id.txt_vi_namebank);
        txtstk = view.findViewById(R.id.txt_vi_stkhoan);
        txtmapin = view.findViewById(R.id.txt_vi_maping);
        txtbank= view.findViewById(R.id.cbb_vi_bank);
        btnthem = view.findViewById(R.id.btn_vi_them);
        btnadd =view.findViewById(R.id.btn_vi_add);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamestk.setVisibility(View.VISIBLE);
                txtnamemapin.setVisibility(View.VISIBLE);
                txtnamebank.setVisibility(View.VISIBLE);
                txtstk.setVisibility(View.VISIBLE);
                txtmapin.setVisibility(View.VISIBLE);
                txtbank.setVisibility(View.VISIBLE);
                btnthem.setVisibility(View.VISIBLE);
            }
        });
    }
}