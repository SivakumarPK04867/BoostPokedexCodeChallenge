package sivakumardev.boostcodechallenge.pokedex.ui.pokedex

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.databinding.ItemPokemonBinding
import sivakumardev.boostcodechallenge.pokedex.model.Pokemon
import sivakumardev.boostcodechallenge.pokedex.utils.ImageLoadingListener
import sivakumardev.boostcodechallenge.pokedex.utils.PokemonColorUtil

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class PokemonAdapter(
    private val list: List<Pokemon>,
    private val itemClickedListener: OnItemClickedListener? = null,
    private val imageLoadedListener: OnImageLoadedListener? = null
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val viewBinding = ItemPokemonBinding.bind(itemView)

        fun bindView(
            item: Pokemon,
            itemClickedListener: OnItemClickedListener?,
            imageLoadedListener: OnImageLoadedListener?
        ) {

            viewBinding.textViewName.text = item.name
            viewBinding.textViewID.text = item.id

            val color = PokemonColorUtil(itemView.context).getPokemonColor(item.typeofpokemon)
            viewBinding.relativeLayoutBackground.background.colorFilter =
                PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

            item.typeofpokemon?.getOrNull(0).let { firstType ->
                viewBinding.textViewType3.text = firstType
                viewBinding.textViewType3.isVisible = firstType != null
            }

            item.typeofpokemon?.getOrNull(1).let { secondType ->
                viewBinding.textViewType2.text = secondType
                viewBinding.textViewType2.isVisible = secondType != null
            }

            item.typeofpokemon?.getOrNull(2).let { thirdType ->
                viewBinding.textViewType1.text = thirdType
                viewBinding.textViewType1.isVisible = thirdType != null
            }

            Glide.with(itemView.context)
                .load(item.imageurl)
                .placeholder(android.R.color.transparent)
                .addListener(ImageLoadingListener {
                    imageLoadedListener?.invoke(item, viewBinding.imageView)
                })
                .into(viewBinding.imageView)

            viewBinding.imageView.transitionName = item.name
            itemView.setOnClickListener {
                itemClickedListener?.invoke(item, this)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item, itemClickedListener, imageLoadedListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

typealias OnImageLoadedListener = (pokemon: Pokemon, imageView: ImageView) -> Unit

typealias OnItemClickedListener = (pokemon: Pokemon, viewHolder: PokemonAdapter.ViewHolder) -> Unit
