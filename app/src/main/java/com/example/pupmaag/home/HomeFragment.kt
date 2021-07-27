package com.example.pupmaag.home


import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), OnRaportItemLongClick {

    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()
    private val homeVm by viewModels<HomeViewModel>()
    private val adapter = CarAdapter(this)

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
            adapter.setRaports(list)
        })
    }

   /* override fun onCarLongClick(raport: Raport, position: Int) {
        homeVm.addFavCar(raport)
    }
*/
}