package sivakumardev.boostcodechallenge.pokedex.ui.home

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.databinding.ItemMenuBinding
import sivakumardev.boostcodechallenge.pokedex.model.Menu
import sivakumardev.boostcodechallenge.pokedex.utils.PokemonColorUtil

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class MenuAdapter(
    private val list: List<Menu>,
    private val context: Context
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val viewBinding = ItemMenuBinding.bind(itemView)
        fun bindView(item: Menu) {
            viewBinding.textViewName.text = itemView.context.getString(item.name)

            val color = PokemonColorUtil(itemView.context).convertColor(item.color)
            viewBinding.relativeLayoutBackground.background.colorFilter =
                PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

            itemView.setOnClickListener {
                it.findNavController().navigate(R.id.action_navigation_home_to_navigation_pokedex)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
