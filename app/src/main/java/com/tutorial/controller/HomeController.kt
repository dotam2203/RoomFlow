package com.demo.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.entity.AccountEntity
import com.tutorial.databinding.ActivityHomeBinding

class HomeController : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    val account by lazy {  AccountEntity() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFromLogin()
    }
    private fun getDataFromLogin() {
        val bundle = intent.extras
        val acc = bundle?.getParcelable<AccountEntity>("account")
        binding.tvNameLogin.text = acc?.role.toString()

    }
}