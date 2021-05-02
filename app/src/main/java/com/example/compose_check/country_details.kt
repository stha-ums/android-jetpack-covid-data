import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose_check.models.apiModels.Data
import com.example.compose_check.models.dataWidgetModel.WidgetModel
import com.example.compose_check.views.home.composables.DeathRecoveredInfectedDataGrid

@Composable
fun CountryDetail(navController: NavHostController, country: Data) {
    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    country.location!!, style = TextStyle(
                        fontSize = 25.sp
                    )
                )
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DeathRecoveredInfectedDataGrid(
                deathGlobal = WidgetModel(country.dead!!, "Death"),
                recoveredGlobal = WidgetModel(country.recovered!!, "Recovered"),
                infectedGlobal = WidgetModel(country.confirmed!!, "Infected"),
            )
            Spacer(modifier = Modifier.height(100.dp))
            FloatingActionButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "BackButton")
            }
        }
    }
}