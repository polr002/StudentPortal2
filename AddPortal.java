package com.example.roy.studentportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddPortal extends AppCompatActivity {

    List<portalsObject> mPortals;
    private Button addBtn;
    private TextView newPortalName;
    private TextView newPortalURL;
    public static final String portals = "portals";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        addBtn = findViewById(R.id.addBtn);
        newPortalName = findViewById(R.id.portalNameView);
        newPortalURL = findViewById(R.id.portalURLView);

        mPortals = createmPortals();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //import data from the text fields
                String newItem = (String) newPortalName.getText().toString();
                String newURL = (String) newPortalURL.getText().toString();
                //Set message for the toast
                String message = newItem + " succesfully added!";

                //Add portals to the list
                mPortals.add(new portalsObject(newItem, newURL));

                //Inform user that new portal is added
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                //Start new activity where the portals are shown
                Intent data = new Intent(getApplicationContext(), MainActivity.class);
                data.putExtra(portals, (Serializable) mPortals);
                startActivity(data);
            }
        });
    }
    private List<portalsObject> createmPortals() {

        //get mPortals from the other activity
        mPortals = (List<portalsObject>) getIntent().getSerializableExtra("portals");

        //Check if mPortals contains data, otherwise it was empty and we need to initialize
        if (mPortals == null) {
            List<portalsObject> mPortals = new ArrayList<>();
            return mPortals;
        } else {
        return mPortals;
        }
    }
}
