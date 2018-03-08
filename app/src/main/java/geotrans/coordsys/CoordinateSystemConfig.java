package geotrans.coordsys;

import geotrans3.coordinates.CoordinateTuple;
import geotrans3.parameters.CoordinateSystemParameters;

public abstract class CoordinateSystemConfig
{
    public static final String DEFAULT_DATUM = "WGE";
    public static int DEFAULT_PRECISION = 5;
    protected CoordinateSystemParameters coordinateSystemParameters = null;
    protected String datum = "WGE";
    protected int precision = DEFAULT_PRECISION;

    public abstract CoordinateTuple createCoordinateTuple();

    public CoordinateSystemParameters getCoordinateSystemParameters()
    {
        return this.coordinateSystemParameters;
    }

    public String getDatum()
    {
        return this.datum;
    }

    public int getPrecision()
    {
        return this.precision;
    }

    public abstract void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters);

    public void setCoordinateSystemParameters(String paramString)
    {
    }

    public void setDatum(String paramString)
    {
        this.datum = paramString;
    }

    public void setPrecision(int paramInt)
    {
        if ((paramInt < 0) || (paramInt > 8))
            throw new IllegalStateException("Cannot set Geodetic coordinate system parameters to non-Geodetic parameters");
        this.precision = paramInt;
    }
}