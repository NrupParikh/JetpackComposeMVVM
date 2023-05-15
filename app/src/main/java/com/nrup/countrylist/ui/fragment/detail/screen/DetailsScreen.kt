package com.nrup.countrylist.ui.fragment.detail.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.nrup.countrylist.R
import com.nrup.countrylist.domain.model.countrylist.CountryData

@Composable
fun DetailsScreen(countryData: CountryData?) {

    val imagePainter = rememberAsyncImagePainter(
        model = countryData?.flags?.png,
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )

    var countryNameValue: String = ""
    var countryCodeValue: String = ""
    var callingCodeValue: String = ""
    var capitalCityValue: String = ""
    var subRegionValue: String = ""
    var continentValue: String = ""
    var populationValue: String = ""
    var latLangValue: String = ""
    var areaValue: String = ""
    var timeZonesValue: String = ""
    var bordersValue: String = ""
    var nativeNameValue: String = ""
    var numericCodeValue: String = ""
    var currencyCodeValue: String = ""
    var currencyNameValue: String = ""
    var currencySymbolValue: String = ""
    var languagesValue: String = ""
    var independentValue: String = ""

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
        currencyCodeValue = currencies.toString()
        currencyNameValue = currencies.toString()
        currencySymbolValue = currencies.toString()
        languagesValue = languages.toString()
        independentValue = independent.toString()
    }


    val data = ArrayList<Pair<String, String>>()
    data.add(Pair("Name", countryNameValue))
    data.add(Pair("Code", countryCodeValue))
    data.add(Pair("Calling Code", callingCodeValue))
    data.add(Pair("Capital", capitalCityValue))
    data.add(Pair("Sub Region", subRegionValue))
    data.add(Pair("Continent", continentValue))
    data.add(Pair("population", populationValue))
    data.add(Pair("LatLang", latLangValue))
    data.add(Pair("Area", areaValue))
    data.add(Pair("Time Zone(s)", timeZonesValue))
    data.add(Pair("Borders", bordersValue))
    data.add(Pair("Native Name", nativeNameValue))
    data.add(Pair("Numeric Code", numericCodeValue))
    data.add(Pair("Currency Code", currencyCodeValue))
    data.add(Pair("Currency Name", currencyNameValue))
    data.add(Pair("Currency Symbol", currencySymbolValue))
    data.add(Pair("Languages", languagesValue))
    data.add(Pair("Is Independent", independentValue))
    data.trimToSize()

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(
            4.dp,
            MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Text(
            text = countryData?.name.toString(),
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = imagePainter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }


        TableScreen(data)
    }
}

@Composable
fun TableScreen(data: ArrayList<Pair<String, String>>) {

//    val tableData = (0 until data.size).mapIndexed { index, item ->
//        index to "Item $index"
//    }

    val column1Weight = .5f
    val column2Weight = .5f

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Here is the header
        item {
            Row(Modifier.background(MaterialTheme.colorScheme.secondary)) {
                TableCell(
                    text = "Attribute",
                    weight = column1Weight,
                    TextAlign.Center,
                    FontWeight.Bold
                )
                TableCell(
                    text = "Value",
                    weight = column2Weight,
                    TextAlign.Center,
                    FontWeight.Bold
                )
            }
        }

        items(data) {
            val (key, value) = it
            Row(Modifier.fillMaxWidth()) {
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
        color = Color.Black,
        textAlign = textAlign,
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.secondary)
            .weight(weight)
            .padding(8.dp),
        fontWeight = fontWeight
    )
}