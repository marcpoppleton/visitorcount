package com.marcpoppleton.visitorcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcpoppleton.visitorcount.ui.theme.VisitorCountTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var boysCount by remember { mutableStateOf(0) }
            var girlsCount by remember { mutableStateOf(0) }
            var nonbinaryCount by remember { mutableStateOf(0) }
            VisitorCountTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 10.dp,
                            alignment = Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "${girlsCount + nonbinaryCount + boysCount} visitors",
                            fontSize = 40.sp
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(0.5F)
                                    .padding(0.dp, 0.dp, 2.dp, 0.dp),
                                shape = RoundedCornerShape(15.dp),
                                onClick = { girlsCount++ }) {
                                Text(
                                    text = "$girlsCount Girls"
                                )
                            }
                            Button(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(0.5F)
                                    .padding(0.dp, 0.dp, 0.dp, 0.dp),
                                shape = RoundedCornerShape(15.dp),
                                onClick = { nonbinaryCount++ }) {
                                Text(
                                    text = "$nonbinaryCount Non binary"
                                )
                            }
                            Button(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(0.5F)
                                    .padding(2.dp, 0.dp, 0.dp, 0.dp),
                                shape = RoundedCornerShape(15.dp),
                                onClick = { boysCount++ }) {
                                Text(
                                    text = "$boysCount Boys"
                                )
                            }
                        }
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(10.dp),
                            shape = RoundedCornerShape(15.dp),
                            onClick = {
                                boysCount = 0
                                nonbinaryCount = 0
                                girlsCount = 0
                            }) {
                            Text(
                                text = "Reset"
                            )
                        }
                    }
                }
            }
        }
    }
}