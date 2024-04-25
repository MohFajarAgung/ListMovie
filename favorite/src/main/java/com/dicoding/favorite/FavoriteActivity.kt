package com.dicoding.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.core.ui.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.dicoding.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.favorite.di.favoriteModule
import com.dicoding.listmovie.DetailMovieActivity
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.unloadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFavoriteBinding
    private val viewModel : FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val favAdapter = MovieAdapter()
        favAdapter.onItemClick = { movie ->
            Intent(this, DetailMovieActivity::class.java).also {
                it.putExtra(DetailMovieActivity.DATA, movie)
                startActivity(it)
            }
        }

        viewModel.favorite.observe(this, {
            favAdapter.setData(it)
            binding.viewEmpty.root.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
        })

        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = favAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(favoriteModule)
    }
}