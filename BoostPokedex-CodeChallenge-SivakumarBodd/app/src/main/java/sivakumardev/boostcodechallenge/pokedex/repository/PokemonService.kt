package sivakumardev.boostcodechallenge.pokedex.repository

import sivakumardev.boostcodechallenge.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
interface PokemonService {
    @GET("pokemon.json")
    fun get(): Call<List<Pokemon>>
}
