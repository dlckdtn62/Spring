package kr.co.fastcampus.cli;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Member {
    private int id;
    @NonNull private String username;
    @NonNull  private String password;

    public Member(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//delombok으로 변경되는 것도 볼 수 있다.
//@NonNull ~> @required..