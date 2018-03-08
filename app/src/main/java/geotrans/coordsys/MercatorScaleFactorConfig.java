package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.MercatorScaleFactorParameters;

public class MercatorScaleFactorConfig extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public MercatorScaleFactorConfig()
    {
        Log.d("GeoTrans", "MercatorScaleFactorConfig constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(18);
    }

    public static CoordinateTuple createCoordinateTuple(double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "MercatorScaleFactorConfig.createCoordinateTuple(" + paramDouble1 + ", " + paramDouble2 + ")");
        return new MapProjectionCoordinates(18, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "MercatorScaleFactorConfig.createCoordinateTuple");
        return new MapProjectionCoordinates(18);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "MercatorScaleFactorConfig.setCoordinateSystemParameters");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 18)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 18 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString)
    {
        Log.d("GeoTrans", "MercatorScaleFactorConfig.setCoordinateSystemParameters via string " + paramString);
        double d4 = 0.0D;
        double d6 = 0.0D;
        double d5 = 0.0D;
        double d8 = 0.0D;
//        paramString = paramString.split(",", -1);
        StringToVal localStringToVal = new StringToVal();
        double d3 = d4;
        double d2 = d6;
        double d1 = d5;
        double d7 = d8;
//        if (paramString.length == 4)
//        {
//            d3 = d4;
//            d2 = d6;
//            d1 = d5;
//        }
//        try
//        {
//            d4 = localStringToVal.stringToLongitude(paramString[0].trim()) / 57.295779513082323D;
//            d3 = d4;
//            d2 = d6;
//            d1 = d5;
//            d6 = localStringToVal.stringToDouble(paramString[1]);
//            d3 = d4;
//            d2 = d6;
//            d1 = d5;
//            d5 = localStringToVal.stringToDouble(paramString[2]);
//            d3 = d4;
//            d2 = d6;
//            d1 = d5;
//            d7 = localStringToVal.stringToDouble(paramString[3]);
//            d1 = d5;
//            d2 = d6;
//            d3 = d4;
//            this.coordinateSystemParameters = new MercatorScaleFactorParameters(18, d3, d2, d1, d7);
//            return;
//        }
//        catch (CoordinateConversionException paramString)
//        {
//            while (true)
//                d7 = d8;
//        }
    }
}