package com.sijanneupane.mvvmnews.repository

import com.sijanneupane.mvvmnews.api.RetrofitInstance
import com.sijanneupane.mvvmnews.db.ArticleDatabase
import com.sijanneupane.mvvmnews.models.Article

/* dapatkan data dari database dan dari sumber data jarak jauh (retrofit api) */
class NewsRepository(
    val db: ArticleDatabase //parameter
) {

    /* fungsi yang secara langsung menanyakan api untuk berita terkini */
    suspend fun getBreakingNews(countryCode:String, pageNumber:Int)=
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    /* fungsi yang meminta api untuk mencari berita  */
    suspend fun searchNews(searchQuery: String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    /* berfungsi untuk menyisipkan artikel ke db */
    suspend fun upsert(article: Article)=
        db.getArticleDao().upsert(article)

    /* berfungsi untuk mendapatkan berita tersimpan dari db */
    fun getSavedNews()=
        db.getArticleDao().getAllArticles()

    /* berfungsi untuk menghapus artikel dari db */
    suspend fun deleteArticle(article: Article)=
        db.getArticleDao().deleteArticle(article)
}