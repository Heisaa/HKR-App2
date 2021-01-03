package com.example.hkr_app2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.fragment.app.commit
import com.example.hkr_app2.R
import com.example.hkr_app2.webAddress

class WebFragment : Fragment(R.layout.fragment_web) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerRight, ContactFragment())
            }
        }


        val view = inflater.inflate(R.layout.fragment_web, container, false)

        val webView = view.findViewById<WebView>(R.id.webView)
        webView.loadUrl(webAddress.address)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        return view
    }

}