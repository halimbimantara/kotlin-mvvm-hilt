package com.ojekbro.framework.mvvm.core

import android.Manifest
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.ojekbro.framework.mvvm.R
import com.ojekbro.framework.mvvm.utils.ERROR_MESSAGE
import com.ojekbro.framework.mvvm.widget.TopSnackbar
import io.github.inflationx.viewpump.ViewPumpContextWrapper

/**
 * rizmaulana 2020-02-24.
 */
abstract class BaseActivity : AppCompatActivity() {

    private val progressDialog by lazy {
        ProgressDialog(this)
    }

    private val permissionsList = listOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeStatusBarWhite()
        observeChange()
    }

    fun loading(loaded: Boolean) {
        if (loaded) showProgress() else hideProgress()
    }

    fun showProgress() {
        with(progressDialog) {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setContentView(R.layout.layout_progress_dialog)
            isIndeterminate = true
            setCancelable(false)
            setCanceledOnTouchOutside(false)
            show()
        }
    }

    fun hideProgress() {
        progressDialog?.dismiss()
    }

    //set dulu content

    fun showSnackbarMessage(message: String?) {
        message?.let {
            val container = try {
                findViewById<CoordinatorLayout>(R.id.layout_content)
            } catch (e: Exception) {
                window.decorView.rootView
            }
            showTopSnackbar(container, it, R.color.orange_yellow)
        }
    }

    fun showSnackbarError(message: String?) {
        message?.let {
            val container = findViewById<CoordinatorLayout>(R.id.layout_content)
            if (container != null) {
                showTopSnackbar(container, it, R.color.red)
            } else {
                showTopSnackbar(window.decorView.rootView, it, R.color.red)
            }
        }
    }

    fun onUnexpectedError() {
        hideProgress()
        showSnackbarError(getString(R.string.msg_unexpected_error))
    }

    fun tokenRefresh() {

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun showTopSnackbar(root: View, message: String, @ColorRes color: Int) {
        val topSnackbar = TopSnackbar.make(root, message, TopSnackbar.LENGTH_LONG)
        val snackbarView = topSnackbar.getView()
        snackbarView.setBackgroundColor(ContextCompat.getColor(this, color))
        val textView = snackbarView.findViewById(R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        topSnackbar.show()
    }

    fun hideSoftKeyboard() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        val view = this.currentFocus
        if (view != null) {
            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    open fun changeStatusBarWhite() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        }
    }

    protected open fun permission(invoke: () -> Unit) {
        runtimePermission(permissionsList, invoke)
    }

    private fun runtimePermission(permissions: List<String>, action: () -> Unit) {
        Dexter.withActivity(this).withPermissions(permissions)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    report?.let {
                        if (it.deniedPermissionResponses.size > 0) {
                            runtimePermission(
                                it.deniedPermissionResponses.map { p -> p.permissionName },
                                action
                            )
                        } else {
                            action.invoke()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            })
            .withErrorListener {
                showSnackbarError(ERROR_MESSAGE)
            }
            .check()
    }

    open fun setupActionBarWithBackButton(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        toolbar.setTitleTextAppearance(this, R.style.TextAppearance_App_TextView_Toolbar)
    }

    abstract fun observeChange()

}