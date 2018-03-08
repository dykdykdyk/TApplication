package geotrans.coordsys;

import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.MGRSorUSNGCoordinates;
import geotrans3.parameters.CoordinateSystemParameters;

public class MgrsConfig extends CoordinateSystemConfig
{
    public MgrsConfig()
    {
        this.coordinateSystemParameters = new CoordinateSystemParameters(19);
    }

    public static CoordinateTuple createMgrsCoordinateTuple(String paramString, int paramInt)
    {
        return new MGRSorUSNGCoordinates(19, paramString, paramInt);
    }

    public CoordinateTuple createCoordinateTuple()
    {
        return new MGRSorUSNGCoordinates(19, this.precision);
    }

    public CoordinateTuple createCoordinateTuple(String paramString)
    {
        return createMgrsCoordinateTuple(paramString, this.precision);
    }

    public void setCoordinateSystemParameters(CoordinateSystemParameters paramCoordinateSystemParameters)
    {
        int i = paramCoordinateSystemParameters.getCoordinateType();
        if (i != 19)
            throw new IllegalArgumentException("Unable to set coordinate system parameters; expected 19 type but was " + i);
        this.coordinateSystemParameters = paramCoordinateSystemParameters;
    }
}