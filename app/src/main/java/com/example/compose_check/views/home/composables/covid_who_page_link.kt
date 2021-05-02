package com.example.compose_check.views.home.composables


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.compose_check.R


@Composable
fun WhoPageLinkLunchWidgetWithImage(context: Context) {
    Card(
        elevation = 10.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(16.dp)
            .clickable {


                val intent = Intent(Intent.ACTION_VIEW)
                intent.data =
                    Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019")
                startActivity(context, intent, Bundle())
            }
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Image(
                painterResource(R.drawable.coronavirus),
                "This is content description",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height = 60.dp)
                    .width(width = 60.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Covid 19")
                Text("For more visit WHO site")
            }

            Image(
                painterResource(R.drawable.who_logo),
                "This is content description",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height = 60.dp)
                    .width(width = 60.dp)
            )
        }
    }

}