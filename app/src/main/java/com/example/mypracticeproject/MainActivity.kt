package com.example.mypracticeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mypracticeproject.ui.theme.MyPracticeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPracticeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyPracticeProjectApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyPracticeProjectTheme {
        BusinessCardApp()
    }
}

@Composable
fun MyPracticeProjectApp() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ArticleApp()
        TaskManagerApp()
        ComposeQuadrantApp()
        BusinessCardApp()
    }
}

//ARTICLE APP
@Composable
fun ArticleApp() {
    ArticleCard(
        title = stringResource(id = R.string.article_title),
        shortDescription = stringResource(
            id = R.string.article_short_description
        ),
        longDescription = stringResource(id = R.string.article_long_description),
        articleImagePainter = painterResource(
            id = R.drawable.bg_compose_background
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp)
    )
}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    articleImagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = articleImagePainter, contentDescription = null)
        Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(all = 16.dp))
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}


//TASK MANAGER APP
@Composable
fun TaskManagerApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.task_completed),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(text = stringResource(id = R.string.task_nice_work), fontSize = 16.sp)
    }
}

//COMPOSE QUADRANT APP
@Composable
fun ComposeQuadrantApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp)
    ) {
        Row(modifier = Modifier.weight(1f)) {
            ComposableQuadrant(
                title = stringResource(id = R.string.quad_one_title), description = stringResource(
                    id = R.string.quad_one_desc
                ), backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposableQuadrant(
                title = stringResource(id = R.string.quad_two_title), description = stringResource(
                    id = R.string.quad_two_desc
                ), backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposableQuadrant(
                title = stringResource(id = R.string.quad_three_title),
                description = stringResource(
                    id = R.string.quad_three_desc
                ),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposableQuadrant(
                title = stringResource(id = R.string.quad_four_title), description = stringResource(
                    id = R.string.quad_four_desc
                ), backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableQuadrant(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = description)
    }
}

@Composable
fun BusinessCardApp() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp).padding(bottom = 32.dp)
    ) {
        CardIntroduction(
            name = stringResource(id = R.string.business_name),
            title = stringResource(id = R.string.business_title),
            profileImage = painterResource(id = R.drawable.picture),
            modifier = Modifier.align(Alignment.Center)
        )
        CardLinks(
            contact = stringResource(id = R.string.business_contact),
            website = stringResource(id = R.string.business_website),
            email = stringResource(id = R.string.business_email),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun CardIntroduction(
    name: String,
    title: String,
    profileImage: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = profileImage, contentDescription = null)
        Text(text = name, fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(vertical = 16.dp))
        Text(text = title)
    }
}

@Composable
fun CardLinks(contact: String, website: String, email: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        SingleCardLink(Icons.Rounded.Call, text = contact)
        SingleCardLink(Icons.Rounded.Share, text = website)
        SingleCardLink(Icons.Rounded.Email, text = email)
    }
}

@Composable
fun SingleCardLink(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Icon(icon, contentDescription = null, tint = Color(0xFF3ddc84))
        Text(text = text, color = Color(0xFF3ddc84))
    }
}

