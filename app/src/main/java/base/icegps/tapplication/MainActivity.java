package base.icegps.tapplication;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import geotrans.coordsys.CoordinateSystemConfig;
import geotrans.coordsys.GeodeticConfig;
import geotrans.coordsys.UTMConfig;
import geotrans3.coordinates.Accuracy;
import geotrans3.coordinates.BNGCoordinates;
import geotrans3.coordinates.CartesianCoordinates;
import geotrans3.coordinates.ConvertResults;
import geotrans3.coordinates.CoordinateTuple;
import geotrans3.coordinates.GARSCoordinates;
import geotrans3.coordinates.GEOREFCoordinates;
import geotrans3.coordinates.GeodeticCoordinates;
import geotrans3.coordinates.MGRSorUSNGCoordinates;
import geotrans3.coordinates.MapProjectionCoordinates;
import geotrans3.coordinates.UPSCoordinates;
import geotrans3.coordinates.UTMCoordinates;
import geotrans3.enumerations.CoordinateType;
import geotrans3.enumerations.DatumType;
import geotrans3.enumerations.HeightType;
import geotrans3.enumerations.SourceOrTarget;
import geotrans3.exception.CoordinateConversionException;
import geotrans3.exception.ErrorMessages;
import geotrans3.jni.JNICoordinateConversionService;
import geotrans3.jni.JNIDatumLibrary;
import geotrans3.jni.JNIEllipsoidLibrary;
import geotrans3.jni.JNIFiomeths;
import geotrans3.misc.Info;
import geotrans3.parameters.CoordinateSystemParameters;
import geotrans3.parameters.EquidistantCylindricalParameters;
import geotrans3.parameters.GeodeticParameters;
import geotrans3.parameters.LocalCartesianParameters;
import geotrans3.parameters.MapProjection3Parameters;
import geotrans3.parameters.MapProjection4Parameters;
import geotrans3.parameters.MapProjection5Parameters;
import geotrans3.parameters.MapProjection6Parameters;
import geotrans3.parameters.MercatorScaleFactorParameters;
import geotrans3.parameters.MercatorStandardParallelParameters;
import geotrans3.parameters.NeysParameters;
import geotrans3.parameters.ObliqueMercatorParameters;
import geotrans3.parameters.PolarStereographicScaleFactorParameters;
import geotrans3.parameters.PolarStereographicStandardParallelParameters;
import geotrans3.parameters.UTMParameters;
import jni.JniServiceManager;

import static java.lang.Math.PI;

public class MainActivity extends AppCompatActivity {
 ///storage/emulated/0/icegps/ellips.dat
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.show_result)
    TextView showResult;
    @BindView(R.id.create_service)
    Button createService;
    @BindView(R.id.convert)
    Button convert;

    /**
     *
     * @param savedInstanceState
     * UTM coordinates consist of a zone number in the range from 1 to 60
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Backup();
//        MGRSTOUTM();
//        UTMTOMGRS();
        //普通经纬度坐标转换utm
//        StandtoUTM();
        //普通经纬度坐标转换国家2000
//        StandtoCGCS2000();

        /*
        * Datum PUK:PULKOVO 1942,Russia (克拉索夫斯基椭球)
        * 投影方式:高斯-克吕格投影(横向墨卡托投影 TM)
        * */
        //北京54

