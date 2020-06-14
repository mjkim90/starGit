package km.project.datepicketdialog

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AreaGoodsHeaderFilterCellAdapter(private val items: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    fun putItems(items: ArrayList<String>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun removeAll() {
        items.clear()
        notifyDataSetChanged()
    }

    private fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        items[holder.adapterPosition].run {
            (holder.itemView as TextView).run {
                text = items[position]
                setOnClickListener {
                    removeItem(holder.adapterPosition)
                }
            }
        }
    }
}
