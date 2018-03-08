package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;

public class Lambert2CoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public Lambert2CoordinateModel()
    {
        Log.d("GeoTrans", "Lambert2CoordinateModel constructor");
        this.coordinateSystemConfig = new Lambert2Config();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "Lambert2CoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        return paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing());
        return "";
    }

    public double getEasting()
    {
        Log.d("GeoTrans", "Lambert2CoordinateModel.getEasting");
        return ((MapProjectionCoordinates)this.coordinateTuple).getEasting();
    }

    public double getNorthing()
    {
        Log.d("GeoTrans", "Lambert2CoordinateModel.getNorthing");
        return ((MapProjectionCoordinates)this.coordinateTuple).getNorthing();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "Lambert2CoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof Lambert2Config))
            throw new IllegalArgumentException("Unable to set coordinate system configuration; expected Lambert2Config configuration but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "Lambert2CoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof MapProjectionCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected MapProjectionCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}