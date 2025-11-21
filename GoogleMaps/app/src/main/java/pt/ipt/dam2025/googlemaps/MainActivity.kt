package pt.ipt.dam2025.googlemaps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import pt.ipt.dam2025.googlemaps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /* ##############################################################
           DO NOT FORGET THAT YOU MUST ASK FOR PERMISSION TO USE GPS DATA
           ############################################################## */


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just add a marker at IPT, Tomar.
     * If Google Play services is not installed on the device,
     * the user will be prompted to install it inside the SupportMapFragment.
     * This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Tomar and move the camera to it
        val tomar = LatLng(39.59955518526609, -8.389549138467965)
        mMap.addMarker(MarkerOptions().position(tomar).title("Marker in IPT (I154)"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tomar))
        //                                          .newLatLngZoom(tomar,15f))
    }




}