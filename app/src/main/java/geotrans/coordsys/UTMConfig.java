package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.UTMCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.UTMParameters;

public class UTMConfig extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public UTMConfig()
    {
        Log.d("GeoTrans", "UTMConfig constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(34);
    }

    public static CoordinateTuple createCoordinateTuple(long paramLong, char paramChar, double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "UTMConfig.createCoordinateTuple(" + paramLong + ", " + paramChar + ", " + paramDouble1 + ", " + paramDouble2 + ")");
        return new UTMCoordinates(34, paramLong, paramChar, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "UTMConfig.createCoordinateTuple");
        return new UTMCoordinates(34);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "UTMConfig.setCoordinateSystemParameters");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 34)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 34 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString)
    {
        int i = 1;
        Log.d("GeoTrans", "UTMConfig.setCoordinateSystemParameters via string " + paramString);
        long l2 = 0L;
        long l4 = 0L;
//        paramString = paramString.split(",", -1);
//        StringToVal localStringToVal = new StringToVal();
//        long l1 = l2;
//        long l3 = l4;
//        if (paramString.length == 2)
//            l1 = l2;
//        try
//        {
//            l2 = localStringToVal.stringToInt(paramString[0]);
//            l1 = l2;
//            boolean bool = paramString[1].contains("t");
//            if (bool);
//            while (true)
//            {
//                l3 = i;
//                l1 = l2;
//                paramString = new UTMParameters(34, l1, l3);
//                Log.d("GeoTrans", "UTM Parameters: Zone: " + l1 + " Override: " + l3);
//                this.coordinateSystemParameters = paramString;
//                return;
//                i = 0;
//            }
//        }
//        catch (CoordinateConversionException paramString)
//        {
//            while (true)
//                l3 = l4;
//        }
    }
}