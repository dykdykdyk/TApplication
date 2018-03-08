
package jni;

import android.util.Log;

import geotrans.coordsys.CoordinateSystemConfig;
import geotrans3.coordinates.Accuracy;
import geotrans3.coordinates.ConvertResults;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.jni.JNICoordinateConversionService;
import geotrans3.parameters.CoordinateSystemParameters;

/**
 * Created by Administrator on 2018/2/6.
 */


public class JniServiceManager {
    private static final String TAG = "GeoTrans";
    private static CoordinateSystemParameters curDestParameters;
    private static CoordinateSystemParameters curSrcParameters;

    public JniServiceManager()
    {
        Log.d("GeoTrans", "JniServiceManager constructor");
    }

    public static CoordinateTuple convert(CoordinateTuple paramCoordinateTuple, CoordinateSystemConfig paramCoordinateSystemConfig1, CoordinateSystemConfig paramCoordinateSystemConfig2)
            throws CoordinateConversionException
    {
        Log.d("GeoTrans", "JniServiceManager.convert srcTuple  " + paramCoordinateTuple.toString());
        CoordinateTuple localCoordinateTuple = paramCoordinateSystemConfig2.createCoordinateTuple();
        Log.d("GeoTrans", "JniServiceManager.convert destTuple " + localCoordinateTuple.toString());
        try
        {
            Log.d("GeoTrans", "JniServiceManager.convert -- before createService");
            JNICoordinateConversionService localJNICoordinateConversionService = createService(paramCoordinateSystemConfig1, paramCoordinateSystemConfig2);
            Log.d("GeoTrans", "JniServiceManager.convert -- after createService");
            paramCoordinateTuple = convert(localJNICoordinateConversionService, paramCoordinateTuple, localCoordinateTuple);
            Log.d("GeoTrans", "JniServiceManager.convert --dest tuple result: " + paramCoordinateTuple.toString());
            curSrcParameters = localJNICoordinateConversionService.getCoordinateSystem(0);
            curDestParameters = localJNICoordinateConversionService.getCoordinateSystem(1);
            paramCoordinateSystemConfig1.setCoordinateSystemParameters(curSrcParameters);
            paramCoordinateSystemConfig2.setCoordinateSystemParameters(curDestParameters);
            Log.d("GeoTrans", "JniServiceManager.convert -- src and dest parameters received");
            return paramCoordinateTuple;
        }
        catch (Throwable t)
        {
            Log.e("GeoTrans", "JniServiceManager.convert -- JNI failed", t);
            throw new CoordinateConversionException(t.getMessage());
        }

    }

    public static CoordinateTuple convert(JNICoordinateConversionService paramJNICoordinateConversionService, CoordinateTuple paramCoordinateTuple1, CoordinateTuple paramCoordinateTuple2)
            throws CoordinateConversionException
    {
        Log.d("GeoTrans", "JniServiceManager.convert jniService, src, dest");
        Accuracy localAccuracy1 = new Accuracy(-1.0D, -1.0D, -1.0D);
        Accuracy localAccuracy2 = new Accuracy();
        try
        {
            ConvertResults targetCoordinates = paramJNICoordinateConversionService.convertSourceToTarget(paramCoordinateTuple1, localAccuracy1, paramCoordinateTuple2, localAccuracy2);
            CoordinateTuple targetCoordin  = targetCoordinates.getCoordinateTuple();
            Log.d("GeoTrans", "dest tuple result: " + paramJNICoordinateConversionService.toString());
            return targetCoordin;
        }
        catch (Throwable throwable)
        {
            Log.e("GeoTrans", "JNI convertSourceToTarget failed", throwable);
            throw new CoordinateConversionException(throwable.getMessage());
        }
    }

    public static JNICoordinateConversionService createService(CoordinateSystemConfig paramCoordinateSystemConfig1, CoordinateSystemConfig paramCoordinateSystemConfig2)
            throws CoordinateConversionException
    {
        Log.d("GeoTrans", "JniServiceManager.createService");
        Log.d("GeoTrans", "JniServiceManager.createService 1");
        Log.d("GeoTrans", "JniServiceManager.createService -- gettint Datums");
        String str1 = paramCoordinateSystemConfig1.getDatum();
        String str2 = paramCoordinateSystemConfig2.getDatum();
        Log.d("GeoTrans", "JniServiceManager.createService -- srcDatum " + str1 + " destDatum " + str2);
        CoordinateSystemParameters  paramCoordinateSystemParameters1 = paramCoordinateSystemConfig1.getCoordinateSystemParameters();
        Log.d("GeoTrans", "JniServiceManager.createService -- srcCoordSysParams " + paramCoordinateSystemConfig1.toString());
        CoordinateSystemParameters  paramCoordinateSystemParameters2 = paramCoordinateSystemConfig2.getCoordinateSystemParameters();
        Log.d("GeoTrans", "JniServiceManager.createService -- destCoordSysParams " + paramCoordinateSystemConfig2.toString());
        try
        {
            Log.d("GeoTrans", "JniServiceManager.createService -- new JNICoordinateConversionService");
            JNICoordinateConversionService    service = new JNICoordinateConversionService(str1, paramCoordinateSystemParameters1, str2, paramCoordinateSystemParameters2);
            Log.d("GeoTrans", "JniServiceManager.createService -- JNICoordinateConversionService created");
            return service;
        }
        catch (Throwable throwable)
        {
            Log.e("GeoTrans", "Cannot create JNI Conversion Service", throwable);
            throw new CoordinateConversionException(throwable.getMessage());
        }

    }
}
