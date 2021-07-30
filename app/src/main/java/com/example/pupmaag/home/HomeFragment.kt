package com.example.pupmaag.home


import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.example.pupmaag.data.Raport
import com.example.pupmaag.profile.ProfileFragmentDirections
import com.example.pupmaag.raport.RaportFragmentDirections
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.list_row.*

class HomeFragment : BaseFragment(), OnRaportItemLongClick {

    private val auth = FirebaseAuth.getInstance()
    private val homeVm by viewModels<HomeViewModel>()
    private val adapter = RaportAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout_action -> {
                auth.signOut()
                requireActivity().finish()
            }
        }
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_home.layoutManager = LinearLayoutManager(requireContext())
        recyclerView_home.adapter = adapter
          }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeVm.raports.observe(viewLifecycleOwner, { list ->
            adapter.setRaports(list.sortedByDescending { it.date })
        })
    }


    override fun onRaportLongClick(raport: Raport, position: Int) {
        val bundle = bundleOf("raport" to raport)

        if (raport.zone == "Strefa 1"){
            findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToRaportFragmentz1().actionId,bundle)}
        else{
            if (raport.zone == "Strefa 2"){
                findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToRaportFragmentz2().actionId,bundle)}
            else{
                if (raport.zone == "Strefa 3"){
                    findNavController()
                        .navigate(HomeFragmentDirections.actionHomeFragmentToRaportFragmentz3().actionId,bundle)}
                else{
                    if (raport.zone == "Strefa 4"){
                        findNavController()
                            .navigate(HomeFragmentDirections.actionHomeFragmentToRaportFragmentz4().actionId,bundle)}
                    else {
                        if (raport.zone == "Strefa 5 - okres zimowy") {
                            findNavController()
                                .navigate(
                                    HomeFragmentDirections.actionHomeFragmentToRaportFragmentz5().actionId,
                                    bundle
                                )
                        } else {
                            findNavController()
                                .navigate(
                                    HomeFragmentDirections.actionHomeFragmentToRaportFragmentz6().actionId,
                                    bundle
                                )
                        }

                    }
                }
            }
        }
    }

}