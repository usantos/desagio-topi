package br.com.desafiotopi.interactor.interfaces;

import br.com.desafiotopi.request.GitRepository;

import java.util.List;

public interface LoadItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<GitRepository> eventArrayList);
        void onFailure(Throwable t);
    }

    void getRepositoryList(OnFinishedListener onFinishedListener, int page);
}
