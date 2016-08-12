package controllers;

import models.User;
import play.data.*;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;

import static play.data.Form.form;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result getUser() {
        return ok(user.render(form(User.class)));
    }

    public Result createUser() {
        Form<User> formData = formFactory.form(User.class).bindFromRequest();
        User user = formData.get();

        String email = user.getEmail();
        String password = user.getPassword();
        return ok("Hello " + email + " with password: " + password);
    }

}
