package geotrans.coordsys;

import android.util.Log;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.GeodeticCoordinates;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.misc.StringToVal;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.GeodeticParameters;

public class GeodeticConfig extends CoordinateSystemConfig {
    private final String TAG = "GeoTrans";

    public GeodeticConfig() {
        this.coordinateSystemParameters = new GeodeticParameters(10, 0);
    }

    public static CoordinateTuple createGeodeticCoordinateTuple(double paramDouble1, double paramDouble2, double paramDouble3) {
        return new GeodeticCoordinates(10, paramDouble1, paramDouble2, paramDouble3);
    }

    public CoordinateTuple createCoordinateTuple() {
        return new GeodeticCoordinates(10);
    }

    public CoordinateTuple createCoordinateTuple(double paramDouble1, double paramDouble2, double paramDouble3) {
        return createGeodeticCoordinateTuple(paramDouble1, paramDouble2, paramDouble3);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters) {
        if (!(paramCoordinateSystemParameters instanceof GeodeticParameters))
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected GeodeticParameters class but was " + paramCoordinateSystemParameters.getClass().getSimpleName());
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }

    public void setCoordinateSystemParameters(String paramString) {
        Log.d("GeoTrans", "GeodeticConfig.setCoordinateSystemParameters via string " + paramString);
        StringToVal localStringToVal = new StringToVal();
        String str = paramString;
        try {
            if (paramString.length() == 0)
                str = "0";
            int i = localStringToVal.stringToInt(str);
            this.coordinateSystemParameters = new GeodeticParameters(10, i);
            return;
        } catch (CoordinateConversionException paramStrin) {
            throw new RuntimeException("unable to update height type; caused by " + paramStrin.toString(), paramStrin);
        }
    }
}