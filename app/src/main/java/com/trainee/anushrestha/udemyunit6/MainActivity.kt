package com.trainee.anushrestha.udemyunit6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trainee.anushrestha.udemyunit6.ui.theme.UdemyUnit6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    ProfileCardLayout()
        }
    }
}

@Composable
fun ProfileCardLayout() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray){
    }
    ProfileCard()
}

@Composable
fun ProfileCard(){
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            ProfilePicture()
            ProfileContent()
        }

    }

}

@Composable
fun ProfilePicture(){
    Card(shape = CircleShape,
        border = BorderStroke(3.dp, Color.Red),
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.pp),
            contentDescription ="" ,
            contentScale = ContentScale.Crop,
            modifier=Modifier.size(80.dp))
    }
}

@Composable
fun ProfileContent(){
    Column(modifier = Modifier.padding(4.dp)){
        Text(text = "Name : Surprised person")
        Text(text = "Bachelor completed")
        Text(text = "Name : Surprised person")
        Text(text = "Bachelor completed")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        ProfileCardLayout()
}