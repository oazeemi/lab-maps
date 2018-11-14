package edu.uw.oazeemi.maplab

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val fountain = LatLng(47.653809, -122.307808)
        val drawing = PolylineOptions().add(LatLng(47.654027, -122.308256)).add(LatLng(47.653529, -122.307999))
                .add(LatLng(47.653809, -122.307808)).add(LatLng(47.653547, -122.307580)).add(LatLng(47.654014, -122.307349))
                .color(Color.rgb(232, 211, 162))
        mMap.addMarker(MarkerOptions().position(fountain).title("Marker in Fountain").snippet("The ducks live here")
                .icon(BitmapDescriptorFactory.defaultMarker(268F)))
        mMap.addPolyline(drawing)
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
