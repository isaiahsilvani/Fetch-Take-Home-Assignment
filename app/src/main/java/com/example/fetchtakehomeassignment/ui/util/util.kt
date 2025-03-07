package com.example.fetchtakehomeassignment.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Helper function to get string resource within a Composable
 */
@Composable
fun getString(resId: Int) = LocalContext.current.getString(resId)