package com.dicoding.listmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.core.domain.model.Movie
import com.dicoding.listmovie.databinding.ActivityDetailMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailMovieBinding
    private val viewModel: DetailMovieViewModel by viewModel()
    companion object {
        const val DATA = "data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.toolbar.setNavigationOnClickListener{onBackPressed()}

        val detail = intent.getParcelableExtra<Movie>(DATA)

       showDetail(detail)
    }

    private fun showDetail(detail: Movie?){
        detail?.let {
            with(binding){
                Glide.with(this@DetailMovieActivity)
                    .load("https://image.tmdb.org/t/p/w500" + detail.coverMovie)
                    .transform(RoundedCorners(20))
                    .into(imgDetail)

                tvDateDetail.text = detail.date
                tvTitleDetail.text = detail.title
                tvRatingDetail.text = detail.vote_average.toString()
                tvDescDetail.text = detail.desc

                var favoriteStat = detail.isFav
                setFavStat(favoriteStat)

                fab.setOnClickListener{
                    favoriteStat = !favoriteStat
                    viewModel.setMovieFav(detail, favoriteStat)
                    setFavStat(favoriteStat)
                }
            }
        }
    }

    private fun setFavStat(favStat : Boolean){
        if(favStat){
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.ic_love_true)
            )
        }else{
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fav_false))
        }
    }
}