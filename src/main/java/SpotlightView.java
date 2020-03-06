import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.impl.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@RequestScoped
public class SpotlightView implements Serializable {

    @Inject
    private UserService userService;

    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String occupation;

    public String save() {
        userService.addUser(firstName, lastName, dob, email, occupation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've registered"));
        setFirstName(null);
        setEmail(null);
        return "/hello.xhtml?faces-redirect=true";
    }
}