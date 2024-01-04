package com.example.aimogus

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.aimogus.ui.theme.AImogusTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import com.example.aimogus.Questions
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AImogusTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(onNextScreen = {
                navController.navigate("lobby")
            })
        }
        composable(route = "lobby") {
            LobbyScreen(onNextScreen = {
                navController.navigate("question")
            })
        }
        composable(route = "question") {
            QuestionScreen(onNextScreen = {
                navController.navigate("responses")
            })
        }
        composable(route = "responses") {
            ResponsesScreen(onNextScreen = {
                navController.navigate("decision")
            })
        }
        composable(route = "decision") {
            DecisionScreen(onNextScreen = {
                navController.navigate("results")
            })
        }
        composable(route = "results") {
            ResultsScreen(onNextScreen = {
                navController.navigate("home")
            })
        }
    }
}


@Composable
fun HomeScreen(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "AImogus",
            fontSize = 76.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = "Find the imposter!",
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = onNextScreen,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Start!")
        }
    }
}

@Composable
fun LobbyScreen(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Lobby",
            fontSize = 76.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = onNextScreen,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Join Group")
        }
    }
}

@Composable
fun QuestionScreen(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    val questions = Questions()
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        var userAnswer by remember { mutableStateOf("")}
        val questionText = questions.getRandomQuestion()
        Text(
            text = "Question 1",
            fontSize = 76.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = questionText,
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        OutlinedTextField(
            value = userAnswer,
            onValueChange = { userAnswer = it },
            label = {Text("Answer")},
            singleLine = false,
            modifier = Modifier
                .padding(24.dp)
        )
        Button(
            onClick = onNextScreen,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun ResponsesScreen(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Responses",
            fontSize = 76.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = "Bob: Yes",
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = onNextScreen,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun DecisionScreen(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Decision Time!",
            fontSize = 76.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = "Who is the imposter?",
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = onNextScreen,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun ResultsScreen(onNextScreen: () -> Unit, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Results",
            fontSize = 76.sp,
            lineHeight = 120.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = "Bob was the imposter",
            fontSize = 38.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = onNextScreen,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Play Again")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AImogusTheme {
        App()
    }
}