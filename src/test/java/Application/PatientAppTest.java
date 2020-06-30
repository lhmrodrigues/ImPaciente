package Application;

import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import Infra.Repositories.PatientRepository;
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
public class PatientAppTest {

    @Mock
    private PatientRepository mockPatientRepository;

    @InjectMocks
    private PatientApp patientApp;

    private Patient patientDefault;

    @BeforeAll
    public void init(){
        patientApp = new PatientApp();
        patientDefault = new Patient();
        patientDefault.setName("Gabriel Lara");
        patientDefault.setCpfCrm("43521");
        patientDefault.setPassword("mockPassword");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginPatientSuccess() throws Exception {
        //ARRANGE
        Patient patient = new Patient();
        patient.setName("Gabriel Lara");
        patient.setCpfCrm("12345678900");
        patient.setPassword("mockPassword");

        when(mockPatientRepository.patientByCPF("12345678900")).thenReturn(patient);

        //ACT
        Patient loggedPatient = patientApp.patientLogin(patient);

        //ASSERT
        assertEquals(patient,loggedPatient);
    }

    @Test
    public void loginPatientWrongPassword() throws Exception {
        //ARRANGE
        Patient patient = new Patient();
        patient.setName("Gabriel Lara");
        patient.setCpfCrm("12345678900");
        patient.setPassword("Password");

        when(mockPatientRepository.patientByCPF("12345678900")).thenReturn(patient);

        //ACT AND ASSERT
        Assertions.assertThrows(Exception.class, () -> patientApp.patientLogin(patientDefault));
    }

    @Test
    public void loginPatientNotExist() throws Exception {
        //ARRANGE
        Patient patient = new Patient();
        patient.setName("Gabriel Lara");
        patient.setCpfCrm("12345678900");
        patient.setPassword("mockPassword");

        when(mockPatientRepository.patientByCPF("12345678900")).thenReturn(null);

        //ACT AND ASSERT
        Assertions.assertThrows(Exception.class, () -> patientApp.patientLogin(patient));
    }

    @Test
    public void getCPFPatientSucess() throws Exception {
        //ARRANGE
        Patient patient = new Patient();
        patient.setName("Gabriel Lara");
        patient.setCpfCrm("12345678900");
        patient.setPassword("mockPassword");

        when(mockPatientRepository.patientByCPF("12345678900")).thenReturn(patient);

        //ACT
        Patient loggedPatient = patientApp.patientLogin(patient);

        //ASSERT
        assertEquals(patient,loggedPatient);
    }
}
