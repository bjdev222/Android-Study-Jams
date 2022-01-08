package com.scetasj.universitydatabase.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.db.AppDatabase
import com.scetasj.universitydatabase.db.dao

class UserRepository(context: Context) {

    var db: dao = AppDatabase.getInstance(context)?.userDao()!!


    //Fetch All the Users
    fun getAllUsers(): LiveData<List<Info>> {
        return db.gelAllUsers()
    }

    // Insert new user
    fun insertUser(users: Info) {
        db.insertUser(users)
    }

    // update user
    fun updateUser(users: Info) {
        db.updateUser(users)
    }

    // Delete user
    fun deleteUser(users: Info) {
        db.deleteUser(users)
    }

}