package com.example.shikibu.ui_samples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class TabListFragment: Fragment() {

    private lateinit var list: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments
        list = args.getStringArrayList(BasicTabHostActivity.EXTRA_ID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?
                              , savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_tabhost_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mListView = view?.findViewById<View>(R.id.tabhost_listview) as ListView
        mListView.adapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, list)
    }
}