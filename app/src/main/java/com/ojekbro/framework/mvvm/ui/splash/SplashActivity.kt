package com.ojekbro.framework.mvvm.ui.splash

import android.os.Bundle
import com.ojekbro.framework.mvvm.R
import com.ojekbro.framework.mvvm.core.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {
    private val splashViewModel by viewModel<SplashViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        observeChange()
    }

    override fun observeChange() {
//        splashViewModel.isLoged.observe(this, { success ->
//            if (success) {
//                openActivity(this, Intent(this, MainActivity::class.java))
//            } else {
//                Log.i("action", "login screen")
//                openActivity(this, Intent(this, LoginActivity::class.java))
//            }
//        })
    }
}