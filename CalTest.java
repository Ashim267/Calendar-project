// File name: 
// Author:
// VUnetid: 
// Email: 
// Class: CS2201
// Date: 
// Honor statement:
// Assignment Number: 
// Description: 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalTest {

    @Test
    public void testDefaultConstructor1() {
        Calendar cal1 = new Calendar();
        assertTrue(cal1.isEmpty());
    }

    @Test
    public void testDefaultConstructor2() {
        Calendar cal1 = new Calendar();
        assertEquals(0, cal1.getNumRem());
    }

    @Test
    public void testDefaultConstructor3() {
        Calendar cal1 = new Calendar();
        assertEquals("", cal1.toString());
    }
    
    @Test
    public void testToString_Format() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/1/2024"), "Happy");
        Reminder rem4 = new Reminder(new Date("1/8/2024"), "First");
        Reminder rem5 = new Reminder(new Date("1/1/2023"), "Happy New");
        Reminder rem6 = new Reminder(new Date("1/8/2025"), "First day of classes");
        Reminder rem7 = new Reminder(new Date("1/2/2023"), "Happy New");
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        cal.addRem(rem6);
        cal.addRem(rem7);
        assertEquals("On 01/01/2023: Happy New\nOn 01/02/2023: Happy New\nOn 01/01/2024: Happy\nOn 01/01/2024: Happy New Year\nOn 01/08/2024: First\nOn 01/08/2024: First day of classes\nOn 01/08/2025: First day of classes\n", cal.toString());
    }

    //TODO -- it is your job to fully test the Calendar class

    @Test
    public void testToString() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals("On 01/10/2023: First\nOn 01/10/2023: First day of classes\nOn 01/01/2024: Happy New Year\nOn 01/08/2024: First day of classes\nOn 01/10/2024: First day of classes\n", cal.toString());
        Calendar cal1 = new Calendar();
        assertEquals("",cal1.toString());
    }

    @Test
    public void testGetNum() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        assertEquals(0, cal.getNumRem());
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals(5, cal.getNumRem());
    }

    @Test
    public void testGetRem() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        assertThrows(IllegalArgumentException.class, () -> cal.getRem(1));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertThrows(IllegalArgumentException.class, () -> cal.getRem(100));
        assertThrows(IllegalArgumentException.class, () -> cal.getRem(-20));
        assertEquals("On 01/08/2024: First day of classes", cal.getRem(3).toString());
    }

    @Test
    public void testcount() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        String fir ="1/1/2024";
        Date first = new Date(fir) ;
        assertEquals(0, cal.count(first));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals(1, cal.count(first));
        String fir1 ="1/10/2023";
        Date first1 = new Date(fir1) ;
        assertEquals(2, cal.count(first1));
        String fir2 ="1/10/20";
        Date first2 = new Date(fir2) ;
        assertEquals(0, cal.count(first2));

    }

    @Test
    public void testfindrem() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        String fir ="1/1/2024";
        Date first = new Date(fir) ;
        assertEquals(-1, cal.findRem(first));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals(2, cal.findRem(first));
        String fir1 ="1/10/2023";
        Date first1 = new Date(fir1) ;
        assertEquals(0, cal.findRem(first1));
        String fir2 ="1/10/20";
        Date first2 = new Date(fir2) ;
        assertEquals(-1, cal.findRem(first2));

    }

    @Test
    public void testfindremstring() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        assertEquals(-1, cal.findRem("Happy New Year"));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals(1, cal.findRem("First day of classes"));
        assertEquals(0, cal.findRem("First"));
        assertEquals(-1, cal.findRem("wahhha"));
    }

    @Test
    public void testfindremstringind() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        assertEquals("", cal.toString("Happy New Year"));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals("On 01/10/2023: First day of classes", cal.toString(1));
        assertEquals("On 01/10/2023: First", cal.toString(0));
        assertEquals("", cal.toString(100));
        assertEquals("", cal.toString(-100));
    }

    @Test
    public void testtoStringALL() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        assertEquals("", cal.toString("First"));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals("On 01/10/2023: First day of classes\nOn 01/08/2024: First day of classes\nOn 01/10/2024: First day of classes\n", cal.toString("First day of classes"));
        assertEquals("On 01/10/2023: First\n", cal.toString("First"));
        assertEquals("", cal.toString("wahhha"));
    }

    @Test
    public void testtostringDate() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        String fir = "1/1/2024";
        Date first = new Date(fir);
        assertEquals("", cal.toString(first));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals("On 01/01/2024: Happy New Year\n", cal.toString(first));
        String fir1 = "1/10/2023";
        Date first1 = new Date(fir1);
        assertEquals("On 01/10/2023: First\nOn 01/10/2023: First day of classes\n", cal.toString(first1));
        String fir2 = "1/10/20";
        Date first2 = new Date(fir2);
        assertEquals("", cal.toString(first2));
    }

    @Test
    public void testtostringDateTwoDates() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        String fir ="1/1/2024";
        Date first = new Date(fir) ;
        String fir1 ="1/10/2023";
        Date first1 = new Date(fir1) ;
        assertEquals("", cal.toString(first,first1));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        String finalist ="1/10/2024";
        Date finalista = new Date(finalist) ;
        assertEquals("On 01/10/2023: First\nOn 01/10/2023: First day of classes\nOn 01/01/2024: Happy New Year\nOn 01/08/2024: First day of classes\nOn 01/10/2024: First day of classes\n", cal.toString(first1,finalista));
        String fir2 ="1/10/20";
        Date first2 = new Date(fir2) ;
    }

    @Test
    public void testT0equals() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);

        Calendar cal1 = new Calendar();
        Reminder remt1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder remt2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder remt3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder remt4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder remt5 = new Reminder(new Date("1/10/2023"), "First");
        cal1.addRem(remt1);
        cal1.addRem(remt2);
        cal1.addRem(remt3);
        cal1.addRem(remt4);
        cal1.addRem(remt5);

        Calendar cal2 = new Calendar();
        cal2.addRem(remt1);
        cal2.addRem(remt2);
        cal2.addRem(remt3);

        Calendar cal3 = new Calendar();
        cal3.addRem(remt1);
        cal3.addRem(remt2);
        cal3.addRem(remt3);
        cal3.addRem(remt5);
        cal3.addRem(remt4);


        assertEquals(true, cal.equals(cal1));
        assertFalse(cal.equals(cal2));
        assertFalse(cal.equals(cal3));
    }

    @Test
    public void testaddRem() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        Reminder rem6 = new Reminder(new Date("1/5/2024"), "First");
        assertEquals(0, cal.addRem(rem2));
        assertEquals(0, cal.addRem(rem2));
        assertEquals(2, cal.addRem(rem3));
        assertEquals(0, cal.addRem(rem4));
        assertEquals(0, cal.addRem(rem5));
        assertEquals(2, cal.addRem(rem1));
        assertEquals(3, cal.addRem(rem6));
    }

    @Test
    public void testdeleteremmm() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        Reminder rem6 = new Reminder(new Date("1/10/2025"), "First");
        Reminder rem7 = new Reminder(new Date("1/10/2025"), "First");
        assertEquals(0, cal.deleteRem());
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        cal.addRem(rem6);
        cal.addRem(rem7);
        assertEquals(5, cal.deleteRem());
    }

    @Test
    public void testdeleteremindex() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        Reminder rem6 = new Reminder(new Date("1/10/2025"), "First");
        assertEquals(0, cal.deleteRem(3));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        cal.addRem(rem6);
        assertEquals(1, cal.deleteRem(0));
        assertEquals(1, cal.deleteRem(4));
        assertEquals(0, cal.deleteRem(4));
        assertEquals(0, cal.deleteRem(-200));
        assertEquals(0, cal.deleteRem(200));
        Calendar cal2 = new Calendar();
        assertEquals(0, cal2.deleteRem(20));
    }

    @Test
    public void testdeleteremstring() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        Reminder rem6 = new Reminder(new Date("1/10/2025"), "First");
        assertEquals(0, cal.deleteRem("First"));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        cal.addRem(rem6);
        assertEquals(2, cal.deleteRem("First"));
        assertEquals(0, cal.deleteRem("Harry"));
        Calendar cal2 = new Calendar();
        assertEquals(0, cal2.deleteRem("walala"));
    }

    @Test
    public void testdeleteremindermatching() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        Reminder rem6 = new Reminder(new Date("1/10/2025"), "First");
        Reminder remtest11 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        assertEquals(0, cal.deleteRem(remtest11));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        cal.addRem(rem6);
        Reminder remtest122 = new Reminder(new Date("1/1/2111"), "Happy New Year");
        assertEquals(1, cal.deleteRem(remtest11));
        assertEquals(0, cal.deleteRem(remtest122));
        Calendar cal2 = new Calendar();
        assertEquals(0, cal2.deleteRem(remtest11));
    }

    @Test
    public void testdeleterDate() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        Date datest = new Date(1,10,2023);
        Date datest1 = new Date(1,10,2115);
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        assertEquals(2, cal.deleteRem(datest));
        assertEquals(0, cal.deleteRem(datest1));
        Calendar cal2 = new Calendar();
        assertEquals(0, cal2.deleteRem(datest1));
    }

    @Test
    public void testdeleterDatebetween() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        String fir ="1/1/2024";
        Date first = new Date(fir) ;
        String fir1 ="1/10/2023";
        Date first1 = new Date(fir1) ;
        assertEquals(0, cal.deleteRem(first,first1));
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        String finalist ="12/10/2023";
        Date finalista = new Date(finalist) ;
        assertEquals(2, cal.deleteRem(first1,finalista));

    }

    @Test
    public void testCLoningg() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem5 = new Reminder(new Date("1/10/2023"), "First");
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem5);
        Calendar clone1 = cal.clone();
        assertEquals(clone1,cal);
    }

    @Test
    public void testMergeCal() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date("1/1/2024"), "Happy New Year");
        Reminder rem2 = new Reminder(new Date("1/8/2024"), "First day of classes");
        Reminder rem3 = new Reminder(new Date("1/10/2024"), "First day of classes");
        Reminder rem4 = new Reminder(new Date("1/10/2023"), "First day of classes");
        Reminder rem6 = new Reminder(new Date("1/8/2024"), "First1234");
        cal.addRem(rem1);
        cal.addRem(rem2);
        cal.addRem(rem3);
        cal.addRem(rem4);
        cal.addRem(rem6);
        Calendar cal1 = new Calendar();
        cal1.addRem(rem1);
        cal1.addRem(rem2);
        Calendar cal2 = new Calendar();
        cal2.addRem(rem3);
        cal2.addRem(rem4);
        cal2.addRem(rem6);
        cal1.mergeCal(cal2);
        assertEquals(cal.toString(),cal1.toString());
        assertTrue(cal.equals(cal1));

        Calendar calA = new Calendar();
        Calendar calB = new Calendar();
        calB.addRem(rem1);
        calB.addRem(rem3);
        calB.addRem(rem4);
        calB.addRem(rem6);
        calB.addRem(rem2);
        calA.mergeCal(calB);
        assertTrue(cal.equals(calA));

    }

}
