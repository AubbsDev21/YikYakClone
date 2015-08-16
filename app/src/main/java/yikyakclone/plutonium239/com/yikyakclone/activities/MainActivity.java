package yikyakclone.plutonium239.com.yikyakclone.activities;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import yikyakclone.plutonium239.com.yikyakclone.R;
import yikyakclone.plutonium239.com.yikyakclone.adapters.YaksListAdapter;
import yikyakclone.plutonium239.com.yikyakclone.events.MainActivityEvents;
import yikyakclone.plutonium239.com.yikyakclone.utilities.Utilities;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private ListView yaksListView;
    private YaksListAdapter adapter;
    private FloatingActionButton fab;
    private GoogleApiClient apiClient;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setEvents();
        setupApi();
    }

    private void setupApi() {
        apiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        apiClient.connect();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(Utilities.getLocation() != null) {
            adapter.loadObjects();
        }
    }

    private void setEvents() {
        MainActivityEvents events = new MainActivityEvents();

        fab.setOnClickListener(events.getNewYakOnClickListener(this, NewYakActivity.class));

        //show delete etc.
        yaksListView.setOnItemLongClickListener(events.getYaksListViewOnItemLongClickListener());

        yaksListView.setOnItemClickListener(events.getYaksListViewOnItemClickListener(this, YakActivity.class));
    }

    private void initializeComponents() {
        yaksListView = (ListView)findViewById(R.id.yaksListView);
        fab = (FloatingActionButton)findViewById(R.id.fab);

        adapter = new YaksListAdapter(this);

//        yaksListView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    public YaksListAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onConnected(Bundle bundle) {
        LocationRequest request = new LocationRequest();
        request.setInterval(1000000);
        request.setFastestInterval(1000000);
        request.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, request, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Utilities.setLocation(location);

                if(yaksListView.getAdapter() == null) {
                    yaksListView.setAdapter(adapter);
                } else {
                    adapter.loadObjects();
                }
            }
        });
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
