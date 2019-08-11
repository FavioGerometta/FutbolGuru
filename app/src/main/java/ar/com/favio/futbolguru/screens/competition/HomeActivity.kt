package ar.com.favio.futbolguru.screens.competition

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import ar.com.favio.futbolguru.R

import ar.com.favio.futbolguru.databinding.ActivityHomeBinding
import ar.com.favio.futbolguru.screens.competition.competitions.CompetitionsFragment
import ar.com.favio.futbolguru.screens.competition.today.TodayFixturesFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : DaggerAppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    /*@Inject
    var connectivityReceiver: ConnectivityReceiver? = null*/

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_fixture -> {
                binding.toolbar.title = "Today\'s Fixtures"
                supportFragmentManager.beginTransaction()
                    .replace(frame_container.id, TodayFixturesFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_competition -> {
                binding.toolbar.title = "Competitions"
                supportFragmentManager.beginTransaction()
                    .replace(frame_container.id, CompetitionsFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        binding.navigation.selectedItemId = R.id.navigation_fixture
    }
}