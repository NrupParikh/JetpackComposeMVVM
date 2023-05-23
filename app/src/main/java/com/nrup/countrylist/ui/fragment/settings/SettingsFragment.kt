package com.nrup.countrylist.ui.fragment.settings

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.ui.fragment.settings.screen.SettingsScreen
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.viewmodel.SettingsViewModel

@Composable
fun SettingsFragment(
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    SettingsScreen()
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsFragmentPreview() {
    CountryListTheme {
        SettingsFragment()
    }
}