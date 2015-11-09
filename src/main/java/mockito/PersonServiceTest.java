package mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;




public class PersonServiceTest
{
	@Mock
	private PersonDao personDAO;
	
	@InjectMocks
	private PersonService personService=new PersonService( );

	@Before
	public void setUp()
			throws Exception
	{
		MockitoAnnotations.initMocks( this );
	}

	@Test
	public void shouldUpdatePersonName()
	{
		Person person1 = new Person( 1, "Phillip" );

		when( personDAO.fetchPerson( 1 ) ).thenReturn( person1 );

		boolean  updated;

		updated =personService.update( 1, "David" );

		assertTrue(updated);


		verify( personDAO).fetchPerson( 1 );

		ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass( Person.class );
		verify( personDAO ).update( personCaptor.capture() );
		Person updatedPerson = personCaptor.getValue();
		assertEquals( "David", updatedPerson.getPersonName() );

	}
	//    @Test
	//    public void shouldNotUpdateIfPersonNotFound()
	//    {

	//    }
} 
