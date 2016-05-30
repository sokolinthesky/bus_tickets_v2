/*package ua.busstation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.busstation.core.route.Route;
import ua.busstation.core.route.RouteManager;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {

    @Autowired
    private RouteManager manager;

    @Test
    public void RouteGetAllTest() {
        List<Route> models =  manager.allRouts();

        Route one = models.get(0);
        Route two = models.get(1);

        System.out.println(one.getBusByNumber("747"));
        System.out.println(one.getBusByNumber("748"));

    }

    @Test
    @Transactional
        public void findByNameTest() {
    }

    @Test
    public void editTest() {
    }

    @Test
    public void createTest() {

    }

    @Test
    public void sizeTest() {
    }

    @Test
    public void deleteTest() {

    }

}*/
