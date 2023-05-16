package com.nrup.countrylist.ui.fragment.detail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nrup.countrylist.R
import com.nrup.countrylist.domain.model.countrylist.CountryData
import com.nrup.countrylist.ui.components.CountryListItem
import com.nrup.countrylist.utils.AppUtils.Companion.getValue

@Composable
fun DetailsScreen(countryData: CountryData?) {


    var countryNameValue = ""
    var countryCodeValue = ""
    var callingCodeValue = ""
    var capitalCityValue = ""
    var subRegionValue = ""
    var continentValue = ""
    var populationValue = ""
    var latLangValue = ""
    var areaValue = ""
    var timeZonesValue = ""
    var bordersValue = ""
    var nativeNameValue = ""
    var numericCodeValue = ""
    var currencyCodeValue = ""
    var currencyNameValue = ""
    var currencySymbolValue = ""
    var languagesValue = ""
    var independentValue = ""

    countryData?.apply {
        countryNameValue = name.toString()
        countryCodeValue = alpha2Code.toString()
        callingCodeValue = "+" + callingCodes?.first().toString()
        capitalCityValue = capital.toString()
        subRegionValue = subregion.toString()
        continentValue = region.toString()
        populationValue = population.toString()
        latLangValue = latlng?.first().toString() + "," + latlng?.last().toString()
        areaValue = area.toString()
        timeZonesValue = timezones?.first().toString()
        bordersValue = borders?.toList().toString()
        nativeNameValue = nativeName.toString()
        numericCodeValue = numericCode.toString()
        currencyCodeValue = currencies?.first()?.code.toString()
        currencyNameValue = currencies?.first()?.name.toString()
        currencySymbolValue = currencies?.first()?.symbol.toString()
        languagesValue = languages?.first()?.name.toString()
        independentValue =
            if (independent == true) stringResource(id = R.string.yes) else stringResource(id = R.string.no)
    }


    val data = ArrayList<Pair<String, String>>()
    data.add(Pair("Name", countryNameValue.getValue()))
    data.add(Pair("Code", countryCodeValue.getValue()))
    data.add(Pair("Calling Code", callingCodeValue.getValue()))
    data.add(Pair("Capital", capitalCityValue.getValue()))
    data.add(Pair("Sub Region", subRegionValue.getValue()))
    data.add(Pair("Continent", continentValue.getValue()))
    data.add(Pair("population", populationValue.getValue()))
    data.add(Pair("LatLang", latLangValue.getValue()))
    data.add(Pair("Area", areaValue.getValue()))
    data.add(Pair("Time Zone(s)", timeZonesValue.getValue()))
    data.add(Pair("Borders", bordersValue.getValue()))
    data.add(Pair("Native Name", nativeNameValue.getValue()))
    data.add(Pair("Numeric Code", numericCodeValue.getValue()))
    data.add(Pair("Currency Code", currencyCodeValue.getValue()))
    data.add(Pair("Currency Name", currencyNameValue.getValue()))
    data.add(Pair("Currency Symbol", currencySymbolValue.getValue()))
    data.add(Pair("Languages", languagesValue.getValue()))
    data.add(Pair("Is Independent", independentValue.getValue()))
    data.trimToSize()


    Column() {
        CountryListItem(
            index = 0,
            countryData,
            false,
            onClick = null
        )

        TableScreen(data)
    }


}

@Composable
fun TableScreen(data: ArrayList<Pair<String, String>>) {

    val column1Weight = .5f
    val column2Weight = .5f

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Here is the header
        item() {
            Row(
                Modifier
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f))
                    .height(
                        // Used to set Max height to Row Item.
                        intrinsicSize = IntrinsicSize.Max
                    )
            ) {
                TableCell(
                    text = stringResource(id = R.string.attribute),
                    weight = column1Weight,
                    TextAlign.Center,
                    FontWeight.Bold
                )
                TableCell(
                    text = stringResource(id = R.string.value),
                    weight = column2Weight,
                    TextAlign.Center,
                    FontWeight.Bold
                )
            }
        }

        items(data) {
            val (key, value) = it
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(
                        // Used to set Max height to Row Item.
                        intrinsicSize = IntrinsicSize.Max
                    )
            ) {
                TableCell(
                    text = key,
                    weight = column1Weight,
                    TextAlign.Start,
                    FontWeight.Bold
                )
                TableCell(
                    text = value,
                    weight = column2Weight,
                    TextAlign.Start,
                    FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    textAlign: TextAlign,
    fontWeight: FontWeight
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary,
        textAlign = textAlign,
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.secondary)
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight(),
        fontWeight = fontWeight,

        )
}