package sinx.com.helloespresso.recycler_view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sinx.com.helloespresso.R

class ItemAdapter(private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.tv_item)

        fun bind(item: Item, onItemClick: (String) -> Unit) {
            textView.text = item.value
            textView.setOnClickListener {
                onItemClick(item.value)
            }
        }

    }
}