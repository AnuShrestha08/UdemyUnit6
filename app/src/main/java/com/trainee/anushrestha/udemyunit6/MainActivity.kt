package com.trainee.anushrestha.udemyunit6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trainee.anushrestha.udemyunit6.ui.theme.UdemyUnit6Theme
import com.trainee.anushrestha.udemyunit6.ui.theme.activeColor
import com.trainee.anushrestha.udemyunit6.ui.theme.tryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UdemyUnit6Theme{
                    ProfileCardLayout()
            }
        }
    }
}
 @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCardLayout(profileDetailing : List<ProfileDetails> = profileDetailsList) {
    Scaffold(topBar = { AppBar() }) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Column {
                for(profileDetails in profileDetailing) {
                    ProfileCard(profileDetails = profileDetails)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    TopAppBar(
        navigationIcon = {
                         IconButton(onClick = { /*TODO*/ }) {
                             Icon(imageVector = Icons.Default.ArrowBack, contentDescription = " ", modifier = Modifier.padding(4.dp))
                         }
        },
        title = {
            Text(text = "Chat status",
                style = MaterialTheme.typography.headlineLarge) },
    )

}

@Composable
fun ProfileCard(profileDetails: ProfileDetails){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .wrapContentHeight(align = Alignment.Top),
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp),
        shape = CutCornerShape(topEnd = 25.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            ProfilePicture(profileDetails.drawableImage, profileDetails.status)
            ProfileContent(profileDetails.name, profileDetails.status)
        }

    }

}

@Composable
    fun ProfilePicture(drawableImage: Int, onlineStatus : Boolean){
    //taking online status as we might change the borderStroke acc to status of users
    Card(shape = CircleShape,
        border = BorderStroke(width = 3.dp,
            color = if(onlineStatus)
                        MaterialTheme.colorScheme.activeColor
                            else
                                Color.Red),
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Image(painter = painterResource(id = drawableImage),
            contentDescription ="" ,
            contentScale = ContentScale.Crop,
            modifier=Modifier.size(80.dp))
    }
}

@Composable
fun ProfileContent(name : String, onlineStatus : Boolean){
    //taking online status as we might change the
    // text acc. to status of users

    Column(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()){
        Text(text = name,
            style = MaterialTheme.typography.headlineSmall)
        Text(text = if(onlineStatus)
                        "Active"
                            else
                                "Inactive",
            style = MaterialTheme.typography.bodySmall,
            modifier =
            Modifier.alpha(0.5f))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UdemyUnit6Theme{
        ProfileCardLayout()
    }
}