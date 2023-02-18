package sivakumardev.boostcodechallenge.pokedex.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class Generation(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int
) {
    override fun toString() = "$id$title$image"
}
