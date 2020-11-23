import dsa.minimo1.Covid19ManagerImpl;
import dsa.minimo1.Covid19Manager;
import dsa.minimo1.models.Persona;
import dsa.minimo1.models.Muestra;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;


public class TestPCR {

    Covid19Manager manager;
    Persona persona;
    List<Muestra> muestras;
    private static Logger logger = Logger.getLogger(TestPCR.class);

    @Before
    public void setUp() throws Exception{
        manager = Covid19ManagerImpl.getInstance();
        muestras = new LinkedList<Muestra>();
        persona = new Persona("1","Pepe","Palotes",45,"A");
    }

    @After
    public void TearDown() throws Exception{
        manager=null;
    }

    @Test
    public void testCrearPersona() throws Exception {

        manager.addPerson2("1", persona);

        Assert.assertEquals(manager.mostrarPersonas().get("1"),persona);
    }
    @Test
    public void testProcesarMuestra() throws Exception{

        manager.addPerson2("1", persona);
        Muestra muestraAnalizada = manager.procesarMuestra("LaboratorioDSA");
        Assert.assertEquals(muestraAnalizada.getEstado(),"Positivo");


    }
}
