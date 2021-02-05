package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {


  @Test
  public void testMyIp() {

    String location = new GeoIPService().getGeoIPServiceSoap().getLocation();
    System.out.println(location);
    assertEquals(location, "<GeoIP><Country>RU</Country><State>37</State></GeoIP>");
  }

 /* @Test
  public void testInvalidIp() {

    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("90.154.73.xxx");
    System.out.println(ipLocation);
    assertEquals(ipLocation, "<GeoIP><Country>RU</Country><State>48</State></GeoIP>");
  }
*/
}