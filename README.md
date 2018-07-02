# Backend Exercise
This is an exercise required for a job application.

## Rationale

The solution consists basically on an implementation of  the ***Composite Pattern***,  since the Family Rental promotion is no more no less than a composition of 3 to 5 rentals in which they will have a discount of 30% on the total price.

On top of this pattern, variants for extensibility and adaptability must be applied; in this case the use of an ***abstract class*** to define an atomic rental is the strategy of choice. This gives a way to ***decouple the business logic asociated with the costs and rental types***, delegating the responsability of knowing the cost and way to treat that cost in different ways, if needed, to the ***concret classes*** that extends from it.

## Howto run tests

Have in mind that the code was developed under Eclipse Photon, with JUnit 5 and OpenJDK 10; it shouldn't matter but, knowing the headaches that Java may produce, it's never a bad idea to point out under which environment conditions a product was developed.

Just to keep it simple and environment agnostic, only the source files where pushed to the repository, no IDE metadata is included. Because of that, you will have to create a new Eclipse project, and while defining the build settings (second form, where you can select the source code folder) remove the default src directory and click "Link additional source" and then select the ```src/``` directory in the cloned repository, probably you will have to choose another name for the directory, since it's already taken by the default one.

Once you have selected the source directory, click the ```Libraries``` tab and click on the ```Add Library...``` button, then add the JUnit library, and select JUnit 5 in the next dialog.

Now that you have open the project with Eclipse IDE, right click on the project root folder, on the package explorer. Go to ```Coverage as ...``` and then ```JUnit Test```. Eclipse will automatically look for all the test cases and execute them.

> Test coverage 96,8%
