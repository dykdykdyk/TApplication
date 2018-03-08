package geotrans.coordsys;

import android.content.Context;
import android.util.Log;

import geotrans3.coordinates.CoordinateTuple;
import java.util.Observable;

public abstract class CoordinateModel extends Observable
{
    private static final String PACKAGE_DELIMITER = ".";
    private String TAG = "GeoTrans";
    protected CoordinateSystemConfig coordinateSystemConfig = null;
    protected CoordinateTuple coordinateTuple = null;

    public static CoordinateModel createCoordinateModel(String paramString)
    {
        try
        {
            CoordinateModel localCoordinateModel = (CoordinateModel)Class.forName(CoordinateModel.class.getPackage().getName() + "." + paramString + "CoordinateModel").newInstance();
            return localCoordinateModel;
        }
        catch (Throwable localThrowable)
        {
            throw new RuntimeException("Cannot create coordinate model '" + paramString + "'" + " due to " + localThrowable.toString(), localThrowable);
        }
    }

    public String coordinateString(Context paramContext)
    {
        Log.d(this.TAG, "CoordinateModel.coordinateString");
        return getCoordinateTuple().toString();
    }

    public String coordinateString(Context paramContext, CoordinateSystemConfig paramCoordinateSystemConfig)
    {
        return coordinateString(paramContext);
    }

    public CoordinateSystemConfig getCoordinateSystemConfig()
    {
        return this.coordinateSystemConfig;
    }

    public CoordinateTuple getCoordinateTuple()
    {
        return this.coordinateTuple;
    }

    public abstract void setCoordinateSystemConfig(CoordinateSystemConfig paramCoordinateSystemConfig);

    public abstract void setCoordinateTuple(CoordinateTuple paramCoordinateTuple);
}