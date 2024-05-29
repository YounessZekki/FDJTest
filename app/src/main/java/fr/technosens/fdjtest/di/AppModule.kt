package fr.technosens.fdjtest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.technosens.fdjtest.data.api.ApiService
import fr.technosens.fdjtest.data.repository.LeagueRepositoryImpl
import fr.technosens.fdjtest.domain.repository.LeagueRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL: String = "https://www.thesportsdb.com/api/v1/json/50130162/"

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLeagueRepository(apiService: ApiService): LeagueRepository {
        return LeagueRepositoryImpl(apiService)
    }
}
