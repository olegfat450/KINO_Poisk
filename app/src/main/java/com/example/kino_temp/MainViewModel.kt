package com.example.kino_temp

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.kino_temp.models.kinopoisk.Doc
import com.example.kino_temp.models.kinopoisk.ModelKinop
import com.example.kino_temp.retrofit.r.api.ApiService
import com.example.kino_temp.retrofit.r.api.RetrofitRepository
import com.google.android.gms.location.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(): ViewModel() {

    val data = Pager(
           PagingConfig(pageSize = 10,
               initialLoadSize = 10,
               enablePlaceholders = true,
               maxSize = 30
           ),
    ) { FilmPageSource() }.flow.cachedIn(viewModelScope)

  //  val repository = RetrofitRepository()
 //   val lifeDate: MutableLiveData<Response<ModelKinop>> = MutableLiveData()
  //  var list: MutableList<Response<ModelKinop>> = mutableListOf()



}
   class MainViewModelFactory(): ViewModelProvider.Factory{

       override fun <T : ViewModel> create(modelClass: Class<T>): T {
           if ( modelClass.isAssignableFrom(MainViewModel::class.java)){
               return MainViewModel() as T
           }
           throw IllegalArgumentException(" Error ViewModel")
       }
   }








