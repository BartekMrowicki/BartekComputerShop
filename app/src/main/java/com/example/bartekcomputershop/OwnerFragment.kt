package com.example.bartekcomputershop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.bartekcomputershop.database.PartDatabase
import com.example.bartekcomputershop.database.ShopDatabase
import kotlinx.android.synthetic.main.frag_owner.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class OwnerFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     return inflater.inflate(R.layout.frag_owner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton.setOnClickListener {
            val title = partTitle.text

            doAsync {
                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    ShopDatabase::class.java, "database-name"
                ).build()

                db.PartsDao().insertAll(PartDatabase(null, title.toString(), 239.99 ))
                uiThread {

                }
            }
        }
    }
}