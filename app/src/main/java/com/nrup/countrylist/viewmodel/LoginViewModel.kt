package com.nrup.countrylist.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nrup.countrylist.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val countryRepository: CountryRepository,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _email = mutableStateOf("")
    var email: State<String> = _email

    private val _password = mutableStateOf("")
    var password: State<String> = _password

    private val _passwordVisible = mutableStateOf(false)
    var passwordVisible: State<Boolean> = _passwordVisible

    private val _isLoginEnabled = mutableStateOf(false)
    var isLoginEnabled: State<Boolean> = _isLoginEnabled

    private val _isPasswordError = mutableStateOf(Pair(false, ""))
    val isPasswordError: State<Pair<Boolean, String>> = _isPasswordError

    private val _isEmailError = mutableStateOf(Pair(false, ""))
    val isEmailError: State<Pair<Boolean, String>> = _isEmailError

    fun setEmail(email: String) {
        _email.value = email
        validateEmail(email)
    }

    fun setPassword(password: String) {
        _password.value = password
        validatePassword(password)
    }

    fun setPasswordVisible(isEnabled: Boolean) {
        _passwordVisible.value = isEnabled
    }

    private fun setIsPasswordError(isError: Pair<Boolean, String>) {
        _isPasswordError.value = isError
    }

    private fun setIsEmailError(isError: Pair<Boolean, String>) {
        _isEmailError.value = isError
    }


    private fun validateForm() {
        val isEmailValid = validateEmail(email.value)
        val isPasswordValid = validatePassword(password.value)
    }

    private fun validatePassword(value: String): Boolean {
        when {
            value.isEmpty() -> {
                setIsPasswordError(Pair(true, "Please enter password"))
                return false
            }

            value.length <= 6 -> {
                setIsPasswordError(Pair(true, "Password must be 6 character long"))
                return false
            }

            value.length > 8 -> {
                setIsPasswordError(Pair(true, "Password must be less than 8 character long"))
                return false
            }

            !value.any { it.isUpperCase() } -> {
                setIsPasswordError(
                    Pair(
                        true,
                        "Password must contains at least one uppercase letter"
                    )
                )
                return false
            }

            !value.any { it.isLowerCase() } -> {
                setIsPasswordError(Pair(true, "Password must contains at least one lower letter"))
                return false
            }

            !value.any { it.isDigit() } -> {
                setIsPasswordError(Pair(true, "Password must contains at least one digit"))
                return false
            }

            !value.any { it == '@' } && !value.any { it == '$' } && !value.any { it == '_' } -> {
                setIsPasswordError(
                    Pair(
                        true,
                        "Password must contains special character from [@,$,_]"
                    )
                )
                return false
            }

            else -> {
                setIsPasswordError(Pair(false, ""))
                return true
            }
        }
    }

    private fun validateEmail(value: String): Boolean {
        return when {
            value.isEmpty() -> {
                setIsEmailError(Pair(true, "Please enter email"))
                false
            }

            !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches() -> {
                setIsEmailError(Pair(true, "Please enter valid email"))
                false
            }

            else -> {
                setIsEmailError(Pair(false, ""))
                true
            }
        }
    }
}