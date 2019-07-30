package app.troc.kotlinexample3.main_fragment


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import app.troc.kotlinexample3.DataProvider
import app.troc.kotlinexample3.R
import kotlinx.android.synthetic.main.fragment_blank.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {


    private val userViewModel by lazy { ViewModelProviders.of(this).get(UsersListViewModel::class.java)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.title = "Main"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val rootView = inflater.inflate(R.layout.fragment_blank, container, false)


   return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Navigation.createNavigateOnClickListener(R.id.toLogin, null)


        loginButton.setOnClickListener {

            it.findNavController().navigate(R.id.toLogin)
        }

        var adapter = UserAdapter()

        var recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter



        refreshButton.setOnClickListener {  adapter.refreshData(DataProvider.usersList) }


        userViewModel.getListUsers().observe(this, Observer {
            it?.let {
                adapter.refreshData(it)
            }
        })
    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.title = "Main"
    }


}
