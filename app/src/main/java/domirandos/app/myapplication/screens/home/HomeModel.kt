package domirandos.app.myapplication.screens.home

import domirandos.app.myapplication.model.Post
import domirandos.app.myapplication.model.PostData
import domirandos.app.myapplication.networking.APIService

class HomeModel(private val api:APIService) {

    suspend fun getAllPosts():PostData{
        return api.getPosts()
    }

    suspend fun getPost(postId:Int):PostData{
        return api.getPost(postId)
    }
    suspend fun searchPosts(postName:String): PostData{
        return api.searchByName(postName)
    }
}