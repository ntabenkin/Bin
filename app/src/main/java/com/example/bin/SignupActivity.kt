import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.bin.LoginActivity
import com.example.bin.MainActivity
import com.example.bin.databinding.SignupActivityBinding
import com.example.bin.tools.showToast

class SignupActivity : AppCompatActivity() {

    lateinit var binding: SignupActivityBinding

    val MIN_PASSWORD_LENGTH = 6;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewInitializations()
    }

    fun viewInitializations() {
        binding.etFirstName.isVisible = true

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (binding.etFirstName.text.toString().equals("")) {
            binding.etFirstName.setError("Please Enter First Name")
            return false
        }
        if (binding.etLastName.text.toString().equals("")) {
            binding.etLastName.setError("Please Enter Last Name")
            return false
        }
        if (binding.etEmail.text.toString().equals("")) {
            binding.etEmail.setError("Please Enter Email")
            return false
        }
        if (binding.etPassword.text.toString().equals("")) {
            binding.etPassword.setError("Please Enter Password")
            return false
        }
        if (binding.etRepeatPassword.text.toString().equals("")) {
            binding.etRepeatPassword.setError("Please Enter Repeat Password")
            return false
        }

        // checking the proper email format
        if (!isEmailValid(binding.etEmail.text.toString())) {
            binding.etEmail.setError("Please Enter Valid Email")
            return false
        }

        // checking minimum password Length
        if (binding.etPassword.text.length < MIN_PASSWORD_LENGTH) {
            binding.etPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters")
            return false
        }

        // Checking if repeat password is same
        if (!binding.etPassword.text.toString().equals(binding.etRepeatPassword.text.toString())) {
            binding.etRepeatPassword.setError("Password does not match")
            return false
        }
        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event
    data class User(
        val email: String,
        val password: String
    )
    fun performSighnup(fName: String, lName: String, email: String, password: String, repeatPassword: String){
        this.showToast(text = "fName")

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
    fun performSignUp(view: View) {
        val user = User(binding.etEmail.text.toString(), binding.etPassword.text.toString())

        if (validateInput()) {
            // Input is valid, here send data to your server
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val repeatPassword = binding.etRepeatPassword.text.toString()
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            performSighnup(firstName,lastName,email,password,repeatPassword)
        }
    }

}