package com.example.kino_temp

import android.content.Context
import android.net.http.HttpException
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kino_temp.models.Omdb_2.Responses
import com.example.kino_temp.models.Omdb_2.S
import com.example.kino_temp.models.Omdb_2.T
import com.example.kino_temp.models.kinopoisk.Doc
import com.example.kino_temp.models.kinopoisk.ModelKinop
import com.example.kino_temp.retrofit.r.api.ApiService
import com.example.kino_temp.retrofit.r.api.RetrofitRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Response

import retrofit2.http.Query

class FilmPageSource(): PagingSource<Int,Doc>() {



    override fun getRefreshKey(state: PagingState<Int, Doc>): Int? {

       val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
         return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Doc> {

        val page: Int = params.key ?: 1

               var response: Response<ModelKinop>? = null

              return try {  response = RetrofitRepository().getMoves(page)

                          LoadResult.Page(response.body()!!.docs,
                         prevKey = if (page == 1) null else page -1,
                         nextKey = if (response.isSuccessful) page +1 else null)



            } catch (e:Exception) {  LoadResult.Error(e); }











    }
}