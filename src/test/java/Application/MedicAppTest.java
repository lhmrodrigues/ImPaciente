package Application;

import Domain.Model.Users.Medic;
import Infra.Repositories.MedicRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MedicAppTest {

    @Mock
    private MedicRepository mockMedicRepository;

    @InjectMocks
    private MedicApp medicApp;

    private Medic medicDefault;

    @BeforeAll
    public void init(){
        medicApp = new MedicApp();

        medicDefault = new Medic();
        medicDefault.setName("Gabriel Lara");
        medicDefault.setCpfCrm("43521");
        medicDefault.setPassword("mockPassword");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginMedicSuccess() throws Exception {
        //ARRANGE
        Medic medic = new Medic();
        medic.setName("Gabriel Lara");
        medic.setCpfCrm("43521");
        medic.setPassword("mockPassword");
        when(mockMedicRepository.medicByCRM("43521")).thenReturn(medic);

        //ACT
        Medic loggedMedic = medicApp.medicLogin(medic);

        //ASSERT
        assertEquals(medic,loggedMedic);
    }

    @Test
    public void loginMedicNotExist() throws Exception {
        //ARRANGE
        Medic medic = new Medic();
        medic.setName("Gabriel Lara");
        medic.setCpfCrm("112233");
        medic.setPassword("mockPassword");

        when(mockMedicRepository.medicByCRM("112233")).thenReturn(null);

        //ACT AND ASSERT
        Assertions.assertThrows(Exception.class, () -> medicApp.medicLogin(medic));
    }

    @Test
    public void loginMedicWrongPassword() throws Exception {
        //ARRANGE
        Medic medic = new Medic();
        medic.setName("Gabriel Lara");
        medic.setCpfCrm("112233");
        medic.setPassword("Password");

        when(mockMedicRepository.medicByCRM("112233")).thenReturn(medicDefault);

        //ACT AND ASSERT
        Assertions.assertThrows(Exception.class, () -> medicApp.medicLogin(medic));
    }

    @Test
    public void addMedic() throws Exception {
        //ARRANGE
        Medic medic = new Medic();
        medic.setName("Gabriel Lara");
        medic.setCpfCrm("112233");
        medic.setPassword("mockPassword");

        when(mockMedicRepository.medicByCRM("112233")).thenReturn(null);

        //ACT AND ASSERT
        medicApp.add(medic);
    }

    @Test
    public void addMedicWithRepeatCRM() throws Exception{
        //ARRANGE
        Medic medic = new Medic();
        medic.setName("Gabriel Lara");
        medic.setCpfCrm("112233");
        medic.setPassword("mockPassword");

        when(mockMedicRepository.medicByCRM("112233")).thenReturn(medic);

        //ACT AND ASSERT
        Assertions.assertThrows(Exception.class, () -> medicApp.add(medic));
    }

}
