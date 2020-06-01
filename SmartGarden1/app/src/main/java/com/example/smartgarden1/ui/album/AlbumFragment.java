package com.example.smartgarden1.ui.album;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.smartgarden1.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

//import static androidx.core.content.PermissionChecker.checkSelfPermission;

public class AlbumFragment extends Fragment{

    //private AlbumViewModel albumViewModel;
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1;
    private ProgressDialog mProgress;
    private Uri image_uri;
    private StorageReference mStorage;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    String usermail = firebaseUser.getEmail();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_album, container, false);
        ImageButton btn;
        btn = root.findViewById(R.id.buttonphoto);

        mStorage = FirebaseStorage.getInstance().getReference();
        mProgress = new ProgressDialog(getContext());

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Opening Camera", Toast.LENGTH_LONG ).show();
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, PERMISSION_CODE);
                }else{
                    //Do your work
                    openCamera();
                }
            }
        });
        return root;
    }

    private void openCamera(){
        //Toast.makeText(getActivity(), "Opening Camera", Toast.LENGTH_LONG ).show();
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();
        if (requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK){
            Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();
            mProgress.setMessage("Uploading Image...");
            mProgress.show();
            Uri uri = data.getData();

            StorageReference filepath = mStorage.child(usermail).child(image_uri.getLastPathSegment());
            filepath.putFile(image_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //mProgress.dismiss();
                    Toast.makeText(getActivity(), "Upload finished", Toast.LENGTH_SHORT).show();
                }
            });
            filepath.putFile(image_uri).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity(), "Upload not finished", Toast.LENGTH_SHORT).show();
                }
            });
        }else if (resultCode == RESULT_CANCELED){
            Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                }
                else{
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }

    };
}
