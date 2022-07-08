package com.demo.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tutorial.database.AccountDB
import com.tutorial.databinding.ActivityRegisterBinding
import com.tutorial.repository.AccountRepository

class RegisterController : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    val accRepository: AccountRepository by lazy { AccountRepository(AccountDB.getDatabase(this).accDao()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setControl()
    }

    fun setControl() {
        binding.apply {
            btnRegister.setOnClickListener {
                startActivity(Intent(this@RegisterController, LoginController::class.java))
                /*lifecycleScope.launchWhenCreated {
                    try {
                      accRepository.readAllAccount.collect { list ->
                          Toast.makeText(this@RegisterController,"Email: ${list[0].email}", Toast.LENGTH_LONG).show()
                      }

                    } catch (e: Exception){
                        Log.d("ABC", "setControl: ${e.message}")
                    }
                    
                }*/

            }
            tvLogin.setOnClickListener {
                finish();
            }
        }
    }
}