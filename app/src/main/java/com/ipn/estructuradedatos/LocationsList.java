package com.ipn.estructuradedatos;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class LocationsList
{
    public static List<LocationData> initLocationsData(Context context)
    {
        List<LocationData> locationDataList = new ArrayList<>();
        locationDataList.add(new LocationData(
                context.getString(R.string.progresoName),
                context.getString(R.string.progresoAddress),
                context.getString(R.string.progresoDescription),
                R.drawable.puerto_progreso_yucatan));

        locationDataList.add(new LocationData(
                context.getString(R.string.sisalName),
                context.getString(R.string.sisalAddress),
                context.getString(R.string.sisalDescription),
                R.drawable.sisal));

        locationDataList.add(new LocationData(
                context.getString(R.string.chelemName),
                context.getString(R.string.chelemAddress),
                context.getString(R.string.chelemDescription),
                R.drawable.chelem));

        locationDataList.add(new LocationData(
                context.getString(R.string.cenoteIkKilName),
                context.getString(R.string.cenoteIkKilAddress),
                context.getString(R.string.cenoteIkKilDescription),
                R.drawable.cenote_sagrado_ik_kil));

        locationDataList.add(new LocationData(
                context.getString(R.string.cenoteXlacahName),
                context.getString(R.string.cenoteXlacahAddress),
                context.getString(R.string.cenoteXlacahDescription),
                R.drawable.cenote_xlacah));

        locationDataList.add(new LocationData(
                context.getString(R.string.chichenItzaName),
                context.getString(R.string.chichenItzaAddress),
                context.getString(R.string.chichenItzaDescription),
                R.drawable.chichenitza));

        locationDataList.add(new LocationData(
                context.getString(R.string.EkBalamName),
                context.getString(R.string.EkBalamAddress),
                context.getString(R.string.EkBalamDescription),
                R.drawable.ekbalam));

        locationDataList.add(new LocationData(
                context.getString(R.string.uxmalName),
                context.getString(R.string.uxmalAddress),
                context.getString(R.string.uxmalDescription),
                R.drawable.uxmal));

        locationDataList.add(new LocationData(
                context.getString(R.string.coloradasName),
                context.getString(R.string.coloradasAddress),
                context.getString(R.string.coloradasDescription),
                R.drawable.lascoloradas));

        locationDataList.add(new LocationData(
                context.getString(R.string.CelestunName),
                context.getString(R.string.CelestunAddress),
                context.getString(R.string.CelestunDescription),
                R.drawable.celestun));

        return  locationDataList;
    }
}
