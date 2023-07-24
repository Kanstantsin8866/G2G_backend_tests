package Tests.API_DB_tests;

public class USERS {
    private Long id;
    private String firstname;
    private String lastname;
    private String emailName;


    public USERS(Long id, String firstname, String lastname, String emailName) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailName = emailName;
    }

    public USERS() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String emailName) {
        this.emailName = emailName;
    }

    public String getEmailName() {
        return emailName;
    }

    @Override
    public String toString() {
        return "Users " +
                "id: " + id +
                ",firstname:" + firstname +
                ", lastname:" + lastname +
                ", emailName: " + emailName;
    }

}







