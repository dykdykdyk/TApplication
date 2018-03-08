package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.UTMCoordinates;

public class UTMCoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public UTMCoordinateModel()
    {
        Log.d("GeoTrans", "UTMCoordinateModel constructor");
        this.coordinateSystemConfig = new UTMConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "UPSCoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        return getZone() + " " + getHemisphere() + " " + paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing());
          return "";
    }

    public double getEasting()
    {
        Log.d("GeoTrans", "UTMCoordinateModel.getEasting");
        return ((UTMCoordinates)this.coordinateTuple).getEasting();
    }

    public char getHemisphere()
    {
        Log.d("GeoTrans", "UTMCoordinateModel.getHemisphere");
        return ((UTMCoordinates)this.coordinateTuple).getHemisphere();
    }

    public double getNorthing()
    {
        Log.d("GeoTrans", "UTMCoordinateModel.getNorthing");
        return ((UTMCoordinates)this.coordinateTuple).getNorthing();
    }

    public long getZone()
    {
        Log.d("GeoTrans", "UTMCoordinateModel.getZone");
        return ((UTMCoordinates)this.coordinateTuple).getZone();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "UTMCoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof UTMConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configurationexpected UTMConfig type but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "UTMCoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof UTMCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected UTMCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}