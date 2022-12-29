package com.sijanneupane.mvvmnews.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/* Di sini artikel akan menjadi seluruh tabel dan dengan kolom */
@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true) //menambahkan id sebagai kunci utama ke tabel dan kelas
    var id: Int?= null, //tidak semua artikel memiliki ID, jadi setel ke null
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable
//serialisasi untuk mengirim seluruh kelas dengan bundel