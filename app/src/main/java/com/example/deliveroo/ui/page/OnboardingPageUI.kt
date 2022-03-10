package com.example.deliveroo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.deliveroo.model.Page
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.deliveroo.model.onboardPages
import com.example.deliveroo.ui.page.LoginForm
import com.example.deliveroo.ui.theme.DeliverooTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.*
import java.nio.file.Files.size
@Composable
private fun PageUi(page :Page){
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7F4)),
    ) {
        Image(painter = painterResource(id = page.image),
            contentDescription = null ,
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp
                    )
                )
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = page.title,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFb95856),
            modifier = Modifier.padding(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = page.description,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(horizontal = 32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))



    }
}

@OptIn(ExperimentalPagerApi::class, kotlinx.coroutines.DelicateCoroutinesApi::class)
@Composable
fun OnboardingUI (onButtonClick: ()->Unit = {}){
    val pagerState =  rememberPagerState()
    val scope = rememberCoroutineScope()
    Column() {
        HorizontalPager(count = 3,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {page ->  
            PageUi(page = onboardPages[page])
        }
        

        when (pagerState.currentPage){
            2 -> AnimatedVisibility(visible = true ) {
                OutlinedButton(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                    ,onClick = onButtonClick,
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color(0xFFb1413c),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 20.sp
                    )
                }
            }
            else -> AnimatedVisibility(visible = true  ) {
                OutlinedButton(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                    ,onClick = {
                       scope.launch(){
                           pagerState.animateScrollToPage(2)
                       }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color(0xFFb1413c),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Skip",
                        fontSize = 20.sp
                    )
                }

            }
        }


        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(16.dp),
            activeColor = Color(0xFFb1413c)
        )
        }

    }



@Preview
@Composable
fun PreviewPage(){
    val pages : Page = onboardPages[0]
    DeliverooTheme{
        PageUi(page = pages)
    }

}