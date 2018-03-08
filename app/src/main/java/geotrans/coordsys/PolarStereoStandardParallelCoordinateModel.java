package geotrans.coordsys;

import android.content.Context;
import android.util.Log;
//import geotrans.android.util.StrToVal;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MapProjectionCoordinates;

public class PolarStereoStandardParallelCoordinateModel extends CoordinateModel
{
    private static final String TAG = "GeoTrans";

    public PolarStereoStandardParallelCoordinateModel()
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelCoordinateModel constructor");
        this.coordinateSystemConfig = new PolarStereoStandardParallelConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelCoordinateModel.coordinateString");
//        paramContext = new StrToVal(paramContext);
//        return paramContext.meterToString(getEasting()) + " " + paramContext.meterToString(getNorthing());
          return "";
    }

    public double getEasting()
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelCoordinateModel.getEasting");
        return ((MapProjectionCoordinates)this.coordinateTuple).getEasting();
    }

    public double getNorthing()
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelCoordinateModel.getNorthing");
        return ((MapProjectionCoordinates)this.coordinateTuple).getNorthing();
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelCoordinateModel.setCoordinateSystemConfig");
        if (!(paramCoordinateSystemConfig instanceof PolarStereoStandardParallelConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configuration; expected PolarStereoStandardParallelConfig configuration but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        Log.d("GeoTrans", "PolarStereoStandardParallelCoordinateModel.setCoordinateTuple(tuple)");
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof MapProjectionCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected MapProjectionCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}