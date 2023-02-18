package sivakumardev.boostcodechallenge.pokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import sivakumardev.boostcodechallenge.pokedex.database.dao.PokemonDAO
import sivakumardev.boostcodechallenge.pokedex.model.Pokemon
import sivakumardev.boostcodechallenge.pokedex.repository.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class PokedexViewModel(
    private val pokemonDAO: PokemonDAO,
    private val pokemonService: PokemonService
) : ViewModel() {

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        val call = pokemonService.get()

        call.enqueue(object : Callback<List<Pokemon>?> {
            override fun onResponse(
                call: Call<List<Pokemon>?>?,
                response: Response<List<Pokemon>?>?
            ) {
                response?.body()?.let { pokemons: List<Pokemon> ->
                    thread {
                        pokemonDAO.add(pokemons)
                    }
                }
            }

            override fun onFailure(call: Call<List<Pokemon>?>?, t: Throwable?) {
                // error
                t?.printStackTrace()
            }
        })
    }

    fun getListPokemon() = pokemonDAO.all()
}
