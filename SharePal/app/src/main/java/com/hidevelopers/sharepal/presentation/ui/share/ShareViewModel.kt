package com.hidevelopers.sharepal.presentation.ui.share


import android.app.Application
import androidx.lifecycle.*
import com.hidevelopers.sharepal.repository.StorageRepo
import com.hidevelopers.sharepal.repository.data.AudioData
import com.hidevelopers.sharepal.repository.data.ImageData
import com.hidevelopers.sharepal.repository.data.VideoData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class ShareViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: StorageRepo = StorageRepo(application)
    private var dispatcher: CoroutineDispatcher = Dispatchers.Main
    private val _getAllVideoList = MutableLiveData<List<VideoData>>()
    val getAllVideoList: LiveData<List<VideoData>> = getVideoList()

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name
//
//    private val _getAllAudioList = MutableLiveData<List<AudioData>>()
//    val getALlAudioList: LiveData<List<AudioData>> = _getAllAudioList
//
//    private val _getALlImageList = MutableLiveData<List<ImageData>>()
//    val getAllImageList: LiveData<List<ImageData>> = _getALlImageList
    //private val videoLiveDataList:MutableLiveData<List<VideoData>> =MutableLiveData()
    private val imageLiveDataList:MutableLiveData<List<ImageData>> = MutableLiveData()
    private val audioLiveDataList:MutableLiveData<List<AudioData>> = MutableLiveData()

//    private val _getAllAppInstallList = MutableLiveData<List<AppData>>()
//    val getALlAppInstallList: LiveData<List<AppData>> = _getAllAppInstallList

    private fun getVideoList():MutableLiveData<List<VideoData>> {
        getAllVideoList()
        return _getAllVideoList
    }

    private fun getAllVideoList(){
        viewModelScope.launch(dispatcher) {
            Timber.i("repository ${repository.getVideosList()}")
            _getAllVideoList.postValue(
                withContext(Dispatchers.IO){
                    repository.getVideosList()
                }
            )
        }
    }
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

//    private fun getAppInstallList(){
//        viewModelScope.launch(dispatcher) {
//            _getAllAppInstallList.postValue(repository.getInstallApp())
//        }
//    }
}
