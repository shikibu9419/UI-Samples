package com.example.shikibu.ui_samples

import android.os.Bundle
import android.support.v4.app.FragmentTabHost
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_basic_tabhost.*

class BasicTabHostActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_tabhost)

        val array = arrayListOf("Miho Nishizumi", "Saori Takebe", "Hana Isuzu", "Yukari Akiyama", "Mako Reizen",
                                "Darjeeling", "Kay", "Anchovy", "Катюша", "Maho Nishizumi")
        val args = Bundle()
        args.putStringArrayList(EXTRA_ID, array)

        tabSetUp(args)
    }

    private fun tabSetUp(args: Bundle) {
        val mFragmentManager = supportFragmentManager
        val tabHost: FragmentTabHost = tabhost
        tabHost.setup(this, mFragmentManager, R.id.content)

        val homeTabSpec = tabHost.newTabSpec("Home")
        homeTabSpec.setIndicator("HOME")
        tabHost.addTab(homeTabSpec, TabHomeFragment::class.java, null)

        val listTabSpec = tabHost.newTabSpec("List")
        listTabSpec.setIndicator("LIST VIEW")
        tabHost.addTab(listTabSpec, TabListFragment::class.java, args)

        val gridTabSpec = tabHost.newTabSpec("Grid")
        gridTabSpec.setIndicator("GRID VIEW")
        tabHost.addTab(gridTabSpec, TabGridFragment::class.java, args)
    }

    companion object {
        const val EXTRA_ID = "com.example.shikibu.ui_samples_basic_tabhost_activity"
    }
}
