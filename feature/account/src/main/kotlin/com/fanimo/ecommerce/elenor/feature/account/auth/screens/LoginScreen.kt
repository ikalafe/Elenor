package com.fanimo.ecommerce.elenor.feature.account.auth.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.fanimo.ecommerce.designsystem.component.EleButton
import com.fanimo.ecommerce.elenor.feature.account.R

@Composable
fun LoginScreen(
    onPhoneNumberEntered:  (String) -> Unit
) {
    var phoneNumber by remember { mutableStateOf("") }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .imePadding()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .padding(8.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = R.drawable.logo)
                    .crossfade(enable = true)
                    .scale(Scale.FILL)
                    .build(),
                contentDescription = stringResource(id = R.string.login_heading_text)
            )
            // Phone number input field
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { "Enter your phone number" }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Submit button
            EleButton(
                onClick = { onPhoneNumberEntered(phoneNumber) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}


