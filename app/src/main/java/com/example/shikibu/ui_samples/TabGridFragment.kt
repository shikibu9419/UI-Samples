package com.example.shikibu.ui_samples

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TabGridFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments
        val array = args.getStringArrayList(BasicTabHostActivity.EXTRA_ID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?
                              , savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_tabhost_grid, container, false)
    }
}