package com.example.bartekcomputershop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.bartekcomputershop.database.ShopDatabase
import com.example.bartekcomputershop.models.Part
import com.google.gson.Gson
import kotlinx.android.synthetic.main.frag_main.*
import kotlinx.android.synthetic.main.frag_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainFragment : androidx.fragment.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.frag_main, container, false)
        doAsync {
            val json = URL("https://api.myjson.com/bins/xq0gc").readText()

            uiThread {

                val parts = Gson().fromJson(json, Array<Part>::class.java).toList()
                root.recycler_view.apply {
                    layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 2)
                    adapter = PartsAdapter(parts)
                    root.progressBar.visibility = View.GONE

                }
            }
        }



          doAsync {

              val db = Room.databaseBuilder(
                  activity!!.applicationContext,
                  ShopDatabase::class.java, "database-name"
              ).build()

              val partDatabase = db.PartsDao().searchFor("%computer%")

              val parts = partDatabase.map {

                  Part(
                      it.title,
                      "https://panaromabd.com/image/cache/catalog/gaming%20pc/c05520071%20copy-350x350.JPG",
                      it.Price,
                      true
                  )
              }
              uiThread {
                  recycler_view.apply {
                      layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 2)
                      adapter = PartsAdapter(parts)

                  }
                  progressBar.visibility = View.GONE
              }
          }


        //root.progressBar.visibility = View.GONE

        val categories = listOf(
            "Cpu",
            "Gpu",
            "Pre-Built Computers",
            "Cpu",
            "Gpu",
            "Pre-Built Computers",
            "Cpu",
            "Gpu",
            "Pre-Built Computers"
        )

        root.categoryview.apply {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                activity,
                androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
                false
            )
            adapter = CategoryAdapter(categories)
        }

        return root
    }
    }



