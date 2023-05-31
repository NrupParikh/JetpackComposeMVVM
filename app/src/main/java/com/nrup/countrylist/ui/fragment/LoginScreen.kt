package com.nrup.countrylist.ui.fragment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = loginViewModel.email.value,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            supportingText = {
                if (loginViewModel.isEmailError.value.first) {
                    Text(
                        text = loginViewModel.isEmailError.value.second,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        ),
                        maxLines = 2,
                        softWrap = true
                    )
                }
            },
            onValueChange = {
                loginViewModel.setEmail(it)
            },
            label = { Text(text = "Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = loginViewModel.password.value,
            singleLine = true,
            isError = loginViewModel.isPasswordError.value.first,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (loginViewModel.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            supportingText = {
                if (loginViewModel.isPasswordError.value.first) {
                    Text(
                        text = loginViewModel.isPasswordError.value.second,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        ),
                        maxLines = 2,
                        softWrap = true
                    )
                }
            },
            onValueChange = {
                loginViewModel.setPassword(it)
            },
            label = { Text(text = "Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "",
                )
            },
            trailingIcon = {
                val image =
                    if (loginViewModel.passwordVisible.value)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description =
                    if (loginViewModel.passwordVisible.value) "Hide password" else "Show password"

                IconButton(
                    onClick = {
                        if (loginViewModel.passwordVisible.value) {
                            loginViewModel.setPasswordVisible(false)
                        } else {
                            loginViewModel.setPasswordVisible(true)
                        }
                    }
                ) {
                    Icon(imageVector = image, description)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (loginViewModel.isLoginEnabled.value) {
                    onClick()
                }
            },
            enabled = loginViewModel.isLoginEnabled.value
        ) {
            Text(text = "Login")
        }


    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Text(
//            text = "Login",
//            modifier = Modifier.clickable { onClick() },
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Text(
//            text = "Sign Up",
//            modifier = Modifier.clickable { onSignUpClick() },
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Text(
//            text = "Forgot Password",
//            modifier = Modifier.clickable { onForgotClick() },
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
}

@Composable
@Preview(showBackground = true)
fun LightPreviewLoginScreen() {
    LoginScreen(onClick = { }, onSignUpClick = { }, onForgotClick = {})
}