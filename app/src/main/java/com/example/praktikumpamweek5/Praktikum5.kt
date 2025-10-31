package com.example.praktikumpamweek5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val purpleGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF6A1B9A), //
        Color(0xFF8E24AA), //
        Color(0xFFAB47BC)  //
    )
)
@Composable
fun RegistrationScreen() {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("") }

    var submittedNama by remember { mutableStateOf("") }
    var submittedAlamat by remember { mutableStateOf("") }
    var submittedGender by remember { mutableStateOf("") }
    var submittedStatus by remember { mutableStateOf("") }

    val genderOptions = stringArrayResource(R.array.gender_options)
    val statusOptions = stringArrayResource(R.array.status_options)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(purpleGradient)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(R.string.form_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

            ){
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
                ){
                    FormLabel(text = stringResource(R.string.label_nama))
                    OutlinedTextField(
                        value = textNama,
                        onValueChange = { textNama = it },
                        placeholder = { Text(stringResource(R.string.placeholder_nama)) }, // <-- MEMANGGIL STRING
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    FormLabel(text = stringResource(R.string.label_gender))
                    Column {
                        genderOptions.forEach { option ->
                            RadioButtonOption(
                                text = option,
                                selected = selectedGender == option,
                                onClick = { selectedGender = option }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    FormLabel(text = stringResource(R.string.label_alamat)) // <-- MEMANGGIL STRING
                    OutlinedTextField(
                        value = textAlamat,
                        onValueChange = { textAlamat = it },
                        placeholder = { Text(stringResource(R.string.placeholder_alamat)) }, // <-- MEMANGGIL STRING
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = {
                            // Simpan data ke state 'submitted'
                            submittedNama = textNama
                            submittedAlamat = textAlamat
                            submittedGender = selectedGender
                            submittedStatus = selectedStatus
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF673AB7) // Warna ungu tombol
                        )
                    ){
                        Text(text = stringResource(R.string.button_submit))
                    }
                }
            }
        }
    }
}

@Composable
fun RadioButtonOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = onClick
            )
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Composable
fun FormLabel(text: String) {
    TODO("Not yet implemented")
}

