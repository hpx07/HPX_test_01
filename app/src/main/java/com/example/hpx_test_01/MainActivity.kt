package com.example.hpx_test_01

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    
    private lateinit var webView: WebView
    private lateinit var reloadButton: ImageView
    
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        hideSystemUI()
        
        // Create container layout
        val container = FrameLayout(this)
        setContentView(container)
        
        // Create WebView
        webView = WebView(this)
        container.addView(webView, FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        ))
        
        // Create reload button
        reloadButton = ImageView(this).apply {
            setImageResource(android.R.drawable.ic_popup_sync)
            setBackgroundColor(Color.parseColor("#80000000"))
            setPadding(24, 24, 24, 24)
            setColorFilter(Color.WHITE)
            setOnClickListener {
                clearCacheAndReload()
            }
        }
        
        val buttonSize = 120
        val buttonParams = FrameLayout.LayoutParams(buttonSize, buttonSize).apply {
            gravity = Gravity.BOTTOM or Gravity.START
            setMargins(32, 32, 32, 32)
        }
        container.addView(reloadButton, buttonParams)
        
        // Configure WebView settings
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
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
    }
    
    private fun clearCacheAndReload() {
        // Animate the button
        val rotate = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 500
            repeatCount = 1
        }
        reloadButton.startAnimation(rotate)
        
        // Clear all caches
        webView.clearCache(true)
        webView.clearHistory()
        webView.clearFormData()
        
        // Reload with no cache
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.reload()
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
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
