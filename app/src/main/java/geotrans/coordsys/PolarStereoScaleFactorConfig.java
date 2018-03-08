package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.PolarStereographicScaleFactorParameters;

public class PolarStereoScaleFactorConfig extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public PolarStereoScaleFactorConfig()
    {
        Log.d("GeoTrans", "PolarStereoScaleFactorConfig constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(27);
    }

    public static CoordinateTuple createCoordinateTuple(double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "PolarStereoScaleFactorConfig.createCoordinateTuple(" + paramDouble1 + ", " + paramDouble2 + ")");
        return new MapProjectionCoordinates(27, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "PolarStereoScaleFactorConfig.createCoordinateTuple");
        return new MapProjectionCoordinates(27);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "PolarStereoScaleFactorConfig.setCoordinateSystemParameters");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 27)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 27 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString)
    {
        Log.d("GeoTrans", "MercatorScaleFactorConfig.setCoordinateSystemParameters via string " + paramString);
        double d4 = 0.0D;
        double d6 = 0.0D;
        Object localObject = "N";
        double d5 = 0.0D;
        double d8 = 0.0D;
        String[] arrayOfString = paramString.split(",", -1);
        StringToVal localStringToVal = new StringToVal();
        double d3 = d4;
        double d2 = d6;
        double d1 = d5;
        double d7 = d8;
        paramString = (String)localObject;
        if (arrayOfString.length == 5)
        {
            d3 = d4;
            d2 = d6;
            d1 = d5;
            paramString = (String)localObject;
        }
        try
        {
            d4 = localStringToVal.stringToLongitude(arrayOfString[0].trim()) / 57.295779513082323D;
            d3 = d4;
            d2 = d6;
            d1 = d5;
            paramString = (String)localObject;
            d6 = localStringToVal.stringToDouble(arrayOfString[1]);
            localObject = arrayOfString[2];
            d3 = d4;
            d2 = d6;
            d1 = d5;
            paramString = (String)localObject;
            d5 = localStringToVal.stringToDouble(arrayOfString[3]);
            d3 = d4;
            d2 = d6;
            d1 = d5;
            paramString = (String)localObject;
            d7 = localStringToVal.stringToDouble(arrayOfString[4]);
            paramString = (String)localObject;
            d1 = d5;
            d2 = d6;
            d3 = d4;
            localObject = new PolarStereographicScaleFactorParameters(27, d3, d2, paramString.charAt(0), d1, d7);
            Log.d("GeoTrans", "PolarStereoScaleFactor Parameters: centralMeridian: " + d3 + " Scale Factor: " + d2 + " Hemisphere: " + paramString + " False Easting: " + d1 + " False Northing: " + d7);
            this.coordinateSystemParameters = ((CoordinateSystemParameters)localObject);
            return;
        }
        catch (CoordinateConversionException localCoordinateConversionException)
        {
            while (true)
                d7 = d8;
        }
    }
}