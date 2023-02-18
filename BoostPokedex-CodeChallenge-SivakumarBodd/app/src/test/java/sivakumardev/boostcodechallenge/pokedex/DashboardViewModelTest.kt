package sivakumardev.boostcodechallenge.pokedex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import sivakumardev.boostcodechallenge.pokedex.database.dao.PokemonDAO
import sivakumardev.boostcodechallenge.pokedex.model.Pokemon
import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.DashboardViewModel
import io.mockk.*
import org.junit.*

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class DashboardViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val dao: PokemonDAO = mockk(relaxed = true)
    private lateinit var viewModel: DashboardViewModel

    @Before
    fun before() {
        viewModel = DashboardViewModel(pokemonDAO = dao)
    }

    @Test
    fun `GIVEN id WHEN request pokemon THEN get pokemon as result and call only 1 request`() {
        // GIVEN
        val input = "123"
        val expected: LiveData<Pokemon> = mockk(relaxed = true)
        every { dao.getById(input) } returns expected

        // WHEN
        val result = viewModel.getPokemonById(id = input)

        // THEN
        verify(exactly = 1) { dao.getById(input) }
        confirmVerified(dao)
        Assert.assertEquals(expected.value, result.value)
    }

    @Test
    fun `GIVEN a list of ids WHEN request pokemon evolutions THEN get a list of pokemons and call only 1 request`() {
        // GIVEN
        val input = listOf("123", "321")
        val pikachu = Pokemon().apply { name = "Pikachu" }
        val squirtle = Pokemon().apply { name = "Squirtle" }
        val expected = MutableLiveData(listOf(pikachu, squirtle))
        every { dao.getEvolutionsByIds(input) } returns expected

        // WHEN
        val result = viewModel.getPokemonEvolutionsByIds(ids = input)

        // THEN
        verify(exactly = 1) { dao.getEvolutionsByIds(input) }
        confirmVerified(dao)
        Assert.assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @AfterClass
        fun tearDown() {
            unmockkAll()
        }
    }
}
