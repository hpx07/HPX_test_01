package com.example.hpx_test_01

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    
    private lateinit var webView: WebView
    private lateinit var reloadButton: FloatingActionButton
    
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        hideSystemUI()
        
        // Set content view
        setContentView(R.layout.activity_main)
        
        // Initialize views
        webView = findViewById(R.id.webView)
        reloadButton = findViewById(R.id.reloadButton)
        
        // Configure WebView settings
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
            allowFileAccess = true
            allowContentAccess = true
            setSupportZoom(true)
            builtInZoomControls = false
            displayZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        
        // Set WebView clients
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        
        // Load portfolio from GitHub Pages (live updates)
        webView.loadUrl("https://hpx07.github.io/portfolio-v2/")
        
        // Setup reload button
        reloadButton.setOnClickListener {
            clearCacheAndReload()
        }
    }
    
    private fun clearCacheAndReload() {
        // Animate button rotation
        reloadButton.animate()
            .rotation(reloadButton.rotation + 360f)
            .setDuration(500)
            .start()
        
        // Clear all caches deeply
        webView.clearCache(true)
        webView.clearHistory()
        webView.clearFormData()
        
        // Clear cookies
        android.webkit.CookieManager.getInstance().apply {
            removeAllCookies(null)
            flush()
        }
        
        // Clear WebView storage
        webView.clearSslPreferences()
        android.webkit.WebStorage.getInstance().deleteAllData()
        
        // Reload the page
        webView.reload()
    }
    
    private fun hideSystemUI() {
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = 
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
    
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
    
    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}
