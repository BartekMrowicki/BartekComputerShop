package com.example.bartekcomputershop

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem
import androidx.room.Room
import com.example.bartekcomputershop.database.PartDatabase
import com.example.bartekcomputershop.database.ShopDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        doAsync {
            val db = Room.databaseBuilder(
                applicationContext,
                ShopDatabase::class.java, "database-name"
            ).build()

            db.PartsDao().insertAll(PartDatabase(null, "CPU", 239.99 ))
            val parts = db.PartsDao().getAll()
            uiThread {

            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame,MainFragment())
            .commit()

        naviview.setNavigationItemSelectedListener {
            it.isChecked = true
            drawerLayout.closeDrawers()
            when (it.itemId) {

                R.id.HomeScreen ->  {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MainFragment()).commit()
                }
                R.id.Owner ->  {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, OwnerFragment()).commit()
                }

                R.id.actionComputer ->  {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ComputerFragment()).commit()
                }
                R.id.actionCPU -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, CpuFragment()).commit()
             }
                R.id.actionGPU -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, GpuFragment()).commit()
                }
            }
            true

        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
      drawerLayout.openDrawer(GravityCompat.START)
        return true

    }

    }




