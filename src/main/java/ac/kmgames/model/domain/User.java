package ac.kmgames.model.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
class User {
    private long id;
    private String email;
    private String password;
    private String name;
    private String nicname;
    private long cash;
    private Timestamp date;
    private boolean ban;
}
