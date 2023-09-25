package ca.tetervak.mytipcalculator2.ui.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.mytipcalculator2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen() {

    val serviceCostInput: MutableState<String> = remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Text(
            text = stringResource(R.string.tip_calculator),
            color = colorResource(id = R.color.pink_700),
            fontSize = 24.sp
        )
        CalculatorInputs(
            serviceCost = serviceCostInput.value,
            onServiceCostChange = { serviceCostInput.value = it}
        )
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun CalculatorInputs(serviceCost: String, onServiceCostChange: (String) -> Unit) {
    TextField(
        label = { Text(text = stringResource(R.string.service_cost)) },
        singleLine = true,
        value = serviceCost,
        onValueChange = onServiceCostChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .padding(16.dp)
            .sizeIn(minWidth = 256.dp)
    )
}


@Preview
@Composable
fun CalculatorScreenPreview(){
    CalculatorScreen()
}

