package kata6;

public class Person {
    private final Integer id;

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
    private final String mail;

    public Person(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }
    
}
