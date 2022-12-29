package com.sijanneupane.mvvmnews.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.sijanneupane.mvvmnews.R
import com.sijanneupane.mvvmnews.ui.MainActivity
import com.sijanneupane.mvvmnews.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article){
    lateinit var viewModel: NewsViewModel
    //get articles as global element
    private val args: ArticleFragmentArgs by navArgs()
    //ArticleFragmentArgs dihasilkan oleh komponen navigasi saat menambahkan args

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= (activity as MainActivity).viewModel


        val article = args.article
        webView.apply {
            webViewClient= WebViewClient()
            loadUrl(article.url.toString())
        }

        //untuk menyimpan artikel
        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view, " Article Saved Successfully! ", Snackbar.LENGTH_SHORT).show()
        }


    }
}