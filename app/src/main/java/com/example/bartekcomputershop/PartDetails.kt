package com.example.bartekcomputershop
import android.app.AlertDialog
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.part_details.*

class PartDetails: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.part_details)

        val title = intent.getStringExtra("title")
val photoURL = intent.getStringExtra("photoUrl")
        part_name.text = title

        Picasso.get().load(photoURL).into(photop)


        in_stock.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Thank you for asking, $title is here ready to be pick up!")
                .setPositiveButton("ok") { _, _ ->

                }
                .create()
                .show()
        }
    }
}