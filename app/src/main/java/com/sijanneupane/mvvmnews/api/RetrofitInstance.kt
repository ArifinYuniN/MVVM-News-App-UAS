package com.sijanneupane.mvvmnews.api

import com.sijanneupane.mvvmnews.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val  retrofit by lazy {
            //malas berarti kita hanya menginisialisasi ini di sini sekali

            val logging= HttpLoggingInterceptor()
            /* dependensi HTTP LOGGING INTERCEPTOR ini dapat mencatat respons retrofit,
               ini akan berguna dalam debug kode  */
            //menempel pada objek retrofit
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            //klien jaringan
            val client= OkHttpClient.Builder().addInterceptor(logging).build()

            //meneruskan klien ke instance retrofit
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
            /* digunakan untuk menentukan bagaimana respons harus ditafsirkan dan dikonversi
            ke objek kotlin */
                .client(client)
                .build()


        }

        // ini dapat digunakan dari mana saja untuk membuat permintaan jaringan
        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}