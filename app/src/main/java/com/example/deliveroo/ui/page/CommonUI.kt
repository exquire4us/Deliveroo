package com.example.deliveroo.ui.page

import android.content.Context
import android.util.Size
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.deliveroo.R
import com.example.deliveroo.ui.theme.DeliverooTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
 fun TextFieldDetailsInput(
    modifier: Modifier,
    style: TextStyle,
    data: String,
    colors: TextFieldColors,
    placeHolder: String,
    valueChange: (String) -> Unit,
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    visualTransformation : VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable ()-> Unit  = {},
    leadingIcon: @Composable ()-> Unit = {},
) {
    TextField(
        singleLine = true,
        value = data,
        onValueChange = valueChange,
        textStyle = style,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(onDone  = {keyboardController?.hide()}),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        placeholder = { Text(text = placeHolder) },
        colors = colors,
        modifier = modifier
    )
}

@Composable
fun OutlineButtonDetails(
    modifier: Modifier = Modifier ,
    onButtonClick: () -> Unit = {},
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    buttonText: String = "Work",
    borders: BorderStroke? = null,
) {
    OutlinedButton(
        onClick = onButtonClick,
        border = borders,
        colors = colors,
        modifier = modifier

    ) {
        Text(
            text = buttonText.uppercase(),
            modifier = modifier.padding(horizontal = 100.dp, vertical = 10.dp)

        )
    }

}

@Composable
fun PromoImageShapeCard (
    modifier: Modifier = Modifier,
    shape : Shape = RoundedCornerShape(30.dp),
    painter : Painter = painterResource(id = R.drawable.crab_sticks)
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(BorderStroke(2.dp, Color(0xffe42021)), shape = shape)
            .padding(4.dp)
        ,
        shape = shape,
        elevation = 5.dp,

    ) {
        Box() {
            Image(painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(width = 150.dp, height = 180.dp)
                    .clip(shape)


            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopularAndNewCard(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.crab_sticks),
    shape : Shape = RoundedCornerShape(30.dp),
    foodName : String = "Tom Yam",
    price: String = "¢200",
    onCardClick: ()-> Unit = {}
){
    Card(
        onClick = onCardClick,
        modifier = modifier
            .padding(10.dp)
            .size(width = 200.dp, height = 150.dp),
        shape = shape,
        elevation = 5.dp
    ) {
        Box(modifier = modifier.height(300.dp)){
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .clip(shape)

            )
            Box(
                modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 50f
                        )
                    )
            )
            
            Box(modifier = modifier
                .fillMaxSize()
                .padding(12.dp)
            ) {
                Text(
                    text = foodName,
                    style = TextStyle(color = Color.White, fontSize = 15.sp, FontWeight.Bold),
                    modifier = modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                )

                Text(
                    text = price,
                    style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif ),
                    modifier = modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .background(Color(0xffe42021), shape = shape)
                        .padding(horizontal = 12.dp)
                )

               Icon(imageVector = Icons.Default.FavoriteBorder,
                   contentDescription = null,
                   tint = Color(0xffe42021),
                   modifier = modifier
                       .align(Alignment.TopEnd)
                       .padding(5.dp)
                       .size(25.dp)
               )
            }
        }
    }
}
@Composable
fun CategoriesButton(
    modifier: Modifier = Modifier,
    categoryName: String = "Work",

){
    OutlinedButton(onClick = {}, modifier = modifier, colors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color(0xffe42021),
        contentColor = Color.White
    ), shape = RoundedCornerShape(50.dp)) {
        Icon(imageVector = Icons.Default.Face, contentDescription = null, modifier = modifier.size(40.dp))
        Text(text = categoryName, fontWeight = FontWeight.Bold, fontSize = 24.sp,
        modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp))
    }
}

@Composable
fun TextHeadings(
    modifier:Modifier = Modifier,
    title: String = "New Item",
    textSize: TextUnit = 50.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    color : Color = Color(0xff333030)
){
    Text(modifier =modifier ,text = title, fontWeight = fontWeight, color = color, fontSize = textSize)
}



@Preview
@Composable
fun PreviewCategoryUi(){
    CategoriesButton()
}
@Preview
@Composable
fun PopularAndNewCardPreview(){
    PopularAndNewCard()
}


@Preview
@Composable
fun TextHeadingPreview(){
    TextHeadings()
}

@Preview
@Composable
fun PromoImage(){
    PromoImageShapeCard()
}
