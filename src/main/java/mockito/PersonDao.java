package mockito;

import java.util.List;

public interface PersonDao
{
    public Person fetchPerson( Integer personID );
    public void update( Person person );
} 