package sivakumardev.boostcodechallenge.pokedex.ui.generation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.model.Generation

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class GenerationViewModel : ViewModel() {

    private val listGeneration = MutableLiveData<List<Generation>>()

    fun getListGeneration(): LiveData<List<Generation>> {
        listGeneration.value = listOf(
            Generation(id = 1, title = R.string.generation_item_1, image = R.drawable.gen1),
            Generation(id = 1, title = R.string.generation_item_2, image = R.drawable.gen2),
            Generation(id = 1, title = R.string.generation_item_3, image = R.drawable.gen3),
            Generation(id = 1, title = R.string.generation_item_4, image = R.drawable.gen4),
            Generation(id = 1, title = R.string.generation_item_5, image = R.drawable.gen5),
            Generation(id = 1, title = R.string.generation_item_6, image = R.drawable.gen6),
            Generation(id = 1, title = R.string.generation_item_7, image = R.drawable.gen7),
            Generation(id = 1, title = R.string.generation_item_8, image = R.drawable.gen8)
        )
        return listGeneration
    }
}
