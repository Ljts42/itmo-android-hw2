package com.github.ljts42.hw2_simple_xml

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.ljts42.hw2_simple_xml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInButton.setOnClickListener {
            if (binding.editTextEmail.text.isEmpty()) {
                binding.textViewErrorMassage.text = resources.getString(R.string.error_msg_empty_email)
            } else if (binding.editTextPassword.text.isEmpty()) {
                binding.textViewErrorMassage.text = resources.getString(R.string.error_msg_empty_password)
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.editTextEmail.text).matches()) {
                binding.textViewErrorMassage.text = resources.getString(R.string.error_msg_email_format)
            } else {
                binding.textViewErrorMassage.text = resources.getString(R.string.error_msg_login_or_password)
            }
            binding.textViewErrorMassage.visibility = View.VISIBLE
        }

        binding.passwordShowButton.setOnClickListener {
            binding.passwordShowButton.visibility = View.GONE
            binding.passwordHideButton.visibility = View.VISIBLE
            binding.editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }

        binding.passwordHideButton.setOnClickListener {
            binding.passwordShowButton.visibility = View.VISIBLE
            binding.passwordHideButton.visibility = View.GONE
            binding.editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}
