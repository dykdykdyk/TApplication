package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.parameters.MercatorStandardParallelParameters;

public class MercatorStandardParallelCoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public MercatorStandardParallelCoordinateModel()
    {
        Log.d("GeoTrans", "MercatorStandardParallelCoordinateModel constructor");
        this.coordinateSystemConfig = new MercatorStandardParallelConfig();
    }

    public String coordinateString(Context paramContext, CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "MercatorStandardParallelCoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        paramCoordinateSystemConfig = paramContext.doubleToString(((MercatorStandardParallelParameters)paramCoordinateSystemConfig.getCoordinateSystemParameters()).getScaleFactor(), 5);
//        return paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing()) + " " + paramCoordinateSystemConfig;
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
        Log.d("GeoTrans", "MercatorStandardParallelCoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof MercatorStandardParallelConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configuration; expected MercatorStandardParallelConfig configuration but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "MercatorStandardParallelCoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof MapProjectionCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected MapProjectionCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}