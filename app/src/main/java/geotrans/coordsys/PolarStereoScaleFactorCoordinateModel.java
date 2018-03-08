package geotrans.coordsys;

import android.content.Context;
import android.util.Log;

import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MGRSorUSNGCoordinates;

public class PolarStereoScaleFactorCoordinateModel extends CoordinateModel
{
    private final String TAG = "GeoTrans";

    public PolarStereoScaleFactorCoordinateModel()
    {
        this.coordinateSystemConfig = new MgrsConfig();
    }

    public String coordinateString(Context paramContext)
    {
        Log.d("GeoTrans", "MgrsCoordinateModel.coordinateString");
        return getMgrsString();
    }

    public String getMgrsString()
    {
        String str = "";
        MGRSorUSNGCoordinates localMGRSorUSNGCoordinates = (MGRSorUSNGCoordinates)this.coordinateTuple;
        if (localMGRSorUSNGCoordinates != null)
            str = localMGRSorUSNGCoordinates.getCoordinateString();
        return str;
    }

    public void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        if (!(paramCoordinateSystemConfig instanceof MgrsConfig))
            throw new IllegalArgumentException("Unable to set coordinate system configurationexpected MgrsConfig type but was " + paramCoordinateSystemConfig.getClass().getSimpleName());
        this.coordinateSystemConfig = paramCoordinateSystemConfig;
    }

    public void setCoordinateTuple(CoordinateTuple paramCoordinateTuple)
    {
        if ((paramCoordinateTuple != null) && (!(paramCoordinateTuple instanceof MGRSorUSNGCoordinates)))
            throw new IllegalArgumentException("Unable to set coordinate tuple; expected MGRSorUSNGCoordinates coordinate type but was " + paramCoordinateTuple.getClass().getSimpleName());
        this.coordinateTuple = paramCoordinateTuple;
        setChanged();
        notifyObservers();
    }
}