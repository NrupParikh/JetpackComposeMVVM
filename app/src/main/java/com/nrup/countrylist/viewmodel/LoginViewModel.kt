package com.nrup.countrylist.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nrup.countrylist.R
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


    fun setEmail(email: String, context: Context) {
        _email.value = email
//        validateEmail(email,context)
        validateForm(context, _email.value, _password.value)
    }

    fun setPassword(password: String, context: Context) {
        _password.value = password
//        validatePassword(password,context)
        validateForm(context, _email.value, _password.value)
    }

    fun setPasswordVisible(isVisible: Boolean) {
        _passwordVisible.value = isVisible
    }

    private fun setIsPasswordError(isError: Pair<Boolean, String>) {
        _isPasswordError.value = isError
    }

    private fun setIsEmailError(isError: Pair<Boolean, String>) {
        _isEmailError.value = isError
    }

    private fun setIsLoginEnabled(isEnabled: Boolean) {
        _isLoginEnabled.value = isEnabled
    }


    private fun validateForm(context: Context, email: String, password: String) {
        val isEmailValid = validateEmail(email, context)
        val isPasswordValid = validatePassword(password, context)
        if (isEmailValid && isPasswordValid) {
            Log.d("TAG", "Enable Login")
            setIsLoginEnabled(true)
        } else {
            setIsLoginEnabled(false)
        }
    }

    private fun validatePassword(value: String, context: Context): Boolean {
        when {
            value.isEmpty() -> {
                setIsPasswordError(Pair(true, context.getString(R.string.val_msg_enter_password)))
                return false
            }

            value.length <= 6 -> {
                setIsPasswordError(Pair(true, context.getString(R.string.val_msg_min_pass_length)))
                return false
            }

            value.length > 8 -> {
                setIsPasswordError(Pair(true, context.getString(R.string.val_msg_max_pass_length)))
                return false
            }

            !value.any { it.isUpperCase() } -> {
                setIsPasswordError(
                    Pair(
                        true,
                        context.getString(R.string.val_msg_upper_case_required)
                    )
                )
                return false
            }

            !value.any { it.isLowerCase() } -> {
                setIsPasswordError(
                    Pair(
                        true,
                        context.getString(R.string.val_msg_lower_case_required)
                    )
                )
                return false
            }

            !value.any { it.isDigit() } -> {
                setIsPasswordError(Pair(true, context.getString(R.string.val_msg_digit_required)))
                return false
            }

            !value.any { it == '@' } && !value.any { it == '$' } && !value.any { it == '_' } -> {
                setIsPasswordError(
                    Pair(
                        true,
                        context.getString(R.string.val_msg_special_char_required)
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

    private fun validateEmail(value: String, context: Context): Boolean {
        return when {
            value.isEmpty() -> {
                setIsEmailError(Pair(true, context.getString(R.string.val_msg_enter_email)))
                false
            }

            !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches() -> {
                setIsEmailError(Pair(true, context.getString(R.string.val_msg_enter_valid_email)))
                false
            }

            else -> {
                setIsEmailError(Pair(false, ""))
                true
            }
        }
    }
}