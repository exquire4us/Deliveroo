package com.example.deliveroo.ui.page

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliveroo.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.deliveroo.model.StoreUserDetails
import com.example.deliveroo.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


@Composable
fun LoginForm(
    onSignUpClick: () -> Unit = {},
    onLoginClick: ()->Unit = {}
) {
    val context = LocalContext.current
    val dataStore = StoreUserDetails(context)
    var isVisible by remember { mutableStateOf(false) }

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val style = TextStyle(
        fontSize = 24.sp,
        color = colorResource(id = R.color.iconColor),
        fontWeight = FontWeight.Bold
    )
    val textFieldcolors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = colorResource(id = R.color.unfocusedIndicatorColor),
        focusedIndicatorColor = colorResource(id = R.color.unfocusedIndicatorColor),
        leadingIconColor = colorResource(id = R.color.iconColor),
        trailingIconColor = colorResource(id = R.color.iconColor),
        placeholderColor = colorResource(id = R.color.iconColor),
        backgroundColor = Color.Transparent
    )
    val loginButtonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = colorResource(id = R.color.buttonColor),
        contentColor = colorResource(id = R.color.backgroundColor)
    )
    val signUpButtonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = colorResource(id = R.color.buttonColor)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.red_crabs_seafood_logo),
            contentDescription = null,

            )
        TextFieldDetailsInput(
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.person_icon), contentDescription = null , modifier = Modifier.size(20.dp))
            },
            style = style,
            data = username,
            colors = textFieldcolors,
            placeHolder = "Username",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done,
                autoCorrect = false
            ),
            valueChange = { username = it },
            modifier = Modifier
        )

        TextFieldDetailsInput(
            modifier = Modifier.padding(16.dp),
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_password), contentDescription = null , modifier = Modifier.size(20.dp))
            },
            style = style,
            data = password,
            colors = textFieldcolors,
            placeHolder = "Password",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                autoCorrect = false
            ),
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val iconImage = if (isVisible) R.drawable.unseen else R.drawable.seen
                Icon(painter = painterResource(id = iconImage), contentDescription = "" , modifier = Modifier.size(20.dp))
                IconButton({isVisible = !isVisible}) {
                }

            },
            valueChange = { password = it }
        )
        OutlineButtonDetails(
            modifier = Modifier,
            colors = loginButtonColors,
            buttonText = "Login",
            onButtonClick = onLoginClick
        )

        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {

            Divider(
                color = colorResource(id = R.color.dividerColor),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .align(Alignment.CenterVertically),
                startIndent = 5.dp,
            )

            Text(
                text = "OR",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.Bottom),
                color = colorResource(id = R.color.buttonColor)
            )

            Divider(
                color = colorResource(id = R.color.dividerColor),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterVertically),
                startIndent = 5.dp,
            )
        }

       OutlineButtonDetails(
           modifier = Modifier,
           colors = signUpButtonColors,
           buttonText = "Sign Up",
           borders = BorderStroke(2.dp, colorResource(id = R.color.buttonColor)),
            onButtonClick = onSignUpClick
           )

    }
}




@Preview
@Composable
fun Preview() {
    LoginForm()

}