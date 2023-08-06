package com.sbz.shoppinnglist

import android.app.Application
import com.sbz.shoppinnglist.ui.repository.Graph

class ShoppingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(applicationContext)
    }
}