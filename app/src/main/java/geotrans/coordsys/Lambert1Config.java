package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.MapProjection5Parameters;

public class Lambert1Config extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public Lambert1Config()
    {
        Log.d("GeoTrans", "Lambert1Config constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(14);
    }

    public static CoordinateTuple createCoordinateTuple(double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "Lambert1Config.createCoordinateTuple(" + paramDouble1 + ", " + paramDouble2 + ")");
        return new MapProjectionCoordinates(14, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "Lambert1Config.createCoordinateTuple");
        return new MapProjectionCoordinates(14);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "Lambert1Config.setCoordinateSystemParameters via object");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 14)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 14 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString)
    {
        Log.d("GeoTrans", "Lambert1Config.setCoordinateSystemParameters via string " + paramString);
        double d5 = 0.0D;
        double d8 = 0.0D;
        double d7 = 0.0D;
        double d6 = 0.0D;
        double d10 = 0.0D;
//        paramString = paramString.split(",",-1);
        StringToVal localStringToVal = new StringToVal();
        double d4 = d5;
        double d3 = d8;
        double d2 = d7;
        double d1 = d6;
        double d9 = d10;
//        if (paramString.length == 5)
//        {
//            d4 = d5;
//            d3 = d8;
//            d2 = d7;
//            d1 = d6;
//        }
//        try
//        {
//            d5 = localStringToVal.stringToLongitude(paramString[0].trim()) / 57.295779513082323D;
            d4 = d5;
            d3 = d8;
            d2 = d7;
            d1 = d6;
//            d8 = localStringToVal.stringToLatitude(paramString[1].trim()) / 57.295779513082323D;
            d4 = d5;
            d3 = d8;
            d2 = d7;
            d1 = d6;
//            d7 = localStringToVal.stringToDouble(paramString[2]);
            d4 = d5;
            d3 = d8;
            d2 = d7;
            d1 = d6;
//            d6 = localStringToVal.stringToDouble(paramString[3]);
            d4 = d5;
            d3 = d8;
            d2 = d7;
            d1 = d6;
//            d9 = localStringToVal.stringToDouble(paramString[4]);
            d1 = d6;
            d2 = d7;
            d3 = d8;
            d4 = d5;
            this.coordinateSystemParameters = new MapProjection5Parameters(14, d4, d3, d2, d1, d9);
            return;
//        }
//        catch (CoordinateConversionException CCE)
//        {
////            while (true)
////                d9 = d10;
//        }
    }
}