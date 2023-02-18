package sivakumardev.boostcodechallenge.pokedex.ui.dashboard

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.about.AboutFragment
import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.evolution.EvolutionFragment
import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.moves.MovesFragment
import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.stats.StatsFragment

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class ViewPagerAdapter(
    supportFragmentManager: FragmentManager,
    context: Context,
    private val pokemonId: String
) : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    data class Page(val title: String, val ctor: () -> Fragment)

    @Suppress("MoveLambdaOutsideParentheses")
    private val pages = listOf(
        Page(
            context.getString(R.string.dashboard_tab_1),
            { AboutFragment.newInstance(pokemonId) }
        ),
        Page(
            context.getString(R.string.dashboard_tab_2),
            { StatsFragment.newInstance(pokemonId) }
        ),
        Page(
            context.getString(R.string.dashboard_tab_3),
            { EvolutionFragment.newInstance(pokemonId) }
        ),
        Page(
            context.getString(R.string.dashboard_tab_4),
            { MovesFragment() }
        )
    )

    override fun getItem(position: Int): Fragment {
        return pages[position].ctor()
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pages[position].title
    }
}
