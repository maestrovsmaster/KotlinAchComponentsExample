package app.troc.kotlinexample3

import app.troc.kotlinexample3.model.User

object DataProvider {

    var usersList = ArrayList<User>()

    init {
        usersList.add(User("Petya", 18))
        usersList.add(User("Andrew", 25))
        usersList.add(User("Anna", 24))

    }

     fun getUsers():ArrayList<User>{
        return usersList
    }


    fun getAnotherUsers():ArrayList<User>{
        usersList.add(User("sonya", 14))
        return usersList
    }
}