package com.example.conexaapp.ui.contacts.contactlocalization

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.conexaapp.MainActivity
import com.example.conexaapp.R
import com.example.conexaapp.ui.news.newdetail.NewDetailFragmentArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ContactLocalizationFragment : Fragment() {

    private val args: ContactLocalizationFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->
        val localization = LatLng(args.lat.toDouble(), args.longitud.toDouble())
        googleMap.addMarker(MarkerOptions().position(localization).title("Here is ${args.name}"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(localization))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(localization, 14f), 5000, null)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_localization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        (activity as? MainActivity)?.setUpToolbar(true, "Localization") {
            findNavController().popBackStack()
        }
    }
}