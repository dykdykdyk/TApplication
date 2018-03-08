package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;

public class TranMercCoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public TranMercCoordinateModel()
    {
        Log.d("GeoTrans", "TranMercCoordinateModel constructor");
        this.coordinateSystemConfig = new TranMercConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "TransMercCoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        return paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing());
          return "";
    }

    public double getEasting()
    {
        Log.d("GeoTrans", "TranMercCoordinateModel.getEasting");
        return ((MapProjectionCoordinates)this.coordinateTuple).getEasting();
    }

    public double getNorthing()
    {
        Log.d("GeoTrans", "TranMercCoordinateModel.getNorthing");
        return ((MapProjectionCoordinates)this.coordinateTuple).getNorthing();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "TranMercCoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof TranMercConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configuration; expected TranMercConfig configuration but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "TranMercCoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof MapProjectionCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected MapProjectionCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}