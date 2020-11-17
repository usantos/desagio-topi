package br.com.desafiotopi.interactor

import android.util.Log
import br.com.desafiotopi.interactor.interfaces.LoadItemsInteractor
import br.com.desafiotopi.response.GitRepositoryListResponse
import br.com.desafiotopi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadItemsInteractorImpl : LoadItemsInteractor {

    private val TAG = "LoadItemsInteractorImpl"

    override fun getRepositoryList(onFinishedListener: LoadItemsInteractor.OnFinishedListener, page: Int) {

        val call= ApiClient().apiService().getRepositoryList("language:kotlin", "stars", page)
        call.enqueue(object : Callback<GitRepositoryListResponse> {
            override fun onResponse(
                call: Call<GitRepositoryListResponse>,
                response: Response<GitRepositoryListResponse>
            ) {
                val reps = if (response.body() != null) response.body()!!.items else null
                Log.d(TAG, "Number of repository: " + reps!!.size)
                onFinishedListener.onFinished(reps)
            }

            override fun onFailure(call: Call<GitRepositoryListResponse>, t: Throwable) {
                Log.e(TAG, t.toString())
                onFinishedListener.onFailure(t)
            }
        })
    }
}
