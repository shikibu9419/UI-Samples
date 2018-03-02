package com.example.shikibu.ui_samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_basic_realm_recycler.*

class BasicRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_realm_recycler)

        fab_add_data.setOnClickListener {
            addData()
        }
    }

    private fun addData() {
        Realm.getDefaultInstance().use { realm ->
            val data = ExampleModel()

            if(!realm.isEmpty) {
                data.id = realm.where(ExampleModel::class.java).max("id")!!.toLong() + 1
            }

            data.title = "Title ${data.id}"
            data.detail = "Detail ${data.id}"

            realm.executeTransaction {
                it.copyToRealmOrUpdate(data)

                it.where(ExampleModel::class.java).findAll().forEach {
                    Log.d("HOGE", "${it.id}: ${it.title}, ${it.detail}")
                }
            }
        }
    }
}