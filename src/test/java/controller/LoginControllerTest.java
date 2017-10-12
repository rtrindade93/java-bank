package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.AuthService;
import view.View;

import static org.mockito.ArgumentMatchers.anyInt;

public class LoginControllerTest {

    private LoginController loginController;
    private View view;
    private Controller controller;
    private AuthService authService;

    @Before
    public void setup() {
        loginController = new LoginController();

        view = Mockito.mock(View.class);
        loginController.setView(view);

        controller = Mockito.mock(Controller.class);
        loginController.setNextController(controller);

        authService = Mockito.mock(AuthService.class);
        loginController.setAuthService(authService);
    }

    @Test
    public void initTest() {
        loginController.init();

        Mockito.verify(view).show();
    }

    @Test
    public void onLoginTest() {
        int fakeId = 1246357;

        Mockito.when(authService.authenticate(fakeId)).thenReturn(true);
        loginController.onLogin(fakeId);

        Mockito.verify(authService).authenticate(fakeId);
        Mockito.verify(controller).init();
        Mockito.verify(view, Mockito.never()).show();
    }

    @Test
    public void onLoginTestFail() {
        int fakeId = 1246357;

        Mockito.when(authService.authenticate(anyInt())).thenReturn(false);
        loginController.onLogin(fakeId);

        Mockito.verify(view).show();
        Mockito.verify(controller, Mockito.never()).init();
    }
}
