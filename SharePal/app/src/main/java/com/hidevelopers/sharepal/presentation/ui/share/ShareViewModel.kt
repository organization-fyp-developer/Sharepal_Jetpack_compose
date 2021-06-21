package com.hidevelopers.sharepal.presentation.ui.share//package com.hidevelopers.sharepal.presentation.ui.share
//
//import android.content.Context
//import androidx.compose.material.ScrollableTabRow
//import androidx.compose.runtime.Composable
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.hhdeveloper.sharingapplication.datasource.data.AppData
//import com.hidevelopers.sharepal.repository.ExternalStorageRepository
//import com.hidevelopers.sharepal.repository.data.AudioData
//import com.hidevelopers.sharepal.repository.data.ImageData
//import com.hidevelopers.sharepal.repository.data.VideoData
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//
//@HiltViewModel
//class ShareViewModel @Inject constructor(
//    private val repository: ExternalStorageRepository,
//    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
//):ViewModel() {
//    private val _getAllVideoList = MutableLiveData<List<VideoData>>()
//    val getAllVideoList: LiveData<List<VideoData>> = _getAllVideoList
//
//    private val _getAllAudioList = MutableLiveData<List<AudioData>>()
//    val getALlAudioList: LiveData<List<AudioData>> = _getAllAudioList
//
//    private val _getALlImageList = MutableLiveData<List<ImageData>>()
//    val getAllImageList: LiveData<List<ImageData>> = _getALlImageList
//
//    private val _getAllAppInstallList = MutableLiveData<List<AppData>>()
//    val getALlAppInstallList: LiveData<List<AppData>> = _getAllAppInstallList
//
//    private fun getAllVideoList(){
//        viewModelScope.launch(dispatcher) {
//            _getAllVideoList.postValue(repository.getVideosList())
//        }
//    }
//
//    private fun getImageList(){
//        viewModelScope.launch(dispatcher) {
//            _getALlImageList.postValue(repository.getImagesList())
//        }
//    }
//
//    private fun getAudioList(){
//        viewModelScope.launch(dispatcher) {
//            _getAllAudioList.postValue(repository.getAudiosList())
//        }
//    }
//
//    private fun getAppInstallList(){
//        viewModelScope.launch(dispatcher) {
//            _getAllAppInstallList.postValue(repository.getInstallApp())
//        }
//    }
//}
