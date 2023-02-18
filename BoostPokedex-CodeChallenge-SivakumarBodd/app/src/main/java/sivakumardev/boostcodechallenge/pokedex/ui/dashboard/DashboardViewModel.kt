package sivakumardev.boostcodechallenge.pokedex.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sivakumardev.boostcodechallenge.pokedex.database.dao.PokemonDAO
import sivakumardev.boostcodechallenge.pokedex.model.Pokemon

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class DashboardViewModel(private val pokemonDAO: PokemonDAO) : ViewModel() {

    fun getPokemonById(id: String?): LiveData<Pokemon> {
        return pokemonDAO.getById(id)
    }

    fun getPokemonEvolutionsByIds(ids: List<String>): LiveData<List<Pokemon>> {
        return pokemonDAO.getEvolutionsByIds(ids)
    }
}
