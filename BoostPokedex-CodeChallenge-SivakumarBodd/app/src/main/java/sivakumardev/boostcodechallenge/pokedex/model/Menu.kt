package sivakumardev.boostcodechallenge.pokedex.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
data class Menu(
    val id: Int,
    @StringRes val name: Int,
    @ColorRes val color: Int
)
