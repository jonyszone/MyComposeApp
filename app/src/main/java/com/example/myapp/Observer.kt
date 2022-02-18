package com.example.myapp

import android.util.Log
import androidx.lifecycle.*

class Observer : LifecycleEventObserver {

//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    fun onCreate(){
//        Log.d("main", "Observer")
//
//    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("Main", "Observer")
    }
}