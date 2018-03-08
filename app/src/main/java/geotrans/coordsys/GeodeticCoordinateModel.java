package geotrans.coordsys;

import android.content.Context;
import android.util.Log;

//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.GeodeticCoordinates;
import geotrans3.exception.CoordinateConversionException;

public class GeodeticCoordinateModel extends CoordinateModel
{
    private final String TAG = "GeoTrans";

    public GeodeticCoordinateModel()
    {
        this.coordinateSystemConfig = new GeodeticConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "Lambert1CoordinateModel.coordinateString");
//        StrToVal  param = new StrToVal(paramContext);
        Log.d("GeoTrans", "Lambert1CoordinateModel.coordinateString strToVal created");
//        try
//        {
//            paramContext = param.latitudeToString(getLatitudeDecimalDegrees()) + ", " + paramContext.longitudeToString(getLongitudeDecimalDegrees()) + ", " + paramContext.meterToString(getHeight());
//            return paramContext;
//        }
//        catch (CoordinateConversionException paramContext)
//        {
//        }
        return getLatitudeDecimalDegrees() + " " + getLongitudeDecimalDegrees() + " " + getHeight();
    }

    public double getHeight()
    {
        return ((GeodeticCoordinates)this.coordinateTuple).getHeight();
    }

    public double getLatitudeDecimalDegrees()
    {
        return getLatitudeRadians() * 57.295779513082323D;
    }

    public double getLatitudeRadians()
    {
        return ((GeodeticCoordinates)this.coordinateTuple).getLatitude();
    }

    public double getLongitudeDecimalDegrees()
    {
        return getLongitudeRadians() * 57.295779513082323D;
    }

    public double getLongitudeRadians()
    {
        return ((GeodeticCoordinates)this.coordinateTuple).getLongitude();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        if (!(paramCoordinateSystemConfig instanceof GeodeticConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configuration; expected GeodeticConfig configuration but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof GeodeticCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected GeodeticCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}