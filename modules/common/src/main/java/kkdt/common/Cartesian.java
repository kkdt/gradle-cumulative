package kkdt.common;

import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.geography.coordinates.Altitude;
import org.jscience.geography.coordinates.LatLong;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.geography.coordinates.crs.CoordinatesConverter;

public class Cartesian {
   private static final CoordinatesConverter<XYZ, Altitude> altitudeConverter = 
      XYZ.CRS.getConverterTo(Altitude.CRS);
   private static final CoordinatesConverter<XYZ, LatLong> latLonConverter = 
      XYZ.CRS.getConverterTo(LatLong.CRS);
   
   private Unit<Length> unit = SI.METER;
   private XYZ geocentric;
   private LatLong latLon;
   private Altitude altitude;
   
   public Cartesian() {
      geocentric = XYZ.valueOf(0,0,0, SI.METER);
   }
   
   public Cartesian(double x, double y, double z, Unit<Length> unit) {
      geocentric = XYZ.valueOf(x, y, z, unit);
      this.unit = unit;
   }
   
   public XYZ getValue() {
      return geocentric;
   }
   
   public Altitude getAltitude() {
      if(altitude == null) {
         altitude = altitudeConverter.convert(geocentric);
      }
      return altitude;
   }
   
   public void setAltitude(double alt, Unit<Length> unit) {
      altitude = Altitude.valueOf(alt, unit);
   }
   
   public LatLong getLatLon() {
      if(latLon == null) {
         latLon = latLonConverter.convert(geocentric);
      }
      return latLon;
   }
   
   public void setLatLon(double lat, double lon, Unit<Angle> unit) {
      latLon = LatLong.valueOf(lat, lon, unit);
   }
   
   public Cartesian withAltitude(double alt, Unit<Length> unit) {
      setAltitude(alt, unit);
      return this;
   }
   
   public Cartesian withAltitude(Altitude altitude) {
      this.altitude = altitude;
      return this;
   }
   
   public Cartesian withLatLon(double lat, double lon, Unit<Angle> unit) {
      setLatLon(lat, lon, unit);
      return this;
   }
   
   public Cartesian withLatLon(LatLong latLon) {
      this.latLon = latLon;
      return this;
   }
   
   public Cartesian withCartesian(double x, double y, double z, Unit<Length> unit) {
      geocentric = XYZ.valueOf(x, y, z, unit);
      this.unit = unit;
      return this;
   }
   
   public Cartesian withCartesian(double x, double y, double z) {
      geocentric = XYZ.valueOf(x, y, z, unit);
      return this;
   }
}
