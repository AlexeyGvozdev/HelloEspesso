package sinx.com.helloespresso.recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_recycler_view.*
import sinx.com.helloespresso.R

class RecyclerViewActivity : AppCompatActivity() {

    private val adapter = ItemAdapter {
        Toast.makeText(this, it, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        val items = mutableListOf<Item>()
        for(i in 0..40) {
            items.add(i, Item(i.toString()))
        }
        adapter.items = items
    }
}
