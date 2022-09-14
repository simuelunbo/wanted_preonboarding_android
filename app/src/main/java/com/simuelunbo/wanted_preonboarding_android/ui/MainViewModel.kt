package com.simuelunbo.wanted_preonboarding_android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.News
import com.example.domain.usecase.*
import com.simuelunbo.wanted_preonboarding_android.Event
import com.simuelunbo.wanted_preonboarding_android.util.toTimeElapsed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val deleteLikeNewsUseCase: DeleteLikeNewsUseCase,
    private val getCategoryNewsUseCase: GetCategoryNewsUseCase,
    private val getCheckLocalNewsUseCase: GetCheckLocalNewsUseCase,
    private val getHeadLineNewsUseCase: GetHeadLineNewsUseCase,
    private val getLocalNewsUseCase: GetLocalNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase
) : ViewModel() {

    init {
        fetchTopNews()
    }

    private val _toolbarTitle = MutableLiveData<String>()
    val toolbarTitle: LiveData<String> = _toolbarTitle

    private val _topNews = MutableLiveData<List<News>>(emptyList())
    val topNews: LiveData<List<News>> = _topNews

    private val _category = MutableLiveData<String>()
    val category: LiveData<String> = _category

    private val _categoryNews = MutableLiveData<List<News>>(emptyList())
    val categoryNews: LiveData<List<News>> = _categoryNews

    private val _savedNews = MutableLiveData<List<News>?>(emptyList())
    val savedNews: LiveData<List<News>?> = _savedNews

    private val _showToast = MutableLiveData<Event<String?>>()
    val showToast: LiveData<Event<String?>> = _showToast

    private val _detailNews = MutableLiveData<News>()
    val detailNews : LiveData<News> = _detailNews

    private val _detailTitle = MutableLiveData<String>()
    val detailTitle: LiveData<String> = _detailTitle

    private val _detailAuthor = MutableLiveData<String>()
    val detailAuthor: LiveData<String> = _detailAuthor

    private val _detailElapsed = MutableLiveData<String>()
    val detailElapsed: LiveData<String> = _detailElapsed

    private val _detailThumbNail = MutableLiveData<String>()
    val detailThumbNail: LiveData<String> = _detailThumbNail

    private val _detailContent = MutableLiveData<String>()
    val detailContent: LiveData<String> = _detailContent

    private val _isStar = MutableLiveData<Boolean>(false)
    val isStar: LiveData<Boolean> = _isStar

    fun checkIsSaved() = viewModelScope.launch {
        _isStar.value = getCheckLocalNewsUseCase(_detailTitle.value ?: "")?: false
    }


    fun updateToolbar(title: String) {
        _toolbarTitle.value = title
    }

    fun setCategory(category: String) {
        _category.value = category
        fetchCategoryNews()
    }

    fun getSavedNews() {
        viewModelScope.launch {
            _savedNews.value = getLocalNewsUseCase()
        }
    }

    fun updateSavedState() {
        when (_isStar.value) {
            true -> {
                deleteSaved()
                _isStar.value = false
            }
            else -> {
                saveNews(_detailNews.value)
                _isStar.value = true
            }
        }
    }

    private fun deleteSaved() = viewModelScope.launch {
        if(_detailNews.value != null) deleteLikeNewsUseCase(_detailNews.value!!)
    }

    private fun saveNews(news: News?) {
        viewModelScope.launch {
            if(news != null) saveNewsUseCase(news)
        }
    }


    fun setDetailNews(news: News) {
        _detailNews.value = news
        _detailTitle.value = news.title
        _detailAuthor.value = news.author
        _detailThumbNail.value = news.urlToImage
        _detailElapsed.value = news.publishedAt.toTimeElapsed()
        _detailContent.value = news.content
    }

    private fun fetchTopNews() = viewModelScope.launch {
        getHeadLineNewsUseCase().onSuccess {
            _topNews.value = it
        }.onFailure { exception ->
            _showToast.value = Event(exception.message)
        }
    }

    private fun fetchCategoryNews() = viewModelScope.launch {
        getCategoryNewsUseCase(category = _category.value ?: "").onSuccess {
            _categoryNews.value = it
        }.onFailure { exception ->
            _showToast.value = Event(exception.message)
        }
    }

}