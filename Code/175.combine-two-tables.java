select FirstName, LastName, City, State
from Person LEFT JOIN Address 
on Person.PersonId = Address.PersonId