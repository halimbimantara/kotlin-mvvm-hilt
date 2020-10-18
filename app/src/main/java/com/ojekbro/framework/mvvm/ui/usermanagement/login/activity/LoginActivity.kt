package com.ojekbro.framework.mvvm.ui.usermanagement.login.activity

import android.os.Bundle
import com.ojekbro.framework.mvvm.R
import com.ojekbro.framework.mvvm.core.BaseActivity
import com.ojekbro.framework.mvvm.ui.usermanagement.login.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {
    private val loginViewModel by viewModel<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        observeChange()
    }

    override fun observeChange() {

    }
}