package com.example.roy.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter mAdapter;
    List<portalsObject> mPortals;
    public static final String portals = "portals";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.portalsListView);

        //get mPortals from AddPortal
        mPortals = (List<portalsObject>) getIntent().getSerializableExtra("portals");

        //if mportals has a value we update the UI
        if(mPortals != null) {
            updateUI();
        }

        //Floating action btn to add portals
        FloatingActionButton newPortalBtn = (FloatingActionButton) findViewById(R.id.newPortalBtn);
        newPortalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start AddPortal and pass the portalsObject
                Intent data = new Intent(getApplicationContext(), AddPortal.class);
                data.putExtra(portals, (Serializable) mPortals);
                startActivity(data);
            }
        });

        //Listener for clicks on the listview
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the url from the clicked portal
                portalsObject portal = (portalsObject) listView.getItemAtPosition(position);
                String portalUrl = portal.getPortalURL();

                //Start webview activity and pass the URL to it
                Intent data = new Intent(getApplicationContext(), WebViewActivity.class);
                data.putExtra("URL", portalUrl);
                startActivity(data);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                portalsObject portal = (portalsObject) parent.getItemAtPosition(position);
                String delItem = portal.getPortalName();
                String message = delItem + " is deleted!";

                mPortals.remove(position);
                updateUI();

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new CustomAdapter(this, mPortals);
            listView.setAdapter(mAdapter);

        } else {
            mAdapter.notifyDataSetChanged();
        }

    }

}
