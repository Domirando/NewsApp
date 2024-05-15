package domirandos.app.myapplication.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import domirandos.app.myapplication.model.PostData
import domirandos.app.myapplication.networking.APIClient
import domirandos.app.myapplication.networking.APIService

class HomeViewModel(val model: HomeModel):ViewModel() {


    private var _posts:MutableStateFlow<PostData?> = MutableStateFlow(null)
    val posts:StateFlow<PostData?> = _posts


    private fun getAllPosts(){
        viewModelScope.launch {
            _posts.value = model.getAllPosts()
        }
    }
    fun searchProduct(name:String){
        viewModelScope.launch {
            _posts.value = model.searchPosts(name)
        }
    }
    fun getPost(id:Int){
        viewModelScope.launch {
            _posts.value = model.getPost(id)
        }
    }
    init{
        getAllPosts()
    }

}