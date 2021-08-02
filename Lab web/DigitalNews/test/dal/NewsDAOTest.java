/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import modal.News;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class NewsDAOTest {

    public NewsDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLastNews method, of class NewsDAO.
     */
    //normalCase
    @Test
    public void testGetLastNewsID() {
        System.out.println("getLastNewsID");
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        int idExpResult = 26;
        News result = instance.getLastNews();
        int idResult = result.getId();
        assertEquals(idExpResult, idResult);
        // TODO review the generated test code and remove the default call to fail.       
    }

    //normalCase
    @Test
    public void testGetLastNewsTitle() {
        System.out.println("getLastNewsTitle");
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        String titleExpResult = "tortor. Nunc commodo auctor velit. Aliquam nisl. N";
        News result = instance.getLastNews();
        String titleResult = result.getTitle();
        assertEquals(titleExpResult, titleResult);
        // TODO review the generated test code and remove the default call to fail.       
    }
    //normalCase

    @Test
    public void testGetLastNewsTitleWritter() {
        System.out.println("getLastNewsWritter");
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        String ParamExpResult = "Neve";
        News result = instance.getLastNews();
        String ParamResult = result.getWritter();
        assertEquals(ParamExpResult, ParamResult);
        // TODO review the generated test code and remove the default call to fail.       
    }

    /**
     * Test of getTop5 method, of class NewsDAO.
     */
    //normalCase
    @Test
    public void testGetTop5a() {
        System.out.println("getTop5Count");
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.getTop5();
        int count = result.size();
        int expCount = 5;
        assertEquals(count, expCount);
        // TODO review the generated test code and remove the default call to fail.
    }
//Boundary case

    @Test
    public void testGetTop5b() {
        System.out.println("getTop5FirstID");
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.getTop5();
        int idExpResult = 38;
        int arr = 0;
        int idResult = result.get(arr).getId();
        assertEquals(idResult, idExpResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    //Boundary case

    @Test
    public void testGetTop5d() {
        System.out.println("getTop5FirstID");
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.getTop5();
        int arr = 4;
        int idExpResult = 5;
        int idResult = result.get(arr).getId();
        assertEquals(idResult, idExpResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    //normalCase
    @Test
    public void testGetTop5c() {
        System.out.println("getTop5FirstID");
        NewsDAO instance = new NewsDAO();
        int arr = 1;
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.getTop5();
        int idExpResult = 94;
        int idResult = result.get(arr).getId();
        assertEquals(idResult, idExpResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNewsByID method, of class NewsDAO.
     */
    @Test //Abnormal Case
    public void testGetNewsByID() {
        System.out.println("getNewsByID");
        int id = 0;
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        News result = instance.getNewsByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test //Abnormal Case
    public void testGetNewsByID1() {
        System.out.println("getNewsByID");
        int id = -45;
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        News result = instance.getNewsByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test //normalCase 
    public void testGetNewsByID2() {
        System.out.println("getNewsByID");
        int id = 2;
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        News result = instance.getNewsByID(id);
        int idExp = result.getId();
        assertEquals(idExp, id);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test //normalCase 
    public void testGetNewsByID3() {
        System.out.println("getNewsByID");
        int id = 2;
        NewsDAO instance = new NewsDAO();
        News expResult = null;
        News result = instance.getNewsByID(id);
        String titleExp = result.getTitle();
        String titleResult = "sollicitudin orci sem eget massa. Suspendisse";
        assertEquals(titleExp, titleResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of searchByPaging method, of class NewsDAO.
     */
    @Test //normalCase 
    public void testSearchByPaging() {
        System.out.println("searchByPaging");
        int index = 1;
        int size = 4;
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 4;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test //normalCase 
    public void testSearchByPaging2() {
        System.out.println("searchByPaging");
        int index = 2;
        int size = 4;
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 4;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test//Abnormal Case
    public void testSearchByPaging1() {
        System.out.println("searchByPaging");
        int index = 100000;
        int size = 4;
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 0;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test//Abnormal Case
    public void testSearchByPaging3() {
        System.out.println("searchByPaging");
        int index = 4;
        int size = 4;
        String txt = "adsfasdfs";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 0;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test//Abnormal Case
    public void testSearchByPaging4() {
        System.out.println("searchByPaging");
        int index = 4;
        int size = 4;
        String txt = "   ";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 0;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }
 @Test
    public void testSearchByPaging41() {
        System.out.println("searchByPaging");
        int index = 4;
        int size = 4;
        String txt = " ";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 4;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test   //Boundary case
    public void testSearchByPaging5() {
        System.out.println("searchByPaging");
        int index = 0;
        int size = 4;
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 0;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test   //Boundary case
    public void testSearchByPaging6() {
        System.out.println("searchByPaging");
        int index = 9;
        int size = 10;
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 10;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test   //Abnormal case
    public void testSearchByPaging7() {
        System.out.println("searchByPaging");
        int index = 10;
        int size = 10;
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 3;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test   //Abnormal case
    public void testSearchByPaging10() {
        System.out.println("searchByPaging");
        int index = 10;
        int size = 10;
        String txt = "a              ";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 3;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    @Test   //Abnormal case
    public void testSearchByPaging8() {
        System.out.println("searchByPaging");
        int index = 10;
        int size = 5;
        String txt = "b";
        NewsDAO instance = new NewsDAO();
        ArrayList<News> expResult = null;
        ArrayList<News> result = instance.searchByPaging(index, size, txt);
        int count = 0;
        assertEquals(count, result.size());
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of countSearch method, of class NewsDAO.
     */
    @Test//Abnormal Case
    public void testCountSearch() {
        System.out.println("countSearch");
        String txt = "     ";
        NewsDAO instance = new NewsDAO();
        int expResult = 0;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test//Abnormal Case
    public void testCountSearch1() {
        System.out.println("countSearch");
        String txt = "asdsahodijasio";
        NewsDAO instance = new NewsDAO();
        int expResult = 0;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test//Abnormal Case
    public void testCountSearch2() {
        System.out.println("countSearch");
        String txt = "a";
        NewsDAO instance = new NewsDAO();
        int expResult = 93;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test//Abnormal Case
    public void testCountSearch3() {
        System.out.println("countSearch");
        String txt = "134";
        NewsDAO instance = new NewsDAO();
        int expResult = 0;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test//Abnormal Case
    public void testCountSearch4() {
        System.out.println("countSearch");
        String txt = ".;'.;.";
        NewsDAO instance = new NewsDAO();
        int expResult = 0;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test//Abnormal Case
    public void testCountSearch9() {
        System.out.println("countSearch");
        String txt = ".;'.;.          ";
        NewsDAO instance = new NewsDAO();
        int expResult = 0;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    //normalCase
    @Test
    public void testCountSearch5() {
        System.out.println("countSearch");
        String txt = "c";
        NewsDAO instance = new NewsDAO();
        int expResult = 80;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    //normalCase

    @Test
    public void testCountSearch6() {
        System.out.println("countSearch");
        String txt = "b";
        NewsDAO instance = new NewsDAO();
        int expResult = 30;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    //Abnormal Case

    @Test
    public void testCountSearch7() {
        System.out.println("countSearch");
        String txt = "b       ";
        NewsDAO instance = new NewsDAO();
        int expResult = 30;
        int result = instance.countSearch(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
}
