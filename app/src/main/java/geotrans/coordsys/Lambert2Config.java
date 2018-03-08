package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.MapProjection6Parameters;

public class Lambert2Config extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public Lambert2Config()
    {
        Log.d("GeoTrans", "Lambert2Config constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(15);
    }

    public static CoordinateTuple createCoordinateTuple(double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "Lambert2Config.createCoordinateTuple(" + paramDouble1 + ", " + paramDouble2 + ")");
        return new MapProjectionCoordinates(15, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "Lambert2Config.createCoordinateTuple");
        return new MapProjectionCoordinates(15);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "Lambert2Config.setCoordinateSystemParameters");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 15)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 15 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString)
    {
//        Log.d("GeoTrans", "Lambert1Config.setCoordinateSystemParameters via string " + paramString);
//        double d6 = 0.0D;
//        double d9 = 0.0D;
//        double d10 = 0.0D;
//        double d8 = 0.0D;
//        double d7 = 0.0D;
//        double d12 = 0.0D;
//        paramString = paramString.split(",", -1);
//        StringToVal localStringToVal = new StringToVal();
//        double d5 = d6;
//        double d4 = d9;
//        double d3 = d10;
//        double d2 = d8;
//        double d1 = d7;
//        double d11 = d12;
//        if (paramString.length == 6)
//        {
//            d5 = d6;
//            d4 = d9;
//            d3 = d10;
//            d2 = d8;
//            d1 = d7;
//        }
//        try
//        {
//            d6 = localStringToVal.stringToLongitude(paramString[0].trim()) / 57.295779513082323D;
//            d5 = d6;
//            d4 = d9;
//            d3 = d10;
//            d2 = d8;
//            d1 = d7;
//            d9 = localStringToVal.stringToLatitude(paramString[1].trim()) / 57.295779513082323D;
//            d5 = d6;
//            d4 = d9;
//            d3 = d10;
//            d2 = d8;
//            d1 = d7;
//            d10 = localStringToVal.stringToLatitude(paramString[2].trim()) / 57.295779513082323D;
//            d5 = d6;
//            d4 = d9;
//            d3 = d10;
//            d2 = d8;
//            d1 = d7;
//            d8 = localStringToVal.stringToLatitude(paramString[3].trim()) / 57.295779513082323D;
//            d5 = d6;
//            d4 = d9;
//            d3 = d10;
//            d2 = d8;
//            d1 = d7;
//            d7 = localStringToVal.stringToDouble(paramString[4]);
//            d5 = d6;
//            d4 = d9;
//            d3 = d10;
//            d2 = d8;
//            d1 = d7;
//            d11 = localStringToVal.stringToDouble(paramString[5]);
//            d1 = d7;
//            d2 = d8;
//            d3 = d10;
//            d4 = d9;
//            d5 = d6;
//            this.coordinateSystemParameters = new MapProjection6Parameters(15, d5, d4, d3, d2, d1, d11);
//            return;
//        }
//        catch (CoordinateConversionException paramString)
//        {
//            while (true)
//                d11 = d12;
//        }
    }
}