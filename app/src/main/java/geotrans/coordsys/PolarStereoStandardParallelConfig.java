package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.PolarStereographicStandardParallelParameters;

public class PolarStereoStandardParallelConfig extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public PolarStereoStandardParallelConfig()
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelConfig constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(26);
    }

    public static CoordinateTuple createCoordinateTuple(double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelConfig.createCoordinateTuple(" + paramDouble1 + ", " + paramDouble2 + ")");
        return new MapProjectionCoordinates(26, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelConfig.createCoordinateTuple");
        return new MapProjectionCoordinates(26);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelConfig.setCoordinateSystemParameters");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 26)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 26 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString)
    {
        Log.d("GeoTrans", "MercatorStandardParallelConfig.setCoordinateSystemParameters via string " + paramString);
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
//            d6 = localStringToVal.stringToLatitude(paramString[1].trim()) / 57.295779513082323D;
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
////            paramString = new PolarStereographicStandardParallelParameters(26, d3, d2, d1, d7);
//            Log.d("GeoTrans", "PolarStereographicStandardParallel Parameters: centralMeridian: " + d3 + " Standard Parallel: " + d2 + " False Easting: " + d1 + " False Northing: " + d7);
////            this.coordinateSystemParameters = paramString;
//            return;
//        }
//        catch (CoordinateConversionException paramString)
//        {
//            while (true)
//                d7 = d8;
//        }
    }
}