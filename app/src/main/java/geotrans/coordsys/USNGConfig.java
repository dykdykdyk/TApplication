package geotrans.coordsys;

import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MGRSorUSNGCoordinates;
import geotrans3.parameters.CoordinateSystemParameters;

public class USNGConfig extends CoordinateSystemConfig
{
    public USNGConfig()
    {
        this.coordinateSystemParameters = new CoordinateSystemParameters(35);
    }

    public static CoordinateTuple createUSNGCoordinateTuple(String paramString, int paramInt)
    {
        return new MGRSorUSNGCoordinates(35, paramString, paramInt);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        return new MGRSorUSNGCoordinates(35, this.precision);
    }

    public CoordinateTuple createCoordinateTuple(String paramString)
    {
        return createUSNGCoordinateTuple(paramString, this.precision);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 35)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 35 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }
}