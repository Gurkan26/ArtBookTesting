package com.gurkan.artbooktesting.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.gurkan.artbooktesting.api.RetrofitAPI
import com.gurkan.artbooktesting.roomdb.ArtDatabase
import com.gurkan.artbooktesting.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        ArtDatabase::class.java,
        "ArtBookDb"
    ).build()


    @Singleton
    @Provides
    fun injectDAO(database: ArtDatabase) = database.artDao()


    @Singleton
    @Provides
    fun injectRetrofitAPI(): RetrofitAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitAPI::class.java)
    }


}