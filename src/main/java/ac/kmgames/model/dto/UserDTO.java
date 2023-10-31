package ac.kmgames.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private long cash;
    private Timestamp register_date;
    private boolean ban;
}
