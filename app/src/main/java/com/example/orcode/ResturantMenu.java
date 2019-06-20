package com.example.orcode;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResturantMenu extends AppCompatActivity {
    private static final String TAG = "QRCODE";
    DatabaseReference reference;
    TextView name, contact,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_menu);

        name=findViewById(R.id.tvName);
        contact=findViewById(R.id.tvContact);
        location=findViewById(R.id.tvLocation);

        String rid = getIntent().getStringExtra("resturantId");//getting data using intent
        System.out.println(rid+"jkdsajgfadsjhfjkadshgjkadshgkjhadskjghakjdsgkjhadskjhgkjdsahgkjadshgkjdshgkjashdjghkjksjgjdg");
//        if (rid!=null){
            reference= FirebaseDatabase.getInstance().getReference().child("resturant").child("1");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String resturantName=dataSnapshot.child("name").getValue().toString();
                    System.out.println(resturantName);
                    String resturantContact=dataSnapshot.child("contact").getValue().toString();
                    String resturantLocation=dataSnapshot.child("location").getValue().toString();

                    name.setText(resturantName);
                    contact.setText(resturantContact);
                    name.setText(resturantLocation);
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(ResturantMenu.this, "Data was not retrieved",Toast.LENGTH_LONG).show();
                }
            });

//        }else{
//            Toast.makeText(this, "Data was not retrieved",Toast.LENGTH_LONG).show();
//        }


    }
}
