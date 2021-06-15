package com.example.donation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClothesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClothesFragment extends Fragment implements View.OnClickListener{

    private EditText customer_uidEdit, customer_nameEdit, customer_addressEdit, customer_clothTypeEdit, customer_pickupDateEdit, customer_TimeEdit, customer_QuantityEdit;

    // creating variable for button
    private Button submitBtn;

    // creating a strings for storing
    // our values from edittext fields.
    private String customer_uid, customer_name, customer_address, customer_clothType, customer_pickupDate, customer_Time, customer_Quantity;

    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;

private View view;
private Button button;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClothesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClothesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClothesFragment newInstance(String param1, String param2) {
        ClothesFragment fragment = new ClothesFragment();
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
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_clothes, container, false);
      button=view.findViewById(R.id.button3);
        button.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons

        customer_nameEdit = view.findViewById(R.id.username5);
        customer_addressEdit = view.findViewById(R.id.username4);
        customer_clothTypeEdit= view.findViewById(R.id.username3);
        customer_pickupDateEdit = view.findViewById(R.id.username2);
        customer_TimeEdit = view.findViewById(R.id.username);
        customer_QuantityEdit= view.findViewById(R.id.username6);
        submitBtn = view.findViewById(R.id.button);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting data from edittext fields.
                customer_name= customer_nameEdit.getText().toString();
                customer_address =  customer_addressEdit.getText().toString();
                customer_clothType = customer_clothTypeEdit.getText().toString();
                customer_pickupDate= customer_pickupDateEdit.getText().toString();
                customer_Quantity =  customer_QuantityEdit.getText().toString();
                customer_Time = customer_TimeEdit.getText().toString();
                if (TextUtils.isEmpty( customer_name)) {
                    customer_nameEdit.setError("Please enter Name");
                } else if (TextUtils.isEmpty(customer_address)) {
                    customer_addressEdit.setError("Please enter Address");
                } else if (TextUtils.isEmpty(customer_clothType)) {
                    customer_clothTypeEdit.setError("Please enter Cloth type");
                }else if (TextUtils.isEmpty(customer_pickupDate)) {
                    customer_pickupDateEdit.setError("Please enter pickup date");
                } else if (TextUtils.isEmpty(customer_Quantity)) {
                    customer_QuantityEdit.setError("Please enter Quantity");
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(customer_name, customer_address, customer_clothType, customer_pickupDate, customer_Time, customer_Quantity);
                }
            }
        });
        return view;
    }

    private void addDataToFirestore(String customer_name, String customer_address,String  customer_clothType,String  customer_pickupDate,String  customer_Time,String  customer_Quantity) {
        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbCourses = db.collection("Donation");

        // adding our data to our courses object class.
        Clothes clothes = new Clothes(customer_name, customer_address, customer_clothType, customer_pickupDate, customer_Time, customer_Quantity);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(clothes).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(getContext(), "Your Clothes has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(getContext(), "Fail to add Cloth \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v) {
        Fragment fragment=new UploadFragment();
        switch (v.getId()){
            case R.id.button3:
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

        }
    }
}