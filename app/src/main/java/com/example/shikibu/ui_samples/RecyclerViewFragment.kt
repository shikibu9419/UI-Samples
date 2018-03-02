package com.example.shikibu.ui_samples

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm



class RecyclerViewFragment: Fragment() {

    private lateinit var mRealm: Realm

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_basic_realm_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRealm = Realm.getDefaultInstance()
        setUpRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }

    private fun setUpRecyclerView() {
        val recyclerView = view.findViewById<View>(R.id.realm_recycler_view) as RecyclerView
        val data = mRealm.where(ExampleModel::class.java).findAll()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerViewAdapter(data)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}
