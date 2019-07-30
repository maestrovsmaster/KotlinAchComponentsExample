package app.troc.kotlinexample3


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_blank.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) //for back pressed
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.title = "Login"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_login, container, false)



        loginButton.setOnClickListener { back() }






        return rootView
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        println("BackFromFragment")
        if (item?.getItemId() == android.R.id.home) {
            println("BackFromFragment home")
            back()
        }

        return super.onOptionsItemSelected(item)
    }

    fun back() {
        val fm = fragmentManager
        if (fm!!.backStackEntryCount > 0) {

            fm.popBackStack()
        } else {
        }
    }


}
