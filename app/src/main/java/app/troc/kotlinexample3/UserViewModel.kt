package app.troc.kotlinexample3

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var userList : MutableLiveData<List<User>> = MutableLiveData()

    //инициализируем список и заполняем его данными пользователей
    init {
        userList.value = DataProvider.getUsers()
    }

    fun getListUsers() = userList

    //для обновления списка передаем второй список пользователей
    fun updateListUsers() {
        userList.value = DataProvider.getAnotherUsers()
    }
}