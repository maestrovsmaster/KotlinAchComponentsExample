package app.troc.kotlinexample3

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.row_user.view.*

class UserAdapter() : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var  users: List<User> = ArrayList()

    init {
      //  this.users = users
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val holderView = inflater.inflate(R.layout.row_user, viewGroup,false)
        val viewHolder = ViewHolder(holderView)

        return viewHolder
    }

    override fun getItemCount(): Int {

        return users.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        println("onBindViewHolder")
        viewHolder.bind(users[position])
       // viewHolder.nameTV.text = users[position].name
    }

    fun refreshData(users: List<User>){

        this.users = users
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var nameTV: TextView

        init {
            nameTV = itemView.findViewById(R.id.nameTV)
        }

        fun bind(user: User) = with(itemView) {
            println("bind")
            nameTV.text = user.name
            ageTV.text = user.age.toString()
        }
    }

}