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
    private boolean ban;
    private long cash;
    private String email;
    private String name;
    private String nickname;
    private String password;
    private String register_date;
    private String created_date_time;
    private String modified_date_time;
}
