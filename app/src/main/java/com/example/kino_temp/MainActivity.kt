package com.example.kino_temp

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kino_temp.Const.Companion.API_KEY
import com.example.kino_temp.databinding.ActivityMainBinding
import com.example.kino_temp.models.Omdb.MoviesModel
import com.example.kino_temp.models.Omdb_2.Responses
import com.example.kino_temp.models.Omdb_2.S
import com.example.kino_temp.models.Omdb_seart.MoviesModel_1
import com.example.kino_temp.models.kinopoisk.Doc
import com.example.kino_temp.models.kinopoisk.ModelKinop
import com.example.kino_temp.retrofit.r.api.ApiService
import com.example.kino_temp.retrofit.r.api.RetrofitInstance
import com.example.kino_temp.retrofit.r.api.RetrofitRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    val list: MutableList<Film> = mutableListOf()
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory()}
    private val adapter by lazy ( LazyThreadSafetyMode.NONE ){ PagingAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


           binding.listTv.layoutManager = LinearLayoutManager(this)

              binding.listTv.adapter = adapter.withLoadStateHeaderAndFooter(header = MainLoadStateAdapter(), footer = MainLoadStateAdapter())

               lifecycleScope.launch { viewModel.data.collectLatest {   adapter.submitData(it);binding }; }




}
}

