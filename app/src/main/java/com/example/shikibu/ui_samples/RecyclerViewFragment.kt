package com.example.shikibu.ui_samples

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import io.realm.RealmResults


class RecyclerViewFragment: Fragment() {

    private lateinit var mRealm: Realm
    private lateinit var results: RealmResults<Model>

    private inner class TouchHelperCallback internal constructor() : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteItem(viewHolder.itemId)
        }

        override fun isLongPressDragEnabled(): Boolean {
            return true
        }
    }

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

        results = mRealm.where(Model::class.java).findAll()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerViewAdapter(results)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        val touchHelperCallback = TouchHelperCallback()
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    fun deleteItem(id: Long) {
        synchronized(lock = Object()) {
            val item = results.where().equalTo("id", id).findAll()
            mRealm.executeTransaction {
                item.deleteAllFromRealm()
            }
        }
    }
}
