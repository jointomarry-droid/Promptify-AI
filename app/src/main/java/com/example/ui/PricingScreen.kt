package com.example.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import coil.compose.AsyncImage
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.premium_rose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = "https://lh3.googleusercontent.com/aida-public/AB6AXuBE9nKeoPAOinEeAnu9_gkl4YfmpFdZnPVOdnc-tpYmDOgeQ68ky6nSoLA_uSTGnVWvcjmXNSIuW7AHImLUoMvAcSR3LLsmHxkTyQEeDDKld-E8BFi1yPBdvtu0FGN0cG0EicCp-AlZXAecMhvEI1DaKOrpSPGpX2S0zrymqvkv3mTwt2rk-m8wCz99voGVVvu8iZCkRVDzS6x320Q8k2RFbaH8TRiAPNBlXWp6iVVJe6B8txAPMD9tepRa1KiXJln7pxjLIwXFgyo",
                                contentDescription = "Profile",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            "PromptCraft AI", 
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 20.sp
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = MaterialTheme.colorScheme.onSurface)
                    }
                },
                actions = {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Default.Bolt, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("150 Credits", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Premium Plans",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Unlock the full potential of PromptCraft AI. Choose the tier that matches your workflow and never hit a creative wall again.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            // Starter
            item {
                PricingCard(
                    title = "Starter",
                    price = "$9",
                    credits = "50 Credits",
                    icon = Icons.Default.Toll,
                    iconColor = MaterialTheme.colorScheme.primary,
                    features = listOf(
                        "Standard AI Models" to true,
                        "Basic Prompt History" to true,
                        "API Access" to false
                    ),
                    buttonText = "Select Starter"
                )
            }
            
            // Pro
            item {
                PricingCard(
                    title = "Pro",
                    price = "$29",
                    credits = "200 Credits",
                    icon = Icons.Default.Bolt,
                    iconColor = premium_rose,
                    features = listOf(
                        "Advanced GPT-4 Access" to true,
                        "Unlimited Prompt History" to true,
                        "Priority Support" to true,
                        "API Access (Standard)" to true
                    ),
                    buttonText = "Buy Now",
                    isRecommended = true
                )
            }
            
            // Unlimited
            item {
                PricingCard(
                    title = "Unlimited",
                    price = "$99",
                    credits = "Unlimited",
                    icon = Icons.Default.AllInclusive,
                    iconColor = MaterialTheme.colorScheme.primary,
                    features = listOf(
                        "All Pro Features" to true,
                        "Dedicated Server Pool" to true,
                        "Custom Model Fine-tuning" to true
                    ),
                    buttonText = "Contact Sales"
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Guaranteed Safe & Secure Checkout", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("By purchasing, you agree to our Terms of Service and Privacy Policy.", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline, textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Composable
fun PricingCard(
    title: String,
    price: String,
    credits: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color,
    features: List<Pair<String, Boolean>>,
    buttonText: String,
    isRecommended: Boolean = false
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = if(isRecommended) MaterialTheme.colorScheme.surfaceContainerHigh else MaterialTheme.colorScheme.surfaceContainer),
        border = BorderStroke(2.dp, if(isRecommended) premium_rose else MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            if (isRecommended) {
                Surface(color = premium_rose, shape = RoundedCornerShape(bottomStart = 8.dp), modifier = Modifier.align(Alignment.End).offset(x = 24.dp, y = (-24).dp)) {
                    Text("Recommended", style = MaterialTheme.typography.labelSmall, color = Color.White, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
                }
            }
            Text(title, style = MaterialTheme.typography.titleLarge, color = if(isRecommended) premium_rose else MaterialTheme.colorScheme.onSurface)
            Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.padding(vertical = 16.dp)) {
                Text(price, style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onSurface)
                Text("/month", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
            }
            Surface(
                color = iconColor.copy(alpha=0.1f),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, iconColor.copy(alpha=0.2f)),
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                    Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(credits, style = MaterialTheme.typography.labelSmall, color = if(isRecommended) premium_rose else MaterialTheme.colorScheme.onSurface)
                }
            }
            
            features.forEach { (feature, isIncluded) ->
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 16.dp)) {
                    if (isIncluded) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = if(isRecommended) premium_rose else MaterialTheme.colorScheme.outline, modifier = Modifier.size(20.dp))
                    } else {
                        Icon(Icons.Default.Close, contentDescription = null, tint = MaterialTheme.colorScheme.outline, modifier = Modifier.size(20.dp))
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(feature, style = MaterialTheme.typography.bodyMedium, color = if(isIncluded) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            if (isRecommended) {
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(48.dp).testTag("pricing_buy_pro"),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = premium_rose)
                ) {
                    Text(buttonText, fontWeight = FontWeight.Bold)
                }
            } else {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Text(buttonText)
                }
            }
        }
    }
}
