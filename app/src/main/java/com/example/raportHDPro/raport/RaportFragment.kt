package com.example.raportHDPro.raport


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.raportHDPro.BaseFragment
import com.example.raportHDPro.R
import kotlinx.android.synthetic.main.fragment_raport.*

class RaportFragment : BaseFragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

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
       openReportZone1Short()
       openReportZone2Short()
       openReportZone3Short()
       openReportZone4Short()
       openReportZone5Short()
       openReportZone6Short()

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
    private fun openReportZone1Short() {
        GoTo_fragment_raport_zone1short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone1ShortFragment().actionId)
        }
    }
    private fun openReportZone2Short() {
        GoTo_fragment_raport_zone2short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone2ShortFragment().actionId)
        }

    }
    private fun openReportZone3Short() {
        GoTo_fragment_raport_zone3short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone3ShortFragment().actionId)
        }

    }
    private fun openReportZone4Short() {
        GoTo_fragment_raport_zone4short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone4ShortFragment().actionId)
        }

    }
    private fun openReportZone5Short() {
        GoTo_fragment_raport_zone5short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone5ShortFragment().actionId)
        }

    }
    private fun openReportZone6Short() {
        GoTo_fragment_raport_zone6short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone6ShortFragment().actionId)
        }

    }

        }






