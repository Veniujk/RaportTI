package com.example.pupmaag.raport


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import kotlinx.android.synthetic.main.fragment_raport.*

class RaportFragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_raport, container, false)
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       openReportZone1()
       openReportZone2()
       openReportZone3()
       openReportZone4()
       openReportZone5()
       openReportZone6()

       }

    private fun openReportZone1() {
        GoTo_fragment_raport_zone1.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz1().actionId)
        }
    }
    private fun openReportZone2() {
        GoTo_fragment_raport_zone2.setOnClickListener {
            findNavController()
            .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz2().actionId)
        }

    }
    private fun openReportZone3() {
        GoTo_fragment_raport_zone3.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz3().actionId)
        }

    }
    private fun openReportZone4() {
        GoTo_fragment_raport_zone4.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz4().actionId)
        }

    }
    private fun openReportZone5() {
        GoTo_fragment_raport_zone5.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz5().actionId)
        }

    }
    private fun openReportZone6() {
        GoTo_fragment_raport_zone6.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz6().actionId)
        }

    }

        }






