package app.troc.kotlinexample3.main_fragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import app.troc.kotlinexample3.DataProvider
import app.troc.kotlinexample3.model.User

class UsersListViewModel : ViewModel() {

    var userList : MutableLiveData<List<User>> = MutableLiveData()


    init {
        userList.value = DataProvider.getUsers()
    }

    fun getListUsers() = userList


    fun updateListUsers() {
        userList.value = DataProvider.getAnotherUsers()
    }
}