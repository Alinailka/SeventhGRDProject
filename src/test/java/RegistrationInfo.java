import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegistrationInfo {
    private final String address;
    private final String name;
    private final String phone;
    private final String date1;
    private final String date2;
}

