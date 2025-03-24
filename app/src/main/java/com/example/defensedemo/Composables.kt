package com.example.defensedemo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.ImeAction
import com.example.defensedemo.ui.theme.DefenseDemoTheme

data class Setting(val title: String, val description: String)

@Composable
fun SettingsScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val settingsList = remember {
        listOf(
            Setting("Wi-Fi", "Manage the Wi-Fi connections."),
            Setting("Bluetooth", "Connect to Bluetooth devices."),
            Setting("Display", "Adjust display settings and behavior."),
            Setting("Location", "Control location services and GPS."),
            Setting("Sound", "Change sound, vibration, and volume settings."),
            Setting("Notifications", "Set your notification preferences."),
            Setting("Battery", "Check battery usage and power-saving options."),
            Setting("Storage", "Manage your phone's storage and files."),
            Setting("Privacy", "Manage privacy settings and app permissions."),
            Setting("Security", "Set up screen lock, fingerprint, or face recognition."),
            Setting("Accounts", "Manage accounts and sync settings."),
            Setting("Apps", "Configure app-specific settings."),
            Setting("Date & Time", "Set time zone, date, and time format."),
            Setting("Language", "Change language preferences."),
            Setting("Backup", "Backup data to cloud services.")
        )
    }

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        Spacer(modifier = Modifier.height(28.dp))

        SearchBar(query = searchQuery, onQueryChange = { searchQuery = it })

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 0.dp)
        ) {
            items(settingsList) { setting ->
                SettingItem(title = setting.title, description = setting.description)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        label = { Text("Search Settings") },
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = { })
    )
}

@Composable
fun SettingItem(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    DefenseDemoTheme() {
        SettingsScreen()
    }
}