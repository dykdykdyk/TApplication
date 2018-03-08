package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;

public class MercatorScaleFactorCoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public MercatorScaleFactorCoordinateModel()
    {
        Log.d("GeoTrans", "MercatorScaleFactorCoordinateModel constructor");
        this.coordinateSystemConfig = new MercatorScaleFactorConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "MercatorScaleFactorCoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        return paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing());
          return "";
    }

    public double getEasting()
    {
        Log.d("GeoTrans", "MercatorScaleFactorCoordinateModel.getEasting");
        return ((MapProjectionCoordinates)this.coordinateTuple).getEasting();
    }

    public double getNorthing()
    {
        Log.d("GeoTrans", "MercatorScaleFactorCoordinateModel.getNorthing");
        return ((MapProjectionCoordinates)this.coordinateTuple).getNorthing();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "MercatorScaleFactorCoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof MercatorScaleFactorConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configurationexpected MercatorScaleFactorConfig type but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "MercatorScaleFactorCoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof MapProjectionCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected MapProjectionCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}