package com.example.shikibu.ui_samples

import android.nfc.NfcAdapter.EXTRA_ID
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentTabHost
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_basic_tabhost.*

class BasicTabHostActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_tabhost)

        val args = Bundle()
        args.putStringArrayList(EXTRA_ID, array)

        tabSetUp(args)
    }

    private fun tabSetUp(args: Bundle) {
        val mFragmentManager = supportFragmentManager
        val tabHost: FragmentTabHost = tabhost
        tabHost.setup(this, mFragmentManager, R.id.tab_content)

        val homeTabSpec = tabHost.newTabSpec("Home")
        homeTabSpec.setIndicator("HOME")
        tabHost.addTab(homeTabSpec, TabHomgeFragment, null)

        val listTabSpec = tabHost.newTabSpec("List")
        listTabSpec.setIndicator("LISTVIEW")
        tabHost.addTab(listTabSpec, TabListFragment, args)

        val gridTabSpec = tabHost.newTabSpec("Grid")
        gridTabSpec.setIndicator("GRIDVIEW")
        tabHost.addTab(gridTabSpec, TabGridFragment, args)
    }
}
