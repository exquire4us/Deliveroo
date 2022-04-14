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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    shape : Shape = RoundedCornerShape(15.dp),
    painter : Painter = painterResource(id = R.drawable.crab_sticks),
    cardWidth : Dp = 150.dp,
    cardHeight : Dp = 180.dp
){
    Card(
        modifier = modifier
            .width(cardWidth)
            .height(cardHeight)
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
    shape : Shape = RoundedCornerShape(15.dp),
    foodName : String = "Tom Yam",
    price: String = "¢200",
    cardHeight  : Dp = 150.dp,
    cardWidth : Dp = 200.dp,
    onCardClick: ()-> Unit = {}
){
    Card(
        onClick = onCardClick,
        modifier = modifier
            .padding(10.dp)
            .size(cardWidth, cardHeight),
        shape = shape,
        elevation = 5.dp
    ) {
        Box(modifier = modifier.fillMaxHeight()){
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
                    style = TextStyle(color = Color.White, fontSize = 10.sp, FontWeight.Bold),
                    modifier = modifier
                        .align(Alignment.BottomStart)
                )

                Text(
                    text = price,
                    style = TextStyle(color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif ),
                    modifier = modifier
                        .align(Alignment.BottomEnd)
                        .background(Color(0xffe42021), shape = shape)
                        .padding(horizontal = 5.dp)
                )

               Icon(imageVector = Icons.Default.FavoriteBorder,
                   contentDescription = null,
                   tint = Color(0xffe42021),
                   modifier = modifier
                       .align(Alignment.TopEnd)
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
    colors : ButtonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color.LightGray,
        contentColor = Color.White
    ),
    icon: Painter = painterResource(id = R.drawable.ic_find_us),
    onButtonClick : ()-> Unit = {}
//0xffe42021

){
    OutlinedButton(onClick = onButtonClick, modifier = modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .padding(end = 10.dp),colors = colors, shape = RoundedCornerShape(50.dp)) {
        Icon(painter  = icon, contentDescription = null, modifier = modifier.size(40.dp))
        Text(text = categoryName, textAlign = TextAlign.Justify,fontWeight = FontWeight.Bold, fontSize = 10.sp,
        modifier =Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoriesCard(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.crab_sticks),
    shape : Shape = RoundedCornerShape(15.dp),
    foodName : String = "Wasabi Shrimps",
    price: String = "¢200",
    cardHeight  : Dp = 150.dp,
    icon: @Composable ()-> Unit  = {},
    onCardClick: ()-> Unit = {}

){
    Card(
        onClick = onCardClick,
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight)
        ,
        shape = shape,
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.background(color = colorResource(id = R.color.backgroundColor))
        ){
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(topEnd = 0.dp, bottomEnd = 0.dp))
                )
                Box(modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()){
                    Column() {
                        TextHeadings(
                            modifier= Modifier
                                .padding(5.dp),
                            textSize = 15.sp,
                            title = foodName
                        )

                        Text(text = "Shrimp in crispy butter, spicy and sweet Wasabi sauce, daikon," +
                                "Pai potatoes , flying fish roe , Kimchi sesame",
                            fontSize = 10.sp, color = Color.DarkGray,
                            modifier = modifier.padding(5.dp)
                        )
                    }

                    Icon(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color(0xffe42021),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 20.dp, bottom = 5.dp)
                            .size(25.dp)
                    )

                    Text(
                        text = price,
                        style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif ),
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 8.dp, bottom = 8.dp)
                            .background(Color(0xffe42021), shape = shape)
                            .padding(horizontal = 12.dp)
                    )


                }

            }


        }
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

@Preview
@Composable
fun CategoriesPreview (){
    CategoriesCard()
}
