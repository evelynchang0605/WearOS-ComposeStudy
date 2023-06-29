@file:OptIn(ExperimentalAnimationGraphicsApi::class)

package com.example.countjetpack

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.AirplaneTicket
import androidx.compose.material.icons.outlined.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.InlineSlider
import androidx.wear.compose.material.InlineSliderDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Stepper
import androidx.wear.compose.material.StepperDefaults
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.TimeTextDefaults
import androidx.wear.compose.material.ToggleChip
import androidx.wear.compose.material.ToggleChipDefaults
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.material.itemsIndexed
import androidx.wear.compose.material.rememberScalingLazyListState
import java.util.Locale


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)
        setContent{
            AppPreview()
        }
    }
}

@Composable
fun CounterApp() {
    val count = remember {
        mutableStateOf(0)
    }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ){
            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize()
                    .padding(top = 20.dp)
            )
            {
                Text("Count:${count.value}",color=Color.White)
                Button(onClick = {count.value++}) {
                    Text(text = "click")
                }
            }
        }
}

@Composable
fun WearApp() {
    //WearExampleTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */
            Column(
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Long live Jetpack Compose Wear OS!",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
//}

@Composable
fun ButtonExample() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {


            Icon(
                Icons.Filled.Call,
                contentDescription = "call",
            )

        }

    }
}

@Composable
fun ToggleChipExample() {
    var checked by remember { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
// When we have both label and secondary label present limit both to 1 line of text
        ToggleChip(
            label = {
                Text("Hüseyin!", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
            secondaryLabel = {
                Text("Compose Wear OS!", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
            checked = checked,
            // For Switch  toggle controls the Wear Material UX guidance is to set the
            // unselected toggle control color to ToggleChipDefaults.switchUncheckedIconColor()
            // rather than the default.
            colors = ToggleChipDefaults.toggleChipColors(
                uncheckedToggleControlColor = ToggleChipDefaults.SwitchUncheckedIconColor
            ),
            toggleControl = {
                Switch(
                    checked = checked,
                    enabled = true,
                    modifier = Modifier.semantics {
                        this.contentDescription =
                            if (checked) "On" else "Off"
                    }
                )
            },
            onCheckedChange = { checked = it },
            appIcon = {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = "call",
                    modifier = Modifier
                        .size(24.dp)
                        .wrapContentSize(align = Alignment.Center),
                )
            },
            enabled = true,
        )
    }

}

@Composable
fun SliderExample() {
    var value by remember { mutableStateOf(4.5f) }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        InlineSlider(
            value = value,
            onValueChange = { value = it },
            increaseIcon = { Icon(InlineSliderDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(InlineSliderDefaults.Decrease, "Decrease") },
            valueRange = 3f..6f,
            steps = 5,
            segmented = true
        )

    }

}

@Composable
fun StepperExample() {
    var value by remember { mutableStateOf(5) }

    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Stepper(
            value = value,
            onValueChange = { value = it },
            increaseIcon = { Icon(StepperDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(StepperDefaults.Decrease, "Decrease") },
            valueProgression = 0..10,
            backgroundColor = Color.White,
        ) {
            Text("Value: $value")
        }


    }

}

@Composable
fun CardExample() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Card(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            contentColor = Color.Yellow,
            shape = RoundedCornerShape(20.dp),
        ) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(R.drawable.ic_launcher_background), contentDescription ="" , Modifier.size(25.dp))
                Text("Jetpack Compose!", textAlign = TextAlign.Center)
            }

        }

    }
}

@Composable
fun CircularProgressIndicatorExample() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 1.dp)
            .background(color = Color.Black),
        startAngle = 295.5f,
        endAngle = 245.5f,
        progress = 0.5f,
        strokeWidth = 5.dp,
        indicatorColor = Color.Green,
        trackColor = Color.LightGray
    )
}

@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScalingLazyListState()

    Column(
        modifier = Modifier.fillMaxSize(),
            //.background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
        ) {

            Icon(
                Icons.Outlined.AirplaneTicket,
                contentDescription = "",
            )

        }
        //Scrolling
        androidx.wear.compose.material.dialog.Dialog(
            showDialog = showDialog,
            onDismissRequest = { showDialog = false }, scrollState = scrollState
        ) {

            Alert(
                scrollState = scrollState,
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                contentPadding =
                PaddingValues(start = 10.dp, end = 10.dp, top = 24.dp, bottom = 52.dp),
                icon = {
                    Icon(
                        Icons.Outlined.Call,
                        contentDescription = "airplane",
                        modifier = Modifier
                            .size(24.dp)
                            .wrapContentSize(align = Alignment.Center)
                            .clickable { showDialog = false },
                        )
                },
                title = { Text(text = "Example Title Text", textAlign = TextAlign.Center, color = Color.White) },
                message = {
                    Text(
                        text = "Message content goes here",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )
                },
            ) {
                item {
                    Chip(
                        label = { Text("Primary") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.primaryChipColors(),
                    )
                }
                item {
                    Chip(
                        label = { Text("Secondary") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.secondaryChipColors(),
                    )
                }
                item {
                    Chip(
                        label = { Text("Third") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.secondaryChipColors(),
                    )
                }


            }
        }


        //For Dialog Animation
        /*
        androidx.wear.compose.material.dialog.Dialog(showDialog = showDialog, onDismissRequest = { showDialog = false }) {
            val animation = AnimatedImageVector.animatedVectorResource(R.drawable.ic_launcher_background)
            Confirmation(
                onTimeout = { showDialog = false },
                icon = {
                    // Initially, animation is static and shown at the start position (atEnd = false).
                    // Then, we use the EffectAPI to trigger a state change to atEnd = true,
                    // which plays the animation from start to end.
                    var atEnd by remember { mutableStateOf(false) }
                    DisposableEffect(Unit) {
                        atEnd = true
                        onDispose {}
                    }
                    Image(
                        painter = rememberAnimatedVectorPainter(animation, atEnd),
                        contentDescription = "Open on phone",
                        modifier = Modifier.size(48.dp)
                    )
                },
                durationMillis = 3000,
            ) {
                Text(text = "Open on phone", textAlign = TextAlign.Center)
            }
        }
    */
    }
}

@Composable
fun listExample() {
    val listState = rememberScalingLazyListState()
    val list: List<String> =
        listOf("Maraş", "Antep", "İzmir", "İstanbul", "Ankara", "Mardin", "Rize")

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black),) {

        ScalingLazyColumn(state = listState) {
            itemsIndexed(items = list) { index, item ->

                Card(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    contentColor = Color.Black,
                    shape = RoundedCornerShape(20.dp),
                ) {


                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(item, textAlign = TextAlign.Center,color = Color.Yellow,)
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))

            }
        }

    }
}

@Composable
fun TimeTextExample() {
    TimeText(
        Modifier.background(color = Color.Black),
        timeSource = TimeTextDefaults.timeSource(
            DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyy-MM-dd-hh:mm")
        )
    )

}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Surface {
        //CounterApp()
        //WearApp()
        //ButtonExample()
        //ToggleChipExample()
        //SliderExample()
        //StepperExample()
        //CardExample()
        //CircularProgressIndicatorExample()
        //DialogExample()
        //listExample()
        TimeTextExample()
        }
}