package com.scetasj.universitydatabase.viewmodel

import android.content.Context
import android.icu.text.IDNA
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.repository.UserRepository

class DeptViewmodel : ViewModel() {

    lateinit var list: LiveData<List<Info>>
    fun getDepartment( context: Context, lifecycleOwner: LifecycleOwner): LiveData<List<Info>> {

        list=UserRepository(context).getAllUsers()

        return  UserRepository(context).getAllUsers()

    }
}