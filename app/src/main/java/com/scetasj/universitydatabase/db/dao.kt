package com.scetasj.universitydatabase.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.scetasj.universitydatabase.model.Info

@Dao
interface dao {

    @Insert
    fun insertUser(users: Info)

    @Query("Select * from proffesor")
    fun gelAllUsers(): LiveData<List<Info>>

    @Update
    fun updateUser(users: Info)

    @Delete
    fun deleteUser(users: Info)

}