package fr.technosens.fdjtest.presentation.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.technosens.fdjtest.R
import fr.technosens.fdjtest.databinding.ActivityMainBinding
import fr.technosens.fdjtest.presentation.adapter.TeamAdapter
import fr.technosens.fdjtest.presentation.viewmodel.LeagueViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val leagueViewModel: LeagueViewModel by viewModels()
    private val leagueList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val leagueAdapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line)
        binding.autoCompleteTextView.setAdapter(leagueAdapter)

        val llm = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = llm
        val teamAdapter = TeamAdapter()
        binding.recyclerView.adapter = teamAdapter

        leagueViewModel.leagues.observe(this, Observer { leagues ->
            leagueAdapter.clear()
            leagueList.clear()
            leagueAdapter.addAll(leagues.map {
                it.strLeague
            })
            leagueAdapter.notifyDataSetChanged()
        })

        leagueViewModel.teams.observe(this, Observer { teams ->
            teamAdapter.submitList(teams)
        })


        binding.autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            leagueViewModel.fetchTeams(binding.autoCompleteTextView.text.toString())
            // hide the keyboard after selecting the league
            hideKeyBoard()
        }
        leagueViewModel.fetchLeagues()
    }

    private fun hideKeyBoard() {
        val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_bar -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate menu with items using MenuInflator
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val searchViewItem = menu.findItem(R.id.search_bar)
        val searchView = MenuItemCompat.getActionView(searchViewItem) as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // Override onQueryTextSubmit method which is call when submit query is searched
            override fun onQueryTextSubmit(query: String): Boolean {
                // If the list contains the search query than filter the adapter
                // using the filter method with the query as its argument
//                if (mylist.contains(query)) {
//                    adapter.filter.filter(query)
//                } else {
//                    // Search query not found in List View
//                    Toast.makeText(this@MainActivity, "Not found", Toast.LENGTH_LONG).show()
//                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
//                adapter.filter.filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}