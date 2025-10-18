package com.mcajusol.pc01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mcajusol.pc01.ui.theme.PC01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleApp()
        }
    }
}

@Composable
@Preview
fun SimpleApp() {
    var name by remember { mutableStateOf(value = "") }
    var message by remember { mutableStateOf<String?>(value = null) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.width(width = 12.dp))
        //Text(text = "Hola Mundo", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Escribe tu nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )
        Button(
            onClick = {
                val safeName = if(name.isBlank()) "Desconocido" else name
                message = "Hola $safeName"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Saludar")
        }
        message?.let {
            Text(text = it,style=MaterialTheme.typography.titleMedium)
        }
    }

}