package com.example.firebasedatabasestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class saveActivity extends AppCompatActivity {

    public final String TAG = "saveActivity";
    EditText name, email,phNo;
    RadioButton male, female;
    Button save;
    ProgressBar loading;
    FirebaseFirestore db;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        db = FirebaseFirestore.getInstance();

        name = findViewById(R.id.NameET);
        email = findViewById(R.id.EmailET);
        phNo = findViewById(R.id.PhNoET);
        save = findViewById(R.id.SaveBtn);
        loading = findViewById(R.id.loadingPB);
        male = findViewById(R.id.maleRB);
        female = findViewById(R.id.femaleRB);

        loading.setVisibility(View.GONE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                saveDetails();
            }
        });
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, "on male RadioButton checked" );
                if(isChecked){
                    gender = "Male";
                }
            }
        });

        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, "on female RadioButton checked" );
                if(isChecked){
                    gender = "Female";
                }
            }
        });

    }

    private void saveDetails() {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String PhNo = phNo.getText().toString();
        String Gender = gender;

        DataViewModel dataView = new DataViewModel(Name, Email, PhNo, Gender);

        db.collection("userData").add(dataView).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                loading.setVisibility(View.GONE);
                Toast.makeText(saveActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loading.setVisibility(View.GONE);
                Toast.makeText(saveActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}