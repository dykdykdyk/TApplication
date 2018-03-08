# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             native-lib
             # Sets the library as a shared library.
             SHARED
             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp
             src/main/cpp/fiomeths.cpp
             src/main/cpp/JNICCSObjectTranslator.cpp
             src/main/cpp/JNICoordinateConversionService.cpp
             src/main/cpp/JNIDatumLibrary.cpp
             src/main/cpp/JNIEllipsoidLibrary.cpp
             src/main/cpp/strtoval.cpp
             src/main/cpp/ThrowException.cpp
             src/main/cpp/DatumLibrary.cpp

             src/main/cpp/Accuracy.cpp
             src/main/cpp/AlbersEqualAreaConic.cpp
             src/main/cpp/AzimuthalEquidistant.cpp
             src/main/cpp/BNGCoordinates.cpp
             src/main/cpp/Bonne.cpp
             src/main/cpp/BritishNationalGrid.cpp
             src/main/cpp/CartesianCoordinates.cpp
             src/main/cpp/Cassini.cpp
             src/main/cpp/CCSThreadLock.cpp
             src/main/cpp/CCSThreadMutex.cpp
             src/main/cpp/CoordinateConversionService.cpp
             src/main/cpp/CoordinateSystem.cpp
             src/main/cpp/CoordinateSystemParameters.cpp
             src/main/cpp/CoordinateTuple.cpp
             src/main/cpp/Datum.cpp
             src/main/cpp/DatumLibrary.cpp
             src/main/cpp/DatumLibraryImplementation.cpp
             src/main/cpp/Eckert4.cpp
             src/main/cpp/Eckert6.cpp
             src/main/cpp/egm2008_aoi_grid_package.cpp
             src/main/cpp/egm2008_full_grid_package.cpp
             src/main/cpp/egm2008_geoid_grid.cpp
             src/main/cpp/Ellipsoid.cpp
             src/main/cpp/EllipsoidLibrary.cpp
             src/main/cpp/EllipsoidLibraryImplementation.cpp
             src/main/cpp/EllipsoidParameters.cpp
             src/main/cpp/EquidistantCylindrical.cpp
             src/main/cpp/EquidistantCylindricalParameters.cpp
             src/main/cpp/ErrorMessages.cpp
             src/main/cpp/fiomeths.cpp
             src/main/cpp/GARS.cpp
             src/main/cpp/MapProjection3Parameters.cpp
             src/main/cpp/MapProjection4Parameters.cpp
             src/main/cpp/MapProjection5Parameters.cpp
             src/main/cpp/GARSCoordinates.cpp
             src/main/cpp/Geocentric.cpp
             src/main/cpp/GeodeticCoordinates.cpp
             src/main/cpp/GeodeticParameters.cpp
             src/main/cpp/GeoidLibrary.cpp
             src/main/cpp/GEOREF.cpp
             src/main/cpp/GEOREFCoordinates.cpp
             src/main/cpp/Gnomonic.cpp
             src/main/cpp/JNICCSObjectTranslator.cpp
             src/main/cpp/JNICoordinateConversionService.cpp
             src/main/cpp/JNIDatumLibrary.cpp
             src/main/cpp/JNIEllipsoidLibrary.cpp
             src/main/cpp/JNIFiomeths.cpp
             src/main/cpp/LambertConformalConic.cpp
             src/main/cpp/LocalCartesian.cpp
             src/main/cpp/LocalCartesianParameters.cpp
             src/main/cpp/MapProjectionCoordinates.cpp
             src/main/cpp/Mercator.cpp
             src/main/cpp/MercatorScaleFactorParameters.cpp
             src/main/cpp/MapProjection6Parameters.cpp
             src/main/cpp/MercatorStandardParallelParameters.cpp
             src/main/cpp/MGRS.cpp
             src/main/cpp/MGRSorUSNGCoordinates.cpp
             src/main/cpp/MillerCylindrical.cpp
             src/main/cpp/Mollweide.cpp
             src/main/cpp/NeysParameters.cpp
             src/main/cpp/Neys.cpp
             src/main/cpp/NZMG.cpp
             src/main/cpp/ObliqueMercator.cpp
             src/main/cpp/ObliqueMercatorParameters.cpp
             src/main/cpp/Orthographic.cpp
             src/main/cpp/PolarStereographic.cpp
             src/main/cpp/PolarStereographicScaleFactorParameters.cpp

             src/main/cpp/PolarStereographicStandardParallelParameters.cpp
             src/main/cpp/Polyconic.cpp
             src/main/cpp/SevenParameterDatum.cpp
             src/main/cpp/Sinusoidal.cpp
             src/main/cpp/Stereographic.cpp
             src/main/cpp/strtoval.cpp
             src/main/cpp/ThreeParameterDatum.cpp
             src/main/cpp/ThrowException.cpp
             src/main/cpp/TransverseCylindricalEqualArea.cpp
             src/main/cpp/CylindricalEqualArea.cpp
             src/main/cpp/TransverseMercator.cpp
             src/main/cpp/UPS.cpp
             src/main/cpp/UPSCoordinates.cpp
             src/main/cpp/USNG.cpp
             src/main/cpp/UTM.cpp
             src/main/cpp/UTMCoordinates.cpp
             src/main/cpp/UTMParameters.cpp
             src/main/cpp/VanDerGrinten.cpp
             src/main/cpp/WarningMessages.cpp
             src/main/cpp/WebMercator.cpp
              )
# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )