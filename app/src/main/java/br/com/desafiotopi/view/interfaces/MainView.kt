package br.com.desafiotopi.view.interfaces


import br.com.desafiotopi.request.GitRepository

interface MainView {

    fun showProgress()

    fun hideProgress()

    fun populateRecyclerGitRepo(items: List<GitRepository>)

    fun showMessage(message: String)
}
