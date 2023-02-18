package sivakumardev.boostcodechallenge.pokedex.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import java.util.Locale
import sivakumardev.boostcodechallenge.pokedex.R

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class PokemonColorUtil(var context: Context) {

    @ColorInt
    fun getPokemonColor(typeOfPokemon: List<String>?): Int {
        val type = typeOfPokemon?.getOrNull(0)
        val color = when (type?.toLowerCase(Locale.ROOT)) {
            "grass", "bug" -> R.color.lightTeal
            "fire" -> R.color.lightRed
            "water", "fighting", "normal" -> R.color.lightBlue
            "electric", "psychic" -> R.color.lightYellow
            "poison", "ghost" -> R.color.lightPurple
            "ground", "rock" -> R.color.lightBrown
            "dark" -> R.color.black
            else -> R.color.lightBlue
        }
        return convertColor(color)
    }

    @ColorInt
    fun convertColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}
