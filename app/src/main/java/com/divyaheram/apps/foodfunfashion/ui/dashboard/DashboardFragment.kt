package com.divyaheram.apps.foodfunfashion.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.divyaheram.apps.foodfunfashion.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })

        val videoView = root.findViewById<WebView>(R.id.video)
        videoView.settings.also {
            it.builtInZoomControls = true
            it.javaScriptEnabled = true
            it.domStorageEnabled = true
        }
        videoView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(v: WebView, handler: SslErrorHandler, er: SslError) {
                handler.proceed()
            }
        }

        videoView.webChromeClient = WebChromeClient()

//        videoView.loadUrl("https://www.google.com/")
        videoView.loadUrl("https://www.youtube.com/")
//        videoView.loadUrl("https://www.youtube.com/watch?v=FTS_p6bA2qs")

        val nextVideo = root.findViewById<Button>(R.id.nextVideo)
        nextVideo.text = "Next"
        nextVideo.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/embed/FTS_p6bA2qs?fs=1")))
        }

        return root
    }
}