package com.demo.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.demo.entity.AccountEntity
import com.tutorial.database.AccountDB
import com.tutorial.databinding.ActivityLoginBinding
import com.tutorial.interfaces.ImlOnClick
import com.tutorial.repository.AccountRepository

class LoginController : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var email: String? = null
    var pass: String? = null
    val accRepository: AccountRepository by lazy {
        AccountRepository(
            AccountDB.getDatabase(this).accDao()
        )
    }
    val acc: AccountEntity by lazy {
        AccountEntity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setControl()
        binding.pbLoad.visibility = View.VISIBLE
        createAcc()
        if (!autoLogin()) {
            binding.pbLoad.visibility = View.GONE
            return
        }
        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
        AccountDB.getDatabase(this)
    }

    private fun autoLogin(): Boolean {
        lifecycleScope.launchWhenCreated {
            val acc: AccountEntity? =
                accRepository.getAccountByEmail(binding.txtEmailL.text.toString())
            if (binding.txtEmailL.text.toString() == acc?.email && binding.txtPasswordL.text.toString() == acc?.password){
                //startActivity(Intent(this@LoginController, HomeActivity::class.java))
                val intent = Intent(this@LoginController, HomeController::class.java)
                val bundle = Bundle()
                bundle.putParcelable("account", acc)
                //bundle.putParcelable("account",)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
        return false
    }

    private fun createAcc() {
        lifecycleScope.launchWhenCreated {
            accRepository.addAccount(AccountEntity("tam@gmail.com", "123", "Admin"))
        }
    }

    private fun setControl() {
        binding.setOnClick = object : ImlOnClick {
            override fun onClickBtnLogin(view: View) {
                try {
                    lifecycleScope.launchWhenCreated {
                        /*accRepository.getAllAccount.collect {
                            email = it[0].email
                            pass = it[0].password
                            binding.apply {
                                if (txtEmailL.text.toString() == email && txtPasswordL.text.toString() == pass) {
                                    Toast.makeText(this@LoginController, "Login success!", Toast.LENGTH_SHORT)
                                        .show()
                                    val intent = Intent(this@LoginController, HomeActivity::class.java)
                                    val bundle = Bundle()
                                    bundle.putParcelable("account",it[0])
                                    //bundle.putParcelable("account",)
                                    intent.putExtras(bundle)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(this@LoginController, "Login fail!", Toast.LENGTH_SHORT)
                                        .show()
                                    return@apply
                                }
                            }
                        }*/
                        val acc: AccountEntity? =
                            accRepository.getAccountByEmail(binding.txtEmailL.text.toString())
                        if (acc == null) {
                            Toast.makeText(this@LoginController, "Login fail", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(
                                this@LoginController,
                                "Login success!! \nEmail: ${acc?.email} \nRole: ${acc?.role}",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this@LoginController, HomeController::class.java)
                            val bundle = Bundle()
                            bundle.putParcelable("account", acc)
                            //bundle.putParcelable("account",)
                            intent.putExtras(bundle)
                            startActivity(intent)
                        }

                    }
                } catch (e: Exception) {
                    Toast.makeText(this@LoginController, "Error: ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            override fun onClickTvRegister(view: View) {
                createAcc()
            }

        }

    }
}