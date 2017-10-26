package rest.stubdb;

import lombok.Getter;
import rest.dto.entities.UserDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserStubDB
{
    @Getter
    private static Map<Long, UserDTO> users = new HashMap<>();
    private static DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");

    static {
        try {
            add(1L, "Taner",   "Yilmaz",   dateFormatter.parse("12/03/1986"));
            add(2L, "Ibrahim", "Yaniklar", dateFormatter.parse("04/11/1985"));
            add(3L, "Sinan",   "Eski",     dateFormatter.parse("23/06/1985"));
            add(4L, "Taha",    "Erkan",    dateFormatter.parse("19/07/1986"));
            add(5L, "Yusuf",   "Kurt",     dateFormatter.parse("10/12/1990"));
            add(6L, "Bekir",   "Sezgin",   dateFormatter.parse("03/06/1988"));
        } catch (Exception e) {

        }
    }

    private synchronized static void add(Long id, String firstName, String lastName, Date dateOfBirth)
    {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDateOfBirth(dateOfBirth);

        add(dto);
    }

    public synchronized static UserDTO add(UserDTO dto)
    {
        return users.put(dto.getId(), dto);
    }

    public synchronized static UserDTO remove(Long id)
    {
        return users.remove(id);
    }

    public static UserDTO get(Long id)
    {
        return users.get(id);
    }

    public static List<UserDTO> get()
    {
        return new ArrayList<>(users.values());
    }
}
