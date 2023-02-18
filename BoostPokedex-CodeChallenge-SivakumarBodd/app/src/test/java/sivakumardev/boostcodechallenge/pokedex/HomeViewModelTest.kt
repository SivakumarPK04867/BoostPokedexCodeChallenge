package sivakumardev.boostcodechallenge.pokedex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import sivakumardev.boostcodechallenge.pokedex.model.Menu
import sivakumardev.boostcodechallenge.pokedex.ui.home.HomeViewModel
import io.mockk.unmockkAll
import org.junit.*

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun before() {
        viewModel = HomeViewModel()
    }

    @Test
    fun `GIVEN list of menus WHEN call function THEN result as expected`() {
        // GIVEN
        val expected = listOf(
            Menu(id = 1, name = R.string.menu_item_1, color = R.color.lightTeal),
            Menu(id = 1, name = R.string.menu_item_2, color = R.color.lightRed),
            Menu(id = 1, name = R.string.menu_item_3, color = R.color.lightBlue),
            Menu(id = 1, name = R.string.menu_item_4, color = R.color.lightYellow),
            Menu(id = 1, name = R.string.menu_item_5, color = R.color.lightPurple),
            Menu(id = 1, name = R.string.menu_item_6, color = R.color.lightBrown)
        )

        // WHEN
        val result = viewModel.getListMenu()

        // THEN
        val expectedTransformed = expected.map { it.toString() }
        val resultTransformed = result.value!!.map { it.toString() }
        Assert.assertEquals(expectedTransformed, resultTransformed)
    }

    @Test
    fun `GIVEN list of news WHEN call function THEN result expected size`() {
        // GIVEN
        val expectedSize = 8

        // WHEN
        val result = viewModel.getListNews()

        // THEN
        Assert.assertEquals(expectedSize, result.value!!.size)
    }

    companion object {
        @JvmStatic
        @AfterClass
        fun tearDown() {
            unmockkAll()
        }
    }
}