//        File file =new File(Environment.getExternalStorageDirectory().getPath() + "/" + "icegps"+"/ellips.dat");
//        Log.i("TAG",":::"+Environment.getExternalStorageDirectory().getPath() + "/" + "icegps"+"/ellips.dat");
//        try {
//            FileOutputStream fileOutputStream =new FileOutputStream(file);
//            try {
//                fileOutputStream.write("11111111111111111111111111111111111111111111111".getBytes());
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        StandtoBEIJING54();
    }

    private void StandtoBEIJING54() {
        //int coordinateType, double _longitude, double _latitude, double _height
        /**
         *   ellipsoid 椭球
         datum 基准面(椭球) CoordinateTuple
         CoordinateSystemConfig 投影方式

         Coordinate Tuple 坐标元祖
         */
        /**
         * GeodeticCoordinates
         */

        double PI_OVER_180 = (PI / 180.0);
        double _longitude=114.24359067;
        double _latitude=22.70475300;
        double height=60.857575757;

        CoordinateSystemParameters sourceParameters = new GeodeticParameters(CoordinateType.GEODETIC, HeightType.NO_HEIGHT);
        CoordinateSystemParameters targetParameters = new MapProjection5Parameters(CoordinateType.TRANMERC,117.0*PI_OVER_180,0,1
                ,500000,0);
        JNICoordinateConversionService jniCoordinateConversionService =null;
        try {
            jniCoordinateConversionService  = new JNICoordinateConversionService("WGE", sourceParameters, "WGE", targetParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //一.创建ellipsoid(椭球)
        //创建JNIEllipsoidLibrary
        JNIEllipsoidLibrary jniEllipsoidLibrary = null;
        try {
            jniEllipsoidLibrary =new JNIEllipsoidLibrary(jniCoordinateConversionService.getEllipsoidLibrary());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
        //写死参数 默认 北京54参数
        /*
        参数意义
          1.ellipsoidCode code
          2.ellipsoidName Name
          3.semiMajorAxis 半轴长
          4. invFlattening 扁率
         */
        try {
            jniEllipsoidLibrary.defineEllipsoid("BJ",
                    "BJ1954",
                    6378245, 1/298.3);
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
        //二.创建Datum(参考平面)
        JNIDatumLibrary jniDatumLibrary = null;
        try {
            jniDatumLibrary = new JNIDatumLibrary(jniCoordinateConversionService.getDatumLibrary());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
        try {
            jniDatumLibrary.defineDatum(DatumType.threeParamDatum, "BJ", "CHINA BeiJing 1954",
                    "BJ: BJ1954",
                    0, 0, 0, -1, -1, -1,
                    //后面两排 固定值
                    179.9999998*PI_OVER_180, 179.9999999*PI_OVER_180, 89.9999998*PI_OVER_180, 89.9999999*PI_OVER_180,
                    0.0, 0.0, 0.0, 0.0);
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
        //重新赋值
        try {
            JNICoordinateConversionService tempJNICoordinateConversionService = new JNICoordinateConversionService("WGE", sourceParameters, "BJ", targetParameters);
            if(jniCoordinateConversionService != null)
                jniCoordinateConversionService.destroy();
            jniCoordinateConversionService  = tempJNICoordinateConversionService;
        } catch (Exception e) {
            e.printStackTrace();
        }
        CoordinateTuple coordinateTuple =new GeodeticCoordinates(CoordinateType.GEODETIC,_longitude *PI_OVER_180,_latitude *PI_OVER_180,height);
        CoordinateTuple resultTuple =new MapProjectionCoordinates(CoordinateType.TRANMERC);
        Accuracy targetAccuracy = new Accuracy();

        try {
            ConvertResults convertResults = jniCoordinateConversionService.convertSourceToTarget(coordinateTuple, targetAccuracy,
                    resultTuple, targetAccuracy);

            resultTuple = convertResults.getCoordinateTuple();
            targetAccuracy = convertResults.getAccuracy();

            MapProjectionCoordinates u= (MapProjectionCoordinates) convertResults.getCoordinateTuple();
            String  warningMessage = resultTuple.getWarningMessage();
            String   errorMessage = resultTuple.getErrorMessage();
            Log.i("TAG","warningMessage:"+warningMessage+",errorMessage:"+errorMessage);
            Log.e("TAG","Easting:"+u.getEasting()+",Northing:"+u.getNorthing());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
    }

    private void StandtoCGCS2000() {
        //int coordinateType, double _longitude, double _latitude, double _height
        /**
         *   ellipsoid 椭球
         datum 基准面(椭球) CoordinateTuple
         CoordinateSystemConfig 投影方式

         Coordinate Tuple 坐标元祖
         */
        /**
         * GeodeticCoordinates
         */

        double PI_OVER_180 = (PI / 180.0);
        double _longitude=114.2544978287;
        double _latitude=22.7075493478;
        double height=60.857575757;

        CoordinateSystemParameters sourceParameters = new GeodeticParameters(CoordinateType.GEODETIC, HeightType.NO_HEIGHT);
        CoordinateSystemParameters targetParameters = new MapProjection5Parameters(CoordinateType.TRANMERC,117.0*PI_OVER_180,0,1
        ,500000,0);
        JNICoordinateConversionService jniCoordinateConversionService =null;
        try {
            jniCoordinateConversionService  = new JNICoordinateConversionService("WGE", sourceParameters, "WGE", targetParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CoordinateTuple coordinateTuple =new GeodeticCoordinates(CoordinateType.GEODETIC,_longitude *PI_OVER_180,_latitude *PI_OVER_180,height);
        CoordinateTuple resultTuple =new MapProjectionCoordinates(CoordinateType.TRANMERC);
        Accuracy targetAccuracy = new Accuracy();

        try {
            ConvertResults convertResults = jniCoordinateConversionService.convertSourceToTarget(coordinateTuple, targetAccuracy,
                    resultTuple, targetAccuracy);

            resultTuple = convertResults.getCoordinateTuple();
            targetAccuracy = convertResults.getAccuracy();

            MapProjectionCoordinates u= (MapProjectionCoordinates) convertResults.getCoordinateTuple();
            String  warningMessage = resultTuple.getWarningMessage();
            String   errorMessage = resultTuple.getErrorMessage();
            Log.i("TAG","warningMessage:"+warningMessage+",errorMessage:"+errorMessage);
            Log.e("TAG","Easting:"+u.getEasting()+",Northing:"+u.getNorthing());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
    }

    private void StandtoUTM() {
        //int coordinateType, double _longitude, double _latitude, double _height
        /**
         *   ellipsoid 椭球
         datum 基准面(椭球) CoordinateTuple
         CoordinateSystemConfig 投影方式

         Coordinate Tuple 坐标元祖
         */
        /**
         * GeodeticCoordinates
         */

        double PI_OVER_180 = (PI / 180.0);
        //114 14 37 .5024  114+14/60+37.5024/3600  0.23333333333  114.2437506633633
        // 22 42 16.8336   22+42/60+16.8336/3600  22.704676
        double _longitude=114.2437506633633;
        double _latitude=22.704676;
        double height=60.857575757;

        CoordinateSystemParameters sourceParameters = new GeodeticParameters(CoordinateType.GEODETIC, HeightType.NO_HEIGHT);
        CoordinateSystemParameters targetParameters = new UTMParameters(CoordinateType.UTM,31,0);
        JNICoordinateConversionService jniCoordinateConversionService =null;
        try {
            jniCoordinateConversionService  = new JNICoordinateConversionService("WGE", sourceParameters, "WGE", targetParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CoordinateTuple coordinateTuple =new GeodeticCoordinates(CoordinateType.GEODETIC,_longitude *PI_OVER_180,_latitude *PI_OVER_180,height);
        CoordinateTuple resultTuple =new UTMCoordinates(CoordinateType.UTM);
        Accuracy targetAccuracy = new Accuracy();

        try {
            ConvertResults convertResults = jniCoordinateConversionService.convertSourceToTarget(coordinateTuple, targetAccuracy,
                    resultTuple, targetAccuracy);

            resultTuple = convertResults.getCoordinateTuple();
            targetAccuracy = convertResults.getAccuracy();

            UTMCoordinates u= (UTMCoordinates) convertResults.getCoordinateTuple();
            String  warningMessage = resultTuple.getWarningMessage();
            String   errorMessage = resultTuple.getErrorMessage();
            Log.i("TAG","warningMessage:"+warningMessage+",errorMessage:"+errorMessage);
            Log.e("TAG","Easting:"+u.getEasting()+",Northing:"+u.getNorthing());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
    }

    private void UTMTOMGRS() {
        double PI_OVER_180 = (PI / 180.0);
        double _longitude=114.2544978287;
        double _latitude=22.7075493478;
        double height=60.857575757;
        CoordinateSystemParameters sourceParameters = new UTMParameters(CoordinateType.UTM,31,0);
        CoordinateSystemParameters targetParameters = new CoordinateSystemParameters(CoordinateType.MGRS);

        JNICoordinateConversionService jniCoordinateConversionService =null;
        try {
            jniCoordinateConversionService  = new JNICoordinateConversionService("WGE", sourceParameters, "EUR-7", targetParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CoordinateTuple coordinateTuple =new UTMCoordinates(CoordinateType.UTM);
        CoordinateTuple resultTuple =new MGRSorUSNGCoordinates(CoordinateType.MGRS);

        Accuracy targetAccuracy = new Accuracy();

        try {
            ConvertResults convertResults = jniCoordinateConversionService.convertSourceToTarget(coordinateTuple, targetAccuracy,
                    resultTuple, targetAccuracy);

            resultTuple = convertResults.getCoordinateTuple();
            targetAccuracy = convertResults.getAccuracy();

            MGRSorUSNGCoordinates u= (MGRSorUSNGCoordinates) convertResults.getCoordinateTuple();
            String  warningMessage = resultTuple.getWarningMessage();
            String   errorMessage = resultTuple.getErrorMessage();
            Log.i("TAG","warningMessage:"+warningMessage+",errorMessage:"+errorMessage);
            Log.e("TAG","Easting:"+u.getCoordinateString());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
    }

    private void MGRSTOUTM() {
        double PI_OVER_180 = (PI / 180.0);
        double _longitude=114.2544978287;
        double _latitude=22.7075493478;
        double height=60.857575757;
        CoordinateSystemParameters sourceParameters = new CoordinateSystemParameters(CoordinateType.MGRS);
        CoordinateSystemParameters targetParameters = new UTMParameters(CoordinateType.UTM,31,0);
        JNICoordinateConversionService jniCoordinateConversionService =null;
        try {
            jniCoordinateConversionService  = new JNICoordinateConversionService("WGE", sourceParameters, "WGE", targetParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CoordinateTuple coordinateTuple =new MGRSorUSNGCoordinates(CoordinateType.MGRS,"31NEA0055550000",80);
        CoordinateTuple resultTuple =new UTMCoordinates(CoordinateType.UTM);
        Accuracy targetAccuracy = new Accuracy();
        try {
            ConvertResults convertResults = jniCoordinateConversionService.convertSourceToTarget(coordinateTuple, targetAccuracy,
                    resultTuple, targetAccuracy);

            resultTuple = convertResults.getCoordinateTuple();
            targetAccuracy = convertResults.getAccuracy();

            UTMCoordinates u= (UTMCoordinates) convertResults.getCoordinateTuple();
            String  warningMessage = resultTuple.getWarningMessage();
            String   errorMessage = resultTuple.getErrorMessage();
            Log.i("TAG","warningMessage:"+warningMessage+",errorMessage:"+errorMessage);
            Log.e("TAG","Easting:"+u.getEasting());
            Log.e("TAG","getNorthing:"+u.getNorthing());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
    }

    private void Backup() {
        //int coordinateType, double _longitude, double _latitude, double _height
        /**
         *   ellipsoid 椭球
         datum 基准面(椭球) CoordinateTuple
         CoordinateSystemConfig 投影方式

         Coordinate Tuple 坐标元祖
         */
        /**
         * GeodeticCoordinates
         */

        double PI_OVER_180 = (PI / 180.0);
        double _longitude=114.2544978287;
        double _latitude=22.7075493478;
        double height=60.857575757;

        CoordinateSystemParameters sourceParameters = new GeodeticParameters(CoordinateType.GEODETIC, HeightType.NO_HEIGHT);
        CoordinateSystemParameters targetParameters = new UTMParameters(CoordinateType.UTM,31,0);
        JNICoordinateConversionService jniCoordinateConversionService =null;
        try {
             jniCoordinateConversionService  = new JNICoordinateConversionService("WGE", sourceParameters, "EUR-7", targetParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CoordinateTuple coordinateTuple =new GeodeticCoordinates(CoordinateType.GEODETIC,_longitude *PI_OVER_180,_latitude *PI_OVER_180,height);
        CoordinateTuple resultTuple =new UTMCoordinates(CoordinateType.UTM);
        Accuracy targetAccuracy = new Accuracy();

        try {
            ConvertResults convertResults = jniCoordinateConversionService.convertSourceToTarget(coordinateTuple, targetAccuracy,
                            resultTuple, targetAccuracy);

            resultTuple = convertResults.getCoordinateTuple();
            targetAccuracy = convertResults.getAccuracy();

            UTMCoordinates u= (UTMCoordinates) convertResults.getCoordinateTuple();
            String  warningMessage = resultTuple.getWarningMessage();
            String   errorMessage = resultTuple.getErrorMessage();
            Log.i("TAG","warningMessage:"+warningMessage+",errorMessage:"+errorMessage);
            Log.e("TAG","Easting:"+u.getEasting()+",Northing:"+u.getNorthing());
        } catch (CoordinateConversionException e) {
            e.printStackTrace();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @OnClick({R.id.create_service, R.id.convert})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create_service:

                break;
            case R.id.convert:

                break;
        }
    }
}
