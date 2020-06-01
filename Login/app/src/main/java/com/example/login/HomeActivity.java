package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.opencensus.tags.Tag;

public class HomeActivity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    // Cloud Firestore
    public static final String MORADA_KEY = "morada";
    public static final String IDADE_KEY = "idade";
    public static final String TAG = "InspiringQuote";
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("sampleData/inspiration/users/users_123/history/05182017");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser ==null) {
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            //Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //startActivity(intent);
        }

        btnLogOut = findViewById(R.id.logout);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);


                //Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                //startActivity(intToMain);
            }
        });
    }
    public void saveInfo (View view) {
        EditText moradaView = (EditText) findViewById(R.id.textMorada);
        EditText idadeView = (EditText) findViewById(R.id.textIdade);
        String morada = moradaView.getText().toString();
        String idade = idadeView.getText().toString();

        if (morada.isEmpty() || idade.isEmpty()) {return; }
        Map<String,Object> dataToSave = new HashMap<String, Object>();
        dataToSave.put(MORADA_KEY, morada);
        dataToSave.put(IDADE_KEY, idade);
        mDocRef.set(dataToSave).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.d(TAG, "Hooray! Document was saved!");
                } else {
                    Log.w(TAG, "Oh no!", task.getException());
                }
            }
        });
    }
}
