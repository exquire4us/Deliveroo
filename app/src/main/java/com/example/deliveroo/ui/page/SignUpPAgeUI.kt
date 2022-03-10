package com.example.deliveroo.ui.page

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveroo.R
import com.example.deliveroo.model.StoreUserDetails
import com.example.deliveroo.model.User
import com.example.deliveroo.ui.theme.Red100
import com.example.deliveroo.ui.theme.Red500
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun SignUpForm(onSignUpClicked: ()->Unit = {}){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var fullName by rememberSaveable{ mutableStateOf("")}
    var emailID by rememberSaveable{ mutableStateOf("") }
    var password by rememberSaveable{ mutableStateOf("") }

    var isVisible by remember {mutableStateOf(false )}

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
    val signUpButtonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = colorResource(id = R.color.buttonColor)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Red100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.red_crab_seafood), contentDescription = null)
        TextFieldDetailsInput(
            modifier = Modifier,
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.person_icon), contentDescription = null , modifier = Modifier.size(20.dp))
            },
            style = style,
            data = fullName,
            colors = textFieldcolors,
            placeHolder = "Full Name",
            valueChange = {fullName = it }
        )
        TextFieldDetailsInput(
            modifier = Modifier.padding(16.dp),
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.person_icon), contentDescription = null , modifier = Modifier.size(20.dp))
            },
            style = style,
            data = emailID,
            colors = textFieldcolors,
            placeHolder = "Email Address",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done,
                autoCorrect = false
            ),
            valueChange = {emailID = it}
        )
        TextFieldDetailsInput(
            modifier = Modifier,
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.person_icon), contentDescription = null , modifier = Modifier.size(20.dp))
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
            trailingIcon = {
                val iconImage = if (isVisible)R.drawable.unseen else R.drawable.seen
                Icon(painter = painterResource(id = iconImage), contentDescription = null, modifier = Modifier.size(20.dp))
                IconButton({isVisible = !isVisible}) {

                }
            },
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
            valueChange = {password = it }
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlineButtonDetails(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = signUpButtonColors, buttonText = "Sign Up",
            borders = BorderStroke(2.dp, Red500),
            onButtonClick = {
                scope.launch {
                    saveDetails(context = context, name = fullName, email = emailID, password = password)
                }
                onSignUpClicked()
            }
        )

    }
}

suspend fun saveDetails (context: Context, name: String, email: String, password: String) {

    val dataStore = StoreUserDetails(context)

    val data = Json.encodeToString(User(name = name, password = password, email = email))

        dataStore.StoreUserData(data)



}
@Preview
@Composable
fun SignUpPreview(){
    SignUpForm()
}
