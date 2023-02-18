package sivakumardev.boostcodechallenge.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sivakumardev.boostcodechallenge.pokedex.database.dao.PokemonDAO
import sivakumardev.boostcodechallenge.pokedex.model.Pokemon

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
@Database(entities = [Pokemon::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO
}
