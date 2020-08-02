package com.example.data.repository

import com.example.domain.repository.Repository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor() : Repository {
    override fun requestApi() {
        Timber.e("으이이잉???")
    }
}