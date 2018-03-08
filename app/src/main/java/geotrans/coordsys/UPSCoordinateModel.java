package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.UPSCoordinates;

public class UPSCoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public UPSCoordinateModel()
    {
        Log.d("GeoTrans", "UPSCoordinateModel constructor");
        this.coordinateSystemConfig = new UPSConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "UPSCoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        return getHemisphere() + " " + paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing());
          return "";
    }

    public double getEasting()
    {
        Log.d("GeoTrans", "UPSCoordinateModel.getEasting");
        return ((UPSCoordinates)this.coordinateTuple).getEasting();
    }

    public char getHemisphere()
    {
        Log.d("GeoTrans", "UPSCoordinateModel.getHemisphere");
        return ((UPSCoordinates)this.coordinateTuple).getHemisphere();
    }

    public double getNorthing()
    {
        Log.d("GeoTrans", "UPSCoordinateModel.getNorthing");
        return ((UPSCoordinates)this.coordinateTuple).getNorthing();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "UPSCoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof UPSConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configurationexpected UPSConfig type but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "UPSCoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof UPSCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected UPSCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}