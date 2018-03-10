package com.example.shikibu.ui_samples

import android.support.design.widget.CoordinatorLayout
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class MainLayout: AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        drawerLayout {
            id = R.id.drawer_layout
            fitsSystemWindows = true
            lparams(width = matchParent, height = matchParent)

            include<CoordinatorLayout>(R.layout.app_bar_main)

            navigationView {
                id = R.id.nav_view
                fitsSystemWindows = true
                lparams(width = wrapContent, height = matchParent, gravity = Gravity.START)

                inflateHeaderView(R.layout.nav_header_main)
                inflateMenu(R.menu.activity_main_drawer)
            }
        }
    }
}