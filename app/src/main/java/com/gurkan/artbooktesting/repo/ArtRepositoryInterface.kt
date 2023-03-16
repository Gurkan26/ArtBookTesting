package com.gurkan.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.gurkan.artbooktesting.model.ImageResponse
import com.gurkan.artbooktesting.roomdb.Art
import com.gurkan.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun searchImage(imageString: String): Resource<ImageResponse>



}