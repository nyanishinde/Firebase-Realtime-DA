package com.example.realtimedb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText userName,userEmail,userPhone,userDesc;
    Button addBtn;

    private DatabaseReference myRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=findViewById(R.id.edtUserName);
        userEmail=findViewById(R.id.edtUserEmail);
        userPhone=findViewById(R.id.edtPhone);
        userDesc=findViewById(R.id.edtDesc);
        addBtn=findViewById(R.id.btnADd);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=userName.getText().toString();
                String email=userEmail.getText().toString();
                String phone=userPhone.getText().toString();
                String desc =userDesc.getText().toString();

                myRootReference= FirebaseDatabase.getInstance().getReference();

                UserDM user = new UserDM(name,email,phone,desc);

                myRootReference.child("Users").child(user.getUserName()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}