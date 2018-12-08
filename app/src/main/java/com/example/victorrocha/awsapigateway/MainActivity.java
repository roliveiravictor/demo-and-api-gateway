package com.example.victorrocha.awsapigateway;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import com.stonetree.clientsdk.PetStoreClient;
import com.stonetree.clientsdk.model.Pet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                ApiClientFactory factory = new ApiClientFactory();
                final PetStoreClient client = factory.build(PetStoreClient.class);
                final Pet pet = client.petsPetIdGet("1");
                Log.i("### THIS IS MY PET ###", pet.getType() + " " + String.valueOf(pet.getPrice()));
                return null;
            }
        }.execute();
    }
}
