package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.UPSCoordinates;
import geotrans3.parameters.CoordinateSystemParameters;

public class UPSConfig extends CoordinateSystemConfig
{
    private static final String TAG = "GeoTrans";

    public UPSConfig()
    {
        Log.d("GeoTrans", "UPSConfig constructor");
        this.coordinateSystemParameters = new CoordinateSystemParameters(33);
    }

    public static CoordinateTuple createCoordinateTuple(char paramChar, double paramDouble1, double paramDouble2)
    {
        Log.d("GeoTrans", "UPSConfig.createCoordinateTuple(" + paramChar + ", " + paramDouble1 + ", " + paramDouble2 + ")");
        return new UPSCoordinates(33, paramChar, paramDouble1, paramDouble2);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        Log.d("GeoTrans", "UPSConfig.createCoordinateTuple");
        return new UPSCoordinates(33);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        Log.d("GeoTrans", "UPSConfig.setCoordinateSystemParameters");
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 33)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 33 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }
}